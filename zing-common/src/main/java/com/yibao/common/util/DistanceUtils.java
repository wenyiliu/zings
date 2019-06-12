package com.yibao.common.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yibao.common.entity.LabeledPoint;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author liuwenyi
 * @date 2019/6/6 14:32
 */
@Slf4j
public class DistanceUtils {

    /**
     * Z-score converts two or more sets of data into an ununitary z-score,
     * unifies data standards, improves data comparability,
     * and weakens data interpretation.
     * @param labeledPoints
     * @return List
     */
    private static List<LabeledPoint> zScore(List<LabeledPoint> labeledPoints) {
        if (labeledPoints.isEmpty()) {
            log.error("the data normalized list cannot be empty");
            return Collections.emptyList();
        }
        List<LabeledPoint> labeledPointList = Lists.newArrayList();
        Integer max = labeledPoints.stream().map(labeledPoint -> labeledPoint.getData().length)
                .max(Integer::compareTo).get();
        Map<Integer, List<Double>> meanDeviationMap = Maps.newHashMap();
        for (int i = 0; i < max; i++) {
            double[] d = new double[labeledPoints.size()];
            for (int j = 0; j < labeledPoints.size(); j++) {
                double[] data = labeledPoints.get(j).getData();
                if (data.length >= i) {
                    d[j] = labeledPoints.get(j).getData()[i];
                }
            }
            List<Double> meanDeviationList = Lists.newArrayList();
            Mean mean = new Mean();
            double dMean = mean.evaluate(d);
            StandardDeviation standardDeviation = new StandardDeviation();
            double deviation = standardDeviation.evaluate(d);
            if (deviation == 0) {
                log.info("标准差为零，取默认值1");
                deviation = 1;
            }
            meanDeviationList.add(dMean);
            meanDeviationList.add(deviation);
            meanDeviationMap.put(i, meanDeviationList);
        }
        labeledPoints.forEach(data -> {
            LabeledPoint labeledPoint = new LabeledPoint();
            labeledPoint.setLabel(data.getLabel());
            double[] d = data.getData();
            double[] unification = new double[d.length];
            for (int i = 0; i < d.length; i++) {
                List<Double> list = meanDeviationMap.get(i);
                unification[i] = (d[i] - list.get(0)) / list.get(1);
            }
            labeledPoint.setData(unification);
            labeledPointList.add(labeledPoint);
        });
        if (labeledPointList.isEmpty()) {
            log.error("归一化后数据为空");
            return Collections.emptyList();
        }
        return labeledPointList;
    }

    /**
     * 计算欧式距离
     *
     * @param list   历史数据
     * @param target 目标数据
     * @param b      true 数据归一化 false 数据不归一
     * @return
     */
    private static Map<Integer, Double> euclideanDistance(List<LabeledPoint> list, LabeledPoint target, Boolean b) {
        if (list.isEmpty()) {
            log.error("历史数据为空，跳过计算欧式距离");
            return Collections.emptyMap();
        }
        List<LabeledPoint> labeledPointList;
        if (b) {
            list.add(target);
            List<LabeledPoint> labeledPointListZScore = zScore(list);
            for (LabeledPoint labeledPoint : labeledPointListZScore) {
                if (labeledPoint.getLabel().equals(target.getLabel())) {
                    target = labeledPoint;
                }
            }
            labeledPointListZScore.remove(target);
            labeledPointList = labeledPointListZScore;
        } else {
            labeledPointList = list;
        }
        double[] targetData = target.getData();
        Map<Integer, Double> similarityMap = Maps.newHashMap();
        labeledPointList.forEach(labeledPoint -> {
            double[] labeledPointData = labeledPoint.getData();
            Integer label = labeledPoint.getLabel();
            Double similarity;
            if (targetData.length != labeledPointData.length) {
                log.error("目标数据长度为{}，标签为{}的数据长度为{}，长度不同，相似度取0", targetData.length,
                        label, labeledPointData.length);
                similarity = 0.0;
            } else {
                Double d = 0.0;
                for (int i = 0; i < labeledPointData.length; i++) {
                    d += Math.pow(targetData[i] - labeledPointData[i], 2);
                }
                similarity = 1 / (1 + Math.sqrt(d));
            }
            similarityMap.put(label, similarity);
        });
        return similarityMap;
    }

    public static void main(String[] args) {
        List<LabeledPoint> labeledPointList = Lists.newArrayList();
        LabeledPoint labeledPoint = new LabeledPoint();
        labeledPoint.setLabel(1);
        double[] d = new double[]{1, 2, 3, 4, 5};
        labeledPoint.setData(d);
        labeledPointList.add(labeledPoint);
        LabeledPoint labeledPoint1 = new LabeledPoint();
        labeledPoint1.setLabel(2);
        double[] d1 = new double[]{1, 3, 3, 4, 5};
        labeledPoint1.setData(d1);
        labeledPointList.add(labeledPoint1);

        LabeledPoint labeledPoint2 = new LabeledPoint();
        labeledPoint2.setLabel(3);
        double[] d2 = new double[]{2, 3, 1, 4, 2};
        labeledPoint2.setData(d2);
        labeledPointList.add(labeledPoint2);

        LabeledPoint labeledPoint3 = new LabeledPoint();
        labeledPoint3.setLabel(4);
        double[] d3 = new double[]{4, 2, 3, 1, 4};
        labeledPoint3.setData(d3);
        labeledPointList.add(labeledPoint3);

        LabeledPoint labeledPoint4 = new LabeledPoint();
        labeledPoint4.setLabel(-1);
        double[] d4 = new double[]{-1, 2, 6, 1, 4};
        labeledPoint4.setData(d4);

        Map<Integer, Double> map = euclideanDistance(labeledPointList, labeledPoint4, true);
        map.forEach((key, value) -> System.out.println(key + "=====" + value));
    }
}

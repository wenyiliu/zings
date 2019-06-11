package com.yibao.common.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yibao.common.entity.LabeledPoint;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author liuwenyi
 * @date 2019/6/6 14:32
 */
@Slf4j
public class ADC {

    /**
     * Z-score converts two or more sets of data into an ununitary z-score,
     * unifies data standards, improves data comparability,
     * and weakens data interpretation.
     *
     * @param
     * @return
     */
    public static List<LabeledPoint> zScore(List<LabeledPoint> labeledPoints) {
        if (labeledPoints.isEmpty()) {
            log.error("the data normalized list cannot be empty");

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
        return labeledPointList;
    }

    private static double[] normalization(double[] d) {
        int len = d.length;
        double[] normalization = new double[len];
        Mean mean = new Mean();
        double dMean = mean.evaluate(d);
        StandardDeviation standardDeviation = new StandardDeviation();
        double deviation = standardDeviation.evaluate(d);
        if (deviation == 0) {
            log.info("标准差为零，取默认值1");
            deviation = 1;
        }
        for (int i = 0; i < len; i++) {
            normalization[i] = (d[i] - dMean) / deviation;
        }
        return normalization;
    }

    public static void euclideanDistance(List<LabeledPoint> list, LabeledPoint target) {
        list.add(target);
        List<Map<Integer,Double>> similarityList=Lists.newArrayList();
        List<LabeledPoint> labeledPointList = zScore(list);
        Stream<LabeledPoint> labeledPointStream = labeledPointList.stream()
                .filter(labeledPoint -> labeledPoint.getLabel().equals(target.getLabel()));
        labeledPointList.forEach(labeledPoint -> {
            labeledPoint.getData();
        });
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
        System.out.println(labeledPointList.size());
        zScore(labeledPointList).forEach(data -> {
            System.out.println(data.toString());
        });
    }
}

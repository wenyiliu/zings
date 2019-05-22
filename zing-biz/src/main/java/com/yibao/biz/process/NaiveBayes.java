package com.yibao.biz.process;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @auther: liuwenyi
 * @date 2019/5/17 17:43
 */
@Slf4j
public class NaiveBayes {

    /**
     * 拉普拉斯平滑
     */
    private static final Double NI = 1.0;

    /**
     * 训练模型
     *
     * @param data train data
     * @return
     */
    public static NaiveBayesModel train(List<LabeledPoint> data) {
        List<Category> categoryList = Lists.newArrayList();
        int sampleSpaceLen = data.size();
        int featureSpaceLen = data.get(0).getData().length;
        data.stream().collect(Collectors.groupingBy(LabeledPoint::getLabel, Collectors.counting()))
                .forEach((key, value) -> {
                    Category category = new Category();
                    category.setIndex(key);
                    double probability = value.doubleValue() / sampleSpaceLen;
                    category.setProbability(probability);
                    List<double[]> valueList = data.stream().filter(labeledPoint -> labeledPoint.getLabel().equals(key))
                            .map(LabeledPoint::getData).collect(Collectors.toList());
                    List<Map<Double, Double>> feature = dimensionalCount(valueList, featureSpaceLen);
                    category.setFeature(feature);
                    categoryList.add(category);
                });
        NaiveBayesModel model = new NaiveBayesModel();
        model.setCategoryList(categoryList);
        return model;
    }

    /**
     * Calculate the probability of each feature
     * in the feature space under different categories
     * @param data
     * @param len
     * @return
     */
    private static List<Map<Double, Double>> dimensionalCount(List<double[]> data, int len) {
        List<Map<Double, Integer>> countList = Lists.newArrayList();
        for (int i = 0; i < len; i++) {
            Map<Double, Integer> countMap = Maps.newHashMap();
            countMap.put(0.0, 0);
            countMap.put(1.0, 0);
            int finalI = i;
            data.forEach(d -> {
                double v = d[finalI];
                Integer value = 1;
                if (countMap.get(v) != null) {
                    value += countMap.get(v);
                }
                countMap.put(v, value);
            });
            countList.add(countMap);
        }
        List<Map<Double, Double>> rateList = Lists.newArrayList();
        countList.forEach(map -> {
            Map<Double, Double> rateMap = Maps.newHashMap();
            map.forEach((key, value) -> {
                double rate = (value + NI) / (data.size() + NI * map.size());
                rateMap.put(key, rate);
            });
            rateList.add(rateMap);
        });
        return rateList;
    }
}

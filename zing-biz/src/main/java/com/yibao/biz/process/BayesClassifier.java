package com.yibao.biz.process;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hankcs.hanlp.seg.common.Term;
import com.yibao.biz.bizenun.QuestionsEnum;
import com.yibao.common.entity.LabeledPoint;
import com.yibao.common.util.HanlpUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @auther: liuwenyi
 * @date 2019/5/5 19:57
 * 贝叶斯分类器
 */
@Slf4j
public class BayesClassifier {

    private static Map<String, Integer> keyWordMap;

    private static NaiveBayesModel model;

    private static final String FILEPATH = ".\\data\\question\\";

    static {
        try {
            keyWordMap = extractKeyWord();
        } catch (Exception e) {
            log.error("加载关键词失败，错误原因：{}", e.getMessage());
        }

    }

    static {
        //todo
        //前期训练数据很少，可以每次直接训练，当数据量很大的时候，可以考虑将模型持久化
        model = NaiveBayes.train(getTrainDataList());
    }

    /**
     * 加载文件
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    private static List<String> loadFile(String filePath) {
        File file = new File(filePath);
        BufferedReader br;
        List<String> lineList = Lists.newArrayList();
        String line;
        try {
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                lineList.add(line);
            }
            br.close();
        } catch (Exception e) {
            log.error("文件加载失败，原因：{}", e.getMessage());
        }
        return lineList;
    }

    /**
     * 量化分词
     *
     * @param sentence
     * @return
     */
    private static double[] sentencesToArrays(String sentence) {
        //创建一个vector数组，默认值为0.0
        double[] vector = new double[keyWordMap.size()];
        List<Term> termList = HanlpUtil.segment.seg(sentence);
        termList.forEach(term -> {
            String word = term.word;
            //分词工具分词后与关键词做匹配，存在将对应的数组值设置为1.0
            if (keyWordMap.containsKey(word)) {
                int index = keyWordMap.get(word);
                vector[index] = 1.0;
            }
        });
        return vector;
    }

    /**
     * 获取训练数据集，LabelPoint接收两个参数：
     * label（Double）分类标签
     * double[]张量
     *
     * @return
     * @throws IOException
     */
    private static List<LabeledPoint> getTrainDataList() {
        List<LabeledPoint> list = Lists.newArrayList();
        for (QuestionsEnum question : QuestionsEnum.values()) {
            List<String> lineList = loadFile(FILEPATH+question.getFilePath());
            lineList.forEach(line -> {
                double[] arr = sentencesToArrays(line);
                LabeledPoint trainData = new LabeledPoint(question.getIndex(), arr);
                list.add(trainData);
            });
        }
        return list;
    }

    /**
     * 预测
     *
     * @return
     */
    public static double classifier(String sentence) {
        double[] arr = sentencesToArrays(sentence);
        return model.predict(arr);
    }

    /**
     * 从抽象的问题模板中提取关键词
     *
     * @return
     */
    private static Map<String, Integer> extractKeyWord() {
        Map<String, Integer> vocabulary = Maps.newHashMap();
        List<String> list = Lists.newLinkedList();
        for (QuestionsEnum q : QuestionsEnum.values()) {
            List<String> lineList = loadFile(FILEPATH+q.getFilePath());
            lineList.forEach(line -> {
                List<Term> termList = HanlpUtil.segment.seg(line);
                termList.forEach(term -> list.add(term.word));
            });
        }
        List<String> keyWordList = list.stream().distinct().collect(Collectors.toList());
        keyWordList.forEach(keyword -> vocabulary.put(keyword, keyWordList.indexOf(keyword)));
        return vocabulary;
    }
}

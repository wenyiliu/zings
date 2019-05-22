package com.yibao.biz.process;

import com.google.common.collect.Lists;
import com.hankcs.hanlp.seg.common.Term;
import com.yibao.biz.model.Answer;
import com.yibao.common.util.HanlpUtil;

import java.util.List;


/**
 * @auther: liuwenyi
 * @date 2019/5/5 21:05
 * 获取关键词
 */
public class Participle {

    /**
     * 分析句子
     *
     * @param queryString
     * @return
     */
    public static Answer analyQuery(String queryString) {
        Answer answer = new Answer();
        StringBuilder sb = new StringBuilder();
        List<String> list = Lists.newArrayList();
        List<Term> termList = HanlpUtil.segment.seg(queryString);
        for (Term term : termList) {
            String word = term.word;//从term中获取分词
            String pos = term.nature.toString();//从term中获取标签
            if (pos.equals("ill")) { //ill 疾病
                list.add(word);
                sb.append("ill ");
            } else if (pos.equals("sym")) { //sym症状
                list.add(word);
                sb.append("sym ");
            } else {
                sb.append(word).append(" ");
            }
        }
        answer.setValues(list);
        answer.setIndex(BayesClassifier.classifier(sb.toString()));
        return answer;
    }
}

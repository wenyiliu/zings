package com.yibao.biz.service;

import com.yibao.common.entity.Result;

/**
 * @author liuwenyi
 * @date 2019/5/6 14:24
 */
public interface QuestionService {

    /**
     * 问答接口
     *
     * @param question 问题
     * @return Result
     */
    Result answer(String question);

}

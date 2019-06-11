package com.yibao.web.controller;

import com.yibao.biz.service.QuestionService;
import com.yibao.common.entity.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuwenyi
 * @date 2019/5/7 16:04
 */
@Api(tags = "问答接口")
@RequestMapping("question")
@RestController
public class QuestionsController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("query")
    public Result getAnswer(String question) {
        return questionService.answer(question);
    }
}

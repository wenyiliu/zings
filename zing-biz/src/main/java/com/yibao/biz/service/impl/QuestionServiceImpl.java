package com.yibao.biz.service.impl;

import com.yibao.biz.model.Answer;
import com.yibao.biz.process.Participle;
import com.yibao.biz.service.*;
import com.yibao.common.entity.Result;
import com.yibao.common.error.ZingErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/5/6 14:25
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private DiseaseService diseaseService;

    @Autowired
    private SymptomRelationService symptomRelationService;

    @Autowired
    private DrugRelationService drugRelationService;

    @Autowired
    private CheckRelationService checkRelationService;

    @Override
    public Result answer(String question) {
        Answer answer = Participle.analyQuery(question);
        List<String> values = answer.getValues();
        if (values.isEmpty()) {
            return Result.wrapErrorResult(ZingErrors.DISEASE_IS_NOT_EXIST);
        }
        //目前只做若干个value中取第一个value值，后期应该会做多value值的问答或者推荐；
        String value = values.get(0);
        switch (answer.getIndex().intValue()) {
            case 0:
                return diseaseService.getDisPreventByName(value);
            case 1:
                return diseaseService.getDisCauseName(value);
            case 2:
                return diseaseService.getDisDescByName(value);
            case 3:
                return checkRelationService.getCheckAndDiseaseBySymName(value);
            case 4:
                return diseaseService.getDisCureWayByName(value);
            case 5:
                return drugRelationService.getDiseaseAndDrugBySymName(value);
            case 6:
                return checkRelationService.getCheckByDisName(value);
            case 7:
                return drugRelationService.getDrugByDisName(value);
            case 8:
                return symptomRelationService.getSymptomByDisName(value);
            case 9:
                return diseaseService.getSyndromeByDiseaseName(value);
            case 10:
                return diseaseService.getDepartmentByDisName(value);
            case 11:
                return symptomRelationService.getDiseaseBySymName(value);
            case 12:
                return symptomRelationService.getDiseaseAndCureWayBySymName(value);
            default:
                return Result.wrapSuccessfulResult(null);
        }
    }
}

package com.yibao.biz.service.impl;

import com.google.common.collect.Lists;
import com.yibao.biz.model.result.DiseaseCheckBO;
import com.yibao.biz.model.result.SymptomDiseaseCheckBO;
import com.yibao.biz.service.CheckRelationService;
import com.yibao.common.entity.Result;
import com.yibao.common.error.ZingErrors;
import com.yibao.dao.entity.node.Check;
import com.yibao.dao.entity.Disease;
import com.yibao.dao.entity.relation.CheckRelation;
import com.yibao.dao.entity.relation.SymptomRelation;
import com.yibao.dao.repository.relation.CheckRelationRepository;
import com.yibao.dao.repository.relation.SymptomRelationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuwenyi
 * @date 2019/5/14 10:35
 */
@Slf4j
@Service
public class CheckRelationServiceImpl implements CheckRelationService {

    @Autowired
    private CheckRelationRepository checkRelationRepository;

    @Autowired
    private SymptomRelationRepository symptomRelationRepository;

    @Override
    public Result getCheckByDisName(String name) {
        List<CheckRelation> checkRelationList = checkRelationRepository.getCheckRelationByDisName(name);
        if (checkRelationList.isEmpty()) {
            log.error("获取与{}相关检查接口失败", name);
            return Result.wrapErrorResult(ZingErrors.CHECK_IS_NOT_EXIST);
        }
        DiseaseCheckBO diseaseCheck = new DiseaseCheckBO();
        diseaseCheck.setDisName(name);
        List<String> checkList = Lists.newArrayList();
        checkRelationList.forEach(checkRelation -> {
            Check check = checkRelation.getEndNode();
            checkList.add(check.getName());
        });
        diseaseCheck.setCheckList(checkList);
        return Result.wrapSuccessfulResult(diseaseCheck);
    }

    @Override
    public Result getCheckAndDiseaseBySymName(String name) {
        List<SymptomRelation> symptomRelationList =
                symptomRelationRepository.getDiseaseBySymptomName(name);
        if (symptomRelationList.isEmpty()) {
            log.error("获取{}相关疾病接口失败", name);
            Result.wrapErrorResult(ZingErrors.DISEASE_NOT_EXIST_OR_SYMNAMT_ERROR);
        }
        SymptomDiseaseCheckBO symptomDiseaseCheck = new SymptomDiseaseCheckBO();
        symptomDiseaseCheck.setSymName(name);
        List<DiseaseCheckBO> diseaseCheckList = Lists.newArrayList();
        symptomRelationList.stream().distinct()
                .collect(Collectors.toList()).forEach(symptomRelation -> {
            Disease disease = symptomRelation.getDisease();
            DiseaseCheckBO diseaseCheck = new DiseaseCheckBO();
            diseaseCheck.setDisName(disease.getName());
            List<String> checkList = Lists.newArrayList();
            checkRelationRepository.getCheckRelationByDisName(disease.getName())
                    .forEach(checkRelation -> {
                        Check check = checkRelation.getEndNode();
                        checkList.add(check.getName());
                    });
            diseaseCheck.setCheckList(checkList);
            diseaseCheckList.add(diseaseCheck);
        });
        symptomDiseaseCheck.setDiseaseCheckList(diseaseCheckList);
        return Result.wrapSuccessfulResult(symptomDiseaseCheck);
    }
}

package com.yibao.biz.service.impl;

import com.google.common.collect.Lists;
import com.yibao.biz.model.result.DiseaseBO;
import com.yibao.biz.model.result.DiseaseSymptomBO;
import com.yibao.biz.model.result.SymptomDiseaseBO;
import com.yibao.biz.service.DiseaseService;
import com.yibao.biz.service.SymptomRelationService;
import com.yibao.common.entity.Result;
import com.yibao.common.error.ZingErrors;
import com.yibao.dao.eneity.node.Symptom;
import com.yibao.dao.eneity.relation.SymptomRelation;
import com.yibao.dao.repository.relation.SymptomRelationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther: liuwenyi
 * @date 2019/5/13 20:36
 */
@Slf4j
@Service
public class SymptomRelationServiceImpl implements SymptomRelationService {

    @Autowired
    private SymptomRelationRepository symptomRelationRepository;

    @Autowired
    private DiseaseService diseaseService;

    @Override
    public Result getDiseaseBySymName(String symName) {
        List<SymptomRelation> symptomRelationList =
                symptomRelationRepository.getDiseaseBySymptomName(symName);
        if (symptomRelationList.isEmpty()) {
            log.error("获取和症状：{}相关疾病接口出错", symName);
            return Result.wrapErrorResult(ZingErrors.DISEASE_IS_NOT_EXIST_OR_SYMNAMT_ERROR);
        }
        SymptomDiseaseBO symptomDisease = new SymptomDiseaseBO();
        symptomDisease.setSymName(symName);
        List<DiseaseBO> diseaseList = Lists.newArrayList();
        symptomRelationList.forEach(symptomRelation -> {
            DiseaseBO disease = diseaseService.setDiseaseBO(symptomRelation.getDisease());
            diseaseList.add(disease);

        });
        symptomDisease.setDiseaseList(diseaseList);
        return Result.wrapSuccessfulResult(symptomDisease);
    }

    @Override
    public Result getSymptomByDisName(String name) {
        DiseaseSymptomBO diseaseSymptom = new DiseaseSymptomBO();
        diseaseSymptom.setDisName(name);
        List<SymptomRelation> symptomRelationList =
                symptomRelationRepository.getSymptomByDisName(name);
        if (symptomRelationList.isEmpty()) {
            log.error("获取与{}相关症状的接口失败", name);
            return Result.wrapErrorResult(ZingErrors.SYMPTOM_IS_NOT_EXIST);
        }
        List<String> symptomList = Lists.newArrayList();
        symptomRelationList.forEach(symptomRelation -> {
            Symptom symptom = symptomRelation.getSymptom();
            symptomList.add(symptom.getName());
        });
        diseaseSymptom.setSymptomList(symptomList.stream().distinct().collect(Collectors.toList()));
        return Result.wrapSuccessfulResult(diseaseSymptom);
    }
}

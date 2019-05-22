package com.yibao.biz.service.impl;

import com.google.common.collect.Lists;
import com.yibao.biz.model.result.DiseaseDrugBO;
import com.yibao.biz.model.result.SymptomDiseaseDrugBO;
import com.yibao.biz.service.DrugRelationService;
import com.yibao.common.entity.Result;
import com.yibao.common.error.ZingErrors;
import com.yibao.dao.entity.Disease;
import com.yibao.dao.entity.relation.SymptomRelation;
import com.yibao.dao.repository.node.DiseaseRepository;
import com.yibao.dao.repository.relation.SymptomRelationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 9:48
 */
@Slf4j
@Service
public class DrugRelationServiceImpl implements DrugRelationService {

    @Autowired
    private SymptomRelationRepository symptomRelationRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public Result getDiseaseAndDrugBySymName(String name) {
        List<SymptomRelation> symptomRelationList =
                symptomRelationRepository.getDiseaseBySymptomName(name);
        if (symptomRelationList.isEmpty()) {
            log.error("获取与{}相关疾病和药物接口失败", name);
            return Result.wrapErrorResult(ZingErrors.DISEASE_AND_DRUG_NOT_EXIST_OR_SYMNAMT_ERROR);
        }
        SymptomDiseaseDrugBO symDiseaseDrug = new SymptomDiseaseDrugBO();
        symDiseaseDrug.setSymName(name);
        List<DiseaseDrugBO> diseaseDrugList = Lists.newArrayList();
        symptomRelationList.forEach(symptomRelation -> {
            Disease startNode = symptomRelation.getDisease();
            DiseaseDrugBO diseaseDrug = new DiseaseDrugBO();
            List<String> drugList = diseaseRepository.getDrugByDiseaseName(startNode.getName());
            List<String> list = drugList.stream().distinct().collect(Collectors.toList());
            diseaseDrug.setDisName(startNode.getName());
            diseaseDrug.setDrugList(list);
            diseaseDrugList.add(diseaseDrug);
        });
        symDiseaseDrug.setDiseaseDrugList(diseaseDrugList);
        return Result.wrapSuccessfulResult(symDiseaseDrug);
    }

    @Override
    public Result getDrugByDisName(String name) {
        DiseaseDrugBO diseaseDrug = new DiseaseDrugBO();
        diseaseDrug.setDisName(name);
        List<String> drugList = diseaseRepository.getDrugByDiseaseName(name);
        if (drugList.isEmpty()) {
            log.error("获取{}相关的药物接口失败", name);
            return Result.wrapErrorResult(ZingErrors.DRUG_IS_NOT_EXIST);
        }
        List<String> list = drugList.stream().distinct().collect(Collectors.toList());
        diseaseDrug.setDrugList(list);
        return Result.wrapSuccessfulResult(diseaseDrug);
    }
}

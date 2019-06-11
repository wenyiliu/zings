package com.yibao.biz.service.impl;

import com.google.common.collect.Lists;
import com.yibao.biz.model.result.*;
import com.yibao.biz.service.DiseaseService;
import com.yibao.common.entity.Result;
import com.yibao.common.error.ZingErrors;
import com.yibao.dao.entity.Disease;
import com.yibao.dao.repository.node.DiseaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liuwenyi
 * @date 2019/4/30 18:06
 */
@Slf4j
@Service
public class DiseaseServiceImpl implements DiseaseService {

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Override
    public Result getDisCauseName(String name) {
        List<String> causeList = getDiseaseProperties(name, 0);
        if (causeList.isEmpty()) {
            log.error("获取{}诱因失败", name);
            return Result.wrapErrorResult(ZingErrors.DISEASE_CAUSE_IS_NOT_EXIST);
        }
        DiseaseCauseBO diseaseCause = new DiseaseCauseBO();
        diseaseCause.setDisName(name);
        causeList.stream().distinct().collect(Collectors.toList())
                .forEach(diseaseCause::setCause);
        return Result.wrapSuccessfulResult(diseaseCause);
    }

    @Override
    public Result getDisPreventByName(String name) {
        DiseasePreventBO diseasePrevent = new DiseasePreventBO();
        diseasePrevent.setDisName(name);
        List<String> diseasePreventList = getDiseaseProperties(name, 1);
        if (diseasePreventList.isEmpty()) {
            log.error("查询{}防御措施接口失败", name);
            return Result.wrapErrorResult(ZingErrors.DISEASE_PREVENT_IS_NOT_EXIST);
        }
        diseasePreventList.stream().distinct().collect(Collectors.toList())
                .forEach(diseasePrevent::setPrevent);
        return Result.wrapSuccessfulResult(diseasePrevent);
    }

    @Override
    public Result getDisCureWayByName(String name) {
        DiseaseCureWayBO diseaseCureWay = new DiseaseCureWayBO();
        diseaseCureWay.setDisName(name);
        List<Disease> diseaseList = getDiseaseByName(name);
        if (diseaseList.isEmpty()) {
            log.error("查询{}治疗方式失败", name);
            return Result.wrapErrorResult(ZingErrors.DISEASE_CUREWAY_IS_NOT_EXIST);
        }
        diseaseList.stream().distinct().collect(Collectors.toList())
                .forEach(disease -> diseaseCureWay.setCureWayList(disease.getCure_way()));
        return Result.wrapSuccessfulResult(diseaseCureWay);
    }

    @Override
    public Result getDisDescByName(String name) {
        DiseaseDescBO diseaseDesc = new DiseaseDescBO();
        diseaseDesc.setDisName(name);
        List<String> diseaseDescList = getDiseaseProperties(name, 2);
        if (diseaseDescList.isEmpty()) {
            log.error("查询{}描述接口失败", name);
            return Result.wrapErrorResult(ZingErrors.DISEASE_DESC_IS_NOT_EXIST);
        }
        diseaseDescList.stream().distinct().collect(Collectors.toList())
                .forEach(diseaseDesc::setDesc);
        return Result.wrapSuccessfulResult(diseaseDesc);
    }

    /**
     * 获取疾病
     *
     * @param name
     * @return
     */
    @Override
    public List<Disease> getDiseaseByName(String name) {
        List<Disease> diseaseList = diseaseRepository.getDiseaseByName(name);
        if (diseaseList.isEmpty()) {
            log.error("获取疾病：{}失败或者不存在", name);
            return Lists.newArrayList();
        }
        return diseaseList.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public DiseaseBO setDiseaseBO(Disease disease) {
        DiseaseBO diseaseBO = new DiseaseBO();
        diseaseBO.setDepartment(disease.getCure_department());
        diseaseBO.setDisName(disease.getName());
        return diseaseBO;
    }

    @Override
    public Result getSyndromeByDiseaseName(String name) {
        DiseaseSyndromeBO syndrome = new DiseaseSyndromeBO();
        syndrome.setDisName(name);
        List<Disease> syndromeList = diseaseRepository.getSyndromeByDiseaseName(name);
        if (syndromeList.isEmpty()) {
            log.error("获取{}的并发症接口失败", name);
            return Result.wrapErrorResult(ZingErrors.SYNDROME_IS_NOT_EXIST);
        }
        List<DiseaseBO> diseaseList = Lists.newArrayList();
        syndromeList.forEach(disease -> {
            DiseaseBO diseaseBO = new DiseaseBO();
            diseaseBO.setDisName(disease.getName());
            diseaseBO.setDepartment(disease.getCure_department());
            diseaseList.add(diseaseBO);
        });
        syndrome.setSyndromeList(diseaseList.stream().distinct().collect(Collectors.toList()));
        return Result.wrapSuccessfulResult(syndrome);
    }

    @Override
    public Result getDepartmentByDisName(String name) {
        List<String> depList = diseaseRepository.getDepartmentByDiseaseName(name);
        if (depList.isEmpty()) {
            log.error("获取{}相关科室接口失败", name);
            return Result.wrapErrorResult(ZingErrors.DEPARTMENT_IS_NOT_EXIST);
        }
        return Result.wrapSuccessfulResult(depList);
    }

    /**
     * 获取疾病的某一个属性值
     *
     * @param name
     * @param index
     * @return
     */
    private List<String> getDiseaseProperties(String name, int index) {
        List<Disease> diseaseList = getDiseaseByName(name);
        List<String> diseasePropertyList = Lists.newArrayList();
        if (diseaseList.isEmpty()) {
            return Lists.newArrayList();
        }
        diseaseList.forEach(disease -> {
            String value;
            switch (index) {
                case 0:
                    value = disease.getCause();
                    break;
                case 1:
                    value = disease.getPrevent();
                    break;
                case 2:
                    value = disease.getDesc();
                    break;
                default:
                    value = null;
            }
            diseasePropertyList.add(value);
        });
        return diseasePropertyList;
    }
}

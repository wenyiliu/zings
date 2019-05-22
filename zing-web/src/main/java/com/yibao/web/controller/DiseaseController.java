package com.yibao.web.controller;

import com.yibao.biz.service.DiseaseService;
import com.yibao.common.entity.Result;
import com.yibao.dao.entity.Disease;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther: liuwenyi
 * @date 2019/5/21 10:31
 */
@ApiModel("疾病相关接口")
@RestController
@RequestMapping("disease")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @GetMapping("query")
    @ApiOperation("获取疾病")
    public List<Disease> getDiseaseByName(@Param("name") String name) {
        return diseaseService.getDiseaseByName(name);
    }

    @GetMapping("desc")
    @ApiOperation("获取疾病描述")
    public Result getDesc(@Param("name") String name) {
        return diseaseService.getDisDescByName(name);
    }

    @GetMapping("cause")
    @ApiOperation("获取疾病病因")
    public Result getCause(@Param("name") String name) {
        return diseaseService.getDisCauseName(name);
    }

    @GetMapping("dep")
    @ApiOperation("获取疾病所属科室")
    public Result getDepartment(@Param("name") String name) {
        return diseaseService.getDepartmentByDisName(name);
    }

    @GetMapping("syn")
    @ApiOperation("获取疾病并发症")
    public Result getSyndrome(@Param("name") String name) {
        return diseaseService.getSyndromeByDiseaseName(name);
    }

    @GetMapping("cureway")
    @ApiOperation("获取疾病治疗方式")
    public Result getCureWay(@Param("name") String name) {
        return diseaseService.getDisCureWayByName(name);
    }

    @GetMapping("prevent")
    @ApiOperation("获取疾病治疗方式")
    public Result getPrevent(@Param("name") String name) {
        return diseaseService.getDisPreventByName(name);
    }

}

package com.yibao.web.controller;

import com.yibao.biz.service.HospitalService;
import com.yibao.common.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: liuwenyi
 * @date 2019/5/20 16:10
 */
@Api(tags = "医院相关接口")
@RestController
@RequestMapping("hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping("query")
    @ApiOperation("根据医院名称或者简称查询医院")
    public Result getHospitalByName(@Param("name") String name) {
        return hospitalService.getHospitalByNameOrAlias(name);
    }
}

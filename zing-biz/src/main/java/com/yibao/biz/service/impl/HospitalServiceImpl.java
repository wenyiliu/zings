package com.yibao.biz.service.impl;

import com.google.common.collect.Lists;
import com.yibao.biz.model.result.HospitalBO;
import com.yibao.biz.service.HospitalService;
import com.yibao.common.entity.Result;
import com.yibao.common.error.ZingErrors;
import com.yibao.common.util.BeanUtils;
import com.yibao.dao.entity.node.Hospital;
import com.yibao.dao.repository.node.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther: liuwenyi
 * @date 2019/5/14 19:50
 */
@Slf4j
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    private static List<Hospital> getList() {
        String path = "data/hospital.txt";
        File file = new File(path);
        BufferedReader reader;
        String line;
        List<Hospital> hospitalList = Lists.newArrayList();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                Hospital hospital = new Hospital();
                String[] columns = line.split("\\|");
                String id = columns[0];
                Integer.parseInt(id);
                hospital.setPId(Integer.parseInt(id));
                hospital.setName(columns[1]);
                hospital.setAlias(columns[2]);
                hospital.setAddress(columns[3]);
                hospital.setDesc(columns[4]);
                hospitalList.add(hospital);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hospitalList;
    }

    @Override
    public int batchInsert() {
        List<Hospital> hospitalList1 = getList();
        List hospitals = (List) hospitalRepository.saveAll(hospitalList1);
        return hospitals.size();
    }

    @Override
    public Result getHospitalByNameOrAlias(String name) {
        List<Hospital> hospitalList = hospitalRepository.getDistinctByNameOrAlias(name);
        if (hospitalList.isEmpty()) {
            log.error("{}医院不存在或者输入错误");
            return Result.wrapErrorResult(ZingErrors.HOSPITAL_IS_NOT_EXIST);
        }
        List<HospitalBO> hospitals = BeanUtils.copyList(hospitalList, HospitalBO.class);
        return Result.wrapSuccessfulResult(hospitals.stream().distinct()
                .collect(Collectors.toList()));
    }
}

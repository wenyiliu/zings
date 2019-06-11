package com.yibao.test;

import com.yibao.biz.service.DataCenterResultService;
import com.yibao.dao.entity.DataCenterResultDO;
import com.yibao.web.ZingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liuwenyi
 * @date 2019/5/21 15:25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class DataCenterResultServiceTest {

    @Autowired
    private DataCenterResultService dataCenterResultService;
    @Test
    public void getData() {
        DataCenterResultDO data = dataCenterResultService.getDataByID(23);
        System.out.println(data.toString());
    }
}

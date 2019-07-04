package com.yibao.test;

import com.yibao.common.util.hbase.HBaseConnection;
import com.yibao.web.ZingApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liuwenyi
 * @date 2019/07/01
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class HbaseUtilsTest {



    @Test
    public void test(){
        log.info(HBaseConnection.connection.toString());
    }
}

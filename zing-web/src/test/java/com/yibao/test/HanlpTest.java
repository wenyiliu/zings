package com.yibao.test;

import com.hankcs.hanlp.seg.common.Term;
import com.yibao.common.util.HanlpUtil;
import com.yibao.web.ZingApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/08/05
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZingApplication.class)
public class HanlpTest {

    @Test
    public void test() {
        List<Term> termList = HanlpUtil.segment.seg("肺泡蛋白质沉积症是什么");
        log.info("{}", termList.toString());
    }
}

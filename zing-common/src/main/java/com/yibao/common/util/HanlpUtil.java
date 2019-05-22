package com.yibao.common.util;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;

/**
 * @auther: liuwenyi
 * @date 2019/5/21 17:51
 */
public class HanlpUtil {
    public static Segment segment;

    /**
     * 初始化Segment
     * @return
     */
    static {
        try {
            segment = HanLP.newSegment();
            //开启自定义词典功能
            segment.enableCustomDictionary(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.yibao.biz.bizenun;

import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.List;

/**
 * @author liuwenyi
 * @date 2019/6/4 18:27
 */
public enum MailToEnum {

    /**
     * 邮件接收人分组
     * "xiaoyu.lxy@120yibao.com","zhaoshuan.lzs@120yibao.com",
     */
    GROUPONE(Lists.newArrayList(3), new String[]{
            "13503991075@163.com"}),
    ;

    @Getter
    private List<Integer> sqlId;
    @Getter
    private String[] to;

    MailToEnum(List<Integer> sqlId, String[] to) {
        this.sqlId=sqlId;
        this.to=to;
    }
}

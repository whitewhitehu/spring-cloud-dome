package com.spdata.common.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页参数
 * @author yangqifang
 */
@Getter
@Setter
@ToString
public class PageParameter<T> {
    private int pagenum;
    private int pagesize;
    private T parament;
}

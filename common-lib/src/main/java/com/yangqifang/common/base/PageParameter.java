package com.yangqifang.common.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页参数
 *
 * @author yangqifang
 */
@Data
public class PageParameter<T> {
    private int pagenum;
    private int pagesize;
    private T parament;
}

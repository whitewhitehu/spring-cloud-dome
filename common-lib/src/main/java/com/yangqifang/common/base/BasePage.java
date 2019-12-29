package com.yangqifang.common.base;

import lombok.Data;

import java.util.Collection;
import java.util.Collections;

/**
 * @author: yangqifang
 * @description: 2019/12/29 18:51
 */
@Data
public class BasePage<T> {
    //当前页
    private int page = 1;
    //每页大小
    private int limit = 10;
    private Collection<T> data = Collections.emptyList();
    //数据总数
    private int total = 0;

    public BasePage() {
    }

    public BasePage(int page, int limit, Collection<T> data, int total) {
        this.page = page;
        this.limit = limit;
        this.data = data;
        this.total = total;
    }
}

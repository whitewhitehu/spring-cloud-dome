package com.spdata.crm.dept.entity;

import com.spdata.common.dept.Dept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/1/2216:39
 **/
@Getter
@Setter
@ToString
public class DeptTree extends Dept {
    /**
     * 子节点
     */
    private List<DeptTree> children = new ArrayList<>();
}

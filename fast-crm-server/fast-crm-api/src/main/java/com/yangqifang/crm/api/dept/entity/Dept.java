package com.yangqifang.crm.api.dept.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author yangqifang
 */
@Data
public class Dept {
    /**
     * 部门ID
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 父节点ID 为0时为顶层
     */
    private Integer parent;

    /**
     * 是否删除
     */
    private Integer isDel;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateTime;
}


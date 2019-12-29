package com.yangqifang.crm.api.menu.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangqifang
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Menu {
    private Integer id;
    /**
     * title:名称
     */
    private String title;
    /**
     * 菜单地址
     */
    @JSONField(name = "path")
    private String path;
    /**
     * 图标
     */
    private String icon;
    /**
     * 是否删除
     */
    @JSONField(serialize = false)
    private Boolean is_del;
    /**
     * 父级菜单ID
     */
    private Integer pid;
    /**
     * 排序值
     */
    private Integer sort;
    /**
     * 前端组件路径
     */
    @JSONField(name = "component")
    private String component;
    /**
     * 重定向地址
     */
    private String redirect;
    /**
     * 是否隐藏 默认false 不隐藏
     */
    private boolean hidden;
    @JSONField(ordinal = 10)
    private List<Menu> children = new ArrayList<>();
}

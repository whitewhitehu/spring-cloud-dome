package com.spdata.common.menu;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Menu {
    private Integer id;
    //菜单名称
    private String name;
    //菜单地址
    @JSONField(name = "path")
    private String url;
    //图标
    private String icon;
    //是否删除
    @JSONField(serialize = false)
    private Boolean is_del;
    //父级菜单ID
    private Integer superior;
    //排序值
    private Integer sort;
    //前端组件
    @JSONField(name = "component")
    private String component;
    //目标渲染组件
    private String render;
    private List<Menu> children;
}

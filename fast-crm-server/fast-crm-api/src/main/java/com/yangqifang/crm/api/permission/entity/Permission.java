package com.yangqifang.crm.api.permission.entity;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Permission {
    private Integer id;
    private String name;
    private String value;
    @JSONField(serialize = false)
    private boolean is_del;
}

package com.spdata.common.permission;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class permission {
    private Integer id;
    private String name;
    private String value;
    @JSONField(serialize = false)
    private boolean is_del;
}

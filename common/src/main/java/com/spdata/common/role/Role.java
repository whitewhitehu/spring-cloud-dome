package com.spdata.common.role;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Role {

    private Integer id;
    private String name;
    private Date create_time;
    @JSONField(serialize = false)
    private boolean is_del;
}

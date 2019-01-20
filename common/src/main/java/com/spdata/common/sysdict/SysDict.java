package com.spdata.common.sysdict;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SysDict {

    private Integer id;

    private String name;

    private String type;

    private String value;

    private Integer isDel;

}


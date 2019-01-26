package com.spdata.common.sysdict;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yangqifang
 */
@Getter
@Setter
@ToString
public class SysDict {

    private Integer id;

    private String name;

    private String group;

    private String value;

    private Integer isDel;

}


package com.spdata.common.sysdict;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author yangqifang
 */
@Getter
@Setter
@ToString
public class SysDict implements Serializable {

    private Integer id;

    private String name;

    private String group;

    private String value;

    private Integer isDel;

}


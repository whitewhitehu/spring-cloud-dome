package com.yangqifang.crm.api.account.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author yangqifang
 */
@Data
public class AbstractAccount implements Serializable {
    private Integer id;
    private String username;
    @JSONField(serialize = false)
    private String password;
    private Integer deptId;
    private String mailbox;
    private String givename;
    private String country;
    private String avatar;
    private int phone;
    private boolean is_del;
}

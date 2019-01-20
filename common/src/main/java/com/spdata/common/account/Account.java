package com.spdata.common.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.spdata.common.menu.Menu;
import com.spdata.common.permission.permission;
import com.spdata.common.role.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class Account implements Serializable {
    private Integer id;
    private String username;
    @JSONField(serialize = false)
    private String password;
    private String mailbox;
    private String givename;
    private String country;
    private String avatar;
    private boolean is_del;
    private List<Role> roles;
    @JSONField(serialize = false)
    private List<Menu> menus;
    @JSONField(serialize = false)
    private List<permission> permissions;

}

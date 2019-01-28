package com.spdata.crm.account.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.spdata.common.account.Account;
import com.spdata.common.role.Role;
import com.spdata.crm.account.entity.serialize.AccountVoSerializeRoles;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/1/2819:26
 **/
@Getter
@Setter
@ToString
public class AccountVO extends Account {
    @JSONField(serializeUsing = AccountVoSerializeRoles.class)
    private List<Role> roles;
}

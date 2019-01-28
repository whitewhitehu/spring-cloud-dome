package com.spdata.crm.account;

import com.spdata.common.account.Account;
import com.spdata.common.role.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/1/2816:57
 **/
@Getter
@Setter
@ToString
public class AccountVO extends Account {
    private List<Role> roles;
}

package com.yangqifang.crm.api.account.dto;

import com.yangqifang.crm.api.account.entity.AbstractAccount;
import com.yangqifang.crm.api.role.entity.Role;
import lombok.Data;

import java.util.List;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/1/2819:26
 **/
@Data
public class AccountDto extends AbstractAccount {
    private List<Role> roles;
}

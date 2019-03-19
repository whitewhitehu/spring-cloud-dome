package com.spdata.resource.server.user.mapper;

import com.spdata.common.account.Account;
import com.spdata.common.base.BaseInterface;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/3/17-21:24
 **/
@Mapper
public interface UserMapper extends BaseInterface<Account> {
    /**
     * 根据登陆账户名称 查询 用户名,邮箱,头像,地区,
     *
     * @param username
     * @return
     */
    Account findBuAccountInfo(String username);
}

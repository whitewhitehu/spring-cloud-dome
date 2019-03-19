package com.spdata.resource.server.user.server;

import com.spdata.common.account.Account;
import com.spdata.common.base.BaseService;
import com.spdata.resource.server.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/3/17-21:31
 **/
@Service
public class UserService extends BaseService<UserMapper, Account> {
    @Autowired
    private UserMapper userMapper;

    public Account findBuAccountInfo(String username) {
        return userMapper.findBuAccountInfo(username);
    }
}

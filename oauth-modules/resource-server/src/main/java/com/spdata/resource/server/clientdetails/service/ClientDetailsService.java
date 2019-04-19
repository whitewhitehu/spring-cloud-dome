package com.spdata.resource.server.clientdetails.service;

import com.spdata.common.base.BaseService;
import com.spdata.common.clientdetail.MyOauthClientDetail;
import com.spdata.resource.server.clientdetails.mapper.ClientDetailsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author yangqifang
 * @date 2019/3/26-13:08
 * @描述:
 **/
@Service
public class ClientDetailsService extends BaseService<ClientDetailsMapper, MyOauthClientDetail> {
    @Autowired
    private ClientDetailsMapper clientDetailsMapper;

    @Override
    public boolean save(MyOauthClientDetail entity) {
        entity.setClientId(UUID.randomUUID().toString());
        entity.setClientSecret(UUID.randomUUID().toString());
        return clientDetailsMapper.save(entity);
    }

    public boolean update(MyOauthClientDetail myOauthClientDetail) {
        return clientDetailsMapper.update(myOauthClientDetail);
    }
}

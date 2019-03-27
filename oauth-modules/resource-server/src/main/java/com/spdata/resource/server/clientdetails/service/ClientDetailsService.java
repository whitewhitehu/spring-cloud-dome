package com.spdata.resource.server.clientdetails.service;

import com.spdata.common.base.BaseService;
import com.spdata.common.clientdetail.OauthClientDetails;
import com.spdata.resource.server.clientdetails.entity.MyOauthClientDetail;
import com.spdata.resource.server.clientdetails.mapper.ClientDetailsMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/3/26-13:08
 **/
@Service
public class ClientDetailsService extends BaseService<ClientDetailsMapper, MyOauthClientDetail> {
    @Override
    public boolean save(MyOauthClientDetail entity) {
        entity.setClientId(UUID.randomUUID().toString());
        entity.setClientSecret(UUID.randomUUID().toString());
        return super.save(entity);
    }
}

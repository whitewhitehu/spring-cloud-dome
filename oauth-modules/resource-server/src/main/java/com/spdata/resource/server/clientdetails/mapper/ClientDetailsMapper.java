package com.spdata.resource.server.clientdetails.mapper;

import com.spdata.common.base.BaseInterface;
import com.spdata.common.clientdetail.OauthClientDetails;
import com.spdata.resource.server.clientdetails.entity.MyOauthClientDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yangqifang
 * @描述:
 * @data 2019/3/22-15:25
 **/
@Mapper
public interface ClientDetailsMapper extends BaseInterface<MyOauthClientDetail> {
    @Override
    boolean save(MyOauthClientDetail myOauthClientDetail);
}

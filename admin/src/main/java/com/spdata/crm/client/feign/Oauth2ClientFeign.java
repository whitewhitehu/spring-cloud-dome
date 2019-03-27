package com.spdata.crm.client.feign;

import com.spdata.common.base.BaseResul;
import com.spdata.common.clientdetail.MyOauthClientDetail;
import com.spdata.crm.client.fallback.Oauth2ClienFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yangqifang
 * @date 2019/3/27-20:43
 * @deprecated : 远程调用resource-server-oath2服务接口
 **/
@FeignClient(value = "resource-server-oath2", fallback = Oauth2ClienFeignFallback.class)
public interface Oauth2ClientFeign {
    @PostMapping(value = "/resources/client/save")
    public BaseResul Oauth2ClientSave(@RequestBody MyOauthClientDetail myOauthClientDetail);
}

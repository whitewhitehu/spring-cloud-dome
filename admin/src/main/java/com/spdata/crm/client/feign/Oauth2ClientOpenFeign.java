package com.spdata.crm.client.feign;

import com.spdata.common.base.BaseResul;
import com.spdata.common.clientdetail.MyOauthClientDetail;
import com.spdata.crm.client.fallback.Oauth2ClienFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yangqifang
 * @date 2019/3/27-20:43
 * @deprecated : 远程调用resource-server-oath2服务接口
 **/
@FeignClient(name = "resource-server-oath2", fallback = Oauth2ClienFeignFallback.class, configuration = feignConfiguration.class)
public interface Oauth2ClientOpenFeign {
    @RequestMapping(value = "/resources/client/save", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public BaseResul clientSave(@RequestBody MyOauthClientDetail myOauthClientDetail);

    @RequestMapping(value = "/resources/client/update", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public BaseResul updateClient(@RequestBody MyOauthClientDetail myOauthClientDetail);
}

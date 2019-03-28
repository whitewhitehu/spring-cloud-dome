package com.spdata.crm.client.web;

import com.spdata.common.base.BaseResul;
import com.spdata.common.clientdetail.MyOauthClientDetail;
import com.spdata.crm.client.feign.Oauth2ClientOpenFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangqifang
 * @date 2019/3/28-14:30
 * @deprecated : oauth2 client 管理
 **/
@RestController
@RequestMapping(value = "/client")
@ResponseStatus(HttpStatus.OK)
public class ClientController {
    @Autowired
    private Oauth2ClientOpenFeign oauth2ClientOpenFeign;

    @ApiOperation("添加客户端")
    @PostMapping(value = "/save")
    public BaseResul save(@RequestBody MyOauthClientDetail clientDetail) {
        BaseResul resul = oauth2ClientOpenFeign.clientSave(clientDetail);
        return resul;
    }

    @ApiOperation("修改客户端")
    @PostMapping(value = "/update")
    public BaseResul update(@RequestBody MyOauthClientDetail clientDetail) {
        return oauth2ClientOpenFeign.updateClient(clientDetail);
    }
}

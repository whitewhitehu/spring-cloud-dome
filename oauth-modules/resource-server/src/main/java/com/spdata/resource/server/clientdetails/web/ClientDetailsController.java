package com.spdata.resource.server.clientdetails.web;

import com.spdata.common.base.BaseResul;
import com.spdata.common.base.Basemessage;
import com.spdata.common.clientdetail.MyOauthClientDetail;
import com.spdata.resource.server.clientdetails.service.ClientDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangqifang
 * @date 2019/3/27-19:46
 * @deprecated :
 **/
@RestController
@RequestMapping(value = "/client/")
public class ClientDetailsController {
    private Logger logger = LoggerFactory.getLogger(ClientDetailsController.class);
    @Autowired
    private ClientDetailsService clientDetailsService;

    /**
     * 添加OAUTH2客户端
     *
     * @param myOauthClientDetail
     * @return
     */
    @PostMapping(value = "/save")
    public BaseResul save(@RequestBody MyOauthClientDetail myOauthClientDetail) {
        BaseResul resul = new BaseResul();
        try {
            resul.setData(clientDetailsService.save(myOauthClientDetail));
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_system_message);
        }
        return resul;
    }

    /**
     * 修改OAUTH2客户端
     *
     * @param myOauthClientDetail
     * @return
     */
    @PostMapping(value = "/update")
    public BaseResul update(@RequestBody MyOauthClientDetail myOauthClientDetail) {
        BaseResul resul = new BaseResul();
        try {
            resul.setData(clientDetailsService.update(myOauthClientDetail));
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            resul.setCode(Basemessage.error);
            resul.setMessage(Basemessage.error_system_message);
        }
        return resul;
    }
}

package com.spdata.crm.client.fallback;

import com.spdata.common.base.BaseResul;
import com.spdata.common.base.Basemessage;
import com.spdata.common.clientdetail.MyOauthClientDetail;
import com.spdata.crm.client.feign.Oauth2ClientOpenFeign;
import org.springframework.stereotype.Component;

/**
 * @author yangqifang
 * @date 2019/3/27-20:52
 * @deprecated :
 **/
@Component
public class Oauth2ClienFeignFallback implements Oauth2ClientOpenFeign {
    @Override
    public BaseResul clientSave(MyOauthClientDetail myOauthClientDetail) {
        BaseResul baseResul = new BaseResul();
        baseResul.setCode(Basemessage.error);
        baseResul.setMessage(Basemessage.error_system_message);
        return baseResul;
    }

    @Override
    public BaseResul updateClient(MyOauthClientDetail myOauthClientDetail) {
        BaseResul baseResul = new BaseResul();
        baseResul.setCode(Basemessage.error);
        baseResul.setMessage(Basemessage.error_system_message);
        return baseResul;
    }
}

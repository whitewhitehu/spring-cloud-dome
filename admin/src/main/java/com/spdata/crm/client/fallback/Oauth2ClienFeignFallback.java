package com.spdata.crm.client.fallback;

import com.spdata.common.base.BaseResul;
import com.spdata.common.base.Basemessage;
import com.spdata.common.clientdetail.MyOauthClientDetail;
import com.spdata.crm.client.feign.Oauth2ClientFeign;

/**
 * @author yangqifang
 * @deprecated:
 * @date 2019/3/27-20:52
 **/
public class Oauth2ClienFeignFallback implements Oauth2ClientFeign {
    @Override
    public BaseResul Oauth2ClientSave(MyOauthClientDetail myOauthClientDetail) {
        BaseResul baseResul = new BaseResul();
        baseResul.setCode(Basemessage.error);
        return baseResul;
    }
}

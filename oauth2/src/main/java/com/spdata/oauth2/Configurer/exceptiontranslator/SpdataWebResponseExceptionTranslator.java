package com.spdata.oauth2.Configurer.exceptiontranslator;

import com.spdata.entity.Base.BaseResul;
import com.spdata.entity.Base.Basemessage;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * @描述:
 * @auther yangqifang
 * @data 2018/12/621:44
 **/
@Component
public class SpdataWebResponseExceptionTranslator extends DefaultWebResponseExceptionTranslator {
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
        ResponseEntity responseEntity = super.translate(e);
        BaseResul baseResul = new BaseResul();
        if (e instanceof InvalidGrantException) {
            baseResul.setCode(Basemessage.ParameterError);
            baseResul.setMessage(e.getLocalizedMessage());
        }
        ResponseEntity resulEntity = new ResponseEntity(baseResul, responseEntity.getHeaders(), responseEntity.getStatusCode());
        return resulEntity;
    }
}

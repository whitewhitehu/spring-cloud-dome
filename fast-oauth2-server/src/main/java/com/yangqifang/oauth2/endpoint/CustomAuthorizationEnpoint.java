package com.yangqifang.oauth2.endpoint;

import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yangqifang
 * @描述: 自定义授权界面
 * @data 2019/3/319:46
 **/
@Controller
@SessionAttributes("authorizationRequest")
public class CustomAuthorizationEnpoint {

    @RequestMapping(value = "/oauth2/confirm_access")
    public ModelAndView confirm_access(Map<String, Object> model, HttpServletRequest request) {
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) model.get("authorizationRequest");
        ModelAndView view = new ModelAndView("confirm_access");
        view.addObject("AuthorizationRequest", authorizationRequest);
        return view;
    }
}

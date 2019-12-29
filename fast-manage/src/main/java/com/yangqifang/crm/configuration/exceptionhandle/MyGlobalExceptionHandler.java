package com.yangqifang.crm.configuration.exceptionhandle;

import com.yangqifang.common.base.BaseResul;
import com.yangqifang.common.base.Basemessage;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author yangqifang
 * @描述: 404 403 500 请求异常处理
 * @data 2019/2/2520:53
 **/
@RestControllerAdvice
public class MyGlobalExceptionHandler {
    /**
     * 404找不到路径异常处理方法
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResul default404ErrorHandler(Exception e) {
        BaseResul resul = new BaseResul();
        resul.setCode(4004);
        resul.setMessage(Basemessage.NoHandler);
        return resul;
    }

    /**
     * 403没有这个权限异常处理方法
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(HttpStatus.OK)
    public BaseResul default403ErrorHandler(Exception e) {
        BaseResul resul = new BaseResul();
        resul.setCode(4003);
        resul.setMessage(Basemessage.Refuse_message);
        return resul;
    }
}

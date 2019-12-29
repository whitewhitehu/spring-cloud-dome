package com.yangqifang.common.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
/**
 * 返回消息模板
 */
public class BaseResul {
    private Integer code = Basemessage.success;
    private String message = Basemessage.success_message;
    private Object data;

    public BaseResul() {
    }

    public BaseResul(String message) {
        this.message = message;
    }

    public BaseResul(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResul(Object data) {
        this.data = data;
    }

    public BaseResul(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public BaseResul(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResul create() {
        return new BaseResul();
    }

    public BaseResul success() {
        return new BaseResul();
    }

    public BaseResul success(String message) {
        return new BaseResul(message);
    }

    public BaseResul success(String message, Object data) {
        return new BaseResul(message, data);
    }

    public BaseResul fail(Integer code) {
        BaseResul resul = create();
        resul.setCode(code);
        return resul;
    }

    public BaseResul fail(Integer code,String message) {
        BaseResul resul = create();
        resul.setCode(code);
        resul.setMessage(message);
        return resul;
    }


}

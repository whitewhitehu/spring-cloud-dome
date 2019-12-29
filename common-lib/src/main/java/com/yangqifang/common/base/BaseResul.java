package com.yangqifang.common.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * 返回消息模板
 */
public class BaseResul {
    private Integer code=Basemessage.success;
    private String message=Basemessage.success_message;
    private Object data;
}

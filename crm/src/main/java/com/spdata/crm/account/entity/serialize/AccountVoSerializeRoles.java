package com.spdata.crm.account.entity.serialize;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.spdata.common.role.Role;
import lombok.extern.java.Log;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangqifang
 * @描述: 对AccountVO的roles字段自定义序列化
 * @data 2019/1/2820:17
 **/
@Log
public class AccountVoSerializeRoles implements ObjectSerializer {
    @Override
    public void write(JSONSerializer jsonSerializer, Object object, Object fieldName, Type fieldType, int i) throws IOException {
        List<Integer> roleIDlist = new ArrayList<>();
        try {
            List<Role> roles = (List<Role>) object;
            roles.forEach(item -> {
                roleIDlist.add(item.getId());
            });
        } catch (Exception e) {
            e.printStackTrace();
            log.info(this.getClass().getName() + ":序列化异常----" + e.getMessage());
        }
        jsonSerializer.write(roleIDlist);
    }
}

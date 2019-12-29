package com.yangqifang.common.base;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public abstract class BaseService<D extends BaseInterface<T>, T> {
    @Autowired
    private D d;

    public T findById(T id) {
        return d.findByid(id);
    }

    public Collection<T> findByList(Collection<T> collection) {
        return d.findByIds(collection);
    }

    public boolean save(T entity) {
        return d.save(entity);
    }

    public T insert(T t) {
        return d.insert(t);
    }

    public boolean delect(T t) {
        return d.delect(t);
    }

    boolean update(T t) {
        return d.update(t);
    }

    public PageInfo<T> findByPage(PageParameter<T> t) {
        PageHelper.startPage(t.getPagenum(), t.getPagesize());
        List<T> list = d.findByPage(t.getParament());
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return pageInfo;
    }

    public boolean delect(Serializable id) {
        return d.deltct(id);
    }
}

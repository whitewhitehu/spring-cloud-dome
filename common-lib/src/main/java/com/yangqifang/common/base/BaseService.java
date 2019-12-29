package com.yangqifang.common.base;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public abstract class BaseService<D extends BaseDaoInterface<T>, T> {
    @Autowired
    private D dao;

    public T findById(T id) {
        return dao.findByid(id);
    }

    public Collection<T> findByIds(Collection<Serializable> collection) {
        return dao.findByIds(collection);
    }

    public boolean save(T entity) {
        return dao.save(entity);
    }

    public T insert(T t) {
        return dao.insert(t);
    }

    public boolean delect(T t) {
        return dao.delect(t);
    }

    boolean update(T t) {
        return dao.update(t);
    }

    @Deprecated
    public PageInfo<T> findByPage(PageParameter<T> t) {
        PageHelper.startPage(t.getPagenum(), t.getPagesize());
        List<T> list = dao.findByPage(t.getParament());
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return pageInfo;
    }

    public boolean delect(Serializable id) {
        return dao.deltct(id);
    }
    boolean batchUpdate(Collection<T> collection){
        return dao.batchUpdate(collection);
    }
}

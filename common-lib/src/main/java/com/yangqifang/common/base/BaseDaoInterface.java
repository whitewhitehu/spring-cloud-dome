package com.yangqifang.common.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseDaoInterface<T> {
    Collection<T> findByIds(Collection<Serializable> listid);

    T findByid(T t);

    boolean save(T t);

    T insert(T t);

    boolean delect(T t);

    List<T> findByPage(T t);

    boolean update(T t);

    boolean batchUpdate(Collection<T> collection);

    boolean deltct(Serializable id);

    T findByid(Serializable id);

    boolean batchDelect(Collection<Serializable> id);

    boolean batchSave(Collection<T> collection);
}

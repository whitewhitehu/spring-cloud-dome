package com.yangqifang.common.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseInterface<T> {
    Collection<T> findByIds(Collection<?> listid);

    T findByid(T t);

    boolean save(T t);

    T insert(T t);

    boolean delect(T t);

    List<T> findByPage(T t);

    boolean update(T t);

    boolean deltct(Serializable id);
}

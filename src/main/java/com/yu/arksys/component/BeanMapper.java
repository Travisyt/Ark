package com.yu.arksys.component;

import com.yu.arksys.bean.api.ResponseBean;

/**
 * 函数编程接口
 * @param <T>
 */
public interface BeanMapper<T, Mapper> {

    ResponseBean map(T bean, Mapper mapper);

}

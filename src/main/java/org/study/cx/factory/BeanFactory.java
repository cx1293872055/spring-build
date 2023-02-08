package org.study.cx.factory;

import org.study.cx.BeansException;

/**
 * @author chenxin
 * @date 2023-02-07 星期二 23:37:38
 */

public interface BeanFactory {
    Object getBean(String name);

    Object getBean(String name,
                   Object... args) throws BeansException;
}

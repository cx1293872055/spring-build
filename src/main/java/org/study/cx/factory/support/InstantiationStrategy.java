package org.study.cx.factory.support;

import org.study.cx.BeansException;
import org.study.cx.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author chenxin
 * @date 2023-02-08 星期三 23:23:06
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition,
                       String beanName,
                       Constructor constructor,
                       Object[] args) throws BeansException;

}

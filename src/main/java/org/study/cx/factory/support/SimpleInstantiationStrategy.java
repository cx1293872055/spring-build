package org.study.cx.factory.support;

import org.study.cx.BeansException;
import org.study.cx.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * @author chenxin
 * @date 2023-02-08 星期三 23:24:17
 */

public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition,
                              String beanName,
                              Constructor constructor,
                              Object[] args) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            if (Objects.nonNull(constructor)) {
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes())
                                .newInstance(args);
            } else {
                return beanClass.getDeclaredConstructor()
                                .newInstance();
            }
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}

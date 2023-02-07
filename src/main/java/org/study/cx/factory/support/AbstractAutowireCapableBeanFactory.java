package org.study.cx.factory.support;

import org.study.cx.BeansException;
import org.study.cx.factory.config.BeanDefinition;

/**
 * @author chenxin
 * @date 2023-02-07 星期二 23:56:22
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName,
                                BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass()
                                 .newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failde : ", e);
        }

        registerSingleton(beanName, bean);
        return bean;
    }
}

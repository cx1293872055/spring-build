package org.study.cx.factory.support;

import org.study.cx.BeansException;
import org.study.cx.factory.BeanFactory;
import org.study.cx.factory.config.BeanDefinition;

import java.util.Objects;

/**
 * @author chenxin
 * @date 2023-02-07 星期二 23:50:20
 */

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {


    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (Objects.nonNull(bean)) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName,
                                         BeanDefinition beanDefinition) throws BeansException;
}

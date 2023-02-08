package org.study.cx.factory.support;

import org.study.cx.BeansException;
import org.study.cx.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * @author chenxin
 * @date 2023-02-07 星期二 23:56:22
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

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

    @Override
    protected Object createBean(String beanName,
                                BeanDefinition beanDefinition,
                                Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        }catch (Exception e) {
            throw new BeansException("Instantiation of bean failed ", e);
        }

        registerSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition,
                                        String beanName,
                                        Object[] args) {

        Constructor constructorToUser = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {

            if (Objects.nonNull(args) && declaredConstructor.getParameterTypes().length == args.length) {
                constructorToUser = declaredConstructor;
                break;
            }
        }
        return instantiationStrategy.instantiate(beanDefinition, beanName, constructorToUser, args);
    }
}

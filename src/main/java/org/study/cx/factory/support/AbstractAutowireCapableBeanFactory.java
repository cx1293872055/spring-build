package org.study.cx.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.study.cx.BeansException;
import org.study.cx.PropertyValue;
import org.study.cx.PropertyValues;
import org.study.cx.factory.config.BeanDefinition;
import org.study.cx.factory.config.BeanReference;

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

            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed e: ", e);
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
            applyPropertyValues(beanName, bean, beanDefinition);
        }catch (Exception e) {
            throw new BeansException("Instantiation of bean failed ", e);
        }

        registerSingleton(beanName, bean);
        return bean;
    }

    private void applyPropertyValues(String beanName,
                                     Object bean,
                                     BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                BeanUtil.setFieldValue(bean, name, value);

            }
        }catch (Exception e) {
            throw new BeansException("Error setting property values:" + beanName);
        }
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
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUser, args);
    }


    public InstantiationStrategy getInstantiationStrategy() {
        return this.instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}

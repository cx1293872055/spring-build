package org.study.cx.factory.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.study.cx.BeansException;
import org.study.cx.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * @author chenxin
 * @date 2023-02-08 星期三 23:27:59
 */

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition,
                              String beanName,
                              Constructor constructor,
                              Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (Objects.isNull(constructor)) {
            return enhancer.create();
        }
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}

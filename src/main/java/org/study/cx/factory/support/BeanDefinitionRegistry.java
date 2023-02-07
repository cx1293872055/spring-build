package org.study.cx.factory.support;

import org.study.cx.factory.config.BeanDefinition;

/**
 * @author chenxin
 * @date 2023-02-08 星期三 00:02:53
 */

public interface BeanDefinitionRegistry {


    void registerBeanDefinition(String beanName,
                                BeanDefinition beanDefinition);
}

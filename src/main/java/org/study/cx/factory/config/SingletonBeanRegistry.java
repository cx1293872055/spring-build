package org.study.cx.factory.config;

/**
 * @author chenxin
 * @date 2023-02-07 星期二 23:45:39
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName,
                           Object singletonObject);
}

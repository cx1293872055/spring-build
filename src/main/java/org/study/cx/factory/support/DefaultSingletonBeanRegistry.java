package org.study.cx.factory.support;

import org.study.cx.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxin
 * @date 2023-02-07 星期二 23:48:17
 */

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {


    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName,
                                  Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}

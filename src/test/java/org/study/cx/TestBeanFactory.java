package org.study.cx;

import org.junit.jupiter.api.Test;
import org.study.cx.factory.config.BeanDefinition;
import org.study.cx.factory.support.DefaultListableBeanFactory;

/**
 * @author chenxin
 * @date 2023-02-09 星期四 00:13:50
 */


public class TestBeanFactory {

    @Test
    void testInstantiationStrategy() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class));

        UserService userService = (UserService) beanFactory.getBean("userService", "chenxin");


        System.out.println(userService.getUser());
        System.out.println(userService);

        UserService userService1 = (UserService) beanFactory.getBean("userService");
        System.out.println(userService1.getUser());
        System.out.println(userService1);
    }
}

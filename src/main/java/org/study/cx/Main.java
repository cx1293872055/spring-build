package org.study.cx;

import org.study.cx.factory.config.BeanDefinition;
import org.study.cx.factory.support.DefaultListableBeanFactory;

/**
 * @author ${USER}
 * @since ${YEAR}-${MONTH}-${DAY} ${DAY_NAME_FULL} ${HOUR}:${MINUTE}:${SECOND}
 */
public class Main {
    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class));

        UserService userService = (UserService) beanFactory.getBean("userService");
        System.out.println(userService.getUser());
        System.out.println(userService);

        UserService userService1 = (UserService) beanFactory.getBean("userService");
        System.out.println(userService1.getUser());
        System.out.println(userService1);
    }
}
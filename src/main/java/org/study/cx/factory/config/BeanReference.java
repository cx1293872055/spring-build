package org.study.cx.factory.config;

/**
 * @author chenxin
 * @date 2023-02-13 星期一 23:22:43
 */

public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}

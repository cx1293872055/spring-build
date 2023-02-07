package org.study.cx;

/**
 * @author chenxin
 * @date 2023-02-07 星期二 23:52:54
 */

public class BeansException extends RuntimeException{

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message,
                          Throwable cause) {
        super(message, cause);
    }
}

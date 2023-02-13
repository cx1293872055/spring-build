package org.study.cx;

/**
 * @author chenxin
 * @date 2023-02-13 星期一 23:23:27
 */

public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name,
                         Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

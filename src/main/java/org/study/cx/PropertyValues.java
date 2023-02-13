package org.study.cx;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxin
 * @date 2023-02-13 星期一 23:24:01
 */

public class PropertyValues {

    private List<PropertyValue> propertyValueLsit = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        propertyValueLsit.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueLsit.toArray(new PropertyValue[0]);
    }

    public PropertyValue getProeprtyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueLsit) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }

        return null;
    }
}

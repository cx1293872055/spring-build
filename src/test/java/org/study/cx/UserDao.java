package org.study.cx;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxin
 * @date 2023-02-13 星期一 23:36:51
 */

public class UserDao {


    private static final Map<String, String> map = new HashMap<>();


    static {

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
    }

    public String queryName(String uId) {
        return map.get(uId);
    }

}

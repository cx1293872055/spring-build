package org.study.cx;

/**
 * @author chenxin
 * @date 2023-02-08 星期三 00:10:18
 */

public class UserService {

    private String uId;
    private UserDao userDao;

    public UserService() {
    }

    public UserService(String name) {
        System.out.println(name);
    }
    public String getUser() {
        return "chenxin-cx";
    }

    public void queryUser() {
        System.out.println("------ ** "+userDao.queryName(uId));
    }
}

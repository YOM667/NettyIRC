package me.youm.services;

import me.youm.services.impl.UserServiceMemoryImpl;
import me.youm.services.impl.UserServiceSqlImpl;

public class UserServiceFactory {
    /*
     *创建UserServices的实现
     */
    private static UserService userService = new UserServiceMemoryImpl();


    private static UserServiceSqlImpl userServiceSql = new UserServiceSqlImpl();

    /**
     * 工厂类的获取方法
     * @return 返回userService
     */
    public static UserService getUserService() {
        return userService;
    }
    public static UserServiceSqlImpl getUserServiceSql() {
        return userServiceSql;
    }

}

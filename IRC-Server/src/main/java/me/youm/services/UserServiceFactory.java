package me.youm.services;

public class UserServiceFactory {
    /*
     *创建UserServices的实现
     */
    private static UserService userService = new UserServiceMemoryImpl();

    /**
     * 工厂类的获取方法
     * @return 返回userService
     */
    public static UserService getUserService() {
        return userService;
    }
}

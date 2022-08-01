package me.youm.server.services;

/**
 * 用户管理接口
 */
public interface UserService {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回 true, 否则返回 false
     */
    boolean login(String username, String password);

    /**
     * 注册
     * @param userName 用户名
     * @param passWord 密码
     * @param nickName 昵称
     * @return 注册成功返回 true, 否则返回 false
     */
    boolean register(String userName,String passWord,String nickName);
}

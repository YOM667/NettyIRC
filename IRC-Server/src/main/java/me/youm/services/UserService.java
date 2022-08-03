package me.youm.services;


import me.youm.entity.User;

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
     * @param user 用户
     * @return 注册成功返回 true, 否则返回 false
     */
    boolean register(User user);

    /**
     * 更改nickname
     * @param user 用户
     * @return 修改成功返回 true, 否则返回 false
     */
    boolean updateNickName(User user);

    /**
     * 获取用户信息
     * @return 返回用户对象
     */
    User getUserInfo(String username);
}

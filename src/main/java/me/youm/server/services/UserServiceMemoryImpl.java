package me.youm.server.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * UserService 的实现类 是用内存进行存储数据
 *
 */
public class UserServiceMemoryImpl implements UserService {
    private Map<String, String> allUserMap = new ConcurrentHashMap<>();

    /**
     * 实现父类的login方法
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回 true, 否则返回 false
     */
    @Override
    public boolean login(String username, String password) {
        /*
         *进行消息判断 ,通过key获取allUserMap的value,如果获取的值是空 就返回false
         * 否则返回 pass 是否和 password 相等
         */
        String pass = allUserMap.get(username);
        if (pass == null) {
            return false;
        }
        return pass.equals(password);
    }

    /**
     * 注册
     * @param userName 用户名
     * @param passWord 密码
     * @param nickName 昵称
     * @return 注册成功返回 true, 否则返回 false
     */
    @Override
    public boolean register(String userName, String passWord, String nickName) {
        allUserMap.put(userName,passWord);
        return true;
    }
}

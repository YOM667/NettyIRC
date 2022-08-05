package me.youm.services.impl;

import me.youm.entity.User;
import me.youm.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * UserService 的实现类 是用内存进行存储数据
 *
 */
public class UserServiceMemoryImpl implements UserService {
    private Map<String, String> allUserMap = new ConcurrentHashMap<>();
    private Map<String, String> userNickMap = new ConcurrentHashMap<>();

    private List<User> users = new ArrayList<>();


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
     * @param user 用户名
     * @return 注册成功返回 true, 否则返回 false
     */
    @Override
    public boolean register(User user) {
        users.add(user);
        userNickMap.put(user.getUserName(),user.getNickName());
        allUserMap.put(user.getUserName(),user.getPassWord());
        return true;
    }

    @Override
    public boolean updateNickName(User user) {
        userNickMap.put(userNickMap.get(user.getUserName()),user.getNickName());
        for (User u : users){
            if (u.getUserName().equals(user.getUserName())) {
                u.setNickName(user.getNickName());
                users.set(users.indexOf(u),u);
            }
        }

        return true;
    }

    @Override
    public User getUserInfo(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean banUser(String name) {
        return false;
    }
}

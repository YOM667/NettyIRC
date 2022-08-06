package me.youm.services.impl;

import me.youm.dao.UserMapper;
import me.youm.entity.User;
import me.youm.services.UserService;
import me.youm.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author : You_M
 * @date : 2022/8/4 17:16 37
 * @projectName : KES-IRC-Server
 * @className : UserServiceSqlImpl
 */
public class UserServiceSqlImpl implements UserService {
    private static final Logger log = LogManager.getLogger(UserServiceSqlImpl.class);

    @Override
    public boolean login(String username, String password) {
        User user = getUserInfo(username);
        return user.getUserName().equals(username) && user.getPassWord().equals(password);
    }

    @Override
    public boolean register(User user) {
        SqlSession session = MyBatisUtil.getSession();
        try{
            UserMapper userMapper = session.getMapper(UserMapper.class);
            if(user == null){
                return false;
            }
            int isSuccess = userMapper.registerUser(user);
            if (isSuccess>0){
                log.info("客户端用户注册成功");
            }
            session.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean updateNickName(User user) {
        SqlSession session = MyBatisUtil.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        try {
            getUserInfo(user.getUserName());
            userMapper.updateNickName(user);
            session.commit();

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public User getUserInfo(String username) {
        SqlSession session = MyBatisUtil.getSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        try {
            User user = userMapper.selectUserByName(username);
            return user;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean banUser(String name) {
        SqlSession session = MyBatisUtil.getSession();
        try {
            User userInfo = getUserInfo(name);
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.deleteUser(userInfo);
            userMapper.updateAfter(userInfo.getId());
            userMapper.updateAfterDelete(userInfo.getId());
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
        return true;
    }
}

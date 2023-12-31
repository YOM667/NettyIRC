package me.youm.services;

import me.youm.LLLM;
import me.youm.dao.UserMapper;
import me.youm.entity.User;;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author : You_M
 * @date : 2022/8/7 13:41 38
 * @projectName : KES-IRC-Server
 * @className : ServicesSql
 */
public class ServicesSql implements UserService{
    private static final Logger log = LogManager.getLogger(ServicesSql.class);

    @Override
    public boolean login(String username, String password) {
        User user = getUserInfo(username);
        return user.getUserName().equals(username) && user.getPassWord().equals(password);
    }

    @Override
    public boolean register(User user) {
        SqlSession session = LLLM.getSession();
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
        SqlSession session = LLLM.getSession();
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
        SqlSession session = LLLM.getSession();
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
        SqlSession session = LLLM.getSession();
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

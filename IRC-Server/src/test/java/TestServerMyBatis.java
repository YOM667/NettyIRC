import me.youm.dao.UserMapper;
import me.youm.entity.User;
import me.youm.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author : You_M
 * @date : 2022/8/4 13:24 49
 * @projectName : KES-IRC-Server
 * @className : TestServer
 */
public class TestServerMyBatis {
    /**
     * 测试mybatis是否能从数据库获取数据
     */
    @Test
    public void testSqlSelectByName(){
       try( SqlSession session = MyBatisUtil.getSession()){
           UserMapper userMapper = session.getMapper(UserMapper.class);
           User user = userMapper.selectUserByName("YouM");
           System.out.println(user.toString());
           session.close();
       }
    }
    @Test
    public void testSqlRegisterUser(){
        try( SqlSession session = MyBatisUtil.getSession()){
            UserMapper userMapper = session.getMapper(UserMapper.class);
            int isSuccess = userMapper.registerUser(new User("jhjj","123","NIMA"));
            if (isSuccess>0){
                System.out.println("注册成功");
            }
            session.commit();
            session.close();
        }
    }
    @Test
    public void testSqlUpdateNickName(){
        try( SqlSession session = MyBatisUtil.getSession()){
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.updateNickName(new User("Hawer","123","HAAA"));
            session.commit();
            session.close();
        }
    }
    @Test
    public void testSqlDeleteUser(){
        try( SqlSession session = MyBatisUtil.getSession()){
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = new User("sadsa", "123", "HAAA");
            userMapper.deleteUser(user);
            userMapper.updateAfter(user.getId());
            userMapper.updateAfterDelete(user.getId());
            session.commit();
            session.close();
        }
    }
}

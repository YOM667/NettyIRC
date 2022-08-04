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
}

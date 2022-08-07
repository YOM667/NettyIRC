package me.youm;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author : You_M
 * @date : 2022/8/7 13:36 07
 * @projectName : KES-IRC-Server
 * @className : MybatisUtils
 */
public class MybatisUtils {
    private static SqlSessionFactory sessionFactory;
    static {
        try {
            /*指定mybatis的config路径*/
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return sessionFactory.openSession();
    }
}

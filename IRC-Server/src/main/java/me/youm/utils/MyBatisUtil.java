package me.youm.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * MyBatisUtil用来初始化mybatis
 */
public class MyBatisUtil {
    private static SqlSessionFactory sessionFactory;
    static {
        try {
            /*指定mybatis的config路径*/
            String resource = "me.youm/mapper/UserMapper.xml";
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

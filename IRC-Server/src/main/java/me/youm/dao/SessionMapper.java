package me.youm.dao;

import me.youm.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author : You_M
 * @date : 2022/8/5 15:11 36
 * @projectName : KES-IRC-Server
 * @className : SessionMapper
 */
public interface SessionMapper {
    int registerUser(User user);
}

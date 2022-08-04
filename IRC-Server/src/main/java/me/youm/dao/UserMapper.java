package me.youm.dao;

import me.youm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : You_M
 * @date : 2022/8/4 13:19 19
 * @projectName : KES-IRC-Server
 * @className : UserMapper
 */
public interface UserMapper {
    User selectUserByName(String name);
    int registerUser(User user);
    void updateNickName(User user);
    void deleteUser(User user);
    void updateAfterDelete(Integer id);
    void updateAfter(@Param(value = "id") Integer id);
}

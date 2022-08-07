package me.youm.dao;

import me.youm.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User selectUserByName(String name);
    int registerUser(User user);
    void updateNickName(User user);
    void deleteUser(User user);
    void updateAfterDelete(Integer id);
    void updateAfter(@Param(value = "id") Integer id);
}
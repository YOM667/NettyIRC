package me.youm.api;

import com.sun.istack.internal.NotNull;
import me.youm.services.UseStatus;
import me.youm.services.UserService;
import me.youm.services.UserServiceFactory;

/**
 * @author : You_M
 * @date : 2022/8/7 13:51 01
 * @projectName : KES-IRC-Server
 * @className : SetMapper
 */
public class SetMapper {
    private UseStatus status = UseStatus.DEFAULT;
    private UserService userService;

    public UseStatus getStatus() {
        return status;
    }

    public void setStatus(UseStatus status) {
        this.status = status;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}

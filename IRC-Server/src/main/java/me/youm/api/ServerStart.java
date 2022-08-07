package me.youm.api;


import me.youm.ServerMain;
import me.youm.server.init.Server;
import me.youm.services.UseStatus;
import me.youm.services.UserService;

/**
 * @author : You_M
 * @date : 2022/8/5 14:40 35
 * @projectName : KES-IRC-Server
 * @className : ServerStart
 */
public class ServerStart {
    public static ServerStart start = new ServerStart();
    public static ServerStart getStart(){
        return start;
    }
    private ServerMain serverMain = new ServerMain();
    private SetMapper setMapper = new SetMapper();
    public boolean run(){
        return serverMain.start();
    }
    public SetMapper getSetMapper() {
        return setMapper;
    }
    public void config(UseStatus status, UserService userService){
        setMapper.setUserService(userService);
        setMapper.setStatus(status);
    }
    public void config(UseStatus status){
        setMapper.setStatus(status);
    }
}

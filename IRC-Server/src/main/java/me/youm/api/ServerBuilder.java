package me.youm.api;

import me.youm.ServerMain;
import me.youm.services.UseStatus;
import me.youm.services.UserService;

/**
 * @author : You_M
 * @date : 2022/8/12 16:31 18
 * @projectName : KES-IRC-Server
 * @className : ServerBuilder
 */
public final class ServerBuilder {
    public static ServerBuilder build(){
        return new ServerBuilder();
    }
    private ServerStop serverStop;
    private ServerMain serverMain;
    private SetMapper setMapper;
    public ServerBuilder() {
        serverMain = new ServerMain();
        serverStop = new ServerStop();
        setMapper = new SetMapper();
    }

    public ServerStop getServerStop() {
        return serverStop;
    }
    public String getHost(){
        return serverMain.getHost();
    }
    public int getPort(){
        return serverMain.getPort();
    }
    public SetMapper getSetMapper() {
        return setMapper;
    }
    //-----------------------------------------
    public boolean run(){
        return serverMain.start();
    }
    public void config(UseStatus status, UserService userService){
        setMapper.setUserService(userService);
        setMapper.setStatus(status);
    }
    public void config(UseStatus status){
        setMapper.setStatus(status);
    }

}

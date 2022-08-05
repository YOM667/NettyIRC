package me.youm.api;


import me.youm.ServerMain;
import me.youm.server.init.Server;

/**
 * @author : You_M
 * @date : 2022/8/5 14:40 35
 * @projectName : KES-IRC-Server
 * @className : ServerStart
 */
public abstract class ServerStart {
    public ServerMain serverMain = new ServerMain();

    private void run(Server server){
        serverMain.start(server);
    }


}

package me.youm.api;

import me.youm.ServerMain;

/**
 * @author : You_M
 * @date : 2022/8/14 11:02 20
 * @projectName : KES-IRC-Server
 * @className : ServerStop
 */
public class ServerStop {
    public void stopServer(ServerMain serverMain){
        serverMain.stop();
    }
}

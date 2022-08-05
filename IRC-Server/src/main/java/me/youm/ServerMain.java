package me.youm;

import me.youm.server.init.Server;

public class ServerMain {
    public Server server;
    public static void main(String[] args){
        new Server().start();
    }
    public void start(Server server){
        this.server = server;
        server.start();
    }
}

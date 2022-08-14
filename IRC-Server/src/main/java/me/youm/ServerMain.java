package me.youm;

import me.youm.server.init.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerMain{
    private static final Logger log = LogManager.getLogger(ServerMain.class);
    public Server server = new Server();
    public Thread t = new Thread(server);
    public boolean start(int port,String host){
        server.setPort(port);
        server.setHost(host);
        t.start();
        CountDownLatch latch = server.getLatch();
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return server.getIS_SUCCESS().get();
    }
    public boolean start(){
        t.start();
        CountDownLatch latch = server.getLatch();
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return server.getIS_SUCCESS().get();
    }
    public void stop(){
        server.stop();
    }
    public String getHost(){
        return server.getHost();
    }
    public int getPort(){
        return server.getPort();
    }
}

package me.youm.server.init;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressWarnings("all")
public class Server implements Runnable{
    public static final Logger log = LogManager.getLogger(Server.class);
    private int port;
    private String host;
    private AtomicBoolean IS_SUCCESS = new AtomicBoolean(false);
    public Server() {
        this(1145,"0.0.0.0");
    }

    public Server(int port,String host) {
        this.port = port;
        this.host = host;
    }
    public synchronized int getPort() {
        return port;
    }

    public  void setPort(int port) {
        this.port = port;
    }
    public  synchronized String getHost() {
        return host;
    }
    private CountDownLatch latch = new CountDownLatch(1);
    private Channel channel;
    public void setHost(String host) {
        this.host = host;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public AtomicBoolean getIS_SUCCESS() {
        return IS_SUCCESS;
    }

    public void setIS_SUCCESS(AtomicBoolean IS_SUCCESS) {
        this.IS_SUCCESS = IS_SUCCESS;
    }

    /**
     * TODO 启动bootstrap服务端
     */
    @Override
    public void run() {
        /**
         * 创建两个EventLoopGroup 分别是 worker和boss
         */
        EventLoopGroup worker = new NioEventLoopGroup();
        EventLoopGroup boss = new NioEventLoopGroup();
        try {
            log.info("服务器启动");
            ServerBootstrap serverBootstrap = new ServerBootstrap()
                    .group(boss, worker)
                    .childHandler(new ChatServerInitializer())
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .option(ChannelOption.SO_KEEPALIVE,true);
            ChannelFuture future = serverBootstrap.bind("127.0.0.1",1145).sync();
            future.addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                    if (future.isSuccess()){
                        IS_SUCCESS.set(true);
                        latch.countDown();
                    }else {
                        IS_SUCCESS.set(false);
                        latch.countDown();
                    }
                }
            });
            channel = future.channel();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
    public void stop(){
        try {
            if (channel != null) {
                log.info("http server is stopping listen port {} ...", port);
                channel.close();
                channel = null;
                log.info("http server is stopped to listen port {} !", port);
            }
        } catch (Exception e) {
            log.error("close netty http server exception", e);
        }
    }
}

package me.youm.server;

import com.sun.corba.se.internal.CosNaming.BootstrapServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Server {
    private int port;

    public Server() {
        this(1145);
    }

    public Server(int port) {
        this.port = port;
    }
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void start(){
        EventLoopGroup worker = new NioEventLoopGroup();
        EventLoopGroup boss = new NioEventLoopGroup();
        try {
            System.out.println("服务器启动");
            ServerBootstrap serverBootstrap = new ServerBootstrap()
            .group(boss, worker)
            .childHandler(new ChatServerInitializer())
            .channel(NioServerSocketChannel.class)
            .option(ChannelOption.SO_BACKLOG,200)
            .option(ChannelOption.SO_KEEPALIVE,true);
            Channel channel = serverBootstrap.bind("127.0.0.1",1145).sync().channel();

            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            log.error("server error", e);
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}

package me.youm.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import me.youm.client.command.Command;
import me.youm.client.command.CommandManager;

import java.util.List;
import java.util.Scanner;


public class ChatClient {
    public CommandManager commandManager = new CommandManager();
    public void init(){
        commandManager.init();
    }
    public void start() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
            .group(group)
            .channel(NioSocketChannel.class)
            .handler(new ChatClientInitializer());
            Channel channel = bootstrap.connect("127.0.0.1", 1145).sync().channel();

            Scanner scanner = new Scanner(System.in);
            init();

            while (true){
                String msg = scanner.nextLine();
                if(commandManager.contrast(msg))
                {
                    channel.writeAndFlush(msg+" \n");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

}
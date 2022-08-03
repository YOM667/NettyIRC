package me.youm.client.init;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import me.youm.command.CommandManager;
import me.youm.entity.Message;
import me.youm.entity.User;
import me.youm.message.ChatGroupRequestPacket;
import me.youm.message.ChatGroupResponsePacket;

import java.util.Scanner;

/**
 * <h1>客户端的代码</h1>
 * <p>用的单例设计模式</p>
 * <p>CommandManager用来进行命令模块管理</p>
 * <p>User是么每个客户端必须要有的</p>
 * <li> start 启动客户端
 * <li> init 初始化所有模块
 * @version 0.1.5
 */
@SuppressWarnings("all")
public class ChatClient {
    public static ChatClient chatClient = new ChatClient();
    public static ChatClient getChatClient(){
        return chatClient;
    }
    public User user = new User();

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
            init();
            //------------------------------------------------------
            run(channel);
            //------------------------------------------------------
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    public User getUser() {
        return user;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }
    public void run(Channel channel){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String msg = scanner.nextLine();
            switch (commandManager.contrast(msg,channel)){
                case CHAT:
                    if(this.user.isLogin()){
                        channel.writeAndFlush(new ChatGroupRequestPacket(new Message(msg,user)));
                    }
                    break;
                case COMMAND:
                    System.out.println("发送了指令");
                    break;
                case ERROR:
                    System.out.println("报错");
                    break;
                default:{
                }
            }

        }
    }
}
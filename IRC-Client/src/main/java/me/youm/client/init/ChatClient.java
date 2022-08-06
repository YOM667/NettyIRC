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
    /**
     * 单例设计模式
     */
    public static ChatClient chatClient = new ChatClient();
    private Channel channel;
    /**
     * TODO 获取实例
     * @return ChatClient对象
     */
    public static ChatClient getChatClient(){
        return chatClient;
    }
    //公共的可访问的对象--------------------------------------
    /**
     * 只有本类才能直接访问的private的User对象,可以通过ChatClient.getChatClient().getUser() 获取
     */
    private User user = new User();
    /**
     * 只有本类才能直接访问的private的CommandManager对象,可以通过ChatClient.getChatClient().getCommandManager 获取
     */
    public CommandManager commandManager = new CommandManager();
    //公共的可访问的对象--------------------------------------

    /**
     * TODO 初始化方法 用来初始化commandManager等方法
     */
    public void init(){
        commandManager.init();
    }

    /**
     * TODO start方法由主类调用,用来启动bootstrap客户端
     */
    public void start() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
            .group(group)
            .channel(NioSocketChannel.class)
            .handler(new ChatClientInitializer());
            channel= bootstrap.connect("127.0.0.1", 1145).sync().channel();
            /*调用各种方法,以后会加入多线程*/
            // ------------------------------------------------------
            init();
            run(channel);
            //------------------------------------------------------
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    /**
     * TODO 获取User的方法
     * @return User对象
     */
    public User getUser() {
        return user;
    }
    /**
     * TODO 获取CommandManager的方法
     * @return CommandManager对象
     */
    public CommandManager getCommandManager() {
        return commandManager;
    }

    public Channel getChannel() {
        return channel;
    }

    /**
     * TODO run方法由start方法调用,用来进行控制台输入输出
     * @param channel Channel对象 用来发送数据
     */
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
package me.youm.command;

import io.netty.channel.Channel;
import me.youm.client.init.ChatClient;
import me.youm.command.commands.*;

import java.util.ArrayList;
import java.util.List;
/**
 * @author : You_M
 * @date : 2022/7/29 17:33 10
 * @projectName : KES-IRC-Server
 * @className : CommandManager
 */
public class CommandManager {
    /*指令前缀,这是IRC协议中 发出指令所需要的前缀*/
    public static String suffix = "/";
    /**
     *工厂模式和策略模式混合,减少if else
     * 创建commands 存储继承于Command的类
     */
    private List<Command> commands;

    /**
     * TODO 由ChatClient的init方法调用,用来初始化commands
     */
    public void init() {
        this.commands = new ArrayList<>();
        this.commands.add(new ExitCommand());
        this.commands.add(new NickCommand());
        this.commands.add(new LoginCommand());
        this.commands.add(new RegisterCommand());
        this.commands.add(new INFOCommand());
        this.commands.add(new HelpCommand());
        this.commands.add(new BanUserCommand());
    }

    /**
     * TODO 通过分割message中的空格 形成一个字符串数组 进行进行逻辑判断
     * @param message 用户输入的消息
     * @param channel channel用来发送数据
     * @return 返回Type类型 如果是指令返回COMMAND 是消息返回CHAT 是错误指令返回ERROR
     */
    public Type contrast(String message, Channel channel){
        String[] args = message.split(" ");
        //----------------------------------------
        /*遍历所有command*/
        for (Command command : commands) {
            /*如果第一个空格前的指令前缀是 / 并且 是 / + command其中之一的名字*/
            if(args[0].startsWith(suffix) && args[0].equalsIgnoreCase(suffix + command.getName()) ){
                /*如果command的名字是login 或者 register*/
                if(command.getName().equals("login") || command.getName().equals("register")|| command.getName().equals("help")){
                   /*进行非空判断 */
                    if(!(command.execute(args,channel) == null)){
                        return Type.COMMAND;
                    }else {
                        System.out.println("格式出错");
                        return Type.ERROR;
                    }
                }else {
                    /*ChatClient的user对象中的isLogin方法是true*/
                    if(ChatClient.getChatClient().getUser().isLogin()){
                        /*进行非空判断 */
                        if(!(command.execute(args,channel) == null)){
                            return Type.COMMAND;
                        }else{
                            System.out.println("格式出错");
                            return Type.ERROR;
                        }
                    /*ChatClient的user对象中的isLogin方法是false*/
                    }else {
                        /*输出 请登录信息 */
                        System.out.println("请登录");
                        return Type.ERROR;
                    }
                }

            }
        }
        /*如果commands中没有args[0]中的值*/
        if(args[0].startsWith(suffix)){
            /*输出没有这个指令*/
            System.out.println("没有这个指令");
            return Type.ERROR;
        }
        return Type.CHAT;
    }

    public List<Command> getCommands() {
        return commands;
    }

}

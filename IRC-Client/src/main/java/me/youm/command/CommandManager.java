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

    public static String suffix = "/";
    private List<Command> commands;
    public void init() {
        this.commands = new ArrayList<>();
        this.commands.add(new ExitCommand());
        this.commands.add(new NickCommand());
        this.commands.add(new KickCommand());
        this.commands.add(new LoginCommand());
        this.commands.add(new RegisterCommand());
        this.commands.add(new INFOCommand());
    }
    public Type contrast(String message, Channel channel){
        String[] args = message.split(" ");
        //----------
        for (Command command : commands) {
            if(args[0].startsWith(suffix) && args[0].equalsIgnoreCase(suffix + command.getName()) ){
                if(command.getName().equals("login") || command.getName().equals("register")){
                    if(!(command.execute(args,channel) == null)){
                        return Type.COMMAND;
                    }else {
                        System.out.println("格式出错");
                        return Type.ERROR;
                    }
                }else {
                    if(ChatClient.getChatClient().user.isLogin()){
                        if(!(command.execute(args,channel) == null)){
                            return Type.COMMAND;
                        }else {
                            System.out.println("格式出错");
                            return Type.ERROR;
                        }
                    }else {
                        System.out.println("请登录");
                        return Type.ERROR;
                    }
                }

            }
        }
        if(args[0].startsWith(suffix)){
            System.out.println("没有这个指令");
            return Type.ERROR;
        }
        return Type.CHAT;
    }
}

package me.youm.client.command;

import io.netty.channel.Channel;
import me.youm.client.command.commands.*;

import java.util.ArrayList;
import java.util.List;

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
    }
    public boolean contrast(String message, Channel channel){
        String[] args = message.split(" ");
        for (Command command : commands) {
            if(args[0].startsWith(suffix)){
                if(args[0].equalsIgnoreCase(suffix + command.getName())){
                    if(!(command.execute(args,channel) == null)){
                        return true;
                    }else {
                        System.out.println("格式出错");
                    }
                }
            }
        }
        if(args[0].startsWith(suffix)){
            System.out.println("没有这个指令");
            return false;
        }
        return true;
    }
}

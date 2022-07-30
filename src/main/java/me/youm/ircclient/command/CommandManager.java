package me.youm.ircclient.command;

import io.netty.channel.Channel;

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
    }
    public List<Command> getCommands() {
        return commands;
    }
    public boolean contrast(String message, Channel channel){
        String[] args = message.split(" ");
        for (Command command : commands) {
            if(args[0].startsWith(suffix) && args[0].equalsIgnoreCase("/" + command.getName())){
                if(!(command.execute(args,channel) == null)){
                    return true;
                }
                return false;
            }
        }
        return true;
    }
}

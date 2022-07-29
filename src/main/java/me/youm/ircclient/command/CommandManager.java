package me.youm.ircclient.command;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    public static String suffix = "/";
    private List<Command> commands;
    public void init() {
        this.commands = new ArrayList<>();
        this.commands.add(new ExitCommand());
        this.commands.add(new Nick());
    }
    public List<Command> getCommands() {
        return commands;
    }
    public boolean contrast(String message){
        String[] args = message.split(" ");
        for (Command command : commands) {
            if(args[0].startsWith(suffix) && args[0].equalsIgnoreCase("/" + command.getName())){
                command.execute(args);
                return false;
            }
        }
        return true;
    }
}

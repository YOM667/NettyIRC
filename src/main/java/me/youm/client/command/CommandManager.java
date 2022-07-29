package me.youm.client.command;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    public static String suffix = "/";
    private List<Command> commands;
    public void init() {
        this.commands = new ArrayList<>();
        this.commands.add(new ExitCommand());
    }
    public List<Command> getCommands() {
        return commands;
    }
    public boolean contrast(String message){
        String[] args = message.split(" ");
        for (Command command : commands) {
            if(args[0].startsWith(suffix)){
                command.execute(args);
                return false;
            }
        }
        return true;
    }
}

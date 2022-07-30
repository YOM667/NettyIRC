package me.youm.ircclient.command;

import me.youm.ircclient.client.ChatClient;

public class KickCommand extends Command{
    public KickCommand() {
        super("kick", new String[]{"k"});
    }

    @Override
    public String execute(String[] args) {
        if(args.length <= 2){
            if(args[0].equalsIgnoreCase("/kick")){
                return "success";
            }
        }
        return null;
    }
}

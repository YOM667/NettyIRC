package me.youm.ircclient.command;

import io.netty.channel.Channel;
import me.youm.ircclient.client.ChatClient;

public class NickCommand extends Command{
    public NickCommand() {
        super("nick", new String[]{"n"});
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length <= 2){
            if(args[0].equalsIgnoreCase("/nick")){
                ChatClient.user.setUserName(args[1]);
                System.out.println(ChatClient.user.getUserName());
                return "success";
            }
        }
        return null;
    }
}

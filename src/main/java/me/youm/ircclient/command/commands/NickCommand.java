package me.youm.ircclient.command.commands;

import io.netty.channel.Channel;
import me.youm.ircclient.client.ChatClient;
import me.youm.ircclient.command.Command;
import me.youm.entity.User;

public class NickCommand extends Command {
    public NickCommand() {
        super("nick", new String[]{"n"});
    }

    @Override
    public String execute(String[] args, Channel channel) {
        User user = ChatClient.getChatClient().getUser();
        if(args.length >= 2){
            if(args[0].equalsIgnoreCase("/nick")){
                channel.writeAndFlush("*//kes");
                user.setUserName(args[1]);
                System.out.println("你的用户名已被更改为: "+user.getUserName());
                return "success";
            }
        }
        return null;
    }
}

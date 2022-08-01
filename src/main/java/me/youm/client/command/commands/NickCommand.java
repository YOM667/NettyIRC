package me.youm.client.command.commands;

import io.netty.channel.Channel;
import me.youm.client.ChatClient;
import me.youm.client.command.Command;
import me.youm.client.entity.User;

public class NickCommand extends Command {
    public NickCommand() {
        super("nick", new String[]{"n"});
    }

    @Override
    public String execute(String[] args, Channel channel) {
        User user = ChatClient.getChatClient().getUser();
        if(args.length >= 2){
            if(args[0].equalsIgnoreCase("/nick")){
                user.setUserName(args[1]);
                System.out.println("你的用户名已被更改为: "+user.getUserName());
                return "success";
            }
        }
        return null;
    }
}

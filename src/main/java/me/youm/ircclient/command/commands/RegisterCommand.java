package me.youm.ircclient.command.commands;

import io.netty.channel.Channel;
import me.youm.ircclient.client.ChatClient;
import me.youm.ircclient.command.Command;

public class RegisterCommand extends Command {
    public RegisterCommand() {
        super("register", new String[]{"r"}, "/register [username] [password] [nickname]");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length >= 4 && args[0].equalsIgnoreCase("/register")){
            channel.writeAndFlush("*//kes");
            ChatClient.getChatClient().getUser().setUserName(args[1]);
            ChatClient.getChatClient().getUser().setPassWord(args[2]);
            ChatClient.getChatClient().getUser().setNickName(args[3]);
            System.out.println("注册成功");
            return "success";
        }
        return null;
    }
}

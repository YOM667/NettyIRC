package me.youm.client.command.commands;

import io.netty.channel.Channel;
import me.youm.client.ChatClient;
import me.youm.client.command.Command;

public class LoginCommand extends Command  {
    public LoginCommand() {
        super("login", new String[]{"l"}, "/login [username] [password]");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length >= 3 && args[0].equalsIgnoreCase("/login")){
            channel.writeAndFlush("*//kes");
            if(
                    ChatClient.getChatClient().getUser().getUserName().equals(args[1]) &&
                    ChatClient.getChatClient().getUser().getPassWord().equals(args[2])
            )
            {
                System.out.println("你成功的登录了账号");
                return "success";
            }
            System.out.println("登录账号失败,请检查");
            return "success";
        }
        return null;
    }
}

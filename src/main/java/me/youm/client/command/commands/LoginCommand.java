package me.youm.client.command.commands;

import io.netty.channel.Channel;
import me.youm.client.ChatClient;
import me.youm.client.command.Command;
import me.youm.client.entity.User;
import me.youm.server.agreement.message.LoginRequestPacket;

public class LoginCommand extends Command  {
    public LoginCommand() {
        super("login", new String[]{"l"}, "/login [username] [password]");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length >= 3 && args[0].equalsIgnoreCase("/login")){
            User user = ChatClient.getChatClient().getUser();
            channel.writeAndFlush(new LoginRequestPacket(user));
            return "success";
        }
        return null;
    }
}

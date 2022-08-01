package me.youm.client.command.commands;

import io.netty.channel.Channel;
import me.youm.client.command.Command;
import me.youm.server.message.LoginRequestMessage;

public class LoginCommand extends Command  {
    public LoginCommand() {
        super("login", new String[]{"l"}, "/login [username] [password]");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length >= 3 && args[0].equalsIgnoreCase("/login")){
            channel.writeAndFlush(new LoginRequestMessage(args[1],args[2]));
            return "success";
        }
        return null;
    }
}

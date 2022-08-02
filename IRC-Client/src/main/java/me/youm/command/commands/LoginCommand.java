package me.youm.command.commands;

import io.netty.channel.Channel;

import me.youm.command.Command;
import me.youm.message.LoginRequestPacket;


public class LoginCommand extends Command {
    public LoginCommand() {
        super("login", new String[]{"l"}, "/login [username] [password]");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length >= 3 && args[0].equalsIgnoreCase("/login")){
            channel.writeAndFlush(new LoginRequestPacket(args[1],args[2]));
            return "success";
        }
        return null;
    }
}

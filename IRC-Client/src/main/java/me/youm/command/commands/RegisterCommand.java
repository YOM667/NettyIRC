package me.youm.command.commands;

import io.netty.channel.Channel;
import me.youm.client.init.ChatClient;

import me.youm.command.Command;
import me.youm.entity.User;
import me.youm.message.RegisterRequestPacket;
/**
 * @author : You_M
 * @date : 2022/7/29 17:55 41
 * @projectName : KES-IRC-Server
 * @className : RegisterCommand
 */
public class RegisterCommand extends Command {
    public RegisterCommand() {
        super("register", new String[]{"r"}, "/register [username] [password] [nickname]");
    }
    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length >= 4 && args[0].equalsIgnoreCase("/register")){
            channel.writeAndFlush(new RegisterRequestPacket(new User(args[1],args[2],args[3])));
            return "success";
        }
        return null;
    }
}

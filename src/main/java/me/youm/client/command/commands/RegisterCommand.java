package me.youm.client.command.commands;

import io.netty.channel.Channel;
import me.youm.client.ChatClient;
import me.youm.client.command.Command;
import me.youm.client.entity.User;
import me.youm.server.agreement.message.RegisterRequestPacket;

public class RegisterCommand extends Command {
    public RegisterCommand() {
        super("register", new String[]{"r"}, "/register [username] [password] [nickname]");
    }
    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length >= 4 && args[0].equalsIgnoreCase("/register")){
            User user = ChatClient.getChatClient().getUser();
            user.setUserName(args[1]);
            user.setPassWord(args[2]);
            user.setNickName(args[3]);
            channel.writeAndFlush(new RegisterRequestPacket(user));
            return "success";
        }
        return null;
    }
}

package me.youm.command.commands;

import io.netty.channel.Channel;
import me.youm.ChatClient;
import me.youm.command.Command;
import me.youm.entity.User;
import me.youm.message.NickNameRequestPacket;

public class NickCommand extends Command {
    public NickCommand() {
        super("nick", new String[]{"n"});
    }

    @Override
    public String execute(String[] args, Channel channel) {
        User user = ChatClient.getChatClient().getUser();
        if(args.length >= 2){
            if(args[0].equalsIgnoreCase("/nick")){
                user.setNickName(args[1]);
                channel.writeAndFlush(new NickNameRequestPacket(user));
                return "success";
            }
        }
        return null;
    }
}

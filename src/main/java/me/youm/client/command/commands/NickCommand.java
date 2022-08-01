package me.youm.client.command.commands;

import io.netty.channel.Channel;
import me.youm.client.ChatClient;
import me.youm.client.command.Command;
import me.youm.client.entity.User;
import me.youm.server.agreement.message.NickNameRequestPacket;

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

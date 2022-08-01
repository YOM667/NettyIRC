package me.youm.client.command.commands;

import io.netty.channel.Channel;
import me.youm.client.ChatClient;
import me.youm.client.command.Command;
import me.youm.client.entity.Status;

public class KickCommand extends Command {
    public KickCommand() {
        super("kick", new String[]{"k"},"/kick [username]");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length >= 2 && args[0].equalsIgnoreCase("/kick")){
            if(ChatClient.getChatClient().getUser().getStatus().equals(Status.ADMIN)) {
                channel.writeAndFlush("*//kes <kick|"+args[1] + ">");
            }
            return "success";
        }
        return null;
    }
}

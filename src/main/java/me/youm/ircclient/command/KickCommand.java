package me.youm.ircclient.command;

import io.netty.channel.Channel;
import me.youm.ircclient.client.ChatClient;
import me.youm.ircclient.entity.Status;

public class KickCommand extends Command{
    public KickCommand() {
        super("kick", new String[]{"k"},"/kick [username]");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length <= 2 && args[0].equalsIgnoreCase("/kick")){
            if(ChatClient.user.getStatus().equals(Status.ADMIN)) {
                channel.writeAndFlush("*//kes <kick|"+args[1] + ">");
            }
            return "success";
        }
        return null;
    }
}

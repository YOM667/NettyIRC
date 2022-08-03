package me.youm.command.commands;

import io.netty.channel.Channel;
import me.youm.client.init.ChatClient;
import me.youm.command.Command;
import me.youm.entity.Status;

/**
 * @author : You_M
 * @date : 2022/7/29 17:57 10
 * @projectName : KES-IRC-Server
 * @className : KickCommand
 */
public class KickCommand extends Command {
    public KickCommand() {
        super("kick", new String[]{"k"},"/kick [username]");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length >= 2 && args[0].equalsIgnoreCase("/kick")){
            if(ChatClient.getChatClient().getUser().getStatus().equals(Status.ADMIN)) {
            }
            return "success";
        }
        return null;
    }
}

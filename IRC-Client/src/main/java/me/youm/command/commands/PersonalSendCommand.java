package me.youm.command.commands;

import io.netty.channel.Channel;
import me.youm.command.Command;
import me.youm.entity.Message;
import me.youm.message.ChatPersonalRequestPacket;

/**
 * @author : You_M
 * @date : 2022/8/6 11:42 55
 * @projectName : KES-IRC-Server
 * @className : PersonalSendCommand
 */
public class PersonalSendCommand extends Command {
    public PersonalSendCommand() {
        super("psend", new String[]{"p"},"/psend [username] [message]");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length >= 3 && args[0].equals("/psend")){
            channel.writeAndFlush(new ChatPersonalRequestPacket(args[1],new Message(args[2], user)));
            return "success";
        }
        return null;
    }
}

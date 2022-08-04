package me.youm.command.commands;

import io.netty.channel.Channel;
import me.youm.command.Command;
import me.youm.message.INFORequestPacket;

/**
 * @author : You_M
 * @date : 2022/8/3 11:13 04
 * @projectName : KES-IRC-Server
 * @className : INFOCommand
 */
public class INFOCommand extends Command {
    public INFOCommand() {
        super("info", new String[]{"i"},"/info");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args[0].equalsIgnoreCase("/info")) {
            channel.writeAndFlush(new INFORequestPacket(true));
            return "success";
        }
        return null;
    }
}

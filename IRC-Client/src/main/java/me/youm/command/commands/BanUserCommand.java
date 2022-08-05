package me.youm.command.commands;

import io.netty.channel.Channel;
import me.youm.command.Command;
import me.youm.entity.Status;
import me.youm.message.BanUserRequestPacket;

/**
 * @author : You_M
 * @date : 2022/8/5 17:00 41
 * @projectName : KES-IRC-Server
 * @className : BanUserCommand
 */
public class BanUserCommand extends Command {

    public BanUserCommand() {
        super("ban", new String[]{"b"},"/ban username");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length >= 2){
            if(user.getStatus() == Status.ADMIN || user.getStatus() == Status.BOSS ){
                if(args[0].equals("/ban")){
                    channel.writeAndFlush(new BanUserRequestPacket(args[1]));
                    return "success";
                }
            }
        }

        return null;
    }
}

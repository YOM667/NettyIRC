package me.youm.command.commands;

import io.netty.channel.Channel;
import me.youm.command.Command;
import me.youm.message.NickNameRequestPacket;
/**
 * @author : You_M
 * @date : 2022/7/29 17:58 10
 * @projectName : KES-IRC-Server
 * @className : NickCommand
 */
public class NickCommand extends Command {
    public NickCommand() {
        super("nick", new String[]{"n"},"/nick [nickname]");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if (args.length >= 2) {
            if (args[0].equalsIgnoreCase("/nick")) {
                user.setNickName(args[1]);
                channel.writeAndFlush(new NickNameRequestPacket(user));
                return "success";
            }
        }

        return null;
    }
}

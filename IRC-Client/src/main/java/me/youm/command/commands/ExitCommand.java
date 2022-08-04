package me.youm.command.commands;

import io.netty.channel.Channel;
import me.youm.command.Command;
/**
 * @author : You_M
 * @date : 2022/7/29 17:57 14
 * @projectName : KES-IRC-Server
 * @className : ExitCommand
 */

public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit",new String[]{"e"},"/exit");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args[0].equalsIgnoreCase("/exit")) {
            System.exit(1);
            return "success";
        }
        return null;
    }
}

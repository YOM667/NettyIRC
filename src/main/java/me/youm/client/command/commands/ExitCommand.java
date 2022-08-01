package me.youm.client.command.commands;

import io.netty.channel.Channel;
import me.youm.client.command.Command;

public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit",new String[]{"e"});
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args[0].equalsIgnoreCase("/exit")) {
            channel.writeAndFlush("<exit>");
            System.exit(1);
            return "success";
        }
        return null;
    }
}

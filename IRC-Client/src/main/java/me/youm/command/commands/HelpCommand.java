package me.youm.command.commands;

import io.netty.channel.Channel;
import me.youm.client.init.ChatClient;
import me.youm.command.Command;
import me.youm.util.PrinterUtil;

/**
 * @author : You_M
 * @date : 2022/8/4 12:44 01
 * @projectName : KES-IRC-Server
 * @className : HelpCommand
 */
public class HelpCommand extends Command {
    public HelpCommand() {
        super("help", new String[]{"h"} ,"/help");
    }

    @Override
    public String execute(String[] args, Channel channel) {
        if(args.length >= 1 && args[0].equals("/help")){
            PrinterUtil.printHelp(ChatClient.getChatClient().commandManager.getCommands());
            return "help";
        }
        return null;
    }
}

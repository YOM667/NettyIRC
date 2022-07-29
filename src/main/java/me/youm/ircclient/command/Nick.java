package me.youm.ircclient.command;

import me.youm.ircclient.client.ChatClient;

public class Nick extends Command{
    public Nick() {
        super("nick", new String[]{"n"});
    }

    @Override
    public String execute(String[] args) {
        if(args.length <= 2){
            if(args[0].equalsIgnoreCase("/nick")){
                ChatClient.user.setUserName(args[1]);
                System.out.println(ChatClient.user.getUserName());
            }else {
                System.out.println("你输入的命令有误请重新输入");
            }
        }
        return null;
    }
}

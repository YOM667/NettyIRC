package me.youm.client.command;

public class FuckCommand extends Command{
    public FuckCommand() {
        super("fuck",new String[]{"f"});
    }

    @Override
    public String execute(String[] args) {
        if(args[0].equalsIgnoreCase("/fuck")){
                System.out.println("sb");
        }else {
            System.out.println("你输入的命令有误请重新输入");
        }
        return null;
    }
}

package me.youm.ircclient.command;

public class ExitCommand extends Command{
    public ExitCommand() {
        super("exit",new String[]{"e"});
    }

    @Override
    public String execute(String[] args) {
        if(args[0].equalsIgnoreCase("/exit")){
            System.exit(1);
        }else {
            System.out.println("你输入的命令有误请重新输入");
        }
        return null;
    }
}

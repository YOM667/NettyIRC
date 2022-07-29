package me.youm.client.command;

public class ExitCommand extends Command{
    public ExitCommand() {
        super("exit");
    }

    @Override
    public String execute(String[] args) {
        if(args.length != 0){
            System.out.println("你输入的值超出了命令的长度,请重新输入");
            return "";
        }else {
            if(args[0].equalsIgnoreCase("exit")){
                System.exit(1);
            }
        }
        return null;
    }
}

package me.youm.ircclient.command;

public class ExitCommand extends Command{
    public ExitCommand() {
        super("exit",new String[]{"e"});
    }

    @Override
    public String execute(String[] args) {
        if(args[0].equalsIgnoreCase("/exit")) {
            System.exit(1);
            return "success";
        }
        return null;
    }
}

package me.youm.ircclient.command;

public abstract class Command {
    private String name;
    private String[] alias;

    public String[] getAlias() {
        return alias;
    }

    public void setAlias(String[] alias) {
        this.alias = alias;
    }

    public Command(String name,String[] alias) {
        this.name = name.toLowerCase();
        this.alias = alias;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract String execute(String[] args);
}

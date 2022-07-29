package me.youm.client.command;

import java.util.HashMap;
import java.util.Map;

public abstract class Command {
    private String name;

    public Command(String name) {
        this.name = name.toLowerCase();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract String execute(String[] args);
}

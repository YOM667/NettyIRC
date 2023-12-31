package me.youm.command;

import io.netty.channel.Channel;
import me.youm.client.init.ChatClient;
import me.youm.entity.User;

/**
 * @author : You_M
 * @date : 2022/7/29 17:32 41
 * @projectName : KES-IRC-Server
 * @className : Command
 */
@SuppressWarnings("all")
public abstract class Command {
    private String name;
    private String[] alias;

    private String des;
    protected User user = ChatClient.getChatClient().getUser();

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
    public Command(String name,String[] alias,String des) {
        this.name = name.toLowerCase();
        this.alias = alias;
        this.des = des;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public abstract String execute(String[] args, Channel channel);
    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}

package me.youm;

import me.youm.client.init.ChatClient;

/**
 * @author : You_M
 * @date : 2022/7/29 14:55 15
 * @projectName : KES-IRC-Server
 * @className : ClientMain
 */
public class ClientMain {
    public static String[] dev = {"You_M"};
    public static void main(String[] args) {
        ChatClient.getChatClient().start();
        for (String s : dev) {
            System.out.println(s);
        }
    }

}

package me.youm;

import me.youm.client.init.ChatClient;

/**
 * @author : You_M
 * @date : 2022/7/29 14:55 15
 * @projectName : KES-IRC-Server
 * @className : ClientMain
 */
public class ClientMain {
    /**
     * 个人习惯,我喜欢把dev的成员写在主类中并加一些没有用的代码
     * 只是为了好玩
     */
    public static String[] dev = {"You_M"};
    public static String des =
            "Do you like my code? my code is very very very very cool"+
            "if you love me , please add Please add my QQ: 1055965862";
    public static void main(String[] args) {
        Thread t = new Thread(ChatClient.getChatClient());
        t.start();
    }

}

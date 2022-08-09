package me.youm.client;

import me.youm.client.init.ChatClient;
import me.youm.entity.Message;
import me.youm.message.ChatGroupRequestPacket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * @author : You_M
 * @date : 2022/8/9 15:52 27
 * @projectName : KES-IRC-Server
 * @className : InputThread
 */
public class InputThread implements Runnable {
    private static final Logger log = LogManager.getLogger(ChatClient.class);

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String msg = scanner.nextLine();
            switch (ChatClient.getChatClient().commandManager.contrast(msg, ChatClient.getChatClient().getChannel())){
                case CHAT:
                    if(ChatClient.getChatClient().getUser().isLogin()){
                        ChatClient.getChatClient().getChannel().writeAndFlush(new ChatGroupRequestPacket(new Message(msg,ChatClient.getChatClient().getUser())));
                    }
                    break;
                case COMMAND:
                    log.info("发送了指令");
                    break;
                case ERROR:
                    log.info("报错");
                    break;
                default:{
                }
            }
        }
    }
}

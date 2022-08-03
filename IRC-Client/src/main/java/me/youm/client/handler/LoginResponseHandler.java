package me.youm.client.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.client.init.ChatClient;
import me.youm.entity.User;
import me.youm.message.LoginResponsePacket;

/**
 * @author : You_M
 * @date : 2022/8/2 14:54 25
 * @projectName : KES-IRC-Server
 * @className : LoginResponseHandler
 */
@ChannelHandler.Sharable
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    private User u = ChatClient.getChatClient().user;
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginResponsePacket loginResponseMessage)  {
        System.out.println(loginResponseMessage.isSuccess() +" | " + loginResponseMessage.getReason());
        writeUser(loginResponseMessage.getUser());
    }
    public void writeUser(User user){
        u.setUserName(user.getUserName());
        u.setPassWord(user.getPassWord());
        u.setNickName(user.getNickName());
    }
}

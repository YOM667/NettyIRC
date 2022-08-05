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
    private User u = ChatClient.getChatClient().getUser();
    /**
     * 读取LoginResponsePacket数据包的方法
     * @param channelHandlerContext ChannelHandlerContext对象
     * @param loginResponseMessage  LoginResponsePacket数据包
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginResponsePacket loginResponseMessage)  {
        System.out.println(loginResponseMessage.isSuccess() +" | " + loginResponseMessage.getReason() + " | " + loginResponseMessage.getUser());
        writeUser(loginResponseMessage.getUser());
    }

    /**
     * 将LoginResponsePacket中的User对象写入到客户端的User中
     * 使客户端可以判断 用户是否登录
     * @param user User对象
     */
    public void writeUser(User user){
        u.setUserName(user.getUserName());
        u.setPassWord(user.getPassWord());
        u.setNickName(user.getNickName());
        u.setStatus(user.getStatus());
    }
}

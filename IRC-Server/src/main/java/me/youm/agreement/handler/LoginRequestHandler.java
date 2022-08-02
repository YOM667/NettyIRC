package me.youm.agreement.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.message.LoginRequestPacket;
import me.youm.message.LoginResponsePacket;
import me.youm.services.UserServiceFactory;
import me.youm.session.Session;
import me.youm.session.SessionFactory;

@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginRequestPacket loginRequestMessage) throws Exception {
        String userName = loginRequestMessage.getUserName();
        String passWord = loginRequestMessage.getPassWord();

        LoginResponsePacket responseMessage;
        boolean login = UserServiceFactory.getUserService().login(userName, passWord);
        if (login) {
            Session session = SessionFactory.getSession();
            session.bind(channelHandlerContext.channel(), userName);
            responseMessage = new LoginResponsePacket(true, "登陆成功");
        } else {
            responseMessage = new LoginResponsePacket(false, "登陆失败 ,用户名或密码不正确");
        }
        channelHandlerContext.writeAndFlush(responseMessage);
    }
}
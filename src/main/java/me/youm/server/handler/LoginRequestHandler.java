package me.youm.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.server.protocol.message.LoginRequestMessage;
import me.youm.server.protocol.message.LoginResponseMessage;
import me.youm.server.services.UserServiceFactory;
import me.youm.server.session.Session;
import me.youm.server.session.SessionFactory;

public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginRequestMessage loginRequestMessage) throws Exception {
        String passWord = loginRequestMessage.getPassWord();
        String userName = loginRequestMessage.getUserName();
        LoginResponseMessage responseMessage;
        boolean login = UserServiceFactory.getUserService().login(userName, passWord);
        if (login) {
            Session session = SessionFactory.getSession();
            session.bind(channelHandlerContext.channel(), userName);
            responseMessage = new LoginResponseMessage(true, "登陆成功");
        } else {
            responseMessage = new LoginResponseMessage(false, "登陆失败 ,用户名或密码不正确");
        }
        channelHandlerContext.writeAndFlush(responseMessage);
    }
}

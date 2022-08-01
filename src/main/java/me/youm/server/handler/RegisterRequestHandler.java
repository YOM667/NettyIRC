package me.youm.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.server.protocol.message.LoginResponseMessage;
import me.youm.server.protocol.message.RegisterRequestMessage;
import me.youm.server.protocol.message.RegisterResponseMessage;
import me.youm.server.services.UserServiceFactory;
import me.youm.server.session.Session;
import me.youm.server.session.SessionFactory;

public class RegisterRequestHandler extends SimpleChannelInboundHandler<RegisterRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RegisterRequestMessage registerRequestMessage) throws Exception {
        String passWord = registerRequestMessage.getPassWord();
        String userName = registerRequestMessage.getUserName();
        String nickName = registerRequestMessage.getNickName();
        RegisterResponseMessage responseMessage;
        boolean register = UserServiceFactory.getUserService().register(userName, passWord,nickName);
        if (register) {
            responseMessage = new RegisterResponseMessage(true, "注册成功");
        } else {
            responseMessage = new RegisterResponseMessage(false, "注册失败 ,请按照规则填写");
        }
        channelHandlerContext.writeAndFlush(responseMessage);
    }
}

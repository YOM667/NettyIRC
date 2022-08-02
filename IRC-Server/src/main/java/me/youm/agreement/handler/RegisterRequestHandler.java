package me.youm.agreement.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.entity.User;
import me.youm.message.RegisterRequestPacket;
import me.youm.message.RegisterResponsePacket;
import me.youm.services.UserServiceFactory;

@ChannelHandler.Sharable
public class RegisterRequestHandler extends SimpleChannelInboundHandler<RegisterRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RegisterRequestPacket registerRequestMessage){

        User user = registerRequestMessage.getUser();
        RegisterResponsePacket responseMessage;
        boolean register = UserServiceFactory.getUserService().register(user);
        if (register) {
            responseMessage = new RegisterResponsePacket(true, "注册成功",user.getUserName(),user.getPassWord(),user.getNickName());
        } else {
            responseMessage = new RegisterResponsePacket(false, "注册失败 ,请按照规则填写");
        }
        channelHandlerContext.writeAndFlush(responseMessage);
    }
}

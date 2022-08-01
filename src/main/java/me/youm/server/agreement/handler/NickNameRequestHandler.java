package me.youm.server.agreement.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.server.agreement.message.NickNameRequestPacket;
import me.youm.server.agreement.message.NickNameResponsePacket;
import me.youm.server.agreement.message.Packet;
import me.youm.server.agreement.message.RegisterResponsePacket;
import me.youm.server.services.UserService;
import me.youm.server.services.UserServiceFactory;

public class NickNameRequestHandler extends SimpleChannelInboundHandler<NickNameRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, NickNameRequestPacket nickNameRequestPacket) throws Exception {
        UserService userService = UserServiceFactory.getUserService();
        boolean update = userService.updateNickName(nickNameRequestPacket.getUser());
        NickNameResponsePacket responsePacket;
        if (update) {
            responsePacket = new NickNameResponsePacket(true, "更改成功");
        } else {
            responsePacket = new NickNameResponsePacket(false, "更改失败 ,请按照规则填写");
        }
        channelHandlerContext.writeAndFlush(responsePacket);
    }
}

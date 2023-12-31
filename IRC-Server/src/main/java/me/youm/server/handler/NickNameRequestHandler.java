package me.youm.server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import me.youm.dao.UserServicesMapper;
import me.youm.message.NickNameRequestPacket;
import me.youm.message.NickNameResponsePacket;
import me.youm.services.UserService;
import me.youm.services.UserServiceFactory;
import me.youm.utils.SendPacket;
@ChannelHandler.Sharable
public class NickNameRequestHandler extends SimpleChannelInboundHandler<NickNameRequestPacket> implements UserServicesMapper {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, NickNameRequestPacket nickNameRequestPacket) throws Exception {
        UserService userService = setMapper.getStatus().isValue() ? setMapper.getUserService(): UserServiceFactory.getUserServiceSql();
        boolean update = userService.updateNickName(nickNameRequestPacket.getUser());
        NickNameResponsePacket responsePacket;
        if (update) {
            responsePacket = new NickNameResponsePacket(true, "更改成功");
        } else {
            responsePacket = new NickNameResponsePacket(false, "更改失败 ,请按照规则填写");
        }
        SendPacket.sendPacketToServer(channelHandlerContext,responsePacket);
    }
}

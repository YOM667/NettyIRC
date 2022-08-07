package me.youm.server.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.api.ServerStart;
import me.youm.api.SetMapper;
import me.youm.dao.UserServicesMapper;
import me.youm.message.BanUserRequestPacket;
import me.youm.message.BanUserResponsePacket;
import me.youm.services.UseStatus;
import me.youm.services.UserService;
import me.youm.services.UserServiceFactory;
import me.youm.services.impl.UserServiceSqlImpl;
import me.youm.session.SessionFactory;
import me.youm.utils.SendPacket;

/**
 * @author : You_M
 * @date : 2022/8/5 17:05 21
 * @projectName : KES-IRC-Server
 * @className : BanUserRequestHandler
 */
@ChannelHandler.Sharable
public class BanUserRequestHandler extends SimpleChannelInboundHandler<BanUserRequestPacket> implements UserServicesMapper {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, BanUserRequestPacket banUserRequestPacket) throws Exception {
        UserService userServiceSql = setMapper.getStatus().isValue() ? setMapper.getUserService() : UserServiceFactory.getUserServiceSql();
        boolean ban = userServiceSql.banUser(banUserRequestPacket.getUserName());
        Channel channel = SessionFactory.getSession().getChannel(banUserRequestPacket.getUserName());
        channel.close();
        channel.closeFuture();
        SendPacket.sendPacketToServer(channelHandlerContext,ban ? new BanUserResponsePacket(true,"删除成功") : new BanUserResponsePacket(false,"删除失败请检查是否输入正确"));
    }
}

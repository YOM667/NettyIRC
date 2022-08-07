package me.youm.server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.dao.UserServicesMapper;
import me.youm.entity.User;
import me.youm.message.INFORequestPacket;
import me.youm.message.INFOResponsePacket;
import me.youm.services.UserService;
import me.youm.services.UserServiceFactory;
import me.youm.session.Session;
import me.youm.session.SessionFactory;
import me.youm.utils.SendPacket;

/**
 * @author : You_M
 * @date : 2022/8/3 11:25 27
 * @projectName : KES-IRC-Server
 * @className : INFORequestPacket
 */
@ChannelHandler.Sharable
public class INFORequestHandler extends SimpleChannelInboundHandler<INFORequestPacket> implements UserServicesMapper {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, INFORequestPacket infoRequestPacket) throws Exception {
        Session session = SessionFactory.getSession();
        String userName = session.getUserName(channelHandlerContext.channel());
//        UserService userService = UserServiceFactory.getUserService();
//        User userInfo = userService.getUserInfo(userName);
        User userInfo = setMapper.getStatus().isValue() ? setMapper.getUserService().getUserInfo(userName) : UserServiceFactory.getUserServiceSql().getUserInfo(userName);
        INFOResponsePacket infoResponsePacket;
        if (infoRequestPacket.isWant()) {
            infoResponsePacket = new INFOResponsePacket(userInfo,"获取成功",true);
        }else {
            infoResponsePacket = new INFOResponsePacket(userInfo,"获取失败",false);
        }
        SendPacket.sendPacketToServer(channelHandlerContext,infoResponsePacket);
    }
}

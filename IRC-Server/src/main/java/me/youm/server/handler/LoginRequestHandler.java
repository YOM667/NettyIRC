package me.youm.server.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import me.youm.dao.UserServicesMapper;
import me.youm.entity.User;
import me.youm.message.LoginRequestPacket;
import me.youm.message.LoginResponsePacket;
import me.youm.services.UserService;
import me.youm.services.UserServiceFactory;
import me.youm.session.Session;
import me.youm.session.SessionFactory;
import me.youm.utils.SendPacket;

@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> implements UserServicesMapper {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginRequestPacket loginRequestMessage) throws Exception {
        String userName = loginRequestMessage.getUserName();
        String passWord = loginRequestMessage.getPassWord();

        LoginResponsePacket responseMessage;
        UserService userService = setMapper.getStatus().isValue() ? setMapper.getUserService() : UserServiceFactory.getUserServiceSql();
        boolean login = userService.login(userName, passWord);
        User userInfo = userService.getUserInfo(userName);
        if (login) {
            Session session = SessionFactory.getSession();
            session.bind(channelHandlerContext.channel(), userName);
            responseMessage = new LoginResponsePacket(true, "登陆成功",userInfo);
        } else {
            responseMessage = new LoginResponsePacket(false, "登陆失败 ,用户名或密码不正确",userInfo);
        }
        SendPacket.sendPacketToServer(channelHandlerContext,responseMessage);
    }
}

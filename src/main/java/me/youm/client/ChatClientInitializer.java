package me.youm.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import me.youm.client.handler.LoginResponseHandler;
import me.youm.client.handler.NickNameResponseHandler;
import me.youm.client.handler.ReadHandler;
import me.youm.client.handler.RegisterResponseHandler;
import me.youm.server.agreement.protocol.IRCMessageCodec;
import me.youm.server.agreement.protocol.ProcotolFrameDecoder;

public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {
    private final LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
    private final RegisterResponseHandler REGISTER_HANDLER = new RegisterResponseHandler();
    private final LoginResponseHandler LOGIN_HANDLER = new LoginResponseHandler();
    private final NickNameResponseHandler NICK_NAME_HANDLER = new NickNameResponseHandler();
    @Override
    protected void initChannel(SocketChannel socketChannel) {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new ProcotolFrameDecoder());
        pipeline.addLast(LOGGING_HANDLER);
        pipeline.addLast(new IRCMessageCodec());
        pipeline.addLast(REGISTER_HANDLER);
        pipeline.addLast(LOGIN_HANDLER);
        pipeline.addLast(NICK_NAME_HANDLER);
    }
}

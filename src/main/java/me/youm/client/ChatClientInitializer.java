package me.youm.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import me.youm.client.handler.LoginResponseHandler;
import me.youm.client.handler.RegisterResponseHandler;
import me.youm.server.protocol.IRCMessageCodec;
import me.youm.server.protocol.ProcotolFrameDecoder;

public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {
    private final LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
    private final RegisterResponseHandler REGISTER_HANDLER = new RegisterResponseHandler();
    private final LoginResponseHandler LOGIN_HANDLER = new LoginResponseHandler();
    @Override
    protected void initChannel(SocketChannel socketChannel) {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new ProcotolFrameDecoder());
        pipeline.addLast(new IRCMessageCodec());
        // pipeline.addLast(new StringDecoder());
        // pipeline.addLast(new StringEncoder());
        // pipeline.addLast(new ReadHandler());
        pipeline.addLast(LOGGING_HANDLER);
        pipeline.addLast(REGISTER_HANDLER);
        pipeline.addLast(LOGIN_HANDLER);
    }
}

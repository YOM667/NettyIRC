package me.youm.client.init;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import me.youm.client.handler.*;
import me.youm.protocol.IRCMessageCodec;
import me.youm.protocol.ProcotolFrameDecoder;

/**
 * @author : You_M
 * @date : 2022/7/29 15:01 42
 * @projectName : KES-IRC-Server
 * @className : ChatClientInitializer
 */
public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {
    private final LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
    private final RegisterResponseHandler REGISTER_HANDLER = new RegisterResponseHandler();
    private final LoginResponseHandler LOGIN_HANDLER = new LoginResponseHandler();
    private final NickNameResponseHandler NICK_NAME_HANDLER = new NickNameResponseHandler();
    private final INFOResponseHandler INFO_HANDLER = new INFOResponseHandler();
    private final ChatGroupResponseHandler CHAT_GROUP_HANDLER = new ChatGroupResponseHandler();
    @Override
    protected void initChannel(SocketChannel socketChannel) {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new ProcotolFrameDecoder());
        pipeline.addLast(LOGGING_HANDLER);
        pipeline.addLast(new IRCMessageCodec());
        pipeline.addLast(REGISTER_HANDLER);
        pipeline.addLast(LOGIN_HANDLER);
        pipeline.addLast(NICK_NAME_HANDLER);
        pipeline.addLast(INFO_HANDLER);
        pipeline.addLast(CHAT_GROUP_HANDLER);
    }
}

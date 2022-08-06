package me.youm.server.init;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import me.youm.server.handler.*;
import me.youm.protocol.IRCMessageCodec;
import me.youm.protocol.ProcotolFrameDecoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ChannelHandler.Sharable
public class ChatServerInitializer extends ChannelInitializer<SocketChannel> {
    public static final Logger log = LogManager.getLogger(ChatServerInitializer.class);
    private final LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
    private final LoginRequestHandler LOGIN_HANDLER = new LoginRequestHandler();
    private final RegisterRequestHandler REGISTER_HANDLER = new RegisterRequestHandler();
    private final NickNameRequestHandler NICK_NAME_HANDLER = new NickNameRequestHandler();
    private final INFORequestHandler INFO_HANDLER = new INFORequestHandler();
    private final ChatGroupRequestHandler CHAT_GROUP_HANDLER = new ChatGroupRequestHandler();
    private final BanUserRequestHandler BAN_USER_HANDLER = new BanUserRequestHandler();
    private final ChatPersonalHandler CHAT_PERSONAL_HANDLE = new ChatPersonalHandler();
    @Override
    protected void initChannel(SocketChannel socketChannel)  {
        log.info("有客户端进入: {}" , socketChannel.remoteAddress());
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new ProcotolFrameDecoder());
        pipeline.addLast(new IRCMessageCodec());
//        pipeline.addLast(new ChatGroupHandler());
        pipeline.addLast(LOGGING_HANDLER);
        pipeline.addLast(LOGIN_HANDLER);
        pipeline.addLast(REGISTER_HANDLER);
        pipeline.addLast(NICK_NAME_HANDLER);
        pipeline.addLast(INFO_HANDLER);
        pipeline.addLast(CHAT_GROUP_HANDLER);
        pipeline.addLast(BAN_USER_HANDLER);
        pipeline.addLast(CHAT_PERSONAL_HANDLE);
    }
}

package me.youm.server.init;

import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
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

        socketChannel.pipeline().addLast(new IdleStateHandler(10,0,0));
        /*
           ChannelDuplexHandler 可以同时作为入栈和出栈 Handler
        */
        socketChannel.pipeline().addLast(new ChannelDuplexHandler(){
            /**
             * 用来触发特殊事件
             * @param ctx ChannelHandlerContext
             * @param evt 事件类型
             * @throws Exception 异常
             */
            @Override
            public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
                IdleStateEvent event =  (IdleStateEvent)evt;
                if(event.state() == IdleState.READER_IDLE){
                    log.debug("服务器已经超过 10 秒 没有收到数据了" );
                }
                super.userEventTriggered(ctx,evt);
            }
        });
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

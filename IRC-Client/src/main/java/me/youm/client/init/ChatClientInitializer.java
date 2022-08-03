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
    /*LoggingHandler 日志级别Handler*/
    private final LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
    /*RegisterResponseHandler 注册Response事件Handler*/
    private final RegisterResponseHandler REGISTER_HANDLER = new RegisterResponseHandler();
    /*LoginResponseHandler 登录Response事件Handler*/
    private final LoginResponseHandler LOGIN_HANDLER = new LoginResponseHandler();
    /*NickNameResponseHandler 修改nickname Response事件Handler*/
    private final NickNameResponseHandler NICK_NAME_HANDLER = new NickNameResponseHandler();
    /*INFOResponseHandler 查看用户信息Response事件Handler*/
    private final INFOResponseHandler INFO_HANDLER = new INFOResponseHandler();
    /*ChatGroupResponseHandler 群聊消息Response事件Handler*/
    private final ChatGroupResponseHandler CHAT_GROUP_HANDLER = new ChatGroupResponseHandler();

    /**
     * TODO 初始化Channel方法
     * @param socketChannel SocketChannel对象
     */
    @Override
    protected void initChannel(SocketChannel socketChannel) {
        /*
         * 将事件管理加入到队列中
         */
        ChannelPipeline pipeline = socketChannel.pipeline();
        /*加入半包粘包处理器*/
        pipeline.addLast(new ProcotolFrameDecoder());
        pipeline.addLast(LOGGING_HANDLER);
        /*加入编解码器*/
        pipeline.addLast(new IRCMessageCodec());
        pipeline.addLast(REGISTER_HANDLER);
        pipeline.addLast(LOGIN_HANDLER);
        pipeline.addLast(NICK_NAME_HANDLER);
        pipeline.addLast(INFO_HANDLER);
        pipeline.addLast(CHAT_GROUP_HANDLER);
    }
}

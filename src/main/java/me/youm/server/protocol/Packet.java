package me.youm.server.protocol;

import me.youm.server.protocol.message.LoginRequestMessage;
import me.youm.server.protocol.message.LoginResponseMessage;
import me.youm.server.protocol.message.RegisterRequestMessage;
import me.youm.server.protocol.message.RegisterResponseMessage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Packet {
    private final static Map<Byte, Class<? extends Packet>> packetType = new ConcurrentHashMap<>();
    static {
        packetType.put(PacketCommand.LoginRequest, LoginRequestMessage.class);
        packetType.put(PacketCommand.LoginResponse, LoginResponseMessage.class);
        packetType.put(PacketCommand.RegisterRequest, RegisterRequestMessage.class);
        packetType.put(PacketCommand.RegisterResponse, RegisterResponseMessage.class);
    }

    public static Class<? extends Packet> get(Byte command) {
        return packetType.get(command);
    }

    /**
     * 获取协议指令
     *
     * @return 返回指令值
     */
    public abstract Byte getCommand();

}

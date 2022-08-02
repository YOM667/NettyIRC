package me.youm.server.agreement.message;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Packet implements Serializable {
    public Packet() {
    }

    private final static Map<Byte, Class<? extends Packet>> packetType = new ConcurrentHashMap<>();

    static {
        packetType.put(PacketCommand.LoginRequest, LoginRequestPacket.class);
        packetType.put(PacketCommand.LoginResponse, LoginResponsePacket.class);
        packetType.put(PacketCommand.RegisterRequest, RegisterRequestPacket.class);
        packetType.put(PacketCommand.RegisterResponse, RegisterResponsePacket.class);
        packetType.put(PacketCommand.NickNameRequest , NickNameRequestPacket.class);
        packetType.put(PacketCommand.NickNameResponse,NickNameResponsePacket.class);
    }


    public static Class<? extends Packet> get(Byte command) {
        return packetType.get(command);
    }

    /**
     * 获取协议指令
     * @return 返回指令值
     */
    public abstract Byte getCommand();

}

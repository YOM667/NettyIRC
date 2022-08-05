package me.youm.message;

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
        packetType.put(PacketCommand.NickNameResponse, NickNameResponsePacket.class);
        packetType.put(PacketCommand.INFOResponse, INFOResponsePacket.class);
        packetType.put(PacketCommand.INFORequest, INFORequestPacket.class);
        packetType.put(PacketCommand.ChatGroupResponse, ChatGroupResponsePacket.class);
        packetType.put(PacketCommand.ChatGroupRequest, ChatGroupRequestPacket.class);
        packetType.put(PacketCommand.BanUserResponse, BanUserResponsePacket.class);
        packetType.put(PacketCommand.BanUserRequest, BanUserRequestPacket.class);

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

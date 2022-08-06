package me.youm.message;

/**
 * 存储Packet类型的类
 */
public interface PacketCommand {
    Byte LoginRequest = 1;
    Byte LoginResponse = 2;
    Byte RegisterRequest = 3;
    Byte RegisterResponse = 4;
    Byte NickNameRequest = 5;
    Byte NickNameResponse = 6;
    Byte INFOResponse = 7;
    Byte INFORequest = 8;
    Byte ChatGroupRequest = 9;
    Byte ChatGroupResponse = 10;
    Byte BanUserRequest = 11;
    Byte BanUserResponse = 12;
    Byte ChatPersonalRequest = 12;
    Byte ChatPersonalResponse = 12;
}
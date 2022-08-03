package me.youm.message;

public interface PacketCommand {
    Byte LoginRequest = 1;
    Byte LoginResponse = 2;
    Byte RegisterRequest = 3;
    Byte RegisterResponse = 4;
    Byte NickNameRequest = 5;
    Byte NickNameResponse = 6;
    Byte INFOResponse = 7;
    Byte INFORequest = 8;
}
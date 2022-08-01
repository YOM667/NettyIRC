package me.youm.server.protocol;

public interface PacketCommand {
    Byte LoginRequest = 1;
    Byte LoginResponse = 2;

    Byte RegisterRequest = 3;
    Byte RegisterResponse = 4;
}
package me.youm.client;

import ch.qos.logback.core.net.server.Client;

public class ClientMain {
    public static void main(String[] args) {
        new ChatClient().start();
    }
}

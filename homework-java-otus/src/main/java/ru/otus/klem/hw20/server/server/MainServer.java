package ru.otus.klem.hw20.server.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static ru.otus.klem.hw20.server.server.Server.queryAndAnswer;
import static ru.otus.klem.hw20.server.server.Server.serverSocket;


public class MainServer {
    static int port = 8088;
    public static void main(String[] args) {
        try {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                System.out.println("Server started!");
                while (true) {
                    Socket socket = serverSocket.accept();
                    System.out.println("Socket connected:" + socket.isConnected());
                    queryAndAnswer(socket);
                }
            } finally {
                System.out.println("Server closed!");
                serverSocket.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

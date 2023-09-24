package ru.otus.klem.hw20.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    static String host = "localhost";
    static int port = 8088;


    public static void main(String[] args) throws Exception {

        Socket socket = new Socket(host, port);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner reader = new Scanner(System.in);
        System.out.println("Status connect: " + socket.isConnected());
        while (true) {
            String readIn = in.readLine();

            if (readIn == null || readIn.trim().isEmpty()) {
                break;
            }

            System.out.println(readIn);
            String readerLine = reader.nextLine();
            out.write(readerLine + "\n");
            out.flush();
        }
        socket.close();
        in.close();
        out.close();

    }
}

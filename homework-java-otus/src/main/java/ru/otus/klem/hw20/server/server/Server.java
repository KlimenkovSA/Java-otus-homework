package ru.otus.klem.hw20.server.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements AutoCloseable {
    public static ServerSocket serverSocket;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void queryAndAnswer(Socket socket) throws IOException {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write("Enter first number\n");
            out.flush();
            String first = in.readLine();
            System.out.println(first);
            out.write("Enter second number\n");
            out.flush();
            String second = in.readLine();
            System.out.println(second);
            out.write("Chose action: + - * /\n");
            out.flush();
            int action = in.read();
            System.out.println((char) action);
            try {
                out.write(" Результат = " + calculate(first, second, action) + " press Enter\n");
            } catch (ArithmeticException e) {
                out.write("Error! division by zero is impossible" + e + "\n");
            } catch (RuntimeException e) {
                out.write("Error!  " + e + "\n");
            }
        } finally {
            out.flush();
            socket.close();
            in.close();
            out.close();
        }
    }

    public static int calculate(String first, String second, int action) {
        int result;
        try {
            result = switch ((char) action) {
                case '+' -> Integer.parseInt(first) + Integer.parseInt(second);
                case '-' -> Integer.parseInt(first) - Integer.parseInt(second);
                case '*' -> Integer.parseInt(first) * Integer.parseInt(second);
                case '/' -> Integer.parseInt(first) / Integer.parseInt(second);
                default -> throw new RuntimeException("Error! Enter correct operator");
            };
        } catch (ArithmeticException e) {
            throw new RuntimeException("Error! division by zero is impossible" + e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error!  " + e);
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        in.close();
        out.close();
        serverSocket.close();
    }
}

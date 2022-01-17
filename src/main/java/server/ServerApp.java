package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class ServerApp {

    private static int port = 1234;

    public static void main(String[] args) {
        System.out.println("Server startup!");

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                System.out.println("New connection accepted: ");
                final String name = in.readLine();
                System.out.println("\t" + name + ": port is " + clientSocket.getPort());
                out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            } catch (IOException e) {
                System.out.println("Ошибка создания серверного сокета или потока чтения/записи!" + e.getMessage());
            }
        }
    }
}

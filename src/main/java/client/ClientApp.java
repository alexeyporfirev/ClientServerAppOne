package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp {

    private static String host = "localhost";
    private static int hostPort = 1234;

    public static void main(String[] args) {
        System.out.println("Client App startup!");
        try(Socket clientSocket = new Socket(host, hostPort);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Alexey");
            System.out.println(in.readLine());
        } catch (UnknownHostException e) {
            System.out.println("Неверно задано имя сервера!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка соединения с сервером или чтения/записи в поток!" + e.getMessage());
        }
    }
}

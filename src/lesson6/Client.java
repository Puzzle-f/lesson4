package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
static final String ADRES =  "localhost";
    private static int PORT = 10000;

    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            socket = new Socket(ADRES, PORT);
            System.out.println("Вы подключились к серверу");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String message = scanner.nextLine();
                        outputStream.writeUTF(message);
                        System.out.println("Клиент: " + message);
                    }
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }).start();

                while (true) {
                    String str = inputStream.readUTF();
                    if(str.equals("/end")){
                        System.out.println("Клиент вышел из чата");
                        break;
                    } else {
                        System.out.println("Сервер: " + str);
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


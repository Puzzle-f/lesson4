package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

        private static int PORT = 10000;

        public static void main(String[] args) {
            ServerSocket server = null;

            Socket socket = null;
            Scanner scanner = new Scanner(System.in);

            try {
                server = new ServerSocket(PORT);
                System.out.println("Сервер запущен");

                socket = server.accept();
                System.out.println("Клиент подключился");

                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                new Thread(() -> {
                    try {
                        while (true) {
                            outputStream.writeUTF(scanner.nextLine());
                            System.out.println("Server: " + outputStream);
                        }
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }).start();

                  while (true) {
String str = inputStream.readUTF();
                      System.out.println("Клиент: " + str);
                      if(str.equals("/end")){
                          System.out.println("Клиент вышел из чата");
                          break;
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



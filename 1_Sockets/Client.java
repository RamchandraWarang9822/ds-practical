import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5555);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));

        new Thread(() -> {
            try {
                String serverMessage;
                while ((serverMessage = reader.readLine()) != null) {
                    System.out.println(serverMessage);
                    if (serverMessage.equals("Server: bye")) {
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Error reading from server: " + e.getMessage());
            }
        }).start();

        String clientMesage;
        while (true) {
            System.out.print("Client : ");
            clientMesage = keyboardReader.readLine();
            writer.println(clientMesage);
            if (clientMesage.equals("bye")) {
                break;
            }
        }

        socket.close();
        System.out.println("Connection Terminated");

    }

}
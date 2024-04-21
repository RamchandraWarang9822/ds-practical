import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port " + 8080);

        while (true) {
            // Wait for a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from: " + clientSocket.getInetAddress().getHostAddress());

            // Thread to handle communication with the client
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }

    private static class ClientHandler implements Runnable {

        private final Socket clientSocket;
        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Get input and output streams
                DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

                while (true) {
                    // Receive client timestamp
                    long clientTime = inputStream.readLong();

                    // Calculate average time with server time
                    long serverTime = System.currentTimeMillis();
                    long averageTime = (clientTime + serverTime) / 2;

                    // Send average time back to the client
                    outputStream.writeLong(averageTime);
                    System.out.println("Sent average time: " + averageTime);
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Client disconnected or error occurred. Server continues listening.");
            }
        }
    }
}

import java.io.*;
import java.net.*;
import java.util.Date;

public class Client {
    
    public static void main(String[] args) throws IOException {

        while (true) {
            try {
                // Connect to the server
                Socket clientSocket = new Socket("localhost", 8080);
                System.out.println("Connected to server: " + clientSocket.getRemoteSocketAddress());

                // Get input and output streams
                DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

                // Send current time to the server
                long currentTime = System.currentTimeMillis();

                outputStream.writeLong(currentTime);
                System.out.println("Sent current time: " + currentTime);

                // Receive average time from the server
                long averageTime = inputStream.readLong();

                Date average = new Date(averageTime);
                System.out.println("Received average time: " + average);

                // Add delay
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Connection to server lost. Client will reconnect in 5 seconds.");
                try {
                    Thread.sleep(5000); // Wait for 5 seconds before reconnecting
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}

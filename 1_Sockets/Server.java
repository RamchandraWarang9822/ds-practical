import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Server {

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5555);
        System.out.println("Server initiated, Waiting for Clients to Connect");

        while (true) {
            Socket s = ss.accept();
            System.out.println("Client Connected: " + s);

            ClientHandler clientHandler = new ClientHandler(s);
            clientHandler.start();
        }

    }

}

class ClientHandler extends Thread {

    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream());
    }

    public void run() {
        try {
            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.printf("Client: %S", clientMessage);

                writer.printf("Server %S: ", clientMessage);

                if (clientMessage == "bye") {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                System.out.println("Error closing socket " + e.getMessage());
            }
        }
    }
}
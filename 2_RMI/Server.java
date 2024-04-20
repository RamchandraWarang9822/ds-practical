import java.rmi.Naming;

public class Server {

    public static void main(String[] args) {

        try {
            Servant servant = new Servant();
            Naming.bind("Server", servant);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
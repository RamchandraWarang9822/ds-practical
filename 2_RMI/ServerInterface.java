import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    String concat(String a, String b) throws RemoteException;
}
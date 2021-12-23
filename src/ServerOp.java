import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerOp extends Remote {

     void sendPicture(String s) throws RemoteException;

}

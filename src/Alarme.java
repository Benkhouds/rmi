import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class Alarme extends UnicastRemoteObject implements ServerOp {

    public Alarme() throws RemoteException {}

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Alarme server = new Alarme();
        LocateRegistry.createRegistry(1200);
        Naming.rebind("rmi://127.0.0.1:1200/server", server);
    }

    @Override
    public void sendPicture(String s){

        System.out.println(s);
    }
}

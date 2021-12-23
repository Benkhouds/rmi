import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException, InterruptedException {
        ServerOp services = (ServerOp) Naming.lookup("rmi://127.0.0.1:1200/server");
        for (int i = 0; i <30 ; i++) {
            Camera t1 = new Camera("Hamza "+(i+1), services);
            t1.start();
            t1.join();
        }
    }
}

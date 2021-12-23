import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.ThreadLocalRandom;

public class Camera extends Thread{

    private final ServerOp services;
    public Camera(String name, ServerOp services) {
        super(name);
        this.services = services;
    }
    public String generateRandom(int n){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
    @Override
    public void run()  {
            synchronized(this.services){
                String s = generateRandom(ThreadLocalRandom.current().nextInt(5, 20));
                System.out.println(Thread.currentThread().getName()+ ": " +s);
                try {
                    this.services.sendPicture(s);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }




    }
}

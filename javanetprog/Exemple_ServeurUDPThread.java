// Exemple_ServeurUDPThread.java
import java.net.*;

public class Exemple_ServeurUDPThread extends Thread {

  protected DatagramSocket socket;
  
    public static void main(String[] args) throws Exception {
        try {
            Exemple_ServeurUDPThread UDPThread = new Exemple_ServeurUDPThread();
            UDPThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    public Exemple_ServeurUDPThread() throws Exception{
        socket = new DatagramSocket(9632);      
    }
    
  public void run() {
    try {  
        while (true) {
            System.out.println("Lancement du serveur");
            byte buffer[] = new byte[256];
                                
            DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
            DatagramPacket envoi = null;
            socket.receive(paquet);

            System.out.println("\n"+paquet.getAddress());
            int taille = paquet.getLength();
            String donnees = new String(paquet.getData(),0, taille);
            System.out.println("Donnees reçues = "+donnees);

            String message = "Bonjour "+donnees;
            System.out.println("Donnees envoyees = "+message);
            envoi = new DatagramPacket(message.getBytes(), 
            message.length(), paquet.getAddress(), paquet.getPort());
            socket.send(envoi);
            Thread.yield( );
        }
    } catch (Exception e) {
        e.printStackTrace();
    }                   
  }
}
// Exemple_ServeurTCPThread.java
import java.net.*;
import java.io.*;

public class Exemple_ServeurTCPThread extends Thread {

  final static int port = 9632;
  private Socket socket;

  public static void main(String[] args) {
    try {
      ServerSocket socketServeur = new ServerSocket(port);
      System.out.println("Lancement du serveur");
      while (true) {
        Socket socketClient = socketServeur.accept();
        Exemple_ServeurTCPThread Serveur= new Exemple_ServeurTCPThread(socketClient);
        Serveur.start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Exemple_ServeurTCPThread(Socket socket) {
    this.socket = socket;
  }

  public void run() {
    try {

      System.out.println("Connexion avec le client : " + socket.getInetAddress());

      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintStream out = new PrintStream(socket.getOutputStream());

      out.println("Veuillez saisir votre compte : ");
      String message = in.readLine();
      System.out.println("Bonjour " + message);

      socket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
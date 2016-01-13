// Exemple_ServeurTCP.java
import java.net.*;
import java.io.*;

public class Exemple_ServeurTCP {
  final static int port = 9632;

  public static void main(String[] args) {
    try {
        System.out.println("Lancement du serveur");
        ServerSocket socketServeur = new ServerSocket(port);
      
      while (true) {
        
        Socket socketClient = socketServeur.accept(); 
        System.out.println("Connexion avec : " + socketClient.getInetAddress());

        BufferedReader in = new BufferedReader(
          new InputStreamReader(socketClient.getInputStream()));
        PrintStream out = new PrintStream(socketClient.getOutputStream());
        
        out.println("Veuillez saisir votre compte : ");
        String Compte = in.readLine();
        System.out.println("Compte d'utilisaeur : " + Compte);
        
        out.println("Bienvenue " + Compte);
        socketClient.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

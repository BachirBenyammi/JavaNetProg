// Exemple_InetAddress.java
import java.net.*;

public class Exemple_InetAddress { 
    
      public static void main(String[] args) {
      try {
        // Renvoi l'adresse de la machine
        InetAddress Adresse_Locale = InetAddress.getLocalHost(); 
        System.out.println("L'adresse locale = " + Adresse_Locale.getHostAddress());
      
        // Renvoi l'adresse IP du serveur de l'université de Laghouat
        InetAddress Adresse_Serveur = InetAddress.getByName("lagh-univ.dz"); 
        System.out.println("L'adresse de l'université de Laghouat = " 
            + Adresse_Serveur.getHostAddress());
      
        // Renvoi les adresses du serveurs Google
        InetAddress[] Adresses_Serveurs = InetAddress.getAllByName("google.com");
        System.out.println("Les adresses du Google : ");
        for (int i = 0; i < Adresses_Serveurs.length; i++)
            System.out.println("     " + Adresses_Serveurs[i].getHostAddress());
      }
      catch (Exception e) {
        e.printStackTrace();    
      }
  }
}
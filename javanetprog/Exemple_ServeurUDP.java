//Exepmple_ServeurUDP.java

import java.io.*;
import java.net.*;

public class Exemple_ServeurUDP {

  final static int port = 9632;
  final static int taille = 1024;
  static byte buffer[] = new byte[taille];

  public static void main(String argv[]) throws Exception {
    DatagramSocket socket = new DatagramSocket(port);

    System.out.println("Lancement du serveur");
    while (true) {
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
    }
  }
}
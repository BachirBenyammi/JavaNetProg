//Exepmple_ClientUDP.java

import java.io.*;
import java.net.*;

public class Exemple_ClientUDP {

  final static int port = 9632;
  final static int taille = 1024;
  static byte buffer[] = new byte[taille];

  public static void main(String argv[]) throws Exception {
    try {
      InetAddress serveur = InetAddress.getByName(argv[0]);
      int length = argv[1].length();
      byte buffer[] = argv[1].getBytes();
      DatagramSocket socket = new DatagramSocket();
      DatagramPacket donneesEmises = new DatagramPacket(buffer, length, serveur, port);
      DatagramPacket donneesRecues = new DatagramPacket(new byte[taille], taille);

      socket.send(donneesEmises);
      socket.receive(donneesRecues);

      System.out.println("Message : " + new String(donneesRecues.getData(), 
        0, donneesRecues.getLength()));
      System.out.println("de : " + donneesRecues.getAddress() + ":" + 
        donneesRecues.getPort());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
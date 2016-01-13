// Exemple_ClientTCP.java
import java.net.*;
import java.io.*;

public class Exemple_ClientTCP {
  final static int port = 9632;

  public static void main(String[] args) {

    Socket socket;
    
    try {
      InetAddress serveur = InetAddress.getByName(args[0]);
      socket = new Socket(serveur, port);

      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintStream out = new PrintStream(socket.getOutputStream());

      Console c = System.console();

      String Message = c.readLine(in.readLine());
      out.println(Message);

      System.out.println(in.readLine());
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
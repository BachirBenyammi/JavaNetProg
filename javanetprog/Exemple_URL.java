// c
import java.net.*;

public class Exemple_URL {
    public static void main(String[] args) {
        URL pageURL = null;
        try { 
            pageURL = new URL("http://localhost:80/fichiers/teste.txt");
System.out.println("Protocole : " + pageURL.getProtocol ()); 
System.out.println("Hôte : " + pageURL.getHost ());
System.out.println("Port : "  + pageURL.getPort ());
System.out.println("Fichier : "  + pageURL.getFile ());
        } 
        catch (MalformedURLException e) {
            e.printStackTrace();    
        } 
    }
}
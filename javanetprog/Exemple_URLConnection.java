// Exemple_URLConnection.java
import java.net.*;
import java.io.*;

public class Exemple_URLConnection {

    public static void main(String[] args) {
        try {
            URL monURL = new URL("http://localhost/fichiers/teste.txt");
                        
            // Ouvrir la connexion et le flux de données
            URLConnection connexion = monURL.openConnection();
            InputStream flux = connexion.getInputStream();           

                             // Renvoi la taille
                              int taille = connexion.getContentLength();

            // Affichage du texte
            for(;taille != 0; taille --)
            System.out.print((char)flux.read());

            flux.close();
                        
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
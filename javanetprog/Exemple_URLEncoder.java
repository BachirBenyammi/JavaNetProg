// Exemple_URLEncoder.java

import java.net.*;

public class Exemple_URLEncoder {

    public static void main(String[] args) {
        String url = "http://www.test.fr/images perso/mon image.gif";
        System.out.println(URLEncoder.encode(url));
    }
}

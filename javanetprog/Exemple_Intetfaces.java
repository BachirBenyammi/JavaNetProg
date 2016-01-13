// Exemple_Intetfaces.java
import java.io.*;
import java.net.*;
import java.util.*;
import static java.lang.System.out;

public class Exemple_Intetfaces {
    
     public static void main(String args[]) throws SocketException {
        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(nets))
            displayInterfaceInformation(netint);
    }

    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
        out.printf("Nom court: %s\n", netint.getDisplayName());
        out.printf("Désignation: %s\n", netint.getName());
        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
            out.printf("Adresse IP %s\n", inetAddress);
        }
        out.printf("\n");
     }
}

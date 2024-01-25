package pexer1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PreExercise1 {

    public static void main(String[] args) {
        int hostnameNumber = 1;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Host " + hostnameNumber+ " - Enter an IP address or a hostname: ");
            String hostName = scanner.nextLine();

            HostLookup.lookupHost(hostName);

            System.out.print("Search for another IP address/hostname [y/n]? ");
            String response = scanner.nextLine().toLowerCase();
            hostnameNumber++;

            if (!response.equals("y")) {
                break;
            }
        }
            System.out.println("Program exited.");
    }
}

    class HostLookup {
    static void lookupHost(String hostName) {
        try {
            InetAddress[] addresses = InetAddress.getAllByName(hostName);

            System.out.println("Number of Hosts/IPs: " + addresses.length);
            System.out.println("Host name\tIP Address");
            for (InetAddress address : addresses) {
                System.out.println(hostName + "\t" + address.getHostAddress());

                }

            } catch (UnknownHostException e) {
                System.out.println("Error: Unknown Host");
        }
    }
}
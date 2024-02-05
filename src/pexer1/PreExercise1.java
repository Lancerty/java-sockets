package pexer1;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PreExercise1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Type an IP address or hostname: ");
            String hostName = scanner.nextLine();

            lookupHost(hostName);

            System.out.print("Search another IP address/hostname [y/n]? ");
            String response = scanner.nextLine().trim().toLowerCase();

            while (!response.equals("y") && !response.equals("n")) {
                System.out.print("Invalid input. Please enter 'y' or 'n': ");
                response = scanner.nextLine().trim().toLowerCase();
            }

            if (response.equals("n")) {
                break;
            }
        }
        System.out.println("Program exited.");
    }

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

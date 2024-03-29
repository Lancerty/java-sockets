package pexer2;  // Assuming the package name is "pexer2"

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PreExercise2 {

    public static void main(String[] args) {
        int port = 2000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running...");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();

                // Start a new thread to handle the client
                Thread clientThread = new Thread(() -> handleClient(clientSocket));
                clientThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
                BufferedReader streamRdr = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter streamWtr = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            // server sends message to client
            streamWtr.println("What is your name? ");
            // server accepts input from client
            String name = streamRdr.readLine();

            int age;
            while (true) {
                streamWtr.println("What is your age? ");
                try {
                    age = Integer.parseInt(streamRdr.readLine());
                    if (age <= 0) {
                        throw new NumberFormatException();
                    } else {
                        break;
                    }
                } catch (NumberFormatException nfe) {
                    // println method will auto flush
                    streamWtr.println("Please enter a valid age.");
                    continue;
                }
            }

            if (age >= 18) {
                streamWtr.println(name + ", you may exercise your right to vote!");
            } else {
                streamWtr.println(name + ", you are still too young to vote!");
            }

            streamWtr.println("Thank you and good day.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
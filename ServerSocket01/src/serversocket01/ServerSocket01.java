/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serversocket01;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santambrogio.lorenzo
 */
public class ServerSocket01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            boolean fine = false;
            String messaggio;
            while (!fine) {
                messaggio = in.readLine();
                if (messaggio.equals("fine")) {
                    fine = true;
                }
                out.println(messaggio.toUpperCase());
            }            
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerSocket01.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

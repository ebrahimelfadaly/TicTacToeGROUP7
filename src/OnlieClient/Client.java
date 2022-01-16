/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlieClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class Client extends Thread {
    private DataInputStream dis;
    private DataOutputStream dos;
    private Socket socket;
    static Client client;
    public Client()
    {
        try {
            socket=new Socket("127.0.0.1",5005);
            dis=new DataInputStream(socket.getInputStream());
            dos=new DataOutputStream(socket.getOutputStream());
                     } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     public static Client getClient() throws IOException
    {
        if(client==null)
        {
           client=new Client(); 
        }
        return client;
    }
     public void sendMessage(String msg) throws IOException {
        dos.writeUTF(msg);
        dos.flush();
    }
     public void login(String username,String password) throws IOException {
        dos.writeUTF("IN."+username+"."+password);
        dos.flush();
    }

    public String readResponse() throws IOException {
        return dis.readUTF();
    }
    public void closeConnection() throws IOException {
            dis.close();
            dos.close();
            socket.close();
    }
     public boolean isConnected() {
        return socket != null && socket.isConnected();
    }
     public int isReading(){
          int response = 0;
        try {
            response = socket.getInputStream().read();
        } catch (IOException ex) {
            closeClient();
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
     }
      public void closeClient() {
        try {
            dos.close();
            dis.close();
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}

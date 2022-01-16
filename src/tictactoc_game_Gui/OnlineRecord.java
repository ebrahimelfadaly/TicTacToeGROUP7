/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoc_game_Gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author asus
 */
public class OnlineRecord {
    public static FileInputStream lowInput;
    public static FileOutputStream lowOut;
    public static DataInputStream highInput;
    public static DataOutputStream highOutput;
    public OnlineRecord(){}
    public static void writeOnlineGameSteps(File onlinelFile, String dataonline, String player1, int scoreP1, String player2, int scoreP2, LinkedHashMap<Integer, String> moves, String winner)
    {
        try {
            lowOut = new FileOutputStream(onlinelFile);
            highOutput = new DataOutputStream(lowOut);
            LocalDateTime ldf = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDateTime = ldf.format(formatter);
            dataonline += formatDateTime+","+player1+","+ scoreP1+","+ player2+","+ scoreP2+","+winner+"," ;
            
            for(int key: moves.keySet())
            {
                dataonline += key+","+ moves.get(key)+",";
            }
            dataonline += "/n";
            System.out.println("inside write local game"+dataonline);
            highOutput.writeUTF(dataonline);
            lowOut.close();
            highOutput.close();
            
        } catch (IOException ex) {
            Logger.getLogger(LocalDBRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//emd writeLocalGameSteps
    //kl
    
    
    
    
   public static String readOnlineFile(File onlinelFile)
    { 
        String dataFromFile= "";
        try {
            if(onlinelFile.length() >2)
            {
                lowInput = new FileInputStream(onlinelFile);
                highInput = new DataInputStream(lowInput);
                dataFromFile = highInput.readUTF();
                lowInput.close();
                lowInput.close();
            }
                                                         
            
        } catch (IOException ex) {
            Logger.getLogger(LocalDBRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataFromFile;
    }// end dataFromFile
   //read all date from local file
    public static String [] readOnlineGameDateTime(File onlinelFile)
    {
        String dataOfTime = "";
        if(onlinelFile.length() >5)
        {
            try {
                lowInput = new FileInputStream(onlinelFile);
                highInput = new DataInputStream(lowInput);
                dataOfTime = highInput.readUTF();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LocalDBRecord.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LocalDBRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String [] allDate = dataOfTime.split("/n", dataOfTime.length());
        String [] allTimes = new String[allDate.length];
        for(int x =0; x <allDate.length; x++)
        {
            String []oneDate = allTimes[x].split(",", dataOfTime.length());
            allTimes [x]= oneDate[0];
        }
        
        
        return allTimes;
    }// end readLocalGameDateTime
    public static void fillMap(LinkedHashMap<Integer, String> moves, JButton [] arr)
    {
        for(int x = 0; x <arr.length; x++)
        {
           String empty=arr[x].getText();
            System.out.println(x+" "+arr[x].getText());
            if(empty.equalsIgnoreCase(""))
            {
                moves.put(x, arr[x].getText());
            }
            
        }
    }
      public static void fillTabel(JTable table, File onlinelFile, String dataonline)
    {
        
            
            String [] all = dataonline.split("/n");
            System.out.println("\n all insind"+all[0]+"\n length of all :" + all.length);
            System.out.println("inside the fill table method");
            for(int x = 0 ; x <all.length ; x++)
            {
                
                System.out.println("inside the first for");
                String [] parts = all[x].split(",");
                //System.out.println(parts[0]);
                
           
                System.out.println("inside the second for\n");
                table.setValueAt(parts[0],x, 0);
                table.setValueAt(parts[1],x, 1);
                table.setValueAt(parts[2],x, 2);
                table.setValueAt(parts[3],x, 3);
                table.setValueAt(parts[4],x, 4);
                table.setValueAt(parts[5],x, 5);
            
            }
            
        
        
    }
    
}

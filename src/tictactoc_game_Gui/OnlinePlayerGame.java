/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoc_game_Gui;
import OnlieClient.Client;
import helpersClass.ClientBaseClass;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import static tictactoc_game_Gui.OnlineRecord.readOnlineFile;

/**
 *
 * @author Fady
 */

public class OnlinePlayerGame extends javax.swing.JFrame {
public int scoreX;
    Client client;
public int scoreO;
public int tieScore;
public static File onlinefile;
public static  String dataOnline;
boolean record = false;
 String winner ="";
 String Player1;
 String Player2;
 String flag = "X";
    public static JButton [] arr = new JButton[9];
    static int pos;
    static String btn;
    Icon x_icon;
    Icon o_icon;
    
    LinkedHashMap<Integer, String> moves = new LinkedHashMap<>();
    /**
     * Creates new form TwoPlayerGame
     */
    
    ClientBaseClass clientBaseClass;
    public OnlinePlayerGame() {
        initComponents();
        
        
        arr[0] = btn0;
        arr[1] = btn1;
        arr[2] = btn2;
        arr[3] = btn3;
        arr[4] = btn4;
        arr[5] = btn5;
        arr[6] = btn6;
        arr[7] = btn7;
        arr[8] = btn8;
        
        scoreO=0;
        scoreX=0;
       tieScore=0;
        


        x_icon = new ImageIcon("C:\\Users\\asus\\Documents\\NetBeansProjects\\TicTacToc_Game\\src\\ui\\xIcon.png", "x");
        o_icon = new ImageIcon("C:\\Users\\asus\\Documents\\NetBeansProjects\\TicTacToc_Game\\src\\ui\\oIcon.png", "o");
       try {
            
            onlinefile = new File("onlinePlayer4.txt");
            if(onlinefile.createNewFile())
            {
                System.out.println("file created "+ onlinefile.getName()+ onlinefile.getPath());
            }
            else
            {
                System.out.println("the file is already existed");
            }
            System.out.println("length: "+ onlinefile.length());
             
        } catch (IOException ex) {
            Logger.getLogger(OnlineRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
       jplayer1.setText(LoginForm.Username);
       jplayer2.setText(LoginForm.Username);
       Player1=jplayer1.getText();
       Player2=jplayer2.getText();
       
      
       
       game.setVisible(false);
       clientBaseClass = new ClientBaseClass(new ArrayList(Arrays.asList(arr))){
            @Override
            public void onWin() {
                
                super.onWin();
                scoreX++;
                  
                if(record)
                {
                   winner= clientBaseClass.winnerSymbole;
                    recordGame();
                  OnlineRecord.writeOnlineGameSteps(onlinefile, dataOnline ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
                //viedo
                jLabelscorex.setText(scoreX+"");
                win w=new win();
                w.setVisible(true);
                
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onLose() {
                super.onLose();
                scoreO++;
                
                if(record)
                {
                   winner= clientBaseClass.winnerSymbole;
                    recordGame();
                    jLabelscore0.setText(scoreO+"");
                   OnlineRecord.writeOnlineGameSteps(onlinefile, dataOnline ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
                 lose l=new lose();
            l.setVisible(true);
                //viedo
                
                
                
                
                 //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onDraw() {
             
                super.onDraw();
                  JOptionPane.showMessageDialog(OnlinePlayerGame.this, "game tie");
                  tieScore++;
                winner=clientBaseClass.TIE;
                if(record)
                {
                   winner= clientBaseClass.winnerSymbole;
                    recordGame();
                    OnlineRecord.writeOnlineGameSteps(onlinefile, dataOnline ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
            }
            
             @Override
            public void onFinsh() {
                super.onFinsh(); 
                
            }

            @Override
            public void onLetsPlay() {
                super.onLetsPlay();
                game.setVisible(true);
            }

            @Override
            public void onSelect(JButton button, String symbole) {
                super.onSelect(button, symbole);
                
                if(symbole .equals(ClientBaseClass.X))
                { 
                   
                     button.setIcon(x_icon);
                     
                }
                else
                 
                {
                    
                    button.setIcon(o_icon);
                }
                if(button.equals(btn0))
                {
                moves.put(0,symbole);
                arr[0]=button;
                }
                     
                if(button.equals(btn1))
                    {
                moves.put(1,symbole);
                arr[1]=button;
                }
                 if(button.equals(btn2))
                    {
                moves.put(2,symbole);
                arr[2]=button;
                }
                  if(button.equals(btn3))
                    {
                moves.put(3,symbole);
                arr[3]=button;
                }
                   if(button.equals(btn4))
                    {
                moves.put(4,symbole);
                arr[4]=button;
                }
                    if(button.equals(btn5))
                     {
                moves.put(5,symbole);
                arr[5]=button;
                }
                     if(button.equals(btn6))
                     {
                moves.put(6,symbole);
                arr[6]=button;
                }
                      if(button.equals(btn7))
                    {
                moves.put(7,symbole);
                arr[7]=button;
                }
                       if(button.equals(btn8))
                    {
                moves.put(8,symbole);
                arr[8]=button;
                }
                
                 System.out.println(0+symbole);
                
                    
//                symbole == ClientBaseClass.X
//                symbole == ClientBaseClass.O
          System.out.println(symbole);
            }
            

        };
       
       
    }
       
       
    public void recordGame()
    {
     
            System.out.println("inside");
            OnlineRecord.fillMap(moves, arr);
            jrecord.setText("Record game");
            jrecord.setBackground(Color.GREEN);
            record = false;
            dataOnline = readOnlineFile(onlinefile);
            System.out.println(dataOnline+"the line inside recordGame");
        
        
    }
    
    
    
/*
    public void getTheWinnter() {
        boolean win = false;
       //first row
        if (!(btn0.getIcon() == null) && btn0.getIcon().equals(btn1.getIcon()) && btn1.getIcon().equals(btn2.getIcon())) {
          if(btn0.getIcon().equals(x_icon)){
              scoreX++;
            jLabelscorex.setText(scoreX+"");
            winner="x";
            JOptionPane.showMessageDialog(this, "X Winer");//video
            if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
           
          }
         else{
               scoreO++;
            jLabelscore0.setText(scoreO+"");
             winner="o";
              JOptionPane.showMessageDialog(this, "O Winer");
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
         
          }
           win = true;
         }
          
         //second row 
        if (!(btn3.getIcon() == null) && btn3.getIcon().equals(btn4.getIcon()) && btn4.getIcon().equals(btn5.getIcon())) {
           if(btn3.getIcon().equals(x_icon)){
               scoreX++;
               winner="x";
            jLabelscorex.setText(scoreX+"");
            JOptionPane.showMessageDialog(this, "X Winer");
            if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
             
        
           }
        else{
                scoreO++;
            jLabelscore0.setText(scoreO+"");
            
              JOptionPane.showMessageDialog(this, "O Winer");
              winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
           }
           win = true;
        }
        //third row
          if (!(btn6.getIcon() == null) && btn6.getIcon().equals(btn7.getIcon()) && btn7.getIcon().equals(btn8.getIcon())) {
           if(btn6.getIcon().equals(x_icon)){
               scoreX++;
            jLabelscorex.setText(scoreX+"");
            JOptionPane.showMessageDialog(this, "X Winer");
            winner="x";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
             
            
          }
         else{
                scoreO++;
            jLabelscore0.setText(scoreO+"");
              JOptionPane.showMessageDialog(this, "O Winer");
              winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
            
          }
          win = true;
        }
          //frist coloum
           if (!(btn0.getIcon() == null) && btn0.getIcon().equals(btn3.getIcon()) && btn3.getIcon().equals(btn6.getIcon())) {
            if(btn0.getIcon().equals(x_icon)){
                scoreX++;
            jLabelscorex.setText(scoreX+"");
            JOptionPane.showMessageDialog(this, "X Winer");
            winner="x";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
            
         
            }
        else{
                 scoreO++;
            jLabelscore0.setText(scoreO+"");
              JOptionPane.showMessageDialog(this, "O Winer");
              winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
              
          }
         win = true;
        }
           //second coloum
            if (!(btn1.getIcon() == null) && btn1.getIcon().equals(btn4.getIcon()) && btn4.getIcon().equals(btn7.getIcon())) {
            if(btn1.getIcon().equals(x_icon)){
                scoreX++;
            jLabelscorex.setText(scoreX+"");
            JOptionPane.showMessageDialog(this, "X Winer");
            winner="x";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
            
            
          }
          else{ 
                 scoreO++;
            jLabelscore0.setText(scoreO+"");
                JOptionPane.showMessageDialog(this, "O Winer");
                winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
     
          }
            win = true;
        }
            //third coloum
             if (!(btn2.getIcon() == null) && btn2.getIcon().equals(btn5.getIcon()) && btn5.getIcon().equals(btn8.getIcon())) {
           if(btn2.getIcon().equals(x_icon)){
               scoreX++;
            jLabelscorex.setText(scoreX+"");
            JOptionPane.showMessageDialog(this, "X Winer");
            winner="x";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
            
           
          }
          else{
                scoreO++;
            jLabelscore0.setText(scoreO+"");
               JOptionPane.showMessageDialog(this, "O Winer");
               winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
    
          }
           win = true;
        }
             //first diag
              if (!(btn0.getIcon() == null) && btn0.getIcon().equals(btn4.getIcon()) && btn4.getIcon().equals(btn8.getIcon())) {
           if(btn0.getIcon().equals(x_icon)){
               scoreX++;
            jLabelscorex.setText(scoreX+"");
            JOptionPane.showMessageDialog(this, "X Winer");
            winner="x";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
             
          
          }
         else{
                scoreO++;
            jLabelscore0.setText(scoreO+"");
              JOptionPane.showMessageDialog(this, "O Winer");
              winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
             
          }
            win = true;
        }
              //second diag
               if (!(btn2.getIcon() == null) && btn2.getIcon().equals(btn4.getIcon()) && btn4.getIcon().equals(btn6.getIcon())) {
           if(btn2.getIcon().equals(x_icon)){
               scoreX++;
            jLabelscorex.setText(scoreX+"");
            JOptionPane.showMessageDialog(this, "X Winer");
            winner="x";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
             
          
          }
          else{
                scoreO++;
            jLabelscore0.setText(scoreO+"");
              JOptionPane.showMessageDialog(this, "O Winer");
              winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
              
          }
           win = true;
          
        }
               else if(!(btn0.getIcon() == null)&&!(btn1.getIcon() == null)&&!(btn2.getIcon() == null)&&!(btn3.getIcon() == null)
                       &&!(btn4.getIcon() == null)&&!(btn5.getIcon() == null)&&!(btn6.getIcon() == null)
                       &&!(btn7.getIcon() == null)&&!(btn8.getIcon() == null)&&win==false){
                JOptionPane.showMessageDialog(this, "Tie");
                winner="tie";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(onlinefile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
               }
    }
   

    int x_or_o = 0;
     

    public ActionListener creatAction(JButton button) {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.getIcon() == null) {
                    if ((x_or_o % 2) == 0) {
                        button.setIcon(x_icon);
                        button.setText(flag);
                        flag="O";
                        
                        getTheWinnter();
                    } else {
                        button.setIcon(o_icon);
                        
                        button.setText(flag);
                        flag = "X";
                        getTheWinnter();
                    }
                    x_or_o++;
                }
            }

        };
        return al;
    }
    

    public void addAction() {
        Component[] comps = game.getComponents();
        for (Component comp : comps) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                button.addActionListener(creatAction(button));
            }
        }
    }
    */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        game = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        jplayer1 = new javax.swing.JLabel();
        jLabelscorex = new javax.swing.JLabel();
        jplayer2 = new javax.swing.JLabel();
        jLabelscore0 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jrecord = new javax.swing.JButton();
        jreplay = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        watingScreen = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        game.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/back.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        game.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        btn0.setBackground(new java.awt.Color(204, 255, 255));
        btn0.setBorder(null);
        btn0.setBorderPainted(false);
        btn0.setContentAreaFilled(false);
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        game.add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, 80));

        btn1.setBackground(new java.awt.Color(204, 255, 255));
        btn1.setBorder(null);
        btn1.setBorderPainted(false);
        btn1.setContentAreaFilled(false);
        game.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 130, 80));

        btn2.setBackground(new java.awt.Color(204, 255, 255));
        btn2.setBorder(null);
        btn2.setBorderPainted(false);
        btn2.setContentAreaFilled(false);
        game.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 120, 90));

        btn3.setBackground(new java.awt.Color(204, 255, 255));
        btn3.setBorder(null);
        btn3.setBorderPainted(false);
        btn3.setContentAreaFilled(false);
        game.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 100, 130));

        btn4.setBackground(new java.awt.Color(204, 255, 255));
        btn4.setBorder(null);
        btn4.setBorderPainted(false);
        btn4.setContentAreaFilled(false);
        game.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 120, 110));

        btn5.setBackground(new java.awt.Color(204, 255, 255));
        btn5.setBorder(null);
        btn5.setBorderPainted(false);
        btn5.setContentAreaFilled(false);
        game.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 110, 120));

        btn6.setBackground(new java.awt.Color(204, 255, 255));
        btn6.setBorder(null);
        btn6.setBorderPainted(false);
        btn6.setContentAreaFilled(false);
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        game.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 110, 120));

        btn7.setBackground(new java.awt.Color(204, 255, 255));
        btn7.setBorder(null);
        btn7.setBorderPainted(false);
        btn7.setContentAreaFilled(false);
        game.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 140, 140));

        btn8.setBackground(new java.awt.Color(204, 255, 255));
        btn8.setBorder(null);
        btn8.setBorderPainted(false);
        btn8.setContentAreaFilled(false);
        game.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 120, 120));

        jplayer1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jplayer1.setForeground(new java.awt.Color(255, 255, 255));
        jplayer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/user.png"))); // NOI18N
        jplayer1.setText("Player 1");
        game.add(jplayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, 50));

        jLabelscorex.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelscorex.setForeground(new java.awt.Color(255, 255, 255));
        jLabelscorex.setText(" 0");
        game.add(jLabelscorex, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 40, -1));

        jplayer2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jplayer2.setForeground(new java.awt.Color(255, 255, 255));
        jplayer2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/user.png"))); // NOI18N
        jplayer2.setText("Player 2");
        game.add(jplayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 140, 50));

        jLabelscore0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelscore0.setForeground(new java.awt.Color(255, 255, 255));
        jLabelscore0.setText("0");
        game.add(jLabelscore0, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 40, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/VS.png"))); // NOI18N
        game.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jrecord.setForeground(new java.awt.Color(255, 255, 255));
        jrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/record.png"))); // NOI18N
        jrecord.setBorder(null);
        jrecord.setBorderPainted(false);
        jrecord.setContentAreaFilled(false);
        jrecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrecordActionPerformed(evt);
            }
        });
        game.add(jrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 60, 50));

        jreplay.setForeground(new java.awt.Color(255, 255, 255));
        jreplay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/replay.png"))); // NOI18N
        jreplay.setBorder(null);
        jreplay.setBorderPainted(false);
        jreplay.setContentAreaFilled(false);
        jreplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jreplayActionPerformed(evt);
            }
        });
        game.add(jreplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 50, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/gameBoard.png"))); // NOI18N
        game.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 600));

        getContentPane().add(game, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        watingScreen.setBackground(new java.awt.Color(255, 255, 255));
        watingScreen.setForeground(new java.awt.Color(255, 255, 255));
        watingScreen.setPreferredSize(new java.awt.Dimension(500, 600));
        watingScreen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 204, 255));
        jLabel2.setText("WAITING FOR ANOTHER PLAYER.......");
        watingScreen.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 450, 160));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoc_game_Gui/gamePlayBg.png"))); // NOI18N
        watingScreen.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(watingScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       
       GamePlayMenu gamemainmenu = new GamePlayMenu();
              gamemainmenu.setVisible(true);
                   gamemainmenu.pack();
                   gamemainmenu.setLocationRelativeTo(null);
                   this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void jrecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrecordActionPerformed
        // TODO add your handling code here:
        record = true;
       jrecord.setText("Recording");
       jrecord.setBackground(Color.red);
    }//GEN-LAST:event_jrecordActionPerformed

    private void jreplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jreplayActionPerformed
        // TODO add your handling code here:
       HistoryTabelOnline s = new HistoryTabelOnline();
        dataOnline = readOnlineFile(onlinefile);
        System.out.println("\n inside the history btn"+dataOnline+"\n");
        s.method(onlinefile, dataOnline);
        s.setVisible(true);
        s.setDefaultCloseOperation(2);
    }//GEN-LAST:event_jreplayActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OnlinePlayerGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OnlinePlayerGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OnlinePlayerGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OnlinePlayerGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OnlinePlayerGame().setVisible(true);
                

            }
        });
      
                    
                   
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel game;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelscore0;
    private javax.swing.JLabel jLabelscorex;
    private javax.swing.JLabel jplayer1;
    private javax.swing.JLabel jplayer2;
    private javax.swing.JButton jrecord;
    private javax.swing.JToggleButton jreplay;
    private javax.swing.JPanel watingScreen;
    // End of variables declaration//GEN-END:variables
}

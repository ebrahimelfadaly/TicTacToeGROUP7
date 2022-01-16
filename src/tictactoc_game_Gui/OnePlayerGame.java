/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoc_game_Gui;
import OnlieClient.Client;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import static tictactoc_game_Gui.LocalDBRecord.readLocalFile;

/**
 *
 * @author Fady
 */

public class OnePlayerGame extends javax.swing.JFrame {
Client client;

public static File localFile;
public static  String dataLocl;
public int scoreX;
public int scoreO;
public int tiescore;
boolean record = false;
 String winner ="";
 String Player1;
 String Player2;
 LinkedHashMap<Integer, String> moves = new LinkedHashMap<>();
    JButton [] arr = new JButton[9];
    String flag="X";
     Icon x_icon;
    Icon o_icon;
    
    
    /**
     * Creates new form TwoPlayerGame
     */
    public OnePlayerGame() {
        initComponents();
        addAction();
        scoreO=0;
        scoreX=0;
        tiescore=0;
        arr[0] = btn0;
        arr[1] = btn1;
        arr[2] = btn2;
        arr[3] = btn3;
        arr[4] = btn4;
        arr[5] = btn5;
        arr[6] = btn6;
        arr[7] = btn7;
        arr[8] = btn8;
        for(int i=0; i<arr.length ; i++){
            arr[i].setName(""+i);
        }
        
        x_icon = new ImageIcon("C:\\Users\\asus\\Documents\\NetBeansProjects\\TicTacToc_Game\\src\\ui\\xIcon.png", "x");
        o_icon = new ImageIcon("C:\\Users\\asus\\Documents\\NetBeansProjects\\TicTacToc_Game\\src\\ui\\oIcon.png", "o");
       try {
            
            localFile = new File("localplayer3.txt");
            if(localFile.createNewFile())
            {
                System.out.println("file created "+ localFile.getName()+ localFile.getPath());
            }
            else
            {
                System.out.println("the file is already existed");
            }
            System.out.println("length: "+ localFile.length());
             
        } catch (IOException ex) {
            Logger.getLogger(LocalDBRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
       jplayer1.setText(LoginForm.Username);
       Player1=jplayer1.getText();
       Player2=jplayer2.getText();
    }
    public void recordGame()
    {
     
            System.out.println("inside");
            LocalDBRecord.fillMap(moves, arr);
            jrecord.setText("Record game");
            jrecord.setBackground(Color.GREEN);
            record = false;
            dataLocl = readLocalFile(localFile);
            System.out.println(dataLocl+"the line inside recordGame");
        
         
    }
     public void choose_player()
    {
        if(flag.equalsIgnoreCase("X"))
        {
            flag = "O";
           
        }else
        {
            flag = "X";
         
        }
    }

    public void getTheWinnter() {
        boolean win = false;
       //first row
        if (!(btn0.getIcon() == null) && btn0.getIcon().equals(btn1.getIcon()) && btn1.getIcon().equals(btn2.getIcon())) {
          if(btn0.getIcon().equals(x_icon)){
              scoreX++;
            jLabelscorex.setText(scoreX+"");
            winner="x";
             win w=new win();
              w.setVisible(true);
            if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
           
          }
         else{
               scoreO++;
            jLabelscore0.setText(scoreO+"");
             winner="o";
             lose l=new lose();
            l.setVisible(true);
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
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
             win w=new win();
              w.setVisible(true);
            if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
             
        
           }
        else{
                scoreO++;
            jLabelscore0.setText(scoreO+"");
            
              lose l=new lose();
            l.setVisible(true);
              winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
           }
           win = true;
        }
        //third row
          if (!(btn6.getIcon() == null) && btn6.getIcon().equals(btn7.getIcon()) && btn7.getIcon().equals(btn8.getIcon())) {
           if(btn6.getIcon().equals(x_icon)){
               scoreX++;
            jLabelscorex.setText(scoreX+"");
           win w=new win();
              w.setVisible(true);
            winner="x";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
             
            
          }
         else{
                scoreO++;
            jLabelscore0.setText(scoreO+"");
              lose l=new lose();
            l.setVisible(true);
              winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
            
          }
          win = true;
        }
          //frist coloum
           if (!(btn0.getIcon() == null) && btn0.getIcon().equals(btn3.getIcon()) && btn3.getIcon().equals(btn6.getIcon())) {
            if(btn0.getIcon().equals(x_icon)){
                scoreX++;
            jLabelscorex.setText(scoreX+"");
            win w=new win();
              w.setVisible(true);
            winner="x";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
         
            }
        else{
                 scoreO++;
            jLabelscore0.setText(scoreO+"");
               lose l=new lose();
            l.setVisible(true);
              winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
              
          }
         win = true;
        }
           //second coloum
            if (!(btn1.getIcon() == null) && btn1.getIcon().equals(btn4.getIcon()) && btn4.getIcon().equals(btn7.getIcon())) {
            if(btn1.getIcon().equals(x_icon)){
                scoreX++;
            jLabelscorex.setText(scoreX+"");
            win w=new win();
              w.setVisible(true);
            winner="x";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
            
            
          }
          else{ 
                 scoreO++;
            jLabelscore0.setText(scoreO+"");
                lose l=new lose();
            l.setVisible(true);
                winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
     
          }
            win = true;
        }
            //third coloum
             if (!(btn2.getIcon() == null) && btn2.getIcon().equals(btn5.getIcon()) && btn5.getIcon().equals(btn8.getIcon())) {
           if(btn2.getIcon().equals(x_icon)){
               scoreX++;
            jLabelscorex.setText(scoreX+"");
           win w=new win();
              w.setVisible(true);
            winner="x";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
            
           
          }
          else{
                scoreO++;
            jLabelscore0.setText(scoreO+"");
               lose l=new lose();
            l.setVisible(true);
               winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
    
          }
           win = true;
        }
             //first diag
              if (!(btn0.getIcon() == null) && btn0.getIcon().equals(btn4.getIcon()) && btn4.getIcon().equals(btn8.getIcon())) {
           if(btn0.getIcon().equals(x_icon)){
               scoreX++;
            jLabelscorex.setText(scoreX+"");
             win w=new win();
              w.setVisible(true);
            winner="x";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
             
          
          }
         else{
                scoreO++;
            jLabelscore0.setText(scoreO+"");
              lose l=new lose();
            l.setVisible(true);
              winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
             
          }
            win = true;
        }
              //second diag
               if (!(btn2.getIcon() == null) && btn2.getIcon().equals(btn4.getIcon()) && btn4.getIcon().equals(btn6.getIcon())) {
           if(btn2.getIcon().equals(x_icon)){
               scoreX++;
            jLabelscorex.setText(scoreX+"");
         win w=new win();
              w.setVisible(true);
            winner="x";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
             
          
          }
          else{
                scoreO++;
            jLabelscore0.setText(scoreO+"");
             lose l=new lose();
            l.setVisible(true);
              winner="o";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
              
          }
           win = true;
          
        }
               else if(!(btn0.getIcon() == null)&&!(btn1.getIcon() == null)&&!(btn2.getIcon() == null)&&!(btn3.getIcon() == null)
                       &&!(btn4.getIcon() == null)&&!(btn5.getIcon() == null)&&!(btn6.getIcon() == null)
                       &&!(btn7.getIcon() == null)&&!(btn8.getIcon() == null)&&win==false){
                JOptionPane.showMessageDialog(this, "Tie");
                
                 tiescore++;
                winner="tie";
              if(record)
                {
                    
                    recordGame();
                    LocalDBRecord.writeLocalGameSteps(localFile, dataLocl ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
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
                       
                        button.setText("X");
                        moves.put(Integer.parseInt(button.getName()), "X");
                        getTheWinnter();
                    } else {
                        button.setIcon(o_icon);
                       
                        button.setText("O");
                         moves.put(Integer.parseInt(button.getName()), "O");
                        getTheWinnter();
                    }
                    x_or_o++;
                }
            }

        };
        return al;
    }

    public void addAction() {
        Component[] comps = jPanel1.getComponents();
        for (Component comp : comps) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                button.addActionListener(creatAction(button));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/back.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/reset.png"))); // NOI18N
        btnReset.setBorder(null);
        btnReset.setBorderPainted(false);
        btnReset.setContentAreaFilled(false);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 60, 50));

        btn0.setBorder(null);
        btn0.setBorderPainted(false);
        btn0.setContentAreaFilled(false);
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        jPanel1.add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 110, 80));

        btn1.setBorder(null);
        btn1.setBorderPainted(false);
        btn1.setContentAreaFilled(false);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 130, 80));

        btn2.setBorder(null);
        btn2.setBorderPainted(false);
        btn2.setContentAreaFilled(false);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 120, 90));

        btn3.setBorder(null);
        btn3.setBorderPainted(false);
        btn3.setContentAreaFilled(false);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 100, 130));

        btn4.setBorder(null);
        btn4.setBorderPainted(false);
        btn4.setContentAreaFilled(false);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 120, 110));

        btn5.setBorder(null);
        btn5.setBorderPainted(false);
        btn5.setContentAreaFilled(false);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel1.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 110, 120));

        btn6.setBorder(null);
        btn6.setBorderPainted(false);
        btn6.setContentAreaFilled(false);
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel1.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 110, 120));

        btn7.setBorder(null);
        btn7.setBorderPainted(false);
        btn7.setContentAreaFilled(false);
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel1.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 140, 140));

        btn8.setBorder(null);
        btn8.setBorderPainted(false);
        btn8.setContentAreaFilled(false);
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel1.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 120, 120));

        jplayer1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jplayer1.setForeground(new java.awt.Color(255, 255, 255));
        jplayer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/user.png"))); // NOI18N
        jplayer1.setText("Player x");
        jPanel1.add(jplayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, 50));

        jLabelscorex.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelscorex.setForeground(new java.awt.Color(255, 255, 255));
        jLabelscorex.setText(" 0");
        jPanel1.add(jLabelscorex, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 40, -1));

        jplayer2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jplayer2.setForeground(new java.awt.Color(255, 255, 255));
        jplayer2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/user.png"))); // NOI18N
        jplayer2.setText("Player O");
        jPanel1.add(jplayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 140, 50));

        jLabelscore0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelscore0.setForeground(new java.awt.Color(255, 255, 255));
        jLabelscore0.setText("0");
        jPanel1.add(jLabelscore0, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 40, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/VS.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        jrecord.setForeground(new java.awt.Color(255, 255, 255));
        jrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/record.png"))); // NOI18N
        jrecord.setBorder(null);
        jrecord.setBorderPainted(false);
        jrecord.setContentAreaFilled(false);
        jrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jrecordMouseClicked(evt);
            }
        });
        jrecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrecordActionPerformed(evt);
            }
        });
        jPanel1.add(jrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 50, 50));

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
        jPanel1.add(jreplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 60, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/gameBoard.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        // TODO add your handling code here:
     //   String x=arr[0].getText();
      // moves.put(0,x);
      // System.out.println(x+"0");
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       
   
      /*
         try {
        client=Client.getClient();
        
        String x=scoreX+"";
        String o=scoreO+"";
        String t=tiescore+"";
        int l=scoreO+scoreO+tiescore;
        String al=l+"";
        client.sendMessage("SPGAMES."+LoginForm.Username + "."+al + "." +x + "." +o + "." +t );//setprofile
        System.out.println("i am set profile+");
        
        
        String messgChecksUserEntryCases = client.readResponse();
        System.out.println("The message sent from the socket was: " + messgChecksUserEntryCases);
        if (messgChecksUserEntryCases.equalsIgnoreCase("User Invalid")) {
            System.out.println(messgChecksUserEntryCases);
            client.closeClient();
            //JOptionPane.showMessageDialog(null, "Please enter a unique username and a password ");
            
        }
        client.closeClient();
     */
        GamePlayMenu gamemainmenu = new GamePlayMenu();
        gamemainmenu.setVisible(true);
        gamemainmenu.pack();
        gamemainmenu.setLocationRelativeTo(null);
        this.dispose();
    
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        btn0.setIcon(null);
        btn1.setIcon(null);
        btn2.setIcon(null);
        btn3.setIcon(null);
        btn4.setIcon(null);
        btn5.setIcon(null);
        btn6.setIcon(null);
        btn7.setIcon(null);
        btn8.setIcon(null);
        
        x_or_o=0;
        
    }//GEN-LAST:event_btnResetActionPerformed

    private void jrecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrecordActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jrecordActionPerformed

    private void jreplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jreplayActionPerformed
        // TODO add your handling code here:
        HistoryTabel s = new HistoryTabel();
        dataLocl = readLocalFile(localFile);
        System.out.println("\n inside the history btn"+dataLocl+"\n");
        s.method(localFile, dataLocl);
        s.setVisible(true);
        s.setDefaultCloseOperation(2);
    }//GEN-LAST:event_jreplayActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
       //String x=arr[6].getText();
      // moves.put(6,x);
      // System.out.println(x);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
      // String x=arr[1].getText();
      // moves.put(1,x);
      // System.out.println(x);
        
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
      // String x=arr[8].getText();
      // moves.put(8,x);
      // System.out.println(x);
    }//GEN-LAST:event_btn8ActionPerformed

    private void jrecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jrecordMouseClicked
        // TODO add your handling code here:
        record = true;
       jrecord.setText("Recording");
       jrecord.setBackground(Color.red);
    }//GEN-LAST:event_jrecordMouseClicked

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
            java.util.logging.Logger.getLogger(OnePlayerGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OnePlayerGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OnePlayerGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OnePlayerGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OnePlayerGame().setVisible(true);

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
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelscore0;
    private javax.swing.JLabel jLabelscorex;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jplayer1;
    private javax.swing.JLabel jplayer2;
    private javax.swing.JButton jrecord;
    private javax.swing.JToggleButton jreplay;
    // End of variables declaration//GEN-END:variables
}

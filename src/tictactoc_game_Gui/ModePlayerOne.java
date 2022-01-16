/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoc_game_Gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import static tictactoc_game_Gui.SingleDBRecord.readsingleFile;




public class ModePlayerOne extends javax.swing.JFrame {
public static File singleFile;
public static  String dataSingle;
public int scoreX;
public int scoreO;
public int tiescore;
boolean record = false;
 String winner ="";
 String Player1;
 String Player2;
 LinkedHashMap<Integer, String> moves = new LinkedHashMap<>();
    JButton [] arr = new JButton[9];
    private String startGame="X";
  
    boolean checker;
    int turno =1;
    
    Icon x_icon;
    Icon o_icon;
    
    JButton list [] = new JButton [9];
 
    /**
     * Creates new form singleMode
     */

    /**
     * Creates new form singleMode
     */;

    
    public ModePlayerOne() {
        initComponents();
        list[0] = (btn0);
        list[1] = (btn1);
        list[2] = (btn2);
        list[3] = (btn3);
        list[4] = (btn4);
        list[5] = (btn5);
        list[6] = (btn6);
        list[7] = (btn7);
        list[8] = (btn8); 
        scoreO=0;
        scoreX=0;
        tiescore=0;
 
        Computer(); 
    
       x_icon = new ImageIcon("C:\\Users\\asus\\Documents\\NetBeansProjects\\TicTacToc_Game\\src\\ui\\xIcon.png", "x");
        o_icon = new ImageIcon("C:\\Users\\asus\\Documents\\NetBeansProjects\\TicTacToc_Game\\src\\ui\\oIcon.png", "o");
   try {
            
            singleFile = new File("singleplayers1.txt");
            if(singleFile.createNewFile())
            {
                System.out.println("file created "+ singleFile.getName()+ singleFile.getPath());
            }
            else
            {
                System.out.println("the file is already existed");
            }
            System.out.println("length: "+ singleFile.length());
             
        } catch (IOException ex) {
            Logger.getLogger(ModePlayerOne.class.getName()).log(Level.SEVERE, null, ex);
        }
   jplayer1.setText(LoginForm.Username);
       Player1=jplayer1.getText();
       Player2=jcomputer.getText();
    }
     private void gameScore()
     {
        jLabescorex.setText(scoreX+"");
         jLabelscoreo.setText(scoreO+"");
     }
    private void choose_a_Player()
     {
          if(startGame.equalsIgnoreCase("X"))
          {
              startGame = "O";
              
          }
          else
          { 
              startGame = "X";
              
          }    
     }
    public void recordGame()
    {
     
            System.out.println("inside");
            SingleDBRecord.fillMap(moves, list);
            
            record = false;
            dataSingle = readsingleFile(singleFile);
            System.out.println(dataSingle+"the line inside recordGame");
        
        
    }
    
    
    public void winner (){
        
    analysis(btn0,btn1,btn2);
    analysis(btn3,btn4,btn5);
    analysis(btn6,btn7,btn8);
    analysis(btn0,btn3,btn6);
    analysis(btn1,btn4,btn7);
    analysis(btn2,btn5,btn8);
    analysis(btn0,btn4,btn8);
    analysis(btn2,btn4,btn6);
    
    }
    
    public void analysis(JButton B1, JButton B2, JButton B3){
       if (B1.getText() ==  "X" && B2.getText() == "X" && B3.getText() == "X") {
           
          ++scoreO;
           jcomputer.setText(scoreO+"");
           winner=Player2;
           if(record)
                {
                    
                    recordGame();
                    SingleDBRecord.writesingleGameSteps(singleFile, dataSingle ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
            lose l=new lose();
            l.setVisible(true);
            
        } else if (B1.getText() ==  "O" && B2.getText() == "O" && B3.getText() ==  "O") {
            ++scoreX;
             jLabescorex.setText(scoreX+"");
                winner=Player1;
             if(record)
                {
                    
                    recordGame();
                    SingleDBRecord.writesingleGameSteps(singleFile, dataSingle ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
          
              win w=new win();
              w.setVisible(true);
         
        }
    }
    
    public void Computer() {
        if (turno == 1) {
            cpu (btn0, btn1, btn2);    
        }
         if (turno == 1) {
            cpu (btn3, btn4, btn5);    
        }
          if (turno ==1) {
            cpu (btn6, btn7, btn8);    
        }
         if (turno ==1) {
            cpu (btn0, btn3, btn6);
            
        }
          if (turno ==1) {
            cpu (btn1, btn4, btn7);    
        }
          if (turno ==1) {
            cpu (btn2, btn5, btn8);    
        }
          
          if (turno ==1) {
            cpu (btn0, btn4, btn8);    
        }
        
         if (turno ==1) {
            cpu (btn2, btn4, btn6);    
        }
          if (turno ==1) {
            Random rand = new Random();
            int AI;
            
          boolean A = true;
            
            do {
                AI= (int) (rand.nextDouble() * 9 + 1);
                if (list[AI -1].getText() == "") {
                  
                    list[AI -1].setText("X");
                 
                    A = false;
                }
                    
                boards();
            } while(A);
          }
          winner();
    }
    
    
     public void cpu(JButton B1, JButton B2, JButton B3) {
      if(B1.getText() =="O" && B2.getText() == "O" && B3.getText() == ""){
       B3.setText("X");
       turno =2; 
      } else if (B1.getText() =="O" && B2.getText() == "" && B3.getText() == "O"){
       B2.setText("X");
       turno =2; 
      } else if(B1.getText() =="" && B2.getText() == "O" && B3.getText() == "O"){
       B1.setText("X");
       turno =2; 
      }
       if(B1.getText() =="X" && B2.getText() == "X" && B3.getText() == ""){
       B3.setText("X");
       turno =2; 
      } else if (B1.getText() =="X" && B2.getText() == "" && B3.getText() == "X"){
       B2.setText("X");
       turno =2; 
      } else if(B1.getText() =="" && B2.getText() == "X" && B3.getText() == "X"){
       B1.setText("X");
       turno =2; 
      }
    }
    
    public void boards() {
    String one = btn0.getText();
    String two = btn1.getText();
    String three = btn2.getText();
    String four = btn3.getText();
    String five = btn4.getText();
    String six= btn5.getText();
    String seven= btn6.getText();
    String eight = btn7.getText();
    String nine = btn8.getText(); 
    
    if (one!="" && two!="" && three!="" && four!="" && five!="" && six!="" && seven!="" && eight!="" && nine!=""){
        ++tiescore;
      
        winner="Tie";
        if(record)
                {
                    
                    recordGame();
                    SingleDBRecord.writesingleGameSteps(singleFile, dataSingle ,Player1, scoreX, Player2, scoreO, moves, winner);
                    
                }
                   JOptionPane.showMessageDialog(null, "Game Tie ");
     
    
    }    
            
    }
    public void newGame() {
    btn0.setText("");
    btn1.setText("");
    btn2.setText("");
    btn3.setText("");
    btn4.setText("");
    btn5.setText("");
    btn6.setText("");
    btn7.setText("");
    btn8.setText("");
    /////////////////
    btn0.setIcon(null);
        btn1.setIcon(null);
        btn2.setIcon(null);
        btn3.setIcon(null);
        btn4.setIcon(null);
        btn5.setIcon(null);
        btn6.setIcon(null);
        btn7.setIcon(null);
        btn8.setIcon(null);
          
          
     
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
        jcomputer = new javax.swing.JLabel();
        jLabescorex = new javax.swing.JLabel();
        jLabelscoreo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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

        btn0.setBackground(new java.awt.Color(255, 255, 255));
        btn0.setFont(new java.awt.Font("Adobe Heiti Std R", 1, 24)); // NOI18N
        btn0.setForeground(java.awt.Color.white);
        btn0.setBorder(null);
        btn0.setBorderPainted(false);
        btn0.setContentAreaFilled(false);
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        jPanel1.add(btn0, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, 80));

        btn1.setBackground(new java.awt.Color(255, 255, 255));
        btn1.setFont(new java.awt.Font("Adobe Heiti Std R", 1, 24)); // NOI18N
        btn1.setForeground(java.awt.Color.white);
        btn1.setBorder(null);
        btn1.setBorderPainted(false);
        btn1.setContentAreaFilled(false);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 130, 80));

        btn2.setBackground(new java.awt.Color(255, 255, 255));
        btn2.setFont(new java.awt.Font("Adobe Heiti Std R", 1, 24)); // NOI18N
        btn2.setForeground(java.awt.Color.white);
        btn2.setBorder(null);
        btn2.setBorderPainted(false);
        btn2.setContentAreaFilled(false);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel1.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 120, 90));

        btn3.setBackground(new java.awt.Color(255, 255, 255));
        btn3.setFont(new java.awt.Font("Adobe Heiti Std R", 1, 24)); // NOI18N
        btn3.setForeground(java.awt.Color.white);
        btn3.setBorder(null);
        btn3.setBorderPainted(false);
        btn3.setContentAreaFilled(false);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 100, 130));

        btn4.setBackground(new java.awt.Color(255, 255, 255));
        btn4.setFont(new java.awt.Font("Adobe Heiti Std R", 1, 24)); // NOI18N
        btn4.setForeground(java.awt.Color.white);
        btn4.setBorder(null);
        btn4.setBorderPainted(false);
        btn4.setContentAreaFilled(false);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 150, 120));

        btn5.setBackground(new java.awt.Color(255, 255, 255));
        btn5.setFont(new java.awt.Font("Adobe Heiti Std R", 1, 24)); // NOI18N
        btn5.setForeground(java.awt.Color.white);
        btn5.setBorder(null);
        btn5.setBorderPainted(false);
        btn5.setContentAreaFilled(false);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel1.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 110, 120));

        btn6.setBackground(new java.awt.Color(255, 255, 255));
        btn6.setFont(new java.awt.Font("Adobe Heiti Std R", 1, 24)); // NOI18N
        btn6.setForeground(java.awt.Color.white);
        btn6.setBorder(null);
        btn6.setBorderPainted(false);
        btn6.setContentAreaFilled(false);
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel1.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 110, 120));

        btn7.setBackground(new java.awt.Color(255, 255, 255));
        btn7.setFont(new java.awt.Font("Adobe Heiti Std R", 1, 24)); // NOI18N
        btn7.setForeground(java.awt.Color.white);
        btn7.setBorder(null);
        btn7.setBorderPainted(false);
        btn7.setContentAreaFilled(false);
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel1.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 140, 140));

        btn8.setBackground(new java.awt.Color(255, 255, 255));
        btn8.setFont(new java.awt.Font("Adobe Heiti Std R", 1, 24)); // NOI18N
        btn8.setForeground(java.awt.Color.white);
        btn8.setBorder(null);
        btn8.setBorderPainted(false);
        btn8.setContentAreaFilled(false);
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel1.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 130, 120));

        jplayer1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jplayer1.setForeground(new java.awt.Color(255, 255, 255));
        jplayer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/user.png"))); // NOI18N
        jplayer1.setText("O");
        jPanel1.add(jplayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 70, -1));

        jcomputer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcomputer.setForeground(new java.awt.Color(255, 255, 255));
        jcomputer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/computer.png"))); // NOI18N
        jcomputer.setText("X");
        jPanel1.add(jcomputer, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 80, 50));

        jLabescorex.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabescorex.setForeground(new java.awt.Color(255, 255, 255));
        jLabescorex.setText("0");
        jPanel1.add(jLabescorex, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabelscoreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelscoreo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelscoreo.setText("0");
        jPanel1.add(jLabelscoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/VS.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 50, 40));

        jLabel3.setFont(new java.awt.Font("Adobe Heiti Std R", 1, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/gameBoard.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

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
        String s = btn0.getText();
        if(s.equalsIgnoreCase(""))
        {
            btn0.setText("O");
            moves.put(0, "O");
           
            turno =1;
        }
       Computer();
       
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
      
       GamePlayMenu gamemainmenu = new GamePlayMenu();
      gamemainmenu.setVisible(true);
                   gamemainmenu.pack();
                   gamemainmenu.setLocationRelativeTo(null);
                   this.dispose();

    }//GEN-LAST:event_btnBackActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        String s = btn1.getText();
        if(s.equalsIgnoreCase(""))
        {
            btn1.setText("O");
            moves.put(1, "O");
            choose_a_Player();
            turno =1;
        }
       Computer();
      
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
      String s = btn2.getText();
        if(s.equalsIgnoreCase(""))
        {
            btn2.setText("O");
            moves.put(2, "O");
            choose_a_Player();
            turno =1;
        }
       Computer();
      
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
       String s = btn3.getText();
        if(s.equalsIgnoreCase(""))
        {
            btn3.setText("O");
            moves.put(3, "O");
            choose_a_Player();
            turno =1;
        }
       Computer();
      
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
       String s = btn4.getText();
        if(s.equalsIgnoreCase(""))
        {
            btn4.setText("O");
            moves.put(4, "O");
            choose_a_Player();
            turno =1;
        }
       Computer();
      
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
      String s = btn5.getText();
        if(s.equalsIgnoreCase(""))
        {
            btn5.setText("O");
            moves.put(5, "O");
            choose_a_Player();
            turno =1;
        }
       Computer();
     
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
       String s = btn6.getText();
        if(s.equalsIgnoreCase(""))
        {
            btn6.setText("O");
            moves.put(6, "O");
            choose_a_Player();
            turno =1;
        }
       Computer();
     
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
       String s = btn7.getText();
        if(s.equalsIgnoreCase(""))
        {
            btn7.setText(startGame);
            moves.put(7, startGame);
            choose_a_Player();
            turno =1;
        }
       Computer();
      
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
      String s = btn8.getText();
        if(s.equalsIgnoreCase(""))
        {
            btn8.setText("O");
            moves.put(8, "O");
            choose_a_Player();
            turno =1;
        }
       Computer();
      
    }//GEN-LAST:event_btn8ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        newGame();
        
        Computer();
        
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(ModePlayerOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModePlayerOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModePlayerOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModePlayerOne.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModePlayerOne().setVisible(true);

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelscoreo;
    private javax.swing.JLabel jLabescorex;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jcomputer;
    private javax.swing.JLabel jplayer1;
    // End of variables declaration//GEN-END:variables
}

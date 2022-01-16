/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoc_game_Gui;

import OnlieClient.Client;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fady
 */


public class MainMenu extends javax.swing.JFrame {

   Client client;
 public static String username=LoginForm.Username;
 public static  String gamenum;
 public static  String gamewin;
 public static  String gamelose;
 public static  String gametie;
 
    public MainMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnOptions = new javax.swing.JButton();
        btnOptions1 = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setMinimumSize(new java.awt.Dimension(500, 600));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoc_game_Gui/Button1.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.setBorder(null);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel2.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, -1, -1));

        btnPlay.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(255, 255, 255));
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoc_game_Gui/Button1.png"))); // NOI18N
        btnPlay.setText("Play");
        btnPlay.setBorder(null);
        btnPlay.setBorderPainted(false);
        btnPlay.setContentAreaFilled(false);
        btnPlay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        jPanel2.add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        btnOptions.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnOptions.setForeground(new java.awt.Color(255, 255, 255));
        btnOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoc_game_Gui/Button1.png"))); // NOI18N
        btnOptions.setText("Log Out");
        btnOptions.setBorder(null);
        btnOptions.setBorderPainted(false);
        btnOptions.setContentAreaFilled(false);
        btnOptions.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionsActionPerformed(evt);
            }
        });
        jPanel2.add(btnOptions, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, -1, -1));

        btnOptions1.setFont(new java.awt.Font("Bookman Old Style", 1, 24)); // NOI18N
        btnOptions1.setForeground(new java.awt.Color(255, 255, 255));
        btnOptions1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoc_game_Gui/Button1.png"))); // NOI18N
        btnOptions1.setText("Profile Games");
        btnOptions1.setBorder(null);
        btnOptions1.setBorderPainted(false);
        btnOptions1.setContentAreaFilled(false);
        btnOptions1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOptions1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptions1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnOptions1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoc_game_Gui/01.png"))); // NOI18N
        jPanel2.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOptionsActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
    System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        
        GamePlayMenu gamePlayMenuNav = new GamePlayMenu();
      
                   gamePlayMenuNav.setVisible(true);
                   gamePlayMenuNav.pack();
                   gamePlayMenuNav.setLocationRelativeTo(null);
                   this.dispose();
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnOptions1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptions1ActionPerformed
        try {
            String massege="";
            
          String []pasremsg;
            
            client = Client.getClient();
            System.out.println("Sending string to the ServerSocket");
            client.sendMessage("PGAMES."+ username);
           massege = client.readResponse();
            System.out.println("The message sent from the socket was: " + massege);
            pasremsg=massege.split("\\.");
           gamenum=pasremsg[0];
           gamewin=pasremsg[1];
           gamelose=pasremsg[2];
           gametie=pasremsg[3];
           
             
             ProfileGames profileGames=new ProfileGames();
               profileGames.setVisible(true);
                   profileGames.pack();
                   profileGames.setLocationRelativeTo(null);
                 this.dispose();
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
             client.closeClient();
        }
        
    }//GEN-LAST:event_btnOptions1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOptions;
    private javax.swing.JButton btnOptions1;
    private javax.swing.JButton btnPlay;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
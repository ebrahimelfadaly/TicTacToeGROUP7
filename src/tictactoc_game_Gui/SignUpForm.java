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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class SignUpForm extends javax.swing.JFrame {

    /**
     * Creates new form SignUpForm
     */
    Client client;
    public SignUpForm() {
        initComponents();
        this.setLocationRelativeTo(null);//set screen on center
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextfullname = new javax.swing.JTextField();
        jPasswordFieldpass2 = new javax.swing.JPasswordField();
        jLabelmins = new javax.swing.JLabel();
        jLabelclose = new javax.swing.JLabel();
        jButtoncancel = new javax.swing.JButton();
        jButtonsave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextusername = new javax.swing.JTextField();
        jPasswordFieldpass1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(550, 600));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setMinimumSize(new java.awt.Dimension(500, 600));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 240, 241));
        jLabel2.setText("Password :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 105, -1));

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(236, 240, 241));
        jLabel5.setText("FullName :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 100, -1));

        jTextfullname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextfullname.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.add(jTextfullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 210, -1));

        jPasswordFieldpass2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPasswordFieldpass2.setForeground(new java.awt.Color(51, 51, 51));
        jPasswordFieldpass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldpass2ActionPerformed(evt);
            }
        });
        jPanel2.add(jPasswordFieldpass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 210, -1));

        jLabelmins.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelmins.setForeground(new java.awt.Color(255, 255, 255));
        jLabelmins.setText("-");
        jLabelmins.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelminsMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelmins, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 0, -1, -1));

        jLabelclose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelclose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelclose.setText("X");
        jLabelclose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelcloseMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 0, -1, -1));

        jButtoncancel.setBackground(new java.awt.Color(192, 57, 43));
        jButtoncancel.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jButtoncancel.setForeground(new java.awt.Color(255, 255, 255));
        jButtoncancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoc_game_Gui/Button1.png"))); // NOI18N
        jButtoncancel.setText("Cancel");
        jButtoncancel.setBorder(null);
        jButtoncancel.setBorderPainted(false);
        jButtoncancel.setContentAreaFilled(false);
        jButtoncancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jButtoncancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, -1, 31));

        jButtonsave.setBackground(new java.awt.Color(34, 167, 240));
        jButtonsave.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jButtonsave.setForeground(new java.awt.Color(255, 255, 255));
        jButtonsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoc_game_Gui/Button1.png"))); // NOI18N
        jButtonsave.setText("Sign Up");
        jButtonsave.setBorder(null);
        jButtonsave.setBorderPainted(false);
        jButtonsave.setContentAreaFilled(false);
        jButtonsave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsaveActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 401, 225, 31));

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(236, 240, 241));
        jLabel6.setText("Confirm Password :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 140, -1));

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sign Up Form");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 11, -1, -1));

        jLabel9.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setText("UserName :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 117, -1));

        jTextusername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextusername.setForeground(new java.awt.Color(51, 51, 51));
        jTextusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextusernameActionPerformed(evt);
            }
        });
        jPanel2.add(jTextusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 210, -1));

        jPasswordFieldpass1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPasswordFieldpass1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.add(jPasswordFieldpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 210, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoc_game_Gui/gamePlayBg.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelcloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelcloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabelcloseMouseClicked

    private void jLabelminsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelminsMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelminsMouseClicked

    private void jPasswordFieldpass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldpass2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldpass2ActionPerformed

    private void jButtonsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsaveActionPerformed
             if(verfyfields())
             {
              sigup();
              
              
             }
    }//GEN-LAST:event_jButtonsaveActionPerformed

    private void jTextusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextusernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextusernameActionPerformed
public boolean verfyfields(){
    String fname= jTextfullname.getText().trim();
    String username=jTextusername.getText().trim();
    String password=String.valueOf(jPasswordFieldpass1.getPassword());
    String password2=String.valueOf(jPasswordFieldpass2.getPassword());
    if(fname.trim().equals("") ||username.trim().equals("")||password.trim().equals("")||password2.trim().equals("") )
    {
        JOptionPane.showMessageDialog(null, "One or More filed is Empty");
    return false;
    }
    else if(!password.equals(password2))
        {
        JOptionPane.showMessageDialog(null, "password dosent match ","confirm password",2);
          return false;
            }
    else return true;
}
public void sigup()
{
        try {
            String fname= jTextfullname.getText().trim();
            String username=jTextusername.getText().trim();
            String password=String.valueOf(jPasswordFieldpass1.getPassword());
            client=Client.getClient();
            if(!jTextfullname.getText().startsWith(" ")&& !jTextusername.getText().startsWith(" ") && !password.startsWith(" "))
            {
                client.sendMessage( "UP."+fname + "." +username + "." + password );   // sign up
                System.out.println("i am signup");
            
            }
            String messgChecksUserEntryCases = client.readResponse();
             System.out.println("The message sent from the socket was: " + messgChecksUserEntryCases);
                if (messgChecksUserEntryCases.equalsIgnoreCase("Empty Field")) {
                    System.out.println(messgChecksUserEntryCases);
                    //JOptionPane.showMessageDialog(null, "Please enter a unique username and a password ");
                 
                }
                else if (!messgChecksUserEntryCases.equalsIgnoreCase("ALREADY EXISTS") && !messgChecksUserEntryCases.equalsIgnoreCase("NO ENTRY") ) {
                    System.out.println(messgChecksUserEntryCases);
                    System.out.println("signup");
                    JOptionPane.showMessageDialog(null, "suceced ");
                    LoginForm.Username=username;
                   MainMenu form=new MainMenu();
                   form.setVisible(true);
                   form.pack();
                   form.setLocationRelativeTo(null);
                   this.dispose();
                
                }
                else {
                    System.out.println(messgChecksUserEntryCases);
                    System.out.println("User already exists");
                   
                    JOptionPane.showMessageDialog(null,"username already exists please enter a unique name");
               
                }
            
        } catch (IOException ex) {
            Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE, null, ex);
            client.closeClient();
        }



}
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
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtoncancel;
    private javax.swing.JButton jButtonsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelclose;
    private javax.swing.JLabel jLabelmins;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordFieldpass1;
    private javax.swing.JPasswordField jPasswordFieldpass2;
    private javax.swing.JTextField jTextfullname;
    private javax.swing.JTextField jTextusername;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
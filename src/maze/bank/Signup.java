/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;

/**
 *
 * @author Omkar
 */
public class Signup extends javax.swing.JFrame {
    
    Connection myConn = null;
    PreparedStatement pst = null;
    ResultSet myRs = null;

    /**
     * Creates new form Signup
     */
    public Signup(){
        initComponents();
        setbranch();
    }
    
    private void setbranch(){

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mazebank?serverTimezone=UTC", "admin" , "admin");
            pst = myConn.prepareStatement("select * from branch");
            myRs = pst.executeQuery();
            while (myRs.next()) {
                String item = myRs.getString("name");
                branch.addItem(item);
            }
            if (myRs != null) {
                    myRs.close();
            }
            if (myConn != null) {
                    myConn.close();
            }
        }
        catch (SQLException exc) {
            System.out.println("Exception");
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
        jLabel1 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addr = new javax.swing.JTextField();
        dob = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        branch = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        rpin = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pin = new javax.swing.JPasswordField();
        desc = new javax.swing.JLabel();
        bank_name = new javax.swing.JLabel();
        main_header = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 450));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("First Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        fname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 180, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Last Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        lname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 180, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Email");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 180, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Phone");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        phone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });
        jPanel1.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 180, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Address");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        addr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addrActionPerformed(evt);
            }
        });
        jPanel1.add(addr, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 180, -1));

        dob.setDateFormatString("dd/MM/yyyy");
        dob.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 180, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("D.O.B");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("PAN Card");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        pan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panActionPerformed(evt);
            }
        });
        jPanel1.add(pan, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 180, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Branch");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, -1, -1));

        branch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchActionPerformed(evt);
            }
        });
        jPanel1.add(branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 180, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Pin (4 digits)");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, -1, -1));

        rpin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(rpin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 180, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Retype Pin");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        jButton1.setBackground(new java.awt.Color(174, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sign up");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));

        pin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(pin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 180, -1));

        desc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desc.setForeground(new java.awt.Color(174, 0, 0));
        desc.setText("Invest in the red, it's in your interest");
        jPanel1.add(desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        bank_name.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        bank_name.setText("MAZE BANK");
        jPanel1.add(bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 130, 40));

        main_header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Header1.PNG"))); // NOI18N
        jPanel1.add(main_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 600, 450));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Background.jpg"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void addrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addrActionPerformed

    private void panActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_panActionPerformed

    private void branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchActionPerformed

    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            Database db = new Database();
            String pass = new String(pin.getPassword());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            String strDate = dateFormat.format(dob.getDate());  
            System.out.println(strDate);
            String bid = db.findBranch(branch.getSelectedItem().toString());
            db.signup(fname.getText(),lname.getText(),email.getText(),phone.getText(),addr.getText(),strDate,pan.getText(),pass,bid);
            new Dashboard().setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(Signup.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addr;
    private javax.swing.JLabel background;
    private javax.swing.JLabel bank_name;
    private javax.swing.JComboBox<String> branch;
    private javax.swing.JLabel desc;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lname;
    private javax.swing.JLabel main_header;
    private javax.swing.JTextField pan;
    private javax.swing.JTextField phone;
    private javax.swing.JPasswordField pin;
    private javax.swing.JPasswordField rpin;
    // End of variables declaration//GEN-END:variables
}

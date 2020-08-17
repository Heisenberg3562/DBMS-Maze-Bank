/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.bank;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Omkar
 */
public class Bank extends javax.swing.JFrame {

    /**
     * Creates new form Bank
     */
    public Bank() {
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

        jPanel1 = new javax.swing.JPanel();
        signinBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bank_name = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        signinBtn.setBackground(new java.awt.Color(174, 0, 0));
        signinBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        signinBtn.setForeground(new java.awt.Color(255, 255, 255));
        signinBtn.setText("Sign up");
        signinBtn.setToolTipText("");
        signinBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinBtnActionPerformed(evt);
            }
        });
        jPanel1.add(signinBtn);
        signinBtn.setBounds(470, 320, 180, 60);

        jButton1.setBackground(new java.awt.Color(174, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(140, 320, 180, 60);

        bank_name.setFont(new java.awt.Font("Tahoma", 0, 60)); // NOI18N
        bank_name.setText("MAZE BANK");
        jPanel1.add(bank_name);
        bank_name.setBounds(230, 170, 330, 90);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home.PNG"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(100, 0, 600, 450);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Background.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1, 3, 800, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void data() throws SQLException{
        Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?serverTimezone=UTC", "student" , "student");
			
                        myStmt = myConn.createStatement();
                        
			System.out.println("Inserting a new user to database\n");
			
			myStmt.executeUpdate("insert into user(Acc_no, First_name, Last_name, Email, Phone, Address) values (9876543211, 'Adeeba', 'Ansari', 'adeeba@gmail.com', 8446904813, 'Bhiwandi')");
			System.out.println("Test");
			// 4. Verify this by getting a list of employees
			myRs = myStmt.executeQuery("select * from user");
			System.out.println("Test");
			// 5. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("First_name") + ", " + myRs.getString("Last_name"));
			}
		}
		catch (SQLException exc) {
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

            // TODO add your handling code here:
//        Bank b = new Bank();
//        b.data();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void signinBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinBtnActionPerformed
        // TODO add your handling code here:
        new Signup().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_signinBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Bank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bank.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bank().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bank_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton signinBtn;
    // End of variables declaration//GEN-END:variables
}

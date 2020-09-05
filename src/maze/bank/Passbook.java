/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze.bank;

/**
 *
 * @author Omkar
 */
public class Passbook extends javax.swing.JFrame {

    /**
     * Creates new form Passbook
     */
    public Passbook() {
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
        balance = new javax.swing.JLabel();
        desc = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        red = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        amtLabel = new javax.swing.JLabel();
        bank_name = new javax.swing.JLabel();
        main_header = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        balance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        balance.setText("0");
        jPanel1.add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, -1, -1));

        desc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desc.setForeground(new java.awt.Color(174, 0, 0));
        desc.setText("Invest in the red, it's in your interest");
        jPanel1.add(desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText(Database.name);
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 360, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("₹");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, 220, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Account Balance :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 120, -1));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 440, 150));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Account Transactions");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 160, 20));

        red.setBackground(new java.awt.Color(174, 0, 0));
        red.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Red.png"))); // NOI18N
        jPanel1.add(red, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 580, 70));

        jButton1.setBackground(new java.awt.Color(174, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Main Menu");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 160, -1));

        amtLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        amtLabel.setText("Account Balance : ₹");
        jPanel1.add(amtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        bank_name.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        bank_name.setText("MAZE BANK");
        bank_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bank_nameMouseClicked(evt);
            }
        });
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bank_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bank_nameMouseClicked
        // TODO add your handling code here:
        new Dashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bank_nameMouseClicked

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
            java.util.logging.Logger.getLogger(Passbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Passbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Passbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Passbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Passbook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amtLabel;
    private javax.swing.JLabel background;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel bank_name;
    private javax.swing.JLabel desc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel main_header;
    private javax.swing.JLabel name;
    private javax.swing.JLabel red;
    // End of variables declaration//GEN-END:variables
}

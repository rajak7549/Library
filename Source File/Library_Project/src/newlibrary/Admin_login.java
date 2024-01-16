/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package newlibrary;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Admin_login extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;

    public Admin_login() {
        initComponents();
        connect();
    }

    public void connect() {
        try {
            Properties user = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "");
            if (con != null) {
                System.out.println("Connect succesfuly");
                stmt = con.createStatement();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Username");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 129, 127, -1));

        jLabel2.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 205, 127, -1));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 5, true));

        jLabel3.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Welcome to Admin Page");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(125, 125, 125))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, -1));

        txtUsername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 0, 0));
        txtUsername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 5, true));
        jPanel1.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 134, 183, -1));

        txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 0, 0));
        txtPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 5, true));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 210, 183, -1));

        jButton1.setBackground(new java.awt.Color(153, 0, 0));
        jButton1.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 0));
        jButton1.setText("Login");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 5, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 277, 93, 37));

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 0));
        jButton2.setText("Back");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 5, true));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 277, 88, 37));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/newlibrary_image/admin page.jpg"))); // NOI18N
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 5, true));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 510, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String sql = "select * from admin where username='" + txtUsername.getText() + "'and password='" + txtPassword.getText() + "'";
            rs = stmt.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                i++;
            }
            if (i == 1) {
                JOptionPane.showMessageDialog(this, "Login successfully");
                Admin_View_All v = new Admin_View_All();
                v.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "Login Invalid");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

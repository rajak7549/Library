/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package newlibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Member extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    ResultSet rs;

    public Member() {
        initComponents();
        connect();
    }

    public class CategoryItem {

        int id;
        String name;

        public CategoryItem(int id, String name) {
            this.id = id;
            this.name = name;

        }

        public String toString() {

            return name;
        }

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

    public void Category() {
        try {
            stmt = con.prepareStatement("select * from category");
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtmember = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cadd = new javax.swing.JButton();
        cupdate = new javax.swing.JButton();
        cdelete = new javax.swing.JButton();
        ccancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtsession = new javax.swing.JComboBox<>();
        txtcourse = new javax.swing.JComboBox<>();
        txtcontact = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        txtregistration = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Member Name");

        txtmember.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtmember.setForeground(new java.awt.Color(204, 0, 0));
        txtmember.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 4));

        jLabel2.setBackground(new java.awt.Color(255, 255, 0));
        jLabel2.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Registration no");

        cadd.setBackground(new java.awt.Color(204, 0, 0));
        cadd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cadd.setForeground(new java.awt.Color(255, 255, 0));
        cadd.setText("Add");
        cadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caddActionPerformed(evt);
            }
        });

        cupdate.setBackground(new java.awt.Color(204, 0, 0));
        cupdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cupdate.setForeground(new java.awt.Color(255, 255, 0));
        cupdate.setText("Update");

        cdelete.setBackground(new java.awt.Color(204, 0, 0));
        cdelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cdelete.setForeground(new java.awt.Color(255, 255, 0));
        cdelete.setText("Delete");
        cdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdeleteActionPerformed(evt);
            }
        });

        ccancel.setBackground(new java.awt.Color(204, 0, 0));
        ccancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ccancel.setForeground(new java.awt.Color(255, 255, 0));
        ccancel.setText("View");
        ccancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccancelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Harrington", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Member");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Member Name", "Registration", "Session", "Course/Part", "Contact", "Address", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setBackground(new java.awt.Color(255, 255, 0));
        jLabel4.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Session");

        jLabel5.setBackground(new java.awt.Color(255, 255, 0));
        jLabel5.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Course/Part");

        jLabel6.setBackground(new java.awt.Color(255, 255, 0));
        jLabel6.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("Contact");

        jLabel7.setBackground(new java.awt.Color(255, 255, 0));
        jLabel7.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Address");

        txtsession.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtsession.setForeground(new java.awt.Color(204, 0, 0));
        txtsession.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019 - 2022", "2023 - 2026", "2027 - 2030" }));
        txtsession.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 4));

        txtcourse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtcourse.setForeground(new java.awt.Color(204, 0, 0));
        txtcourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BCA", "BBA", "BA", "B.com", "Bsc", "B.tech" }));
        txtcourse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 4));

        txtcontact.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtcontact.setForeground(new java.awt.Color(204, 0, 0));
        txtcontact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 4));

        jLabel8.setBackground(new java.awt.Color(255, 255, 0));
        jLabel8.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("Email");

        txtemail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtemail.setForeground(new java.awt.Color(204, 0, 0));
        txtemail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 4));

        txtregistration.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtregistration.setForeground(new java.awt.Color(204, 0, 0));
        txtregistration.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 4));

        txtaddress.setColumns(20);
        txtaddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtaddress.setForeground(new java.awt.Color(204, 0, 0));
        txtaddress.setRows(5);
        txtaddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 4));
        jScrollPane2.setViewportView(txtaddress);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtmember)
                                            .addComponent(txtsession, 0, 158, Short.MAX_VALUE)
                                            .addComponent(txtcourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtcontact)
                                            .addComponent(txtregistration)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtemail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cadd, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cdelete))
                                        .addGap(125, 125, 125)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ccancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cupdate))
                                        .addGap(52, 52, 52))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(82, 82, 82)))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtregistration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtsession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtcourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtcontact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cadd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ccancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void caddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caddActionPerformed

        String member_name = txtmember.getText();
        String registration = txtregistration.getText();
        String session = txtsession.getSelectedItem().toString();
        String course = txtcourse.getSelectedItem().toString();
        String contact = txtcontact.getText();
        String address = txtaddress.getText();
        String email = txtemail.getText();

        if (txtmember.getText().equals("") || txtregistration.getText().equals("") || txtsession.getSelectedItem().toString().equals("") || txtcontact.getText().equals("") || txtaddress.getText().equals("") || txtemail.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Please enter all data");
        } else {

            try {
                String sql = "insert into member(member_name,registration,session,course,contact,address,email)"
                        + "values('" + member_name + "','" + registration + "','" + session + "','" + course + "','" + contact + "','" + address + "','" + email + "')";
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Member are registred");

            } catch (SQLException ex) {
                System.out.print(ex);
                //Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
            }

//
//            String data[] = {txtmember.getText(), txtregistration.getText(), txtsession.getSelectedItem().toString(), txtcontact.getText(), txtaddress.getText(), txtemail.getText()};
//
//            DefaultTableModel tablModel = (DefaultTableModel) jTable1.getModel();
//
//            tablModel.addRow(data);
//
//            JOptionPane.showMessageDialog(this, "Add data successfully");
//
//            txtmember.setText("");
//            txtregistration.setText("");
//            txtcontact.setText("");
//            txtaddress.setText("");
//            txtemail.setText("");
        }

    }//GEN-LAST:event_caddActionPerformed

    private void ccancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccancelActionPerformed
        String sql = "select * from member";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getNString(6), rs.getString(7), rs.getString(8)});
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());

        }
    }//GEN-LAST:event_ccancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdeleteActionPerformed
        int row = jTable1.getSelectedRow();
        String cell = jTable1.getModel().getValueAt(row, 0).toString();
        String sql = "DELETE FROM member where id=" + cell;
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.execute();

            JOptionPane.showMessageDialog(this, "Delete update table successfully");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_cdeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        connection con1 = new connection();
        DefaultTableModel tblmodel = (DefaultTableModel) jTable1.getModel();
        var arr = tblmodel.getDataVector();
        int row = jTable1.getSelectedRow();

        txtmember.setText(String.valueOf(arr.elementAt(row).elementAt(1)));
        txtregistration.setText(String.valueOf(arr.elementAt(row).elementAt(2)));
        txtsession.setSelectedItem(String.valueOf(arr.elementAt(row).elementAt(3)));
        txtcourse.setSelectedItem(String.valueOf(arr.elementAt(row).elementAt(4)));
        txtcontact.setText(String.valueOf(arr.elementAt(row).elementAt(5)));
        txtaddress.setText(String.valueOf(arr.elementAt(row).elementAt(6)));
        txtemail.setText(String.valueOf(arr.elementAt(row).elementAt(7)));

    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadd;
    private javax.swing.JButton ccancel;
    private javax.swing.JButton cdelete;
    private javax.swing.JButton cupdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtcontact;
    private javax.swing.JComboBox<String> txtcourse;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtmember;
    private javax.swing.JTextField txtregistration;
    private javax.swing.JComboBox<String> txtsession;
    // End of variables declaration//GEN-END:variables

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package newlibrary;

import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Author extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    PreparedStatement pstmt;

    public Author() {
        initComponents();
        btnfind.grabFocus();
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

    private void update() {

        String name = txtAuthorName.getText();
        String address = txtaddress.getText();
        String phone = txtphone.getText();
        String email = txtemail.getText();

        try {

            String sql = "update author set name='" + name + "',address='" + address + "',email='" + email + "' where phone='" + phone + "'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Data updated successfully");
            DefaultTableModel model = (DefaultTableModel) tblauthor.getModel();
            var arr = model.getDataVector();
            for (int i = 0; i < arr.size(); i++) {
                if (arr.elementAt(i).elementAt(0).equals(phone)) {
                    model.setValueAt(name, i, 2);
                    model.setValueAt(address, i, 3);
                    model.setValueAt(email, i, 5);
                }
            }

        } catch (Exception ex) {
            ex.getStackTrace();
        }

    }

    private void view_author() {

        String sql = "select * from author";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tblauthor.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());

        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtAuthorName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cadd = new javax.swing.JButton();
        cupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        ccancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblauthor = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 5));

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Author Name");

        txtAuthorName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtAuthorName.setForeground(new java.awt.Color(204, 0, 0));
        txtAuthorName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jLabel2.setBackground(new java.awt.Color(255, 255, 0));
        jLabel2.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Address");

        cadd.setBackground(new java.awt.Color(204, 0, 0));
        cadd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cadd.setForeground(new java.awt.Color(255, 255, 0));
        cadd.setText("Add");
        cadd.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 0)));
        cadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caddActionPerformed(evt);
            }
        });

        cupdate.setBackground(new java.awt.Color(204, 0, 0));
        cupdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cupdate.setForeground(new java.awt.Color(255, 255, 0));
        cupdate.setText("Update");
        cupdate.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 0)));
        cupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cupdateActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(204, 0, 0));
        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 0));
        btndelete.setText("Delete");
        btndelete.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 0)));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        ccancel.setBackground(new java.awt.Color(204, 0, 0));
        ccancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ccancel.setForeground(new java.awt.Color(255, 255, 0));
        ccancel.setText("View");
        ccancel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 0)));
        ccancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccancelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Harrington", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Author");

        tblauthor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblauthor.setForeground(new java.awt.Color(204, 0, 0));
        tblauthor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Author Name", "Address", "Phone", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblauthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblauthorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblauthor);

        txtaddress.setColumns(20);
        txtaddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtaddress.setForeground(new java.awt.Color(204, 0, 0));
        txtaddress.setRows(5);
        txtaddress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        jScrollPane2.setViewportView(txtaddress);

        jLabel4.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Phone");

        txtphone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtphone.setForeground(new java.awt.Color(204, 0, 0));
        txtphone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jLabel5.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Email");

        txtemail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtemail.setForeground(new java.awt.Color(204, 0, 0));
        txtemail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 5));

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtid.setForeground(new java.awt.Color(204, 0, 0));
        txtid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        btnfind.setBackground(new java.awt.Color(153, 0, 0));
        btnfind.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnfind.setForeground(new java.awt.Color(255, 255, 0));
        btnfind.setText("Find ");
        btnfind.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 0)));
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("Searching data");

        jButton3.setBackground(new java.awt.Color(153, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 0));
        jButton3.setText("Print");
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(255, 255, 0)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(txtphone)
                            .addComponent(txtemail)
                            .addComponent(txtAuthorName)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnfind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cupdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ccancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnfind)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cadd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ccancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void caddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caddActionPerformed

        String name = txtAuthorName.getText();
        String address = txtaddress.getText();
        String phone = txtphone.getText();
        String email = txtemail.getText();

        try {
            String sql = "insert into author(name,address,phone,email)"
                    + "values('" + name + "','" + address + "','" + phone + "','" + email + "')";
            stmt.executeUpdate(sql);
            //JOptionPane.showMessageDialog(this, "Data saved successfully");

        } catch (SQLException ex) {
            System.out.print(ex);
            //Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (txtAuthorName.getText().equals("") || txtaddress.getText().equals("") || txtphone.getText().equals("") || txtemail.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Please enter all data");
        } else {

            String data[] = {txtAuthorName.getText(), txtaddress.getText(), txtphone.getText(), txtemail.getText()};

            DefaultTableModel tablModel = (DefaultTableModel) tblauthor.getModel();

            tablModel.addRow(data);

            JOptionPane.showMessageDialog(this, "Add data successfully");

            txtAuthorName.setText("");
            txtaddress.setText("");
            txtphone.setText("");
            txtphone.setText("");
            txtemail.setText("");
        }

    }//GEN-LAST:event_caddActionPerformed

    private void ccancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccancelActionPerformed
        String sql = "select * from author";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tblauthor.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});

                // System.out.println("hello");
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());

        }
    }//GEN-LAST:event_ccancelActionPerformed

    private void cupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cupdateActionPerformed

        String name = txtAuthorName.getText();
        String address = txtaddress.getText();
        String phone = txtphone.getText();
        String email = txtemail.getText();
        String id;

        try {
            DefaultTableModel model = (DefaultTableModel) tblauthor.getModel();
            var arr = model.getDataVector();

            if (arr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Field is mandatory");
                return;
            }

            int row = tblauthor.getSelectedRow();
            id = String.valueOf(arr.elementAt(row).elementAt(0));

            String sql = "update author set name='" + name + "', address='" + address + "', email='" + email + "', phone = '" + phone + "' where id=" + id;
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Data updated successfully");

            for (int i = 0; i < arr.size(); i++) {
                // System.out.println(id);
                if (arr.elementAt(i).elementAt(0).toString().equals(id)) {
                    model.setValueAt(name, i, 1);
                    model.setValueAt(address, i, 2);
                    model.setValueAt(phone, i, 3);
                    model.setValueAt(email, i, 4);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (txtAuthorName.getText().equals("") || txtaddress.getText().equals("") || txtphone.getText().equals("") || txtemail.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Please enter all data");
        } else {

            String data[] = {txtAuthorName.getText(), txtaddress.getText(), txtphone.getText(), txtemail.getText()};

            DefaultTableModel tablModel = (DefaultTableModel) tblauthor.getModel();

            tablModel.addRow(data);

            JOptionPane.showMessageDialog(this, "Add data successfully");

            txtAuthorName.setText("");
            txtaddress.setText("");
            txtphone.setText("");
            txtphone.setText("");
            txtemail.setText("");
        }

    }//GEN-LAST:event_cupdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        int row = tblauthor.getSelectedRow();
        String cell = tblauthor.getModel().getValueAt(row, 0).toString();
        String sql = "DELETE FROM author where id=" + cell;

        if (cell.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data is not deleted");
        } else {

            try {

                pstmt = con.prepareStatement(sql);
                pstmt.execute();

                JOptionPane.showMessageDialog(this, "Delete update table successfully");
                //view_author();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(this, e);
            }
        }

    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
        try {

            PreparedStatement pst = con.prepareStatement("select * from author where id=?");
            int id = Integer.parseInt(txtid.getText());
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next() == false) {

                JOptionPane.showMessageDialog(this, "Sorry Record is not found");
                txtAuthorName.setText("");
                txtaddress.setText("");
                txtphone.setText("");
                txtemail.setText("");
            } else {
                DefaultTableModel model = (DefaultTableModel) tblauthor.getModel();
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)});
            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }//GEN-LAST:event_btnfindActionPerformed

    private void tblauthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblauthorMouseClicked
        connection con1 = new connection();
        DefaultTableModel tblmodel = (DefaultTableModel) tblauthor.getModel();
        var arr = tblmodel.getDataVector();
        int row = tblauthor.getSelectedRow();

        txtAuthorName.setText(String.valueOf(arr.elementAt(row).elementAt(1)));
        txtaddress.setText(String.valueOf(arr.elementAt(row).elementAt(2)));
        txtphone.setText(String.valueOf(arr.elementAt(row).elementAt(3)));
        txtemail.setText(String.valueOf(arr.elementAt(row).elementAt(4)));

    }//GEN-LAST:event_tblauthorMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            tblauthor.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Author().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton cadd;
    private javax.swing.JButton ccancel;
    private javax.swing.JButton cupdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblauthor;
    private javax.swing.JTextField txtAuthorName;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtphone;
    // End of variables declaration//GEN-END:variables

}

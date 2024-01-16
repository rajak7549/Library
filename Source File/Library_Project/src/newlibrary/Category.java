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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Category extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pstmt;

    public Category() {
        initComponents();
        connect();
    }

    public void connect() {
        try {
            // Properties user = null;
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcategory = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtstatus = new javax.swing.JComboBox<>();
        cadd = new javax.swing.JButton();
        cupdate = new javax.swing.JButton();
        cdelete = new javax.swing.JButton();
        ccancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcategory = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Category Name");

        txtcategory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtcategory.setForeground(new java.awt.Color(204, 0, 0));
        txtcategory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 51), 4, true));

        jLabel2.setBackground(new java.awt.Color(255, 255, 0));
        jLabel2.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Status ");

        txtstatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtstatus.setForeground(new java.awt.Color(204, 0, 0));
        txtstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active ", "DeActive" }));
        txtstatus.setToolTipText("");
        txtstatus.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 51), 4, true));
        txtstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstatusActionPerformed(evt);
            }
        });

        cadd.setBackground(new java.awt.Color(204, 0, 0));
        cadd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cadd.setForeground(new java.awt.Color(255, 255, 0));
        cadd.setText("Add");
        cadd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 51), 4, true));
        cadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caddActionPerformed(evt);
            }
        });

        cupdate.setBackground(new java.awt.Color(204, 0, 0));
        cupdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cupdate.setForeground(new java.awt.Color(255, 255, 0));
        cupdate.setText("Update");
        cupdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 51), 4, true));
        cupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cupdateActionPerformed(evt);
            }
        });

        cdelete.setBackground(new java.awt.Color(204, 0, 0));
        cdelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cdelete.setForeground(new java.awt.Color(255, 255, 0));
        cdelete.setText("Delete");
        cdelete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 51), 4, true));
        cdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdeleteActionPerformed(evt);
            }
        });

        ccancel.setBackground(new java.awt.Color(204, 0, 0));
        ccancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ccancel.setForeground(new java.awt.Color(255, 255, 0));
        ccancel.setText("View");
        ccancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 51), 4, true));
        ccancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccancelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Harrington", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Category");

        tblcategory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        tblcategory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblcategory.setForeground(new java.awt.Color(204, 0, 0));
        tblcategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Category name", "Status"
            }
        ));
        tblcategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblcategory);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Search caregory");

        txtid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtid.setForeground(new java.awt.Color(204, 0, 0));
        txtid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 51), 4, true));

        jButton2.setText("Find");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 51), 4, true));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cdelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ccancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtstatus, 0, 135, Short.MAX_VALUE)
                                    .addComponent(txtcategory)
                                    .addComponent(cupdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cadd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ccancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstatusActionPerformed

    private void caddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caddActionPerformed

        String category = txtcategory.getText();
        String status = txtstatus.getSelectedItem().toString();

        try {
            String sql = "insert into category(Category,Status)"
                    + "values('" + category + "','" + status + "')";
            stmt.executeUpdate(sql);
            //JOptionPane.showMessageDialog(this, "Data saved successfully");

        } catch (SQLException ex) {
            System.out.print(ex);
            //Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (txtcategory.getText().equals("") || txtstatus.getSelectedItem().toString().equals("")) {

            JOptionPane.showMessageDialog(this, "Please enter all data");
        } else {

            String data[] = {txtcategory.getText(), txtstatus.getSelectedItem().toString()};

            DefaultTableModel tablModel = (DefaultTableModel) tblcategory.getModel();

            tablModel.addRow(data);

            JOptionPane.showMessageDialog(this, "Add data successfully");

            txtcategory.setText("");

        }

    }//GEN-LAST:event_caddActionPerformed

    private void ccancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccancelActionPerformed
        String sql = "select * from category";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tblcategory.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3)});
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());

        }
    }//GEN-LAST:event_ccancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();;        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cupdateActionPerformed
        String category_name = txtcategory.getText();
        String ststus = txtstatus.getSelectedItem().toString();
        String id;

        try {
            DefaultTableModel model = (DefaultTableModel) tblcategory.getModel();
            var arr = model.getDataVector();

            if (arr.isEmpty()) {
                return;
            }

            int row = tblcategory.getSelectedRow();
            id = String.valueOf(arr.elementAt(row).elementAt(0));

            String sql = "update category set Category='" + category_name + "',Status='" + ststus + "' where id=" + id;
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Data updated successfully");

            for (int i = 0; i < arr.size(); i++) {
                // System.out.println(id);
                if (arr.elementAt(i).elementAt(0).toString().equals(id)) {

                    model.setValueAt(category_name, i, 1);
                    model.setValueAt(ststus, i, 2);

                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (txtcategory.getText().trim().isEmpty() || txtstatus.getSelectedItem().toString().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Field is mandatory");

        } else {

            String data[] = {txtcategory.getText(), txtstatus.getSelectedItem().toString()};

            DefaultTableModel tablModel = (DefaultTableModel) tblcategory.getModel();

            tablModel.addRow(data);

            JOptionPane.showMessageDialog(this, "Add data successfully");
            txtcategory.setText("");
            // txtstatus.getSelectedItem.("");

        }

    }//GEN-LAST:event_cupdateActionPerformed

    private void cdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdeleteActionPerformed
        connection con1 = new connection();
        int row = tblcategory.getSelectedRow();
        String cell = tblcategory.getModel().getValueAt(row, 0).toString();
        String sql = "DELETE FROM category where id=" + cell;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.execute();

            JOptionPane.showMessageDialog(this, "Delete update table successfully");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_cdeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            PreparedStatement pst = con.prepareStatement("select * from author where id=?");
            int id = Integer.parseInt(txtid.getText());
            pst.setInt(1, id);
            java.sql.ResultSet rs = pst.executeQuery();

            if (rs.next() == false) {

                JOptionPane.showMessageDialog(this, "Sorry Record is not found");
                txtcategory.setText("");
            } else {
                DefaultTableModel model = (DefaultTableModel) tblcategory.getModel();
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)});
            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblcategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcategoryMouseClicked
        connection con1 = new connection();
        DefaultTableModel tblmodel = (DefaultTableModel) tblcategory.getModel();
        var arr = tblmodel.getDataVector();
        int row = tblcategory.getSelectedRow();

        txtcategory.setText(String.valueOf(arr.elementAt(row).elementAt(1)));
        txtstatus.setSelectedItem(arr.elementAt(row).elementAt(2));

    }//GEN-LAST:event_tblcategoryMouseClicked

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
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadd;
    private javax.swing.JButton ccancel;
    private javax.swing.JButton cdelete;
    private javax.swing.JButton cupdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblcategory;
    private javax.swing.JTextField txtcategory;
    private javax.swing.JTextField txtid;
    private javax.swing.JComboBox<String> txtstatus;
    // End of variables declaration//GEN-END:variables

    private Object getSelectedItem() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

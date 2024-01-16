/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package newlibrary;

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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Book extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pstmt;

    public Book() {
        initComponents();
        connect();
        view_category();
        view_author();
        view_publisher();
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

    private void view_category() {

        try {
            connection con = new connection();
            String q = "select Category from category";
            ResultSet res = con.stmt.executeQuery(q);
            while (res.next()) {
                comboboxcategory.addItem(res.getString("Category"));
            }
        } catch (SQLException ex) {
            // Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void view_author() {

        try {
            connection con = new connection();
            String q = "select name from author";
            ResultSet res = con.stmt.executeQuery(q);
            while (res.next()) {
                comboauthor.addItem(res.getString("name"));
            }
        } catch (SQLException ex) {
            // Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void view_publisher() {

        try {
            connection con = new connection();
            String q = "select publisher_name from publisher";
            ResultSet res = con.stmt.executeQuery(q);
            while (res.next()) {
                comboboxPublisher.addItem(res.getString("publisher_name"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtbook = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboboxcategory = new javax.swing.JComboBox<>();
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
        comboauthor = new javax.swing.JComboBox<>();
        comboboxPublisher = new javax.swing.JComboBox<>();
        txtno_of_page = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtquantity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        comboboxedition = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 0)));

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Book Name");

        txtbook.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtbook.setForeground(new java.awt.Color(204, 0, 0));
        txtbook.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jLabel2.setBackground(new java.awt.Color(255, 255, 0));
        jLabel2.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Category");

        comboboxcategory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboboxcategory.setForeground(new java.awt.Color(204, 0, 0));
        comboboxcategory.setToolTipText("");
        comboboxcategory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        comboboxcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxcategoryActionPerformed(evt);
            }
        });

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
        cupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cupdateActionPerformed(evt);
            }
        });

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
        jLabel3.setText("Book");

        jTable1.setBorder(javax.swing.BorderFactory.createMatteBorder(7, 7, 7, 7, new java.awt.Color(255, 255, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Name", "Category", "Author", "Publisher", "No Of Pages", "Edition", "Quantity", "Price", "Date / Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
        jLabel4.setText("Author");

        jLabel5.setBackground(new java.awt.Color(255, 255, 0));
        jLabel5.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Publisher");

        jLabel6.setBackground(new java.awt.Color(255, 255, 0));
        jLabel6.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("No of Pages");

        jLabel7.setBackground(new java.awt.Color(255, 255, 0));
        jLabel7.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Edition");

        comboauthor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboauthor.setForeground(new java.awt.Color(204, 0, 0));
        comboauthor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        comboboxPublisher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboboxPublisher.setForeground(new java.awt.Color(204, 0, 0));
        comboboxPublisher.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        txtno_of_page.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtno_of_page.setForeground(new java.awt.Color(204, 0, 0));
        txtno_of_page.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jLabel8.setBackground(new java.awt.Color(255, 255, 0));
        jLabel8.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("Quantity");

        txtquantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtquantity.setForeground(new java.awt.Color(204, 0, 0));
        txtquantity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jLabel9.setBackground(new java.awt.Color(255, 255, 0));
        jLabel9.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("Price");

        txtprice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtprice.setForeground(new java.awt.Color(204, 0, 0));
        txtprice.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        comboboxedition.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboboxedition.setForeground(new java.awt.Color(204, 0, 0));
        comboboxedition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th" }));
        comboboxedition.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("Search book ");

        txtid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtid.setForeground(new java.awt.Color(204, 0, 0));
        txtid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidKeyReleased(evt);
            }
        });

        jButton2.setText("Find");
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
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cdelete)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cadd, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(119, 119, 119)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ccancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cupdate))))
                                .addGap(47, 47, 47))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtbook)
                            .addComponent(comboboxcategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboauthor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboboxPublisher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtno_of_page)
                            .addComponent(txtquantity)
                            .addComponent(txtprice)
                            .addComponent(comboboxedition, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(31, 31, 31))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboboxcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboboxPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtno_of_page, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboboxedition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ccancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboboxcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxcategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxcategoryActionPerformed

    private void caddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caddActionPerformed

        String book_name = txtbook.getText();
        String category = comboboxcategory.getSelectedItem().toString();
        String author = comboauthor.getSelectedItem().toString();
        String publisher = comboboxPublisher.getSelectedItem().toString();
        String no_of_page = txtno_of_page.getText();
        String edition = comboboxedition.getSelectedItem().toString();
        String quantity = txtquantity.getText();
        String price = txtprice.getText();
        String available_qty = txtquantity.getText();
        int issuue_qty = 0;

//        int avilable_quantity = Integer.parseInt(txtquantity.getText());
//       
        if (txtbook.getText().trim().isEmpty() || comboboxcategory.getSelectedItem().toString().trim().isEmpty() || comboboxPublisher.getSelectedItem().toString().trim().isEmpty() || comboauthor.getSelectedItem().toString().trim().isEmpty() || txtno_of_page.getText().trim().isEmpty() || txtquantity.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Field is mandatory");
            txtbook.setText(" ");
            txtno_of_page.setText("");
            txtquantity.setText(" ");
        } else {

            String sql = "insert into book(book_name,category,author,publisher,no_of_pages,edition,book_quantity,price,date)"
                    + "values('" + book_name + "','" + category + "','" + author + "','" + publisher + "','" + no_of_page + "','" + edition + "','" + quantity + "','" + price + "',default)";
            try {
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Book added in book and View quantitySuccessfully");

                // insert data into a new table view_quantity
                String sql1 = "insert into view_quantity(issuue_qty,book_name,book_category,author_name,publisher,Available_qty)"
                        + "values('" + issuue_qty + "','" + book_name + "','" + category + "','" + author + "','" + publisher + "','" + available_qty + "')";
                stmt.executeUpdate(sql1);

                //Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_caddActionPerformed

    private void ccancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccancelActionPerformed
        String sql = "select * from book";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getNString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)});
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());

        }
    }//GEN-LAST:event_ccancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cupdateActionPerformed

        String book_name = txtbook.getText();
        String category = comboboxcategory.getSelectedItem().toString();
        String author = comboauthor.getSelectedItem().toString();
        String publisher = comboboxPublisher.getSelectedItem().toString();
        String no_of_page = txtno_of_page.getText();
        String edition = comboboxedition.getSelectedItem().toString();
        String quantity = txtquantity.getText();
        String price = txtprice.getText();
        String id;

        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            var arr = model.getDataVector();

            if (arr.isEmpty()) {
                return;
            }

            int row = jTable1.getSelectedRow();
            id = String.valueOf(arr.elementAt(row).elementAt(0));

            String sql = "update book set book_name='" + book_name + "',category='" + category + "',author='" + author + "',publisher='" + publisher + "',no_of_pages='" + no_of_page + "',edition='" + edition + "',quantity='" + quantity + "',price='" + price + "',where id=" + id;
            //System.out.println(id);
            //System.out.println("update author set name='" + name + "', address='" + address + "', email='" + email + "', phone = '" + phone + "' where id=" + id);
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Data updated successfully");

            for (int i = 0; i < arr.size(); i++) {
                // System.out.println(id);
                if (arr.elementAt(i).elementAt(0).toString().equals(id)) {
                    System.out.println(model.getValueAt(i, 1));
                    model.setValueAt(book_name, i, 1);
                    model.setValueAt(category, i, 2);
                    model.setValueAt(author, i, 3);
                    model.setValueAt(publisher, i, 4);
                    model.setValueAt(no_of_page, i, 5);
                    model.setValueAt(edition, i, 6);
                    model.setValueAt(quantity, i, 7);
                    model.setValueAt(price, i, 8);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_cupdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            PreparedStatement pst = con.prepareStatement("select * from book where id=?");
            int id = Integer.parseInt(txtid.getText());
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next() == false) {

                JOptionPane.showMessageDialog(this, "Sorry Record is not found");
                txtbook.setText("");
                txtno_of_page.setText("");
                txtquantity.setText("");
                txtprice.setText("");
            } else {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8)});

            }

        } catch (Exception e) {
            System.out.println(e);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyReleased
        DefaultTableModel Df = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(Df);
        jTable1.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(txtid.getText()));
    }//GEN-LAST:event_txtidKeyReleased

    private void cdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdeleteActionPerformed
        int row = jTable1.getSelectedRow();
        String cell = jTable1.getModel().getValueAt(row, 0).toString();
        String sql = "DELETE FROM book where id=" + cell;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.execute();

            JOptionPane.showMessageDialog(this, "Delete update table successfully");
            //view_author();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_cdeleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        connection con1 = new connection();
        DefaultTableModel tblmodel = (DefaultTableModel) jTable1.getModel();
        var arr = tblmodel.getDataVector();
        int row = jTable1.getSelectedRow();

        txtbook.setText(String.valueOf(arr.elementAt(row).elementAt(1)));
        comboboxcategory.setSelectedItem(arr.elementAt(row).elementAt(2));
        comboboxPublisher.setSelectedItem(arr.elementAt(row).elementAt(4));
        comboauthor.setSelectedItem(arr.elementAt(row).elementAt(3));
        txtno_of_page.setText(String.valueOf(arr.elementAt(row).elementAt(5)));
        comboboxedition.setSelectedItem(arr.elementAt(row).elementAt(6));
        txtquantity.setText(String.valueOf(arr.elementAt(row).elementAt(7)));
        txtprice.setText(String.valueOf(arr.elementAt(row).elementAt(8)));

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadd;
    private javax.swing.JButton ccancel;
    private javax.swing.JButton cdelete;
    private javax.swing.JComboBox<String> comboauthor;
    private javax.swing.JComboBox<String> comboboxPublisher;
    private javax.swing.JComboBox<String> comboboxcategory;
    private javax.swing.JComboBox<String> comboboxedition;
    private javax.swing.JButton cupdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtbook;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtno_of_page;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtquantity;
    // End of variables declaration//GEN-END:variables

}

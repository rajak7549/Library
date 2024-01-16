/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package newlibrary;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ReturnBook extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    ResultSet rs;

    public ReturnBook() {
        initComponents();
        connect();
        //view_category();
        //view_category1();
        //view_category2();
        //view_bookname();
        //view_edition();
        // view_issue();
        //returndate();
        //issuedate();
        // total_days();

    }

    public void connect() {
        try {
            // Properties user = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "");
            if (con != null) {
                // System.out.println("Connect succesfuly");
                stmt = con.createStatement();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")

    // code for access data on table....\
    private void book_view() {
        int c;
        try {
            //connection con = new connection();

            String book_record = "select * from issue_book";
            ResultSet rest = stmt.executeQuery(book_record);

            ResultSetMetaData Rss = (ResultSetMetaData) rest.getMetaData();
            c = Rss.getColumnCount();

            DefaultTableModel model = (DefaultTableModel) tblIssueBook.getModel();

            model.setRowCount(0);
            while (rest.next()) {
                Vector v2 = new Vector();
                for (int a = 1; a <= c; a++) {

                    v2.add(rest.getString("book_id"));
                    v2.add(rest.getString("book_name"));
                    v2.add(rest.getString("category"));
                    v2.add(rest.getString("author_name"));
                    v2.add(rest.getString("publisher_name"));
                    v2.add(rest.getString("price"));
                    v2.add(rest.getString("quantity"));

                }
                model.addRow(v2);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void total_days() {

        ZoneId z = ZoneId.of("Asia/Colombia");
        LocalDate today = LocalDate.now(z);
        // String currentDate=today.toString();
        SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
        String Firstdate = txtireturndate.getText();
        String SecondDate = txtissuedate.getText();

        try {
            Date date1 = myformat.parse(Firstdate);
            Date date2 = myformat.parse(SecondDate);

            long diff = date1.getTime() - date2.getTime();

            int dayBetweenDates = (int) (diff / 1000 * 60 * 60 * 24);
//            txttotaldays.setText(dayBetweenDates);
            System.out.println(dayBetweenDates);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void returndate() {

        try {
            connection con = new connection();
            String q = "select Return_date from return_book";
            ResultSet res = con.stmt.executeQuery(q);
            while (res.next()) {
                txtissuedate.setText(res.getString("Return_date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void issuedate() {

        try {
            connection con = new connection();
            String q = "select Issue_date from issue_book";
            ResultSet res = con.stmt.executeQuery(q);
            while (res.next()) {
                txtireturndate.setText(res.getString("Issue_date"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void view_category() {

        try {
            connection con = new connection();
            String q = "select Category from category";
            ResultSet res = con.stmt.executeQuery(q);
            while (res.next()) {
                cmbcategory.addItem(res.getString("Category"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void view_category1() {

        try {
            connection con = new connection();
            String q = "select name from author";
            ResultSet res = con.stmt.executeQuery(q);
            while (res.next()) {
                cmbAuthorName.addItem(res.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void view_category2() {

        try {
            connection con = new connection();
            String q = "select publisher_name from publisher";
            ResultSet res = con.stmt.executeQuery(q);
            while (res.next()) {
                cmbPublisherName.addItem(res.getString("publisher_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void view_bookname() {

        try {
            connection con = new connection();
            String q = "select book_name from book";
            ResultSet res = con.stmt.executeQuery(q);
            while (res.next()) {
                cmbBookName.addItem(res.getString("book_name"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void view_edition() {

        try {
            connection con = new connection();
            String q = "select edition from book";
            ResultSet res = con.stmt.executeQuery(q);
            while (res.next()) {
                txtIssueQuantity.setText(res.getString("edition"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void view_issue() {

        try {
            connection con = new connection();
            String q = "select Issue_date from issue_date";
            ResultSet res = con.stmt.executeQuery(q);
            while (res.next()) {
                txtissuedate.setText(res.getString("Issue_date"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtmemberid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();
        ccancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIssueBook = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbcategory = new javax.swing.JComboBox<>();
        cmbAuthorName = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtireturndate = new javax.swing.JTextField();
        txtmembername = new javax.swing.JTextField();
        cmbPublisherName = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbBookName = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtIssueQuantity = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txtIssueId = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtissuedate = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtfine = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txttotaldays = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Member Id");

        txtmemberid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtmemberid.setForeground(new java.awt.Color(204, 0, 0));
        txtmemberid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jLabel2.setBackground(new java.awt.Color(255, 255, 0));
        jLabel2.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Member Name");

        btnReturn.setBackground(new java.awt.Color(204, 0, 0));
        btnReturn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReturn.setForeground(new java.awt.Color(255, 255, 0));
        btnReturn.setText("Return");
        btnReturn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        ccancel.setBackground(new java.awt.Color(204, 0, 0));
        ccancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ccancel.setForeground(new java.awt.Color(255, 255, 0));
        ccancel.setText("View");
        ccancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        ccancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccancelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Harrington", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Return Book");

        tblIssueBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "member id", "Member Name", "Book Category", "Author Name", "Publisher Name", "Book Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIssueBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIssueBookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIssueBook);

        jLabel4.setBackground(new java.awt.Color(255, 255, 0));
        jLabel4.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Book Category");

        jLabel5.setBackground(new java.awt.Color(255, 255, 0));
        jLabel5.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Author Nmae");

        jLabel6.setBackground(new java.awt.Color(255, 255, 0));
        jLabel6.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("Publisher Name");

        cmbcategory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbcategory.setForeground(new java.awt.Color(204, 0, 0));
        cmbcategory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        cmbAuthorName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbAuthorName.setForeground(new java.awt.Color(204, 0, 0));
        cmbAuthorName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        cmbAuthorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAuthorNameActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 0));
        jLabel8.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("Return Date");

        txtireturndate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtireturndate.setForeground(new java.awt.Color(204, 0, 0));
        txtireturndate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        txtmembername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtmembername.setForeground(new java.awt.Color(204, 0, 0));
        txtmembername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        cmbPublisherName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbPublisherName.setForeground(new java.awt.Color(204, 0, 0));
        cmbPublisherName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jLabel9.setBackground(new java.awt.Color(255, 255, 0));
        jLabel9.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("Book Name");

        cmbBookName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbBookName.setForeground(new java.awt.Color(204, 0, 0));
        cmbBookName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        cmbBookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBookNameActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 0));
        jLabel10.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("Issue quantity");

        txtIssueQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtIssueQuantity.setForeground(new java.awt.Color(204, 0, 0));
        txtIssueQuantity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtIssueId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtIssueId.setForeground(new java.awt.Color(204, 0, 0));
        txtIssueId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        txtIssueId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIssueIdKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 0));
        jLabel11.setText("Issue iD");

        jLabel12.setBackground(new java.awt.Color(255, 255, 0));
        jLabel12.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));
        jLabel12.setText("Issue date");

        txtissuedate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtissuedate.setForeground(new java.awt.Color(204, 0, 0));
        txtissuedate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jLabel13.setBackground(new java.awt.Color(255, 255, 0));
        jLabel13.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setText("Fine");

        txtfine.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtfine.setForeground(new java.awt.Color(204, 0, 0));
        txtfine.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jLabel14.setBackground(new java.awt.Color(255, 255, 0));
        jLabel14.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setText("Total Days");

        txttotaldays.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txttotaldays.setForeground(new java.awt.Color(204, 0, 0));
        txttotaldays.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        txttotaldays.setName(""); // NOI18N

        jButton3.setBackground(new java.awt.Color(153, 0, 0));
        jButton3.setFont(new java.awt.Font("Harrington", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 0));
        jButton3.setText("Search");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 0, 0));
        jButton5.setFont(new java.awt.Font("Harrington", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 0));
        jButton5.setText("Total");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ccancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(87, 87, 87)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(txtIssueId, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(txtmemberid, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(txtmembername, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(cmbcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(cmbAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel6)
                            .addGap(36, 36, 36)
                            .addComponent(cmbPublisherName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(66, 66, 66)
                            .addComponent(cmbBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(66, 66, 66)
                            .addComponent(txtIssueQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(74, 74, 74)
                            .addComponent(txtissuedate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel8)
                            .addGap(65, 65, 65)
                            .addComponent(txtireturndate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(74, 74, 74)
                            .addComponent(txttotaldays, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(82, 82, 82)
                            .addComponent(txtfine, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(267, 267, 267)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(766, 766, 766)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtIssueId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(jButton3)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtmemberid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(txtmembername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cmbcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cmbAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cmbPublisherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cmbBookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtIssueQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtissuedate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel8))
                            .addComponent(txtireturndate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(txttotaldays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtfine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ccancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed

        String member_id = txtmemberid.getText();
        String member_name = txtmembername.getText();
        String book_category = cmbcategory.getSelectedItem().toString();
        String author_name = cmbAuthorName.getSelectedItem().toString();
        String publisher_name = cmbPublisherName.getSelectedItem().toString();
        String book_name = cmbBookName.getSelectedItem().toString();
        String edition = txtIssueQuantity.getText();
        String total_days = txttotaldays.getText();
        String fine = txtfine.getText();
        try {
            String query = "INSERT INTO return_book VALUES"
                    + "(DEFAULT, ?, ?, ?, ?, ?, ?, ?,?,DEFAULT, DEFAULT, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, Integer.parseInt(member_id));
            pstmt.setString(2, member_name);
            pstmt.setString(3, book_category);
            pstmt.setString(4, author_name);
            pstmt.setString(5, publisher_name);
            pstmt.setString(6, book_name);
            pstmt.setString(7, edition);
            pstmt.setString(8, edition);
            pstmt.setInt(9, Integer.parseInt(total_days));
            pstmt.setInt(10, Integer.parseInt(fine));

            //String query1 = "update issue_book set avaliable_quantity=avaliable_quantity+quantity where book_id='" + book_return + "'";
            // PreparedStatement pstmt1 = con.prepareStatement(query1);
            // pstmt1.executeUpdate();
            JOptionPane.showMessageDialog(this, "Book are returned");

        } catch (SQLException ex) {
            System.out.print(ex);
            //Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (txtmemberid.getText().equals("") || txtmembername.getText().equals("") || cmbcategory.getSelectedItem().toString().equals("") || cmbAuthorName.getSelectedItem().toString().equals("") || cmbPublisherName.getSelectedItem().equals("") || cmbAuthorName.getSelectedItem().toString().equals("") || cmbBookName.getSelectedItem().equals("") || cmbAuthorName.getSelectedItem().toString().equals("") || txtIssueQuantity.getText().equals("") || txttotaldays.getText().equals("") || txtfine.getText().equals("")) {

            JOptionPane.showMessageDialog(this, "Please enter all data");
        } else {

            String data[] = {txtmemberid.getText(), txtmembername.getText(), cmbcategory.getSelectedItem().toString(), cmbAuthorName.getSelectedItem().toString(), cmbPublisherName.getSelectedItem().toString(), cmbBookName.getSelectedItem().toString(), txtIssueQuantity.getText(), txtireturndate.getText(), txtissuedate.getText(), txttotaldays.getText(), txtfine.getText()};

            DefaultTableModel tablModel = (DefaultTableModel) tblIssueBook.getModel();

            tablModel.addRow(data);

            JOptionPane.showMessageDialog(this, "Add data successfully");

            txtmemberid.setText("");
            txtmembername.setText("");
            cmbcategory.setSelectedItem("");
            cmbAuthorName.setSelectedItem("");
            cmbPublisherName.setSelectedItem("");
            cmbBookName.setSelectedItem("");
            txtIssueQuantity.setText("");
            txtireturndate.setText("");
            txtissuedate.setText("");
            txttotaldays.setText("");
            txtfine.setText("");

        }

    }//GEN-LAST:event_btnReturnActionPerformed

    private void ccancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccancelActionPerformed
//        String sql = "select * from return_book";

        try {

            //connection con=new connection();
            String sql = "select * from issue_book";

            ResultSet rs = stmt.executeQuery(sql);

            DefaultTableModel model = (DefaultTableModel) tblIssueBook.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());

        }

    }//GEN-LAST:event_ccancelActionPerformed

    private void cmbAuthorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAuthorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAuthorNameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtIssueIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIssueIdKeyReleased
        DefaultTableModel Df = (DefaultTableModel) tblIssueBook.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(Df);
        tblIssueBook.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(txtIssueId.getText()));
    }//GEN-LAST:event_txtIssueIdKeyReleased

    private void tblIssueBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIssueBookMouseClicked
        connection con1 = new connection();
        DefaultTableModel tblmodel = (DefaultTableModel) tblIssueBook.getModel();
        var arr = tblmodel.getDataVector();
        int row = tblIssueBook.getSelectedRow();
        txtIssueId.setText(String.valueOf(arr.elementAt(row).elementAt(1)));
        txtmemberid.setText(String.valueOf(arr.elementAt(row).elementAt(2)));
        txtmembername.setText(String.valueOf(arr.elementAt(row).elementAt(3)));
        cmbcategory.setSelectedItem(arr.elementAt(row).elementAt(4));
        cmbAuthorName.setSelectedItem(arr.elementAt(row).elementAt(5));
        cmbPublisherName.setSelectedItem(arr.elementAt(row).elementAt(6));
        cmbBookName.setSelectedItem(arr.elementAt(row).elementAt(7));
        txtIssueQuantity.setText(String.valueOf(arr.elementAt(row).elementAt(10)));
        txtissuedate.setText(String.valueOf(arr.elementAt(row).elementAt(9)));
    }//GEN-LAST:event_tblIssueBookMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String issue_id = txtIssueId.getText();
        String sql = "select * from issue_book where id= " + issue_id;
        try {
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtmemberid.setText(rs.getString("member_id"));
                txtmembername.setText(rs.getString("member_name"));
                cmbcategory.addItem(rs.getString("book_category"));
                cmbAuthorName.addItem(rs.getString("author_name"));
                cmbPublisherName.addItem(rs.getString("publisher_name"));
                txtIssueQuantity.setText(rs.getString("issue_quantity"));
                cmbBookName.addItem(rs.getString("book_name"));
                txtissuedate.setText(rs.getString("Issue_date"));

            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //  ZoneId z = ZoneId.of("Asia/Colombia");
        //LocalDate today = LocalDate.now();
        String currentDate = txtireturndate.getText();
        SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
        String Firstdate = txtissuedate.getText();
        String SecondDate = currentDate;
        long dayBetweenDates;

        try {
            Date date1 = myformat.parse(Firstdate);
            Date date2 = myformat.parse(SecondDate);

            long diff = date1.getTime() - date2.getTime();

            dayBetweenDates = (long) (diff / (1000 * 60 * 60 * 24));
            long x = Math.abs(dayBetweenDates);
            txttotaldays.setText(x + "");
            int date12 = Integer.parseInt(txttotaldays.getText());

            int total_day = date12 - 5;

            if (total_day <= 5) {
                JOptionPane.showMessageDialog(this, "NO fine Paid");
                txtfine.setText(0 + "");

            } else {
                //int fine = (total_day * 5);
                txttotaldays.setText("" + total_day);
                int fine = (total_day * 5);
                txtfine.setText(fine + "");

            }
            System.out.println(dayBetweenDates);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void cmbBookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBookNameActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton ccancel;
    private javax.swing.JComboBox<String> cmbAuthorName;
    private javax.swing.JComboBox<String> cmbBookName;
    private javax.swing.JComboBox<String> cmbPublisherName;
    private javax.swing.JComboBox<String> cmbcategory;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblIssueBook;
    private javax.swing.JTextField txtIssueId;
    private javax.swing.JTextField txtIssueQuantity;
    private javax.swing.JTextField txtfine;
    private javax.swing.JTextField txtireturndate;
    private javax.swing.JTextField txtissuedate;
    private javax.swing.JTextField txtmemberid;
    private javax.swing.JTextField txtmembername;
    private javax.swing.JTextField txttotaldays;
    // End of variables declaration//GEN-END:variables

}

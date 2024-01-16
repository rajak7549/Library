package newlibrary;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class IssueBook extends javax.swing.JFrame {

    Connection con;
    Statement stmt;
    PreparedStatement pstmt;

    public IssueBook() {
        initComponents();
        connect();
        // view_publisher();
        //view_category();
        //view_author();
        //view_bookname();
        Issue_date();

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
                combobookCategory.addItem(res.getString("Category"));
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
                combopublisher.addItem(res.getString("publisher_name"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Issue_date() {

        try {
            connection con = new connection();
            String q = "select Issue_date from issue_book";
            ResultSet res = con.stmt.executeQuery(q);
            while (res.next()) {
                txtissuedate.setText(res.getString("Issue_date"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void view_bookname() {

        try {
            connection con = new connection();
            String q = "select book_name from book";
            ResultSet res = con.stmt.executeQuery(q);
            while (res.next()) {
                combobookname.addItem(res.getString("book_name"));
            }
        } catch (SQLException ex) {
            //Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void book_quantity() {

        String sql = "select quantity from book";
        try {
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                txtavaliablquantity.setText(rs.getString("quantity"));

            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());

        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        cadd = new javax.swing.JButton();
        cupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        ccancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblauthor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combobookCategory = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtmemberid = new javax.swing.JTextField();
        txtmembername = new javax.swing.JTextField();
        combobookname = new javax.swing.JComboBox<>();
        comboauthor = new javax.swing.JComboBox<>();
        combopublisher = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtissuedate = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtavaliablquantity = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtbookid = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtissueqty = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));

        cadd.setBackground(new java.awt.Color(204, 0, 0));
        cadd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cadd.setForeground(new java.awt.Color(255, 255, 0));
        cadd.setText("Issue");
        cadd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        cadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caddActionPerformed(evt);
            }
        });

        cupdate.setBackground(new java.awt.Color(204, 0, 0));
        cupdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cupdate.setForeground(new java.awt.Color(255, 255, 0));
        cupdate.setText("Update");
        cupdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        cupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cupdateActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(204, 0, 0));
        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 0));
        btndelete.setText("Delete");
        btndelete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        ccancel.setBackground(new java.awt.Color(204, 0, 0));
        ccancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
        jLabel3.setText("Issue Book");

        tblauthor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblauthor.setForeground(new java.awt.Color(204, 0, 0));
        tblauthor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Issue Id", "Member Id", "Member Name", "Book Category", "Author Name", "Publisher Name", "Book Name", "Price", "Issue Date", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
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
        tblauthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblauthorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblauthor);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtid.setForeground(new java.awt.Color(204, 0, 0));
        txtid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidKeyReleased(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 0));
        jButton2.setText("SearchTable");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 3, true));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("Searching data");

        jLabel7.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("Book Category");

        combobookCategory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        combobookCategory.setForeground(new java.awt.Color(204, 0, 0));
        combobookCategory.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));
        combobookCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobookCategoryActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 0));
        jLabel8.setText("Author Name");

        jLabel9.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("Book Name");

        jLabel10.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 0));
        jLabel10.setText("Publisher Name");

        jLabel11.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 0));
        jLabel11.setText("Member Id");

        jLabel12.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));
        jLabel12.setText("Member Name");

        txtmemberid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtmemberid.setForeground(new java.awt.Color(204, 0, 0));
        txtmemberid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        txtmembername.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtmembername.setForeground(new java.awt.Color(204, 0, 0));
        txtmembername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        combobookname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        combobookname.setForeground(new java.awt.Color(204, 0, 0));
        combobookname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        comboauthor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboauthor.setForeground(new java.awt.Color(204, 0, 0));
        comboauthor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        combopublisher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        combopublisher.setForeground(new java.awt.Color(204, 0, 0));
        combopublisher.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jLabel14.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setText("Issuedate");

        txtissuedate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtissuedate.setForeground(new java.awt.Color(204, 0, 0));
        txtissuedate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jLabel15.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 0));
        jLabel15.setText("Available quantity");

        txtavaliablquantity.setEditable(false);
        txtavaliablquantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtavaliablquantity.setForeground(new java.awt.Color(204, 0, 0));
        txtavaliablquantity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 0));
        jButton3.setText("Book id");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 3, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 0));
        jLabel16.setText("Book id");

        txtbookid.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtbookid.setForeground(new java.awt.Color(204, 0, 0));
        txtbookid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jLabel17.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 0));
        jLabel17.setText("Issue quantity");

        txtissueqty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtissueqty.setForeground(new java.awt.Color(204, 0, 0));
        txtissueqty.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 4, true));

        jButton4.setBackground(new java.awt.Color(204, 0, 0));
        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 0));
        jButton4.setText("Member");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 0), 3, true));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cadd, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel12))
                                    .addGap(92, 92, 92)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(combopublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(combobookCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtmembername, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtbookid, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton3)
                                            .addComponent(txtmemberid, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton4))
                                        .addComponent(combobookname, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtissuedate, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtavaliablquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtissueqty, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ccancel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(0, 33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmemberid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbookid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmembername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobookCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combopublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combobookname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtissuedate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtavaliablquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtissueqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ccancel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
//        // TODO add your handling code here:
//        int qty = 0;
//        String s = dropDownId.getSelectedItem().toString();
//        int id = Integer.parseInt(s);
//        String bookno = txtbookno.getText();
//        String bookname = txtbookname.getText();
//        int studentid = Integer.parseInt(txtstudentid.getText());
//        String studentname = txtstudentname.getText();
//        String studentcontact = txtstudentcontact.getText();
//        String date = new java.util.Date().toString();
//        try {
//            ConnectionClass connDb1 = new ConnectionClass();
//            String q = "select qty from addbook where id='" + id + "'";
//            ResultSet resval = connDb1.sm.executeQuery(q);
//            while (resval.next()) {
//                qty = Integer.parseInt(resval.getString("qty"));
//                if (qty <= 0) {
//                    JOptionPane.showMessageDialog(null, "no stock");
//                    
//                } else {
//                    String q2 = "insert into issuebook(id,book_no,bookname,student_id,student_nm,student_contact,date)values('" + id + "','" + bookno + "','" + bookname + "','" + studentid + "','" + studentname + "','" + studentcontact + "','" + date + "')";
//                    String q3 = "update addbook set issuebook=issuebook+1 where id='" + id + "'";
//                    String q4 = "update addbook set qty=qty-1 where id='" + id + "'";
//                    int q2_execute = connDb1.sm.executeUpdate(q2);
//                    int q3_execute = connDb1.sm.executeUpdate(q3);
//                    int q4_execute = connDb1.sm.executeUpdate(q4);
//                    if (q2_execute == 1) {
//                        if (q3_execute == 1) {
//                            if (q4_execute == 1) {
//                                JOptionPane.showMessageDialog(null, "Book issued");
//                            } else {
//                                JOptionPane.showMessageDialog(null, "data error");
//                                
//                            }
//                            
//                        } else {
//                            JOptionPane.showMessageDialog(null, "fill the data carefully");
//                            
//                        }
//                        
//                    } else {
//                        JOptionPane.showMessageDialog(null, "fill the data");
//                    }
//                    
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }             
    private void caddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caddActionPerformed
        String member_id = txtmemberid.getText();
        String member_name = txtmembername.getText();
        String book_category = combobookCategory.getSelectedItem().toString();
        String author = comboauthor.getSelectedItem().toString();
        String publisher = combopublisher.getSelectedItem().toString();
        String book_name = combobookname.getSelectedItem().toString();
        String avialable_quantity = txtavaliablquantity.getText();
        String issuequantity = txtissueqty.getText();
        String book_id = txtbookid.getText();
        //String issue_date = txtissuedate.getText();
        LocalDateTime ldt = LocalDateTime.now();

        String Issue_date = (DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt));

        //System.out.println(Issue_date);
        txtissuedate.setText(Issue_date + "");
        try {
            String query = "INSERT INTO issue_book VALUES"
                    + "(DEFAULT, ?, ?, ?, ?, ?, ?,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(query);

            pstmt.setInt(1, Integer.parseInt(member_id));
            pstmt.setString(2, member_name);
            pstmt.setString(3, book_category);
            pstmt.setString(4, author);
            pstmt.setString(5, publisher);
            pstmt.setString(6, book_name);
            pstmt.setInt(7, Integer.parseInt(avialable_quantity));
            pstmt.setString(9, issuequantity);
            pstmt.setString(8, Issue_date);
            // pstmt.setString(10, book_id);

            pstmt.executeUpdate();
            String query1 = "update issue_book set avaliable_quantity=avaliable_quantity-issue_quantity where book_id=" + book_id;
            PreparedStatement pstmt1 = con.prepareStatement(query1);
            pstmt1.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex);
            //Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (txtmemberid.getText().equals("") || txtmembername.getText().equals("") || combobookCategory.getSelectedItem().toString().equals("") || comboauthor.getSelectedItem().toString().equals("") || combopublisher.getSelectedItem().toString().equals("") || combobookname.getSelectedItem().toString().equals("")) {

            JOptionPane.showMessageDialog(this, "Please enter all data");
        } else {

            String data[] = {txtmemberid.getText(), txtmembername.getText(), combobookCategory.getSelectedItem().toString(), comboauthor.getSelectedItem().toString(), combopublisher.getSelectedItem().toString(), combobookname.getSelectedItem().toString(), txtissuedate.getText()};

            DefaultTableModel tablModel = (DefaultTableModel) tblauthor.getModel();

            tablModel.addRow(data);

            JOptionPane.showMessageDialog(this, "Add data successfully");

            txtmemberid.setText("");
            txtmembername.setText("");

        }

    }//GEN-LAST:event_caddActionPerformed

    private void ccancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccancelActionPerformed
        String sql = "select * from issue_book";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tblauthor.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)});
            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());

        }
    }//GEN-LAST:event_ccancelActionPerformed

    private void cupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cupdateActionPerformed

        String member_id = txtmemberid.getText();
        String member_name = txtmembername.getText();
        String book_category = combobookCategory.getSelectedItem().toString();
        String author = comboauthor.getSelectedItem().toString();
        String publisher = combopublisher.getSelectedItem().toString();
        String book_name = combobookname.getSelectedItem().toString();

        String id;

        if (txtmemberid.getText().trim().isEmpty() || txtmembername.getText().trim().isEmpty() || combobookCategory.getSelectedItem().toString().trim().isEmpty() || comboauthor.getSelectedItem().toString().trim().isEmpty() || combopublisher.getSelectedItem().toString().trim().isEmpty() || combobookname.getSelectedItem().toString().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please Enter all Data");

        } else {

            try {
                DefaultTableModel model = (DefaultTableModel) tblauthor.getModel();
                var arr = model.getDataVector();

                if (arr.isEmpty()) {
                    return;
                }

                int row = tblauthor.getSelectedRow();
                id = String.valueOf(arr.elementAt(row).elementAt(0));

                String sql = "update issue_book set member_id='" + member_id + "', member_name='" + member_name + "', book_category='" + book_category + "', author_name = '" + author + "',publisher_name = '" + publisher + "',book_name = '" + book_name + "' where id=" + id;
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Data updated successfully");

                for (int i = 0; i < arr.size(); i++) {
                    // System.out.println(id);
                    if (arr.elementAt(i).elementAt(0).toString().equals(id)) {
                        System.out.println(model.getValueAt(i, 1));
                        model.setValueAt(member_id, i, 1);
                        model.setValueAt(member_name, i, 2);
                        model.setValueAt(book_category, i, 3);
                        model.setValueAt(author, i, 4);
                        model.setValueAt(publisher, i, 5);
                        model.setValueAt(book_name, i, 6);

                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }//GEN-LAST:event_cupdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed

        int row = tblauthor.getSelectedRow();
        String cell = tblauthor.getModel().getValueAt(row, 0).toString();
        String sql = "DELETE FROM issue_book where id=" + cell;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.execute();

            JOptionPane.showMessageDialog(this, "Delete update table successfully");
            view_author();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_btndeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//        try {
//
//            PreparedStatement pst = con.prepareStatement("select * from publisher where id=?");
//            int id = Integer.parseInt(txtid.getText());
//            pst.setInt(1, id);
//            ResultSet rs = pst.executeQuery();
//
//            if (rs.next() == false) {
//
//                JOptionPane.showMessageDialog(this, "Sorry Record is not found");
//                txtAuthorName.setText("");
//                txtaddress.setText("");
//                txtphone.setText("");
//                txtemail.setText("");
//            } else {
//                DefaultTableModel model = (DefaultTableModel) tblauthor.getModel();
//                model.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5)});
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//
//        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblauthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblauthorMouseClicked
        connection con1 = new connection();
        DefaultTableModel tblmodel = (DefaultTableModel) tblauthor.getModel();
        var arr = tblmodel.getDataVector();
        int row = tblauthor.getSelectedRow();

        txtmemberid.setText(String.valueOf(arr.elementAt(row).elementAt(1)));
        txtmembername.setText(String.valueOf(arr.elementAt(row).elementAt(2)));
        combobookCategory.setSelectedItem(arr.elementAt(row).elementAt(3));
        comboauthor.setSelectedItem(arr.elementAt(row).elementAt(4));
        combopublisher.setSelectedItem(arr.elementAt(row).elementAt(5));
        combobookname.setSelectedItem(arr.elementAt(row).elementAt(6));

        txtissuedate.setText(String.valueOf(arr.elementAt(row).elementAt(7)));
        txtavaliablquantity.setText(String.valueOf(arr.elementAt(row).elementAt(8)));

    }//GEN-LAST:event_tblauthorMouseClicked

    private void txtidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyReleased
        DefaultTableModel Df = (DefaultTableModel) tblauthor.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(Df);
        tblauthor.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(txtid.getText()));
    }//GEN-LAST:event_txtidKeyReleased

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String book_id = txtbookid.getText();
        if (txtbookid.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "hello data error");
        } else {
            try {
                connection con = new connection();
                String q = "select * from book where id='" + book_id + "'";
                ResultSet res = con.stmt.executeQuery(q);
                while (res.next()) {
                    combobookname.addItem(res.getString("book_name"));
                    comboauthor.addItem(res.getString("author"));
                    combopublisher.addItem(res.getString("publisher"));
                    combobookCategory.addItem(res.getString("category"));
                    txtavaliablquantity.setText(res.getString("book_quantity"));
                    //combopublisher.addItem(res.getString("publisher_name"));

//                    String q2 = "select * from issue_book where book_id='" + book_id + "'";
//                    ResultSet res1 = con.stmt.executeQuery(q2);
//                    while (res1.next()) {
//                        txtissuedate.setText(res1.getString("Issue_date"));
//                    }
                }
            } catch (SQLException ex) {
                //Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void combobookCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobookCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobookCategoryActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String id = txtmemberid.getText();
        String sql = "select * from member where ID= " + id;
        try {
            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                txtmembername.setText(rs.getString("member_name"));

            }

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());

        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton cadd;
    private javax.swing.JButton ccancel;
    private javax.swing.JComboBox<String> comboauthor;
    private javax.swing.JComboBox<String> combobookCategory;
    private javax.swing.JComboBox<String> combobookname;
    private javax.swing.JComboBox<String> combopublisher;
    private javax.swing.JButton cupdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblauthor;
    private javax.swing.JTextField txtavaliablquantity;
    private javax.swing.JTextField txtbookid;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtissuedate;
    private javax.swing.JTextField txtissueqty;
    private javax.swing.JTextField txtmemberid;
    private javax.swing.JTextField txtmembername;
    // End of variables declaration//GEN-END:variables

}

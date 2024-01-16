/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newlibrary;

import java.sql.*;
import newlibrary.ResultSet;

public class connection {

    Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;

    connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "");
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            // Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new connection();
    }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

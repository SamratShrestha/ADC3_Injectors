/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ica
 */
public class DbConnection {

//    private Connection con;
    private static final String url = "jdbc:mysql://localhost:3306/injectors";
    private static final String dbusername = "niit";
    private static final String dbpassword = "";
//    public DbConnection(){
//        con=null;
//    }

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, dbusername, dbpassword);
        } catch (Exception e) {
            con.close();
            System.out.println(e);
        }
        return con;
    }
}

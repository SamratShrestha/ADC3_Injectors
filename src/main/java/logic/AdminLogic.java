/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.DbConnection;
import model.Admin;
import model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ica
 */
public class AdminLogic {

    private PreparedStatement pstm;
    private Connection con;

    public boolean validateAdmin(Admin admin) throws SQLException {
        try {
            DbConnection db = new DbConnection();
            con = db.createConnection();
            pstm = con.prepareStatement("select * from admin where username=? and password=?;");
            pstm.setString(1, admin.getUsername());
            pstm.setString(2, admin.getUsername());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
            pstm.close();
        }
        return false;
    }

    public boolean addClient(Client client) throws SQLException {
        int res =0;
        try {
            DbConnection db = new DbConnection();
            con = db.createConnection();
            pstm = con.prepareStatement("insert into admin values(null,?,?,?,?,?,?,?,CURDATE(),?,?,?)");
            pstm.setString(1, client.getFirstname());
            pstm.setString(2, client.getLastname());
            pstm.setString(3, client.getUsername());
            pstm.setString(4, client.getEmail());
            pstm.setString(5, client.getPassword());
            pstm.setString(6, client.getGender());
            pstm.setLong(7, client.getPhone());
            pstm.setString(8, client.getAnswer());
            pstm.setString(9, client.getAddress());
            pstm.setString(10, client.getCountry());
            res = pstm.executeUpdate();
            if(res>0){
                return true;
            } 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstm.close();
            con.close();
        }

        return false;
    }

    public boolean editClient(Client client) {
        return false;
    }

    public boolean deleteClient(Client client) {
        return false;
    }

    public boolean changePassword(Admin admin) {
        return false;
    }

}

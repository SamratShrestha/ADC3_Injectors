///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package logic;
//
//import dao.DbConnection;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import model.UserBean;
//
///**
// *
// * @author ica
// */
//public class ClientLogic implements UserLogic {
//
//    private PreparedStatement pstm;
//    private Connection con;
//
//    @Override
//    public boolean validateUser(UserBean client) {
//        try {
//            con = DbConnection.createConnection();
//            pstm = con.prepareStatement("select * from users where username=? and password=?");
//            pstm.setString(1, client.getUsername());
//            pstm.setString(2, client.getUsername());
//            ResultSet rs = pstm.executeQuery();
//            if (rs.next()) {
//                int isadmin = rs.getInt("isadmin");
//                if (isadmin == 0) {
//                    return true;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean addUser(UserBean client) {
//        //Logic For Adding Client
//        int res = 0;
//        try {
//            con = DbConnection.createConnection();
//            pstm = con.prepareStatement("insert into users values(null,?,?,?,?,?,?,?,CURDATE(),?,?,?,?,?,?)");
//            pstm.setString(1, client.getFirstname());
//            pstm.setString(2, client.getLastname());
//            pstm.setString(3, client.getUsername());
//            pstm.setString(4, client.getEmail());
//            pstm.setString(5, client.getPassword());
//            pstm.setString(6, client.getGender());
//            pstm.setLong(7, client.getPhone());
//            pstm.setString(8, client.getAnswer());
//            pstm.setString(9, client.getAddress());
//            pstm.setString(10, client.getCountry());
//            pstm.setString(11, client.getPassword());
//            pstm.setInt(12, client.getIsAdmin());
//            pstm.setBoolean(13, client.isAccStatus());
//
//            res = pstm.executeUpdate();
//            if (res > 0) {
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                pstm.close();
//                con.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(AdminLogic.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        return false;
//    }
//
//    @Override
//    public boolean changePassword(UserBean bean) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}

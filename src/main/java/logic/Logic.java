/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserBean;

/**
 *
 * @author ica
 */
public class Logic implements UserLogic {

    private PreparedStatement pstm;
    private Connection con;

    @Override
    public int validateUser(UserBean admin) {
        try {
            con = DbConnection.createConnection();
            pstm = con.prepareStatement("select * from users where username=? and password=?");
            pstm.setString(1, admin.getUsername());
            pstm.setString(2, admin.getPassword());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int isadmin = rs.getInt("isadmin");
                int acc_status = rs.getInt("acc_status");
                if (isadmin == 1 && acc_status == 1) {
                    return 1;
                }
                if (isadmin == 0 && acc_status == 1) {
                    return 2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    @Override
    public boolean addUser(UserBean client
    ) {
        int res = 0;
        try {
            con = DbConnection.createConnection();
            pstm = con.prepareStatement("insert into users values(null,?,?,?,?,?,?,?,CURDATE(),?,?,?,?,?,?)");
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
            pstm.setString(11, client.getPassword());
            pstm.setInt(12, client.getIsAdmin());
            pstm.setBoolean(13, client.isAccStatus());

            res = pstm.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

    @Override
    public boolean changePassword(UserBean admin
    ) {
        String oldpassword = "";
        boolean result = true;
        try {
            con = DbConnection.createConnection();
            pstm = con.prepareStatement("select * from users where password=? and username=?");
            pstm.setString(1, admin.getOldPassword());
            pstm.setString(2, admin.getUsername());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                oldpassword = rs.getString("oldpassword");
            }
            if (admin.getOldPassword().equals(oldpassword) && !admin.getOldPassword().isEmpty()) {
                pstm = con.prepareStatement("update users set password=?,oldpassword=? where username=? and password=?");
                pstm.setString(1, admin.getPassword());
                pstm.setString(2, admin.getPassword());
                pstm.setString(3, admin.getUsername());
                pstm.setString(4, admin.getOldPassword());
                pstm.executeUpdate();
            } else {
                result = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return result;
    }



    public boolean updateDetails(UserBean bean) throws ClassNotFoundException, SQLException {
        try {
            con = DbConnection.createConnection();
            pstm = con.prepareStatement("update users set firstname=?,lastname=?,username=?,email=?,gender=?,phone=?,address=?,country=? where id=?");
            pstm.setString(1, bean.getFirstname());
            pstm.setString(2, bean.getLastname());
            pstm.setString(3, bean.getUsername());
            pstm.setString(4, bean.getEmail());
            pstm.setString(5, bean.getGender());
            pstm.setLong(6, bean.getPhone());
            pstm.setString(7, bean.getAddress());
            pstm.setString(8, bean.getCountry());
            pstm.setInt(9, bean.getId());
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pstm.close();
            con.close();
        }
        return false;

    }

    @Override
    public boolean deleteUser(UserBean bean) {
        try {
            int id = bean.getId();
            con = DbConnection.createConnection();
            pstm = con.prepareStatement("delete from users where id=? and isadmin=0");
            pstm.setInt(1, id);
            int check = pstm.executeUpdate();
            if (check == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean updateStatus(UserBean bean) {
        try {
            con = DbConnection.createConnection();
            pstm = con.prepareStatement("update users set acc_status=? where id=?");
            pstm.setBoolean(1, bean.isAccStatus());
            pstm.setInt(2, bean.getId());
            int check = pstm.executeUpdate();
            if (check == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Logic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}

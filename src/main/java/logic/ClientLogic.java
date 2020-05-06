/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.DbConnection;
import model.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ica
 */
public class ClientLogic {
    
    public boolean validateClient(Client client) {
        try {
            DbConnection db = new DbConnection();
            Connection con =db.createConnection();
            PreparedStatement st = con.prepareStatement("select * from client where username=? and password=?;");
            st.setString(1,client.getUsername());
            st.setString(2,client.getUsername());
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

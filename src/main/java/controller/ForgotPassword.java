/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ica
 */
public class ForgotPassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        try {
            HttpSession session = request.getSession();
            Connection con = new DbConnection().createConnection();
            PreparedStatement pstm = con.prepareStatement("select * from users where username=?");
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                session.setAttribute("reset", username);
                response.sendRedirect("verifyaccount.jsp");
            }else{
                response.sendRedirect("forgotpassword.jsp");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}

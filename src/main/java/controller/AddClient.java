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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.AdminLogic;
import logic.ClientLogic;
import model.Client;

/**
 *
 * @author ica
 */
public class AddClient extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            AdminLogic logic = new AdminLogic();
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Long phone = Long.parseLong(request.getParameter("phone"));
            String gender = request.getParameter("gender");
            String answer = request.getParameter("answer");
            String address = request.getParameter("address");
            String country = request.getParameter("country");
            Client client = new Client(username,password,email,phone,gender,firstname,lastname,address,country,answer);
            if(logic.addClient(client)){
                response.sendRedirect("dashboard.jsp");
            }else{
                response.sendRedirect("addclient.jsp");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

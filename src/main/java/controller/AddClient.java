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
import javax.servlet.http.HttpSession;
import logic.Logic;
import model.UserBean;
//import model.Client;

/**
 *
 * @author ica
 */
public class AddClient extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Logic logic = new Logic();
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String repassword = request.getParameter("repassword");
            Long phone = Long.parseLong(request.getParameter("phone"));
            String gender = request.getParameter("gender");
            String answer = request.getParameter("answer");
            String address = request.getParameter("address");
            String country = request.getParameter("country");
            HttpSession session = request.getSession();
            if (password.equals(repassword)) {
                UserBean bean = new UserBean(username, password, email, phone, gender, firstname, lastname, address, country, answer);
                bean.setIsAdmin(0);
                if (logic.addUser(bean)) {
                    session.setAttribute("success-message", "User added Successfully");
                    response.sendRedirect("dashboard.jsp");
                } else {
                    session.setAttribute("faliure-message", "Client not added");
                    response.sendRedirect("addclient.jsp");
                }
            } else {
                session.setAttribute("faliure-message", "Password and Confirm Password does not match");
                response.sendRedirect("addclient.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

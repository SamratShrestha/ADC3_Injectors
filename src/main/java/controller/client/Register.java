/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.client;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Logic;
import model.UserBean;

/**
 *
 * @author ica
 */
@WebServlet(name = "Register", urlPatterns = {"/client/register"})
public class Register extends HttpServlet {

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
                //Not a admin when added
                bean.setIsAdmin(0);
                //Calling Logic for adding client
                if (logic.addUser(bean)) {
                    session.setAttribute("cusername", username);
                    session.setAttribute("success-message", "Registration Successful");
                    response.sendRedirect("dashboard.jsp");
                } else {
                    session.setAttribute("faliure-message", "Registration Unsuccessful");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
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
public class ChangePassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            HttpSession session = request.getSession();
            String oldpassword = request.getParameter("oldpassword");
            String password = request.getParameter("password");
            String repassword = request.getParameter("repassword");
            String username = (String) session.getAttribute("username");
            UserBean bean = new UserBean();
            Logic logic = new Logic();
            bean.setOldPassword(oldpassword);
            bean.setPassword(password);
            bean.setRepassword(repassword);
            bean.setUsername(username);

            if (bean.getPassword().equals(bean.getRepassword())) {
                if (logic.changePassword(bean)) {
                    session.setAttribute("success-message", "Password Changed Successfully");
                    response.sendRedirect("dashboard.jsp");
                } else {
                    session.setAttribute("faliure-message", "Password Not Changed");
                    response.sendRedirect("changepassword.jsp");
                }
            } else {
                session.setAttribute("faliure-message", "Newpassword and Repassword must match");
                response.sendRedirect("changepassword.jsp");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

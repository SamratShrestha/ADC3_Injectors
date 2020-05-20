/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
@WebServlet(name = "EditProfile", urlPatterns = {"/admin/editprofile","/client/editprofile"})
public class EditProfile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Logic logic = new Logic();
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            Long phone = Long.parseLong(request.getParameter("phone"));
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");
            String country = request.getParameter("country");
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
//            response.getWriter().println(id);
            UserBean bean = new UserBean(username, email, phone, gender, firstname, lastname, address, country);
            bean.setId(id);
            if (logic.updateDetails(bean)) {
                session.setAttribute("success-message", "Profile Update Successfully");
                response.sendRedirect("profile.jsp");
            } else {
                session.setAttribute("faliure-message", "Profile Not Updated");
                response.sendRedirect("editprofile.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

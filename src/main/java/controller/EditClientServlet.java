/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Logic;
import logic.UserLogic;
import model.UserBean;
//import model.Client;

/**
 *
 * @author ica
 */
@WebServlet(name = "EditClientServlet", urlPatterns = {"/admin/editclient"})
public class EditClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            response.getWriter().println(request.getParameter("id"));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/editclient.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
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
                session.setAttribute("success-message", "Edit Successful");
                response.sendRedirect("listclient.jsp");
            } else {
                session.setAttribute("faliure-message", "Edit Unsuccessful");
                response.sendRedirect("editclient.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

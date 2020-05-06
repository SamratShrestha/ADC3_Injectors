/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.AdminLogic;
import model.Admin;

/**
 *
 * @author ica
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String smessage = "Successful Login to dashboard";
        AdminLogic logic = new AdminLogic();
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        try {
            if (logic.validateAdmin(admin)) {
                HttpSession session = req.getSession();
                session.setAttribute("username", username);
//            session.setAttribute("password", password);
               session.setAttribute("success-message", smessage);
                resp.sendRedirect("dashboard.jsp");
//            resp.setContentType( "text/html");
//            resp.getWriter().printf("username=%s\npassword=%s", username, password);
            } else {
                resp.sendRedirect("../index.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

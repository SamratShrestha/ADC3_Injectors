/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "ClientLoginServlet", urlPatterns = {"/client/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/client/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String smessage = "Successful Login to dashboard";
        Logic logic = new Logic();
        UserBean bean = new UserBean();
        HttpSession session = request.getSession();
        bean.setUsername(username);
        bean.setPassword(password);
        int is_valid = logic.validateUser(bean);
        if (is_valid == 2) {
            session.setAttribute("cusername", username);
//            session.setAttribute("password", password);
            session.setAttribute("success-message", smessage);
            response.sendRedirect("dashboard.jsp");
//            resp.setContentType( "text/html");
//            resp.getWriter().printf("username=%s\npassword=%s", username, password);
        } else {
            session.setAttribute("faliure-message", "Invalid Username or Password");
            response.sendRedirect("login.jsp");
        }
        PrintWriter out = response.getWriter();
        out.println(username + password);

    }

}

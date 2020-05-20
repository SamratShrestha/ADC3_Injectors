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
@WebServlet(name = "UnblockClient", urlPatterns = {"/admin/unblockclient"})

public class UnblockClient extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Logic logic = new Logic();
            int id = Integer.parseInt(request.getParameter("id"));
            HttpSession session = request.getSession();
            UserBean bean = new UserBean();
            bean.setId(id);
            bean.setAccStatus(true);
            if (logic.updateStatus(bean)) {
                session.setAttribute("success-message", "Unblock Successful");
                response.sendRedirect("listclient.jsp");
            } else {
                session.setAttribute("faliure-message", "Unblock Unsuccessful");
                response.sendRedirect("listclient.jsp");
            }

        } catch (Exception e) {

        }
    }
}

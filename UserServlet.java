package com.projectmanagement.servlet;

import com.projectmanagement.dao.UserDAO;
import com.projectmanagement.model.User;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/api/users"})
public class UserServlet extends HttpServlet {

    private UserDAO dao = new UserDAO();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        try (PrintWriter out = resp.getWriter()) {
            List<User> users = dao.findAll();
            out.print(gson.toJson(users));
        } catch (Exception e) {
            resp.setStatus(500);
            resp.getWriter().print(gson.toJson(e.getMessage()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);
        }
        User incoming = gson.fromJson(sb.toString(), User.class);
        try {
            User created = dao.create(incoming);
            resp.setContentType("application/json");
            resp.getWriter().print(gson.toJson(created));
        } catch (Exception e) {
            resp.setStatus(500);
            resp.getWriter().print(gson.toJson(e.getMessage()));
        }
    }
}

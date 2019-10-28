package com.github.smthyellow.project0.web.Servlet;

import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.web.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/personalpage")

public class PersonalPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("authUser");
        req.setAttribute("name", user.getFullName());
        req.setAttribute("phone", user.getPhone());
        req.setAttribute("email", user.getEmail());
        req.setAttribute("id", user.getUserId());
        WebUtils.forward("personalPage", req, resp);
    }

    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("authUser");
        req.setAttribute("name", user.getFullName());
        req.setAttribute("phone", user.getPhone());
        req.setAttribute("email", user.getEmail());

        WebUtils.forward("personalpage", req, resp);
    }*/
}

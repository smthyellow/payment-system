package com.github.smthyellow.project0.web.Servlet;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.userService.UserService;
import com.github.smthyellow.project0.service.userService.UserServiceImpl;
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
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");
        Long id = authUser.getAuthUserId();
        User user = userService.getUserById(id);
        req.setAttribute("name", user.getFullName());
        req.setAttribute("phone", user.getPhone());
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

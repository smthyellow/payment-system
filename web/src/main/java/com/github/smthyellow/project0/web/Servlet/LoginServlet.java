package com.github.smthyellow.project0.web.Servlet;

import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.user.UserService;
import com.github.smthyellow.project0.service.user.UserServiceImpl;
import com.github.smthyellow.project0.web.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet ("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object user = req.getSession().getAttribute("authUser");
        if (user == null) {
            WebUtils.forward("/login", req, resp);
            return;
        }
        WebUtils.redirect("/personalpage", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = userService.loginUser(email, password);

        if (user == null){
            req.setAttribute("error", "Check your login and password.");
             WebUtils.forward("login", req, resp);
            return;
        }

        log.info("user {} logged", user.getFullName());
        req.getSession().setAttribute("authUser", user);
        WebUtils.redirect("personalpage", req, resp);

    }
}

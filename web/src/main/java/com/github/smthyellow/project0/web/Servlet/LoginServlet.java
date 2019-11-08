package com.github.smthyellow.project0.web.Servlet;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.authUserService.AuthUserServiceImpl;
import com.github.smthyellow.project0.web.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
    private AuthUserService authUserService = AuthUserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object authUser = req.getSession().getAttribute("authUser");
        if (authUser == null) {
            WebUtils.forward("/login", req, resp);
            return;
        }
        WebUtils.redirect("/personalpage", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        AuthUser authUser = authUserService.loginUser(email, password);

        if (authUser == null){
            req.setAttribute("error", "Check your login and password.");
             WebUtils.forward("login", req, resp);
            return;
        }

        log.info("user {} logged", authUser.getEmail());
        req.getSession().setAttribute("authUser", authUser);
        WebUtils.redirect("personalpage", req, resp);

    }
}

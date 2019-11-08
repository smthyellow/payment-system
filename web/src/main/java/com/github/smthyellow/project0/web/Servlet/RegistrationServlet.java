package com.github.smthyellow.project0.web.Servlet;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.authUserService.AuthUserServiceImpl;
import com.github.smthyellow.project0.web.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private AuthUserService authUserService = AuthUserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebUtils.forward("registration", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        boolean passwordMatch = confirmPassword.equals(password);
        AuthUser authUser = authUserService.checkExistence(email);

        if (authUser != null) {
            req.setAttribute("error", "User with this email already exists.");
            WebUtils.forward("registration", req, resp);
            return;
        } else if (email == null || password == null){
            req.setAttribute("error", "Invalid email or password.");
            WebUtils.forward("registration", req, resp);
            return;
        } else if(passwordMatch == false){
            req.setAttribute("error", "Passwords don't match.");
            WebUtils.forward("registration", req, resp);
            return;
        } else {
            authUserService.totalSaveAuthUser(firstName, lastName, email, phone, password);
            WebUtils.redirect("personalpage", req, resp);
        }
    }
}

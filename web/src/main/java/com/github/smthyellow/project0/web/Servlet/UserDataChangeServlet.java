package com.github.smthyellow.project0.web.Servlet;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.authUserService.AuthUserServiceImpl;
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

@WebServlet ("/datachange")
public class UserDataChangeServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserDataChangeServlet.class);
    private UserService userService = UserServiceImpl.getInstance();
    private AuthUserService authUserService = AuthUserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebUtils.forward("dataChange", req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String currentPassword = req.getParameter("currentPassword");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (currentPassword.equals(authUser.getPassword())) {
            if (password.equals(confirmPassword)){
                authUser = authUserService.updateAuthUser(authUser.getAuthUserId(), firstName, lastName, email, phone, password);
                req.setAttribute("authUser", authUser);
                User user = userService.getUserByAuthUserId(authUser.getAuthUserId());
                log.info("user {} updated", user.getFullName());
            } else {
                req.setAttribute("error", "Passwords don't match.");
                WebUtils.forward("dataChange", req, resp);
                return;
            }
        } else {
            req.setAttribute("error", "Current password is incorrect.");
            WebUtils.forward("dataChange", req, resp);
            return;
        }


    }
}

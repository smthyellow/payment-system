package com.github.smthyellow.project0.web.Servlet;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebUtils.forward("dataChange", req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        /*String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String currentPassword = req.getParameter("currentpassword");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmpassword");

        User user = (User) req.getSession().getAttribute("authUser");

        if (currentPassword.equals(user.getPassword()) && password.equals(confirmPassword)) {
            if (firstName != null) {
                user.setFirstName(firstName);
            }
            if (lastName != null) {
                user.setLastName(lastName);
            }
            if (email != null) {
                user.setEmail(email);
            }
            if (phone != null) {
                user.setPhone(phone);
            }
            if (password != null) {
                user.setPassword(password);
            }

            userService.updateUser(user);
            log.info("user {} updated", user.getFullName());
        }*/


    }
}

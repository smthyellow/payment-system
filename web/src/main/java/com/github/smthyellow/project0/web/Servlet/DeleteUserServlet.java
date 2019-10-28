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

@WebServlet ("/deleteuser")
public class DeleteUserServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DeleteUserServlet.class);
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebUtils.forward("deleteuser", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("authUser");
        userService.deleteUser(user);
        log.info("user {} deleted", user.getFullName());
        WebUtils.redirect("login", req, resp);
    }
}

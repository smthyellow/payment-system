package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.userService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    private final UserService userService;
    private final AuthUserService authUserService;

    public LoginController(AuthUserService authUserService, UserService userService) {
        this.authUserService = authUserService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(HttpSession session) {
        Object authUser = session.getAttribute("authUser");
        if (authUser == null) {
            return "login";
        }
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest rq) {
        String email = rq.getParameter("email");
        String password = rq.getParameter("password");
        AuthUser authUser = authUserService.login(email, password);
        if (authUser == null) {
            rq.setAttribute("error", "login or password invalid");
            return "login";
        }
        log.info("user {} logged", authUser.getEmail());
        User user = userService.getUserByAuthUserId(authUser.getAuthUserId());
        rq.getSession().setAttribute("authUser", authUser);
        rq.getSession().setAttribute("userFullName", user.getFullName());

        return "personalPage";
    }
}

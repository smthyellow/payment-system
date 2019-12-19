package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.userService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class AdministrationController {
    private static final Logger log = LoggerFactory.getLogger(AdministrationController.class);

    private final UserService userService;
    private final AuthUserService authUserService;

    public AdministrationController(AuthUserService authUserService, UserService userService) {
        this.authUserService = authUserService;
        this.userService = userService;
    }

    @GetMapping("/administration")
    public String doGet(HttpSession session) {
        AuthUser authUser = (AuthUser) session.getAttribute("authUser");
        User user = userService.getUserByAuthUserId(authUser.getAuthUserId());
        session.setAttribute("fullUserName", user.getFullName());
        return "administration";
    }
}

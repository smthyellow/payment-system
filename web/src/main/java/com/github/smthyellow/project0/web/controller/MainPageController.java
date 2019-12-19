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
public class MainPageController {
    private static final Logger log = LoggerFactory.getLogger(MainPageController.class);

    private final AuthUserService authUserService;
    private final UserService userService;

    public MainPageController(AuthUserService authUserService, UserService userService) {
        this.authUserService = authUserService;
        this.userService = userService;
    }

    @GetMapping("/mainPage")
    public String doGet(HttpSession session) {
        AuthUser authUser = (AuthUser) session.getAttribute("authUser");
        if (authUser != null){
            User user = userService.getUserByAuthUserId(authUser.getAuthUserId());
            session.setAttribute("fullUserName", user.getFullName());
        }
        return "mainPage";
    }
}

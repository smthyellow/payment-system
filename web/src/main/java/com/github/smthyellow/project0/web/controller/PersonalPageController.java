package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.userService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/personalPage")
public class PersonalPageController {
    private static final Logger log = LoggerFactory.getLogger(PersonalPageController.class);
    private final UserService userService;

    public PersonalPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String get(HttpServletRequest rq) {
        AuthUser authUser = (AuthUser) rq.getSession().getAttribute("authUser");
        User user = userService.getUserByAuthUserId(authUser.getAuthUserId());
        rq.getSession().setAttribute("name", user.getFirstName());

        return "personalPage";
    }
}

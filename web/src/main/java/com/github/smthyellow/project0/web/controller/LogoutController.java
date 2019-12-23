package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LogoutController {
    private final AuthUserService authUserService;

    public LogoutController(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    @GetMapping("/logout")
    public String doGet(HttpSession session) {
        session.removeAttribute("authUser");
        session.invalidate();
        return "login";
    }
}

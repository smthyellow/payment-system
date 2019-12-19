package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.cardService.CardService;
import com.github.smthyellow.project0.service.userService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class CardController {
    private static final Logger log = LoggerFactory.getLogger(CardController.class);

    private final UserService userService;
    private final CardService cardService;

    public CardController(UserService userService, CardService cardService) {
        this.userService = userService;
        this.cardService = cardService;
    }

    @GetMapping("/card")
    public String doGet(HttpSession session) {
        AuthUser authUser = (AuthUser) session.getAttribute("authUser");
        User user = userService.getUserByAuthUserId(authUser.getAuthUserId());
        session.setAttribute("fullUserName", user.getFullName());

        return "card";
    }

}

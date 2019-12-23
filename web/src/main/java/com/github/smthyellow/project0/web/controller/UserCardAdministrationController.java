package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Card;
import com.github.smthyellow.project0.service.accountService.AccountService;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.cardService.CardService;
import com.github.smthyellow.project0.service.userService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/userCardAdministration")
public class UserCardAdministrationController {
    private final UserService userService;
    private final AuthUserService authUserService;
    private final CardService cardService;
    private final AccountService accountService;

    public UserCardAdministrationController(AuthUserService authUserService, UserService userService, CardService cardService, AccountService accountService) {
        this.authUserService = authUserService;
        this.userService = userService;
        this.cardService = cardService;
        this.accountService = accountService;
    }

    @GetMapping()
    public String get(HttpServletRequest rq){
        AuthUser subAuthUser = (AuthUser)rq.getSession().getAttribute("subAuthUser");
        /*List<Card> cards = cardService.getByAuthUserId(subAuthUser.getAuthUserId());
        if(cards == null){
            rq.setAttribute("message", "This user has no cards.");
            return "userCardAdministration";
        }
        rq.setAttribute("cards", cards);*/
        return "userCardAdministration";
    }

    @PostMapping()
    public String post(HttpServletRequest rq){
        Long accountId = Long.parseLong(rq.getParameter("accountId"));
        int expiryMonth = Integer.parseInt(rq.getParameter("expiryMonth"));
        int expiryYear = Integer.parseInt(rq.getParameter("expiryYear"));
        Long cardId = cardService.addCard(accountId, expiryMonth, expiryYear);
        return "userCardAdministration";
    }
}

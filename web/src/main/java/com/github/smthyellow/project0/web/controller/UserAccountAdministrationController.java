package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Card;
import com.github.smthyellow.project0.service.accountService.AccountService;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.cardService.CardService;
import com.github.smthyellow.project0.service.userService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/userAccountAdministration")
public class UserAccountAdministrationController {
    private final UserService userService;
    private final AuthUserService authUserService;
    private final AccountService accountService;

    public UserAccountAdministrationController(AuthUserService authUserService, UserService userService, AccountService accountService) {
        this.authUserService = authUserService;
        this.userService = userService;
        this.accountService = accountService;
    }

    @GetMapping()
    public String get(HttpServletRequest rq){
        AuthUser subAuthUser = (AuthUser)rq.getSession().getAttribute("subAuthUser");
        List<Account> accounts = accountService.getAccountFinishedLimit();
        if(accounts == null){
            rq.setAttribute("message", "This user has no cards.");
            return "userAccountAdministration";
        }
        rq.setAttribute("accounts", accounts);
        return "userAccountAdministration";
    }


}

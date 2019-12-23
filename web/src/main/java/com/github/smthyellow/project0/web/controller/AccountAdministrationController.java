package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.accountService.AccountService;
import com.github.smthyellow.project0.service.userService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/* TODO Система Платежи.
    Клиент имеет Счет в банке и +
    Кредитную Карту (КК).+
     Клиент может оплатить Заказ,
     сделать платеж на другой Счет!!!
     заблокировать КК и
     аннулировать Счет.
      Администратор может заблокировать КК за превышение кредита.*/


@Controller
@RequestMapping("/accountAdministration")
public class AccountAdministrationController {
    private final AccountService accountService;
    private final UserService userService;

    public AccountAdministrationController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService= userService;
    }

    @GetMapping()
    public String get(HttpServletRequest rq) {
        AuthUser authUser = (AuthUser) rq.getSession().getAttribute("authUser");
        User user = userService.getUserByAuthUserId(authUser.getAuthUserId());
        rq.getSession().setAttribute("fullUserName", user.getFullName());
        return "accountAdministration";
    }

    @PostMapping()
    public String post(HttpServletRequest rq){
        List<Account> accounts = accountService.getAccountFinishedLimit();
        rq.setAttribute("accounts", accounts);
        return "accountAdministration";
    }
}

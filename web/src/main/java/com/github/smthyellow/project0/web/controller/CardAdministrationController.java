package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.model.*;
import com.github.smthyellow.project0.service.accountService.AccountService;
import com.github.smthyellow.project0.service.authUserService.AuthUserService;
import com.github.smthyellow.project0.service.cardService.CardService;
import com.github.smthyellow.project0.service.userService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cardAdministration")
public class CardAdministrationController {
    private static final Logger log = LoggerFactory.getLogger(AdministrationController.class);

    private final UserService userService;
    private final AuthUserService authUserService;
    private final CardService cardService;
    private final AccountService accountService;

    public CardAdministrationController(AuthUserService authUserService, UserService userService, CardService cardService, AccountService accountService) {
        this.authUserService = authUserService;
        this.userService = userService;
        this.cardService = cardService;
        this.accountService = accountService;
    }

    @GetMapping()
    public String get(HttpServletRequest rq) {
        AuthUser authUser = (AuthUser) rq.getSession().getAttribute("authUser");
        User user = userService.getUserByAuthUserId(authUser.getAuthUserId());
        rq.getSession().setAttribute("fullUserName", user.getFullName());

        return "cardAdministration";
    }

    @PostMapping()
    public String post(HttpServletRequest rq){
        String stringStatus = rq.getParameter("status");
        AccountAndCardStatus status;
        if (stringStatus.equalsIgnoreCase("active")){
            status = AccountAndCardStatus.ACTIVE;
        } else if (stringStatus.equalsIgnoreCase("blocked")){
            status = AccountAndCardStatus.BLOCKED;
        } else {
            rq.setAttribute("error", "Incorrect status");
            return "cardAdministration";
        }

        List<Card> cards = cardService.getCardByStatus(status);
        /*
        Long cardNumber = Long.parseLong(rq.getParameter("cardNumber"));
        List<Card> cards = new ArrayList<>();
        if (cardNumber != null){
            cards.add(cardService.getByCardNumber(cardNumber));
            rq.setAttribute("cards", cards);
            return "cardAdministration";
        }
        Long accountNumber = Long.parseLong(rq.getParameter("accountNumber"));
        if (accountNumber != null) {
            Account account = accountService.getByAccountNumber(accountNumber);
            cards = cardService.getByAccountId(account.getAccountId());
            rq.setAttribute("cards", cards);
            return "cardAdministration";
        }
        String firstName = rq.getParameter("firstName");
        String lastName = rq.getParameter("lastName");
        if (firstName != null || lastName != null){
            List<User> users = userService.getByFullName(firstName, lastName);
            List<Long> authUserIds = users.stream()
                    .map(user -> user.getAuthUserId())
                    .collect(Collectors.toList());
            List<Account> accounts = accountService.getByAuthUserIds(authUserIds);
            List<Long> accountIds = accounts.stream()
                    .map(account -> account.getAccountId())
                    .collect(Collectors.toList());
            cards = cardService.getByAccountIds(accountIds);
            rq.setAttribute("cards", cards);
            return "cardAdministration";        }*/
        return "cardAdministration";
    }
}

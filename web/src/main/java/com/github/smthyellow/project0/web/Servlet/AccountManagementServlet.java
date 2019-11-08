package com.github.smthyellow.project0.web.Servlet;

import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.service.accountService.AccountService;
import com.github.smthyellow.project0.service.accountService.AccountServiceImpl;
import com.github.smthyellow.project0.web.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@WebServlet("/accountManagement")
public class AccountManagementServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(AccountManagementServlet.class);
    private AccountService accountService = AccountServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");
        /*List<Card> cards = cardService.getListOfCards(authUser.getAuthUserId());
        req.setAttribute("cards", cards);*/
        WebUtils.forward("accountManagement", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");
        Long accountNumber = accountService.addAccount(authUser.getAuthUserId());
        req.setAttribute("message", "Account " + accountNumber + " created");
        log.info("account created:{} at {}", accountNumber, LocalDateTime.now());

        WebUtils.forward("accountManagement", req, resp);
    }
}

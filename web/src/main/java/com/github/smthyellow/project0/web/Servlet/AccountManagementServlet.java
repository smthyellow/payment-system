package com.github.smthyellow.project0.web.Servlet;

import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Card;
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
import java.util.List;

@WebServlet("/accountManagement")
public class AccountManagementServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(AccountManagementServlet.class);
    private AccountService accountService = AccountServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");
        String pageNumber1 = req.getParameter("pageNumber");
        if (pageNumber1 == null) {
            pageNumber1 = "1";
        }

        Integer pageNumber = Integer.valueOf(pageNumber1);

        List<Account> accounts = accountService.getPage(pageNumber, authUser.getAuthUserId());
        req.setAttribute("accounts", accounts);

        long countOfPage =(long) accounts.size()/5 + 1;
        if(accounts.size() % 5 != 0){
            countOfPage++;
        }
        req.setAttribute("pageCount", countOfPage);


        WebUtils.forward("accountManagement", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");
        long accountNumber = accountService.addAccount(authUser);
        req.setAttribute("message", "Account " + accountNumber + " created");
        log.info("account created:{} at {}", accountNumber, LocalDateTime.now());

        WebUtils.forward("accountManagement", req, resp);
    }
}

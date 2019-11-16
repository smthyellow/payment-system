package com.github.smthyellow.project0.web.Servlet;

import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Card;
import com.github.smthyellow.project0.model.Transfer;
import com.github.smthyellow.project0.service.accountService.AccountService;
import com.github.smthyellow.project0.service.accountService.AccountServiceImpl;
import com.github.smthyellow.project0.service.cardService.CardService;
import com.github.smthyellow.project0.service.cardService.CardServiceImpl;
import com.github.smthyellow.project0.service.transferService.TransferService;
import com.github.smthyellow.project0.service.transferService.TransferServiceImpl;
import com.github.smthyellow.project0.web.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/doTransfer")
public class DoTransferServlet extends HttpServlet {


    private static final Logger log = LoggerFactory.getLogger(DoTransferServlet.class);
    private CardService cardService = CardServiceImpl.getInstance();
    private AccountService accountService = AccountServiceImpl.getInstance();
    private TransferService transferService = TransferServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");
        WebUtils.forward("doTransfer", req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        /*AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");
        String fromCardString = req.getParameter("fromCard");
        String fromAccountString = req.getParameter("fromAccount");
        String toCardString = req.getParameter("toCard");
        String toAccountString = req.getParameter("toAccount");
        int sum = Integer.parseInt(req.getParameter("sum"));

        if (fromCardString != null){

        }*/
    }
}

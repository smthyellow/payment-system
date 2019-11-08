package com.github.smthyellow.project0.web.Servlet;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Card;
import com.github.smthyellow.project0.service.cardService.CardService;
import com.github.smthyellow.project0.service.cardService.CardServiceImpl;
import com.github.smthyellow.project0.web.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/cardManagement")
public class CardManagementServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(CardManagementServlet.class);

    private CardService cardService = CardServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");
        List<Card> cards = cardService.getListOfCards(authUser.getAuthUserId());
        req.setAttribute("cards", cards);
        WebUtils.forward("cardManagement", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");
        Long accountId = Long.parseLong(req.getParameter("accountId"));
        Long cardNumber = cardService.addCard(authUser.getAuthUserId(), accountId);
        req.setAttribute("message", "Card " + cardNumber + " created");
        log.info("card created:{} at {}", cardNumber, LocalDateTime.now());

        WebUtils.forward("/cardManagement", req, resp);
    }
}

package com.github.smthyellow.project0.web.controller;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.User;
import com.github.smthyellow.project0.service.transferService.TransferService;
import com.github.smthyellow.project0.service.userService.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/makeTransfer")
public class MakeTransferController {
    private final TransferService transferService;
    private final UserService userService;

    public MakeTransferController(TransferService transferService, UserService userService){
        this.transferService = transferService;
        this.userService = userService;
    }

    @GetMapping()
    public String get(HttpServletRequest rq) {
        AuthUser authUser = (AuthUser) rq.getSession().getAttribute("authUser");
        User user = userService.getUserByAuthUserId(authUser.getAuthUserId());
        rq.getSession().setAttribute("name", user.getFirstName());

        return "makeTransfer";
    }

    @PostMapping()
    public String post(HttpServletRequest rq){
        Long fromAccountId = Long.parseLong(rq.getParameter("fromAccountId"));
        Long toAccountId = Long.parseLong(rq.getParameter("toAccountId"));
        int sum = Integer.parseInt(rq.getParameter("sum"));

        transferService.makeTransfer(fromAccountId, toAccountId, sum);

        return "makeTransfer";
    }
}

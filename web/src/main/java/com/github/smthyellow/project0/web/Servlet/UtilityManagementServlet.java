package com.github.smthyellow.project0.web.Servlet;

import com.github.smthyellow.project0.dao.bill.BillDao;
import com.github.smthyellow.project0.dao.bill.BillDaoImpl;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Bill;
import com.github.smthyellow.project0.service.billService.BillService;
import com.github.smthyellow.project0.service.billService.BillServiceImpl;
import com.github.smthyellow.project0.web.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/utulitymanagement")
public class UtilityManagementServlet extends HttpServlet {

    private BillService billService = BillServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthUser authUser = (AuthUser)req.getSession().getAttribute("authUser");
        WebUtils.forward("utilitymanagement", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthUser authUser = (AuthUser) req.getSession().getAttribute("authUser");
        long billId = Long.parseLong(req.getParameter("billId"));
        Bill bill = billService.getBillById(billId);
        billService.appointBillToUser(bill, authUser);
        req.setAttribute("message", "Service was added.");
        WebUtils.forward("utilitymanagement", req, resp);
    }
}

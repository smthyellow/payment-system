package com.github.smthyellow.project0.dao.bill;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Bill;

import java.util.List;

public interface BillDao {
    //void createBill(Bill bill);

    //List<Bill> getBillByUserId(Long userId);

    List<Bill> getAllBills();

    Bill getBillById(long billId);

    void appointBillToUser(Bill bill, AuthUser authUser);
}


package com.github.smthyellow.project0.dao.dao.bill;

import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Bill;

import java.util.List;

public interface BillDao {
    void createBill(Bill bill);

    void assignBill(Long authUserId, Long billId);

    void unassignBill(Long authUserId, Long billId);

    void deleteBill(Long billId);
}


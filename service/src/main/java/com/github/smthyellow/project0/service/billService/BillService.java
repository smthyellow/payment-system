package com.github.smthyellow.project0.service.billService;

import com.github.smthyellow.project0.model.Bill;

public interface BillService {

    void addBill(Bill bill);

    void updateBill(Bill bill);

    void payBill(Bill bill);

    void deleteBill(Bill bill);
}

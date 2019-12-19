package com.github.smthyellow.project0.service.billService;

import com.github.smthyellow.project0.dao.dao.bill.BillDao;
import com.github.smthyellow.project0.dao.dao.bill.BillDaoImpl;
import com.github.smthyellow.project0.model.AuthUser;
import com.github.smthyellow.project0.model.Bill;

import java.util.List;

public class BillServiceImpl implements BillService{
    private static class SingletonHolder {
        static final BillService HOLDER_INSTANCE = new BillServiceImpl();
    }
    public static BillService getInstance() {
        return BillServiceImpl.SingletonHolder.HOLDER_INSTANCE;
    }

    private BillDao billDao = BillDaoImpl.getInstance();

    /*@Override
    public List<Bill> getAllUtilities(){
        List<Bill> bills = billDao.getAllBills();
        return bills;
    }

    @Override
    public Bill getBillById(long billId){
        Bill bill = billDao.getBillById(billId);
        return bill;
    }

    @Override
    public void appointBillToUser(Bill bill, AuthUser authUser){
        billDao.appointBillToUser(bill, authUser);
    }


     */
}

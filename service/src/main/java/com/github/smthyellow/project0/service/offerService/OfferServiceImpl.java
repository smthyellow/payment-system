package com.github.smthyellow.project0.service.offerService;

import com.github.smthyellow.project0.dao.dao.offer.OfferDao;

public class OfferServiceImpl implements OfferService {
    private final OfferDao offerDao;

    public OfferServiceImpl(OfferDao offerDao) {
        this.offerDao = offerDao;
    }

    /*@Override
    public List<Offer> getAllUtilities(){
        List<Offer> bills = offerDao.getAllBills();
        return bills;
    }

    @Override
    public Offer getBillById(long billId){
        Offer bill = offerDao.getBillById(billId);
        return bill;
    }

    @Override
    public void appointBillToUser(Offer bill, AuthUser authUser){
        offerDao.appointBillToUser(bill, authUser);
    }


     */
}

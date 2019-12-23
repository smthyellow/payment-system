package com.github.smthyellow.project0.service.cardService;

import com.github.smthyellow.project0.dao.dao.card.CardDao;
import com.github.smthyellow.project0.model.AccountAndCardStatus;
import com.github.smthyellow.project0.model.Card;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class CardServiceImpl implements CardService {
    private final CardDao cardDao;

    public CardServiceImpl(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    @Override
    public Card getByCardNumber(Long cardNumber) {
        return cardDao.getByCardNumber(cardNumber);

    }

    @Override
    public List<Card> getByAccountId(Long accountId) {
        return cardDao.getByAccountId(accountId);
    }

    @Override
    public List<Card> getByAccountIds(List<Long> accountIds) {
        return cardDao.getByAccountIds(accountIds);
    }

    @Override
    public List<Card> getCardByStatus(AccountAndCardStatus status) {
        return cardDao.getCardByStatus(status);
    }

    @Override
    public List<Card> getByAuthUserId(Long authUserId) {
        return cardDao.getByAuthUserId(authUserId);
    }

    @Override
    public Long addCard(Long accountId, int expiryMonth, int expiryYear){
        Long cardNumber = (Long) Math.round((Math.random() * 9999999999999999L) +1000000000000000L);
        short cvv = (short) ((short)(Math.random() * 999) + 100);
        LocalDate expiryDate;
        if (expiryMonth == 1 || expiryMonth == 3 || expiryMonth == 5 || expiryMonth == 7 || expiryMonth == 8 || expiryMonth == 10 || expiryMonth == 12){
            expiryDate = LocalDate.of(expiryYear, expiryMonth, 31);
        } else if (expiryMonth == 4 || expiryMonth == 6 || expiryMonth == 9 || expiryMonth == 11 ){
            expiryDate = LocalDate.of(expiryYear, expiryMonth, 31);
        } else {
            expiryDate = LocalDate.of(expiryYear, expiryMonth, 28);
        }

        cardDao.addCard(cvv, cardNumber, accountId, expiryDate, AccountAndCardStatus.ACTIVE);
        return cardNumber;
    }

    /*
    @Override
    public List<Card> getCardsList(long authUserId){
        List<Card> cardList = cardDao.getCardList(authUserId);
        return cardList;
    }

    @Override
    public Card getCardByCardId(long cardId){
        Card card = cardDao.getCardByCardId(cardId);
        return card;
    }

 */
}

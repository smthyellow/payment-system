package com.github.smthyellow.project0.service.cardService;

import com.github.smthyellow.project0.dao.card.CardDao;
import com.github.smthyellow.project0.dao.card.CardDaoImpl;
import com.github.smthyellow.project0.model.Card;

import java.util.List;

public class CardServiceImpl implements CardService {
    private static class SingletonHolder {
        static final CardService HOLDER_INSTANCE = new CardServiceImpl();
    }
    public static CardService getInstance() {
        return CardServiceImpl.SingletonHolder.HOLDER_INSTANCE;
    }

    private CardDao cardDao = CardDaoImpl.getInstance();

    @Override
    public Long addCard(Long userId, Long accountId){
        Long cardNumber = (Long) Math.round((Math.random() * 9999999999999999L) +1000000000000000L);
        short cvv = (short) ((short)(Math.random() * 999) + 100);
        Card card = new Card( userId, cvv, cardNumber, accountId);
        cardDao.addCard(card);
        return cardNumber;

    }
    @Override
    public List<Card> getListOfCards(Long authUserId){
        List<Card> cardList = cardDao.getCardByUserId(authUserId);
        return cardList;
    }

    @Override
    public Card getCardByCardId(long cardId){
        Card card = cardDao.getCardByCardId(cardId);
        return card;
    }
}

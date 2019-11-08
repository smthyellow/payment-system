package com.github.smthyellow.project0.dao.card;

import com.github.smthyellow.project0.dao.part.entity.CardEntity;
import com.github.smthyellow.project0.model.Card;

import java.util.List;

public interface CardDao {
    //int plusCardBalance();

    //int minusCardBalance();

    //void blockCard();

    //void unblockCard();

    //boolean limitReached();

    //void deactivateCard();

    long addCard(Card card);

    List<Card> getCardByUserId(long userId);

    Card getCardByCardId(long cardId);
}

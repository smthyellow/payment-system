package com.github.smthyellow.project0.service.cardService;

import com.github.smthyellow.project0.model.Card;

import java.util.List;

public interface CardService {
    List<Card> getListOfCards(Long userId);

    Long addCard(Long accounId, Long userId);

    Card getCardByCardId(long cardId);

    //void plusBalance(Card card, int sum);

    //void minusBalance(Card card, int sum);

    //void blockCard(Card card);

    //void unblockCard(Card card);

    //void deleteCard(Card card);
}

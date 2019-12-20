package com.github.smthyellow.project0.dao.converter;

import com.github.smthyellow.project0.dao.entity.CardEntity;
import com.github.smthyellow.project0.model.Card;

public class CardConverter {
    public static CardEntity toEntity(Card card){
        if (card == null){
            return null;
        }

        final CardEntity cardEntity = new CardEntity();

        cardEntity.setCardId(card.getCardId());
        cardEntity.setCvv(card.getCvv());
        cardEntity.setCardNumber(card.getCardNumber());
        cardEntity.setAccountId(card.getAccountId());
        return cardEntity;
    }

    public static Card fromEntity(CardEntity cardEntity){
        if (cardEntity == null){
            return null;
        }
        return new Card(
                cardEntity.getCardId(),
                cardEntity.getCvv(),
                cardEntity.getCardNumber(),
                cardEntity.getAccountId(),
                cardEntity.getExpiryDate(),
                cardEntity.getCardStatus()
        );
    }


}

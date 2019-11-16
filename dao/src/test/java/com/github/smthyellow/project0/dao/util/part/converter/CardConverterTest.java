package com.github.smthyellow.project0.dao.util.part.converter;

import com.github.smthyellow.project0.dao.util.part.entity.CardEntity;
import com.github.smthyellow.project0.model.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardConverterTest {
    @Test
    void fromEntityNull() {
        final Card card = CardConverter.fromEntity(null);
        assertNull(card);
    }

    @Test
    void fromEntityNotNull() {
        final CardEntity cardEntity = new CardEntity();
        cardEntity.setCardId(1L);
        cardEntity.setAccountId(2L);
        cardEntity.setAuthUserId(3L);
        cardEntity.setCvv(4);

        final Card card = CardConverter.fromEntity(cardEntity);

        assertNotNull(card);
        assertEquals(card.getCardId(), cardEntity.getCardId());
        assertEquals(card.getAccountId(), cardEntity.getAccountId());
        assertEquals(card.getUserId(), cardEntity.getAuthUserId());
        assertEquals(card.getCvv(), cardEntity.getCvv());
    }

    @Test
    void toEntityNull() {
        final CardEntity billEntity = CardConverter.toEntity(null);
        assertNull(billEntity);
    }

    @Test
    void toEntityNotNull() {
        final Card card = new Card(1L, 2, 3L, 4L);

        final CardEntity cardEntity = CardConverter.toEntity(card);

        assertNotNull(card);
        assertEquals(card.getCardId(), cardEntity.getCardId());
        assertEquals(card.getAccountId(), cardEntity.getAccountId());
        assertEquals(card.getUserId(), cardEntity.getAuthUserId());
        assertEquals(card.getCvv(), cardEntity.getCvv());
    }

}
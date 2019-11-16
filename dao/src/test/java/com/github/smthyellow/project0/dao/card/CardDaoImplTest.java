package com.github.smthyellow.project0.dao.card;

import com.github.smthyellow.project0.model.Card;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardDaoImplTest {
    private CardDao dao = CardDaoImpl.getInstance();

    /*@Test
    void getByUserId() {
        dao.addCard(new Card(1L, 2, 3L, 4L));
        final List<Card> cards = dao.getCardByUserId(1L);

        assertNotNull(cards);

        for (Card c: cards) {
            assertEquals(c.getUserId(), 1L);
        }
    }*/

//    private long cardId;
//    private long authUserId;
//    private int cvv;
//    private long cardNumber;
//    private long accountId;

   /* @Test
    void getByLoginNotExist() {
        final AuthUser user = dao.getByEmail("e");
        assertNull(user);
    }

    @Test
    void saveAuthUser() {
        final long authUserId = dao.saveAuthUser("q", "w", Role.CLIENT);

        final AuthUserEntity userEntity = HibernateUtil.getSession().get(AuthUserEntity.class, authUserId);
        assertNotNull(userEntity);
        assertEquals(userEntity.getEmail(), userEntity.getEmail());
        assertEquals(userEntity.getPassword(), userEntity.getPassword());
    }*/

    /*@Test
    void getAccountByAccountId() {
        long cardId = dao.addCard(new Card(1L, 2, 3L, 4L));
        final Card card = dao.getCardByCardId(cardId);

        assertNotNull(card);

        assertEquals(card.getUserId(), 1L);
        assertEquals(card.getCvv(), 2);
        assertEquals(card.getCardNumber(), 3L);
        assertEquals(card.getAccountId(), 4L);

    }*/

}
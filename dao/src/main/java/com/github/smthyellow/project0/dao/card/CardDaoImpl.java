package com.github.smthyellow.project0.dao.card;

import com.github.smthyellow.project0.dao.util.HibernateUtil;
import com.github.smthyellow.project0.dao.part.converter.CardConverter;
import com.github.smthyellow.project0.dao.part.entity.CardEntity;
import com.github.smthyellow.project0.model.Card;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.RollbackException;
import java.util.List;
import java.util.stream.Collectors;

public class CardDaoImpl implements CardDao{
    private static final Logger log = LoggerFactory.getLogger(CardDaoImpl.class);

    public static class Singleton {
        static CardDao HOLDER_INSTANCE = new CardDaoImpl();
    }

    public static CardDao getInstance() {
        return CardDaoImpl.Singleton.HOLDER_INSTANCE;
    }

    @Override
    public long addCard(Card card){
        CardEntity cardEntity = CardConverter.toEntity(card);
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(cardEntity);
        session.getTransaction().commit();

        return cardEntity.getCardId();
    }
    @Override
    public List<Card> getCardByUserId(long authUserId){
        Query<CardEntity> query = HibernateUtil.getSession()
                .createQuery("from CardEntity au where au.authUserId = :authUserId")
                .setParameter("authUserId", authUserId);
        List<CardEntity> cardEntityList = query.list();
        List<Card> cardList = cardEntityList.stream().map(CardConverter::fromEntity).collect(Collectors.toList());

        return cardList;
    }

    @Override
    public Card getCardByCardId(long cardId){
        CardEntity cardEntity = (CardEntity) HibernateUtil.getSession()
                .createQuery("from CardEntity au where au.cardId = :cardId")
                .setParameter("cardId", cardId).getSingleResult();

        return CardConverter.fromEntity(cardEntity);
    }
}

package com.github.smthyellow.project0.dao.dao.card;

import com.github.smthyellow.project0.dao.dao.account.AccountDao;
import com.github.smthyellow.project0.dao.dao.account.AccountDaoImpl;
import com.github.smthyellow.project0.dao.toDelete.HibernateUtil;
import com.github.smthyellow.project0.dao.converter.AccountConverter;
import com.github.smthyellow.project0.dao.converter.CardConverter;
import com.github.smthyellow.project0.dao.entity.AccountEntity;
import com.github.smthyellow.project0.dao.entity.CardEntity;
import com.github.smthyellow.project0.model.Card;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CardDaoImpl implements CardDao{
    private static final Logger log = LoggerFactory.getLogger(CardDaoImpl.class);

    public static class Singleton {
        static CardDao HOLDER_INSTANCE = new CardDaoImpl();
    }

    /*@Override


    public long addCard(long accountId, int cvv, long cardNumber){
        CardEntity cardEntity = new CardEntity(cvv, cardNumber);
        AccountEntity accountEntity = AccountConverter.toEntity(accountDao.getAccountByAccountId(accountId));
        final Session session = HibernateUtil.getSession();
        session.beginTransaction();
        cardEntity.setAccountEntity(accountEntity);
        accountEntity.getCardEntities().add(cardEntity);
        session.save(accountEntity);
        session.getTransaction().commit();

        return accountEntity.getAccountId();
    }
  //  @Override
//    public List<Card> getCardByAuthUserId(long authUserId){
//        Query<CardEntity> query = HibernateUtil.getSession()
//                .createQuery(
//                        "from CardEntity ce " +
//                        "join AccountEntity ae " +
//                        "where ae.authUserEntity.authUserId = :authUserId")
//                .setParameter("authUserId", authUserId);
//        List <CardEntity> cardEntityList = query.list();
//        List<Card> cardList = cardEntityList.stream().map(CardConverter::fromEntity).collect(Collectors.toList());
//
//        return cardList;
//    }
    @Override
    public List<Card> getCardList(long authUserId) {
        Query<CardEntity> query = HibernateUtil.getSession()
                .createQuery(
                        "from CardEntity ce " +
                        "join AccountEntity ae " +
                        "where ae.authUserEntity.authUserId = :authUserId")
                .setParameter("authUserId", authUserId)
                .setFirstResult(0)
                .setMaxResults(5);
        List<CardEntity> cardEntityList = query.getResultList();
        List<Card> cardList =
                cardEntityList.stream().
                        map(CardConverter::fromEntity).
                        collect(Collectors.toList());

        return cardList;
    }

    @Override
    public Card getCardByCardId(long cardId){
        CardEntity cardEntity = (CardEntity) HibernateUtil.getSession()
                .createQuery("from CardEntity au where au.cardId = :cardId")
                .setParameter("cardId", cardId).getSingleResult();

        return CardConverter.fromEntity(cardEntity);
    }

     */
}

package com.github.smthyellow.project0.dao.dao.card;

import com.github.smthyellow.project0.dao.dao.account.AccountDao;
import com.github.smthyellow.project0.dao.dao.account.AccountDaoImpl;
import com.github.smthyellow.project0.dao.repository.AccountRepository;
import com.github.smthyellow.project0.dao.repository.AuthUserRepository;
import com.github.smthyellow.project0.dao.repository.CardRepository;
import com.github.smthyellow.project0.dao.repository.UserRepository;
import com.github.smthyellow.project0.dao.toDelete.HibernateUtil;
import com.github.smthyellow.project0.dao.converter.AccountConverter;
import com.github.smthyellow.project0.dao.converter.CardConverter;
import com.github.smthyellow.project0.dao.entity.AccountEntity;
import com.github.smthyellow.project0.dao.entity.CardEntity;
import com.github.smthyellow.project0.model.AccountAndCardStatus;
import com.github.smthyellow.project0.model.Card;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardDaoImpl implements CardDao{
    private static final Logger log = LoggerFactory.getLogger(CardDaoImpl.class);

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;

    public CardDaoImpl(CardRepository cardRepository, AccountRepository accountRepository) {
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void addCard(int cvv, Long cardNumber, Long accountId, LocalDate expiryDate, AccountAndCardStatus status) {
        CardEntity cardEntity = new CardEntity(cvv, cardNumber, expiryDate, AccountAndCardStatus.ACTIVE);
        AccountEntity accountEntity = accountRepository.findByAccountId(accountId).orElse(null);
        cardEntity.setAccountEntity(accountEntity);
        cardRepository.save(cardEntity);
    }

    @Override
    public Card getByCardId(Long cardId) {
        Card card = CardConverter.fromEntity(cardRepository.findByCardId(cardId).orElse(null));
        return card;
    }

    @Override
    public int plusBalance(int sum, Long cardId) {
        AccountEntity accountEntity = cardRepository.findByCardId(cardId).orElse(null).getAccountEntity();
        int actualBalance = accountEntity.getBalance() + sum;
        accountRepository.changeBalance(actualBalance, accountEntity.getAccountId());
        return actualBalance;
    }

    @Override
    public int minusBalance(int sum, Long cardId) {
        AccountEntity accountEntity = cardRepository.findByCardId(cardId).orElse(null).getAccountEntity();
        int actualBalance = accountEntity.getBalance() - sum;
        accountRepository.changeBalance(actualBalance, accountEntity.getAccountId());
        return actualBalance;
    }

    @Override
    public void changeStatus(Long cardId, AccountAndCardStatus status) {
        cardRepository.changeCardStatus(status, cardId);
    }

    @Override
    public List<Card> getByAuthUserId(Long authUserId) {
        List<AccountEntity> accountEntities = accountRepository.findByAuthUserEntity(authUserId);
        List<Long> accountIds = accountEntities.stream()
                .map(entity -> entity.getAccountId())
                .collect(Collectors.toList());

        List<Card> cards = cardRepository.findByAccountEntityIn(accountIds).stream()
                .map(CardConverter::fromEntity)
                .collect(Collectors.toList());
        return cards;
    }

    @Override
    public void blockCard(Long cardId, AccountAndCardStatus status) {
        cardRepository.changeCardStatus(status, cardId);
        Long accountId = cardRepository.findByCardId(cardId).orElse(null).getAccountId();
        accountRepository.changeStatus(status, accountId);
    }

    @Override
    public List<Card> getByAccountId(Long accountId) {
        List<Card> cards = cardRepository.findByAccountEntity(accountId).stream()
                .map(CardConverter::fromEntity)
                .collect(Collectors.toList());
        return cards;
    }

    @Override
    public Card getByCardNumber(Long cardNumber) {
        return CardConverter.fromEntity(cardRepository.findByCardNumber(cardNumber).orElse(null));
    }

    @Override
    public List<Card> getByAccountIds(List<Long> accountIds) {
        return cardRepository.findByAccountEntityIn(accountIds).stream()
                .map(CardConverter::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Card> getByCompletedLimit() {
        return null;
    }

    @Override
    public List<Card> getCardByStatus(AccountAndCardStatus status) {
        return cardRepository.findByCardStatus(status).stream()
                .map(CardConverter::fromEntity)
                .collect(Collectors.toList());
    }
}

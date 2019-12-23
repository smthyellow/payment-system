package com.github.smthyellow.project0.dao.dao.card;

import com.github.smthyellow.project0.dao.entity.CardEntity;
import com.github.smthyellow.project0.model.AccountAndCardStatus;
import com.github.smthyellow.project0.model.Card;

import java.time.LocalDate;
import java.util.List;

public interface CardDao {
    List<Card> getCardByStatus(AccountAndCardStatus status);

    void addCard(int cvv, Long cardNumber, Long accountId, LocalDate expiryDate, AccountAndCardStatus status);

    Card getByCardId(Long cardId);

    int plusBalance(int sum, Long cardId);

    int minusBalance(int sum, Long cardId);

    void changeStatus(Long cardId, AccountAndCardStatus status);

    List <Card> getByAuthUserId(Long authUserId);

    void blockCard(Long cardId, AccountAndCardStatus status);

    List<Card> getByAccountId(Long accountId);

    Card getByCardNumber(Long cardNumber);

    List<Card> getByAccountIds(List<Long> accountIds);

    List<Card> getByCompletedLimit();
}

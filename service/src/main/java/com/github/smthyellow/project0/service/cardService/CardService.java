package com.github.smthyellow.project0.service.cardService;

import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AccountAndCardStatus;
import com.github.smthyellow.project0.model.Card;

import java.util.List;

public interface CardService {
    List<Card> getByAuthUserId(Long authUserId);

    List<Card> getCardByStatus(AccountAndCardStatus status);

    Card getByCardNumber(Long cardNumber);

    List<Card> getByAccountId(Long accountId);

    List<Card> getByAccountIds(List<Long> accountIds);

    Long addCard(Long accountId, int expiryMonth, int expiryYear);

}

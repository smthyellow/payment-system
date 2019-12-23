package com.github.smthyellow.project0.dao.dao.account;

import com.github.smthyellow.project0.dao.converter.AccountConverter;
import com.github.smthyellow.project0.dao.converter.AuthUserConverter;
import com.github.smthyellow.project0.dao.entity.AccountEntity;
import com.github.smthyellow.project0.dao.entity.AuthUserEntity;
import com.github.smthyellow.project0.dao.entity.CardEntity;
import com.github.smthyellow.project0.dao.repository.AccountRepository;
import com.github.smthyellow.project0.dao.repository.CardRepository;
import com.github.smthyellow.project0.model.Account;
import com.github.smthyellow.project0.model.AccountAndCardStatus;
import com.github.smthyellow.project0.model.AuthUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AccountDaoImpl implements AccountDao {
    private static final Logger log = LoggerFactory.getLogger(AccountDaoImpl.class);
    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;

    public AccountDaoImpl(AccountRepository accountRepository, CardRepository cardRepository) {
        this.accountRepository = accountRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public void saveAccount(AuthUser authUser, Long accountNumber, int balance, int limit) {
        AuthUserEntity authUserEntity = AuthUserConverter.toEntity(authUser);
        AccountEntity accountEntity = new AccountEntity(accountNumber, balance, limit, AccountAndCardStatus.ACTIVE);
        accountEntity.setAuthUserEntity(authUserEntity);
        accountRepository.save(accountEntity);
    }

    @Override
    public Account getByAccountId(Long accountId) {
        return accountRepository.findByAccountId(accountId).map(AccountConverter::fromEntity).orElse(null);
    }

    @Override
    public int minusBalance(Long accountId, int sum) {
        AccountEntity accountEntity = accountRepository.findByAccountId(accountId).orElse(null);
        int balance = accountEntity.getBalance();
        balance =-sum;
        accountEntity.setBalance(balance);
        accountRepository.changeBalance(balance, accountId);
        return balance;
    }

    @Override
    public int plusBalance(Long accountId, int sum) {
        AccountEntity accountEntity = accountRepository.findByAccountId(accountId).orElse(null);
        int balance = accountEntity.getBalance();
        balance =+sum;
        accountEntity.setBalance(balance);
        accountRepository.changeBalance(balance, accountId);
        return balance;
    }

    @Override
    public void changeStatus(Long accountId, AccountAndCardStatus status) {
        accountRepository.changeStatus(status, accountId);
        List<CardEntity> cardEntities = cardRepository.findByAccountEntity(accountId);
        cardEntities.stream().forEach(c -> cardRepository.changeCardStatus(status, c.getCardId()));
    }

    @Override
    public List getByAuthUserId(Long authUserId) {
        List<AccountEntity> accounts = accountRepository.findByAuthUserEntity(authUserId);
        return accounts.stream().map(AccountConverter::fromEntity).collect(Collectors.toList());
    }

    @Override
    public boolean compareBalanceWithBorder(Long accountId) {
        AccountEntity accountEntity = accountRepository.findByAccountId(accountId).orElse(null);
        return accountEntity.getBalance() > accountEntity.getBorder();
    }

    @Override
    public void changeBorder(Long accountId, int border) {
        accountRepository.changeBorder(border, accountId);
    }

    @Override
    public Account getByAccountNumber(Long accountNumber) {
        return AccountConverter.fromEntity(accountRepository.findByAccountNumber(accountNumber).orElse(null));
    }

    @Override
    public List<Account> getByAuthUserIds(List<Long> authUserIds) {
        return accountRepository.findByAuthUserEntityIn(authUserIds).stream()
                .map(AccountConverter::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> getAccountFinishedLimit() {
        List<AccountEntity> accountEntities = accountRepository.findAll();
        List<Account> accounts = accountEntities.stream()
                .filter(accountEntity -> accountEntity.getBalance()<accountEntity.getBorder())
                .map(AccountConverter::fromEntity)
                .collect(Collectors.toList());
        return accounts;
    }
}

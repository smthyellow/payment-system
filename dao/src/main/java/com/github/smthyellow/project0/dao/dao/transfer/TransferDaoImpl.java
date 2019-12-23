package com.github.smthyellow.project0.dao.dao.transfer;

import com.github.smthyellow.project0.dao.entity.AccountEntity;
import com.github.smthyellow.project0.dao.entity.AuthUserEntity;
import com.github.smthyellow.project0.dao.repository.AccountRepository;
import com.github.smthyellow.project0.dao.repository.AuthUserRepository;
import com.github.smthyellow.project0.dao.repository.CardRepository;
import com.github.smthyellow.project0.dao.repository.TransferRepository;
import com.github.smthyellow.project0.dao.toDelete.HibernateUtil;
import com.github.smthyellow.project0.dao.converter.TransferConverter;

import com.github.smthyellow.project0.dao.entity.TransferEntity;
import com.github.smthyellow.project0.model.Transfer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TransferDaoImpl implements TransferDao {
    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;

    public TransferDaoImpl(TransferRepository transferRepository, AccountRepository accountRepository) {
        this.transferRepository = transferRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void addTransfer(Long fromAccountId, Long toAccountId, int sum) {
        AccountEntity fromAccountEntity = accountRepository.findByAccountId(fromAccountId).orElse(null);
        int fromAccountBalance = fromAccountEntity.getBalance() - sum;
        accountRepository.changeBalance(fromAccountBalance, fromAccountId);

        AccountEntity toAccountEntity = accountRepository.findByAccountId(toAccountId).orElse(null);
        int toAccountBalance = toAccountEntity.getBalance() + sum;
        accountRepository.changeBalance(toAccountBalance, toAccountId);



        TransferEntity transferEntity = new TransferEntity(sum, LocalDateTime.now());
        transferEntity.setFromAccountEntity(fromAccountEntity);
        transferEntity.setToAccountEntity(toAccountEntity);
        transferRepository.save(transferEntity);
    }

    @Override
    public List<Transfer> getByFromAccount(Long fromAccountId) {
        List<Transfer> transfers = transferRepository.findByFromAccountEntity(fromAccountId).stream()
                .map(transferEntity -> TransferConverter.fromEntity(transferEntity))
                .collect(Collectors.toList());
        return transfers;
    }

    @Override
    public List<Transfer> getByToAccount(Long toAccountId) {
        List<Transfer> transfers = transferRepository.findByToAccountEntity(toAccountId).stream()
                .map(transferEntity -> TransferConverter.fromEntity(transferEntity))
                .collect(Collectors.toList());
        return transfers;
    }

    @Override
    public List<Transfer> getByToAuthUser(Long authUserId) {
        List<AccountEntity> accountEntities = accountRepository.findByAuthUserEntity(authUserId);
        List<Transfer> transfers = transferRepository.findByToAccountEntityIn(accountEntities).stream()
                .map(transferEntity -> TransferConverter.fromEntity(transferEntity))
                .collect(Collectors.toList());
        return transfers;
    }

    @Override
    public List<Transfer> getByFromAuthUser(Long authUserId) {
        List<AccountEntity> accountEntities = accountRepository.findByAuthUserEntity(authUserId);
        List<Transfer> transfers = transferRepository.findByFromAccountEntityIn(accountEntities).stream()
                .map(transferEntity -> TransferConverter.fromEntity(transferEntity))
                .collect(Collectors.toList());
        return transfers;
    }
}

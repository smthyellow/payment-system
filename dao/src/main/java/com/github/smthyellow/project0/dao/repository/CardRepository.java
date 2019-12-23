package com.github.smthyellow.project0.dao.repository;

import com.github.smthyellow.project0.dao.entity.AuthUserEntity;
import com.github.smthyellow.project0.dao.entity.CardEntity;
import com.github.smthyellow.project0.model.AccountAndCardStatus;
import com.github.smthyellow.project0.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<CardEntity, Long> {
    List<CardEntity> findByAccountEntity(Long accountId);
    Optional<CardEntity> findByCardId(Long cardId);
    List<CardEntity> findByAccountEntityIn(List<Long> accountIds);
    Optional<CardEntity> findByCardNumber(Long cardNumber);
    List<CardEntity> findByCardStatus(AccountAndCardStatus status);


    @Modifying
    @Query("update CardEntity ce set ce.cardStatus = ?1 where ce.cardId = ?2")
    void changeCardStatus(AccountAndCardStatus status, Long cardId);



    //@Query("select ce.* from AccountEntity ae left join CardEntity ce on ae.accountId where ae.balance < ae.border")

/*
    @Query("select ce from UserEntity ue LEFT JOIN AccountEntity ae on ae.authUserEntity = ue.authUserEntity left join CardEntity ce on ce.accountEntity = ae.cardEntities where ue.firstName =:firstname and ue.lastName =:lastName")
    List<CardEntity> getByFirstNameLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);
*/


}

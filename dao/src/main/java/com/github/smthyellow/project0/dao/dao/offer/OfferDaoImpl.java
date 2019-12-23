package com.github.smthyellow.project0.dao.dao.offer;

import com.github.smthyellow.project0.dao.converter.OfferConverter;
import com.github.smthyellow.project0.dao.entity.OfferEntity;
import com.github.smthyellow.project0.dao.repository.AuthUserRepository;
import com.github.smthyellow.project0.dao.repository.OfferRepository;
import com.github.smthyellow.project0.dao.entity.AuthUserEntity;
import com.github.smthyellow.project0.model.Offer;

import java.util.ArrayList;
import java.util.List;

/*
 */

public class OfferDaoImpl implements OfferDao {
    private final OfferRepository offerRepository;
    private  final AuthUserRepository authUserRepository;

    public OfferDaoImpl(OfferRepository offerRepository, AuthUserRepository authUserRepository) {
        this.offerRepository = offerRepository;
        this.authUserRepository = authUserRepository;
    }

    @Override
    public void createOffer(Offer offer) {
        OfferEntity offerEntity = OfferConverter.toEntity(offer);
        offerRepository.save(offerEntity);
    }

    @Override
    public void assignOffer(Long authUserId, Long offerId) {
        OfferEntity offerEntity = offerRepository.findByOfferId(offerId).orElse(null);
        AuthUserEntity authUserEntity = authUserRepository.findByAuthUserId(authUserId).orElse(null);
        List<OfferEntity> offerEntities = new ArrayList<>();
        offerEntities.add(offerEntity);
        authUserEntity.setOfferEntities(offerEntities);
        authUserRepository.save(authUserEntity);
    }

    @Override
    public void unassignOffer(Long authUserId, Long offerId) {
        OfferEntity offerEntity = offerRepository.findByOfferId(offerId).orElse(null);
        AuthUserEntity authUserEntity = authUserRepository.findByAuthUserId(authUserId).orElse(null);
        List<OfferEntity> offerEntities = authUserEntity.getOfferEntities();
        offerEntities.remove(offerEntity);
        authUserRepository.save(authUserEntity);
    }

    @Override
    public void deleteOffer(Long offerId) {

    }
}

package com.github.smthyellow.project0.dao.dao.offer;

import com.github.smthyellow.project0.model.Offer;

public interface OfferDao {
    void createOffer(Offer offer);

    void assignOffer(Long authUserId, Long offerId);

    void unassignOffer(Long authUserId, Long offerId);

    void deleteOffer(Long offerId);
}


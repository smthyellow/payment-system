package com.github.smthyellow.project0.dao.converter;

import com.github.smthyellow.project0.dao.entity.OfferEntity;
import com.github.smthyellow.project0.model.Offer;

public class OfferConverter {
    public static OfferEntity toEntity(Offer offer){
        if (offer == null){
            return null;
        }

        final OfferEntity offerEntity = new OfferEntity();

        offerEntity.setOfferId(offer.getOfferId());
        offerEntity.setAmount(offer.getAmount());
        return offerEntity;
    }

    public static Offer fromEntity(OfferEntity offerEntity){
        if (offerEntity == null){
            return null;
        }
        return new Offer(
                offerEntity.getOfferId(),
                offerEntity.getAmount()
        );
    }
}

package com.github.smthyellow.project0.dao.converter;

import com.github.smthyellow.project0.dao.entity.OfferEntity;
import com.github.smthyellow.project0.model.Offer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfferConverterTest {
    @Test
    void fromEntityNull() {
        final Offer bill = OfferConverter.fromEntity(null);
        assertNull(bill);
    }

    @Test
    void fromEntityNotNull() {
        final OfferEntity offerEntity = new OfferEntity();
        offerEntity.setOfferId(1);
        offerEntity.setAmount(2);

        final Offer bill = OfferConverter.fromEntity(offerEntity);

        assertNotNull(bill);
        assertEquals(bill.getOfferId(), offerEntity.getOfferId());
        assertEquals(bill.getAmount(), offerEntity.getAmount());
    }

    @Test
    void toEntityNull() {
        final OfferEntity offerEntity = OfferConverter.toEntity(null);
        assertNull(offerEntity);
    }

    @Test
    void toEntityNotNull() {
        final Offer bill = new Offer(1, 2L);

        final OfferEntity offerEntity = OfferConverter.toEntity(bill);

        assertNotNull(bill);
        assertEquals(bill.getOfferId(), offerEntity.getOfferId());
        assertEquals(bill.getAmount(), offerEntity.getAmount());
    }

}
package com.github.smthyellow.project0.dao;

import com.github.smthyellow.project0.dao.util.HibernateUtil;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class HibernateUtilTest {
    @Test
    void getEM() {
        EntityManager em = HibernateUtil.getEm();
        assertNotNull(em);
    }

    @Test
    void getSession() {
        assertNotNull(HibernateUtil.getSession());
    }

    @Test
    void close() {
//        HibernateUtil.close();
//        Assertions.assertThrows(IllegalStateException.class, () -> {
//            HibernateUtil.getEntityManager();
//        });
    }
}
package com.github.smthyellow.project0.dao.toDelete;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static final String PERSISTENT_UNIT_NAME = "smthyellow";
    private static EntityManagerFactory emFactory = null;

    public static Session getSession() {
        return getEm().unwrap(Session.class);
    }

    public static EntityManager getEm() {
        if (emFactory == null) {
            emFactory = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
        }
        return emFactory.createEntityManager();
    }

    public static void closeEMFactory() {
        emFactory.close();
    }
}

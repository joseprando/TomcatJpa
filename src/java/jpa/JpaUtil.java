package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    
    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("TomcatJpaPU");
        }
        
        return emf.createEntityManager();
    }
    
    public static void close() {
        if (emf == null) {
            emf.close();
            emf = null;
        }
    }
}

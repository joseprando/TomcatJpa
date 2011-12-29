package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationService {

    public EntityManagerFactory emf = null;
    public EntityManager entityManager = null;
    public static final String PU_NAME = "TomcatJpaPU";
    
    public ApplicationService() {
        emf = Persistence.createEntityManagerFactory(PU_NAME);
        entityManager = emf.createEntityManager();
    }
}

package facades;

import entities.Guide;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class GuideFacade {

    private static EntityManagerFactory emf;
    private static GuideFacade instance;

    public GuideFacade(){

    }

    public static GuideFacade getGuideFacade(EntityManagerFactory _emf){

        if (instance == null) {
            emf = _emf;
            instance = new GuideFacade();
        }
        return instance;
    }

    public static Guide createGuide(Guide guide){

        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(guide);
            em.getTransaction().commit();
            return guide;
        }finally {
            em.close();
        }


    }

    public List<Guide> getAllGuides(){
        EntityManager em = emf.createEntityManager();
    try {
        TypedQuery<Guide> query = em.createQuery("SELECT G from Guide G",Guide.class);
        return query.getResultList();
    }finally {
        em.close();
    }
    }

    }



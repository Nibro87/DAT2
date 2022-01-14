package facades;

import entities.Trip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class TripFacade {

    private static EntityManagerFactory emf;
    private static TripFacade instance;

    public TripFacade(){
    }

    public static TripFacade getTripFacade(EntityManagerFactory _emf){

        if (instance == null) {
            emf = _emf;
            instance = new TripFacade();
        }
        return instance;
    }

    public static Trip createTrip(Trip trip) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(trip);
            em.getTransaction().commit();
            return trip;

        }finally {
            em.close();
        }
    }








    public List<Trip> getAllTrips() {

        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Trip> query = em.createQuery("SELECT T from Trip T",Trip.class);
            return query.getResultList();
        }finally {
            em.close();
        }


    }


    public Trip deleteById(Long tripId){

        EntityManager em = emf.createEntityManager();

        Trip trip = em.find(Trip.class,tripId);

        try {
            em.getTransaction().begin();
            em.remove(trip);
            em.getTransaction().commit();
            return trip;
        } finally {
            em.close();

        }



        }

    public Trip findByID(Long tripId) {

        EntityManager em = emf.createEntityManager();

        Trip trip = em.find(Trip.class, tripId);


        return trip;

    }




    }











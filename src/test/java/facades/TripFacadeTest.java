package facades;

import entities.Trip;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TripFacadeTest {

    private static EntityManagerFactory emf;
    private static TripFacade tripFacade;
    Trip trip;


    public TripFacadeTest(){

    }

    @BeforeAll
    public static void setUpClass(){
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        tripFacade = TripFacade.getTripFacade(emf);
    }

    @AfterAll
    public static void tearDownClass(){

    }

    @BeforeEach
    public void setUp(){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();


            em.persist(new Trip("tivoli","13-01","21.00","rådhuset","2 timer","penge"));


            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }


    @AfterEach
    public void tearDown(){

    }

    @Test
    public void testAFacadeMethod() throws Exception {
        System.out.println("this test ran,");
        TripFacade tripFacade = new TripFacade();

    }







   @Test
    public void testGetAllTrips(){
       List<Trip> expected = tripFacade.getAllTrips();
       int actual = 1;

       assertEquals(expected.size(),actual);

    }


}

import static org.junit.Assert.assertTrue;
import ex2.bankjpa.model.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

public class JpaTest {

    private static final String PERSISTENCE_UNIT_NAME = "people";
    private EntityManagerFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // Begin a new local transaction so that we can persist a new entity
        em.getTransaction().begin();

        // read the existing entries
        Query q = em.createQuery("select m from Person m");
        // Persons should be empty

        // do we have entries?
        boolean createNewEntries = (q.getResultList().size() == 0);

        // No, so lets create new entries
        if (createNewEntries) {
            assertTrue(q.getResultList().size() == 0);

            Person person = new Person();
            person.setName("Max Mustermann");

            Adress adress = new Adress();
            adress.setStreet("Inndalsveien");
            adress.setNumber(28);

            CreditCard card1 = new CreditCard();
            card1.setNumber(12345);
            card1.setBalance(-5000);
            card1.setLimit(-10000);

            CreditCard card2 = new CreditCard();
            card2.setNumber(123);
            card2.setBalance(1);
            card2.setLimit(2000);

            Pincode pin = new Pincode();
            pin.setPincode("123");

            Bank bank = new Bank();
            bank.setName("Pengebank");


            //foreign keys
            person.setAdressList(new ArrayList<Adress>(Arrays.asList(adress)));

            CreditCard cards[] = new CreditCard[] {card1,card2};
            person.setCardList(new ArrayList<CreditCard>(Arrays.asList(cards)));

            adress.setPeopleList(new ArrayList<Person>(Arrays.asList(person)));
            card1.setBank(bank);
            card1.setPincode(pin);
            card2.setBank(bank);
            card2.setPincode(pin);
            bank.setCardList(new ArrayList<CreditCard>(Arrays.asList(cards)));

            //persisting
            em.persist(person);
            em.persist(adress);
            em.persist(card1);
            em.persist(card2);
            em.persist(pin);
            em.persist(bank);
        }

        // Commit the transaction, which will cause the entity to
        // be stored in the database
        em.getTransaction().commit();

        // It is always good practice to close the EntityManager so that
        // resources are conserved.
        em.close();

    }

    @Test
    public void checkAvailablePeople() {

        // now lets check the database and see if the created entries are there
        // create a fresh, new EntityManager
        EntityManager em = factory.createEntityManager();

        // Perform a simple query for all the Message entities
        Query q = em.createQuery("select m from Person m");

        // We should have 40 Persons in the database
        assertTrue(q.getResultList().size() == 1);

        em.close();
    }

    @Test
    public void checkCards() {
        EntityManager em = factory.createEntityManager();
        // Go through each of the entities and print out each of their
        // messages, as well as the date on which it was created
        Query q = em.createQuery("select f from CreditCard f");

        // We should have 2 cards
        assertTrue(q.getResultList().size() == 2);
        em.close();
    }

    @Test(expected = javax.persistence.NoResultException.class)
    public void deletePerson() {
        EntityManager em = factory.createEntityManager();
        // Begin a new local transaction so that we can persist a new entity
        em.getTransaction().begin();
        Query q = em
                .createQuery("SELECT p FROM Person p WHERE p.name = :name");
        q.setParameter("name", "Jim_1");
        Person user = (Person) q.getSingleResult();
        em.remove(user);
        em.getTransaction().commit();
        Person person = (Person) q.getSingleResult();
        // Begin a new local transaction so that we can persist a new entity

        em.close();
    }
}
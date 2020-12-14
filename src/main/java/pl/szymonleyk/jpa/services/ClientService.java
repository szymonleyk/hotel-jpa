package pl.szymonleyk.jpa.services;

import pl.szymonleyk.jpa.entities.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClientService {
    // entiti manager
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel_db");
    EntityManager em;

    public void add(Client client){
        // zapisanie pokoju
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Client find(int id) {
        em = emf.createEntityManager();
        Client client = em.find(Client.class, id);
        em.close();

        return client;
    }

    public void remove(int id) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Client client = em.find(Client.class, id);
            em.remove(client);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Client> findAll() {
        em = emf.createEntityManager();
        List<Client> clients = em.createQuery("from Client", Client.class).getResultList();
        em.close();

        return clients;
    }

    public List<Client> findByName(String name) {
        em = emf.createEntityManager();
        TypedQuery<Client> query = em.createQuery("from Client where name = :name", Client.class);
        query.setParameter("name", name);
        List<Client> clients = query.getResultList();

        em.close();

        return clients;
    }
}

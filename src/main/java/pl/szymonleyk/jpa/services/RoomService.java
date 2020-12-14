package pl.szymonleyk.jpa.services;

import pl.szymonleyk.jpa.entities.Room;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class RoomService {
    // entiti manager
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotel_db");
    EntityManager em;

    public void add(Room room){
        // zapisanie pokoju
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(room);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Room find(int id) {
        em = emf.createEntityManager();
        Room room = em.find(Room.class, id);
        em.close();

        return room;
    }

    public void update(int id, String name) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Room room = em.find(Room.class, id);
            room.setName(name);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void updateByMerge(Room room) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(room);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remove(int id) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Room room = em.find(Room.class, id);
            em.remove(room);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Room> findAll() {
        em = emf.createEntityManager();
        List<Room> rooms = em.createQuery("from Room", Room.class).getResultList();
        em.close();

        return rooms;
    }

    public List<Room> findByName(String name) {
        em = emf.createEntityManager();
        TypedQuery<Room> query = em.createQuery("from Room where name = :name", Room.class);
        query.setParameter("name", name);
        List<Room> rooms = query.getResultList();

        em.close();

        return rooms;
    }
}

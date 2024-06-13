package com.example.Fitnes_Club.dal;
import com.example.Fitnes_Club.models.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Getter
public class DataAccessLayer {
    private final SessionFactory sessionFactory;

    @Autowired
    public DataAccessLayer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    Session session = null;

    public void updateApartment(Long id, Apartment updatedApartment) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Apartment apartment = session.get(Apartment.class, id);
        apartment.setApartmentNumber(updatedApartment.getApartmentNumber());
        apartment.setAreaSquareMeters(updatedApartment.getAreaSquareMeters());
        apartment.setPrice(updatedApartment.getPrice());
        apartment.setRenovationNeeded(updatedApartment.isRenovationNeeded());
        apartment.setBuilding(updatedApartment.getBuilding());

        session.merge(apartment);
        session.getTransaction().commit();
    }

    public Apartment getApartment(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Apartment apartment = session.get(Apartment.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return apartment;
    }

    public List<Apartment> getApartments(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Apartment> query = builder.createQuery(Apartment.class);
        Root<Apartment> root = query.from(Apartment.class);
        query.select(root);
        List<Apartment> resultList = session.createQuery(query).getResultList();
        return resultList;
    }

    public void createApartment(Apartment newApartment) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newApartment);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public void deleteApartment(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Apartment apartment = session.get(Apartment.class, id);
        session.remove(apartment);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }

    public List<Developer> getWorkouts(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Developer> query = builder.createQuery(Developer.class);
        Root<Developer> root = query.from(Developer.class);
        query.select(root);
        List<Developer> resultList = session.createQuery(query).getResultList();
        return resultList;
    }


    public void createClients(Clients newClients) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newClients);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteClients(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Clients clients = session.get(Clients.class, id);
        session.remove(clients);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateClients(Long id, Clients updatedClients){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Clients clients = session.get(Clients.class, id);

        session.merge(clients);
        session.getTransaction().commit();
    }
    public Clients getClients(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Clients clients = session.get(Clients.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return clients;
    }
    public List<Clients> getClients(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Clients> query = builder.createQuery(Clients.class);
        Root<Clients> root = query.from(Clients.class);
        query.select(root);
        List<Clients> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public void createUser(User newUser) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newUser);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteUser(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.remove(user);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void updateUser(Long id, User updatedUser){
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        session.merge(user);
        session.getTransaction().commit();
    }
    public User getUser(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return user;
    }
    public List<User> getUsers(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        List<User> resultList = session.createQuery(query).getResultList();
        return resultList;
    }

    public String newUserToDatabase(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String name = user.getName();

        Query query = session
                .createQuery("FROM User where Name = :name")
                .setParameter("name", name);
        User userFrom = (User) query.uniqueResult();

        if (userFrom != null) {
            return "Выберите другое имя";
        }
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return "Pabeda)";
    }

    public User getUserFromDatabaseByUsername(String name) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session
                .createQuery("FROM User where Name = :name")
                .setParameter("name", name);
        User userFrom = (User) query.uniqueResult();
        if (userFrom == null) {
            return null;
        }
        return userFrom;
    }
}

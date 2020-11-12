package se.iths.service;

import se.iths.entity.Item;
import se.iths.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserService {
    @PersistenceContext
    EntityManager entityManager;

    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    public User updateUser(User user) {
        entityManager.merge(user);
        return user;
    }

    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    public List<User> getAllUsers() {
        return entityManager.createNamedQuery("User.findAllUnordered").getResultList();
    }

    public List<Item> getAllItemsByUserId(Long id){
        return entityManager.createQuery("SELECT i FROM Item i WHERE i.user.id = " + id, Item.class).getResultList();
    }
}

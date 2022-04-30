package de.hse.gruppe8.orm.dao;

import de.hse.gruppe8.exception.NoUserFoundException;
import de.hse.gruppe8.orm.model.User;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserDao {
    @Inject
    EntityManager entityManager;

    private static final Logger LOGGER = Logger.getLogger(UserDao.class);


    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    public User login(String username, String password) {
        try {
            LOGGER.debug("Checking for user name and password");
            return (User) entityManager.createQuery("SELECT user FROM User user " +
                            "WHERE user.username=:username " +
                            "AND user.password=:password " +
                            "AND user.active=true")
                    .setParameter("username", username)
                    .setParameter("password", password).getSingleResult();

        } catch(NoResultException e) {
            throw new NoUserFoundException(username);
        }
    }

    public List<User> getUsers() {
        Query q = entityManager.createQuery("select users from User users where users.active");
        List<User> users = q.getResultList();
        return users;
    }

    @Transactional
    public User save(User user) {
        if (user.getId() != null) {
            user = entityManager.merge(user);
        } else {
            entityManager.persist(user);
        }
        return user;
    }
    @Transactional
    public void delete(User user) {
        if (user != null) {
            user.setActive(false);
            entityManager.persist(user);
        }
    }
}

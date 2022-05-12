package de.hse.gruppe8.orm.dao;

import de.hse.gruppe8.exception.NoUserFoundException;
import de.hse.gruppe8.jaxrs.model.User;
import de.hse.gruppe8.orm.model.UserEntity;
import de.hse.gruppe8.util.mapper.UserMapper;
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

    @Inject
    UserMapper userMapper;
    private static final Logger LOGGER = Logger.getLogger(UserDao.class);


    public UserEntity getUser(Long id) {
        return entityManager.find(UserEntity.class, id);
    }

    public UserEntity login(String username, String password) {
        try {
            LOGGER.debug("Checking for user name and password");
            return (UserEntity) entityManager.createQuery("SELECT user FROM UserEntity user " +
                            "WHERE user.username=:username " +
                            "AND user.password=:password " +
                            "AND user.active=true")
                    .setParameter("username", username)
                    .setParameter("password", password).getSingleResult();

        } catch(NoResultException e) {
            throw new NoUserFoundException(username);
        }
    }

    public List<UserEntity> getUsers() {
        Query q = entityManager.createQuery("select users from UserEntity users where users.active");
        List<UserEntity> users = q.getResultList();
        return users;
    }

    @Transactional
    public UserEntity save(UserEntity user) {
        if (user.getId() != null) {
            user = entityManager.merge(user);
        } else {
            entityManager.persist(user);
        }
        return user;
    }
    @Transactional
    public void delete(UserEntity user) {
        if (user != null) {
            user.setActive(false);
            entityManager.persist(user);
        }
    }

    @Transactional
    public void addUser(UserEntity userEntity){
        entityManager.persist(userEntity);
    }

    @Transactional
    public void updateUser(UserEntity userEntity){
        entityManager.merge(userEntity);
    }
}

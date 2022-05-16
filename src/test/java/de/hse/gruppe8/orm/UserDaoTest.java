package de.hse.gruppe8.orm;

import de.hse.gruppe8.orm.dao.UserDao;
import de.hse.gruppe8.orm.model.UserEntity;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class UserDaoTest {

    @Inject
    UserDao userDao;

    @BeforeEach
    void clearAllFromDatabase() {
        userDao.removeAll();
    }

    @Test
    void checkAddUser() {
        //Given
        UserEntity userEntity = new UserEntity(null, "username", "passord", false, "firstname", "lastName", "email@admin.de", null, null, true, null);

        //When
        userDao.save(userEntity);

        //Then
        assertEquals(userDao.getUsers().size(), 1);
    }

    @Test
    void checkUpdateUser() {
        //Given
        UserEntity userEntity = new UserEntity(null, "username", "passord", false, "firstname", "lastName", "email@admin.de", null, null, true, null);
        userDao.save(userEntity);
        UserEntity user = userDao.getUsers().get(0);
        final String newName = "andrenNamen";
        //When

        user.setFirstName(newName);
        userDao.save(user);

        //Then
        assertEquals(userDao.getUsers().size(), 1);
        assertEquals(userDao.getUser(user.getId()).getFirstName(), newName);
    }

    @Test
    void checkDeleteUser() {
        //Given
        UserEntity userEntity = new UserEntity(null, "username", "passord", false, "firstname", "lastName", "email@admin.de", null, null, true, null);
        userDao.save(userEntity);
        UserEntity user = userDao.getUsers().get(0);
        //When
        userDao.delete(user);

        //Then
        assertEquals(userDao.getUsers().size(), 0);
    }
}

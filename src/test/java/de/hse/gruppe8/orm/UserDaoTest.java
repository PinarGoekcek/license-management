package de.hse.gruppe8.orm;

import de.hse.gruppe8.orm.dao.UserDao;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class UserDaoTest {

    @Inject
    UserDao userDao;

    @Test
    void checkCreateUser(){

    }
}

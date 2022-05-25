package de.hse.gruppe8.jaxrs.services;

import de.hse.gruppe8.jaxrs.model.User;
import de.hse.gruppe8.orm.dao.UserDao;
import de.hse.gruppe8.orm.model.UserEntity;
import de.hse.gruppe8.util.mapper.UserMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserService {

    @Inject
    UserDao userDao;

    @Inject
    UserMapper userMapper;


    public User getUser(Long id) {
        UserEntity userEntity = userDao.getUser(id);
        return userMapper.toUser(userEntity);
    }

}

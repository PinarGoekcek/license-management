package de.hse.gruppe8.jaxrs.services;

import de.hse.gruppe8.orm.dao.UserDao;
import de.hse.gruppe8.orm.model.User;
import de.hse.gruppe8.util.JwtToken;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class LoginService {
    @Inject
    UserDao userDao;

    @Inject
    JwtToken jwtToken;

    public User login(String username, String password){
        User user = userDao.login(username, password);
        user.setJwt(jwtToken.createUserToken(user.getId()));
        return user;
    }
}

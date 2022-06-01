package de.hse.gruppe8.orm.dao;

import de.hse.gruppe8.orm.model.ContractEntity;
import de.hse.gruppe8.orm.model.UserEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ContractToUserDao {
    @Inject
    EntityManager entityManager;

    private static final Logger LOGGER = Logger.getLogger(ContractToUserDao.class);

    public List<ContractEntity> getContractsForUser (UserEntity userEntity) {
        Query q = entityManager.createQuery("select contracts from ContractToUserEntity contracts where contracts.user.id = :USER", UserEntity.class);
        q.setParameter("USER", userEntity.getId());
        List<ContractEntity> contracts = (List<ContractEntity>) q.getResultList();
        return contracts;
    }

    public List<UserEntity> getUsersForContract (ContractEntity contractEntity) {
        Query q = entityManager.createQuery("select users from ContractToUserEntity users where users.contract.id = :CONTRACT", ContractEntity.class);
        q.setParameter("CONTRACT", contractEntity.getId());
        List<UserEntity> users = (List<UserEntity>) q.getResultList();
        return users;
    }
}

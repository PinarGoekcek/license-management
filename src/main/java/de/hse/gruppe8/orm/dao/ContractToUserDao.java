package de.hse.gruppe8.orm.dao;

import de.hse.gruppe8.orm.model.ContractEntity;
import de.hse.gruppe8.orm.model.ContractToUserEntity;
import de.hse.gruppe8.orm.model.UserEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ContractToUserDao {
    @Inject
    EntityManager entityManager;

    private static final Logger LOGGER = Logger.getLogger(ContractToUserDao.class);

    public List<ContractEntity> getContractsForUser (UserEntity userEntity) {
        TypedQuery<ContractToUserEntity> q = entityManager.createQuery("select entities from ContractToUserEntity entities where entities.user.id = :USER", ContractToUserEntity.class);
        q.setParameter("USER", userEntity.getId());
        List<ContractToUserEntity> contractUsers = q.getResultList();

        List<ContractEntity> contracts = new ArrayList<>();
        for (ContractToUserEntity entry : contractUsers){
            contracts.add(entry.getContract());
        }
        return contracts;
    }

    public List<UserEntity> getUsersForContract (ContractEntity contractEntity) {
        TypedQuery<ContractToUserEntity> q = entityManager.createQuery("select entities from ContractToUserEntity entities where entities.contract.id = :CONTRACT", ContractToUserEntity.class);
        q.setParameter("CONTRACT", contractEntity.getId());
        List<ContractToUserEntity> contractUsers = q.getResultList();

        List<UserEntity> users = new ArrayList<>();
        for (ContractToUserEntity entry : contractUsers){
            users.add(entry.getUser());
        }
        return users;
    }

    @Transactional
    public ContractToUserEntity save(ContractToUserEntity contractToUser) {
        if (contractToUser.getId() != null) {
            contractToUser = entityManager.merge(contractToUser);
        } else {
            entityManager.persist(contractToUser);
        }
        return contractToUser;
    }

    @Transactional
    public void removeAll() {
        Query del = entityManager.createQuery("DELETE FROM ContractToUserEntity WHERE id >= 0");
        del.executeUpdate();
    }
}

package de.hse.gruppe8.orm.dao;

import de.hse.gruppe8.orm.model.Contract;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ContractDao {
    @Inject
    EntityManager entityManager;

    private static final Logger LOGGER = Logger.getLogger(UserDao.class);


    public Contract getContract(Long id) {
        return entityManager.find(Contract.class, id);
    }

    public List<Contract> getContracts () {
        Query q = entityManager.createQuery("select companies from Contract companies where Contract.active");
        return q.getResultList();
    }

    @Transactional
    public Contract save(Contract contract) {
        if (contract.getId() != null) {
            contract = entityManager.merge(contract);
        } else {
            entityManager.persist(contract);
        }
        return contract;
    }
    @Transactional
    public void delete(Contract contract) {
        if (contract != null) {
            contract.setActive(false);
            entityManager.persist(contract);
        }
    }
}

package de.hse.gruppe8.orm.dao;

import de.hse.gruppe8.orm.model.ContractEntity;
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

    private static final Logger LOGGER = Logger.getLogger(ContractDao.class);


    public ContractEntity getContract(Long id) {
        return entityManager.find(ContractEntity.class, id);
    }

    public List<ContractEntity> getContracts () {
        Query q = entityManager.createQuery("select contracts from ContractEntity contracts where ContractEntity.active");
        return q.getResultList();
    }

    @Transactional
    public ContractEntity save(ContractEntity contract) {
        if (contract.getId() != null) {
            contract = entityManager.merge(contract);
        } else {
            entityManager.persist(contract);
        }
        return contract;
    }
    @Transactional
    public void delete(ContractEntity contract) {
        if (contract != null) {
            contract.setActive(false);
            entityManager.persist(contract);
        }
    }
}

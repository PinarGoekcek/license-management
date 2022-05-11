package de.hse.gruppe8.orm.dao;

import de.hse.gruppe8.orm.model.IPAddressEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class IPAddressDao {
    @Inject
    EntityManager entityManager;

    private static final Logger LOGGER = Logger.getLogger(IPAddressDao.class);


    public IPAddressEntity getIPAddress (Long id) {
        return entityManager.find(IPAddressEntity.class, id);
    }

    public List<IPAddressEntity> getIPAddresses() {
        Query q = entityManager.createQuery("select ipAddresses from IPAddressEntity ipAddresses");
        return q.getResultList();
    }

    @Transactional
    public IPAddressEntity save(IPAddressEntity ipAddress) {
        if (ipAddress.getId() != null) {
            ipAddress = entityManager.merge(ipAddress);
        } else {
            entityManager.persist(ipAddress);
        }
        return ipAddress;
    }
    @Transactional
    public void delete(IPAddressEntity ipAddress) {
        if (ipAddress != null) {
            entityManager.persist(ipAddress);
        }
    }
}

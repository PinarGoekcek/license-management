package de.hse.gruppe8.orm.dao;

import de.hse.gruppe8.orm.model.IPAddressEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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

    public List<IPAddressEntity> getIPAddresses () {
        TypedQuery<IPAddressEntity> q = entityManager.createQuery("select entities from IPAddressEntity entities where entities.id >= 0", IPAddressEntity.class);
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
            TypedQuery<IPAddressEntity> del = entityManager.createQuery("select entities from IPAddressEntity entities where entities.id = :IPADDRESS", IPAddressEntity.class);
            del.setParameter("IPADDRESS", ipAddress.getId());
            del.executeUpdate();
        }
    }

    @Transactional
    public void removeAll() {
        Query del = entityManager.createQuery("DELETE FROM IPAddressEntity WHERE id >= 0");
        del.executeUpdate();
    }
}

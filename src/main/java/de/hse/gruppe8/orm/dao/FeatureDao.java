package de.hse.gruppe8.orm.dao;

import de.hse.gruppe8.orm.model.FeatureEntity;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FeatureDao {
    @Inject
    EntityManager entityManager;


    private static final Logger LOGGER = Logger.getLogger(FeatureDao.class);


    public FeatureEntity getFeature (Long id) {
        return entityManager.find(FeatureEntity.class, id);
    }

    public List<FeatureEntity> getFeatures () {
        TypedQuery<FeatureEntity> q = entityManager.createQuery("select features from FeatureEntity features where features.id >= 0", FeatureEntity.class);
        return q.getResultList();
    }

    @Transactional
    public FeatureEntity save(FeatureEntity feature) {
        if (feature.getId() != null) {
            feature = entityManager.merge(feature);
        } else {
            entityManager.persist(feature);
        }
        return feature;
    }
    @Transactional
    public void delete(FeatureEntity feature) {
        if (feature != null) {
            TypedQuery<FeatureEntity> del = entityManager.createQuery("select features from FeatureEntity features where features.id = :FEATURE", FeatureEntity.class);
            del.setParameter("FEATURE", feature.getId());
            del.executeUpdate();
        }
    }

    @Transactional
    public void removeAll() {
        Query del = entityManager.createQuery("DELETE FROM FeatureEntity WHERE id >= 0");
        del.executeUpdate();
    }
}

package de.hse.gruppe8.orm.dao;

import de.hse.gruppe8.exception.NoUserFoundException;
import de.hse.gruppe8.orm.model.Company;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CompanyDao {
    @Inject
    EntityManager entityManager;

    private static final Logger LOGGER = Logger.getLogger(UserDao.class);


    public Company getCompany (Long id) {
        return entityManager.find(Company.class, id);
    }

    public List<Company> getCompanies () {
        Query q = entityManager.createQuery("select companies from Company companies where Company.active");
        return q.getResultList();
    }

    @Transactional
    public Company save(Company company) {
        if (company.getId() != null) {
            company = entityManager.merge(company);
        } else {
            entityManager.persist(company);
        }
        return company;
    }
    @Transactional
    public void delete(Company company) {
        if (company != null) {
            company.setActive(false);
            entityManager.persist(company);
        }
    }
}

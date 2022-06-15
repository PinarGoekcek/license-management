package de.hse.gruppe8.jaxrs.services;

import de.hse.gruppe8.jaxrs.model.Company;
import de.hse.gruppe8.jaxrs.model.User;
import de.hse.gruppe8.orm.dao.CompanyDao;
import de.hse.gruppe8.orm.model.CompanyEntity;
import de.hse.gruppe8.util.mapper.CompanyMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CompanyService {

    @Inject
    CompanyDao companyDao;

    @Inject
    CompanyMapper companyMapper;

    public List<Company> getCompanies(User currentUser) {
        List<Company> companies = new ArrayList<Company>();
        if (currentUser.getIsAdmin()) {
            List<CompanyEntity> companyEntities = companyDao.getCompanies();
            for (CompanyEntity companyEntity : companyEntities) {
                companies.add(companyMapper.toCompany(companyEntity));
            }
        } else {
            companies.add(currentUser.getCompany());
        }
        return companies;
    }

    public Company getCompany(User currentUser, Long id) {
        Company company = null;
        if (currentUser.getIsAdmin()) {
            CompanyEntity companyEntity = companyDao.getCompany(id);
            company = companyMapper.toCompany(companyEntity);
        } else if (id.equals(currentUser.getCompany().getId())) {
            company = currentUser.getCompany();
        }
        return company;
    }

    public Company createCompany(User currentUser, Company company) {
        if (currentUser.getIsAdmin()) {
            CompanyEntity companyEntity = companyMapper.toCompanyEntity(company);
            companyEntity = companyDao.save(companyEntity);
            return companyMapper.toCompany(companyEntity);
        }
        return null;
    }

    public boolean deleteCompany(User currentUser, Long id) {
        if (currentUser.getIsAdmin()) {
            companyDao.delete(companyDao.getCompany(id));
            return true;
        }
        return false;
    }

    public Company updateCompany(User currentUser, Company company) {
        if (currentUser.getIsAdmin()) {
            CompanyEntity companyEntity = companyDao.getCompany(company.getId());
            companyEntity = companyMapper.mapCompanyEntityWithCompany(companyEntity, company);
            companyEntity = companyDao.save(companyEntity);
            return companyMapper.toCompany(companyEntity);
        } else {
            return null;
        }
    }

    public List<User> getUsersFromCompany(User currentUser, Long id) {
        return null;
    }

    public List<User> getContractsFromCompany(User currentUser, Long id) {
        return null;
    }
}

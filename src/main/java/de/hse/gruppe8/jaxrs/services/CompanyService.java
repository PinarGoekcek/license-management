package de.hse.gruppe8.jaxrs.services;

import de.hse.gruppe8.jaxrs.model.Company;
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

    public List<Company> getCompanies(){
        List<CompanyEntity> companyEntities = companyDao.getCompanies();
        List<Company> companies = new ArrayList<Company>();

        for (int i = 0; i < companyEntities.size(); i++) {
            companies.add(companyMapper.toCompany(companyEntities.get(i)));
        }

        return companies;
    }

    public Company getCompany(Long id){
        CompanyEntity companyEntity = companyDao.getCompany(id);
        Company company = companyMapper.toCompany(companyEntity);
        return company;
    }
}

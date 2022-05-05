package de.hse.gruppe8.jaxrs.services;

import de.hse.gruppe8.orm.dao.CompanyDao;
import de.hse.gruppe8.util.mapper.CompanyMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CompanyService {

    @Inject
    CompanyDao companyDao;

    @Inject
    CompanyMapper companyMapper;
}

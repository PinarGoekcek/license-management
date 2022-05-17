package de.hse.gruppe8.util.mapper;

import de.hse.gruppe8.jaxrs.model.Company;
import de.hse.gruppe8.orm.model.CompanyEntity;
import org.mapstruct.Mapper;

@Mapper(config = MappingConfig.class)
public interface CompanyMapper {

    CompanyEntity toCompanyEntity(Company company);
    Company toCompany(CompanyEntity companyEntity);
}

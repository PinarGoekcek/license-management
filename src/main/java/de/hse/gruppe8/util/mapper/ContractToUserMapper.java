package de.hse.gruppe8.util.mapper;

import de.hse.gruppe8.jaxrs.model.ContractToUser;
import de.hse.gruppe8.orm.model.CompanyEntity;
import de.hse.gruppe8.orm.model.ContractToUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = MappingConfig.class, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ContractToUserMapper {

    ContractToUserEntity toContractToUserEntity(ContractToUser contractToUser);

    ContractToUser toContractToUser(ContractToUserEntity contractToUserEntity);

    ContractToUserEntity mapContractToUserEntityWithContractToUser(@MappingTarget ContractToUserEntity s1, ContractToUser s2);

}
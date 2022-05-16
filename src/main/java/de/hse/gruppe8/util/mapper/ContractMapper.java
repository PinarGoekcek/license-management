package de.hse.gruppe8.util.mapper;

import de.hse.gruppe8.jaxrs.model.Contract;
import de.hse.gruppe8.orm.model.ContractEntity;
import org.mapstruct.Mapper;

@Mapper(config = MappingConfig.class)
public interface ContractMapper {

    ContractEntity toContractEntity(Contract contract);
    Contract toContract(ContractEntity contractEntity);
}

package de.hse.gruppe8.jaxrs.services;

import de.hse.gruppe8.jaxrs.model.Contract;
import de.hse.gruppe8.jaxrs.model.User;
import de.hse.gruppe8.orm.dao.ContractDao;
import de.hse.gruppe8.orm.dao.ContractToUserDao;
import de.hse.gruppe8.orm.model.ContractEntity;
import de.hse.gruppe8.util.mapper.ContractMapper;
import de.hse.gruppe8.util.mapper.UserMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ContractService {

    @Inject
    ContractDao contractDao;

    @Inject
    ContractToUserDao contractToUserDao;

    @Inject
    ContractMapper contractMapper;

    @Inject
    UserMapper userMapper;

    public List<Contract> getContracts(User currentUser) {
        List<Contract> contracts = new ArrayList<Contract>();
        if (currentUser.getIsAdmin()) {
            List<ContractEntity> contractEntities = contractDao.getContracts();
            for (ContractEntity contractEntity : contractEntities) {
                contracts.add(contractMapper.toContract(contractEntity));
            }
        } else {
            List<ContractEntity> contractEntities = contractToUserDao.getContractsForUser(userMapper.toUserEntity(currentUser));
            for (ContractEntity contractEntity : contractEntities) {
                contracts.add(contractMapper.toContract(contractEntity));
            }
        }
        return contracts;
    }

}

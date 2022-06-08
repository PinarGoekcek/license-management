package de.hse.gruppe8.jaxrs.services;

import de.hse.gruppe8.jaxrs.model.Contract;
import de.hse.gruppe8.jaxrs.model.ContractToUser;
import de.hse.gruppe8.jaxrs.model.User;
import de.hse.gruppe8.orm.dao.ContractToUserDao;
import de.hse.gruppe8.orm.model.ContractToUserEntity;
import de.hse.gruppe8.orm.model.UserEntity;
import de.hse.gruppe8.util.mapper.ContractMapper;
import de.hse.gruppe8.util.mapper.ContractToUserMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ContractToUserService {

    @Inject
    ContractToUserDao contractToUserDao;

    @Inject
    ContractMapper contractMapper;

    @Inject
    ContractToUserMapper contractToUserMapper;
    

    public ContractToUser createContractToUser(User currentUser, Contract contract, ContractToUser contractToUser) {
        if (currentUser.getIsAdmin()) {
            List<UserEntity> usersInContract = contractToUserDao.getUsersForContract(contractMapper.toContractEntity(contract));
            if (usersInContract.size() < 2) {
                ContractToUserEntity contractToUserEntity = contractToUserDao.save(contractToUserMapper.toContractToUserEntity(contractToUser));
                return contractToUserMapper.toContractToUser(contractToUserEntity);
            }
        }
        return null;
    }

    public boolean deleteContractToUser(User currentUser, Long id) {
        if (currentUser.getIsAdmin()) {
            contractToUserDao.delete(contractToUserDao.getContractToUser(id));
            return true;
        }
        return false;
    }

    public ContractToUser updateContractToUser(User currentUser, ContractToUser contractToUser) {
        if (currentUser.getIsAdmin()) {
            ContractToUserEntity contractToUserEntity = contractToUserDao.getContractToUser(contractToUser.getId());
            contractToUserEntity = contractToUserMapper.mapContractToUserEntityWithContractToUser(contractToUserEntity, contractToUser);
            contractToUserEntity = contractToUserDao.save(contractToUserEntity);
            return contractToUserMapper.toContractToUser(contractToUserEntity);
        } else {
            return null;
        }
    }
}

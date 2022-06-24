package de.hse.gruppe8.jaxrs.services;


import de.hse.gruppe8.jaxrs.model.Contract;
import de.hse.gruppe8.jaxrs.model.User;
import de.hse.gruppe8.orm.dao.CompanyDao;
import de.hse.gruppe8.orm.dao.ContractDao;
import de.hse.gruppe8.orm.dao.UserDao;
import de.hse.gruppe8.orm.model.CompanyEntity;
import de.hse.gruppe8.orm.model.ContractEntity;
import de.hse.gruppe8.orm.model.UserEntity;
import de.hse.gruppe8.util.mapper.CompanyMapper;
import de.hse.gruppe8.util.mapper.UserMapper;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ContractServiceTest {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Inject
    ContractService contractService;

    @Inject
    UserDao userDao;

    @Inject
    ContractDao contractDao;

    @Inject
    CompanyDao companyDao;

    @Inject
    CompanyMapper companyMapper;

    @Inject
    UserMapper userMapper;

    @BeforeEach
    @AfterEach
    void InitDatabase() {
        contractDao.removeAll();
        userDao.removeAll();
        companyDao.removeAll();
    }

    // checkGetContractsForUser -> find in class ContractToUserDaoTest

    @Test
    void checkGetContractsAsAdmin() throws ParseException {
        //Given
        CompanyEntity companyEntity1 = companyDao.save(new CompanyEntity(null, "name 1", "department 1", "street 1", "73732", "esslingen", "Germany", true));
        CompanyEntity companyEntity2 = companyDao.save(new CompanyEntity(null, "name 2", "department 2", "street 2", "73732", "esslingen", "Germany", true));

        UserEntity userEntity_1 = userDao.save(new UserEntity(null, "username_01", "password", true, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_2 = userDao.save(new UserEntity(null, "username_02", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_3 = userDao.save(new UserEntity(null, "username_03", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));


        ContractEntity contractEntity_c1_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "01", "123456", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, null));
        ContractEntity contractEntity_c1_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, userEntity_2));
        ContractEntity contractEntity_c2_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, userEntity_2, null));
        ContractEntity contractEntity_c2_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, null, null));

        User user = userMapper.toUser(userEntity_1);

        //When
        List<Contract> contracts = contractService.getContracts(user);

        //Then
        assertEquals(4, contracts.size());
    }

    @Test
    void checkGetContractsAsUserFromCompany_1() throws ParseException {
        //Given
        CompanyEntity companyEntity1 = companyDao.save(new CompanyEntity(null, "name 1", "department 1", "street 1", "73732", "esslingen", "Germany", true));
        CompanyEntity companyEntity2 = companyDao.save(new CompanyEntity(null, "name 2", "department 2", "street 2", "73732", "esslingen", "Germany", true));

        UserEntity userEntity_1 = userDao.save(new UserEntity(null, "username_01", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_2 = userDao.save(new UserEntity(null, "username_02", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_3 = userDao.save(new UserEntity(null, "username_03", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));


        ContractEntity contractEntity_c1_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "01", "123456", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, null));
        ContractEntity contractEntity_c1_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, userEntity_2));
        ContractEntity contractEntity_c2_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, userEntity_2, null));
        ContractEntity contractEntity_c2_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, null, null));

        User user = userMapper.toUser(userEntity_1);

        //When
        List<Contract> contracts = contractService.getContracts(user);

        //Then
        assertEquals(2, contracts.size());

    }

    @Test
    void checkGetContractsAsUserFromCompany_2() throws ParseException {
        //Given
        CompanyEntity companyEntity1 = companyDao.save(new CompanyEntity(null, "name 1", "department 1", "street 1", "73732", "esslingen", "Germany", true));
        CompanyEntity companyEntity2 = companyDao.save(new CompanyEntity(null, "name 2", "department 2", "street 2", "73732", "esslingen", "Germany", true));

        UserEntity userEntity_1 = userDao.save(new UserEntity(null, "username_01", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_2 = userDao.save(new UserEntity(null, "username_02", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_3 = userDao.save(new UserEntity(null, "username_03", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));


        ContractEntity contractEntity_c1_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "01", "123456", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, null));
        ContractEntity contractEntity_c1_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, userEntity_2));
        ContractEntity contractEntity_c2_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, userEntity_2, null));
        ContractEntity contractEntity_c2_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, null, null));

        User user = userMapper.toUser(userEntity_2);

        //When
        List<Contract> contracts = contractService.getContracts(user);

        //Then
        assertEquals(2, contracts.size());
    }

    @Test
    void checkGetContractsAsUserFromCompany_3() throws ParseException {
        //Given
        CompanyEntity companyEntity1 = companyDao.save(new CompanyEntity(null, "name 1", "department 1", "street 1", "73732", "esslingen", "Germany", true));
        CompanyEntity companyEntity2 = companyDao.save(new CompanyEntity(null, "name 2", "department 2", "street 2", "73732", "esslingen", "Germany", true));

        UserEntity userEntity_1 = userDao.save(new UserEntity(null, "username_01", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_2 = userDao.save(new UserEntity(null, "username_02", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_3 = userDao.save(new UserEntity(null, "username_03", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));


        ContractEntity contractEntity_c1_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "01", "123456", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, null));
        ContractEntity contractEntity_c1_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, userEntity_2));
        ContractEntity contractEntity_c2_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, userEntity_2, null));
        ContractEntity contractEntity_c2_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, null, null));
        ContractEntity contractEntity_c2_3 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, userEntity_3, null));

        User user = userMapper.toUser(userEntity_3);

        //When
        List<Contract> contracts = contractService.getContracts(user);

        //Then
        assertEquals(1, contracts.size());
    }

    @Test
    void checkGetContractsAsUserFromCompany_4() throws ParseException {
        //Given
        CompanyEntity companyEntity1 = companyDao.save(new CompanyEntity(null, "name 1", "department 1", "street 1", "73732", "esslingen", "Germany", true));
        CompanyEntity companyEntity2 = companyDao.save(new CompanyEntity(null, "name 2", "department 2", "street 2", "73732", "esslingen", "Germany", true));

        UserEntity userEntity_1 = userDao.save(new UserEntity(null, "username_01", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_2 = userDao.save(new UserEntity(null, "username_02", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_3 = userDao.save(new UserEntity(null, "username_03", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));


        ContractEntity contractEntity_c1_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "01", "123456", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, null));
        ContractEntity contractEntity_c1_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, userEntity_2));
        ContractEntity contractEntity_c2_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, userEntity_2, null));
        ContractEntity contractEntity_c2_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, null, null));

        User user = userMapper.toUser(userEntity_3);

        //When
        List<Contract> contracts = contractService.getContracts(user);

        //Then
        assertEquals(0, contracts.size());
    }

    @Test
    void checkGetContractAsUserInCompany() throws ParseException {
        //Given
        CompanyEntity companyEntity1 = companyDao.save(new CompanyEntity(null, "name 1", "department 1", "street 1", "73732", "esslingen", "Germany", true));
        CompanyEntity companyEntity2 = companyDao.save(new CompanyEntity(null, "name 2", "department 2", "street 2", "73732", "esslingen", "Germany", true));

        UserEntity userEntity_1 = userDao.save(new UserEntity(null, "username_01", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_2 = userDao.save(new UserEntity(null, "username_02", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_3 = userDao.save(new UserEntity(null, "username_03", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));


        ContractEntity contractEntity_c1_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "01", "123456", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, null));
        ContractEntity contractEntity_c1_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, userEntity_2));
        ContractEntity contractEntity_c2_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, userEntity_2, null));
        ContractEntity contractEntity_c2_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, null, null));

        User user = userMapper.toUser(userEntity_1);

        //When
        Contract contracts = contractService.getContract(user, contractEntity_c1_1.getId());

        //Then
        assertEquals(contractEntity_c1_1.getId(), contracts.getId());
    }

    @Test
    void checkGetContractAsUserNotInCompany() throws ParseException {
        //Given
        CompanyEntity companyEntity1 = companyDao.save(new CompanyEntity(null, "name 1", "department 1", "street 1", "73732", "esslingen", "Germany", true));
        CompanyEntity companyEntity2 = companyDao.save(new CompanyEntity(null, "name 2", "department 2", "street 2", "73732", "esslingen", "Germany", true));

        UserEntity userEntity_1 = userDao.save(new UserEntity(null, "username_01", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_2 = userDao.save(new UserEntity(null, "username_02", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_3 = userDao.save(new UserEntity(null, "username_03", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));


        ContractEntity contractEntity_c1_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "01", "123456", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, null));
        ContractEntity contractEntity_c1_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, userEntity_2));
        ContractEntity contractEntity_c2_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, userEntity_2, null));
        ContractEntity contractEntity_c2_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, null, null));

        User user = userMapper.toUser(userEntity_3);

        //When
        Contract contracts = contractService.getContract(user, contractEntity_c2_2.getId());

        //Then
        assertEquals(null, contracts);
    }

    @Test
    void checkGetContractAsAdmin() throws ParseException {
        //Given
        CompanyEntity companyEntity1 = companyDao.save(new CompanyEntity(null, "name 1", "department 1", "street 1", "73732", "esslingen", "Germany", true));
        CompanyEntity companyEntity2 = companyDao.save(new CompanyEntity(null, "name 2", "department 2", "street 2", "73732", "esslingen", "Germany", true));

        UserEntity userEntity_1 = userDao.save(new UserEntity(null, "username_01", "password", true, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_2 = userDao.save(new UserEntity(null, "username_02", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));
        UserEntity userEntity_3 = userDao.save(new UserEntity(null, "username_03", "password", false, "Hans", "Peter", "test@dd.de", "+49 123", "+49 123", true, companyEntity1));


        ContractEntity contractEntity_c1_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "01", "123456", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, null));
        ContractEntity contractEntity_c1_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity1, userEntity_1, userEntity_2));
        ContractEntity contractEntity_c2_1 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, userEntity_2, null));
        ContractEntity contractEntity_c2_2 = contractDao.save(new ContractEntity(null, formatter.parse("2021-10-20"), formatter.parse("2021-12-30"), "02", "654321", 1, 2, 3, null, null, null, true, companyEntity2, null, null));

        User user = userMapper.toUser(userEntity_3);

        //When
        Contract contracts = contractService.getContract(user, contractEntity_c2_2.getId());

        //Then
        assertEquals(null, contracts);
    }
}
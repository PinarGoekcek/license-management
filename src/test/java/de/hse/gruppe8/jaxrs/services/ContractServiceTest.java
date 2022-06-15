package de.hse.gruppe8.jaxrs.services;


import de.hse.gruppe8.jaxrs.model.Company;
import de.hse.gruppe8.jaxrs.model.Contract;
import de.hse.gruppe8.jaxrs.model.User;
import de.hse.gruppe8.orm.dao.CompanyDao;
import de.hse.gruppe8.orm.dao.ContractDao;
import de.hse.gruppe8.orm.dao.UserDao;
import de.hse.gruppe8.orm.model.CompanyEntity;
import de.hse.gruppe8.orm.model.ContractEntity;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class ContractServiceTest {


    @Inject
    ContractService contractService;

    @Inject
    UserDao userDao;

    @Inject
    ContractDao contractDao;

    @Inject
    CompanyDao companyDao;

    @BeforeEach
    @AfterEach
    void InitDatabase() {
        contractDao.removeAll();
        companyDao.removeAll();
        userDao.removeAll();
    }

    // checkGetContractsForUser -> find in class ContractToUserDaoTest

    @Test
    void checkGetContractsAsAdmin() throws ParseException {
        //Given
        CompanyEntity companyEntity1 = new CompanyEntity(null, "name 1", "department 1", "street 1", "73732", "esslingen", "Germany", true);
        companyEntity1 = companyDao.save(companyEntity1);
        CompanyEntity companyEntity2 = new CompanyEntity(null, "name 2", "department 2", "street 2", "73732", "esslingen", "Germany", true);
        companyEntity2 = companyDao.save(companyEntity2);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateBegin = formatter.parse("2021-10-20");
        Date dateEnd = formatter.parse("2021-12-30");

        ContractEntity contractEntity1 = new ContractEntity(null, dateBegin, dateEnd, "01", "123456", 1,2,3, null, null, null,true, companyEntity1);
        contractDao.save(contractEntity1);
        ContractEntity contractEntity2 = new ContractEntity(null, dateBegin, dateEnd, "02", "654321", 1,2,3, null, null, null,true, companyEntity2);
        contractDao.save(contractEntity2);

        Company company = new Company(2L, "name 2", "department 2", "street 2", "73732", "esslingen", "Germany");
        User user = new User(1L, "username", true, "firstName", "lastName", "lala@lala.de", null, null, "", company);

        //When
        List<Contract> contracts = contractService.getContracts(user);

        //Then
        assertEquals(2, contracts.size());
    }

}
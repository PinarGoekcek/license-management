package de.hse.gruppe8.orm;

import de.hse.gruppe8.orm.dao.CompanyDao;
import de.hse.gruppe8.orm.dao.ContractDao;
import de.hse.gruppe8.orm.dao.ContractToUserDao;
import de.hse.gruppe8.orm.dao.UserDao;
import de.hse.gruppe8.orm.model.CompanyEntity;
import de.hse.gruppe8.orm.model.ContractEntity;
import de.hse.gruppe8.orm.model.ContractToUserEntity;
import de.hse.gruppe8.orm.model.UserEntity;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ContractToUserDaoTest {

    @Inject
    ContractDao contractDao;
    @Inject
    CompanyDao companyDao;

    @Inject
    UserDao userDao;

    @Inject
    ContractToUserDao contractToUserDao;

    @BeforeEach
    void clearAllFromDatabase() {
        contractDao.removeAll();
        companyDao.removeAll();
        userDao.removeAll();
        contractToUserDao.removeAll();
    }


    @Test
    void checkGetContractsForUser() throws ParseException {
        //Given
        CompanyEntity companyEntity1 = new CompanyEntity(null, "Test Corp.", "Development", "Peace street 9", "73728", "Esslingen", "Germany", true);
        companyDao.save(companyEntity1);
        CompanyEntity companyEntity2 = new CompanyEntity(null, "Evil Corp.", "Development", "Another street 9", "75431", "Chicago", "US", true);
        companyDao.save(companyEntity2);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String begin = "2021-10-20";
        Date dateBegin = formatter.parse(begin);
        String end = "2021-12-30";
        Date dateEnd = formatter.parse(end);

        ContractEntity contractEntity1 = new ContractEntity(null, dateBegin, dateEnd, "01", "555555", 1,2,3, null, null, null, true, companyEntity1);
        contractDao.save(contractEntity1);
        ContractEntity contractEntity2 = new ContractEntity(null, dateBegin, dateEnd, "01", "123456", 1,2,3, null, null, null, true, companyEntity2);
        contractDao.save(contractEntity2);

        UserEntity userEntity = new UserEntity(null, "username", "passord", false, "firstname", "lastName", "email@admin.de", null, null, true, companyEntity1);
        userDao.save(userEntity);

        ContractToUserEntity contractToUserEntity = new ContractToUserEntity(null, contractEntity1, userEntity);
        contractToUserDao.save(contractToUserEntity);

        //When
        List<ContractEntity> contractsList = contractToUserDao.getContractsForUser(userEntity);

        //Then
        assertEquals(1, contractsList.size());
        assertEquals("555555", contractEntity1.getLicenseKey());
    }

}

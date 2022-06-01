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
        CompanyEntity companyEntity = new CompanyEntity(null, "Test Corp.", "Development", "Peace street 9", "73728", "Esslingen", "Germany", true);
        companyDao.save(companyEntity);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String begin = "2021-10-20";
        Date dateBegin = formatter.parse(begin);
        String end = "2021-12-30";
        Date dateEnd = formatter.parse(end);

        ContractEntity contractEntity = new ContractEntity(null, dateBegin, dateEnd, "01", "123456", true, companyEntity);
        contractDao.save(contractEntity);

        UserEntity userEntity = new UserEntity(null, "username", "passord", false, "firstname", "lastName", "email@admin.de", null, null, true, null);
        userDao.save(userEntity);

        ContractToUserEntity contractToUserEntity = new ContractToUserEntity(null, contractEntity, userEntity);

        //When
        contractToUserDao.save(contractToUserEntity);

        //Then
        List<ContractEntity> contractsList = contractToUserDao.getContractsForUser(userEntity);
        assertEquals(1, contractsList.size());
    }

}

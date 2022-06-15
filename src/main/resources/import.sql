-- Some initial data

-- Companies
INSERT INTO `Companies` (`id`, `active`, `city`, `country`, `department`, `name`, `street`, `zip_code`)
VALUES ('100', true, 'Esslingen 1', 'Germany 1', 'yeew 1', 'name 1', 'zuhause 1', 'hhhhh 1'),
       ('101', true, 'Esslingen 2', 'Germany 2', 'yeew 2', 'name 2', 'zuhause 2', 'hhhhh 2'),
       ('102', true, 'Esslingen 3', 'Germany 3', 'yeew 3', 'name 3', 'zuhause 3', 'hhhhh 3'),
       ('103', true, 'Esslingen 4', 'Germany 4', 'yeew 4', 'name 4', 'zuhause 4', 'hhhhh 4')
;

-- Users
INSERT INTO Users (id, username, password, is_admin, first_name, last_name, email, phone, mobile, active, company_id)
VALUES ('100', 'admin', 'admin', true, 'Admin', 'Administrator', 'ich@admin.de', '', '', true, 100),
       ('101', 'user', 'user', false, 'Max', 'Mustermann', 'passt@muster.de', '0711-12345', '', true, 102)
;

-- Contracts
INSERT INTO Contracts (id, active, date_start, date_stop, version, license_key, feature_1, feature_2, feature_3, ip_1,
                       ip_2, ip_3, company_id)
VALUES ('100', true, DATE_FORMAT(CURRENT_DATE, '%d.%m.%Y'), DATE_FORMAT(CURRENT_DATE, '%d.%m.%Y'), '01', '12345', '01',
        '02', '03', '192.172.1.0', '', '', 100),
       ('101', true, DATE_FORMAT(CURRENT_DATE, '%d.%m.%Y'), DATE_FORMAT(CURRENT_DATE, '%d.%m.%Y'), '02', '98765', '01',
        '02', '03', '192.172.1.0', '', '', 101),
       ('102', true, DATE_FORMAT(CURRENT_DATE, '%d.%m.%Y'), DATE_FORMAT(CURRENT_DATE, '%d.%m.%Y'), '03', '98765', '01',
        '02', '03', '192.172.1.0', '', '', 101),
       ('103', true, DATE_FORMAT(CURRENT_DATE, '%d.%m.%Y'), DATE_FORMAT(CURRENT_DATE, '%d.%m.%Y'), '04', '98765', '01',
        '02', '03', '192.172.1.0', '', '', 101),
       ('104', true, DATE_FORMAT(CURRENT_DATE, '%d.%m.%Y'), DATE_FORMAT(CURRENT_DATE, '%d.%m.%Y'), '05', '98765', '01',
        '02', '03', '192.172.1.0', '', '', 101),
       ('105', true, DATE_FORMAT(CURRENT_DATE, '%d.%m.%Y'), DATE_FORMAT(CURRENT_DATE, '%d.%m.%Y'), '06', '98765', '01',
        '02', '03', '192.172.1.0', '', '', 101)
;

-- ContractsTOUser
INSERT INTO ContractsToUsers (id, contract_id, user_id)
VALUES ('100', 100, 100),
       ('101', 101, 100),
       ('102', 102, 100),
       ('103', 103, 100),
       ('104', 104, 100),
       ('105', 104, 101),
       ('106', 105, 101)
;
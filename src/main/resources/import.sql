-- Some initial data

-- Companies
INSERT INTO `Companies` (`id`, `active`, `city`, `country`, `department`, `name`, `street`, `zip_code`)
VALUES ('100', true, 'Esslingen 1', 'Germany 1', 'yeew 1', 'name 1', 'zuhause 1', 'hhhhh 1'),
       ('101', true, 'Esslingen 2', 'Germany 2', 'yeew 2', 'name 2', 'zuhause 2', 'hhhhh 2'),
       ('102', true, 'Esslingen 3', 'Germany 3', 'yeew 3', 'name 3', 'zuhause 3', 'hhhhh 3')
;

-- Users
INSERT INTO Users (id, username, password, is_admin, first_name, last_name, email, phone, mobile, active, company_id)
VALUES ('100', 'admin', 'admin', true, 'Admin', 'Administrator', 'ich@admin.de', '', '', true, 100),
       ('101', 'user', 'user', false, 'Max', 'Mustermann', 'passt', '', '', true, 102)
;

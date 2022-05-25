-- Some initial data

-- Companies
INSERT INTO `Companies` (`id`, `active`, `city`, `country`, `department`, `name`, `street`, `zip_code`)
VALUES ('1', true, 'Esslingen', 'Germany', 'yeew', 'name', 'zuhause', 'hhhhh');

-- Users
INSERT INTO Users (id, username, password, is_admin, first_name, last_name, email, phone, mobile, active, company_id)
VALUES ('1', 'admin', 'admin', true, 'Admin', 'Administrator', 'ich@admin.de', '', '', true, 1);

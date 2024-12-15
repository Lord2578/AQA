INSERT INTO mantis_user_table (username, realname, email, password, enabled, protected, access_level, cookie_string)
VALUES ('john.doe', 'John Doe', 'qa@gmail.com', MD5('pass12'), 1, 0, 35, UUID());

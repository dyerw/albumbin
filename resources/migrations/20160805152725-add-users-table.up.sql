CREATE TABLE users
(id VARCHAR(100) PRIMARY KEY,
 username VARCHAR(30),
 email VARCHAR(30),
 admin BOOLEAN,
 last_login TIME,
 password VARCHAR(300));

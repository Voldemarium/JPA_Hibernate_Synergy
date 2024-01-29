CREATE DATABASE postgreDB;

CREATE ROLE vladimir LOGIN PASSWORD postgres;
ALTER ROLE vladimir SUPERUSER;

CREATE TABLE IF NOT EXISTS users
(
id int GENERATED ALWAYS AS IDENTITY,
name VARCHAR(20) NOT NULL,
PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS contacts
(
id int GENERATED ALWAYS AS IDENTITY,
user_Id int,
contactName VARCHAR(255) NOT NULL,
phone VARCHAR(15),
email VARCHAR(100),
PRIMARY KEY(id),
CONSTRAINT fk_users_contacts FOREIGN KEY(user_Id) REFERENCES users(id)
);


INSERT INTO users(id, name) VALUES
('Petya'),
('Vasya'),
('Katya');

INSERT INTO contacts(user_Id, contactName, phone, email) VALUES
(1, 'first', '1234567', 'email@lll.ru'),
(1, 'second', '456756756', 'sefefrfrt@lll.ru'),
(3, 'main', '1234565', 'herhhwwh@lll.ru');

SELECT * FROM users u LEFT JOIN contacts c ON c.user_Id = u.id;
SELECT * FROM users u RIGHT JOIN contacts c ON c.user_Id = u.id;

SELECT * FROM users u INNER JOIN contacts c ON c.user_Id = u.id;
SELECT * FROM users u FULL OUTER JOIN contacts c ON c.user_Id = u.id;

SELECT * FROM users u  CROSS JOIN;

TRUNCATE contacts;

select u.id as "user_Id", u."name", c.id as "contact_Id", c."contactName", c.phone, c.email
FROM users u LEFT JOIN contacts c ON c.user_Id = u.id ORDER BY "user_Id";

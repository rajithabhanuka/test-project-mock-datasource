CREATE SCHEMA IF NOT EXISTS test_db;

CREATE TABLE IF NOT EXISTS test_db.test_user (
    id LONG PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    country VARCHAR(50)
);

INSERT INTO test_db.test_user
    (name,country)
VALUES
    ('Johnny', 'USA'),
    ('Natasha', 'Sri Lanka');
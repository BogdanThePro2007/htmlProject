CREATE DATABASE userdb;

CREATE USER user_service WITH ENCRYPTED PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE userdb TO user_service;

\c userdb

CREATE TABLE IF NOT EXISTS users (
                                     id BIGSERIAL PRIMARY KEY,
                                     email VARCHAR(255) NOT NULL UNIQUE,
                                     password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS pin (
                                   id BIGSERIAL PRIMARY KEY,
                                   pinUrl VARCHAR(255) NOT NULL UNIQUE,
                                   name VARCHAR(255) NOT NULL,
                                   axisX VARCHAR(255) NOT NULL,
                                   axisY VARCHAR(255) NOT NULL,
                                   type VARCHAR(255) NOT NULL,
                                   description VARCHAR(1023) NOT NULL,
                                   imageUrl VARCHAR(255) NOT NULL,
                                   isMarked BOOLEAN,
                                   userId BIGSERIAL
);

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO user_service;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO user_service;

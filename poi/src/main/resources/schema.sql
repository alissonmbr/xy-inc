CREATE SCHEMA IF NOT EXISTS poischema;

CREATE TABLE IF NOT EXISTS poischema.poi(id SERIAL, name VARCHAR(100) UNIQUE, x INTEGER, y INTEGER, PRIMARY KEY(id));
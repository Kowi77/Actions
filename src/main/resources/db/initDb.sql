/*CREATE USER ddd WITH SUPERUSER ;*/
/*DROP DATABASE IF EXISTS action;*/
DROP TABLE IF EXISTS gifts;
DROP TABLE IF EXISTS actions;
DROP SEQUENCE IF EXISTS global_seq;

/*CREATE DATABASE action;*/
CREATE SEQUENCE global_seq START 100;

CREATE TABLE gifts
(
  giftId       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name         TEXT NOT NULL,
  quantity     INTEGER NOT NULL
);

CREATE TABLE actions (
  actionId    INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name         TEXT NOT NULL,
  amount       INTEGER
);
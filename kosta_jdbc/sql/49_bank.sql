USE kosta_practice;
DROP TABLE IF EXISTS bank;
CREATE TABLE bank (
  account VARCHAR(10) PRIMARY KEY,
  balance INT
);
INSERT INTO bank VALUES ('A01', 1000), ('A02', 500), ('A03', 0);

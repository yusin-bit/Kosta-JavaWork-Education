USE kosta_practice;
DROP TABLE IF EXISTS member;
CREATE TABLE member (
  id  VARCHAR(20) PRIMARY KEY,
  pwd VARCHAR(20) NOT NULL
);
INSERT INTO member VALUES ('user1', 'pass1'), ('user2', 'pass2');

DROP TABLE IF EXISTS emp_sample;
CREATE TABLE emp_sample (
  empno INT PRIMARY KEY,
  ename VARCHAR(20),
  sal   INT
);
INSERT INTO emp_sample VALUES (1, 'KIM', 1500), (2, 'LEE', 2500), (3, 'PARK', 3500);

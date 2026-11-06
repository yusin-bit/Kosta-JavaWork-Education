USE kosta_practice;
-- 연습용 테이블만 지웁니다.
DROP TABLE IF EXISTS student;
CREATE TABLE student (
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  age  INT,
  addr VARCHAR(50)
);
INSERT INTO student(name, age, addr) VALUES ('홍길동', 20, '서울'), ('이순신', 25, '부산'), ('강감찬', 30, '대구');

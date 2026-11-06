USE kosta_practice;
DROP TABLE IF EXISTS student_batch;
CREATE TABLE student_batch (
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  major VARCHAR(30)
);

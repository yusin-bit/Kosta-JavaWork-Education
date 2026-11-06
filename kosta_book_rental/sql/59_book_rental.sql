USE kosta_practice;
-- 문제 59 용 기본 테이블입니다. 대여 가능 도서 View 는 문제에서 직접 만들어 보세요.
DROP TABLE IF EXISTS rental;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS member;
CREATE TABLE member (
  id   VARCHAR(20) PRIMARY KEY,
  name VARCHAR(20) NOT NULL
);
CREATE TABLE book (
  book_no INT PRIMARY KEY AUTO_INCREMENT,
  title   VARCHAR(50) NOT NULL,
  owner_id VARCHAR(20) NOT NULL,
  status  TINYINT(1) NOT NULL DEFAULT 1,
  FOREIGN KEY (owner_id) REFERENCES member(id)
);
CREATE TABLE rental (
  rental_no   INT PRIMARY KEY AUTO_INCREMENT,
  borrower_id VARCHAR(20) NOT NULL,
  book_no     INT NOT NULL,
  status      INT NOT NULL DEFAULT 100,
  FOREIGN KEY (borrower_id) REFERENCES member(id),
  FOREIGN KEY (book_no) REFERENCES book(book_no)
);

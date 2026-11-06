USE kosta_practice;
DROP TABLE IF EXISTS reply;
DROP TABLE IF EXISTS board;
CREATE TABLE board (
  board_no   INT PRIMARY KEY AUTO_INCREMENT,
  subject    VARCHAR(30) NOT NULL,
  writer     VARCHAR(20) NOT NULL,
  content    VARCHAR(50) NOT NULL,
  board_date DATETIME NOT NULL
);
CREATE TABLE reply (
  reply_no      INT PRIMARY KEY AUTO_INCREMENT,
  reply_content VARCHAR(100),
  board_no      INT,
  reply_regdate DATETIME,
  FOREIGN KEY (board_no) REFERENCES board(board_no)
);

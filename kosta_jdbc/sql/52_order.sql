USE kosta_practice;
DROP TABLE IF EXISTS order_line;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS goods;
CREATE TABLE goods (
  goods_id VARCHAR(10) PRIMARY KEY,
  name     VARCHAR(30) NOT NULL,
  price    INT NOT NULL,
  stock    INT NOT NULL
);
CREATE TABLE orders (
  order_id     INT PRIMARY KEY AUTO_INCREMENT,
  user_id      VARCHAR(30) NOT NULL,
  order_date   DATETIME NOT NULL,
  total_amount INT NOT NULL
);
CREATE TABLE order_line (
  line_id  INT PRIMARY KEY AUTO_INCREMENT,
  order_id INT NOT NULL,
  goods_id VARCHAR(10) NOT NULL,
  qty      INT NOT NULL,
  amount   INT NOT NULL,
  FOREIGN KEY (order_id) REFERENCES orders(order_id),
  FOREIGN KEY (goods_id) REFERENCES goods(goods_id)
);
INSERT INTO goods VALUES ('A01', '새우깡', 1500, 5), ('A02', '감자깡', 2000, 3), ('A03', '콘칩', 3000, 10);

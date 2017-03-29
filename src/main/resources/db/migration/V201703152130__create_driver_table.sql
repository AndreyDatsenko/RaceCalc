CREATE TABLE driver (
  id           INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name         VARCHAR(100),
  surname      VARCHAR(100),
  number       INT,
  car_category VARCHAR(100),
  car_mark     VARCHAR(100),
  order_number INT,
  result_time  BIGINT
);
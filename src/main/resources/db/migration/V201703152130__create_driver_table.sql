CREATE TABLE driver (
  id           INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name         VARCHAR(100)                   NULL,
  surname      VARCHAR(100)                   NULL,
  number       INT                            NULL,
  car_category VARCHAR(100)                   NULL,
  car_mark     VARCHAR(100)                   NULL
);
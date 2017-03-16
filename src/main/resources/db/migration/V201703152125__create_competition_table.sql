CREATE TABLE competition (
  id         INT PRIMARY KEY,
  name       VARCHAR(300) NOT NULL,
  date       DATE         NOT NULL,
  city       VARCHAR(100) NOT NULL,
  isActiv    BIT(1)       NOT NULL,
  chip_bort  TIMESTAMP    NOT NULL,
  chip_front TIMESTAMP    NOT NULL,
  failstart  TIMESTAMP    NOT NULL
);
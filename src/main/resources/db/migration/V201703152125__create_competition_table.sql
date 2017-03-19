CREATE TABLE competition (
  id          INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  name        VARCHAR(300)                   NOT NULL,
  date        DATE                           NOT NULL,
  city        VARCHAR(100)                   NOT NULL,
  is_active   BIT(1)                         NOT NULL,
  chip_board  LONG                      NOT NULL,
  chip_front  LONG                      NOT NULL,
  false_start LONG                      NOT NULL
);
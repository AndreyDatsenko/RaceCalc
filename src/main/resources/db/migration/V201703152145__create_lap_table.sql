CREATE TABLE lap (
  driver_id  INT PRIMARY KEY,
  number     INT(3),
  time       TIMESTAMP,
  chip_bort  BIT(1) NOT NULL,
  chip_front BIT(1) NOT NULL,
  failstart  BIT(1) NOT NULL,
  INDEX driver_id_inx (driver_id),
  FOREIGN KEY (driver_id)
  REFERENCES driver (id)
    ON DELETE CASCADE
)
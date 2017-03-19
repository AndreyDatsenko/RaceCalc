CREATE TABLE lap (
  driver_id   INT    NOT NULL,
  number      INT(3) NOT NULL,
  time        LONG,
  chip_board   BIT(1),
  chip_front  BIT(1),
  false_start BIT(1),
  INDEX driver_id_inx (driver_id),
  FOREIGN KEY (driver_id)
  REFERENCES driver (id)
    ON DELETE CASCADE
)
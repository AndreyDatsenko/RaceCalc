CREATE TABLE competition_driver (
  competition_id INT NOT NULL,
  INDEX competition_id_inx (competition_id),
  driver_id      INT PRIMARY KEY NOT NULL,
  FOREIGN KEY (competition_id)
  REFERENCES competition (id),
  INDEX driver_id_inx (driver_id),
  FOREIGN KEY (driver_id)
  REFERENCES driver (id)
);
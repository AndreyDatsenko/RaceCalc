CREATE TABLE competition_driver (
  competition_id INT PRIMARY KEY,
  driver_id      INT NOT NULL,
  INDEX competition_id_inx (competition_id),
  FOREIGN KEY (competition_id)
  REFERENCES competition (id)
    ON DELETE CASCADE,
  INDEX driver_id_inx (driver_id),
  FOREIGN KEY (driver_id)
  REFERENCES driver (id)
    ON DELETE CASCADE
);
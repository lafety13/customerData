CREATE TABLE IF NOT EXISTS phone_number (
  id INT(11) NOT NULL AUTO_INCREMENT,
  phone_number VARCHAR(50) NOT NULL UNIQUE,
  type VARCHAR(50) NOT NULL,
  comment VARCHAR(50),
  PRIMARY KEY (id)
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS customer (
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(50) NOT NULL,
  last_name VARCHAR(50) NOT NULL,
  patronymic_name VARCHAR(50) NOT NULL,
  phone_number_id int NOT NULL UNIQUE,
  PRIMARY KEY (id),
  INDEX (first_name, last_name),
  FOREIGN KEY (phone_number_id) REFERENCES phone_number (id)
)
  ENGINE = InnoDB;
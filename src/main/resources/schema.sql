CREATE TABLE IF NOT EXISTS `dbsecurity`.`users` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` TEXT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `dbsecurity`.`authorities` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `id_user` INTEGER NOT NULL,
  FOREIGN KEY (id_user) REFERENCES `dbsecurity`.`users` (id),
  PRIMARY KEY (`id`));

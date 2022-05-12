INSERT IGNORE INTO `dbsecurity`.`users` (`id`, `username`, `password`)
VALUES (1, 'admin', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG');

INSERT IGNORE INTO `dbsecurity`.`authorities` (`id`, `name`, `id_user`) VALUES (1, 'READ', 1);
INSERT IGNORE INTO `dbsecurity`.`authorities` (`id`, `name`, `id_user`) VALUES (2, 'WRITE', 1);

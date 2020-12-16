CREATE DATABASE `logol_ilham` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

-- logol_ilham.news definition
CREATE TABLE `news` (
  `id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO logol_ilham.news
(id, description, created_date, title)
VALUES('1', 'Pemrograman Java', '2020-12-16 01:07:08', 'Back End');
INSERT INTO logol_ilham.news
(id, description, created_date, title)
VALUES('2', 'angular', '2020-12-16 01:06:44', 'front end');
INSERT INTO logol_ilham.news
(id, description, created_date, title)
VALUES('3', 'ESB', '2020-12-16 00:00:00', 'Middleware');
INSERT INTO logol_ilham.news
(id, description, created_date, title)
VALUES('4', 'Master Angular & Spring boot', '2020-12-16 00:00:00', 'Angular & Spring boot');

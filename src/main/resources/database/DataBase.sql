CREATE DATABASE IF NOT EXISTS `Test`;  
USE `Test`;  
  
  
-- Dumping structure for table Test.User  
CREATE TABLE IF NOT EXISTS `User` (  
  `id` int(8) NOT NULL AUTO_INCREMENT,  
  `name` varchar(25) DEFAULT NULL,  
  `age` int(3) DEFAULT NULL,  
  `isAdmin` bit DEFAULT false,  
  `createdDate` timestamp,  
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=UTF8;  
  
-- Dumping data for table Test.User: ~3 rows (approximately)  
/*!40000 ALTER TABLE `User` DISABLE KEYS */;  
INSERT INTO `User` (`id`, `name`, `age`, `isAdmin`, `createdDate`) VALUES  
 (10, 'Иванов', 18, false, '2016-05-4 02:33:11'),
 (11, 'Петров', 25, false, '2016-05-4 02:33:11'),
 (12, 'Сидоров', 35, true, '2016-05-4 02:33:11');
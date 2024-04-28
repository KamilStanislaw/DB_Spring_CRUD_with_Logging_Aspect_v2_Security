CREATE DATABASE  IF NOT EXISTS `m1180_DBSpringDemo3`;
USE `m1180_DBSpringDemo3`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Leslie','Nielsen','leslie@test.com'),
	(2,'Emma','Watson','emma@test.com'),
	(3,'Robert','Kubica','robert@test.com'),
	(4,'Vitaly','Petrov','vitia@test.com'),
	(5,'Juan','Montoya','juan@test.com');


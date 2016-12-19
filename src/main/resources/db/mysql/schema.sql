DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `title` varchar(400) NOT NULL,
  `category` varchar(50) DEFAULT NULL,
  `year` char(4) DEFAULT NULL,
  `cast` varchar(4000) DEFAULT NULL,
  `director` varchar(4000) DEFAULT NULL,
  `story` varchar(4000) DEFAULT NULL,
  `price` double(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=5044 DEFAULT CHARSET=utf8;
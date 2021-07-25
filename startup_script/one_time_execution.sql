use poc_schema;

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_branch` varchar(255) DEFAULT NULL,
  `student_email` varchar(255) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO `student` (`student_id`, `student_branch`, `student_email`, `student_name`) VALUES
(2, 'MCA', 'dolly@gmail.com', 'Dolly'),
(3, 'B-Tech', 'sonoo@gmail.com', 'sonoo');

DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE IF NOT EXISTS `restaurant` (
  `restaurant_id` int(11) NOT NULL AUTO_INCREMENT,
  `restaurant_name` varchar(255) DEFAULT NULL,
  `restaurant_address` varchar(255) DEFAULT NULL,
  `restaurant_contact_no` varchar(255) DEFAULT NULL,
  `restaurant_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`restaurant_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

INSERT INTO `restaurant` (`restaurant_name`, `restaurant_address`, `restaurant_contact_no`, `restaurant_email`) VALUES
('Nacho\'s Tacos', '123 Elmo Drive', 'nachotaco@gmail.com', '995-9595'),
('Ratatouile', '456 Wall Street', 'ratatoiule@gmail.com', '8700123');
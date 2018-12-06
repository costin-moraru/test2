--
-- Database: `test2_db`
--

CREATE DATABASE IF NOT EXISTS `test2_db`;
USE `test2_db`;


-- ENTITIES

--
-- Struttura della tabella `user`
--

CREATE TABLE IF NOT EXISTS `user` (
	`mail` varchar(40) ,
	`name` varchar(40) ,
	`password` varchar(40)  NOT NULL,
	`roles` varchar(40) ,
	`surname` varchar(40) ,
	`username` varchar(40)  NOT NULL,
	
	-- RELAZIONI

	`_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT 

);


-- Security

INSERT INTO `test2_db`.`user` (`username`, `password`, `_id`) VALUES ('admin', '1a1dc91c907325c69271ddf0c944bc72', 1);

CREATE TABLE IF NOT EXISTS `roles` (
	`role` varchar(30) ,
	
	-- RELAZIONI

	`_user` int(11)  NOT NULL REFERENCES user(_id),
	`_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT 

);
INSERT INTO `test2_db`.`roles` (`role`, `_user`, `_id`) VALUES ('ADMIN', '1', 1);





--
-- Struttura della tabella `asset`
--

CREATE TABLE IF NOT EXISTS `asset` (
	`nane` varchar(40) ,
	
	-- RELAZIONI
	`fk_asset_user` int(11)  REFERENCES user(_id),

	`_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT 

);







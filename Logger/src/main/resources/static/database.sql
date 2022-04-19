-- -----------------------------------------------------
-- Schema logs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `logs` DEFAULT CHARACTER SET utf8 ;
USE `logs` ;

-- -----------------------------------------------------
-- Table `logs`.`application_logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `logs`.`application_logs` ;
CREATE TABLE IF NOT EXISTS `logs`.`application_logs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `log_id` TEXT NOT NULL,
  `machine_name` VARCHAR(200) NOT NULL,
  `logged` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `level` VARCHAR(5) NOT NULL,
  `message` TEXT NULL,
  `exception` TEXT NULL,
  `payload` TEXT NULL,
  `call_site` TEXT NULL,
  `action` TEXT NULL,
  `username` VARCHAR(150) NULL,
  `method_name` VARCHAR(200) NULL,
  `application_name` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `logs`.`profile_path`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `logs`.`profile_path` ;
CREATE TABLE IF NOT EXISTS `logs`.`profile_path` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200),
  `type` VARCHAR(50),
  `path` TEXT,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));

  /****** Object: Procedure getPathProfileFile  ******/
DELIMITER $$
DROP PROCEDURE IF EXISTS getPathProfileFile $$
CREATE PROCEDURE getPathProfileFile(IN fileName TEXT)
BEGIN
	SELECT A.path
    FROM logs.profile_path A
	WHERE A.name = fileName;
END $$
DELIMITER ;

INSERT INTO logs.profile_path (name, type, path)
VALUES ("WALBERTH.log",
        "PROFILE",
        "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Data\\WALBERTH.log");
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ozi` DEFAULT CHARACTER SET utf8 ;
USE `ozi` ;

-- -----------------------------------------------------
-- Table `ozi`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ozi`.`User` (
                                            `id` INT NOT NULL AUTO_INCREMENT,
                                            `phone` VARCHAR(20) NOT NULL,
                                            `email` VARCHAR(100) NOT NULL,
                                            `password` VARCHAR(64) NOT NULL,
                                            `name` VARCHAR(60) NOT NULL,
                                            `surname` VARCHAR(60) NOT NULL,
                                            `birthday` DATE NOT NULL,
                                            `sex` ENUM('m', 'f') NOT NULL,
                                            `country` VARCHAR(100) NULL,
                                            `city` VARCHAR(100) NULL,
                                            `about` VARCHAR(500) NULL,
                                            `photo` MEDIUMBLOB NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE,
                                            UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Friends`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ozi`.`Friends` (
                                               `id` INT NOT NULL AUTO_INCREMENT,
                                               `date` DATE NULL,
                                               `user_id` INT NOT NULL,
                                               `friend_id` INT NOT NULL,
                                               PRIMARY KEY (`id`),
                                               INDEX `fk_Friends_User_info1_idx` (`user_id` ASC) VISIBLE,
                                               INDEX `fk_Friends_User_info2_idx` (`friend_id` ASC) VISIBLE,
                                               CONSTRAINT `fk_Friends_User_info1`
                                                   FOREIGN KEY (`user_id`)
                                                       REFERENCES `ozi`.`User` (`id`)
                                                       ON DELETE CASCADE
                                                       ON UPDATE NO ACTION,
                                               CONSTRAINT `fk_Friends_User_info2`
                                                   FOREIGN KEY (`friend_id`)
                                                       REFERENCES `ozi`.`User` (`id`)
                                                       ON DELETE CASCADE
                                                       ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Friend_requests`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ozi`.`Friend_requests` (
                                                       `id` INT NOT NULL AUTO_INCREMENT,
                                                       `date` DATE NULL,
                                                       `receiver_id` INT NOT NULL,
                                                       `sender_id` INT NOT NULL,
                                                       PRIMARY KEY (`id`),
                                                       INDEX `fk_Friend_requests_User_info1_idx` (`receiver_id` ASC) VISIBLE,
                                                       INDEX `fk_Friend_requests_User_info2_idx` (`sender_id` ASC) VISIBLE,
                                                       CONSTRAINT `fk_Friend_requests_User_info1`
                                                           FOREIGN KEY (`receiver_id`)
                                                               REFERENCES `ozi`.`User` (`id`)
                                                               ON DELETE CASCADE
                                                               ON UPDATE NO ACTION,
                                                       CONSTRAINT `fk_Friend_requests_User_info2`
                                                           FOREIGN KEY (`sender_id`)
                                                               REFERENCES `ozi`.`User` (`id`)
                                                               ON DELETE CASCADE
                                                               ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ozi`.`Messages` (
                                                `id` INT NOT NULL AUTO_INCREMENT,
                                                `date` DATE NOT NULL,
                                                `message` LONGTEXT NOT NULL,
                                                `receiver_id` INT NOT NULL,
                                                `sender_id` INT NOT NULL,
                                                PRIMARY KEY (`id`),
                                                INDEX `fk_Messages_User_info1_idx` (`receiver_id` ASC) VISIBLE,
                                                INDEX `fk_Messages_User_info2_idx` (`sender_id` ASC) VISIBLE,
                                                CONSTRAINT `fk_Messages_User_info1`
                                                    FOREIGN KEY (`receiver_id`)
                                                        REFERENCES `ozi`.`User` (`id`)
                                                        ON DELETE CASCADE
                                                        ON UPDATE NO ACTION,
                                                CONSTRAINT `fk_Messages_User_info2`
                                                    FOREIGN KEY (`sender_id`)
                                                        REFERENCES `ozi`.`User` (`id`)
                                                        ON DELETE CASCADE
                                                        ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ozi`.`Posts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ozi`.`Posts` (
                                             `id` INT NOT NULL AUTO_INCREMENT,
                                             `user_id` INT NOT NULL,
                                             `text` LONGTEXT NULL,
                                             `date` DATE NOT NULL,
                                             PRIMARY KEY (`id`),
                                             INDEX `fk_Posts_User_info1_idx` (`user_id` ASC) VISIBLE,
                                             CONSTRAINT `fk_Posts_User_info1`
                                                 FOREIGN KEY (`user_id`)
                                                     REFERENCES `ozi`.`User` (`id`)
                                                     ON DELETE CASCADE
                                                     ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ozi`.`UserHasDialog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ozi`.`UserHasDialog` (
                                                     `User_id` INT NOT NULL,
                                                     `Has_dialog_id` INT NOT NULL,
                                                     INDEX `fk_UserHasDialog_User1_idx` (`User_id` ASC) VISIBLE,
                                                     INDEX `fk_UserHasDialog_User2_idx` (`Has_dialog_id` ASC) VISIBLE,
                                                     UNIQUE INDEX `User_id_UNIQUE` (`User_id` ASC) VISIBLE,
                                                     UNIQUE INDEX `Has_dialog_id_UNIQUE` (`Has_dialog_id` ASC) VISIBLE,
                                                     CONSTRAINT `fk_UserHasDialog_User1`
                                                         FOREIGN KEY (`User_id`)
                                                             REFERENCES `ozi`.`User` (`id`)
                                                             ON DELETE CASCADE
                                                             ON UPDATE NO ACTION,
                                                     CONSTRAINT `fk_UserHasDialog_User2`
                                                         FOREIGN KEY (`Has_dialog_id`)
                                                             REFERENCES `ozi`.`User` (`id`)
                                                             ON DELETE CASCADE
                                                             ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Spinach` DEFAULT CHARACTER SET latin1 ;
SHOW WARNINGS;
USE `Spinach` ;

-- -----------------------------------------------------
-- Table `Spinach`.`Person`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Spinach`.`Person` (
  `person_id` BINARY(16) NOT NULL ,
  `firstname` VARCHAR(32) NULL ,
  `lastname` VARCHAR(32) NULL ,
  `email` VARCHAR(128) NOT NULL ,
  `password` VARCHAR(32) NOT NULL ,
  `last_password_gen` TIMESTAMP NOT NULL ,
  `birhtday` DATE NULL ,
  `created_on` DATETIME NOT NULL ,
  `modified_on` DATETIME NOT NULL ,
  `active` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`person_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Spinach`.`Customer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Spinach`.`Customer` (
  `customer_id` BINARY(16) NOT NULL ,
  `newsletter` CHAR(1) NOT NULL DEFAULT 'N' ,
  `ip_registration_newsletter` VARCHAR(15) NULL ,
  `created_on` DATETIME NOT NULL ,
  `modified_on` DATETIME NOT NULL ,
  `special_offer_from_partner` CHAR(1) NOT NULL DEFAULT 'N' ,
  `person_id` BINARY(16) NOT NULL ,
  PRIMARY KEY (`customer_id`) ,
  INDEX `fk_Customer_Person_idx` (`person_id` ASC) ,
  CONSTRAINT `fk_Customer_Person`
    FOREIGN KEY (`person_id` )
    REFERENCES `Spinach`.`Person` (`person_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Spinach`.`Address`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Spinach`.`Address` (
  `address_id` BINARY(16) NOT NULL ,
  `street_address` VARCHAR(220) NULL ,
  `landmark` VARCHAR(45) NULL ,
  `pincode` VARCHAR(12) NULL ,
  `phone_number` VARCHAR(16) NULL ,
  `land_line` VARCHAR(16) NULL ,
  `customer_id` BINARY(16) NULL ,
  `city` VARCHAR(45) NULL ,
  `state` VARCHAR(45) NULL ,
  `country` VARCHAR(45) NULL ,
  PRIMARY KEY (`address_id`) ,
  INDEX `fk_Address_Customer1_idx` (`customer_id` ASC) ,
  CONSTRAINT `fk_Address_Customer1`
    FOREIGN KEY (`customer_id` )
    REFERENCES `Spinach`.`Customer` (`customer_id` )
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Spinach`.`Country`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Spinach`.`Country` (
  `country_id` BINARY(16) NOT NULL ,
  `country_name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`country_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Spinach`.`State`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Spinach`.`State` (
  `state_id` BINARY(16) NOT NULL ,
  `state_name` VARCHAR(45) NULL ,
  `country_id` BINARY(16) NOT NULL ,
  PRIMARY KEY (`state_id`) ,
  INDEX `fk_State_Country1_idx` (`country_id` ASC) ,
  CONSTRAINT `fk_State_Country1`
    FOREIGN KEY (`country_id` )
    REFERENCES `Spinach`.`Country` (`country_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Spinach`.`City`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Spinach`.`City` (
  `city_id` BINARY(16) NOT NULL ,
  `city_name` VARCHAR(45) NULL ,
  `state_id` BINARY(16) NOT NULL ,
  PRIMARY KEY (`city_id`) ,
  INDEX `fk_City_State1_idx` (`state_id` ASC) ,
  CONSTRAINT `fk_City_State1`
    FOREIGN KEY (`state_id` )
    REFERENCES `Spinach`.`State` (`state_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

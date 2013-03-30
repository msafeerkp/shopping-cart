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
  `personId` BINARY(16) NOT NULL ,
  `firstName` VARCHAR(30) NULL ,
  `lastName` VARCHAR(30) NULL ,
  `gender` CHAR(1) NULL ,
  `birthDate` DATE NULL ,
  PRIMARY KEY (`personId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Spinach`.`UserLogin`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Spinach`.`UserLogin` (
  `userLoginId` BINARY(16) NOT NULL ,
  `UserId` VARCHAR(128) NOT NULL ,
  `currentPassword` BINARY(16) NOT NULL ,
  `hasLoggedIn` CHAR(1) NOT NULL ,
  `enabled` CHAR(1) NOT NULL ,
  PRIMARY KEY (`userLoginId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Spinach`.`Party`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Spinach`.`Party` (
  `partyId` BINARY(16) NOT NULL ,
  `createdOn` DATETIME NOT NULL ,
  `ModifiedOn` DATETIME NULL ,
  `personId` BINARY(16) NOT NULL ,
  `userLoginId` BINARY(16) NOT NULL ,
  PRIMARY KEY (`partyId`) ,
  INDEX `fk_Party_Person1_idx` (`personId` ASC) ,
  INDEX `fk_Party_UserLogin1_idx` (`userLoginId` ASC) ,
  CONSTRAINT `fk_Party_Person1`
    FOREIGN KEY (`personId` )
    REFERENCES `Spinach`.`Person` (`personId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Party_UserLogin1`
    FOREIGN KEY (`userLoginId` )
    REFERENCES `Spinach`.`UserLogin` (`userLoginId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Spinach`.`RoleType`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Spinach`.`RoleType` (
  `roleTypeId` INT NOT NULL AUTO_INCREMENT ,
  `roleName` VARCHAR(45) NULL ,
  PRIMARY KEY (`roleTypeId`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Spinach`.`PartyRole`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Spinach`.`PartyRole` (
  `partyRoleId` BINARY(16) NOT NULL ,
  `partyId` BINARY(16) NOT NULL ,
  `roleTypeId` INT NOT NULL ,
  PRIMARY KEY (`partyRoleId`) ,
  INDEX `fk_PartyRole_Party_idx` (`partyId` ASC) ,
  INDEX `fk_PartyRole_RoleType1_idx` (`roleTypeId` ASC) ,
  CONSTRAINT `fk_PartyRole_Party`
    FOREIGN KEY (`partyId` )
    REFERENCES `Spinach`.`Party` (`partyId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PartyRole_RoleType1`
    FOREIGN KEY (`roleTypeId` )
    REFERENCES `Spinach`.`RoleType` (`roleTypeId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Spinach`.`PartyContactMech`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Spinach`.`PartyContactMech` (
  `partyContactMechId` BINARY(16) NOT NULL ,
  `partyId` BINARY(16) NOT NULL ,
  PRIMARY KEY (`partyContactMechId`) ,
  INDEX `fk_PartyContactMech_Party1_idx` (`partyId` ASC) ,
  CONSTRAINT `fk_PartyContactMech_Party1`
    FOREIGN KEY (`partyId` )
    REFERENCES `Spinach`.`Party` (`partyId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Spinach`.`EmailVerification`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Spinach`.`EmailVerification` (
  `emailVerificationId` BINARY(16) NOT NULL ,
  `emailAddress` VARCHAR(128) NOT NULL ,
  `verificationHash` BINARY(16) NOT NULL ,
  `expiryDate` DATE NOT NULL ,
  `createdOn` DATETIME NOT NULL ,
  `ModifiedOn` DATETIME NULL ,
  PRIMARY KEY (`emailVerificationId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

---- -----------------------------------------------------
---- Table `Spinach`.`Product`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`Product` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductReview`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductReview` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductCalculatedInfo`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductCalculatedInfo` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductGeo`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductGeo` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`VendorProduct`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`VendorProduct` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductFeatureAppl`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductFeatureAppl` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductFeatureApplType`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductFeatureApplType` (
--)
--ENGINE = InnoDB;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductFeature`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductFeature` (
--)
--ENGINE = InnoDB;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductFeatureType`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductFeatureType` (
--)
--ENGINE = InnoDB;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductFeatureCategory`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductFeatureCategory` (
--)
--ENGINE = InnoDB;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductFeatureCategoryAppl`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductFeatureCategoryAppl` (
--)
--ENGINE = InnoDB;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`GoodIdentification`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`GoodIdentification` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`GoodIdentificationType`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`GoodIdentificationType` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductCatalogCategoryType`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductCatalogCategoryType` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductCatalogCategory`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductCatalogCategory` (
--)
--ENGINE = InnoDB;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductCatalog`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductCatalog` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductCategoryRollup`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductCategoryRollup` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ProductCategory`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ProductCategory` (
--)
--ENGINE = InnoDB;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`Shipment`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`Shipment` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ShipmentType`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ShipmentType` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ShipmentContactMech`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ShipmentContactMech` (
--)
--ENGINE = InnoDB;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ShipmentStatus`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ShipmentStatus` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ShipmentItem`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ShipmentItem` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ShipmentItemBilling`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ShipmentItemBilling` (
--)
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;
--
--SHOW WARNINGS;
--
---- -----------------------------------------------------
---- Table `Spinach`.`ShipmentItemFeature`
---- -----------------------------------------------------
--CREATE  TABLE IF NOT EXISTS `Spinach`.`ShipmentItemFeature` (
--)
--ENGINE = InnoDB;
--
--SHOW WARNINGS;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Spinach`.`RoleType`
-- -----------------------------------------------------
START TRANSACTION;
USE `Spinach`;
INSERT INTO `Spinach`.`RoleType` (`roleTypeId`, `roleName`) VALUES (1, 'CUSTOMER');
INSERT INTO `Spinach`.`RoleType` (`roleTypeId`, `roleName`) VALUES (2, 'ADMIN');

COMMIT;

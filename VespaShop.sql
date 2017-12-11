-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema VespaShop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema VespaShop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `VespaShop` DEFAULT CHARACTER SET utf8 ;
USE `VespaShop` ;

-- -----------------------------------------------------
-- Table `VespaShop`.`Produktkategorie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VespaShop`.`Produktkategorie` (
  `idProduktkategorie` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`idProduktkategorie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VespaShop`.`Tags`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VespaShop`.`Tags` (
  `idTags` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`idTags`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VespaShop`.`Kategorie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VespaShop`.`Kategorie` (
  `idKategorie` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`idKategorie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VespaShop`.`Produkt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VespaShop`.`Produkt` (
  `idProdukte` INT NOT NULL,
  `TagsID` INT NOT NULL,
  `ProduktkategorieID` INT NOT NULL,
  `Kategorie_idKategorie1` INT NOT NULL,
  `Bezeichnung` VARCHAR(45) NULL,
  `Produktcol` VARCHAR(45) NULL,
  `Preis` FLOAT NULL,
  `ArtikelNr` VARCHAR(45) NULL,
  `Lagerbestand` VARCHAR(45) NULL,
  `BildPfad` VARCHAR(45) NULL,
  PRIMARY KEY (`idProdukte`),
  INDEX `fk_Produkt_Tags1_idx` (`TagsID` ASC),
  INDEX `fk_Produkt_Produktkategorie1_idx` (`ProduktkategorieID` ASC),
  INDEX `fk_Produkt_Kategorie1_idx` (`Kategorie_idKategorie1` ASC),
  CONSTRAINT `fk_Produkt_Tags1`
    FOREIGN KEY (`TagsID`)
    REFERENCES `VespaShop`.`Tags` (`idTags`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produkt_Produktkategorie1`
    FOREIGN KEY (`ProduktkategorieID`)
    REFERENCES `VespaShop`.`Produktkategorie` (`idProduktkategorie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Produkt_Kategorie1`
    FOREIGN KEY (`Kategorie_idKategorie1`)
    REFERENCES `VespaShop`.`Kategorie` (`idKategorie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VespaShop`.`Kunde`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VespaShop`.`Kunde` (
  `idKunde` INT NOT NULL,
  `Nachname` VARCHAR(45) NULL,
  `Vorname` VARCHAR(45) NULL,
  `Adresse` VARCHAR(45) NULL,
  `PLZ` VARCHAR(45) NULL,
  `Ort` VARCHAR(45) NULL,
  `Telefonnummer` VARCHAR(45) NULL,
  `Mail` VARCHAR(45) NULL,
  PRIMARY KEY (`idKunde`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VespaShop`.`Bestellung`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VespaShop`.`Bestellung` (
  `idBestellung` INT NOT NULL,
  `KundeID` INT NOT NULL,
  `Bestelldatum` VARCHAR(45) NULL,
  PRIMARY KEY (`idBestellung`),
  INDEX `fk_Bestellung_Kunde1_idx` (`KundeID` ASC),
  CONSTRAINT `fk_Bestellung_Kunde1`
    FOREIGN KEY (`KundeID`)
    REFERENCES `VespaShop`.`Kunde` (`idKunde`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `VespaShop`.`Warenkorb`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VespaShop`.`Warenkorb` (
  `Bestellung_idBestellung` INT NOT NULL,
  `Produkt_idProdukte` INT NOT NULL,
  PRIMARY KEY (`Bestellung_idBestellung`, `Produkt_idProdukte`),
  INDEX `fk_Bestellung_has_Produkt_Produkt1_idx` (`Produkt_idProdukte` ASC),
  INDEX `fk_Bestellung_has_Produkt_Bestellung1_idx` (`Bestellung_idBestellung` ASC),
  CONSTRAINT `fk_Bestellung_has_Produkt_Bestellung1`
    FOREIGN KEY (`Bestellung_idBestellung`)
    REFERENCES `VespaShop`.`Bestellung` (`idBestellung`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bestellung_has_Produkt_Produkt1`
    FOREIGN KEY (`Produkt_idProdukte`)
    REFERENCES `VespaShop`.`Produkt` (`idProdukte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


CREATE DATABASE  IF NOT EXISTS `VespaShop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `VespaShop`;
-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: VespaShop
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.17.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Bestellung`
--

DROP TABLE IF EXISTS `Bestellung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bestellung` (
  `idBestellung` int(11) NOT NULL AUTO_INCREMENT,
  `KundeID` int(11) NOT NULL,
  `Bestelldatum` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idBestellung`),
  KEY `fk_Bestellung_Kunde1_idx` (`KundeID`),
  CONSTRAINT `fk_Bestellung_Kunde1` FOREIGN KEY (`KundeID`) REFERENCES `Kunde` (`idKunde`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bestellung`
--

LOCK TABLES `Bestellung` WRITE;
/*!40000 ALTER TABLE `Bestellung` DISABLE KEYS */;
/*!40000 ALTER TABLE `Bestellung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Bild`
--

DROP TABLE IF EXISTS `Bild`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bild` (
  `idBild` int(11) NOT NULL AUTO_INCREMENT,
  `Pfad` varchar(155) DEFAULT NULL,
  `ProduktID` int(11) NOT NULL,
  PRIMARY KEY (`idBild`),
  KEY `fk_Bild_Produkt1_idx` (`ProduktID`),
  CONSTRAINT `fk_Bild_Produkt1` FOREIGN KEY (`ProduktID`) REFERENCES `Produkt` (`idProdukt`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bild`
--

LOCK TABLES `Bild` WRITE;
/*!40000 ALTER TABLE `Bild` DISABLE KEYS */;
/*!40000 ALTER TABLE `Bild` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Kategorie`
--

DROP TABLE IF EXISTS `Kategorie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Kategorie` (
  `idKategorie` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idKategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Kategorie`
--

LOCK TABLES `Kategorie` WRITE;
/*!40000 ALTER TABLE `Kategorie` DISABLE KEYS */;
INSERT INTO `Kategorie` VALUES (1,'Elektrik'),(2,'Getriebe'),(3,'Bremsen'),(4,'Kupplung'),(5,'Rahmen'),(6,'Scheinwerfer'),(7,'Seilzüge'),(8,'Stossdämpfer'),(9,'Vergaser'),(10,'Zündung'),(11,'Zylinder');
/*!40000 ALTER TABLE `Kategorie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Kunde`
--

DROP TABLE IF EXISTS `Kunde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Kunde` (
  `idKunde` int(11) NOT NULL AUTO_INCREMENT,
  `Nachname` varchar(45) DEFAULT NULL,
  `Vorname` varchar(45) DEFAULT NULL,
  `Adresse` varchar(45) DEFAULT NULL,
  `PLZ` varchar(45) DEFAULT NULL,
  `Ort` varchar(45) DEFAULT NULL,
  `Telefonnummer` varchar(45) DEFAULT NULL,
  `Mail` varchar(45) DEFAULT NULL,
  `Passwort` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idKunde`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Kunde`
--

LOCK TABLES `Kunde` WRITE;
/*!40000 ALTER TABLE `Kunde` DISABLE KEYS */;
/*!40000 ALTER TABLE `Kunde` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Produkt`
--

DROP TABLE IF EXISTS `Produkt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Produkt` (
  `idProdukt` int(11) NOT NULL AUTO_INCREMENT,
  `Bezeichnung` varchar(45) DEFAULT NULL,
  `Beschreibung` varchar(255) DEFAULT NULL,
  `Preis` float DEFAULT NULL,
  `ArtikelNr` varchar(45) DEFAULT NULL,
  `Lagerbestand` int(11) DEFAULT NULL,
  `KategorieID` int(11) NOT NULL,
  PRIMARY KEY (`idProdukt`),
  KEY `fk_Produkt_Kategorie1_idx` (`KategorieID`),
  CONSTRAINT `fk_Produkt_Kategorie1` FOREIGN KEY (`KategorieID`) REFERENCES `Kategorie` (`idKategorie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Produkt`
--

LOCK TABLES `Produkt` WRITE;
/*!40000 ALTER TABLE `Produkt` DISABLE KEYS */;
INSERT INTO `Produkt` VALUES (1,'Gas','Gas',150,'21',13,9),(2,'Elektronik','Jflkdsjf',193.33,'3893',348,1),(3,'weisauned','jfdskl',381,'fjdaf',9993,1);
/*!40000 ALTER TABLE `Produkt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tags`
--

DROP TABLE IF EXISTS `Tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tags` (
  `idTags` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idTags`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tags`
--

LOCK TABLES `Tags` WRITE;
/*!40000 ALTER TABLE `Tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tags_has_Produkt`
--

DROP TABLE IF EXISTS `Tags_has_Produkt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tags_has_Produkt` (
  `Tags_idTags` int(11) NOT NULL,
  `Produkt_idProdukte` int(11) NOT NULL,
  PRIMARY KEY (`Tags_idTags`,`Produkt_idProdukte`),
  KEY `fk_Tags_has_Produkt_Produkt1_idx` (`Produkt_idProdukte`),
  KEY `fk_Tags_has_Produkt_Tags1_idx` (`Tags_idTags`),
  CONSTRAINT `fk_Tags_has_Produkt_Produkt1` FOREIGN KEY (`Produkt_idProdukte`) REFERENCES `Produkt` (`idProdukt`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tags_has_Produkt_Tags1` FOREIGN KEY (`Tags_idTags`) REFERENCES `Tags` (`idTags`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tags_has_Produkt`
--

LOCK TABLES `Tags_has_Produkt` WRITE;
/*!40000 ALTER TABLE `Tags_has_Produkt` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tags_has_Produkt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Warenkorb`
--

DROP TABLE IF EXISTS `Warenkorb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Warenkorb` (
  `Bestellung_idBestellung` int(11) NOT NULL,
  `Produkt_idProdukte` int(11) NOT NULL,
  PRIMARY KEY (`Bestellung_idBestellung`,`Produkt_idProdukte`),
  KEY `fk_Bestellung_has_Produkt_Produkt1_idx` (`Produkt_idProdukte`),
  KEY `fk_Bestellung_has_Produkt_Bestellung1_idx` (`Bestellung_idBestellung`),
  CONSTRAINT `fk_Bestellung_has_Produkt_Bestellung1` FOREIGN KEY (`Bestellung_idBestellung`) REFERENCES `Bestellung` (`idBestellung`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bestellung_has_Produkt_Produkt1` FOREIGN KEY (`Produkt_idProdukte`) REFERENCES `Produkt` (`idProdukt`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Warenkorb`
--

LOCK TABLES `Warenkorb` WRITE;
/*!40000 ALTER TABLE `Warenkorb` DISABLE KEYS */;
/*!40000 ALTER TABLE `Warenkorb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-29 18:13:55

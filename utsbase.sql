-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: utsbase
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
-- Table structure for table `Class`
--

DROP TABLE IF EXISTS `Class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Class` (
  `unit_code` varchar(10) NOT NULL,
  `lec_reg_no` varchar(16) NOT NULL,
  `course_code` varchar(30) NOT NULL,
  PRIMARY KEY (`unit_code`,`lec_reg_no`,`course_code`),
  KEY `course_code` (`course_code`),
  KEY `lec_reg_no` (`lec_reg_no`),
  CONSTRAINT `Class_ibfk_1` FOREIGN KEY (`course_code`) REFERENCES `Course` (`code`),
  CONSTRAINT `Class_ibfk_2` FOREIGN KEY (`lec_reg_no`) REFERENCES `Lecturer` (`regNo`),
  CONSTRAINT `Class_ibfk_3` FOREIGN KEY (`unit_code`) REFERENCES `Unit` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Class`
--

LOCK TABLES `Class` WRITE;
/*!40000 ALTER TABLE `Class` DISABLE KEYS */;
INSERT INTO `Class` VALUES ('COMP101','S100','S13/14'),('COMP101','S100','S13/15'),('COMP101','S100','S13/16'),('COMP240','S100','S13/15'),('COMP310','S100','S13/17'),('MATH240','S400','S15/17');
/*!40000 ALTER TABLE `Class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Course` (
  `name` varchar(30) NOT NULL,
  `year` int(1) NOT NULL,
  `number` int(11) DEFAULT NULL,
  `code` varchar(30) NOT NULL,
  PRIMARY KEY (`code`,`name`,`year`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES ('SOME COURSE',2,20,'S12/3'),('COMPUTER SCIENCE',4,70,'S13/14'),('COMPUTER SCIENCE',3,70,'S13/15'),('COMPUTER SCIENCE',2,70,'S13/16'),('COMPUTER SCIENCE',1,70,'S13/17'),('ACTUIRAL SCIENCE',4,30,'S15/14'),('SOIL SCIENCE',4,30,'S15/14'),('ACTUIRAL SCIENCE',3,30,'S15/15'),('SOIL SCIENCE',3,30,'S15/15'),('ACTUIRAL SCIENCE',2,30,'S15/16'),('SOIL SCIENCE',2,30,'S15/16'),('ACTUIRAL SCIENCE',1,30,'S15/17'),('SOIL SCIENCE',1,30,'S15/17');
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DepFaculty`
--

DROP TABLE IF EXISTS `DepFaculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DepFaculty` (
  `department` varchar(150) NOT NULL,
  `faculty` varchar(150) NOT NULL,
  PRIMARY KEY (`department`,`faculty`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DepFaculty`
--

LOCK TABLES `DepFaculty` WRITE;
/*!40000 ALTER TABLE `DepFaculty` DISABLE KEYS */;
INSERT INTO `DepFaculty` VALUES ('COMPUTER SCIENCE','SCIENCE'),('MATHEMATICS','SCIENCE'),('SOIL SCIENCE','SCIENCE'),('BRIAN','KEMBOI');
/*!40000 ALTER TABLE `DepFaculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `IEO`
--

DROP TABLE IF EXISTS `IEO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IEO` (
  `department` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`department`),
  CONSTRAINT `IEO_ibfk_1` FOREIGN KEY (`department`) REFERENCES `DepFaculty` (`department`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `IEO`
--

LOCK TABLES `IEO` WRITE;
/*!40000 ALTER TABLE `IEO` DISABLE KEYS */;
INSERT INTO `IEO` VALUES ('COMPUTER SCIENCE','franklineapiyo@gmail.com','0706705719','Frankline','Apiyo','Frankline1997'),('MATHEMATICS','somedude@yahoo.com','0722348912','Some','Dude','Somedude1997'),('SOIL SCIENCE','someotherdude@gmail.com','0722419216','SomeOther','Dude','Someotherdude1997');
/*!40000 ALTER TABLE `IEO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Lecturer`
--

DROP TABLE IF EXISTS `Lecturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Lecturer` (
  `regNo` varchar(16) NOT NULL,
  `department` varchar(150) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`regNo`),
  KEY `department` (`department`),
  CONSTRAINT `Lecturer_ibfk_1` FOREIGN KEY (`department`) REFERENCES `DepFaculty` (`department`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Lecturer`
--

LOCK TABLES `Lecturer` WRITE;
/*!40000 ALTER TABLE `Lecturer` DISABLE KEYS */;
INSERT INTO `Lecturer` VALUES ('S100','COMPUTER SCIENCE','BENJAMIN ODIYO'),('S20','SOIL SCIENCE','JAMES JOHNSON'),('S300','SOIL SCIENCE','MOHAMED ABDI'),('S400','MATHEMATICS','GEORGE NUR');
/*!40000 ALTER TABLE `Lecturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Room`
--

DROP TABLE IF EXISTS `Room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Room` (
  `d9F10` int(1) NOT NULL,
  `boardType` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `capacity` int(11) NOT NULL,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lab` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Room`
--

LOCK TABLES `Room` WRITE;
/*!40000 ALTER TABLE `Room` DISABLE KEYS */;
INSERT INTO `Room` VALUES (1,'WHITE',200,'B3',0),(0,'WHITE',300,'B4',0),(5,'WHITE',70,'L1',1),(1,'WHITE',20,'L5',0),(1,'WHITE',22,'Rs',0);
/*!40000 ALTER TABLE `Room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `department` varchar(150) NOT NULL,
  `regNo` varchar(12) NOT NULL,
  `fname` varchar(100) NOT NULL,
  `lname` varchar(100) NOT NULL,
  PRIMARY KEY (`regNo`),
  KEY `department` (`department`),
  CONSTRAINT `Student_ibfk_1` FOREIGN KEY (`department`) REFERENCES `DepFaculty` (`department`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Unit`
--

DROP TABLE IF EXISTS `Unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Unit` (
  `code` varchar(10) NOT NULL,
  `name` varchar(150) NOT NULL,
  `cF` decimal(2,1) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Unit`
--

LOCK TABLES `Unit` WRITE;
/*!40000 ALTER TABLE `Unit` DISABLE KEYS */;
INSERT INTO `Unit` VALUES ('COMP101','INTRODUCTION TO COMPUTING',2.5),('COMP240','OBJECT ORIENTED PROGRAMMING',3.5),('COMP310','COMPUTER ARCHITECTURE',3.5),('MATH240','STATISTICS I',3.5),('MATH241','STATISTICS II',3.5),('SOIL200','SOIL MOISTURES',3.0),('SOIL230','SOIL MICRO-ORGANISMS',3.5);
/*!40000 ALTER TABLE `Unit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-30 11:44:54

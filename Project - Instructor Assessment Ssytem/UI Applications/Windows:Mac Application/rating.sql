-- MySQL dump 10.13  Distrib 5.1.39, for Win32 (ia32)
--
-- Host: localhost    Database: rating
-- ------------------------------------------------------
-- Server version	5.1.39-community

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `pid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `comment` blob,
  `easiness` int(11) DEFAULT NULL,
  `clarity` int(11) DEFAULT NULL,
  `help` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,1,'Good',3,3,5),(1,2,'',1,1,1),(5,3,'dddddd',5,5,5),(0,4,'',3,2,4),(0,5,'',3,2,4),(0,6,'',3,2,4),(0,7,'',3,2,4),(0,8,'',3,2,4),(0,9,'',3,2,4),(0,10,'',3,2,4),(2,11,'good teacer, best..',5,5,5),(2,12,'good teacer, best..',5,5,5),(5,13,'good teacer, best..',5,5,5),(5,14,'good teacer, best..',5,5,5),(5,15,'good teacer, best..',5,5,5),(0,16,'wq	edqwewqeq',3,2,3),(1,17,'ass',1,1,1),(1,18,'lolu',5,5,5),(1,19,'asshole',2,2,2),(5,20,'asshole',1,1,1),(5,21,'asshole',1,1,1),(5,22,'asshole',1,1,1),(5,23,'asshole',1,1,1),(5,24,'asshole',1,1,1),(5,25,'asshole',1,1,1),(5,26,'asshole',1,1,1),(5,27,'asshole',1,1,1),(5,28,'asshole',1,1,1),(5,29,'asshole',1,1,1),(5,30,'asshole',1,1,1),(5,31,'asshole',1,1,1),(5,32,'asshole',1,1,1),(5,33,'asshole',1,1,1),(5,34,'asshole',1,1,1),(5,35,'asshole',1,1,1),(5,36,'asshole',1,1,1),(5,37,'asshole',1,1,1),(5,38,'asshole',1,1,1),(5,39,'asshole',1,1,1);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prof`
--

DROP TABLE IF EXISTS `prof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prof` (
  `pid` int(11) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `dept` varchar(20) DEFAULT NULL,
  `overall` float DEFAULT NULL,
  `easiness` float DEFAULT NULL,
  `helfulness` float DEFAULT NULL,
  `clarity` float DEFAULT NULL,
  `no` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prof`
--

LOCK TABLES `prof` WRITE;
/*!40000 ALTER TABLE `prof` DISABLE KEYS */;
INSERT INTO `prof` VALUES (1,'Ajay Kaul','cse',2.8,3.2,2.6,2.6,5),(2,'Sanjay Sharma','cse',2.5,2.5,2.5,2.5,2),(3,'Manoj Kumar','cse',0,0,0,0,0),(4,'M.L. Garg','cse',0,0,0,0,0),(5,'Anuj Mahajan','cse',3.53333,3.53333,3.53333,3.53333,24),(6,'Sonika Gupta','cse',0,0,0,0,0),(7,'Sunanda Gupta','cse',0,0,0,0,0),(8,'Sakshi Arora','cse',0,0,0,0,0),(9,'Monica Prajapati','cse',0,0,0,0,0),(10,'Deo Prakash','cse',0,0,0,0,0);
/*!40000 ALTER TABLE `prof` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-06-19 16:31:06

-- MySQL dump 10.13  Distrib 8.0.26, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: db_mysql
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `active_session`
--

DROP TABLE IF EXISTS `active_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `active_session` (
  `id` varchar(60) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `active_session_user_id_idx` (`user_id`),
  CONSTRAINT `active_session_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `active_session`
--

LOCK TABLES `active_session` WRITE;
/*!40000 ALTER TABLE `active_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `active_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `street` varchar(45) NOT NULL,
  `zip_code` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'gvwfb','wf','ewfrg','ffwgr3g'),(2,'street','zipCode','city','country'),(3,'street','zipCode','city','country'),(4,'street','zipCode','city','country'),(6,'street','zipCode','city','country'),(7,'street','zipCode','city','country'),(8,'street','zipCode','city','country'),(9,'street','zipCode','city','country'),(10,'street','zipCode','city','country'),(11,'street','zipCode','city','country'),(13,'street','zipCode','city','country'),(17,'Karlstorpsvägen','6432WE','Knutanstad','Sweden'),(19,'Cuckoostreet','SOS911','Elm Street','Fantasia'),(20,'Cuckoostreet','SOS911','Elm Street','Fantasia'),(21,'Cuckoostreet','SOS911','Elm Street','Fantasia'),(22,'Cuckoostreet','SOS911','Elm Street','Fantasia'),(23,'Karlstorpsvägen','6432WE','Knutanstad','Sweden'),(24,'Karlstorpsvägen','6432WE','Knutanstad','Sweden'),(25,'fvewrFV','34T4V','ERGRWGE','G3REEWG§'),(26,'fvewrFV','34T4V','ERGRWGE','G3REEWG§'),(27,'Karlstorpsvägen','6432WE','Knutanstad','Sweden'),(29,'Karlstorpsvägen','6432WE','Knutanstad','Sweden'),(30,'Karlstorpsvägen','6432WE','Knutanstad','Sweden'),(31,'Karlstorpsvägen','6432WE','Knutanstad','Sweden'),(32,'Luxury','SECRET','City of Dreams','TOP-SECRET'),(33,'Karlstorpsvägen','6432WE','Knutanstad','Sweden'),(34,'On the street','No really','Anywhere','ANY.WHERE.'),(35,'Bommerstreet','96532b','Island','USA'),(36,'street','zipCode','city','country'),(37,'Ignotusstreet 9','12345','Boomhill','Unearthly'),(38,'Banan street','1232','Banana','Banna Country');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amenity_enum`
--

DROP TABLE IF EXISTS `amenity_enum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amenity_enum` (
  `id` int NOT NULL AUTO_INCREMENT,
  `home_id` int NOT NULL,
  `amenity` enum('WIFI','KITCHEN','PARKING','BATH') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `amenity_enum_home_id_idx` (`home_id`),
  CONSTRAINT `amenity_enum_home_id` FOREIGN KEY (`home_id`) REFERENCES `home` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amenity_enum`
--

LOCK TABLES `amenity_enum` WRITE;
/*!40000 ALTER TABLE `amenity_enum` DISABLE KEYS */;
INSERT INTO `amenity_enum` VALUES (1,1,'WIFI'),(2,1,'BATH'),(3,1,'PARKING'),(4,8,'WIFI'),(5,8,'KITCHEN'),(6,9,'WIFI'),(7,9,'KITCHEN'),(8,10,'WIFI'),(9,10,'KITCHEN'),(10,11,'WIFI'),(11,11,'KITCHEN'),(12,12,'WIFI'),(13,12,'KITCHEN'),(14,13,'WIFI'),(15,13,'KITCHEN'),(18,15,'WIFI'),(19,15,'KITCHEN'),(26,19,'WIFI'),(27,19,'BATH'),(31,21,'WIFI'),(32,21,'KITCHEN'),(33,21,'BATH'),(34,22,'WIFI'),(35,22,'KITCHEN'),(36,22,'BATH'),(37,23,'WIFI'),(38,23,'KITCHEN'),(39,23,'BATH'),(40,24,'WIFI'),(41,24,'KITCHEN'),(42,24,'BATH'),(43,25,'BATH'),(44,26,'BATH'),(45,27,'KITCHEN'),(46,28,'KITCHEN'),(47,29,'WIFI'),(48,30,'BATH'),(49,31,'BATH'),(50,32,'WIFI'),(51,32,'KITCHEN'),(52,32,'BATH'),(53,33,'WIFI'),(54,34,'WIFI'),(55,34,'KITCHEN'),(56,36,'WIFI'),(57,36,'KITCHEN'),(58,37,'WIFI'),(59,37,'KITCHEN'),(60,38,'WIFI'),(61,38,'KITCHEN'),(62,38,'BATH'),(63,39,'WIFI');
/*!40000 ALTER TABLE `amenity_enum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `amenity_enum_history_log`
--

DROP TABLE IF EXISTS `amenity_enum_history_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `amenity_enum_history_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `home_history_log_id` int NOT NULL,
  `amenity` enum('WIFI','KITCHEN','PARKING','BATH') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `amenity_history_home_history_idx` (`home_history_log_id`),
  CONSTRAINT `amenity_history_home_history` FOREIGN KEY (`home_history_log_id`) REFERENCES `home_history_log` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amenity_enum_history_log`
--

LOCK TABLES `amenity_enum_history_log` WRITE;
/*!40000 ALTER TABLE `amenity_enum_history_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `amenity_enum_history_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_detail`
--

DROP TABLE IF EXISTS `booking_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `renter_id` int NOT NULL,
  `home_id` int NOT NULL,
  `total_price` int NOT NULL,
  `start_date` timestamp NOT NULL,
  `end_date` timestamp NOT NULL,
  `created_date` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `booking_detail_renter_id_idx` (`renter_id`),
  KEY `booking_detail_home_id_idx` (`home_id`),
  CONSTRAINT `booking_detail_home_id` FOREIGN KEY (`home_id`) REFERENCES `home` (`id`),
  CONSTRAINT `booking_detail_renter_id` FOREIGN KEY (`renter_id`) REFERENCES `renter` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_detail`
--

LOCK TABLES `booking_detail` WRITE;
/*!40000 ALTER TABLE `booking_detail` DISABLE KEYS */;
INSERT INTO `booking_detail` VALUES (2,1,1,123,'2021-11-22 23:00:00','2021-11-22 23:00:00','2021-11-22 23:00:00'),(3,8,27,976,'2012-11-18 23:01:57','2012-11-18 23:01:57','2021-09-24 08:23:07'),(4,8,27,976,'2012-11-18 23:01:57','2012-11-18 23:01:57','2021-09-24 08:28:32'),(5,8,24,926,'2012-11-18 23:01:57','2012-11-18 23:01:57','2021-09-24 08:31:13');
/*!40000 ALTER TABLE `booking_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home`
--

DROP TABLE IF EXISTS `home`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `home` (
  `id` int NOT NULL AUTO_INCREMENT,
  `host_id` int NOT NULL,
  `address_id` int NOT NULL,
  `price_per_night` int NOT NULL,
  `start_date` timestamp NOT NULL,
  `end_date` timestamp NOT NULL,
  `updated_date` timestamp NULL DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `home_address_id_idx` (`address_id`),
  KEY `home_host_id_idx` (`host_id`),
  CONSTRAINT `home_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `home_host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home`
--

LOCK TABLES `home` WRITE;
/*!40000 ALTER TABLE `home` DISABLE KEYS */;
INSERT INTO `home` VALUES (1,1,1,123,'2021-11-22 23:00:00','2021-11-22 23:00:00',NULL,'2021-11-22 23:00:00'),(4,2,2,0,'2012-11-18 23:01:57','2012-11-18 23:01:57',NULL,NULL),(5,2,3,0,'2012-11-18 23:01:57','2012-11-18 23:01:57',NULL,NULL),(6,4,4,0,'2012-11-18 23:01:57','2012-11-18 23:01:57',NULL,NULL),(8,4,6,0,'2012-11-18 23:01:57','2012-11-18 23:01:57',NULL,NULL),(9,4,7,0,'2012-11-18 23:01:57','2012-11-18 23:01:57',NULL,NULL),(10,4,8,0,'2012-11-18 23:01:57','2012-11-18 23:01:57',NULL,NULL),(11,4,9,0,'2012-11-18 23:01:57','2012-11-18 23:01:57',NULL,'2021-09-23 18:16:11'),(12,4,10,0,'2012-11-18 23:01:57','2012-11-18 23:01:57',NULL,'2021-09-23 18:16:20'),(13,4,11,0,'2012-11-18 23:01:57','2012-11-18 23:01:57',NULL,'2021-09-23 18:24:36'),(15,4,13,0,'2012-11-18 23:01:57','2012-11-18 23:01:57',NULL,'2021-09-23 18:46:47'),(19,4,17,546,'2021-08-17 00:00:00','2021-11-28 00:00:00',NULL,'2021-09-23 22:14:17'),(21,4,19,9846,'2021-09-12 00:00:00','2021-10-28 00:00:00',NULL,'2021-09-23 22:18:36'),(22,4,20,9846,'2021-09-12 00:00:00','2021-10-28 00:00:00',NULL,'2021-09-23 22:18:44'),(23,4,21,9846,'2021-09-12 00:00:00','2021-10-28 00:00:00',NULL,'2021-09-23 22:18:53'),(24,4,22,9846,'2021-09-12 00:00:00','2021-10-28 00:00:00',NULL,'2021-09-23 22:18:58'),(25,4,23,0,'2021-08-10 00:00:00','2021-10-29 00:00:00',NULL,'2021-09-23 22:19:24'),(26,4,24,544651,'2021-08-10 00:00:00','2021-10-29 00:00:00',NULL,'2021-09-23 22:19:35'),(27,4,25,1243,'2021-09-04 00:00:00','2021-09-29 00:00:00',NULL,'2021-09-24 06:56:21'),(28,4,26,1243,'2021-09-04 00:00:00','2021-09-29 00:00:00',NULL,'2021-09-24 06:56:34'),(29,4,27,76345321,'2021-09-27 00:00:00','2021-10-30 00:00:00',NULL,'2021-09-24 07:17:19'),(30,4,29,123,'2021-09-09 00:00:00','2021-09-12 00:00:00',NULL,'2021-09-24 07:30:52'),(31,4,30,123,'2021-09-09 00:00:00','2021-09-12 00:00:00',NULL,'2021-09-24 07:30:55'),(32,4,31,5646561,'2021-09-21 00:00:00','2021-09-30 00:00:00',NULL,'2021-09-24 07:31:26'),(33,4,32,78998,'2021-09-13 00:00:00','2021-09-30 00:00:00',NULL,'2021-09-24 07:33:23'),(34,4,33,98113512,'2021-09-28 00:00:00','2021-09-30 00:00:00',NULL,'2021-09-24 07:34:01'),(35,4,34,54,'2021-09-08 00:00:00','2021-11-30 00:00:00',NULL,'2021-09-24 07:34:55'),(36,11,35,975,'2021-09-05 00:00:00','2022-01-28 00:00:00',NULL,'2021-09-24 07:37:24'),(37,4,36,0,'2012-11-18 23:01:57','2012-11-18 23:01:57',NULL,'2021-09-24 08:42:32'),(38,11,37,100,'2021-09-13 00:00:00','2021-09-30 00:00:00',NULL,'2021-09-24 08:47:03'),(39,4,38,123,'2021-09-24 00:00:00','2021-09-26 00:00:00',NULL,'2021-09-24 08:58:43');
/*!40000 ALTER TABLE `home` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home_history_log`
--

DROP TABLE IF EXISTS `home_history_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `home_history_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `home_id` int NOT NULL,
  `price_per_night` int NOT NULL,
  `start_date` timestamp NOT NULL,
  `end_date` timestamp NOT NULL,
  `created_date` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `home_history_log_id_idx` (`home_id`),
  CONSTRAINT `home_history_log_id` FOREIGN KEY (`home_id`) REFERENCES `home` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_history_log`
--

LOCK TABLES `home_history_log` WRITE;
/*!40000 ALTER TABLE `home_history_log` DISABLE KEYS */;
INSERT INTO `home_history_log` VALUES (1,1,1234,'2021-01-11 23:00:00','2021-11-13 12:00:00','2021-01-01 13:15:09');
/*!40000 ALTER TABLE `home_history_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home_image`
--

DROP TABLE IF EXISTS `home_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `home_image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `home_id` int NOT NULL,
  `image_url` varchar(600) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `image_home_id_idx` (`home_id`),
  CONSTRAINT `image_home_id` FOREIGN KEY (`home_id`) REFERENCES `home` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_image`
--

LOCK TABLES `home_image` WRITE;
/*!40000 ALTER TABLE `home_image` DISABLE KEYS */;
INSERT INTO `home_image` VALUES (1,1,'https://q4g9y5a8.rocketcdn.me/wp-content/uploads/2020/02/home-banner-2020-02-min.webp'),(4,19,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(5,19,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(6,19,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(7,21,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(8,21,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(9,21,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(10,22,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(11,22,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(12,22,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(13,23,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(14,23,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(15,23,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(16,24,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(17,24,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(18,24,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(19,25,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(20,25,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(21,25,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(22,26,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(23,26,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(24,26,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(31,29,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(32,29,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(33,29,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(34,30,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(35,30,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(36,30,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(37,31,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(38,31,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(39,31,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(40,32,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(41,32,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(42,32,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(43,33,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(44,33,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(45,33,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(46,34,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(47,34,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(48,34,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(49,35,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(50,35,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(51,35,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(52,36,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(53,36,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(54,36,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(57,38,'https://images.unsplash.com/photo-1580587771525-78b9dba3b914?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aG91c2V8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80'),(58,38,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(59,38,'https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'),(60,39,'https://www.google.com/url?sa=i&url=https%3A%2F%2Funsplash.com%2Fimages%2Fthings%2Fhouse&psig=AOvVaw0lfsl2iEONzC7q3goVQ64n&ust=1632551742354000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCJiOrqf_lvMCFQAAAAAdAAAAABAD'),(61,39,''),(62,39,'');
/*!40000 ALTER TABLE `home_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home_image_history_log`
--

DROP TABLE IF EXISTS `home_image_history_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `home_image_history_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `home_history_log_id` int NOT NULL,
  `image_url` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `image_history_home_history_id_idx` (`home_history_log_id`),
  CONSTRAINT `image_history_home_history_id` FOREIGN KEY (`home_history_log_id`) REFERENCES `home_history_log` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_image_history_log`
--

LOCK TABLES `home_image_history_log` WRITE;
/*!40000 ALTER TABLE `home_image_history_log` DISABLE KEYS */;
INSERT INTO `home_image_history_log` VALUES (1,1,'oldUrl');
/*!40000 ALTER TABLE `home_image_history_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `homeview`
--

DROP TABLE IF EXISTS `homeview`;
/*!50001 DROP VIEW IF EXISTS `homeview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `homeview` AS SELECT 
 1 AS `id`,
 1 AS `pricePerNight`,
 1 AS `startDate`,
 1 AS `endDate`,
 1 AS `country`,
 1 AS `street`,
 1 AS `city`,
 1 AS `zipCode`,
 1 AS `amenity`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `host`
--

DROP TABLE IF EXISTS `host`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `host` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `_idx` (`user_id`),
  CONSTRAINT `host_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `host`
--

LOCK TABLES `host` WRITE;
/*!40000 ALTER TABLE `host` DISABLE KEYS */;
INSERT INTO `host` VALUES (1,1),(3,2),(2,3),(4,4),(5,5),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14);
/*!40000 ALTER TABLE `host` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `host_review`
--

DROP TABLE IF EXISTS `host_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `host_review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `review_id` int NOT NULL,
  `host_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `host_review_review_id_idx` (`review_id`),
  KEY `host_review_host_id_idx` (`host_id`),
  CONSTRAINT `host_review_host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`),
  CONSTRAINT `host_review_review_id` FOREIGN KEY (`review_id`) REFERENCES `review` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `host_review`
--

LOCK TABLES `host_review` WRITE;
/*!40000 ALTER TABLE `host_review` DISABLE KEYS */;
INSERT INTO `host_review` VALUES (1,1,1);
/*!40000 ALTER TABLE `host_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `new_vadsadiew`
--

DROP TABLE IF EXISTS `new_vadsadiew`;
/*!50001 DROP VIEW IF EXISTS `new_vadsadiew`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `new_vadsadiew` AS SELECT 
 1 AS `id`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `new_view`
--

DROP TABLE IF EXISTS `new_view`;
/*!50001 DROP VIEW IF EXISTS `new_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `new_view` AS SELECT 
 1 AS `id`,
 1 AS `pricePerNight`,
 1 AS `startDate`,
 1 AS `endDate`,
 1 AS `country`,
 1 AS `street`,
 1 AS `city`,
 1 AS `amenity`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `newads_view`
--

DROP TABLE IF EXISTS `newads_view`;
/*!50001 DROP VIEW IF EXISTS `newads_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `newads_view` AS SELECT 
 1 AS `id`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `renter`
--

DROP TABLE IF EXISTS `renter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `renter` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  CONSTRAINT `renter_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `renter`
--

LOCK TABLES `renter` WRITE;
/*!40000 ALTER TABLE `renter` DISABLE KEYS */;
INSERT INTO `renter` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14);
/*!40000 ALTER TABLE `renter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `renter_review`
--

DROP TABLE IF EXISTS `renter_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `renter_review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `review_id` int NOT NULL,
  `renter_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `renter_review_renter_id_idx` (`renter_id`),
  KEY `renter_review_review_id_idx` (`review_id`),
  CONSTRAINT `renter_review_renter_id` FOREIGN KEY (`renter_id`) REFERENCES `renter` (`id`),
  CONSTRAINT `renter_review_review_id` FOREIGN KEY (`review_id`) REFERENCES `review` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `renter_review`
--

LOCK TABLES `renter_review` WRITE;
/*!40000 ALTER TABLE `renter_review` DISABLE KEYS */;
INSERT INTO `renter_review` VALUES (3,2,1);
/*!40000 ALTER TABLE `renter_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creator_id` int NOT NULL,
  `booking_id` int NOT NULL,
  `rating` int NOT NULL,
  `comment` varchar(45) NOT NULL,
  `created_date` timestamp NOT NULL,
  `is_deleted` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `review_booking_id_idx` (`booking_id`),
  KEY `review_creator_id_idx` (`creator_id`),
  CONSTRAINT `review_booking_id` FOREIGN KEY (`booking_id`) REFERENCES `booking_detail` (`id`),
  CONSTRAINT `review_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (1,1,2,3,'something','2021-09-15 10:16:18',0),(2,1,2,1,'hello there','2021-11-10 23:00:00',0);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(400) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Kamilla','Johansson','kam@gmail.com','123'),(2,'Andrew','Hamish','anha@gmail.com','a03ab19b866fc585b5cb1812a2f63ca861e7e7643ee5d43fd7106b623725fd67'),(3,'Robert','Linder','rolling@gmail.com','09d8409dfa0ba399cf95c6510b579542aba7b6230c6354dfb7090e9a9c0fe3d1'),(4,'Anders','SJ','asj@mail.com','a03ab19b866fc585b5cb1812a2f63ca861e7e7643ee5d43fd7106b623725fd67'),(5,'Wendy','Arnoldsson','wean@mail.com','a03ab19b866fc585b5cb1812a2f63ca861e7e7643ee5d43fd7106b623725fd67'),(8,'Hamish','Washington','hawa@mail.com','a03ab19b866fc585b5cb1812a2f63ca861e7e7643ee5d43fd7106b623725fd67'),(9,'Arnold','Arnoldsson','arn@mail.com','a03ab19b866fc585b5cb1812a2f63ca861e7e7643ee5d43fd7106b623725fd67'),(10,'Joey','Quatryl','jq@mail.com','a03ab19b866fc585b5cb1812a2f63ca861e7e7643ee5d43fd7106b623725fd67'),(11,'Karen','Boomer','iwanttotalktoyourmanager@me.com','a03ab19b866fc585b5cb1812a2f63ca861e7e7643ee5d43fd7106b623725fd67'),(12,'Katarina','Williams','katams@mail.com','a03ab19b866fc585b5cb1812a2f63ca861e7e7643ee5d43fd7106b623725fd67'),(13,'John','Adams','ja@mail.com','a03ab19b866fc585b5cb1812a2f63ca861e7e7643ee5d43fd7106b623725fd67'),(14,'Polly','Poppins','pop@mail.com','a03ab19b866fc585b5cb1812a2f63ca861e7e7643ee5d43fd7106b623725fd67'),(15,'Alex','E','apa','67b176705b46206614219f47a05aee7ae6a3edbe850bbbe214c536b989aea4d2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wallet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `token_amount` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `wallet_user_id_idx` (`user_id`),
  CONSTRAINT `wallet_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet`
--

LOCK TABLES `wallet` WRITE;
/*!40000 ALTER TABLE `wallet` DISABLE KEYS */;
/*!40000 ALTER TABLE `wallet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `homeview`
--

/*!50001 DROP VIEW IF EXISTS `homeview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `homeview` AS select `home`.`id` AS `id`,`home`.`price_per_night` AS `pricePerNight`,`home`.`start_date` AS `startDate`,`home`.`end_date` AS `endDate`,`address`.`country` AS `country`,`address`.`street` AS `street`,`address`.`city` AS `city`,`address`.`zip_code` AS `zipCode`,`amenity_enum`.`amenity` AS `amenity` from ((`home` join `address` on((`home`.`id` = `address`.`id`))) join `amenity_enum` on((`home`.`id` = `amenity_enum`.`home_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `new_vadsadiew`
--

/*!50001 DROP VIEW IF EXISTS `new_vadsadiew`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `new_vadsadiew` AS select `home`.`id` AS `id` from ((`home` join `address` on((`home`.`id` = `address`.`id`))) join `amenity_enum` on((`amenity_enum`.`home_id` = `home`.`id`))) order by `home`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `new_view`
--

/*!50001 DROP VIEW IF EXISTS `new_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `new_view` AS select `home`.`id` AS `id`,`home`.`price_per_night` AS `pricePerNight`,`home`.`start_date` AS `startDate`,`home`.`end_date` AS `endDate`,`address`.`country` AS `country`,`address`.`street` AS `street`,`address`.`city` AS `city`,`amenity_enum`.`amenity` AS `amenity` from ((`home` join `address` on((`home`.`id` = `address`.`id`))) join `amenity_enum` on((`home`.`id` = `amenity_enum`.`home_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `newads_view`
--

/*!50001 DROP VIEW IF EXISTS `newads_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `newads_view` AS select `home`.`id` AS `id` from ((`home` join `address` on((`home`.`id` = `address`.`id`))) join `amenity_enum` on((`amenity_enum`.`home_id` = `home`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-24 18:36:06

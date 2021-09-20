-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: db_mysql
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
  `id` int NOT NULL AUTO_INCREMENT,
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'gvwfb','wf','ewfrg','ffwgr3g');
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
  `amenity` enum('wifi','kitchen','parking','bath') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `amenity_enum_home_id_idx` (`home_id`),
  CONSTRAINT `amenity_enum_home_id` FOREIGN KEY (`home_id`) REFERENCES `home` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amenity_enum`
--

LOCK TABLES `amenity_enum` WRITE;
/*!40000 ALTER TABLE `amenity_enum` DISABLE KEYS */;
INSERT INTO `amenity_enum` VALUES (1,1,'wifi'),(2,1,'bath'),(3,1,'parking');
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
  `amenity` enum('wifi','kitchen','parking','bath') NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_detail`
--

LOCK TABLES `booking_detail` WRITE;
/*!40000 ALTER TABLE `booking_detail` DISABLE KEYS */;
INSERT INTO `booking_detail` VALUES (2,1,1,123,'2021-11-22 23:00:00','2021-11-22 23:00:00','2021-11-22 23:00:00');
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
  `created_date` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `home_address_id_idx` (`address_id`),
  KEY `home_host_id_idx` (`host_id`),
  CONSTRAINT `home_address_id` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `home_host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home`
--

LOCK TABLES `home` WRITE;
/*!40000 ALTER TABLE `home` DISABLE KEYS */;
INSERT INTO `home` VALUES (1,1,1,123,'2021-11-22 23:00:00','2021-11-22 23:00:00',NULL,'2021-11-22 23:00:00');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_history_log`
--

LOCK TABLES `home_history_log` WRITE;
/*!40000 ALTER TABLE `home_history_log` DISABLE KEYS */;
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
  `image_url` varchar(300) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `image_home_id_idx` (`home_id`),
  CONSTRAINT `image_home_id` FOREIGN KEY (`home_id`) REFERENCES `home` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_image`
--

LOCK TABLES `home_image` WRITE;
/*!40000 ALTER TABLE `home_image` DISABLE KEYS */;
INSERT INTO `home_image` VALUES (1,1,'https://q4g9y5a8.rocketcdn.me/wp-content/uploads/2020/02/home-banner-2020-02-min.webp');
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
  `image_url` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `image_history_home_history_id_idx` (`home_history_log_id`),
  CONSTRAINT `image_history_home_history_id` FOREIGN KEY (`home_history_log_id`) REFERENCES `home_history_log` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_image_history_log`
--

LOCK TABLES `home_image_history_log` WRITE;
/*!40000 ALTER TABLE `home_image_history_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `home_image_history_log` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `host`
--

LOCK TABLES `host` WRITE;
/*!40000 ALTER TABLE `host` DISABLE KEYS */;
INSERT INTO `host` VALUES (1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `renter`
--

LOCK TABLES `renter` WRITE;
/*!40000 ALTER TABLE `renter` DISABLE KEYS */;
INSERT INTO `renter` VALUES (1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Kamilla','Johansson','kam@gmail.com','123'),(2,'Andrew','Hamish','anha@gmail.com','a03ab19b866fc585b5cb1812a2f63ca861e7e7643ee5d43fd7106b623725fd67'),(3,'Robert','Linder','rolling@gmail.com','09d8409dfa0ba399cf95c6510b579542aba7b6230c6354dfb7090e9a9c0fe3d1');
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-20 13:49:25

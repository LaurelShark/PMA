-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: trading
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'grocery'),(2,'sedan'),(3,'SUV'),(4,'Jomn'),(5,'smartphones'),(6,'earphones'),(7,'cases'),(8,'power-banks'),(9,'categoria'),(10,'new ');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `departments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,1,'food'),(2,2,'cars'),(3,1,'Phones'),(4,2,'Accessories'),(5,1,'Management'),(6,2,'Stock');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `category_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `min_amount` int(11) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `unique_id` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  CONSTRAINT `goods_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'stew',1,1,0,0,0.00,NULL),(2,'Mercedes Benz',2,2,0,0,0.00,NULL),(3,'Mercedes Gelandewagen',3,2,0,0,0.00,NULL),(5,'Good1',1,1,2,1,30.00,'SSL-12LTS-95-HS-112'),(6,'Phone Samsung Galaxy S10 Black',1,1,19,4,48000.00,'35-4190'),(7,'iPhone S8 Rose Gold',1,1,6,4,35000.00,'11-419002-389644-6'),(8,'Sony Noise Cancelin Headphones',2,2,28,5,500.00,NULL),(9,'Sony Stereo Wired Earbuds',2,2,30,5,299.00,NULL),(10,'XIAOMI Mi Power Bank',4,2,13,7,899.00,NULL),(11,'Silicon Case for iPhone S5',3,2,63,10,679.00,NULL),(12,'knut',1,1,100,5,90.00,NULL),(13,'knut32',1,1,100,5,90.00,NULL),(14,'coca-cola',3,1,1500,20,16.00,NULL),(15,'coca-colaUPD',3,1,1500,20,15.50,NULL);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderlines`
--

DROP TABLE IF EXISTS `orderlines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orderlines` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL,
  `good_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `provider_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderlines`
--

LOCK TABLES `orderlines` WRITE;
/*!40000 ALTER TABLE `orderlines` DISABLE KEYS */;
INSERT INTO `orderlines` VALUES (1,20,5,7,30,2),(2,21,14,7,16,2),(3,7,1,10,0,3),(4,3,15,10,15.5,3);
/*!40000 ALTER TABLE `orderlines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(30) NOT NULL,
  `date` datetime DEFAULT NULL,
  `total_sum` float DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'done','2019-02-21 00:00:00',960000,2),(2,'done','2019-02-27 00:00:00',252777,2),(3,'NOT CONFIRMED','2019-04-22 00:00:00',NULL,2),(4,'NOT CONFIRMED','2019-04-22 00:00:00',NULL,2),(5,'NOT CONFIRMED','2019-04-22 00:00:00',NULL,2),(7,'APPROVED','2019-04-25 09:52:22',952,2),(8,'NOT CONFIRMED','2019-04-24 13:29:17',NULL,2),(9,'NOT CONFIRMED','2019-04-24 13:32:27',NULL,2),(10,'NOT CONFIRMED','2019-04-24 13:33:38',46.5,2);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `providers`
--

DROP TABLE IF EXISTS `providers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `providers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `person_name` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `adress` varchar(50) NOT NULL,
  `card_number` varchar(16) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `providers`
--

LOCK TABLES `providers` WRITE;
/*!40000 ALTER TABLE `providers` DISABLE KEYS */;
INSERT INTO `providers` VALUES (1,'Providers Group','Galyna Vasylkivska','0445673812','Baseina str, 9A, off.3','4876234509189754',NULL),(2,'Providers and Co.','Hlib Kovaliov','0447200918','Vokzalna str., 14, off.1','4782193082761090',NULL),(3,'Providers Group','Galyna Vasylkivska','0445673812','Baseina str, 9A, off.3','4876234509189754',NULL),(4,'Providers and Co.','Hlib Kovaliov','0447200918','Vokzalna str., 14, off.1','4782193082761090',NULL);
/*!40000 ALTER TABLE `providers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receiptlines`
--

DROP TABLE IF EXISTS `receiptlines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `receiptlines` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `amount` float NOT NULL,
  `price` float NOT NULL,
  `unique_id` varchar(100) DEFAULT NULL,
  `good_id` int(11) NOT NULL,
  `receipt_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `good_id` (`good_id`),
  KEY `receipt_id` (`receipt_id`),
  CONSTRAINT `receiptlines_ibfk_1` FOREIGN KEY (`good_id`) REFERENCES `goods` (`id`),
  CONSTRAINT `receiptlines_ibfk_2` FOREIGN KEY (`receipt_id`) REFERENCES `receipts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receiptlines`
--

LOCK TABLES `receiptlines` WRITE;
/*!40000 ALTER TABLE `receiptlines` DISABLE KEYS */;
INSERT INTO `receiptlines` VALUES (13,'Phone Samsung Galaxy S10 Black',1,48000,'34-419002-389644-3',1,1),(14,'Sony Stereo Wired Earbuds',1,299,NULL,2,2),(15,'XIAOMI Mi Power Bank',1,899,NULL,3,2),(16,'Silicon Case for iPhone S5',1,679,NULL,2,2),(19,'knut',5,90,NULL,12,13),(20,'coca-cola',20,16,NULL,14,14),(21,'coca-cola',10,16,NULL,14,15),(22,'Good1',12,30,'SSL-12LTS-95-HS-112',5,16),(23,'coca-cola',10,16,NULL,14,16);
/*!40000 ALTER TABLE `receiptlines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipts`
--

DROP TABLE IF EXISTS `receipts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `receipts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total_sum` float DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `receipts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipts`
--

LOCK TABLES `receipts` WRITE;
/*!40000 ALTER TABLE `receipts` DISABLE KEYS */;
INSERT INTO `receipts` VALUES (1,48000,3,NULL),(2,1877,3,NULL),(3,48000,3,NULL),(4,1877,3,NULL),(5,48000,9,NULL),(6,1877,10,NULL),(13,90,2,'2019-04-22 13:28:26'),(14,16,2,'2019-04-22 14:48:21'),(15,160,2,'2019-04-22 14:51:27'),(16,520,2,'2019-04-22 14:58:54');
/*!40000 ALTER TABLE `receipts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'admin'),(2,'user'),(3,'merchandiser');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplies`
--

DROP TABLE IF EXISTS `supplies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `supplies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `provider_id` int(11) NOT NULL,
  `total_sum` float DEFAULT NULL,
  `order_id` int(11) NOT NULL,
  `datetime` datetime DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `provider_id` (`provider_id`),
  KEY `order_id` (`order_id`),
  KEY `created_by` (`created_by`),
  CONSTRAINT `supplies_ibfk_1` FOREIGN KEY (`provider_id`) REFERENCES `providers` (`id`),
  CONSTRAINT `supplies_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `supplies_ibfk_3` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplies`
--

LOCK TABLES `supplies` WRITE;
/*!40000 ALTER TABLE `supplies` DISABLE KEYS */;
INSERT INTO `supplies` VALUES (2,1,210000,2,NULL,NULL),(3,2,960000,1,NULL,NULL),(4,2,294777,2,NULL,NULL),(5,2,0,3,'2019-04-24 14:53:13',NULL),(6,2,0,3,'2019-04-24 14:53:48',NULL),(7,2,0,3,'2019-04-24 14:55:09',NULL),(8,2,0,3,'2019-04-24 14:57:44',NULL),(9,2,108395,3,'2019-04-24 15:02:10',NULL),(10,2,3000,3,'2019-04-25 11:41:33',10),(11,2,2097,3,'2019-04-25 10:07:37',9);
/*!40000 ALTER TABLE `supplies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplylines`
--

DROP TABLE IF EXISTS `supplylines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `supplylines` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` float NOT NULL,
  `price` float NOT NULL,
  `good_id` int(11) NOT NULL,
  `supply_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `good_id` (`good_id`),
  KEY `supply_id` (`supply_id`),
  CONSTRAINT `supplylines_ibfk_1` FOREIGN KEY (`good_id`) REFERENCES `goods` (`id`),
  CONSTRAINT `supplylines_ibfk_2` FOREIGN KEY (`supply_id`) REFERENCES `supplies` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplylines`
--

LOCK TABLES `supplylines` WRITE;
/*!40000 ALTER TABLE `supplylines` DISABLE KEYS */;
INSERT INTO `supplylines` VALUES (2,20,48000,1,2),(3,6,35000,2,4),(4,63,679,3,3),(5,3,35000,7,9),(6,5,679,11,9),(7,3,500,11,10),(8,3,899,10,10),(9,2,30,5,11),(10,3,679,11,11);
/*!40000 ALTER TABLE `supplylines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userroles`
--

DROP TABLE IF EXISTS `userroles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userroles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `userroles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `userroles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroles`
--

LOCK TABLES `userroles` WRITE;
/*!40000 ALTER TABLE `userroles` DISABLE KEYS */;
INSERT INTO `userroles` VALUES (13,11,1);
/*!40000 ALTER TABLE `userroles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `salary` int(11) NOT NULL,
  `department_id` int(11) NOT NULL,
  `email` varchar(80) NOT NULL,
  `password` varchar(150) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `department_id` (`department_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'lol','lol',100,1,'lol@gmail.com','lol'),(3,'kek','kek',1000,1,'kek@gmail.com','kek'),(4,'John','Smith',1500,1,'',''),(8,'Jomn','Smittth',1500000,2,'ya@kl.qwer','123'),(9,'Jomn','Smittth',1500000,2,'ya2@kl.qwer','123'),(10,'Jomn','Smittth',1500000,2,'ya123@kl.qwer','123'),(11,'Ivan','Ivanov',2222,2,'ivan@gmail.com','mypass');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-25 20:08:57

-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: book_Store
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account_status`
--

DROP TABLE IF EXISTS `account_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_status` (
  `Account_Status_Id` int NOT NULL,
  `Account_Status` varchar(20) NOT NULL,
  PRIMARY KEY (`Account_Status_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_status`
--

LOCK TABLES `account_status` WRITE;
/*!40000 ALTER TABLE `account_status` DISABLE KEYS */;
INSERT INTO `account_status` VALUES (1,'Inactive'),(2,'Active'),(3,'Suspended');
/*!40000 ALTER TABLE `account_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_type`
--

DROP TABLE IF EXISTS `account_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_type` (
  `Account_Type_Id` int NOT NULL,
  `Account_Type` varchar(20) NOT NULL,
  PRIMARY KEY (`Account_Type_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_type`
--

LOCK TABLES `account_type` WRITE;
/*!40000 ALTER TABLE `account_type` DISABLE KEYS */;
INSERT INTO `account_type` VALUES (1,'Customer'),(2,'Admin');
/*!40000 ALTER TABLE `account_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `BookID` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `author` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `category` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `publisher` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Publication_Year` date DEFAULT NULL,
  `edition` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `buying_price` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `image_data` longblob,
  PRIMARY KEY (`BookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books_featured_topsellers`
--

DROP TABLE IF EXISTS `books_featured_topsellers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books_featured_topsellers` (
  `BookID` int NOT NULL,
  `is_featured` tinyint(1) DEFAULT NULL,
  `is_topSeller` tinyint(1) DEFAULT NULL,
  `is_newbook` bit(1) NOT NULL,
  `is_top_seller` bit(1) NOT NULL,
  PRIMARY KEY (`BookID`),
  CONSTRAINT `books_featured_topsellers_ibfk_1` FOREIGN KEY (`BookID`) REFERENCES `books` (`BookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_featured_topsellers`
--

LOCK TABLES `books_featured_topsellers` WRITE;
/*!40000 ALTER TABLE `books_featured_topsellers` DISABLE KEYS */;
/*!40000 ALTER TABLE `books_featured_topsellers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_books`
--

DROP TABLE IF EXISTS `cart_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_books` (
  `Cart_Book_ID` int NOT NULL AUTO_INCREMENT,
  `CartID` int NOT NULL,
  `BookID` int NOT NULL,
  `Quantity` int DEFAULT NULL,
  `Price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`Cart_Book_ID`),
  KEY `fk_book` (`BookID`),
  KEY `fk_cart` (`CartID`),
  CONSTRAINT `fk_book` FOREIGN KEY (`BookID`) REFERENCES `books` (`BookID`),
  CONSTRAINT `fk_cart` FOREIGN KEY (`CartID`) REFERENCES `shopping_cart` (`Cart_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_books`
--

LOCK TABLES `cart_books` WRITE;
/*!40000 ALTER TABLE `cart_books` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitems`
--

DROP TABLE IF EXISTS `orderitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderitems` (
  `Order_Item_ID` int NOT NULL AUTO_INCREMENT,
  `Order_Id` int DEFAULT NULL,
  `Book_Id` int DEFAULT NULL,
  `Quantity` int NOT NULL,
  `Price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`Order_Item_ID`),
  KEY `OrderID` (`Order_Id`),
  KEY `BookID` (`Book_Id`),
  CONSTRAINT `orderitems_ibfk_1` FOREIGN KEY (`Order_Id`) REFERENCES `orders` (`Order_ID`),
  CONSTRAINT `orderitems_ibfk_2` FOREIGN KEY (`Book_Id`) REFERENCES `books` (`BookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitems`
--

LOCK TABLES `orderitems` WRITE;
/*!40000 ALTER TABLE `orderitems` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `Order_ID` int NOT NULL AUTO_INCREMENT,
  `User_Id` int DEFAULT NULL,
  `Order_Date` datetime DEFAULT NULL,
  `Total_Amount` decimal(10,2) DEFAULT NULL,
  `Address_Id` int DEFAULT NULL,
  `Payment_Id` int DEFAULT NULL,
  `Order_Status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Confirmation_Email_Sent` tinyint DEFAULT NULL,
  `Confirmation_Number` int NOT NULL,
  `Promo_Code` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`Order_ID`),
  KEY `orders_ibfk_1` (`User_Id`),
  KEY `orders_ibfk_2` (`Address_Id`),
  KEY `orders_ibfk_3` (`Payment_Id`),
  KEY `fk_promo_Code` (`Promo_Code`),
  CONSTRAINT `fk_promo_Code` FOREIGN KEY (`Promo_Code`) REFERENCES `promotions` (`Promo_Code`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`User_Id`) REFERENCES `users` (`User_ID`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`Address_Id`) REFERENCES `shipping_address` (`Address_Id`),
  CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`Payment_Id`) REFERENCES `payment_cards` (`Payment_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_cards`
--

DROP TABLE IF EXISTS `payment_cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_cards` (
  `Payment_Id` int NOT NULL AUTO_INCREMENT,
  `card_number` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `card_holder` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `card_type` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `User_ID` int DEFAULT NULL,
  `exp_date` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`Payment_Id`),
  KEY `paymentcards_ibfk_1` (`User_ID`),
  CONSTRAINT `fk_cards_1` FOREIGN KEY (`User_ID`) REFERENCES `users` (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_cards`
--

LOCK TABLES `payment_cards` WRITE;
/*!40000 ALTER TABLE `payment_cards` DISABLE KEYS */;
INSERT INTO `payment_cards` VALUES (1,'1234567890123456','chaitu','Debit',NULL,'12/23'),(9,'1234567890123456','Addaaaadsdsdaa','Debit',8,'12/25'),(10,'','','',9,''),(13,'','','',12,''),(14,'','','',13,''),(15,'','','',4,'');
/*!40000 ALTER TABLE `payment_cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotions`
--

DROP TABLE IF EXISTS `promotions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promotions` (
  `Promo_Code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Start_Date` date DEFAULT NULL,
  `Expiry_Date` date DEFAULT NULL,
  `Percentage` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`Promo_Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotions`
--

LOCK TABLES `promotions` WRITE;
/*!40000 ALTER TABLE `promotions` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_address`
--

DROP TABLE IF EXISTS `shipping_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipping_address` (
  `Address_Id` int NOT NULL AUTO_INCREMENT,
  `street` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `city` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `state` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `zip_code` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `User_ID` int DEFAULT NULL,
  PRIMARY KEY (`Address_Id`),
  KEY `shippingaddress_ibfk_1_idx` (`User_ID`),
  CONSTRAINT `shippingaddress_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `users` (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_address`
--

LOCK TABLES `shipping_address` WRITE;
/*!40000 ALTER TABLE `shipping_address` DISABLE KEYS */;
INSERT INTO `shipping_address` VALUES (1,'1000 Lakeside Dr','Athens','Georgia',NULL,NULL),(2,'1001 Lakeside Dr','Athens','Georgia',NULL,NULL),(3,'1001 Lakeside Dr','Athens','Georgia','30605',4),(4,'10012 Lakeside Dr','Athens','Georgia','30605',8),(5,'','','','',9),(8,'','','','',12),(9,'','','','',13);
/*!40000 ALTER TABLE `shipping_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping_cart` (
  `Cart_Id` int NOT NULL AUTO_INCREMENT,
  `User_Id` int DEFAULT NULL,
  PRIMARY KEY (`Cart_Id`),
  KEY `shoppingcart_ibfk_1` (`User_Id`),
  CONSTRAINT `shoppingcart_ibfk_1` FOREIGN KEY (`User_Id`) REFERENCES `users` (`User_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `User_ID` int NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `Account_Status_Id` int DEFAULT NULL,
  `account_type_id` enum('ADMIN','CUSTOMER') COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Subscribe_To_Promotions` int DEFAULT NULL,
  `Mobile_Number` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `subscribe_to_promo` bit(1) NOT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `otp_code` int NOT NULL,
  PRIMARY KEY (`User_ID`),
  KEY `fk_account_status` (`Account_Status_Id`),
  CONSTRAINT `fk_account_status` FOREIGN KEY (`Account_Status_Id`) REFERENCES `account_status` (`Account_Status_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'Doe','John','$2a$10$WbHH7H3nnxExhozGp31JNe6nS27cfcvV0F/2Nf6aMwDRowelrDXYa','johndoe@example.com',1,'ADMIN',NULL,'1234567890',_binary '','johndoe',140647),(4,'aaerw','aeeq','$2a$10$R/z7P52j1TVHv4xIo2UhSuZ4qQp5v0L70uwERKUtQBkpw0L3fag/O','chaitu@example.com',2,'CUSTOMER',NULL,'1234567890',_binary '','chaitu',102497),(5,'B','John','$2a$10$2YrRJK5BbCIJxMDWzZbKJ.Wvyps/8G4fBwJi6I0QGDwU.A/1xhS2u','john@example.com',1,'CUSTOMER',NULL,'1234567890',_binary '','john',127601),(8,'Baaaaadaaa','Addaaaadsdsdaa','$2a$10$./cPzXH8xt1W3bp5mxIJx.MBX35o5IHaoMs.8FA5uh6kLLLSgY.nC','chaitanya392k@gmail.com',1,'CUSTOMER',NULL,'1234567890',_binary '','abcaaaaaa',150850),(9,'aandn','aifiw','$2a$10$O.RjGgfKy77pXXcrF1M6E.wvzSf7eDcwnK0OiTiEekjeqHpX/xS3m','revanthbgmi@gmail.com',1,'CUSTOMER',NULL,'1234567890',_binary '','aff',105331),(12,'aadff','add','$2a$10$9381vW7eZEgC3nJPi7t0KORioY2CqPu7z.ntqvsFHfCNgUqEbTLei','chaitu392chaitu@gmail.com',1,'CUSTOMER',NULL,'1234567890',_binary '','addfgg',138397),(13,'aaerw','aeeq','$2a$10$L9gf33bDHnQ7vRva/2LnkeEookCAKq9WWwwqE2AFF05Cux5WhL9La','revanthkoganti@gmail.com',1,'CUSTOMER',NULL,'1234567890',_binary '','aeeeqw',108266);
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

-- Dump completed on 2023-07-15 16:33:10

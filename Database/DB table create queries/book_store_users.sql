-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: book_store
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `User_ID` int NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `first_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Account_Status_Id` int DEFAULT NULL,
  `account_type_id` enum('ADMIN','CUSTOMER') COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Mobile_Number` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `subscribe_to_promo` bit(1) NOT NULL DEFAULT b'0',
  `otp_code` int NOT NULL,
  PRIMARY KEY (`User_ID`),
  KEY `fk_account_status` (`Account_Status_Id`),
  CONSTRAINT `fk_account_status` FOREIGN KEY (`Account_Status_Id`) REFERENCES `account_status` (`Account_Status_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (44,'Koganti','Revanth','$2a$10$OYEyegBBHEoZ/XuuTq0GWuJASr0LOLFCg4HZDw9JF6LQH11cuysVe','revanthkoganti@gmail.com',2,'CUSTOMER','4043996253',_binary '\0',113926),(45,'K','revanth','$2a$10$WWxYtO5DpdTkdHuaSEKYDOyvixXgGZ/QJn8QXjtC3aDWuB.y3damO','revanthkoganti1997@gmail.com',2,'ADMIN','4043996251',_binary '',189182),(46,'Krishna','Chaitanya','$2a$10$K2rDImLGg4dIehpSbrIzc.tbCo1ZvdZaFyaPJIzcS2EtWQKCkU9yO','revanthbgmi@gmail.com',1,'CUSTOMER','4043996251',_binary '',146017),(47,'gude','sai','$2a$10$bbYdejEYcTuWk1ViyHcaq.f60qDgSx8omILT32HXbPeJ7EeXk.wkW','saaigude@gmail.com',2,'CUSTOMER','7013458714',_binary '\0',127814);
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

-- Dump completed on 2023-07-19  0:07:51

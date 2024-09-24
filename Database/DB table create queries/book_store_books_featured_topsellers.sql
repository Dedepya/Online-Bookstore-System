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
-- Table structure for table `books_featured_topsellers`
--

DROP TABLE IF EXISTS `books_featured_topsellers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books_featured_topsellers` (
  `BookID` int NOT NULL,
  `featured` bit(1) NOT NULL,
  `topseller` bit(1) NOT NULL,
  `newbook` bit(1) NOT NULL,
  PRIMARY KEY (`BookID`),
  CONSTRAINT `books_featured_topsellers_ibfk_1` FOREIGN KEY (`BookID`) REFERENCES `books` (`BookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_featured_topsellers`
--

LOCK TABLES `books_featured_topsellers` WRITE;
/*!40000 ALTER TABLE `books_featured_topsellers` DISABLE KEYS */;
INSERT INTO `books_featured_topsellers` VALUES (1,_binary '',_binary '',_binary ''),(2,_binary '\0',_binary '\0',_binary ''),(3,_binary '',_binary '\0',_binary '\0'),(4,_binary '\0',_binary '',_binary '\0'),(5,_binary '\0',_binary '\0',_binary ''),(6,_binary '',_binary '',_binary '\0'),(7,_binary '\0',_binary '',_binary '\0'),(8,_binary '',_binary '\0',_binary ''),(9,_binary '\0',_binary '\0',_binary '\0'),(10,_binary '',_binary '',_binary ''),(11,_binary '',_binary '\0',_binary '\0'),(12,_binary '\0',_binary '',_binary '\0'),(13,_binary '',_binary '\0',_binary ''),(14,_binary '\0',_binary '\0',_binary ''),(15,_binary '\0',_binary '',_binary ''),(16,_binary '',_binary '',_binary '\0'),(18,_binary '\0',_binary '',_binary ''),(19,_binary '',_binary '\0',_binary '');
/*!40000 ALTER TABLE `books_featured_topsellers` ENABLE KEYS */;
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

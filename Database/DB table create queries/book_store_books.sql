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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `BookID` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `publisher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Publication_Year` date DEFAULT NULL,
  `edition` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `buying_price` double DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `description` longtext COLLATE utf8mb4_general_ci,
  `image_data` longtext COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`BookID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'9788173711466','Ikigai: The Japanese Secret to a Long and Happy Life','Héctor García,Francesc Miralles','Motivation','Penguin Life','1969-12-31','1st',12,15,10,'Reading books is a kind of enjoyment. Reading books is a good habit. We bring you a different kinds of books. You can carry this book where ever you want. It is easy to carry. It can be an ideal gift to yourself and to your loved ones. Care instruction k...','https://m.media-amazon.com/images/I/41mtUoTi8ZL._SY291_BO1,204,203,200_QL40_FMwebp_.jpg'),(2,'143130722','The Undefeated Mind: On the Science of Constructing an Indestructible Self','Dr. Alex Lickerman MDs','Motivation','Audible Studios','1969-12-31','Illustrated',15.5,18.45,8,'Discover your ikigai, pronounced ee-key-guy, and unlock a longer, more fulfilling life filled with purpose and joy. With over 1.5 million copies sold worldwide, this international bestseller has captivated readers seeking a more meaningful existence. Bus...','https://m.media-amazon.com/images/I/81TtmBVI4xL._AC_UY327_FMwebp_QL65_.jpg'),(3,'1590035003','The Silent Patient','Alex Michaelides','Suspense','Macmillan Audio','1969-12-31','20th',11.8,13.99,7,'A new edition of the #1 NYT’s bestseller by Mark Nepo, who has been called “one of the finest spiritual guides of our time” and “a consummate storyteller.” Philosopher-poet and cancer survivor Mark Nepo opens a new season of freedom and joy―a...','https://m.media-amazon.com/images/I/91BbLCJOruL._AC_UY327_FMwebp_QL65_.jpg'),(4,'1544534078','Then She Was Gone: A Novel','Lisa Jewell','Suspense','H. D.Jack','1969-12-31','1st',11.8,13.99,7,'In Never Finished David Goggins eye-opening memoir, he goes beyond his bestselling book, Can\'t Hurt Me, to awaken readers to the untapped potential within themselves. Goggins invites you into his Mental Lab, unveiling the philosophy, psychology, and stra...','https://m.media-amazon.com/images/I/81BrOpm6KXL._AC_UY327_FMwebp_QL65_.jpg'),(5,'757316425','Where the Forest Meets the Stars','Lucinda Berry','Suspense','H. D.J','1969-12-31','1st',15.8,17.89,50,'While many self-help authors emphasize personal development for happiness, they often overlook the crucial aspect of cultivating hardiness. However, new scientific research reveals that resilience can be developed through intentional actions. Dr. Alex Li...','https://m.media-amazon.com/images/I/918hXn4Uy1L._AC_UY327_FMwebp_QL65_.jpg'),(6,'125030170X','The Perfect Child','Lucinda Berry','Suspense','H. D.J','1969-12-31','2nd',10.8,13,20,'Immerse yourself in the gripping psychological thriller, The Housemaid\'s Secret by Freida McFadden, where secrets and suspense lurk within the luxurious penthouse of the enigmatic Garrick family. As the new housemaid, the protagonist uncovers unsettling...','https://m.media-amazon.com/images/I/61zk+N+qRcL._AC_UY327_FMwebp_QL65_.jpg'),(7,'1538742578','The Housemaid','Freida McFadden','Suspense','Hachette UK - Bookouture','1969-12-31','2nd',15.3,20,45,'Get ready for the addictive and bestselling psychological thriller, The Housemaid by Freida McFadden, as it takes the literary world by storm. Immerse yourself in the gripping story of a housemaid entangled in a web of secrets, manipulation, and a twist...','https://m.media-amazon.com/images/I/81WduXjuKwL._AC_UY327_FMwebp_QL65_.jpg'),(8,'1957635010','Never Finished: Unshackle Your Mind and Win the War Within','David Goggins','Motivation','Lioncrest Publishing','1969-12-31','2nd',9.3,15.97,0,'Experience the thrilling conclusion to the Cat and Mouse Duet with The Diamond and The Hunter. As the characters navigate a treacherous world of deception and betrayal, they fight to reclaim their identities and seek justice. Prepare for intense action,...','https://m.media-amazon.com/images/I/81hwru1zPNL._AC_UY327_FMwebp_QL65_.jpg'),(9,'1957635010','The Book of Awakening: Having the Life You Want by Being Present to the Life You Have','Mark Nepo','Motivation','Red Wheel','1969-12-31','2nd',9.3,15.97,12,'Experience the thrilling conclusion to the Cat and Mouse Duet with The Diamond and The Hunter. As the characters navigate a treacherous world of deception and betrayal, they fight to reclaim their identities and seek justice. Prepare for intense action,...','https://m.media-amazon.com/images/I/81JtkVD7g6L._AC_UY327_FMwebp_QL65_.jpg'),(10,'1501154656','Hunting Adeline (Cat and Mouse Duet)','H. D. Carlton','Suspense','H. D. Carlton','1969-12-31','Reprint',9.3,11.34,12,'#1 NEW YORK TIMES BESTSELLER From the New York Times bestselling author of Invisible Girl and The Truth About Melody Browne comes a “riveting” (PopSugar) and “acutely observed family drama” (People) that delves into the lingering afterma...','https://m.media-amazon.com/images/I/61KiXD7flWL._AC_UY327_FMwebp_QL65_.jpg'),(11,'1503905128','Hunting Adeline (Cat and Mouse Duet)','H. D. Carlton','Suspense','H. D.Jack','1969-12-31','Reprint',7.3,10.99,12,'#1 NEW YORK TIMES BESTSELLER From the New York Times bestselling author of Invisible Girl and The Truth About Melody Browne comes a “riveting” (PopSugar) and “acutely observed family drama” (People) that delves into the lingering afterma...','https://m.media-amazon.com/images/I/71hARpTz6mL._AC_UY327_FMwebp_QL65_.jpg'),(12,'1503904911','Python Book','Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein','Computer Science','The MIT Press','1969-12-31','Reprint',8.3,19.09,12,'Immerse yourself in the mesmerizing and acclaimed debut novel, where two strangers find solace and love in the presence of a mysterious child. Jo, recovering from loss and illness, welcomes Ursa into her life, a girl claiming to be from the stars and se...','https://m.media-amazon.com/images/I/8118skNqi1L._AC_UL480_FMwebp_QL65_.jpg'),(13,'9781234567890','Selling-Ethically','F. Scott Fitzgerald','Classic Literature','Scribner','1969-12-31','1st',15.99,24.99,10,'A captivating story that will keep you hooked from beginning to end.','https://m.media-amazon.com/images/I/51QHeoLhUnL._AC_UY327_FMwebp_QL65_.jpg'),(14,'978-3-16-148410-0','parent-and-teacher-guides','F. Scott Fitzgerald','Educational Resources','Scribner','1969-12-31','First Edition',10.99,14.99,25,'The Great Gatsby is a classic American novel that explores themes of wealth, love, and the American Dream during the Roaring Twenties.','https://m.media-amazon.com/images/I/71OdIpJQimL._AC_UY327_FMwebp_QL65_.jpg'),(15,'978-0-13-449416-6','Take Back Control','Stieg Larsson','Drama','Vintage Crime/Black Lizard','1969-12-31','3rd',35.99,49.99,10,'Introduction to Algorithms provides a comprehensive introduction to the study of algorithms. It covers a broad range of topics and serves as a fundamental resource for students and professionals in the field of computer science.','https://m.media-amazon.com/images/I/81q68ELuKyL._AC_UY327_FMwebp_QL65_.jpg'),(16,'978-0-553-57340-1','Dune','Frank Herbert','fantasy','Ace Books','1969-12-31','First Edition',10.99,14.99,50,'The Great Gatsby is a novel written by F. Scott Fitzgerald that explores themes of wealth, love, and the American Dream during the Roaring Twenties.','https://m.media-amazon.com/images/I/91SYX-l-LmL._AC_UY327_FMwebp_QL65_.jpg'),(18,'9781234567890','The universe inside here','John Doe','fantasy','ABC Publishing','1969-12-31','Paperback Edition',8.99,14.99,25,'A gripping mystery featuring a complex female protagonist and a dark investigation.','https://m.media-amazon.com/images/I/81opEgWVxFL._AC_UY327_FMwebp_QL65_.jpg'),(19,'9780451450522','Wings of fire: An autobiography','A. P. J. Abdul Kalam','Motivation','Sangam Books Ltd','1969-12-31','Special Edition',12.99,19.99,30,'A science fiction epic set in a distant future on a desert planet.','https://m.media-amazon.com/images/I/61M4NTWpw7L._AC_UY327_FMwebp_QL65_.jpg');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-19  0:07:50

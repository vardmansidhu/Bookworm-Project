-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: bookworm_v1
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `beneficiary`
--

DROP TABLE IF EXISTS `beneficiary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beneficiary` (
  `ben_id` int NOT NULL AUTO_INCREMENT,
  `ifsc` varchar(255) DEFAULT NULL,
  `pan` varchar(255) DEFAULT NULL,
  `acc_no` varchar(255) DEFAULT NULL,
  `acc_type` varchar(255) DEFAULT NULL,
  `bank_branch` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `ben_name` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ben_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beneficiary`
--

LOCK TABLES `beneficiary` WRITE;
/*!40000 ALTER TABLE `beneficiary` DISABLE KEYS */;
INSERT INTO `beneficiary` VALUES (1,'SBI0000069','AFCGN9634F','40030873','Savings','Parel','SBI','Vardman Sidhu','8928247542','vardmansidhu@gmail.com'),(2,'SRCB0000404','DDGRL3640X','35285624','Savings','Lower Parel','SRCB','Kunal Dhanawade','9082229389','Kunaldhanawade7@gmail.com'),(3,'MAHB0000420','EHCSH4837V','35284528','Savings','Amravati','MAHB','vedant Dhadange','8830837062','vedantsd123@gmail.com');
/*!40000 ALTER TABLE `beneficiary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL AUTO_INCREMENT,
  `contact_no` varchar(255) DEFAULT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `points_remaining` int NOT NULL,
  `points_used` int NOT NULL,
  `total_points` int NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,NULL,NULL,NULL,'2024-01-07','kunal@07',0,0,0),(2,'8830837062','vedantsd1@gmail.com','Vedant Dhadange','2024-02-14','vd123',0,0,0),(3,'09998887776','omkar@gmail.com','Omkar','2024-02-01','omk',0,0,0),(4,'09998887776','omkar@gmail.com','Omkar','2024-02-01','omk',0,0,0),(5,'9082229389','kunaldhanawade7@gmail.com','Kunal Dhanawade','2001-11-07','kd07',0,0,0),(6,'9999999999','avon8444@gmail.com','Avon Smith','2000-01-01','powershot',0,0,0),(7,'123','lodamera@gmail.com','Abracadabra','2024-02-23','asdf',0,0,0),(8,'123','choothmaarni@com','Sparshchhabra','2024-02-23','asdf',0,0,0),(9,'8928247542','vardmansidhu@gmail.com','Vardman Sidhu','2000-08-26','powershot',0,0,0),(11,'321654','hello@gmail.com','asdf asdf','2024-02-21','asdf',0,0,0),(12,'32164','test@hotmail.com','asdf asdf','2024-02-23','asdf',0,0,0),(13,'321','asdf@gmail.com','Avon Smith','2024-02-22','asdf',0,0,0),(14,'321654','asdf@gmail.com','Avon Smith','2024-02-21','asdf',0,0,0);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_attribute`
--

DROP TABLE IF EXISTS `customer_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_attribute` (
  `cust_att_id` int NOT NULL AUTO_INCREMENT,
  `attribute_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_att_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_attribute`
--

LOCK TABLES `customer_attribute` WRITE;
/*!40000 ALTER TABLE `customer_attribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_preferences`
--

DROP TABLE IF EXISTS `customer_preferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_preferences` (
  `cust_details_id` int NOT NULL AUTO_INCREMENT,
  `attribute_value` varchar(255) DEFAULT NULL,
  `cust_att_cust_att_id` int DEFAULT NULL,
  `customer_customer_id` int DEFAULT NULL,
  PRIMARY KEY (`cust_details_id`),
  KEY `FKm6wlthwlgr0r4c137q47f67r8` (`cust_att_cust_att_id`),
  KEY `FK38294bqc9pb9owix8o9qw7sbf` (`customer_customer_id`),
  CONSTRAINT `FK38294bqc9pb9owix8o9qw7sbf` FOREIGN KEY (`customer_customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `FKm6wlthwlgr0r4c137q47f67r8` FOREIGN KEY (`cust_att_cust_att_id`) REFERENCES `customer_attribute` (`cust_att_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_preferences`
--

LOCK TABLES `customer_preferences` WRITE;
/*!40000 ALTER TABLE `customer_preferences` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_preferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genre` (
  `genre_id` int NOT NULL AUTO_INCREMENT,
  `genre_desc` varchar(255) DEFAULT NULL,
  `language_id` int DEFAULT NULL,
  PRIMARY KEY (`genre_id`),
  KEY `FKelksj2rqr5r0jkf0tds4cwreh` (`language_id`),
  CONSTRAINT `FKelksj2rqr5r0jkf0tds4cwreh` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (1,'Science Fiction',2),(2,'Novel',1),(3,'Mystery',2),(4,'Drama',3),(5,'Political Drama',1),(6,'Fantasy',1),(7,'Fantasy',3),(8,'Fantasy',4),(9,'Spiritual',5),(10,'Poetry',1),(11,'Suspense',4),(12,'Novel',2),(13,'Suspense',1),(14,'Educational',1);
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `invoice_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `invoice_amount` float DEFAULT NULL,
  `invoice_date` datetime(6) DEFAULT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (42,6,380,'2024-02-25 00:00:00.000000',8),(43,6,40,'2024-02-25 00:00:00.000000',1),(44,6,40,'2024-02-25 00:00:00.000000',1);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice_details`
--

DROP TABLE IF EXISTS `invoice_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice_details` (
  `inv_dtl_id` int NOT NULL AUTO_INCREMENT,
  `base_price` double DEFAULT NULL,
  `renting_days` int DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `invoice_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `transaction_type_id` bigint DEFAULT NULL,
  PRIMARY KEY (`inv_dtl_id`),
  KEY `FKpc7xa72mljy7weoct7uubgjy7` (`invoice_id`),
  KEY `FKswgjrgy5eebhfkmm7bliiyw71` (`product_id`),
  KEY `FK38y1vpp4oi5wj6r6uokjxd5q0` (`transaction_type_id`),
  CONSTRAINT `FKpc7xa72mljy7weoct7uubgjy7` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`invoice_id`),
  CONSTRAINT `FKswgjrgy5eebhfkmm7bliiyw71` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `invoice_details_ibfk_1` FOREIGN KEY (`transaction_type_id`) REFERENCES `transaction_type` (`transaction_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice_details`
--

LOCK TABLES `invoice_details` WRITE;
/*!40000 ALTER TABLE `invoice_details` DISABLE KEYS */;
INSERT INTO `invoice_details` VALUES (1,70,0,40,42,11,1),(2,70,0,30,42,10,1),(3,87,0,50,42,5,1),(4,70,0,30,42,12,1),(5,80,0,50,42,8,1),(6,70,0,50,42,3,1),(7,70,0,40,42,7,1),(8,100,0,90,42,4,1),(9,70,NULL,40,43,9,1),(10,50,NULL,40,44,15,1);
/*!40000 ALTER TABLE `invoice_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `language` (
  `language_id` int NOT NULL AUTO_INCREMENT,
  `language_desc` varchar(255) DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  PRIMARY KEY (`language_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES (1,'Marathi',1),(2,'English',2),(3,'English',1),(4,'Marathi',3),(5,'Hindi',1);
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mylibrary`
--

DROP TABLE IF EXISTS `mylibrary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mylibrary` (
  `library_id` int NOT NULL AUTO_INCREMENT,
  `end_date` datetime(6) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `transaction_type` bigint DEFAULT NULL,
  PRIMARY KEY (`library_id`),
  KEY `FKl69h7l61m2n3c2dalf8lukc7` (`customer_id`),
  KEY `FKboidi3fr7f88k1un7f7c8aboc` (`product_id`),
  KEY `FKbcov75p8m9y956evgneuiq91l` (`transaction_type`),
  CONSTRAINT `FKbcov75p8m9y956evgneuiq91l` FOREIGN KEY (`transaction_type`) REFERENCES `transaction_type` (`transaction_type_id`),
  CONSTRAINT `FKboidi3fr7f88k1un7f7c8aboc` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FKl69h7l61m2n3c2dalf8lukc7` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mylibrary`
--

LOCK TABLES `mylibrary` WRITE;
/*!40000 ALTER TABLE `mylibrary` DISABLE KEYS */;
/*!40000 ALTER TABLE `mylibrary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myshelf`
--

DROP TABLE IF EXISTS `myshelf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `myshelf` (
  `shelf_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `expiry_date` datetime(6) DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `transaction_type_id` int DEFAULT NULL,
  PRIMARY KEY (`shelf_id`),
  KEY `FK31hlwgdji49ppua3v2mtl07hy` (`product_id`),
  CONSTRAINT `FK31hlwgdji49ppua3v2mtl07hy` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myshelf`
--

LOCK TABLES `myshelf` WRITE;
/*!40000 ALTER TABLE `myshelf` DISABLE KEYS */;
INSERT INTO `myshelf` VALUES (1,6,NULL,_binary '',5,1),(2,6,NULL,_binary '',11,1),(3,6,NULL,_binary '',10,1),(4,6,NULL,_binary '',3,1),(5,6,NULL,_binary '',8,1),(6,6,NULL,_binary '',12,1),(7,6,NULL,_binary '',7,1),(8,6,NULL,_binary '',4,1),(9,6,NULL,_binary '',9,1),(10,6,NULL,_binary '',15,1);
/*!40000 ALTER TABLE `myshelf` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(13) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `base_price` float DEFAULT NULL,
  `is_library` bit(1) DEFAULT NULL,
  `is_rentable` bit(1) DEFAULT NULL,
  `long_desc` mediumtext,
  `min_rent_days` int DEFAULT NULL,
  `offer_exp_date` datetime(6) DEFAULT NULL,
  `offer_price` float DEFAULT NULL,
  `product_eng_name` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `rent_per_day` float DEFAULT NULL,
  `short_desc` text,
  `special_cost` float DEFAULT NULL,
  `genre_id` int DEFAULT NULL,
  `language_id` int DEFAULT NULL,
  `type_id` int DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKlgp6x71g08sy3a84mur67uuht` (`genre_id`),
  KEY `FKe7cpbpxindm6xcdy0g3d2aq6q` (`language_id`),
  KEY `FKajjopj7ffr42w11bav8gut0cp` (`type_id`),
  CONSTRAINT `FKajjopj7ffr42w11bav8gut0cp` FOREIGN KEY (`type_id`) REFERENCES `product_type` (`type_id`),
  CONSTRAINT `FKe7cpbpxindm6xcdy0g3d2aq6q` FOREIGN KEY (`language_id`) REFERENCES `language` (`language_id`),
  CONSTRAINT `FKlgp6x71g08sy3a84mur67uuht` FOREIGN KEY (`genre_id`) REFERENCES `genre` (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'8980735267095','Dr. Deepak Ranade',70,_binary '\0',_binary '\0','Publisher Carl Sagan in The Demon-Haunted World:Science as a Candle in the Dark, says Science is not only compatible with spirituality; it is a profound source of spirituality. Well these words were ringing in my ears when I was hearing Dr. Deepak Ranade speaking about his theme of &ldquo;The Whispering Woods. The title of the book itself invigorates our thought process. Whispering Woods! Yes trees whisper, they have thoughts and they express. Hermann Hesse says , Trees have long thoughts, long-breathing and restful, just as they have longer lives than ours. They are wiser than we are, as long as we do not listen to them. But when we have learned how to listen to trees, then the brevity and the quickness and the childlike hastiness of our thoughts achieve an incomparable joy. Whoever has learned how to listen to trees no longer wants to be a tree. He wants to be nothing except what he is. That is home. That is happiness. During the process of evolution, mankind gave many shapes and forms to the concept of God and unfortunately this concept ended up in myth.&nbsp; That was very easy since then little was to be explained to the curious mind.But Dr.Deepak Ranade is a seeker of knowledge. And in his quest for knowledge he has read Dnyaneshwar Maharaj (Maauli as refered with reverence) and tried to co-relate science with spirituality. He has attempted to unravel this myth called God. He says,This is a journey which has taught me that I am but a few steps into the vast expanses of what constitutes our understanding but also that paths reveal themselves when the seeker begins his journey.\nSrujan takes pride in presenting Dr. Deepak Ranade, a Neuro Surgeon by profession through his book The Whispering Woods&rdquo; which is a collection of articles published in Times of&nbsp; India under the column &ldquo;Speaking Trees',30,'2024-01-31 18:30:00.000000',30,'The Whispering Woods','The Whispering Woods','Sujan Dreams Pvt. Ltd.',10,'In his pursuit of knowledge, the author intertwines science and spirituality, demystifying God in The Whispering Woods.',50,1,2,2),(3,'8980735267095','????????? ????????',70,_binary '\0',_binary '\0','?????. ????????????? ?????????? ???????? ?????? ???????? ??? ???? ??? ???? ??? ????. ?? ????????? ???? ??????? ?? ?? ????? ?????. ??? ??????? ???? ?? ?????? ??? ?????? ???? ?????? ?????. ?? ?? ???? ?????? ???? ???? ?? ?????? ???? ?????? ???. ?????? ???? ????????? ?????? ???????? ????? ????? ????. ???? ?? ??????? ?????? ??????????? ????? ?? ???? ?????? ????. ?? ??? ?? ?????? ???? ??????? ?????????? ??? ????. ???????? ??????? ??? ....???????? ??????? ??????? ??? ???????? ??????? ??? ????? ?????. ????? ???? ?? ????????? ???????????? ???? ????? ?? ???? ?????? ????. ??????? ?????????? ??? ??????? ????? ???? ?? ?? ???? ????. ???????? ???????????? ?????? ??????? ?????? ??????? ??????????? ???? ???? ??? ??? ?????? ???? ??????? ?????????? ????????? ????? ??????????? ????? ???? ???. ???? ?????? ????? ??? ????. ???? ????????? ????? ???? ??? ?? ?????? ???? ??? ??? ??????? ??????? ?????. ??? ??????? ???????????? ????????? ???? ?? ?????? ?????? ???? ???? ???. ????????? ???????? ?? ??? ????? ?????????? ??? ??????? ?????? ???. ??????????, ?????????, ????, ???, ???????????? ???? ?????? ????, ??????? ???? ??? ????? ????????? ???? ??? ???? ?????? ????????? ????? ??? ??? ????? ???? ?????? ???????????. ?? ?????? ???? ???? ??? ????? ?? ??? ?????? ?????. ??? ???? ???????? ?????????? ???????? ????? ?????? ???? ?? ?????? ???. ????',30,'2024-01-31 05:30:00.000000',30,'Aatank','????','???? ??????? ????. ??',10,'?? ?? ???? ?????? ???? ???? ?? ?????? ???? ?????? ???. ?????? ???? ????????? ?????? ???????? ????? ????? ????. ???? ?? ??????? ?????? ??????????? ????? ?? ???? ?????? ????. ?? ??? ?? ?????? ???? ??????? ?????????? ??? ????',50,2,1,1),(4,'3648735263549',' Marie Belloc Lowndes',100,_binary '\0',_binary '\0','The Lodger by Marie Belloc Lowndes was inspired by the Jack the Ripper murders. An older couple, the Buntings, are forced to take in lodgers to make ends meet. They are on the verge of starvation when a mysterious man, Mr. Sleuth, appears at their door and asks for lodging, paying in advance. However, when the murders of young women in London attributed to a man known only as &ldquo;The Avenger&rdquo; continue, the Buntings, particularly Mrs. Bunting, grow fearful that their lodger may be the murderer. Summary by Lee Ann Howlett.',0,'2024-02-29 05:30:00.000000',85,'The Lodger','The Lodger','???? ??????? ????. ??',0,'A haunting mystery tale that revolves around the Jack the Ripper murders, this novel was the basis for several films.',90,3,3,1),(5,'8980735267095','?????? ?????',87,_binary '\0',_binary '\0','Dive into an enriching literary odyssey within the pages of this meticulously curated collection of one-act plays, where each narrative serves as a doorway to a realm of unique satisfaction, profound experience, and intellectual invigoration. Within the condensed yet impactful structure of each play, readers are treated to a diverse exploration of human emotions, relationships, and existential dilemmas. Beyond mere entertainment, this anthology becomes a tapestry of sublimation, distilling emotions into poignant moments that resonate long after the final act. As characters navigate the complexities of life, the collection offers a rich intellectual feast, stimulating the mind with nuanced dialogues and thought-provoking scenarios. Whether evoking laughter through sharp wit or unraveling the intricacies of identity, these plays aspire to do more than entertain; they aim to illuminate, challenge, and leave a lasting imprint on the reader\'s psyche. In this unique literary offering, the satisfaction derived is not only from individual narratives but from the collective impact, creating an immersive experience that energizes the mind and lingers in the realm of thought.',0,'2024-04-12 00:00:00.000000',60,'Induche Ghar Aani Itar Eknakika','?????? ?? ??? ??? ???????? ','Srujan Dreams',0,' Collection of one act plays which offers the reader unique satisfaction of experience, sublimation, and energize the mind. make it long.',50,4,3,1),(7,NULL,'????? ???? ',70,_binary '\0',_binary '\0','In the sacred dialogue between a seeker and a trusted confidant named Dhami, a diary becomes the canvas for a soul\'s unfiltered expression. Through inked strokes and vulnerable musings, this exchange unfolds as a transformative journey, where each entry weaves the tapestry of human experience. Dhami, unburdened by judgment, captures the essence of days and the evolution of the soul, serving as a timeless companion in the exploration of self-discovery. In this literary duet, the diary transcends its pages, becoming a cherished confidant, a silent witness to the dialogue between the human heart and the boundless canvas of possibility.',0,'2024-04-14 00:00:00.000000',50,'Dhami','???','Srujan Dreams',0,'Its a dialog with a diary called Dhami',40,6,1,1),(8,NULL,'????????? ????????',80,_binary '\0',_binary '\0','In the captivating theater of life, a suspenseful backdrop sets the stage for a compelling exploration of human relations. Characters, each a nuanced player, navigate a plot woven with threads of trust, betrayal, and unspoken desires. Against the backdrop of suspense, the drama unfolds, delving into the intricacies of love, friendship, and rivalry. Secrets held and revealed add layers to the narrative, intensifying the emotions and tensions within this enthralling performance. The play of human relations takes center stage, leaving audiences captivated by the unpredictable nature of the human experience.',0,'2024-05-01 00:00:00.000000',60,'Yes My Dear','??? ??? ????','Srujan Dreams',0,' A play of human relations on the backdrop od suspense',50,13,1,1),(9,NULL,'Uday Karnik ',70,_binary '\0',_binary '\0','In the literary tapestry woven by Uday Karnik, innovation takes center stage in a narrative that captivates from its very inception. The novel penned by Karnik is a testament to his unique storytelling prowess, marked by a remarkable blend of creativity and insight. At its core, the novel unfurls a compelling saga, guided by a protagonist whose role becomes pivotal in the unfolding drama meticulously crafted by the author. Karnik\'s artistry lies not only in the plot\'s intrigue but in the meticulous attention to detail that renders the narrative a vivid and immersive experience. The hero, a central figure in this literary odyssey, emerges not merely as a character but as a conduit through which the author explores the intricate dynamics of corporate life. With an astute eye, Karnik delves into the multifaceted experiences of an individual occupying a significant position within a company, peeling back the layers to expose the challenges, triumphs, and tribulations that come with such a role. The novel becomes a profound exploration into the human psyche, dissecting the various natures that coexist within the corporate realm. Karnik, with finesse and nuance, unveils the intricacies of interpersonal relationships, highlighting how diverse personalities contribute to the ebb and flow of corporate life. The narrative becomes a mirror reflecting the complex tapestry of human ambitions, ego, and the pursuit of personal goals at the expense of collective well-being. Uday Karnik\'s novel is a literary voyage that transcends the conventional boundaries of storytelling. It becomes an exploration of the human condition within the corporate landscape, offering readers not just a tale, but a profound reflection on the intricacies of ambition, the clash of personalities, and the far-reaching consequences of individual pursuits within the framework of an organizational structure.',0,'2024-05-19 00:00:00.000000',50,'A Commitment For Excellence','A Commitment For Excellence ','Srujan Dreams',0,'uday talks about the His hero in the novel has played a crucial role while Uday gives minute details about various experiences of a person holding power and ego to fulfill the goal for themselves',40,12,2,2),(10,NULL,'??????? ??????',70,_binary '\0',_binary '\0','????? ;????? ??????? ????? ???? ?????? ??????? ????? ?????? ???? ????... ???? ??? ????? ???????? ????? ??????????? ???????????? ???. ??? ???? ????? ????! ??? ??????? ?? ????? ????????? ?????? ????? ??? ?????? ?????. ???? ????? ??????? ??????, ?????? ?????? ??? ??????? ?????. ???? ??? ???! ??????????????? ????? ??????? ??????&nbsp; ????? ????? ????? ????? ??? ???????? ???? ????. ???? ?????? ??????? ?? ???????. ????????? ??????? ?????? ??????? ??? ????? ????? ???? ???. ?? ?????? ???? ??????? ????? ????. ???? ???? ????? ??????? ????????? ???????????? ???? ????? ??? ???? ??????? ???? ???...??? ?? ???? ????? ?????? ???? ???? ???? ?????. ????? ?? ??? ???? ???? ???? ??????? ????? ????? ???? ?? ???? ???? ??? ??? ???? ?????? ?????????? ???? ??? ??? ???? ????....????????? ???? ????? ?????? ????. ??. ????? ????? ??????? ??????? ???????? ??????? ???? ?? ?????? ????? ??? ??? ????? ??? ??? ??? ?????? ???. ?????? ??? ??? ?????? ????? ???????? ??? ??? ????????? ..?? ???? ????? ?? ???? ??????? ?? ?????? ??????? ???????? ?????.&nbsp; ??? ??. ????? ????? ??????? ?? ????? ???? ????? ??????? ??? ???? ??? ????.<??? ????, ??? ????, ??? ???? ???? ????? ?? ???? ??? ??????? ???? ???? ??? ????, ??? ????, ??? ????? ?????...??... ??? ????? ?????? ????? ????? ?? ?? ??? ???? ???...??? ????????? ?????? ...??????? ???????? ????? ????.',0,'2024-04-01 00:00:00.000000',40,'Agnisakha','????????','Kranti',0,'A Beautiful Reflection of Life, A captivating exploration of psychological behavior, offering readers a treat with its beautiful and powerful outlook, enhanced by a poetic structure that elevates the reading experience.',30,10,1,1),(11,NULL,'????????? ??????????? ',70,_binary '\0',_binary '\0','Embark on a profound journey towards inner serenity and tranquility with this illuminating guide, which serves as a compass for those seeking a harmonious and balanced life. Delving into the intricacies of the human experience, this comprehensive roadmap unveils the secrets to cultivating a sense of peace amidst life\'s tumultuous twists and turns. Woven with wisdom drawn from various spiritual and philosophical traditions, the guide provides practical insights and actionable steps to navigate the challenges that often disrupt the equilibrium of our existence. It gently encourages self-reflection, fostering a deeper understanding of one\'s own thoughts, emotions, and aspirations. Through the pages of this transformative manual, discover the art of mindfulness and the power of living in the present moment. Learn to navigate the complexities of relationships, both with oneself and with others, fostering connections that contribute to a sense of fulfillment and contentment. Uncover the significance of gratitude, resilience, and compassion as pillars supporting the structure of a peaceful and purposeful life. This guiding path isn\'t merely a collection of principles; it\'s an immersive exploration, offering anecdotes, practical exercises, and real-life examples to illustrate the profound impact of integrating these teachings into everyday life. Whether you\'re navigating the hustle and bustle of a busy city or seeking solace in the tranquility of nature, this guide provides versatile tools to adapt to diverse environments and circumstances.',0,'2024-05-31 00:00:00.000000',50,'Jivan Ki Gathaye','???? ?? ??? ?????? ','Srujan Dreams',0,'A guiding path to attain peace and tranquility in life',40,9,5,1),(12,NULL,'Shriniwas Narvekar',70,_binary '\0',_binary '\0','In the enchanting realm of her imagination, she is a captivating individual, a girl who has woven a world uniquely her own. This world is richly populated with characters who play vital roles in the tapestry of her existence. Grandparents, wise and affectionate, stand as pillars of support and fountains of cherished stories. Among her cherished companions is the ever-present and loyal Sampya, a steadfast friend who shares in the joys and trials of her journey. Yet, beyond these central figures, her world is further adorned by the vibrant presence of a diverse array of friends, each contributing their own hues to the canvas of her life. These friends, each with their distinct personalities and quirks, create a mosaic of shared laughter, shared dreams, and shared adventures. As she navigates the corridors of her imagination, this girl\'s world becomes a sanctuary of creativity, a space where every day is an opportunity for new discoveries and cherished moments with those who inhabit the landscapes of her mind. In her world, the ordinary transforms into the extraordinary, and each character, each nuance, becomes an essential thread in the narrative of a life beautifully and uniquely her own',0,'2024-01-31 00:00:00.000000',50,'Dekhave Naa Dola','????? ?? ????   ','Srujan Dreams',0,'Dekhave Naa Dolaa is a struggle of one person against the corrupt system with story Well carved out plot, powerful characters and catchy dialogues are main strengths of this play.',30,5,1,1),(13,NULL,'Madhavi Bhat',87,_binary '\0',_binary '\0','In the enchanting realm of her imagination, she is a captivating individual, a girl who has woven a world uniquely her own. This world is richly populated with characters who play vital roles in the tapestry of her existence. Grandparents, wise and affectionate, stand as pillars of support and fountains of cherished stories. Among her cherished companions is the ever-present and loyal Sampya, a steadfast friend who shares in the joys and trials of her journey. Yet, beyond these central figures, her world is further adorned by the vibrant presence of a diverse array of friends, each contributing their own hues to the canvas of her life. These friends, each with their distinct personalities and quirks, create a mosaic of shared laughter, shared dreams, and shared adventures. As she navigates the corridors of her imagination, this girl\'s world becomes a sanctuary of creativity, a space where every day is an opportunity for new discoveries and cherished moments with those who inhabit the landscapes of her mind. In her world, the ordinary transforms into the extraordinary, and each character, each nuance, becomes an essential thread in the narrative of a life beautifully and uniquely her own',0,'2024-05-01 00:00:00.000000',50,'Barkichi Patre','??????? ????? ','Srujan Dreams',0,'Who is she , a girl who have a world of her own with characters like grandparents, her friend sampya and rest of her friends',40,8,4,3),(15,'9783161484100','James W Cooper',50,_binary '\0',_binary '','Python Programming with Design Patterns by James W Cooper is a comprehensive guide to understanding and implementing design patterns in Python. The book covers a wide range of patterns including structural, creational, and behavioral patterns. It provides real-world examples to illustrate each pattern, making it easier for readers to understand and apply these patterns in their own Python projects. The book also includes exercises at the end of each chapter to help readers practice and reinforce their understanding of the concepts presented. Published by Pearson, this book is a valuable resource for both beginners and experienced Python developers who want to write cleaner, more efficient, and more maintainable code.',7,'2023-12-31 00:00:00.000000',45,'Python Programming with Design Patterns','Python Programming with Design Patterns','Pearson',5,'A book on Python programming with design patterns',40,14,1,1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_attribute`
--

DROP TABLE IF EXISTS `product_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_attribute` (
  `attribute_id` int NOT NULL AUTO_INCREMENT,
  `attribute_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`attribute_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_attribute`
--

LOCK TABLES `product_attribute` WRITE;
/*!40000 ALTER TABLE `product_attribute` DISABLE KEYS */;
INSERT INTO `product_attribute` VALUES (1,'Narrator'),(2,'Sound Effects');
/*!40000 ALTER TABLE `product_attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_beneficiary`
--

DROP TABLE IF EXISTS `product_beneficiary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_beneficiary` (
  `prod_ben_id` int NOT NULL AUTO_INCREMENT,
  `percentage` double DEFAULT NULL,
  `ben_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`prod_ben_id`),
  KEY `FKmvg6c9e1rvfa6wwyy7bnspg2k` (`ben_id`),
  KEY `FKkhfp9o212p3x1e5rhts34qqli` (`product_id`),
  CONSTRAINT `FKkhfp9o212p3x1e5rhts34qqli` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  CONSTRAINT `FKmvg6c9e1rvfa6wwyy7bnspg2k` FOREIGN KEY (`ben_id`) REFERENCES `beneficiary` (`ben_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_beneficiary`
--

LOCK TABLES `product_beneficiary` WRITE;
/*!40000 ALTER TABLE `product_beneficiary` DISABLE KEYS */;
INSERT INTO `product_beneficiary` VALUES (1,100,1,1),(2,50,2,3),(3,50,3,3);
/*!40000 ALTER TABLE `product_beneficiary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_details`
--

DROP TABLE IF EXISTS `product_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_details` (
  `prod_att_id` int NOT NULL AUTO_INCREMENT,
  `attribute_value` varchar(255) DEFAULT NULL,
  `attribute_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`prod_att_id`),
  KEY `FKaf5g4ywlsl0a1fxbf3cgx2pjy` (`attribute_id`),
  CONSTRAINT `FKaf5g4ywlsl0a1fxbf3cgx2pjy` FOREIGN KEY (`attribute_id`) REFERENCES `product_attribute` (`attribute_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_details`
--

LOCK TABLES `product_details` WRITE;
/*!40000 ALTER TABLE `product_details` DISABLE KEYS */;
INSERT INTO `product_details` VALUES (1,'Yash Hajare',1,1),(2,'Vedant Dhadange',1,2);
/*!40000 ALTER TABLE `product_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_type`
--

DROP TABLE IF EXISTS `product_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_type` (
  `type_id` int NOT NULL AUTO_INCREMENT,
  `type_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type`
--

LOCK TABLES `product_type` WRITE;
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` VALUES (1,'E-Book'),(2,'Audio-Book'),(3,'Video-Book');
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_url`
--

DROP TABLE IF EXISTS `product_url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_url` (
  `url_id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`url_id`),
  UNIQUE KEY `UK_ke7jgpwe8277qcxt20h36qeth` (`product_id`),
  CONSTRAINT `FKtfs07h1v7bru70auwrjf88nt5` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_url`
--

LOCK TABLES `product_url` WRITE;
/*!40000 ALTER TABLE `product_url` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_url` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publisher` (
  `publisher_id` int NOT NULL AUTO_INCREMENT,
  `publisher_contact_no` varchar(255) DEFAULT NULL,
  `publisher_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`publisher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` VALUES (1,'2107869820','Pearson');
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent`
--

DROP TABLE IF EXISTS `rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rent` (
  `rent_id` int NOT NULL AUTO_INCREMENT,
  `customer_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `rent_end_date` varchar(255) DEFAULT NULL,
  `rent_start_date` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_price` float DEFAULT NULL,
  PRIMARY KEY (`rent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent`
--

LOCK TABLES `rent` WRITE;
/*!40000 ALTER TABLE `rent` DISABLE KEYS */;
/*!40000 ALTER TABLE `rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `royalty_calculation`
--

DROP TABLE IF EXISTS `royalty_calculation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `royalty_calculation` (
  `roycal_id` int NOT NULL AUTO_INCREMENT,
  `baseprice` double DEFAULT NULL,
  `ben_id` int DEFAULT NULL,
  `invoice_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `royalty_on_base_price` double DEFAULT NULL,
  `roycal_trandate` date DEFAULT NULL,
  `saleprice` double DEFAULT NULL,
  `trantype` int DEFAULT NULL,
  PRIMARY KEY (`roycal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `royalty_calculation`
--

LOCK TABLES `royalty_calculation` WRITE;
/*!40000 ALTER TABLE `royalty_calculation` DISABLE KEYS */;
INSERT INTO `royalty_calculation` VALUES (1,70,2,35,3,35,'2024-02-21',50,1),(2,70,3,35,3,35,'2024-02-21',50,1),(3,70,2,39,3,35,'2024-02-25',50,1),(4,70,3,39,3,35,'2024-02-25',50,1),(5,70,2,42,3,35,'2024-02-25',50,1),(6,70,3,42,3,35,'2024-02-25',50,1);
/*!40000 ALTER TABLE `royalty_calculation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction_type`
--

DROP TABLE IF EXISTS `transaction_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction_type` (
  `transaction_type_id` bigint NOT NULL AUTO_INCREMENT,
  `transaction_desc` char(1) DEFAULT NULL,
  PRIMARY KEY (`transaction_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction_type`
--

LOCK TABLES `transaction_type` WRITE;
/*!40000 ALTER TABLE `transaction_type` DISABLE KEYS */;
INSERT INTO `transaction_type` VALUES (1,'P'),(2,'R'),(3,'L');
/*!40000 ALTER TABLE `transaction_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-25 23:09:29

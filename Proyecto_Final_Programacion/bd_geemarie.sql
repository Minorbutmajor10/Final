CREATE DATABASE  IF NOT EXISTS `geemarie` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `geemarie`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: geemarie
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
-- Table structure for table `mockdata2`
--

DROP TABLE IF EXISTS `mockdata2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mockdata2` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nombre` text,
  `Apellido` text,
  `Edad` text,
  `Fecha_Nacimiento` text,
  `Nacionalidad` text,
  `Genero` text,
  `Estado_Civil` text,
  `Ciudad` text,
  `Celular` text,
  `Correo` text,
  `Numero_Documento` text,
  `Puesto` text,
  `Estado_Postulacion` text,
  `Pendiente_Correo` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mockdata2`
--

LOCK TABLES `mockdata2` WRITE;
/*!40000 ALTER TABLE `mockdata2` DISABLE KEYS */;
INSERT INTO `mockdata2` VALUES (1,'Daniel','Coronado','22','22/09/2002','Peruana ','Masculino','Soltero','Lima','987653476','emanuelvilchez63@gmail.com','98734567','Frontend developer','Apto','FALSO'),(2,'Rafael','Rodriguez','28','22/09/2003','Peruana','Masculino','Soltero','Lima','945654378','mariesdev@gmail.com','76548734','Backend developer','Apto','FALSO'),(3,'Melissa','Soto','29','22/09/2004','Colombiana','Femenino','Soltero','Bogota','478398456','yellowsun2086@gmail.com','87452314','Diseñador ux/ui','Apto','FALSO'),(4,'Alvaro','Paredes','24','22/09/2005','Argentina','Masculino','Casado','Buenos Aires','998345234','itachi_el_mejor_uchiha@gmail.com','23145456','Backend developer','No Apto','VERDADERO'),(5,'Ximena','Rojas','20','22/09/2006','Peruana','Femenino','Casado','Lima','878893845','ximena.13@gmail.com','89324522','Backend developer','Apto','FALSO'),(6,'Rosa','Vilchez','35','22/09/2007','Mexicana','Femenino','Soltero','Ciudad de México','830094982','rosav_10@gmail.com','67783469','Frontend developer','No Apto','FALSO'),(7,'Jose','Rivera','27','22/09/2008','Uruguaya','Masculino','Casado','Montevideo','802354644','josee11@gmail.com','45355787','Diseñador ux/ui','No Apto ','VERDADERO'),(8,'Pedro','Quispe','26','22/09/2009','Argentina','Masculino','Casado','Buenos Aires','993220346','pedroquispee@gmail.com','57299832','Frontend developer','Apto','FALSO'),(9,'Manuel','Lozano','20','22/09/2010','Mexicana','Masculino','Soltero','Ciudad de México','856430035','manuel63@gmail.com','82346765','Diseñador ux/ui','Apto','FALSO'),(10,'Maria','López','23','22/09/2011','Colombiana','Femenino','Casado','Bogota','994323456','marialope24@gmail.com','77848729','Diseñador ux/ui','No Apto ','VERDADERO'),(11,'Brenda','Garcia','30','22/09/2012','Peruana','Femenino','Casado','Lima','223456556','brendag30@gmail.com','62637687','Backend developer','Apto','FALSO'),(12,'Bruno','Fernandez','36','22/09/2013','Venezolana','Masculino','Soltero','Caracas','899455759','brunoferna24@gmail.com','58944933','Frontend developer','No Apto ','FALSO'),(13,'Fernanda','Martinez','22','22/09/2014','Venezolana','Femenino','Soltero','Caracas','882993345','fernanda._2@gmail.com','65673788','Social media manager','Apto','FALSO'),(14,'Jesus','Sanchez','24','22/09/2015','Peruana','Masculino','Soltero','Lima','555398459','jesussan.9@gmail.com','89946287','Diseñador ux/ui','Apto','FALSO'),(15,'Sebastian','Carrasco','21','22/09/2016','Colombiana','Masculino','Casado','Medellin','233487676','sebastian_07@gmail.com','72711829','Diseñador ux/ui','No Apto','FALSO'),(16,'Brando','Carquin','23','22/09/2017','Argentina','Masculino','Casado','Buenos Aires','812345345','brando100@gmail.com','45338874','Social media manager','Apto ','FALSO'),(17,'Karina','Flores','31','22/09/2018','Uruguaya','Femenino','Soltero','Montevideo','874562399','karinaaes@gmail.com','87627896','Backend developer','No Apto ','VERDADERO'),(18,'Luz','Vargas','32','22/09/2019','Uruguaya','Femenino','Soltero','Montevideo','899211345','luzzz20@gmail.com','97898413','Diseñador ux/ui','No Apto ','VERDADERO'),(19,'Isabel','Torres','21','22/09/2020','Mexicana','Femenino','Casado','Ciudad de México','112453546','isabeltorres15@gmail.com','54224682','Frontend developer','Apto ','FALSO'),(20,'Susana','Gomez','25','22/09/2021','Argentina','Femenino','Soltero','Buenos Aires','929120032','susana80@gmail.com','78925483','Diseñador ux/ui','Apto ','VERDADERO'),(21,'Paolo','Guerrero',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'paolo9@gmail.com',NULL,NULL,'Apto','FALSO'),(22,'Cristian','Cueva',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'cueva10@gmail.com',NULL,NULL,'Apto','FALSO'),(23,'cristiano','ronaldo',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'cristiano7@gmail.com',NULL,NULL,'Apto','FALSO');
/*!40000 ALTER TABLE `mockdata2` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-01 20:45:28

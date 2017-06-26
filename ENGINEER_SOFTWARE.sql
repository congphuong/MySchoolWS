-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: myschool1
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `chitietbangdiem`
--

DROP TABLE IF EXISTS `chitietbangdiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitietbangdiem` (
  `MA_MH` int(11) NOT NULL,
  `MA_LOP` int(11) NOT NULL,
  `MA_HS` int(11) NOT NULL,
  `MIENG` double DEFAULT NULL,
  `MLPHUT` double DEFAULT NULL,
  `MTIET` double DEFAULT NULL,
  `CUOIKY` double DEFAULT NULL,
  `TONGKET` double DEFAULT NULL,
  `HOC_KY` int(11) DEFAULT NULL,
  KEY `MA_MH` (`MA_MH`),
  KEY `MA_LOP` (`MA_LOP`),
  KEY `MA_HS` (`MA_HS`),
  CONSTRAINT `chitietbangdiem_ibfk_1` FOREIGN KEY (`MA_MH`) REFERENCES `monhoc` (`MA_MH`),
  CONSTRAINT `chitietbangdiem_ibfk_2` FOREIGN KEY (`MA_LOP`) REFERENCES `lop` (`MA_LOP`),
  CONSTRAINT `chitietbangdiem_ibfk_3` FOREIGN KEY (`MA_HS`) REFERENCES `hocsinh` (`MA_HS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietbangdiem`
--

LOCK TABLES `chitietbangdiem` WRITE;
/*!40000 ALTER TABLE `chitietbangdiem` DISABLE KEYS */;
INSERT INTO `chitietbangdiem` VALUES (1,1,5,8,8,8,8,8,1),(2,1,5,7,7,7,7,7,1),(3,1,5,9,9,9,9,9,1),(1,1,6,7,7,7,7,7,1),(2,1,6,8,8,8,8,8,1),(3,1,6,6,6,6,6,6,1);
/*!40000 ALTER TABLE `chitietbangdiem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chucvu` (
  `CHUCVU` varchar(20) NOT NULL,
  PRIMARY KEY (`CHUCVU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucvu`
--

LOCK TABLES `chucvu` WRITE;
/*!40000 ALTER TABLE `chucvu` DISABLE KEYS */;
INSERT INTO `chucvu` VALUES ('GIAOVIEN'),('HOCSINH'),('PHUHUYNH');
/*!40000 ALTER TABLE `chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cmt`
--

DROP TABLE IF EXISTS `cmt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmt` (
  `ID_CMT` int(11) NOT NULL AUTO_INCREMENT,
  `ID_TOPIC` int(11) NOT NULL,
  `USERNAME` varchar(200) NOT NULL,
  `NOI_DUNG` text,
  `THOI_GIAN` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_CMT`,`ID_TOPIC`),
  KEY `FK_CMTTK` (`USERNAME`),
  KEY `ID_TOPIC` (`ID_TOPIC`),
  CONSTRAINT `FK_CMTTK` FOREIGN KEY (`USERNAME`) REFERENCES `taikhoan` (`USERNAME`),
  CONSTRAINT `cmt_ibfk_1` FOREIGN KEY (`ID_TOPIC`) REFERENCES `topic` (`ID_TOPIC`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmt`
--

LOCK TABLES `cmt` WRITE;
/*!40000 ALTER TABLE `cmt` DISABLE KEYS */;
INSERT INTO `cmt` VALUES (17,1,'HS001','BLA BLE BLO','2017-06-21 14:04:00'),(18,1,'HS002','BLA BLE BLO AAAAAAA1','2017-06-23 17:22:47'),(19,1,'HS001','BLA BLE BLO 2','2017-06-21 14:04:00'),(20,1,'HS002','BLA BLE BLO 3','2017-06-21 14:04:00'),(21,1,'HS001','BLA BLE BLO 4','2017-06-21 14:04:00'),(22,1,'HS002','BLA BLE BLO D','2017-06-21 14:04:00'),(23,1,'HS001','BLA BLE BLO','2017-06-21 14:04:00'),(24,1,'HS002','BLA BLE BLO','2017-06-21 14:04:00'),(25,1,'HS001','BLA BLE BLO','2017-06-21 14:04:01'),(26,1,'HS002','BLA BLE BLO','2017-06-21 14:04:01'),(27,1,'HS001','BLA BLE BLO','2017-06-21 14:04:01'),(28,1,'HS002','BLA BLE BLO','2017-06-21 14:04:01'),(29,1,'HS001','BLA BLE BLO','2017-06-21 14:04:01'),(30,1,'HS002','BLA BLE BLO','2017-06-21 14:04:01'),(31,1,'HS001','BLA BLE BLO','2017-06-21 14:04:01'),(32,1,'HS001','BLA BLE BL11111O','2017-06-22 16:47:17'),(33,2,'HS001','BLA BLE BLO','2017-06-22 17:34:23'),(34,4,'HS001','BLA BLE BLO','2017-06-22 17:34:44'),(35,1,'HS001','SDAASDASDASDAS','2017-06-23 13:07:00'),(36,1,'PH001','BLA BLE BLO AAAAAAA222222','2017-06-23 17:35:27'),(37,4,'PH001','BLA BLE BLO','2017-06-24 08:35:30'),(38,4,'PH001','BLA BLE BLO bé này bé nọ ','2017-06-24 08:37:46');
/*!40000 ALTER TABLE `cmt` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER T_CMTP
AFTER INSERT ON CMT
FOR EACH ROW
  BEGIN
    UPDATE TOPIC SET TOPIC.SO_CMT = TOPIC.SO_CMT + 1 WHERE NEW.ID_TOPIC=topic.ID_TOPIC;
  END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `giaovien`
--

DROP TABLE IF EXISTS `giaovien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `giaovien` (
  `MA_GV` int(11) NOT NULL AUTO_INCREMENT,
  `TEN_GV` varchar(50) NOT NULL,
  `GIOI_TINH` varchar(20) NOT NULL,
  `QUE_QUAN` varchar(50) NOT NULL,
  `NGAY_SINH` timestamp NULL DEFAULT NULL,
  `MA_TRUONG` int(11) NOT NULL,
  `USERNAME` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`MA_GV`),
  KEY `PH_TKKK` (`USERNAME`),
  KEY `PH_TK2K` (`MA_TRUONG`),
  CONSTRAINT `PH_TK2K` FOREIGN KEY (`MA_TRUONG`) REFERENCES `truong` (`MA_TRUONG`),
  CONSTRAINT `PH_TKKK` FOREIGN KEY (`USERNAME`) REFERENCES `taikhoan` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giaovien`
--

LOCK TABLES `giaovien` WRITE;
/*!40000 ALTER TABLE `giaovien` DISABLE KEYS */;
INSERT INTO `giaovien` VALUES (1,'CO GIAO THAO','NU ','TP HCM','1993-02-01 17:00:00',1,'admin2'),(2,'THAY GIAO THAO','NAM','TP HCM','1989-03-22 17:00:00',1,'GV002'),(3,'GIAO VIEN 2','NAM ','HA NOI','1991-04-03 17:00:00',1,NULL),(4,'GIAO VIEN 3','NU','TP HCM ','1991-03-01 17:00:00',1,NULL),(5,'GIAO VIEN 4','NAM ','QUANG NGAI','1990-01-01 17:00:00',1,NULL);
/*!40000 ALTER TABLE `giaovien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocsinh`
--

DROP TABLE IF EXISTS `hocsinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hocsinh` (
  `MA_HS` int(11) NOT NULL AUTO_INCREMENT,
  `TEN_HS` varchar(50) NOT NULL,
  `USERNAME` varchar(200) DEFAULT NULL,
  `NGAY_SINH` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `GIOI_TINH` varchar(10) NOT NULL,
  `MA_TRUONG` int(11) NOT NULL,
  `QUE_QUAN` varchar(60) NOT NULL,
  `SO_DT` int(11) DEFAULT NULL,
  PRIMARY KEY (`MA_HS`),
  KEY `FK_HSTK` (`USERNAME`),
  KEY `FK_HSTRUONG` (`MA_TRUONG`),
  CONSTRAINT `FK_HSTK` FOREIGN KEY (`USERNAME`) REFERENCES `taikhoan` (`USERNAME`),
  CONSTRAINT `FK_HSTRUONG` FOREIGN KEY (`MA_TRUONG`) REFERENCES `truong` (`MA_TRUONG`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocsinh`
--

LOCK TABLES `hocsinh` WRITE;
/*!40000 ALTER TABLE `hocsinh` DISABLE KEYS */;
INSERT INTO `hocsinh` VALUES (5,'LE ANH TRI','HS004','2017-06-21 14:57:36','NAM',1,'QUANG NGAI',1222977046),(6,'PHAM LE CONG PHUONG','HS002','2017-06-21 13:57:41','NAM',1,'QUANG NAM',123213123),(7,'LUONG PHU AN','HS003','2017-06-21 13:57:42','NAM',1,'TAY NINH',11313413),(8,'NGO VAN KHUONG','HS001','2017-06-21 13:57:41','NAM',1,'QUANG NAM',123123312);
/*!40000 ALTER TABLE `hocsinh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hocsinhlop`
--

DROP TABLE IF EXISTS `hocsinhlop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hocsinhlop` (
  `MA_HS` int(11) NOT NULL,
  `MA_LOP` int(11) NOT NULL,
  PRIMARY KEY (`MA_HS`,`MA_LOP`),
  KEY `FK_HSLOP` (`MA_LOP`),
  CONSTRAINT `FK_HSH` FOREIGN KEY (`MA_HS`) REFERENCES `hocsinh` (`MA_HS`),
  CONSTRAINT `FK_HSLOP` FOREIGN KEY (`MA_LOP`) REFERENCES `lop` (`MA_LOP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocsinhlop`
--

LOCK TABLES `hocsinhlop` WRITE;
/*!40000 ALTER TABLE `hocsinhlop` DISABLE KEYS */;
INSERT INTO `hocsinhlop` VALUES (5,1),(6,1),(7,1),(8,2);
/*!40000 ALTER TABLE `hocsinhlop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lichthi`
--

DROP TABLE IF EXISTS `lichthi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lichthi` (
  `HOC_KY` int(11) NOT NULL,
  `MA_MH` int(11) DEFAULT NULL,
  `MA_LOP` int(11) DEFAULT NULL,
  `NGAY_THI` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `TIET_BAT_DAU` int(11) DEFAULT NULL,
  `THOI_GIAN_THI` int(11) DEFAULT NULL,
  KEY `FK_MAMH` (`MA_MH`),
  KEY `FK_LLT` (`MA_LOP`),
  CONSTRAINT `FK_LLT` FOREIGN KEY (`MA_LOP`) REFERENCES `lop` (`MA_LOP`),
  CONSTRAINT `FK_MAMH` FOREIGN KEY (`MA_MH`) REFERENCES `monhoc` (`MA_MH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lichthi`
--

LOCK TABLES `lichthi` WRITE;
/*!40000 ALTER TABLE `lichthi` DISABLE KEYS */;
INSERT INTO `lichthi` VALUES (1,1,1,'2017-09-08 17:00:00',1,90),(1,2,1,'2017-06-01 17:00:00',3,120),(1,3,1,'2017-06-02 17:00:00',5,120),(1,4,1,'2017-05-31 17:00:00',2,60),(1,1,2,'2017-04-03 17:00:00',1,90),(1,2,2,'2017-05-04 17:00:00',1,120),(1,3,2,'2017-05-05 17:00:00',3,120);
/*!40000 ALTER TABLE `lichthi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lop`
--

DROP TABLE IF EXISTS `lop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lop` (
  `MA_TRUONG` int(11) NOT NULL,
  `NAM_HOC` int(10) NOT NULL,
  `MA_LOP` int(11) NOT NULL AUTO_INCREMENT,
  `MA_GV` int(11) NOT NULL,
  `SI_SO` int(11) NOT NULL,
  `TEN_LOP` varchar(20) NOT NULL,
  PRIMARY KEY (`MA_LOP`,`MA_TRUONG`,`NAM_HOC`,`TEN_LOP`),
  KEY `FK_TL` (`MA_TRUONG`),
  KEY `FK_LGV` (`MA_GV`),
  CONSTRAINT `FK_LGV` FOREIGN KEY (`MA_GV`) REFERENCES `giaovien` (`MA_GV`),
  CONSTRAINT `FK_TL` FOREIGN KEY (`MA_TRUONG`) REFERENCES `truong` (`MA_TRUONG`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lop`
--

LOCK TABLES `lop` WRITE;
/*!40000 ALTER TABLE `lop` DISABLE KEYS */;
INSERT INTO `lop` VALUES (1,2015,1,1,40,'12A1'),(1,2015,2,2,41,'12A2');
/*!40000 ALTER TABLE `lop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `maxacnhan`
--

DROP TABLE IF EXISTS `maxacnhan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `maxacnhan` (
  `MAXACNHAN` int(11) NOT NULL,
  `MACHUCVU` int(11) NOT NULL,
  `CHUCVU` varchar(20) NOT NULL,
  PRIMARY KEY (`MAXACNHAN`,`MACHUCVU`),
  KEY `FK_MC` (`CHUCVU`),
  CONSTRAINT `FK_MC` FOREIGN KEY (`CHUCVU`) REFERENCES `chucvu` (`CHUCVU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `maxacnhan`
--

LOCK TABLES `maxacnhan` WRITE;
/*!40000 ALTER TABLE `maxacnhan` DISABLE KEYS */;
INSERT INTO `maxacnhan` VALUES (111,1,'GIAOVIEN'),(120,2,'GIAOVIEN'),(113,5,'HOCSINH'),(115,6,'HOCSINH'),(116,7,'HOCSINH'),(117,8,'HOCSINH'),(114,3,'PHUHUYNH'),(118,1,'PHUHUYNH'),(119,2,'PHUHUYNH');
/*!40000 ALTER TABLE `maxacnhan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `monhoc`
--

DROP TABLE IF EXISTS `monhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monhoc` (
  `MA_MH` int(11) NOT NULL AUTO_INCREMENT,
  `TEN_MH` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`MA_MH`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monhoc`
--

LOCK TABLES `monhoc` WRITE;
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` VALUES (1,'TOAN'),(2,'NGU VAN'),(3,'ANH VAN'),(4,'VAT LY'),(5,'HOA HOC'),(6,'SINH HOC'),(7,'LICH SU');
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phuhuynh`
--

DROP TABLE IF EXISTS `phuhuynh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phuhuynh` (
  `MA_PH` int(11) NOT NULL AUTO_INCREMENT,
  `TEN_HO` varchar(50) NOT NULL,
  `NGAYSINH` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `QUEQUAN` varchar(50) DEFAULT NULL,
  `USERNAME` varchar(200) DEFAULT NULL,
  `GIOITINH` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MA_PH`),
  KEY `FK_PH` (`USERNAME`),
  CONSTRAINT `FK_PH` FOREIGN KEY (`USERNAME`) REFERENCES `taikhoan` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phuhuynh`
--

LOCK TABLES `phuhuynh` WRITE;
/*!40000 ALTER TABLE `phuhuynh` DISABLE KEYS */;
INSERT INTO `phuhuynh` VALUES (1,'PHU HUYNH 1','2017-06-21 15:05:26','QUANG NGAI','PH001','NAM'),(2,'PHU HUYNH 2','2017-06-21 15:05:26','QUANG NAM','PH002','NU'),(3,'PHU HUYNH 3','2017-06-21 15:05:26','TAY NINH','PH003','NAM');
/*!40000 ALTER TABLE `phuhuynh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phuhuynhhs`
--

DROP TABLE IF EXISTS `phuhuynhhs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phuhuynhhs` (
  `MA_PH` int(11) NOT NULL,
  `MA_HS` int(11) NOT NULL,
  PRIMARY KEY (`MA_PH`,`MA_HS`),
  KEY `FK_PHPP` (`MA_HS`),
  CONSTRAINT `FK_PHPP` FOREIGN KEY (`MA_HS`) REFERENCES `hocsinh` (`MA_HS`),
  CONSTRAINT `FK_PPPP` FOREIGN KEY (`MA_PH`) REFERENCES `phuhuynh` (`MA_PH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phuhuynhhs`
--

LOCK TABLES `phuhuynhhs` WRITE;
/*!40000 ALTER TABLE `phuhuynhhs` DISABLE KEYS */;
INSERT INTO `phuhuynhhs` VALUES (1,5),(1,6),(2,7),(3,8);
/*!40000 ALTER TABLE `phuhuynhhs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taikhoan` (
  `USERID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(200) DEFAULT NULL,
  `PASSWD` varchar(200) DEFAULT NULL,
  `CHUCVU` varchar(20) DEFAULT NULL,
  `MACHUCVU` int(11) DEFAULT NULL,
  `TOKEN` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`USERID`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES (1,'HS004','$2a$10$6EQ1CrT6kH./UtjkSKpX9e3eOCxdu8rhQ3Wwx1hLjQNYxL/8dFlMO','HOCSINH',5,NULL),(2,'ADMIN','$2a$10$AR5eTjmfk8ydCnd/RgLRjODXNDKKLVc64gAWLpeg7Y1G8e4SKMyK.','GIAOVIEN',1,NULL),(3,'PH001','$2a$10$fFhhGLyff0litXOjYAgh4eKVVMy/rM51jdcAhzBLOJPk17Q3PbD7y','PHUHUYNH',2,NULL),(4,'PH002','$2a$10$T/tvc2AY0rv7qXp1wxSJ8.FJAn0HN9t.U0NqQEGzqZ6NKsfitaJ7.','PHUHUYNH',2,NULL),(5,'PH003','$2a$10$8eq009yEbizqkhvf7dUKiOm/yY8UnlNJbq7HWfQhuhhFQhQN0aYxS','PHUHUYNH',2,NULL),(6,'GV002','GV002','GIAOVIEN',2,NULL),(8,'HS001','$2a$10$D7HMvWpu35tXNU6e7YrODOzVq6DqmPvCQZD7NDT6oJ9Bi0FBYtjGu','HOCSINH',8,NULL),(9,'HS002','$2a$10$LhFYAJ7XijgHGVPfqdLqT.Zx11VLsaqP0sg1tCTyfOey4WYrwDZau','HOCSINH',6,NULL),(10,'HS003','$2a$10$RcDDv0one8rJPG.gZ/itGeeHhFNtFtzn2IWj9661zwRgSjDDYLWpm','HOCSINH',7,NULL),(11,'admin2','$2a$10$aSR1dAqElYqU05IibkD2bui33zIltZ/RXXQGJ6/tvBNiwDHEFps7m','GIAOVIEN',1,NULL);
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thoikhoabieu`
--

DROP TABLE IF EXISTS `thoikhoabieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thoikhoabieu` (
  `MA_GV` int(11) NOT NULL,
  `MA_LOP` int(11) NOT NULL,
  `MA_MH` int(11) NOT NULL,
  `HOC_KY` int(11) NOT NULL,
  `THU` int(11) NOT NULL,
  `TIET` int(11) NOT NULL,
  PRIMARY KEY (`MA_GV`,`MA_LOP`,`HOC_KY`,`THU`,`TIET`),
  KEY `F_KEY_TKB_LOP` (`MA_LOP`),
  KEY `F_KEY_TKB_MH` (`MA_MH`),
  CONSTRAINT `F_KEY_TKB_LOP` FOREIGN KEY (`MA_LOP`) REFERENCES `lop` (`MA_LOP`),
  CONSTRAINT `F_KEY_TKB_MH` FOREIGN KEY (`MA_MH`) REFERENCES `monhoc` (`MA_MH`),
  CONSTRAINT `F_TKBGV` FOREIGN KEY (`MA_GV`) REFERENCES `giaovien` (`MA_GV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thoikhoabieu`
--

LOCK TABLES `thoikhoabieu` WRITE;
/*!40000 ALTER TABLE `thoikhoabieu` DISABLE KEYS */;
INSERT INTO `thoikhoabieu` VALUES (1,1,1,1,2,1),(1,1,1,1,2,2),(2,1,2,1,2,3),(2,1,2,1,2,4),(3,1,3,1,2,5);
/*!40000 ALTER TABLE `thoikhoabieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thongbao`
--

DROP TABLE IF EXISTS `thongbao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thongbao` (
  `ID_TB` int(11) NOT NULL AUTO_INCREMENT,
  `NGUOIGUI` varchar(200) NOT NULL,
  `NGUOINHAN` varchar(200) NOT NULL,
  `TIEU_DE` varchar(200) NOT NULL,
  `NOI_DUNG` text NOT NULL,
  `THOI_GIAN` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_TB`),
  KEY `thongbao_ibfk_1` (`NGUOIGUI`),
  KEY `thongbao_ibfk_2` (`NGUOINHAN`),
  CONSTRAINT `thongbao_ibfk_1` FOREIGN KEY (`NGUOIGUI`) REFERENCES `taikhoan` (`USERNAME`),
  CONSTRAINT `thongbao_ibfk_2` FOREIGN KEY (`NGUOINHAN`) REFERENCES `taikhoan` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thongbao`
--

LOCK TABLES `thongbao` WRITE;
/*!40000 ALTER TABLE `thongbao` DISABLE KEYS */;
INSERT INTO `thongbao` VALUES (1,'ADMIN','PH001','ABC','ABCDCDCDCD','2017-06-23 04:03:06'),(2,'ADMIN','PH002','ABC','ABCDCDCDCD','2017-06-23 04:03:07'),(3,'ADMIN','PH003','ABC','ABCDCDCDCD','2017-06-23 04:03:07'),(4,'ADMIN','HS001','ABC','ABCDCDCDCD','2017-06-23 04:03:07'),(5,'ADMIN','HS002','ABC','ABCDCDCDCD','2017-06-23 04:03:07'),(6,'ADMIN','HS003','ABC','ABCDCDCDCD','2017-06-23 04:03:07'),(7,'ADMIN','HS004','ABC','ABCDCDCDCD','2017-06-23 04:03:07');
/*!40000 ALTER TABLE `thongbao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `ID_TOPIC` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(200) NOT NULL,
  `MA_LOP` int(11) DEFAULT NULL,
  `THOI_GIAN` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `CHU_DE` varchar(100) DEFAULT NULL,
  `NOI_DUNG` text NOT NULL,
  `SO_CMT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_TOPIC`,`USERNAME`),
  KEY `FK_TOPICTK` (`USERNAME`),
  KEY `FK_TOPICLOP` (`MA_LOP`),
  CONSTRAINT `FK_TOPICLOP` FOREIGN KEY (`MA_LOP`) REFERENCES `lop` (`MA_LOP`),
  CONSTRAINT `FK_TOPICTK` FOREIGN KEY (`USERNAME`) REFERENCES `taikhoan` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,'HS004',1,'2017-06-21 13:52:18','TRUONG CHAY','TRUONG CHAY NEN BO CHO CHUNG MAY NGHI',18),(2,'HS004',1,'2017-06-22 17:17:35','TRUONG CHAY','TRUONG CHAY NEN BO CHO CHUNG MAY NGHI11111',1),(3,'HS004',1,'2017-06-22 17:20:59','TRUONG CHAY','TRUONG CHAY NEN BO CHO CHUNG MAY NGHI11111',0),(4,'HS004',2,'2017-06-22 17:32:29','TRUONG CHAY','TRUONG CHAY NEN BO CHO CHUNG MAY NGHI hahahaha',3);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `truong`
--

DROP TABLE IF EXISTS `truong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `truong` (
  `MA_TRUONG` int(11) NOT NULL AUTO_INCREMENT,
  `TEN_TRUONG` varchar(30) NOT NULL,
  `DIA_CHI` varchar(50) NOT NULL,
  PRIMARY KEY (`MA_TRUONG`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `truong`
--

LOCK TABLES `truong` WRITE;
/*!40000 ALTER TABLE `truong` DISABLE KEYS */;
INSERT INTO `truong` VALUES (1,'THPT TRAN QUOC TUAN','TP QUANG NGAI, QUANG NGAI');
/*!40000 ALTER TABLE `truong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_bangdiem`
--

DROP TABLE IF EXISTS `v_bangdiem`;
/*!50001 DROP VIEW IF EXISTS `v_bangdiem`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_bangdiem` AS SELECT
                                       1 AS `TEN_HS`,
                                       1 AS `MA_HS`,
                                       1 AS `TEN_LOP`,
                                       1 AS `TEN_MH`,
                                       1 AS `MIENG`,
                                       1 AS `MLPHUT`,
                                       1 AS `MTIET`,
                                       1 AS `CUOIKY`,
                                       1 AS `TONGKET`,
                                       1 AS `HOC_KY`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_infoparents`
--

DROP TABLE IF EXISTS `v_infoparents`;
/*!50001 DROP VIEW IF EXISTS `v_infoparents`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_infoparents` AS SELECT
                                          1 AS `MA_PH`,
                                          1 AS `TEN_HO`,
                                          1 AS `NGAYSINH`,
                                          1 AS `QUEQUAN`,
                                          1 AS `USERNAME`,
                                          1 AS `GIOITINH`,
                                          1 AS `MA_HS`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_infostd`
--

DROP TABLE IF EXISTS `v_infostd`;
/*!50001 DROP VIEW IF EXISTS `v_infostd`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_infostd` AS SELECT
                                      1 AS `MA_HS`,
                                      1 AS `TEN_HS`,
                                      1 AS `NGAY_SINH`,
                                      1 AS `GIOI_TINH`,
                                      1 AS `MA_LOP`,
                                      1 AS `TEN_LOP`,
                                      1 AS `MA_TRUONG`,
                                      1 AS `TEN_TRUONG`,
                                      1 AS `QUE_QUAN`,
                                      1 AS `SO_DT`,
                                      1 AS `USERNAME`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_infoteacher`
--

DROP TABLE IF EXISTS `v_infoteacher`;
/*!50001 DROP VIEW IF EXISTS `v_infoteacher`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_infoteacher` AS SELECT
                                          1 AS `MA_GV`,
                                          1 AS `TEN_GV`,
                                          1 AS `GIOI_TINH`,
                                          1 AS `QUE_QUAN`,
                                          1 AS `NGAY_SINH`,
                                          1 AS `TEN_TRUONG`,
                                          1 AS `USERNAME`,
                                          1 AS `TEN_LOP`,
                                          1 AS `MA_LOP`,
                                          1 AS `ID_TOPIC`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_lichthi`
--

DROP TABLE IF EXISTS `v_lichthi`;
/*!50001 DROP VIEW IF EXISTS `v_lichthi`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_lichthi` AS SELECT
                                      1 AS `HOC_KY`,
                                      1 AS `MA_MH`,
                                      1 AS `TEN_MH`,
                                      1 AS `MA_LOP`,
                                      1 AS `TEN_LOP`,
                                      1 AS `NGAY_THI`,
                                      1 AS `TIET_BAT_DAU`,
                                      1 AS `THOI_GIAN_THI`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_phtheolop`
--

DROP TABLE IF EXISTS `v_phtheolop`;
/*!50001 DROP VIEW IF EXISTS `v_phtheolop`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_phtheolop` AS SELECT
                                        1 AS `MA_PH`,
                                        1 AS `TEN_HO`,
                                        1 AS `GIOITINH`,
                                        1 AS `NGAYSINH`,
                                        1 AS `QUEQUAN`,
                                        1 AS `USERNAME`,
                                        1 AS `MA_LOP`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_tkb`
--

DROP TABLE IF EXISTS `v_tkb`;
/*!50001 DROP VIEW IF EXISTS `v_tkb`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_tkb` AS SELECT
                                  1 AS `MA_GV`,
                                  1 AS `MA_LOP`,
                                  1 AS `TEN_LOP`,
                                  1 AS `MA_MH`,
                                  1 AS `TEN_MH`,
                                  1 AS `HOC_KY`,
                                  1 AS `THU`,
                                  1 AS `TIET`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'myschool1'
--
/*!50003 DROP PROCEDURE IF EXISTS `THEM_TAIKHOAN` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `THEM_TAIKHOAN`(IN USERNAME VARCHAR(200), IN PASSWD VARCHAR(200), IN CHUCVU VARCHAR(20), IN MACHUCVU INT(11))
  BEGIN
    INSERT INTO `myschool1`.`taikhoan` (`USERNAME`, `PASSWD`, `CHUCVU`, `MACHUCVU`)
    VALUES (USERNAME,PASSWD,CHUCVU,MACHUCVU);
    IF(CHUCVU='HOCSINH')
    THEN UPDATE HOCSINH SET HOCSINH.USERNAME = USERNAME WHERE HOCSINH.MA_HS = MACHUCVU;
    ELSEIF(CHUCVU='GIAOVIEN')
      THEN UPDATE GIAOVIEN SET GIAOVIEN.USERNAME = USERNAME WHERE GIAOVIEN.MA_GV = MACHUCVU;
    ELSEIF(CHUCVU='PHUHUYNH')
      THEN UPDATE PHUHUYNH SET PHUHUYNH.USERNAME = USERNAME WHERE PHUHUYNH.MA_PH = MACHUCVU;
    END IF;
  END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `v_bangdiem`
--

/*!50001 DROP VIEW IF EXISTS `v_bangdiem`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
  /*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
  /*!50001 VIEW `v_bangdiem` AS select `hs`.`TEN_HS` AS `TEN_HS`,`hs`.`MA_HS` AS `MA_HS`,`l`.`TEN_LOP` AS `TEN_LOP`,`mh`.`TEN_MH` AS `TEN_MH`,`ct`.`MIENG` AS `MIENG`,`ct`.`MLPHUT` AS `MLPHUT`,`ct`.`MTIET` AS `MTIET`,`ct`.`CUOIKY` AS `CUOIKY`,`ct`.`TONGKET` AS `TONGKET`,`ct`.`HOC_KY` AS `HOC_KY` from (((`hocsinh` `hs` join `chitietbangdiem` `ct` on((`hs`.`MA_HS` = `ct`.`MA_HS`))) join `monhoc` `mh` on((`ct`.`MA_MH` = `mh`.`MA_MH`))) join `lop` `l` on((`ct`.`MA_LOP` = `l`.`MA_LOP`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_infoparents`
--

/*!50001 DROP VIEW IF EXISTS `v_infoparents`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
  /*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
  /*!50001 VIEW `v_infoparents` AS select `ph`.`MA_PH` AS `MA_PH`,`ph`.`TEN_HO` AS `TEN_HO`,`ph`.`NGAYSINH` AS `NGAYSINH`,`ph`.`QUEQUAN` AS `QUEQUAN`,`ph`.`USERNAME` AS `USERNAME`,`ph`.`GIOITINH` AS `GIOITINH`,`phhs`.`MA_HS` AS `MA_HS` from (`phuhuynhhs` `phhs` join `phuhuynh` `ph` on((`phhs`.`MA_PH` = `ph`.`MA_PH`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_infostd`
--

/*!50001 DROP VIEW IF EXISTS `v_infostd`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
  /*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
  /*!50001 VIEW `v_infostd` AS select `hsl`.`MA_HS` AS `MA_HS`,`hs`.`TEN_HS` AS `TEN_HS`,`hs`.`NGAY_SINH` AS `NGAY_SINH`,`hs`.`GIOI_TINH` AS `GIOI_TINH`,`hsl`.`MA_LOP` AS `MA_LOP`,`lop`.`TEN_LOP` AS `TEN_LOP`,`lop`.`MA_TRUONG` AS `MA_TRUONG`,`truong`.`TEN_TRUONG` AS `TEN_TRUONG`,`hs`.`QUE_QUAN` AS `QUE_QUAN`,`hs`.`SO_DT` AS `SO_DT`,`hs`.`USERNAME` AS `USERNAME` from (((`hocsinhlop` `hsl` join `hocsinh` `hs` on((`hs`.`MA_HS` = `hsl`.`MA_HS`))) join `lop` on((`lop`.`MA_LOP` = `hsl`.`MA_LOP`))) join `truong` on((`truong`.`MA_TRUONG` = `lop`.`MA_TRUONG`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_infoteacher`
--

/*!50001 DROP VIEW IF EXISTS `v_infoteacher`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
  /*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
  /*!50001 VIEW `v_infoteacher` AS select `gv`.`MA_GV` AS `MA_GV`,`gv`.`TEN_GV` AS `TEN_GV`,`gv`.`GIOI_TINH` AS `GIOI_TINH`,`gv`.`QUE_QUAN` AS `QUE_QUAN`,`gv`.`NGAY_SINH` AS `NGAY_SINH`,`truong`.`TEN_TRUONG` AS `TEN_TRUONG`,`gv`.`USERNAME` AS `USERNAME`,`lop`.`TEN_LOP` AS `TEN_LOP`,`lop`.`MA_LOP` AS `MA_LOP`,`topic`.`ID_TOPIC` AS `ID_TOPIC` from (((`giaovien` `gv` join `lop` on((`gv`.`MA_GV` = `lop`.`MA_GV`))) join `truong` on((`truong`.`MA_TRUONG` = `gv`.`MA_TRUONG`))) join `topic` on((`topic`.`MA_LOP` = `lop`.`MA_LOP`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_lichthi`
--

/*!50001 DROP VIEW IF EXISTS `v_lichthi`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
  /*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
  /*!50001 VIEW `v_lichthi` AS select `lt`.`HOC_KY` AS `HOC_KY`,`lt`.`MA_MH` AS `MA_MH`,`mh`.`TEN_MH` AS `TEN_MH`,`lt`.`MA_LOP` AS `MA_LOP`,`lop`.`TEN_LOP` AS `TEN_LOP`,`lt`.`NGAY_THI` AS `NGAY_THI`,`lt`.`TIET_BAT_DAU` AS `TIET_BAT_DAU`,`lt`.`THOI_GIAN_THI` AS `THOI_GIAN_THI` from ((`lichthi` `lt` join `lop` on((`lt`.`MA_LOP` = `lop`.`MA_LOP`))) join `monhoc` `mh` on((`lt`.`MA_MH` = `mh`.`MA_MH`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_phtheolop`
--

/*!50001 DROP VIEW IF EXISTS `v_phtheolop`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
  /*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
  /*!50001 VIEW `v_phtheolop` AS select `ph`.`MA_PH` AS `MA_PH`,`ph`.`TEN_HO` AS `TEN_HO`,`ph`.`GIOITINH` AS `GIOITINH`,`ph`.`NGAYSINH` AS `NGAYSINH`,`ph`.`QUEQUAN` AS `QUEQUAN`,`ph`.`USERNAME` AS `USERNAME`,`hsl`.`MA_LOP` AS `MA_LOP` from (((`phuhuynh` `ph` join `phuhuynhhs` `phhs` on((`ph`.`MA_PH` = `phhs`.`MA_PH`))) join `hocsinh` `hs` on((`hs`.`MA_HS` = `phhs`.`MA_HS`))) join `hocsinhlop` `hsl` on((`hs`.`MA_HS` = `hsl`.`MA_HS`))) group by `ph`.`MA_PH`,`ph`.`TEN_HO`,`ph`.`GIOITINH`,`ph`.`NGAYSINH`,`ph`.`QUEQUAN`,`ph`.`USERNAME`,`hsl`.`MA_LOP` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_tkb`
--

/*!50001 DROP VIEW IF EXISTS `v_tkb`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
  /*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
  /*!50001 VIEW `v_tkb` AS select `tkb`.`MA_GV` AS `MA_GV`,`tkb`.`MA_LOP` AS `MA_LOP`,`lop`.`TEN_LOP` AS `TEN_LOP`,`tkb`.`MA_MH` AS `MA_MH`,`mh`.`TEN_MH` AS `TEN_MH`,`tkb`.`HOC_KY` AS `HOC_KY`,`tkb`.`THU` AS `THU`,`tkb`.`TIET` AS `TIET` from ((`thoikhoabieu` `tkb` join `lop` on((`tkb`.`MA_LOP` = `lop`.`MA_LOP`))) join `monhoc` `mh` on((`mh`.`MA_MH` = `tkb`.`MA_MH`))) */;
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

-- Dump completed on 2017-06-26 17:33:06

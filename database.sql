-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.22-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for test


-- Dumping structure for table test.chitietbangdiem
CREATE TABLE IF NOT EXISTS `chitietbangdiem` (
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

-- Dumping data for table test.chitietbangdiem: ~17 rows (approximately)
/*!40000 ALTER TABLE `chitietbangdiem` DISABLE KEYS */;
INSERT INTO `chitietbangdiem` (`MA_MH`, `MA_LOP`, `MA_HS`, `MIENG`, `MLPHUT`, `MTIET`, `CUOIKY`, `TONGKET`, `HOC_KY`) VALUES
	(1, 1, 5, 8, 8, 8, 8, 8, 1),
	(2, 1, 5, 7, 7, 7, 7, 7, 1),
	(3, 1, 5, 9, 9, 9, 9, 9, 1),
	(1, 1, 6, 7, 7, 7, 7, 7, 1),
	(2, 1, 6, 8, 8, 8, 8, 8, 1),
	(3, 1, 6, 6, 6, 6, 6, 6, 1),
	(4, 1, 5, 8.8, 8.3, 6.2, 5.5, 7.8, 1),
	(5, 1, 5, 7.8, 6, 8.5, 7.5, 8.2, 1),
	(6, 1, 5, 6.7, 7, 8, 9, 8.8, 1),
	(4, 1, 6, 8, 7.6, 8, 6, 7.5, 1),
	(5, 1, 6, 6.6, 7, 8, 6.5, 6.8, 1),
	(6, 1, 6, 9, 6, 7, 5, 7.5, 1),
	(7, 1, 5, 8, 8.5, 8, 9.5, 9, 1),
	(8, 1, 5, 7, 7, 7, 7, 7, 1),
	(9, 1, 5, 5, 6, 7, 8, 6.7, 1),
	(9, 1, 6, 8, 8, 9, 8, 8.8, 1),
	(5, 1, 6, 2, 3, 4, 5.4, 4.6, 1);
/*!40000 ALTER TABLE `chitietbangdiem` ENABLE KEYS */;

-- Dumping structure for table test.chucvu
CREATE TABLE IF NOT EXISTS `chucvu` (
  `CHUCVU` varchar(20) NOT NULL,
  PRIMARY KEY (`CHUCVU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table test.chucvu: ~3 rows (approximately)
/*!40000 ALTER TABLE `chucvu` DISABLE KEYS */;
INSERT INTO `chucvu` (`CHUCVU`) VALUES
	('GIAOVIEN'),
	('HOCSINH'),
	('PHUHUYNH');
/*!40000 ALTER TABLE `chucvu` ENABLE KEYS */;

-- Dumping structure for table test.cmt
CREATE TABLE IF NOT EXISTS `cmt` (
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

-- Dumping data for table test.cmt: ~22 rows (approximately)
/*!40000 ALTER TABLE `cmt` DISABLE KEYS */;
INSERT INTO `cmt` (`ID_CMT`, `ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES
	(17, 1, 'HS001', 'Hôm nay là hạn chót nộp bài tập ngày 21/6 nhé các em', '2017-06-21 14:04:00'),
	(18, 1, 'HS002', 'Các em chuẩn bị bài trước cho ngày mai .', '2017-06-23 17:22:47'),
	(19, 1, 'HS001', 'Thông báo thứ 3', '2017-06-21 14:04:00'),
	(20, 1, 'HS002', 'BLA BLE BLO 3', '2017-06-21 14:04:00'),
	(21, 1, 'HS001', 'BLA BLE BLO 4', '2017-06-21 14:04:00'),
	(22, 1, 'HS002', 'BLA BLE BLO D', '2017-06-21 14:04:00'),
	(23, 1, 'HS001', 'BLA BLE BLO', '2017-06-21 14:04:00'),
	(24, 1, 'HS002', 'BLA BLE BLO', '2017-06-21 14:04:00'),
	(25, 1, 'HS001', 'BLA BLE BLO', '2017-06-21 14:04:01'),
	(26, 1, 'HS002', 'BLA BLE BLO', '2017-06-21 14:04:01'),
	(27, 1, 'HS001', 'BLA BLE BLO', '2017-06-21 14:04:01'),
	(28, 1, 'HS002', 'BLA BLE BLO', '2017-06-21 14:04:01'),
	(29, 1, 'HS001', 'BLA BLE BLO', '2017-06-21 14:04:01'),
	(30, 1, 'HS002', 'BLA BLE BLO', '2017-06-21 14:04:01'),
	(31, 1, 'HS001', 'BLA BLE BLO', '2017-06-21 14:04:01'),
	(32, 1, 'HS001', 'BLA BLE BL11111O', '2017-06-22 16:47:17'),
	(33, 2, 'HS001', 'BLA BLE BLO', '2017-06-22 17:34:23'),
	(34, 4, 'HS001', 'BLA BLE BLO', '2017-06-22 17:34:44'),
	(35, 1, 'HS001', 'SDAASDASDASDAS', '2017-06-23 13:07:00'),
	(36, 1, 'PH001', 'BLA BLE BLO AAAAAAA222222', '2017-06-23 17:35:27'),
	(37, 4, 'PH001', 'BLA BLE BLO', '2017-06-24 08:35:30'),
	(38, 4, 'PH001', 'BLA BLE BLO bé này bé nọ thế kỷ hai mốt', '2017-06-26 10:36:04');
/*!40000 ALTER TABLE `cmt` ENABLE KEYS */;

-- Dumping structure for table test.giaovien
CREATE TABLE IF NOT EXISTS `giaovien` (
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

-- Dumping data for table test.giaovien: ~5 rows (approximately)
/*!40000 ALTER TABLE `giaovien` DISABLE KEYS */;
INSERT INTO `giaovien` (`MA_GV`, `TEN_GV`, `GIOI_TINH`, `QUE_QUAN`, `NGAY_SINH`, `MA_TRUONG`, `USERNAME`) VALUES
	(1, 'NGUYEN THI THAO', 'NU ', 'TP HCM', '1993-02-01 17:00:00', 1, 'admin2'),
	(2, 'NGO BAO CHAU', 'NAM', 'TP HCM', '1989-03-22 17:00:00', 1, 'GV002'),
	(3, 'NGUYEN HOANG KHAC HIEU', 'NAM ', 'HA NOI', '1991-04-03 17:00:00', 1, NULL),
	(4, 'NGO VAN KHUONG', 'NAM', 'TP HCM ', '1991-03-01 17:00:00', 1, NULL),
	(5, 'LE HUYNH ANH TRI', 'NAM ', 'QUANG NGAI', '1990-01-01 17:00:00', 1, NULL);
/*!40000 ALTER TABLE `giaovien` ENABLE KEYS */;

-- Dumping structure for table test.hocsinh
CREATE TABLE IF NOT EXISTS `hocsinh` (
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table test.hocsinh: ~6 rows (approximately)
/*!40000 ALTER TABLE `hocsinh` DISABLE KEYS */;
INSERT INTO `hocsinh` (`MA_HS`, `TEN_HS`, `USERNAME`, `NGAY_SINH`, `GIOI_TINH`, `MA_TRUONG`, `QUE_QUAN`, `SO_DT`) VALUES
	(5, 'LE ANH TRI', 'HS004', '2017-06-21 14:57:36', 'NAM', 1, 'QUANG NGAI', 1222977046),
	(6, 'PHAM LE CONG PHUONG', 'HS002', '2017-06-21 13:57:41', 'NAM', 1, 'QUANG NAM', 123213123),
	(7, 'LUONG PHU AN', 'HS003', '2017-06-21 13:57:42', 'NAM', 1, 'TAY NINH', 11313413),
	(8, 'NGO VAN KHUONG', 'HS001', '2017-06-21 13:57:41', 'NAM', 1, 'QUANG NAM', 123123312),
	(9, 'NHAN VUONG NGOC BAO', NULL, '1996-08-24 17:00:00', 'NU', 1, 'BEN TRE', 852416246),
	(10, 'QUACH THI PHUNG', NULL, '1996-03-21 17:00:00', 'NU', 1, 'BIEN HOA', 564892474);
/*!40000 ALTER TABLE `hocsinh` ENABLE KEYS */;

-- Dumping structure for table test.hocsinhlop
CREATE TABLE IF NOT EXISTS `hocsinhlop` (
  `MA_HS` int(11) NOT NULL,
  `MA_LOP` int(11) NOT NULL,
  PRIMARY KEY (`MA_HS`,`MA_LOP`),
  KEY `FK_HSLOP` (`MA_LOP`),
  CONSTRAINT `FK_HSH` FOREIGN KEY (`MA_HS`) REFERENCES `hocsinh` (`MA_HS`),
  CONSTRAINT `FK_HSLOP` FOREIGN KEY (`MA_LOP`) REFERENCES `lop` (`MA_LOP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table test.hocsinhlop: ~6 rows (approximately)
/*!40000 ALTER TABLE `hocsinhlop` DISABLE KEYS */;
INSERT INTO `hocsinhlop` (`MA_HS`, `MA_LOP`) VALUES
	(5, 1),
	(6, 1),
	(7, 1),
	(8, 2),
	(9, 2),
	(10, 2);
/*!40000 ALTER TABLE `hocsinhlop` ENABLE KEYS */;

-- Dumping structure for table test.lichthi
CREATE TABLE IF NOT EXISTS `lichthi` (
  `HOC_KY` int(11) NOT NULL,
  `MA_MH` int(11) DEFAULT NULL,
  `MA_LOP` int(11) DEFAULT NULL,
  `NGAY_THI` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `TIET_BAT_DAU` int(11) DEFAULT NULL,
  `THOI_GIAN_THI` int(11) DEFAULT NULL,
  `MA_GV_CT` int(11) DEFAULT NULL,
  KEY `FK_MAMH` (`MA_MH`),
  KEY `FK_LLT` (`MA_LOP`),
  CONSTRAINT `FK_LLT` FOREIGN KEY (`MA_LOP`) REFERENCES `lop` (`MA_LOP`),
  CONSTRAINT `FK_MAMH` FOREIGN KEY (`MA_MH`) REFERENCES `monhoc` (`MA_MH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table test.lichthi: ~14 rows (approximately)
/*!40000 ALTER TABLE `lichthi` DISABLE KEYS */;
INSERT INTO `lichthi` (`HOC_KY`, `MA_MH`, `MA_LOP`, `NGAY_THI`, `TIET_BAT_DAU`, `THOI_GIAN_THI`, `MA_GV_CT`) VALUES
	(1, 1, 1, '2017-09-08 17:00:00', 1, 90, 1),
	(1, 2, 1, '2017-06-01 17:00:00', 3, 120, 2),
	(1, 3, 1, '2017-06-02 17:00:00', 5, 120, 5),
	(1, 4, 1, '2017-05-31 17:00:00', 2, 60, 4),
	(1, 5, 1, '2017-09-08 17:00:00', 4, 90, 3),
	(1, 6, 1, '2017-06-01 17:00:00', 3, 120, 5),
	(1, 7, 1, '2017-06-02 17:00:00', 5, 120, 2),
	(1, 1, 2, '2017-04-03 17:00:00', 1, 90, 2),
	(1, 2, 2, '2017-05-04 17:00:00', 1, 120, 1),
	(1, 3, 2, '2017-05-05 17:00:00', 3, 120, 3),
	(1, 4, 2, '2017-05-31 17:00:00', 2, 60, 4),
	(1, 5, 2, '2017-09-08 17:00:00', 4, 90, 3),
	(1, 6, 2, '2017-06-01 17:00:00', 3, 120, 1),
	(1, 7, 2, '2017-06-02 17:00:00', 5, 120, 2);
/*!40000 ALTER TABLE `lichthi` ENABLE KEYS */;

-- Dumping structure for table test.lop
CREATE TABLE IF NOT EXISTS `lop` (
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

-- Dumping data for table test.lop: ~2 rows (approximately)
/*!40000 ALTER TABLE `lop` DISABLE KEYS */;
INSERT INTO `lop` (`MA_TRUONG`, `NAM_HOC`, `MA_LOP`, `MA_GV`, `SI_SO`, `TEN_LOP`) VALUES
	(1, 2017, 1, 1, 40, '12A1'),
	(1, 2017, 2, 2, 41, '12A2');
/*!40000 ALTER TABLE `lop` ENABLE KEYS */;

-- Dumping structure for table test.maxacnhan
CREATE TABLE IF NOT EXISTS `maxacnhan` (
  `MAXACNHAN` int(11) NOT NULL,
  `MACHUCVU` int(11) NOT NULL,
  `CHUCVU` varchar(20) NOT NULL,
  PRIMARY KEY (`MAXACNHAN`,`MACHUCVU`),
  KEY `FK_MC` (`CHUCVU`),
  CONSTRAINT `FK_MC` FOREIGN KEY (`CHUCVU`) REFERENCES `chucvu` (`CHUCVU`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table test.maxacnhan: ~9 rows (approximately)
/*!40000 ALTER TABLE `maxacnhan` DISABLE KEYS */;
INSERT INTO `maxacnhan` (`MAXACNHAN`, `MACHUCVU`, `CHUCVU`) VALUES
	(111, 1, 'GIAOVIEN'),
	(120, 2, 'GIAOVIEN'),
	(113, 5, 'HOCSINH'),
	(115, 6, 'HOCSINH'),
	(116, 7, 'HOCSINH'),
	(117, 8, 'HOCSINH'),
	(114, 3, 'PHUHUYNH'),
	(118, 1, 'PHUHUYNH'),
	(119, 2, 'PHUHUYNH');
/*!40000 ALTER TABLE `maxacnhan` ENABLE KEYS */;

-- Dumping structure for table test.monhoc
CREATE TABLE IF NOT EXISTS `monhoc` (
  `MA_MH` int(11) NOT NULL AUTO_INCREMENT,
  `TEN_MH` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`MA_MH`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Dumping data for table test.monhoc: ~9 rows (approximately)
/*!40000 ALTER TABLE `monhoc` DISABLE KEYS */;
INSERT INTO `monhoc` (`MA_MH`, `TEN_MH`) VALUES
	(1, 'TOAN'),
	(2, 'NGU VAN'),
	(3, 'ANH VAN'),
	(4, 'VAT LY'),
	(5, 'HOA HOC'),
	(6, 'SINH HOC'),
	(7, 'LICH SU'),
	(8, 'DIA LY'),
	(9, 'GDCD');
/*!40000 ALTER TABLE `monhoc` ENABLE KEYS */;

-- Dumping structure for table test.phuhuynh
CREATE TABLE IF NOT EXISTS `phuhuynh` (
  `MA_PH` int(11) NOT NULL AUTO_INCREMENT,
  `TEN_HO` varchar(50) NOT NULL,
  `NGAYSINH` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `QUEQUAN` varchar(50) DEFAULT NULL,
  `USERNAME` varchar(200) DEFAULT NULL,
  `GIOITINH` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MA_PH`),
  KEY `FK_PH` (`USERNAME`),
  CONSTRAINT `FK_PH` FOREIGN KEY (`USERNAME`) REFERENCES `taikhoan` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Dumping data for table test.phuhuynh: ~5 rows (approximately)
/*!40000 ALTER TABLE `phuhuynh` DISABLE KEYS */;
INSERT INTO `phuhuynh` (`MA_PH`, `TEN_HO`, `NGAYSINH`, `QUEQUAN`, `USERNAME`, `GIOITINH`) VALUES
	(1, 'LE VAN BANG', '2017-06-30 03:59:27', 'QUANG NGAI', 'PH001', 'NAM'),
	(2, 'NGUYEN THI THU', '2017-06-30 04:00:33', 'QUANG NAM', 'PH002', 'NU'),
	(3, 'PHAN VAN TAI', '2017-06-30 04:00:42', 'TAY NINH', 'PH003', 'NAM'),
	(8, 'LE CONG TUAN', '2017-06-30 04:00:53', 'CAO BANG', NULL, 'NAM'),
	(9, 'TRAN THI NGOC HAN', '2017-06-30 04:01:13', 'BINH DUONG', NULL, 'NU');
/*!40000 ALTER TABLE `phuhuynh` ENABLE KEYS */;

-- Dumping structure for table test.phuhuynhhs
CREATE TABLE IF NOT EXISTS `phuhuynhhs` (
  `MA_PH` int(11) NOT NULL,
  `MA_HS` int(11) NOT NULL,
  PRIMARY KEY (`MA_PH`,`MA_HS`),
  KEY `FK_PHPP` (`MA_HS`),
  CONSTRAINT `FK_PHPP` FOREIGN KEY (`MA_HS`) REFERENCES `hocsinh` (`MA_HS`),
  CONSTRAINT `FK_PPPP` FOREIGN KEY (`MA_PH`) REFERENCES `phuhuynh` (`MA_PH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table test.phuhuynhhs: ~6 rows (approximately)
/*!40000 ALTER TABLE `phuhuynhhs` DISABLE KEYS */;
INSERT INTO `phuhuynhhs` (`MA_PH`, `MA_HS`) VALUES
	(1, 5),
	(1, 6),
	(2, 7),
	(3, 8),
	(8, 10),
	(9, 9);
/*!40000 ALTER TABLE `phuhuynhhs` ENABLE KEYS */;

-- Dumping structure for table test.taikhoan
CREATE TABLE IF NOT EXISTS `taikhoan` (
  `USERID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(200) DEFAULT NULL,
  `PASSWD` varchar(200) DEFAULT NULL,
  `CHUCVU` varchar(20) DEFAULT NULL,
  `MACHUCVU` int(11) DEFAULT NULL,
  `TOKEN` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`USERID`),
  UNIQUE KEY `USERNAME` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Dumping data for table test.taikhoan: ~10 rows (approximately)
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` (`USERID`, `USERNAME`, `PASSWD`, `CHUCVU`, `MACHUCVU`, `TOKEN`) VALUES
	(1, 'HS004', '$2a$10$6EQ1CrT6kH./UtjkSKpX9e3eOCxdu8rhQ3Wwx1hLjQNYxL/8dFlMO', 'HOCSINH', 5, NULL),
	(2, 'ADMIN', '$2a$10$AR5eTjmfk8ydCnd/RgLRjODXNDKKLVc64gAWLpeg7Y1G8e4SKMyK.', 'GIAOVIEN', 1, NULL),
	(3, 'PH001', '$2a$10$fFhhGLyff0litXOjYAgh4eKVVMy/rM51jdcAhzBLOJPk17Q3PbD7y', 'PHUHUYNH', 2, NULL),
	(4, 'PH002', '$2a$10$T/tvc2AY0rv7qXp1wxSJ8.FJAn0HN9t.U0NqQEGzqZ6NKsfitaJ7.', 'PHUHUYNH', 2, NULL),
	(5, 'PH003', '$2a$10$8eq009yEbizqkhvf7dUKiOm/yY8UnlNJbq7HWfQhuhhFQhQN0aYxS', 'PHUHUYNH', 2, NULL),
	(6, 'GV002', 'GV002', 'GIAOVIEN', 2, NULL),
	(8, 'HS001', '$2a$10$D7HMvWpu35tXNU6e7YrODOzVq6DqmPvCQZD7NDT6oJ9Bi0FBYtjGu', 'HOCSINH', 8, NULL),
	(9, 'HS002', '$2a$10$LhFYAJ7XijgHGVPfqdLqT.Zx11VLsaqP0sg1tCTyfOey4WYrwDZau', 'HOCSINH', 6, NULL),
	(10, 'HS003', '$2a$10$RcDDv0one8rJPG.gZ/itGeeHhFNtFtzn2IWj9661zwRgSjDDYLWpm', 'HOCSINH', 7, NULL),
	(11, 'admin2', '$2a$10$aSR1dAqElYqU05IibkD2bui33zIltZ/RXXQGJ6/tvBNiwDHEFps7m', 'GIAOVIEN', 1, NULL);
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;

-- Dumping structure for procedure test.THEM_TAIKHOAN
DELIMITER //
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
END//
DELIMITER ;

-- Dumping structure for table test.thoikhoabieu
CREATE TABLE IF NOT EXISTS `thoikhoabieu` (
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

-- Dumping data for table test.thoikhoabieu: ~38 rows (approximately)
/*!40000 ALTER TABLE `thoikhoabieu` DISABLE KEYS */;
INSERT INTO `thoikhoabieu` (`MA_GV`, `MA_LOP`, `MA_MH`, `HOC_KY`, `THU`, `TIET`) VALUES
	(1, 1, 1, 1, 2, 1),
	(1, 1, 1, 1, 2, 2),
	(1, 2, 1, 1, 3, 1),
	(2, 1, 1, 1, 5, 1),
	(2, 1, 1, 1, 5, 2),
	(2, 1, 1, 1, 6, 2),
	(2, 2, 1, 1, 2, 1),
	(2, 2, 1, 1, 2, 2),
	(2, 1, 2, 1, 2, 3),
	(2, 1, 2, 1, 2, 4),
	(2, 2, 2, 1, 3, 2),
	(2, 2, 2, 1, 4, 1),
	(2, 2, 2, 1, 4, 2),
	(3, 1, 2, 1, 3, 1),
	(3, 1, 2, 1, 3, 2),
	(3, 1, 2, 1, 5, 3),
	(3, 1, 2, 1, 5, 4),
	(3, 1, 2, 1, 6, 4),
	(4, 2, 2, 1, 2, 3),
	(1, 2, 3, 1, 5, 4),
	(1, 2, 3, 1, 5, 5),
	(3, 1, 3, 1, 2, 5),
	(3, 2, 3, 1, 3, 3),
	(3, 2, 3, 1, 4, 3),
	(3, 2, 3, 1, 4, 4),
	(4, 1, 3, 1, 5, 5),
	(2, 1, 4, 1, 6, 1),
	(3, 1, 6, 1, 6, 3),
	(5, 1, 6, 1, 3, 4),
	(5, 1, 6, 1, 4, 1),
	(5, 1, 6, 1, 4, 2),
	(5, 2, 6, 1, 3, 4),
	(4, 1, 7, 1, 3, 3),
	(4, 1, 7, 1, 3, 4),
	(4, 2, 7, 1, 3, 5),
	(5, 2, 7, 1, 5, 1),
	(5, 2, 7, 1, 5, 2),
	(3, 2, 9, 1, 5, 3);
/*!40000 ALTER TABLE `thoikhoabieu` ENABLE KEYS */;

-- Dumping structure for table test.thongbao
CREATE TABLE IF NOT EXISTS `thongbao` (
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

-- Dumping data for table test.thongbao: ~7 rows (approximately)
/*!40000 ALTER TABLE `thongbao` DISABLE KEYS */;
INSERT INTO `thongbao` (`ID_TB`, `NGUOIGUI`, `NGUOINHAN`, `TIEU_DE`, `NOI_DUNG`, `THOI_GIAN`) VALUES
	(1, 'ADMIN', 'PH001', 'Thông báo chuẩn bị bài.', 'Các em chuẩn bị bài kỹ ngày mai có dự giờ !', '2017-06-23 04:03:06'),
	(2, 'ADMIN', 'PH002', 'Thông báo kiểm tra 15 phút', 'Ngày mai các em kiểm tra 15 phút môn Anh nhé', '2017-06-23 04:03:07'),
	(3, 'ADMIN', 'PH003', 'Thông báo kiểm tra 1 tiết', 'Ngày mai các em kiểm tra 1 tiết Toán', '2017-06-23 04:03:07'),
	(4, 'ADMIN', 'HS001', 'Thông báo nghỉ học', 'Ngày mai các thầy cô phải đi công tác, các em được nghỉ', '2017-06-23 04:03:07'),
	(5, 'ADMIN', 'HS002', 'Thông báo lịch thi', 'Đã có lịch thi, các em lên ứng dụng xem lịch thi của mình !', '2017-06-23 04:03:07'),
	(6, 'ADMIN', 'HS003', 'Thông báo đã có điểm thi học kỳ I', 'Đã có điểm thi học kỳ I các em lên ứng dụng xem điểm của mình nhé !', '2017-06-23 04:03:07'),
	(7, 'ADMIN', 'HS004', 'Thông báo tổng kết học kỳ I', 'Ngày mai 7 giờ các em có mặt tại lớp làm lễ tổng kết học kỳ I', '2017-06-23 04:03:07');
/*!40000 ALTER TABLE `thongbao` ENABLE KEYS */;

-- Dumping structure for table test.topic
CREATE TABLE IF NOT EXISTS `topic` (
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

-- Dumping data for table test.topic: ~4 rows (approximately)
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` (`ID_TOPIC`, `USERNAME`, `MA_LOP`, `THOI_GIAN`, `CHU_DE`, `NOI_DUNG`, `SO_CMT`) VALUES
	(1, 'HS004', 1, '2017-06-21 13:52:18', 'Bài tập Anh làm thêm', 'Các bạn lên đây cùng làm bài tập Anh nhé', 18),
	(2, 'HS004', 1, '2017-06-22 17:17:35', 'Bộ đề thi đại học', 'Bộ đề thi đại học các năm cho các bạn tham khảo', 1),
	(3, 'HS004', 1, '2017-06-22 17:20:59', 'Bộ đề thi tốt nghiệp', 'Đề ôn thi tốt nghiệp', 0),
	(4, 'HS004', 2, '2017-06-22 17:32:29', 'Toán nâng cao', 'Bài tập toán nâng cao sưu tầm của thầy Châu ', 3);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;

-- Dumping structure for table test.truong
CREATE TABLE IF NOT EXISTS `truong` (
  `MA_TRUONG` int(11) NOT NULL AUTO_INCREMENT,
  `TEN_TRUONG` varchar(30) NOT NULL,
  `DIA_CHI` varchar(50) NOT NULL,
  PRIMARY KEY (`MA_TRUONG`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table test.truong: ~2 rows (approximately)
/*!40000 ALTER TABLE `truong` DISABLE KEYS */;
INSERT INTO `truong` (`MA_TRUONG`, `TEN_TRUONG`, `DIA_CHI`) VALUES
	(1, 'THPT TRAN QUOC TUAN', 'TP QUANG NGAI, QUANG NGAI'),
	(2, 'THPT TRAN HUNG DAO', 'TAY NINH');
/*!40000 ALTER TABLE `truong` ENABLE KEYS */;

-- Dumping structure for view test.v_bangdiem
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `v_bangdiem` (
	`TEN_HS` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`MA_HS` INT(11) NOT NULL,
	`TEN_LOP` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`TEN_MH` VARCHAR(10) NULL COLLATE 'utf8_general_ci',
	`MIENG` DOUBLE NULL,
	`MLPHUT` DOUBLE NULL,
	`MTIET` DOUBLE NULL,
	`CUOIKY` DOUBLE NULL,
	`TONGKET` DOUBLE NULL,
	`HOC_KY` INT(11) NULL,
	`MA_LOP` INT(11) NOT NULL
) ENGINE=MyISAM;

-- Dumping structure for view test.v_infoparents
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `v_infoparents` (
	`MA_PH` INT(11) NOT NULL,
	`TEN_HO` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`NGAYSINH` TIMESTAMP NOT NULL,
	`QUEQUAN` VARCHAR(50) NULL COLLATE 'utf8_general_ci',
	`USERNAME` VARCHAR(200) NULL COLLATE 'utf8_general_ci',
	`GIOITINH` VARCHAR(45) NULL COLLATE 'utf8_general_ci',
	`MA_HS` INT(11) NOT NULL
) ENGINE=MyISAM;

-- Dumping structure for view test.v_infostd
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `v_infostd` (
	`MA_HS` INT(11) NOT NULL,
	`TEN_HS` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`NGAY_SINH` TIMESTAMP NOT NULL,
	`GIOI_TINH` VARCHAR(10) NOT NULL COLLATE 'utf8_general_ci',
	`MA_LOP` INT(11) NOT NULL,
	`TEN_LOP` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`MA_TRUONG` INT(11) NOT NULL,
	`TEN_TRUONG` VARCHAR(30) NOT NULL COLLATE 'utf8_general_ci',
	`QUE_QUAN` VARCHAR(60) NOT NULL COLLATE 'utf8_general_ci',
	`SO_DT` INT(11) NULL,
	`USERNAME` VARCHAR(200) NULL COLLATE 'utf8_general_ci'
) ENGINE=MyISAM;

-- Dumping structure for view test.v_infoteacher
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `v_infoteacher` (
	`MA_GV` INT(11) NOT NULL,
	`TEN_GV` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`GIOI_TINH` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`QUE_QUAN` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`NGAY_SINH` TIMESTAMP NULL,
	`TEN_TRUONG` VARCHAR(30) NOT NULL COLLATE 'utf8_general_ci',
	`USERNAME` VARCHAR(200) NULL COLLATE 'utf8_general_ci',
	`TEN_LOP` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`MA_LOP` INT(11) NOT NULL
) ENGINE=MyISAM;

-- Dumping structure for view test.v_lichthi
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `v_lichthi` (
	`HOC_KY` INT(11) NOT NULL,
	`MA_MH` INT(11) NULL,
	`TEN_MH` VARCHAR(10) NULL COLLATE 'utf8_general_ci',
	`MA_LOP` INT(11) NULL,
	`TEN_LOP` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`NGAY_THI` TIMESTAMP NOT NULL,
	`TIET_BAT_DAU` INT(11) NULL,
	`THOI_GIAN_THI` INT(11) NULL,
	`MA_GV_CT` INT(11) NULL,
	`TEN_GV` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci'
) ENGINE=MyISAM;

-- Dumping structure for view test.v_phtheolop
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `v_phtheolop` (
	`MA_PH` INT(11) NOT NULL,
	`TEN_HO` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`GIOITINH` VARCHAR(45) NULL COLLATE 'utf8_general_ci',
	`NGAYSINH` TIMESTAMP NOT NULL,
	`QUEQUAN` VARCHAR(50) NULL COLLATE 'utf8_general_ci',
	`USERNAME` VARCHAR(200) NULL COLLATE 'utf8_general_ci',
	`MA_LOP` INT(11) NOT NULL
) ENGINE=MyISAM;

-- Dumping structure for view test.v_teacherclass
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `v_teacherclass` (
	`NAM_HOC` INT(10) NOT NULL,
	`MA_GV` INT(11) NOT NULL,
	`MA_LOP` INT(11) NOT NULL,
	`TEN_LOP` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci'
) ENGINE=MyISAM;

-- Dumping structure for view test.v_tkb
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `v_tkb` (
	`MA_GV` INT(11) NOT NULL,
	`MA_LOP` INT(11) NOT NULL,
	`TEN_LOP` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`MA_MH` INT(11) NOT NULL,
	`TEN_MH` VARCHAR(10) NULL COLLATE 'utf8_general_ci',
	`HOC_KY` INT(11) NOT NULL,
	`THU` INT(11) NOT NULL,
	`TIET` INT(11) NOT NULL
) ENGINE=MyISAM;

-- Dumping structure for trigger test.T_CMTP
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `T_CMTP` AFTER INSERT ON `cmt` FOR EACH ROW BEGIN
		UPDATE TOPIC SET TOPIC.SO_CMT = TOPIC.SO_CMT + 1 WHERE NEW.ID_TOPIC=topic.ID_TOPIC;
    END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for view test.v_bangdiem
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `v_bangdiem`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` VIEW `v_bangdiem` AS select `hs`.`TEN_HS` AS `TEN_HS`,`hs`.`MA_HS` AS `MA_HS`,`l`.`TEN_LOP` AS `TEN_LOP`,`mh`.`TEN_MH` AS `TEN_MH`,`ct`.`MIENG` AS `MIENG`,`ct`.`MLPHUT` AS `MLPHUT`,`ct`.`MTIET` AS `MTIET`,`ct`.`CUOIKY` AS `CUOIKY`,`ct`.`TONGKET` AS `TONGKET`,`ct`.`HOC_KY` AS `HOC_KY`,`l`.`MA_LOP` AS `MA_LOP` from (((`hocsinh` `hs` join `chitietbangdiem` `ct` on((`hs`.`MA_HS` = `ct`.`MA_HS`))) join `monhoc` `mh` on((`ct`.`MA_MH` = `mh`.`MA_MH`))) join `lop` `l` on((`ct`.`MA_LOP` = `l`.`MA_LOP`))) ;

-- Dumping structure for view test.v_infoparents
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `v_infoparents`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` VIEW `v_infoparents` AS select `ph`.`MA_PH` AS `MA_PH`,`ph`.`TEN_HO` AS `TEN_HO`,`ph`.`NGAYSINH` AS `NGAYSINH`,`ph`.`QUEQUAN` AS `QUEQUAN`,`ph`.`USERNAME` AS `USERNAME`,`ph`.`GIOITINH` AS `GIOITINH`,`phhs`.`MA_HS` AS `MA_HS` from (`phuhuynhhs` `phhs` join `phuhuynh` `ph` on((`phhs`.`MA_PH` = `ph`.`MA_PH`))) ;

-- Dumping structure for view test.v_infostd
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `v_infostd`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` VIEW `v_infostd` AS select `hsl`.`MA_HS` AS `MA_HS`,`hs`.`TEN_HS` AS `TEN_HS`,`hs`.`NGAY_SINH` AS `NGAY_SINH`,`hs`.`GIOI_TINH` AS `GIOI_TINH`,`hsl`.`MA_LOP` AS `MA_LOP`,`lop`.`TEN_LOP` AS `TEN_LOP`,`lop`.`MA_TRUONG` AS `MA_TRUONG`,`truong`.`TEN_TRUONG` AS `TEN_TRUONG`,`hs`.`QUE_QUAN` AS `QUE_QUAN`,`hs`.`SO_DT` AS `SO_DT`,`hs`.`USERNAME` AS `USERNAME` from (((`hocsinhlop` `hsl` join `hocsinh` `hs` on((`hs`.`MA_HS` = `hsl`.`MA_HS`))) join `lop` on((`lop`.`MA_LOP` = `hsl`.`MA_LOP`))) join `truong` on((`truong`.`MA_TRUONG` = `lop`.`MA_TRUONG`))) ;

-- Dumping structure for view test.v_infoteacher
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `v_infoteacher`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` VIEW `v_infoteacher` AS select `gv`.`MA_GV` AS `MA_GV`,`gv`.`TEN_GV` AS `TEN_GV`,`gv`.`GIOI_TINH` AS `GIOI_TINH`,`gv`.`QUE_QUAN` AS `QUE_QUAN`,`gv`.`NGAY_SINH` AS `NGAY_SINH`,`truong`.`TEN_TRUONG` AS `TEN_TRUONG`,`gv`.`USERNAME` AS `USERNAME`,`lop`.`TEN_LOP` AS `TEN_LOP`,`lop`.`MA_LOP` AS `MA_LOP` from (((`giaovien` `gv` join `lop` on((`gv`.`MA_GV` = `lop`.`MA_GV`))) join `truong` on((`truong`.`MA_TRUONG` = `gv`.`MA_TRUONG`))) join `topic` on((`topic`.`MA_LOP` = `lop`.`MA_LOP`))) group by `gv`.`MA_GV` ;

-- Dumping structure for view test.v_lichthi
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `v_lichthi`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` VIEW `v_lichthi` AS select `lt`.`HOC_KY` AS `HOC_KY`,`lt`.`MA_MH` AS `MA_MH`,`mh`.`TEN_MH` AS `TEN_MH`,`lt`.`MA_LOP` AS `MA_LOP`,`lop`.`TEN_LOP` AS `TEN_LOP`,`lt`.`NGAY_THI` AS `NGAY_THI`,`lt`.`TIET_BAT_DAU` AS `TIET_BAT_DAU`,`lt`.`THOI_GIAN_THI` AS `THOI_GIAN_THI`,`lt`.`MA_GV_CT` AS `MA_GV_CT`,`gv`.`TEN_GV` AS `TEN_GV` from (((`lichthi` `lt` join `lop` on((`lt`.`MA_LOP` = `lop`.`MA_LOP`))) join `monhoc` `mh` on((`lt`.`MA_MH` = `mh`.`MA_MH`))) join `giaovien` `gv` on((`lt`.`MA_GV_CT` = `gv`.`MA_GV`))) ;

-- Dumping structure for view test.v_phtheolop
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `v_phtheolop`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` VIEW `v_phtheolop` AS select `ph`.`MA_PH` AS `MA_PH`,`ph`.`TEN_HO` AS `TEN_HO`,`ph`.`GIOITINH` AS `GIOITINH`,`ph`.`NGAYSINH` AS `NGAYSINH`,`ph`.`QUEQUAN` AS `QUEQUAN`,`ph`.`USERNAME` AS `USERNAME`,`hsl`.`MA_LOP` AS `MA_LOP` from (((`phuhuynh` `ph` join `phuhuynhhs` `phhs` on((`ph`.`MA_PH` = `phhs`.`MA_PH`))) join `hocsinh` `hs` on((`hs`.`MA_HS` = `phhs`.`MA_HS`))) join `hocsinhlop` `hsl` on((`hs`.`MA_HS` = `hsl`.`MA_HS`))) group by `ph`.`MA_PH`,`ph`.`TEN_HO`,`ph`.`GIOITINH`,`ph`.`NGAYSINH`,`ph`.`QUEQUAN`,`ph`.`USERNAME`,`hsl`.`MA_LOP` ;

-- Dumping structure for view test.v_teacherclass
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `v_teacherclass`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` VIEW `v_teacherclass` AS select `lop`.`NAM_HOC` AS `NAM_HOC`,`gv`.`MA_GV` AS `MA_GV`,`lop`.`MA_LOP` AS `MA_LOP`,`lop`.`TEN_LOP` AS `TEN_LOP` from (((`lop` join `thoikhoabieu` `tkb` on((`lop`.`MA_LOP` = `tkb`.`MA_LOP`))) join `giaovien` `gv` on((`gv`.`MA_GV` = `tkb`.`MA_GV`))) join `monhoc` `mh` on((`mh`.`MA_MH` = `tkb`.`MA_MH`))) group by `gv`.`MA_GV`,`lop`.`MA_LOP` ;

-- Dumping structure for view test.v_tkb
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `v_tkb`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` VIEW `v_tkb` AS select `tkb`.`MA_GV` AS `MA_GV`,`tkb`.`MA_LOP` AS `MA_LOP`,`lop`.`TEN_LOP` AS `TEN_LOP`,`tkb`.`MA_MH` AS `MA_MH`,`mh`.`TEN_MH` AS `TEN_MH`,`tkb`.`HOC_KY` AS `HOC_KY`,`tkb`.`THU` AS `THU`,`tkb`.`TIET` AS `TIET` from ((`thoikhoabieu` `tkb` join `lop` on((`tkb`.`MA_LOP` = `lop`.`MA_LOP`))) join `monhoc` `mh` on((`mh`.`MA_MH` = `tkb`.`MA_MH`))) ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

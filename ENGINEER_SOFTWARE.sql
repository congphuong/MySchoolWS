CREATE DATABASE MYSCHOOL1;
USE MYSCHOOL1;

create table TRUONG(
	MA_TRUONG INT auto_increment,
    TEN_TRUONG nvarchar(30) NOT NULL,
    DIA_CHI nvarchar(50) NOT NULL,
    primary key (MA_TRUONG));

CREATE TABLE CHUCVU(
	CHUCVU VARCHAR(20) NOT NULL,
    CONSTRAINT PK_MCV PRIMARY KEY (CHUCVU)
);

CREATE TABLE MAXACNHAN(
	MAXACNHAN INT NOT NULL,
	MACHUCVU INT(11) NOT NULL,
    CHUCVU VARCHAR(20) NOT NULL,
    CONSTRAINT PK_MXN PRIMARY KEY (MACHUCVU, CHUCVU),
    CONSTRAINT FK_MC FOREIGN KEY (CHUCVU) REFERENCES CHUCVU(CHUCVU)
);

create table TAIKHOAN(
	USERID INT AUTO_INCREMENT,
	USERNAME VARCHAR(200) UNIQUE,
    PASSWD VARCHAR(200),
    CHUCVU VARCHAR(20),
    MACHUCVU INT(11),
    TOKEN VARCHAR(400),
    CONSTRAINT PK_TK PRIMARY KEY (USERID)
);    

CREATE TABLE GIAOVIEN(
	MA_GV int auto_increment,
    TEN_GV NVARCHAR(50) NOT NULL,
    GIOI_TINH VARCHAR(20) NOT NULL,
	QUE_QUAN NVARCHAR(50) NOT NULL,
    MA_TRUONG int NOT NULL,
    USERNAME VARCHAR(200),
    PRIMARY KEY (MA_GV),
    CONSTRAINT PH_TKKK FOREIGN KEY (USERNAME) REFERENCES TAIKHOAN(USERNAME),
    CONSTRAINT PH_TK2K FOREIGN KEY (MA_TRUONG) REFERENCES TRUONG(MA_TRUONG)
);
    
create table LOP(
	MA_TRUONG INT NOT NULL,
    NAM_HOC INT(10),
	MA_LOP int auto_increment,
    MA_GV INT NOT NULL, 
    SI_SO int NOT NULL,
    TEN_LOP varchar(20) NOT NULL,
    primary key(MA_LOP, MA_TRUONG, NAM_HOC),
    CONSTRAINT FK_TL FOREIGN KEY (MA_TRUONG) REFERENCES TRUONG(MA_TRUONG),
    CONSTRAINT FK_LGV FOREIGN KEY (MA_GV) REFERENCES GIAOVIEN(MA_GV)
);
    
create table HOCSINH(
	MA_HS INT NOT NULL AUTO_INCREMENT,
    TEN_HS nvarchar(50) NOT NULL,
    USERNAME VARCHAR(200),
    NGAY_SINH TIMESTAMP,
    GIOI_TINH VARCHAR(10) NOT NULL,
    MA_TRUONG int NOT NULL,
    QUE_QUAN NVARCHAR(60) NOT NULL,
    SO_DT INT,
	primary keY (MA_HS),
    CONSTRAINT FK_HSTK FOREIGN KEY (USERNAME) REFERENCES TAIKHOAN(USERNAME),
    CONSTRAINT FK_HSTRUONG foreign key (MA_TRUONG) REFERENCES TRUONG(MA_TRUONG)
);
    
CREATE TABLE HOCSINHLOP(
	MA_HS INT,
    MA_LOP INT,
    NAMHOC INT,
    CONSTRAINT PK_HSL PRIMARY KEY (MA_HS, MA_LOP, NAMHOC),
    CONSTRAINT FK_HSH FOREIGN KEY (MA_HS) REFERENCES HOCSINH(MA_HS),
    CONSTRAINT FK_HSLOP FOREIGN KEY (MA_LOP) REFERENCES LOP(MA_LOP)
);
    
CREATE TABLE MONHOC(
	MA_MH int auto_increment,
    TEN_MH nvarchar(10),
    PRIMARY KEY (MA_MH));
    
CREATE TABLE CHITIETBANGDIEM(
	MA_MH int NOT NULL,
    MA_LOP int NOT NULL,
    MA_HS int NOT NULL,
    MIENG DOUBLE, 
    MLPHUT DOUBLE,
    MTIET DOUBLE,
    CUOIKY DOUBLE,
    TONGKET DOUBLE,
    HOC_KY INT,
    FOREIGN KEY (MA_MH) REFERENCES MONHOC(MA_MH),
    FOREIGN KEY (MA_LOP) REFERENCES LOP(MA_LOP),
    FOREIGN KEY (MA_HS) REFERENCES HOCSINH(MA_HS));
       
create table PHUHUYNH(
	MA_PH int auto_increment,
    TEN_HO NVARCHAR(50) not null,
    NGAYSINH TIMESTAMP not null,
    QUEQUAN NVARCHAR(50), 
    USERNAME VARCHAR(200),
    GIOITINH VARCHAR(45),
    CONSTRAINT FK_PH FOREIGN KEY (USERNAME) REFERENCES TAIKHOAN(USERNAME),
    primary key (ma_ph)
);
    
CREATE TABLE PHUHUYNHHS(
	MA_PH int not null,
    MA_HS INT not null,
    PRIMARY KEY (MA_PH, MA_HS),
	CONSTRAINT FK_PPPP FOREIGN KEY (MA_PH) REFERENCES PHUHUYNH(MA_PH),
    CONSTRAINT FK_PHPP FOREIGN KEY (MA_HS) REFERENCES HOCSINH(MA_HS)
); 

CREATE TABLE `thongbao` (
  `ID_TB` int(11) NOT NULL AUTO_INCREMENT,
  `NGUOIGUI` varchar(200) NOT NULL,
  `NGUOINHAN` varchar(200) NOT NULL,
  `TIEU_DE` varchar(200) NOT NULL,
  `NOI_DUNG` text NOT NULL,
  `THOI_GIAN` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID_TB`),
  CONSTRAINT `thongbao_ibfk_1` FOREIGN KEY (`NGUOIGUI`) REFERENCES `taikhoan` (`USERNAME`),
  CONSTRAINT `thongbao_ibfk_2` FOREIGN KEY (`NGUOINHAN`) REFERENCES `taikhoan` (`USERNAME`)
);
    
CREATE TABLE TOPIC(
	ID_TOPIC INT AUTO_INCREMENT,
    USERNAME VARCHAR(200) not null,
    MA_LOP INT,
	THOI_GIAN TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    CHU_DE NVARCHAR(100),
    NOI_DUNG TEXT not null,
    SO_CMT INT,
    CONSTRAINT FK_TOPICTK FOREIGN KEY (USERNAME) REFERENCES TAIKHOAN(USERNAME),
	CONSTRAINT `FK_TOPICLOP` FOREIGN KEY (`MA_LOP`) REFERENCES `LOP`(`MA_LOP`),
    PRIMARY KEY (ID_TOPIC, USERNAME));
        
CREATE TABLE CMT(
	ID_CMT INT AUTO_INCREMENT,
	ID_TOPIC INT,
    USERNAME VARCHAR(200) NOT NULL,
    NOI_DUNG TEXT,
    THOI_GIAN TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (ID_CMT, ID_TOPIC),
    CONSTRAINT FK_CMTTK FOREIGN KEY (USERNAME) REFERENCES TAIKHOAN(USERNAME),
    FOREIGN KEY (ID_TOPIC) REFERENCES TOPIC(ID_TOPIC));

CREATE TABLE THOIKHOABIEU(
	MA_GV INT NOT NULL,
	MA_LOP INT NOT NULL,
	MA_MH INT NOT NULL,
	HOC_KY INT NOT NULL,
	THU INT,
	TIET INT,
	CONSTRAINT P_KEY_TKB PRIMARY KEY (MA_GV, MA_LOP, HOC_KY, THU, TIET),
	CONSTRAINT F_KEY_TKB_LOP FOREIGN KEY (MA_LOP) REFERENCES LOP(MA_LOP),
	CONSTRAINT F_TKBGV FOREIGN KEY (MA_GV) REFERENCES GIAOVIEN(MA_GV),
	CONSTRAINT F_KEY_TKB_MH FOREIGN KEY (MA_MH) REFERENCES MONHOC(MA_MH)
);
    
CREATE TABLE `lichthi` (
  `HOC_KY` int(11) NOT NULL,
  `MA_MH` int(11),
  `MA_LOP` INT(11),
  `NGAY_THI` TIMESTAMP,
  `TIET_BAT_DAU` int(11),
  `THOI_GIAN_THI` int(11),
 
  CONSTRAINT `FK_MAMH` FOREIGN KEY (`MA_MH`) REFERENCES `monhoc` (`MA_MH`),
  CONSTRAINT FK_LLT foreign key(MA_LOP) REFERENCES LOP(MA_LOP)
);

DELIMITER $$
CREATE TRIGGER T_CMTP 
AFTER INSERT ON CMT 
FOR EACH ROW 
	BEGIN
		UPDATE TOPIC SET TOPIC.SO_CMT = TOPIC.SO_CMT + 1 WHERE NEW.ID_TOPIC=topic.ID_TOPIC;
    END$$
DELIMITER ;

CREATE VIEW V_INFOSTD
AS
SELECT HSL.MA_HS, HS.TEN_HS,HS.NGAY_SINH, HS.GIOI_TINH, HSL.MA_LOP, HS.MA_TRUONG, HS.QUE_QUAN, HS.SO_DT, HS.USERNAME
FROM HOCSINHLOP AS HSL INNER JOIN HOCSINH AS HS ON HS.MA_HS = HSL.MA_HS;

CREATE VIEW V_PHTHEOLOP
AS 
	SELECT PH.MA_PH, PH.TEN_HO, PH.GIOITINH, PH.NGAYSINH, PH.QUEQUAN, PH.USERNAME, HSL.MA_LOP
    FROM PHUHUYNH AS PH INNER JOIN PHUHUYNHHS AS PHHS ON PH.MA_PH = PHHS.MA_PH
						INNER JOIN HOCSINH AS HS ON HS.MA_HS = PHHS.MA_HS
                        INNER JOIN HOCSINHLOP AS HSL ON HS.MA_HS = HSL.MA_HS;
                        
CREATE VIEW V_BANGDIEM
AS
		SELECT HS.TEN_HS, HS.MA_HS, L.TEN_LOP, MH.TEN_MH, CT.MIENG, CT.MLPHUT, CT.MTIET, CT.CUOIKY, CT.TONGKET,CT.HOC_KY
        FROM HOCSINH AS HS INNER JOIN CHITIETBANGDIEM AS CT ON HS.MA_HS = CT.MA_HS
						   INNER JOIN MONHOC AS MH ON CT.MA_MH = MH.MA_MH
                           INNER JOIN LOP AS L ON CT.MA_LOP = L.MA_LOP;
                           
CREATE VIEW V_TKB
AS 
	SELECT TKB.MA_GV, TKB.MA_LOP, LOP.TEN_LOP, TKB.MA_MH, MH.TEN_MH, TKB.HOC_KY, TKB.THU, TKB.TIET
    FROM THOIKHOABIEU AS TKB INNER JOIN LOP ON TKB.MA_LOP = LOP.MA_LOP
							 INNER JOIN MONHOC AS MH ON MH.MA_MH=TKB.MA_MH;

CREATE VIEW V_LICHTHI
AS 
	SELECT LT.HOC_KY, LT.MA_MH, MH.TEN_MH, LT.MA_LOP, LOP.TEN_LOP, LT.NGAY_THI, LT.TIET_BAT_DAU, LT.THOI_GIAN_THI
    FROM LICHTHI AS LT INNER JOIN LOP ON LT.MA_LOP = LOP.MA_LOP
					   INNER JOIN MONHOC AS MH ON LT.MA_MH = MH.MA_MH;

DELIMITER $$
CREATE PROCEDURE THEM_TAIKHOAN(IN USERNAME VARCHAR(200), IN PASSWD VARCHAR(200), IN CHUCVU VARCHAR(20), IN MACHUCVU INT(11))
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
END; $$
DELIMITER ;



INSERT INTO `myschool1`.`chucvu` (`CHUCVU`) VALUES ('GIAOVIEN');
INSERT INTO `myschool1`.`chucvu` (`CHUCVU`) VALUES ('PHUHUYNH');
INSERT INTO `myschool1`.`chucvu` (`CHUCVU`) VALUES ('HOCSINH');

INSERT INTO `myschool1`.`maxacnhan` (`MAXACNHAN`, `MACHUCVU`, `CHUCVU`) VALUES ('111', '1', 'GIAOVIEN');
INSERT INTO `myschool1`.`maxacnhan` (`MAXACNHAN`, `MACHUCVU`, `CHUCVU`) VALUES ('112', '2', 'PHUHUYNH');
INSERT INTO `myschool1`.`maxacnhan` (`MAXACNHAN`, `MACHUCVU`, `CHUCVU`) VALUES ('113', '3', 'HOCSINH');

INSERT INTO `myschool1`.`thoikhoabieu` (`MA_GV`, `MA_LOP`, `MA_MH`, `HOC_KY`, `THU`, `TIET`) VALUES ('1', '1', '1', '1', '2', '1');
INSERT INTO `myschool1`.`thoikhoabieu` (`MA_GV`, `MA_LOP`, `MA_MH`, `HOC_KY`, `THU`, `TIET`) VALUES ('1', '1', '1', '1', '2', '2');
INSERT INTO `myschool1`.`thoikhoabieu` (`MA_GV`, `MA_LOP`, `MA_MH`, `HOC_KY`, `THU`, `TIET`) VALUES ('2', '1', '2', '1', '2', '3');
INSERT INTO `myschool1`.`thoikhoabieu` (`MA_GV`, `MA_LOP`, `MA_MH`, `HOC_KY`, `THU`, `TIET`) VALUES ('2', '1', '2', '1', '2', '4');
INSERT INTO `myschool1`.`thoikhoabieu` (`MA_GV`, `MA_LOP`, `MA_MH`, `HOC_KY`, `THU`, `TIET`) VALUES ('3', '1', '3', '1', '2', '5');

INSERT INTO `myschool1`.`chitietbangdiem` (`MA_MH`, `MA_LOP`, `MA_HS`, `MIENG`, `MLPHUT`, `MTIET`, `CUOIKY`, `TONGKET`, `HOC_KY`) VALUES ('1', '1', '5', '8', '8', '8', '8', '8', '1');
INSERT INTO `myschool1`.`chitietbangdiem` (`MA_MH`, `MA_LOP`, `MA_HS`, `MIENG`, `MLPHUT`, `MTIET`, `CUOIKY`, `TONGKET`, `HOC_KY`) VALUES ('2', '1', '5', '7', '7', '7', '7', '7', '1');
INSERT INTO `myschool1`.`chitietbangdiem` (`MA_MH`, `MA_LOP`, `MA_HS`, `MIENG`, `MLPHUT`, `MTIET`, `CUOIKY`, `TONGKET`, `HOC_KY`) VALUES ('3', '1', '5', '9', '9', '9', '9', '9', '1');
INSERT INTO `myschool1`.`chitietbangdiem` (`MA_MH`, `MA_LOP`, `MA_HS`, `MIENG`, `MLPHUT`, `MTIET`, `CUOIKY`, `TONGKET`, `HOC_KY`) VALUES ('1', '1', '6', '7', '7', '7', '7', '7', '1');
INSERT INTO `myschool1`.`chitietbangdiem` (`MA_MH`, `MA_LOP`, `MA_HS`, `MIENG`, `MLPHUT`, `MTIET`, `CUOIKY`, `TONGKET`, `HOC_KY`) VALUES ('2', '1', '6', '8', '8', '8', '8', '8', '1');
INSERT INTO `myschool1`.`chitietbangdiem` (`MA_MH`, `MA_LOP`, `MA_HS`, `MIENG`, `MLPHUT`, `MTIET`, `CUOIKY`, `TONGKET`, `HOC_KY`) VALUES ('3', '1', '6', '6', '6', '6', '6', '6', '1');

INSERT INTO `myschool1`.`lichthi` (`HOC_KY`, `MA_MH`, `MA_LOP`, `NGAY_THI`, `TIET_BAT_DAU`, `THOI_GIAN_THI`) VALUES ('1', '1', '1', '2017-9-9', '1', '90');
INSERT INTO `myschool1`.`lichthi` (`HOC_KY`, `MA_MH`, `MA_LOP`, `NGAY_THI`, `TIET_BAT_DAU`, `THOI_GIAN_THI`) VALUES ('1', '2', '1', '2017-6-2', '3', '120');
INSERT INTO `myschool1`.`lichthi` (`HOC_KY`, `MA_MH`, `MA_LOP`, `NGAY_THI`, `TIET_BAT_DAU`, `THOI_GIAN_THI`) VALUES ('1', '3', '1', '2017-6-3', '5', '120');
INSERT INTO `myschool1`.`lichthi` (`HOC_KY`, `MA_MH`, `MA_LOP`, `NGAY_THI`, `TIET_BAT_DAU`, `THOI_GIAN_THI`) VALUES ('1', '4', '1', '2017-6-1', '2', '60');
INSERT INTO `myschool1`.`lichthi` (`HOC_KY`, `MA_MH`, `MA_LOP`, `NGAY_THI`, `TIET_BAT_DAU`, `THOI_GIAN_THI`) VALUES ('1', '1', '2', '2017-4-4', '1', '90');
INSERT INTO `myschool1`.`lichthi` (`HOC_KY`, `MA_MH`, `MA_LOP`, `NGAY_THI`, `TIET_BAT_DAU`, `THOI_GIAN_THI`) VALUES ('1', '2', '2', '2017-5-5', '1', '120');
INSERT INTO `myschool1`.`lichthi` (`HOC_KY`, `MA_MH`, `MA_LOP`, `NGAY_THI`, `TIET_BAT_DAU`, `THOI_GIAN_THI`) VALUES ('1', '3', '2', '2017-5-6', '3', '120');

INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS001', 'BLA BLE BLO', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS002', 'BLA BLE BLO 1', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS001', 'BLA BLE BLO 2', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS002', 'BLA BLE BLO 3', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS001', 'BLA BLE BLO 4', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS002', 'BLA BLE BLO D', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS001', 'BLA BLE BLO', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS002', 'BLA BLE BLO', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS001', 'BLA BLE BLO', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS002', 'BLA BLE BLO', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS001', 'BLA BLE BLO', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS002', 'BLA BLE BLO', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS001', 'BLA BLE BLO', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS002', 'BLA BLE BLO', NOW());
INSERT INTO `cmt` (`ID_TOPIC`, `USERNAME`, `NOI_DUNG`, `THOI_GIAN`) VALUES ('1', 'HS001', 'BLA BLE BLO', NOW());

INSERT INTO `chitietbangdiem` VALUES (1,1,5,8,8,8,8,8,1),(2,1,5,7,7,7,7,7,1),(3,1,5,9,9,9,9,9,1),(1,1,6,7,7,7,7,7,1),(2,1,6,8,8,8,8,8,1),(3,1,6,6,6,6,6,6,1);

INSERT INTO `giaovien` VALUES (1,'CO GIAO THAO','NU ','TP HCM',1,NULL),(2,'THAY GIAO THAO','NAM','TP HCM',1,'GV002'),(3,'GIAO VIEN 2','NAM ','HA NOI',1,NULL),(4,'GIAO VIEN 3','NU','TP HCM ',1,NULL),(5,'GIAO VIEN 4','NAM ','QUANG NGAI',1,NULL);

INSERT INTO `hocsinh` VALUES (5,'LE ANH TRI','HS004','2017-06-21 14:57:36','NAM',1,'QUANG NGAI',1222977046),(6,'PHAM LE CONG PHUONG','HS002','2017-06-21 13:57:41','NAM',1,'QUANG NAM',123213123),(7,'LUONG PHU AN','HS003','2017-06-21 13:57:42','NAM',1,'TAY NINH',11313413),(8,'NGO VAN KHUONG','HS001','2017-06-21 13:57:41','NAM',1,'QUANG NAM',123123312);

INSERT INTO `hocsinhlop` VALUES (5,1,2015),(6,1,2015),(7,1,2016),(8,2,2016);

INSERT INTO `lop` VALUES (1,2015,1,1,40,'12A1'),(1,2015,2,2,41,'12A2');

INSERT INTO `maxacnhan` VALUES (111,1,'GIAOVIEN'),(120,2,'GIAOVIEN'),(113,5,'HOCSINH'),(115,6,'HOCSINH'),(116,7,'HOCSINH'),(117,8,'HOCSINH'),(114,3,'PHUHUYNH'),(118,1,'PHUHUYNH'),(119,2,'PHUHUYNH');

INSERT INTO `monhoc` VALUES (1,'TOAN'),(2,'NGU VAN'),(3,'ANH VAN'),(4,'VAT LY'),(5,'HOA HOC'),(6,'SINH HOC'),(7,'LICH SU');

INSERT INTO `phuhuynh` VALUES (1,'PHU HUYNH 1','2017-06-21 15:05:26','QUANG NGAI','PH001','NAM'),(2,'PHU HUYNH 2','2017-06-21 15:05:26','QUANG NAM','PH002','NU'),(3,'PHU HUYNH 3','2017-06-21 15:05:26','TAY NINH','PH003','NAM');

INSERT INTO `phuhuynhhs` VALUES (1,5),(1,6),(2,7),(3,8);

INSERT INTO `taikhoan` VALUES (1,'HS004','$2a$10$6EQ1CrT6kH./UtjkSKpX9e3eOCxdu8rhQ3Wwx1hLjQNYxL/8dFlMO','HOCSINH',5,NULL),(2,'ADMIN','$2a$10$AR5eTjmfk8ydCnd/RgLRjODXNDKKLVc64gAWLpeg7Y1G8e4SKMyK.','GIAOVIEN',1,NULL),(3,'PH001','$2a$10$fFhhGLyff0litXOjYAgh4eKVVMy/rM51jdcAhzBLOJPk17Q3PbD7y','PHUHUYNH',2,NULL),(4,'PH002','$2a$10$T/tvc2AY0rv7qXp1wxSJ8.FJAn0HN9t.U0NqQEGzqZ6NKsfitaJ7.','PHUHUYNH',2,NULL),(5,'PH003','$2a$10$8eq009yEbizqkhvf7dUKiOm/yY8UnlNJbq7HWfQhuhhFQhQN0aYxS','PHUHUYNH',2,NULL),(6,'GV002','GV002','GIAOVIEN',2,NULL),(8,'HS001','$2a$10$D7HMvWpu35tXNU6e7YrODOzVq6DqmPvCQZD7NDT6oJ9Bi0FBYtjGu','HOCSINH',8,NULL),(9,'HS002','$2a$10$LhFYAJ7XijgHGVPfqdLqT.Zx11VLsaqP0sg1tCTyfOey4WYrwDZau','HOCSINH',6,NULL),(10,'HS003','$2a$10$RcDDv0one8rJPG.gZ/itGeeHhFNtFtzn2IWj9661zwRgSjDDYLWpm','HOCSINH',7,NULL);

INSERT INTO `thoikhoabieu` VALUES (1,1,1,1,2,1),(1,1,1,1,2,2),(2,1,2,1,2,3),(2,1,2,1,2,4),(3,1,3,1,2,5);

INSERT INTO `truong` VALUES (1,'THPT TRAN QUOC TUAN','TP QUANG NGAI, QUANG NGAI');

















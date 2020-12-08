DROP TABLE ANSWER;
DROP TABLE QUESTION;
DROP TABLE TEACH;
DROP TABLE CHOOSE;
DROP TABLE SETE;
DROP TABLE TAKE;
DROP TABLE STUDENT;
DROP TABLE CLASS;
DROP TABLE TEACHER;
DROP TABLE SUBJECT;
DROP TABLE EXAM;



-- create table - STUDENT
CREATE TABLE STUDENT(STU_ID VARCHAR(8) NOT NULL , STU_NAME VARCHAR(20),C_ID VARCHAR(3),STU_PWD VARCHAR(10),PRIMARY KEY (STU_ID));

-- create table - TEACHER
CREATE TABLE TEACHER(TEA_ID VARCHAR(8) NOT NULL ,TEA_NAME VARCHAR(20),TEA_PWD VARCHAR(10),PRIMARY KEY (TEA_ID));

-- create table - SUBJECT
CREATE TABLE SUBJECT(SUB_ID VARCHAR(12) NOT NULL , SUB_NAME VARCHAR(30),PRIMARY KEY (SUB_ID));

-- create table - CLASS
CREATE TABLE CLASS(C_ID VARCHAR(3) NOT NULL ,INSTRUCTOR_ID VARCHAR(12),
     PRIMARY KEY (C_ID),
     FOREIGN KEY (INSTRUCTOR_ID) REFERENCES TEACHER(TEA_ID));

-- create table - EXAM
CREATE TABLE EXAM(TEST# VARCHAR(11) NOT NULL,START_TIME DATE,DURATION NUMBER(5),PRIMARY KEY (TEST#));

-- create table - QUESTION
CREATE TABLE QUESTION(TEST# VARCHAR(11) NOT NULL, Q# NUMBER(3) NOT NULL,COMPULSORY VARCHAR(2),TYPE VARCHAR(8),SCORE NUMBER(4,2),Q_CONTENT VARCHAR(1000),ANSWER VARCHAR(1000),
     PRIMARY KEY (TEST#,Q#),
     FOREIGN KEY (TEST#) REFERENCES EXAM(TEST#));

-- create table - TEACH
CREATE TABLE TEACH(YEAR NUMBER(4) NOT NULL, SEM NUMBER(1) NOT NULL, TEA_ID VARCHAR(8) NOT NULL,SUB_ID VARCHAR(12),C_ID VARCHAR(3) NOT NULL,
     PRIMARY KEY (YEAR,SEM,C_ID,TEA_ID), 
     FOREIGN KEY (TEA_ID) REFERENCES TEACHER(TEA_ID),
     FOREIGN KEY (C_ID) REFERENCES CLASS(C_ID),
     FOREIGN KEY (SUB_ID) REFERENCES SUBJECT(SUB_ID));

-- create table - CHOOSE
CREATE TABLE CHOOSE(YEAR NUMBER(4) NOT NULL, SEM NUMBER(1) NOT NULL,C_ID VARCHAR(3) NOT NULL,SUB_ID VARCHAR(12) NOT NULL,
     PRIMARY KEY (YEAR,SEM,SUB_ID,C_ID),
     FOREIGN KEY (SUB_ID) REFERENCES SUBJECT(SUB_ID),
     FOREIGN KEY (C_ID) REFERENCES CLASS(C_ID));

-- create table - SETE
CREATE TABLE SETE(TEST# VARCHAR(11) NOT NULL,YEAR NUMBER(4), SEM NUMBER(1),TEA_ID VARCHAR(8),C_ID VARCHAR(3),
     PRIMARY KEY (TEST#), 
     FOREIGN KEY (TEA_ID) REFERENCES TEACHER(TEA_ID),
     FOREIGN KEY (C_ID) REFERENCES CLASS(C_ID),
     FOREIGN KEY (TEST#) REFERENCES EXAM(TEST#));

-- create table - ANSWER
CREATE TABLE ANSWER(TEST# VARCHAR(11) NOT NULL,Q# NUMBER(3) NOT NULL,STU_ID VARCHAR(8) NOT NULL,STU_ANS VARCHAR(1000),STU_SCORE NUMBER(4,2),
     PRIMARY KEY (TEST#,Q#,STU_ID), 
     FOREIGN KEY (TEST#,Q#) REFERENCES QUESTION(TEST#,Q#),
     FOREIGN KEY (STU_ID) REFERENCES STUDENT(STU_ID),
     FOREIGN KEY (TEST#) REFERENCES EXAM(TEST#));

-- create table - TAKE
CREATE TABLE TAKE(TEST# VARCHAR(11) NOT NULL,STU_ID VARCHAR(8) NOT NULL,TEST_RESULT NUMBER(5,2), COMMENTS VARCHAR(500),
     PRIMARY KEY (TEST#,STU_ID), 
     FOREIGN KEY (TEST#) REFERENCES EXAM(TEST#),
     FOREIGN KEY (STU_ID) REFERENCES STUDENT(STU_ID));


--create index TEACH SUB_ID
CREATE INDEX TEACH_SUB_ID_I ON TEACH(SUB_ID);

--create index CHOOSE SUB_ID
CREATE INDEX CHOOSE_SUB_ID_I ON CHOOSE(SUB_ID);

--create index ANS STU_SCORE
CREATE INDEX ANSWER_STU_SCORE_I ON ANSWER(STU_SCORE);

--create index TAKE TEST_RESULT
CREATE INDEX TAKE_TEST_RESULT_I ON TAKE(TEST_RESULT);

--create index SETE YEAR
CREATE INDEX SETE_YEAR_I ON SETE(YEAR);

--create index SETE SEM
CREATE INDEX SETE_SEM_I ON SETE(SEM);

--create index SETE C_ID
CREATE INDEX SETE_C_ID_I ON SETE(C_ID);

--create index SETE TEA_ID
CREATE INDEX SETE_TEA_ID_I ON SETE(TEA_ID);



-- insert records into STUDENT
INSERT INTO STUDENT VALUES ('S180101','Mickey','C01','123456');
INSERT INTO STUDENT VALUES ('S180102','Goofy','C01','123456');
INSERT INTO STUDENT VALUES ('S180103','Danny Johnson','C01','123456');
INSERT INTO STUDENT VALUES ('S180104','Mulan','C01','123456');
INSERT INTO STUDENT VALUES ('S180105','Alex Williams','C01','123456');
INSERT INTO STUDENT VALUES ('S180106','Elsa','C01','123456');
INSERT INTO STUDENT VALUES ('S180107','Jimmy','C01','123456');
INSERT INTO STUDENT VALUES ('S180108','Austin Jones','C01','123456');
INSERT INTO STUDENT VALUES ('S180109','Martin Cooper','C01','123456');
INSERT INTO STUDENT VALUES ('S180110','Thomas','C01','123456');
INSERT INTO STUDENT VALUES ('S180111','Kylie','C01','123456');
INSERT INTO STUDENT VALUES ('S180112','Chris','C01','123456');
INSERT INTO STUDENT VALUES ('S180113','Gabe Vincent','C01','123456');
INSERT INTO STUDENT VALUES ('S180114','Evan','C01','123456');
INSERT INTO STUDENT VALUES ('S180115','Kendall','C01','123456');
INSERT INTO STUDENT VALUES ('S180116','Jeff Teague','C01','123456');
INSERT INTO STUDENT VALUES ('S180117','Kevin','C01','123456');
INSERT INTO STUDENT VALUES ('S180118','Max Black','C01','123456');
INSERT INTO STUDENT VALUES ('S180119','Caroline','C01','123456');
INSERT INTO STUDENT VALUES ('S180120','Kat Dennings','C01','123456');
INSERT INTO STUDENT VALUES ('S180121','Beth Behrs','C01','123456');
INSERT INTO STUDENT VALUES ('S180122','Earl','C01','123456');
INSERT INTO STUDENT VALUES ('S180123','Oleg','C01','123456');
INSERT INTO STUDENT VALUES ('S180124','Garrett Morris','C01','123456');
INSERT INTO STUDENT VALUES ('S180125','Jonathan','C01','123456');
INSERT INTO STUDENT VALUES ('S180126','Jennifer','C01','123456');
INSERT INTO STUDENT VALUES ('S180127','Nick Zano','C01','123456');
INSERT INTO STUDENT VALUES ('S180128','Renee Taylor','C01','123456');
INSERT INTO STUDENT VALUES ('S180129','Nora','C01','123456');
INSERT INTO STUDENT VALUES ('S180130','Jackee','C01','123456');

INSERT INTO STUDENT VALUES ('S190201','Victor','C02','123456');
INSERT INTO STUDENT VALUES ('S190202','Jeremy Lamb','C02','123456');
INSERT INTO STUDENT VALUES ('S190203','Emily','C02','123456');
INSERT INTO STUDENT VALUES ('S190204','Brian','C02','123456');
INSERT INTO STUDENT VALUES ('S190205','Joe Harris','C02','123456');
INSERT INTO STUDENT VALUES ('S190206','Alize','C02','123456');
INSERT INTO STUDENT VALUES ('S190207','Olivia','C02','123456');
INSERT INTO STUDENT VALUES ('S190208','Hill','C02','123456');
INSERT INTO STUDENT VALUES ('S190209','Bella','C02','123456');
INSERT INTO STUDENT VALUES ('S190210','Susan Simon','C02','123456');
INSERT INTO STUDENT VALUES ('S190211','Peter Parker','C02','123456');
INSERT INTO STUDENT VALUES ('S190212','Sam','C02','123456');
INSERT INTO STUDENT VALUES ('S190213','Elizabeth','C02','123456');
INSERT INTO STUDENT VALUES ('S190214','Mary Green','C02','123456');
INSERT INTO STUDENT VALUES ('S190215','Amy','C02','123456');
INSERT INTO STUDENT VALUES ('S190216','Penny','C02','123456');
INSERT INTO STUDENT VALUES ('S190217','Kaley','C02','123456');
INSERT INTO STUDENT VALUES ('S190218','James Joseph','C02','123456');
INSERT INTO STUDENT VALUES ('S190219','Melissa Rauch','C02','123456');
INSERT INTO STUDENT VALUES ('S190220','Mayim','C02','123456');
INSERT INTO STUDENT VALUES ('S190221','Kunal','C02','123456');
INSERT INTO STUDENT VALUES ('S190222','Kim Kardashian','C02','123456');
INSERT INTO STUDENT VALUES ('S190223','Carol Ann','C02','123456');
INSERT INTO STUDENT VALUES ('S190224','Christine','C02','123456');
INSERT INTO STUDENT VALUES ('S190225','Laurie','C02','123456');
INSERT INTO STUDENT VALUES ('S190226','Sarah','C02','123456');
INSERT INTO STUDENT VALUES ('S190227','Brian Posehn','C02','123456');
INSERT INTO STUDENT VALUES ('S190228','Richard','C02','123456');
INSERT INTO STUDENT VALUES ('S190229','Kate','C02','123456');
INSERT INTO STUDENT VALUES ('S190230','Mark Harelik','C02','123456');

INSERT INTO STUDENT VALUES ('S190301','Boris Spacey','C03','123456');
INSERT INTO STUDENT VALUES ('S190302','Alice Amter','C03','123456');
INSERT INTO STUDENT VALUES ('S190303','Robin Wright','C03','123456');
INSERT INTO STUDENT VALUES ('S190304','Derek','C03','123456');
INSERT INTO STUDENT VALUES ('S190305','Rachel','C03','123456');
INSERT INTO STUDENT VALUES ('S190306','Regina','C03','123456');
INSERT INTO STUDENT VALUES ('S190307','Nathan Darrow','C03','123456');
INSERT INTO STUDENT VALUES ('S190308','Greg','C03','123456');
INSERT INTO STUDENT VALUES ('S190309','Riki','C03','123456');
INSERT INTO STUDENT VALUES ('S190310','Campbell','C03','123456');
INSERT INTO STUDENT VALUES ('S190311','Anne Hathaway','C03','123456');
INSERT INTO STUDENT VALUES ('S190312','Neve','C03','123456');
INSERT INTO STUDENT VALUES ('S190313','Sean','C03','123456');
INSERT INTO STUDENT VALUES ('S190314','Reed Birney','C03','123456');
INSERT INTO STUDENT VALUES ('S190315','Patrick','C03','123456');
INSERT INTO STUDENT VALUES ('S190316','Diane Lane','C03','123456');
INSERT INTO STUDENT VALUES ('S190317','Evan Stan','C03','123456');
INSERT INTO STUDENT VALUES ('S190318','Dominic','C03','123456');
INSERT INTO STUDENT VALUES ('S190319','Natalie','C03','123456');
INSERT INTO STUDENT VALUES ('S190320','Julie Andrews','C03','123456');
INSERT INTO STUDENT VALUES ('S190321','Amanda Coleman','C03','123456');
INSERT INTO STUDENT VALUES ('S190322','Lex','C03','123456');
INSERT INTO STUDENT VALUES ('S190323','Nicholas','C03','123456');
INSERT INTO STUDENT VALUES ('S190324','Molly','C03','123456');
INSERT INTO STUDENT VALUES ('S190325','Kirsty Mather','C03','123456');
INSERT INTO STUDENT VALUES ('S190326','Ben Uttley','C03','123456');
INSERT INTO STUDENT VALUES ('S190327','Hayley Atwell','C03','123456');
INSERT INTO STUDENT VALUES ('S190328','Doug Cockle','C03','123456');
INSERT INTO STUDENT VALUES ('S190329','Erich','C03','123456');
INSERT INTO STUDENT VALUES ('S190330','Rosanna','C03','123456');

-- insert records into TEACHER
INSERT INTO TEACHER VALUES ('T890023','Bobby Berk','123456');
INSERT INTO TEACHER VALUES ('T920045','Jinsoo Lee','123456');
INSERT INTO TEACHER VALUES ('T960678','Almen Yau','123456');
INSERT INTO TEACHER VALUES ('T836099','Dean','123456');
INSERT INTO TEACHER VALUES ('T825189','Antoni','123456');
INSERT INTO TEACHER VALUES ('T930577','Pearl Lin','123456');
INSERT INTO TEACHER VALUES ('T918821','Karamo Brown','123456');
INSERT INTO TEACHER VALUES ('T867474','Valerie','123456');
INSERT INTO TEACHER VALUES ('T865677','Tedd Li','123456');

-- insert records into SUBJECT
INSERT INTO SUBJECT VALUES ('COMP2411','Database Systems');
INSERT INTO SUBJECT VALUES ('COMP2011','Data Structure');
INSERT INTO SUBJECT VALUES ('AF2111','Accounting');
INSERT INTO SUBJECT VALUES ('CBS2012','Language');
INSERT INTO SUBJECT VALUES ('ELC2012','English Debating');
INSERT INTO SUBJECT VALUES ('COMP2021','Java');
INSERT INTO SUBJECT VALUES ('ABCT1234','Science');
INSERT INTO SUBJECT VALUES ('APSS1011','Psychology');
INSERT INTO SUBJECT VALUES ('HTM1203','Tourism');

-- insert records into CLASS
INSERT INTO CLASS VALUES ('C01','T930577');
INSERT INTO CLASS VALUES ('C02','T825189');
INSERT INTO CLASS VALUES ('C03','T960678');

-- insert records into TEACH
INSERT INTO TEACH VALUES (2020,1,'T890023','COMP2411','C01');
INSERT INTO TEACH VALUES (2020,1,'T890023','COMP2411','C02');
INSERT INTO TEACH VALUES (2020,1,'T890023','COMP2411','C03');
INSERT INTO TEACH VALUES (2020,1,'T836099','COMP2011','C01');
INSERT INTO TEACH VALUES (2020,1,'T836099','COMP2011','C02');
INSERT INTO TEACH VALUES (2020,1,'T836099','COMP2011','C03');
INSERT INTO TEACH VALUES (2020,1,'T918821','COMP2021','C01');
INSERT INTO TEACH VALUES (2020,1,'T918821','COMP2021','C02');
INSERT INTO TEACH VALUES (2020,1,'T918821','COMP2021','C03');
INSERT INTO TEACH VALUES (2020,1,'T865677','ABCT1234','C01');
INSERT INTO TEACH VALUES (2020,1,'T930577','HTM1203','C01');
INSERT INTO TEACH VALUES (2020,1,'T825189','ELC2012','C02');
INSERT INTO TEACH VALUES (2020,1,'T920045','AF2111','C02');
INSERT INTO TEACH VALUES (2020,1,'T867474','CBS2012','C03');
INSERT INTO TEACH VALUES (2020,1,'T960678','APSS1011','C03');

INSERT INTO TEACH VALUES (2019,2,'T867474','CBS2012','C01');
INSERT INTO TEACH VALUES (2019,2,'T960678','APSS1011','C01');
INSERT INTO TEACH VALUES (2019,2,'T865677','ABCT1234','C02');
INSERT INTO TEACH VALUES (2019,2,'T930577','HTM1203','C02');
INSERT INTO TEACH VALUES (2019,2,'T825189','ELC2012','C03');
INSERT INTO TEACH VALUES (2019,2,'T920045','AF2111','C03');

INSERT INTO TEACH VALUES (2019,1,'T825189','ELC2012','C01');
INSERT INTO TEACH VALUES (2019,1,'T920045','AF2111','C01');
INSERT INTO TEACH VALUES (2019,1,'T867474','CBS2012','C02');
INSERT INTO TEACH VALUES (2019,1,'T960678','APSS1011','C02');
INSERT INTO TEACH VALUES (2019,1,'T865677','ABCT1234','C03');
INSERT INTO TEACH VALUES (2019,1,'T930577','HTM1203','C03');

-- insert records into CHOOSE
INSERT INTO CHOOSE VALUES (2020,1,'C01','COMP2411');
INSERT INTO CHOOSE VALUES (2020,1,'C01','COMP2011');
INSERT INTO CHOOSE VALUES (2020,1,'C01','COMP2021');
INSERT INTO CHOOSE VALUES (2020,1,'C01','ABCT1234');
INSERT INTO CHOOSE VALUES (2020,1,'C01','HTM1203');
INSERT INTO CHOOSE VALUES (2020,1,'C02','COMP2411');
INSERT INTO CHOOSE VALUES (2020,1,'C02','COMP2011');
INSERT INTO CHOOSE VALUES (2020,1,'C02','COMP2021');
INSERT INTO CHOOSE VALUES (2020,1,'C02','ELC2012');
INSERT INTO CHOOSE VALUES (2020,1,'C02','AF2111');
INSERT INTO CHOOSE VALUES (2020,1,'C03','COMP2411');
INSERT INTO CHOOSE VALUES (2020,1,'C03','COMP2011');
INSERT INTO CHOOSE VALUES (2020,1,'C03','COMP2021');
INSERT INTO CHOOSE VALUES (2020,1,'C03','CBS2012');
INSERT INTO CHOOSE VALUES (2020,1,'C03','APSS1011');

INSERT INTO CHOOSE VALUES (2019,2,'C01','CBS2012');
INSERT INTO CHOOSE VALUES (2019,2,'C01','APSS1011');
INSERT INTO CHOOSE VALUES (2019,2,'C02','ABCT1234');
INSERT INTO CHOOSE VALUES (2019,2,'C02','HTM1203');
INSERT INTO CHOOSE VALUES (2019,2,'C03','ELC2012');
INSERT INTO CHOOSE VALUES (2019,2,'C03','AF2111');

INSERT INTO CHOOSE VALUES (2019,1,'C01','ELC2012');
INSERT INTO CHOOSE VALUES (2019,1,'C01','AF2111');
INSERT INTO CHOOSE VALUES (2019,1,'C02','CBS2012');
INSERT INTO CHOOSE VALUES (2019,1,'C02','APSS1011');
INSERT INTO CHOOSE VALUES (2019,1,'C03','ABCT1234');
INSERT INTO CHOOSE VALUES (2019,1,'C03','HTM1203');



--insert preset data for EXAM
INSERT INTO EXAM VALUES ('201C241101',to_date('2020/12/07:11:00:00AM','yyyy/mm/dd:hh:mi:ssam'),60);
INSERT INTO EXAM VALUES ('201A123401',to_date('2020/12/07:3:00:00PM','yyyy/mm/dd:hh:mi:sspm'),80);
INSERT INTO EXAM VALUES ('201E201202',to_date('2020/12/10:08:00:00AM','yyyy/mm/dd:hh:mi:ssam'),30);
INSERT INTO EXAM VALUES ('201C241102',to_date('2020/12/07:10:00:00AM','yyyy/mm/dd:hh:mi:ssam'),60);


--insert preset data for SETE
INSERT INTO SETE VALUES ('201C241101',2020,1,'T890023','C01');
INSERT INTO SETE VALUES ('201A123401',2020,1,'T865677','C01');
INSERT INTO SETE VALUES ('201E201202',2020,1,'T825189','C02');
INSERT INTO SETE VALUES ('201C241102',2020,1,'T890023','C02');


--insert preset data for QUESTION
INSERT INTO QUESTION VALUES ('201C241101',1,'Y','MC',10,'What is the basic unit that can be translated into the algebraic operators and optimized?|Query block|Transaction|Sector|Record','A');
INSERT INTO QUESTION VALUES ('201C241101',2,'Y','MC',10,'If we include one entry for each record in the data file, then it is called a____?| Dense index|Primary index|Secondary index|Clustering index','A');
INSERT INTO QUESTION VALUES ('201C241101',3,'Y','blank',10,'Unknown attributes are assigned a ____ value.','null');
INSERT INTO QUESTION VALUES ('201C241101',4,'Y','blank',10,'Schema in 1st Normal Form (1NF) may have problems like insert anomalies, delete anomalies, and _______ anomalies.','update');
INSERT INTO QUESTION VALUES ('201C241101',5,'Y','long',20,'What is lossless join?',NULL);
INSERT INTO QUESTION VALUES ('201C241101',6,'N','long',10,'For collision resolution, explain the difference between Linear Probing and Quadratic Probing.',NULL);

INSERT INTO QUESTION VALUES ('201A123401',1,'Y','MC',10,'The fastest-running terrestrial animal is___?|Lion|Man|Cheetah|Jaguar','C');
INSERT INTO QUESTION VALUES ('201A123401',2,'Y','MC',10,'What yellow metal is an alloy of copper and zinc? |Steel|Brass|Bronze|Silver','B');
INSERT INTO QUESTION VALUES ('201A123401',3,'Y','blank',15,'Fe is the atomic symbol of which element?','Iron');
INSERT INTO QUESTION VALUES ('201A123401',4,'Y','blank',15,'Which fruit has more genes than humans','Tomato');
INSERT INTO QUESTION VALUES ('201A123401',5,'Y','long',20,'Tell me something about photosynthesis.',NULL);
INSERT INTO QUESTION VALUES ('201A123401',6,'N','long',10,'Tell me something about Cellular differentiation.',NULL);

INSERT INTO QUESTION VALUES ('201E201202',1,'N','long',25,'Write a subject for an email send to your boss ask for a leaving',NULL);
INSERT INTO QUESTION VALUES ('201E201202',2,'N','MC',25,'Which of the following should not be included in a business proposal?|Timeline|Budget|Finance Position|Personnel','C');
INSERT INTO QUESTION VALUES ('201E201202',3,'Y','blank',25,'When writing a news release for general public, we should use ______ English','plain');
INSERT INTO QUESTION VALUES ('201E201202',4,'Y','blank',25,'The document attached to the CV of jobseeker to further explain their suitability is called _______.','cover letter');

INSERT INTO QUESTION VALUES ('201C241102',1,'Y','MC',15,'What is the basic unit that can be translated into the algebraic operators and optimized?|Query block|Transaction|Sector|Record','A');
INSERT INTO QUESTION VALUES ('201C241102',2,'Y','blank',15,'Unknown attributes are assigned a ____ value.','null');
INSERT INTO QUESTION VALUES ('201C241102',3,'Y','blank',15,'Schema in 1st Normal Form (1NF) may have problems like insert anomalies, delete anomalies, and _______ anomalies.','update');
INSERT INTO QUESTION VALUES ('201C241102',4,'Y','long',25,'What are primary index and secondary index?',NULL);

--insert preset data for ANSWER

INSERT INTO ANSWER VALUES ('201C241101',1,'S180101','A',10);
INSERT INTO ANSWER VALUES ('201C241101',2,'S180101','B',0);
INSERT INTO ANSWER VALUES ('201C241101',3,'S180101','null',10);
INSERT INTO ANSWER VALUES ('201C241101',4,'S180101','update',10);
INSERT INTO ANSWER VALUES ('201C241101',5,'S180101','No spurious tuples should be generated by doing a natural-join of any relations.',20);
INSERT INTO ANSWER VALUES ('201C241101',6,'S180101','Sorry. I have no idea.',0);

INSERT INTO ANSWER VALUES ('201C241101',1,'S180102','C',0);
INSERT INTO ANSWER VALUES ('201C241101',2,'S180102','A',10);
INSERT INTO ANSWER VALUES ('201C241101',3,'S180102','null',10);
INSERT INTO ANSWER VALUES ('201C241101',4,'S180102','index',0);
INSERT INTO ANSWER VALUES ('201C241101',5,'S180102','Lossless join is a way of join.',5);
INSERT INTO ANSWER VALUES ('201C241101',6,'S180102','Collisions occur when a new record hashes to a bucket that is already full.',3);

INSERT INTO ANSWER VALUES ('201C241101',1,'S180103','A',10);
INSERT INTO ANSWER VALUES ('201C241101',2,'S180103','A',10);
INSERT INTO ANSWER VALUES ('201C241101',3,'S180103','good',0);
INSERT INTO ANSWER VALUES ('201C241101',4,'S180103','index',0);
INSERT INTO ANSWER VALUES ('201C241101',5,'S180103','Lossless join is a way of join.',5);
INSERT INTO ANSWER VALUES ('201C241101',6,'S180103',NULL,0);




INSERT INTO ANSWER VALUES ('201A123401',1,'S180101','A',0);
INSERT INTO ANSWER VALUES ('201A123401',2,'S180101','B',10);
INSERT INTO ANSWER VALUES ('201A123401',3,'S180101','Iron',15);
INSERT INTO ANSWER VALUES ('201A123401',4,'S180101','Tomato',15);
INSERT INTO ANSWER VALUES ('201A123401',5,'S180101','It is about how green plants produce oxygen.',10);
INSERT INTO ANSWER VALUES ('201A123401',6,'S180101',NULL,0);

INSERT INTO ANSWER VALUES ('201A123401',1,'S180102','C',10);
INSERT INTO ANSWER VALUES ('201A123401',2,'S180102','B',10);
INSERT INTO ANSWER VALUES ('201A123401',3,'S180102','Iron',15);
INSERT INTO ANSWER VALUES ('201A123401',4,'S180102','Grape',0);
INSERT INTO ANSWER VALUES ('201A123401',5,'S180102','No idea.',0);
INSERT INTO ANSWER VALUES ('201A123401',6,'S180102','Cellular differentiation is the process in which a cell changes from one cell type to another.',10);

INSERT INTO ANSWER VALUES ('201A123401',1,'S180103','A',0);
INSERT INTO ANSWER VALUES ('201A123401',2,'S180103','A',0);
INSERT INTO ANSWER VALUES ('201A123401',3,'S180103','Iron',15);
INSERT INTO ANSWER VALUES ('201A123401',4,'S180103','Tomato',15);
INSERT INTO ANSWER VALUES ('201A123401',5,'S180103','It is about how green plants produce oxygen.',10);
INSERT INTO ANSWER VALUES ('201A123401',6,'S180103',NULL,0);



INSERT INTO ANSWER VALUES ('201E201202',1,'S190207','Sorry I have to leave next monday',10);
INSERT INTO ANSWER VALUES ('201E201202',2,'S190207','C',25);
INSERT INTO ANSWER VALUES ('201E201202',3,'S190207','Simple',0);
INSERT INTO ANSWER VALUES ('201E201202',4,'S190207','resume',0);

INSERT INTO ANSWER VALUES ('201E201202',1,'S190230','Leave Request',15);
INSERT INTO ANSWER VALUES ('201E201202',2,'S190230',NULL,0);
INSERT INTO ANSWER VALUES ('201E201202',3,'S190230','plain',25);
INSERT INTO ANSWER VALUES ('201E201202',4,'S190230','cover letter',25);

INSERT INTO ANSWER VALUES ('201E201202',1,'S190221','I want to leave',0);
INSERT INTO ANSWER VALUES ('201E201202',2,'S190221','A',0);
INSERT INTO ANSWER VALUES ('201E201202',3,'S190221','Simple',0);
INSERT INTO ANSWER VALUES ('201E201202',4,'S190221','cover letter',25);

INSERT INTO ANSWER VALUES ('201E201202',1,'S190220','Request for Annual Leave in Advance',20);
INSERT INTO ANSWER VALUES ('201E201202',2,'S190220','B',0);
INSERT INTO ANSWER VALUES ('201E201202',3,'S190220','Plain',25);
INSERT INTO ANSWER VALUES ('201E201202',4,'S190220','cover letter',25);




INSERT INTO ANSWER VALUES ('201C241102',1,'S190207','C',0);
INSERT INTO ANSWER VALUES ('201C241102',2,'S190207','no',0);
INSERT INTO ANSWER VALUES ('201C241102',3,'S190207','update',15);
INSERT INTO ANSWER VALUES ('201C241102',4,'S190207','Primary index is for ordered files.',9);

INSERT INTO ANSWER VALUES ('201C241102',1,'S190230','A',15);
INSERT INTO ANSWER VALUES ('201C241102',2,'S190230','null',15);
INSERT INTO ANSWER VALUES ('201C241102',3,'S190230','no idea',0);
INSERT INTO ANSWER VALUES ('201C241102',4,'S190230','Primary index is for ordered files.',9);

INSERT INTO ANSWER VALUES ('201C241102',1,'S190221','C',0);
INSERT INTO ANSWER VALUES ('201C241102',2,'S190221','no idea',0);
INSERT INTO ANSWER VALUES ('201C241102',3,'S190221','no idea',0);
INSERT INTO ANSWER VALUES ('201C241102',4,'S190221','Primary index is for ordered files.',9);

INSERT INTO ANSWER VALUES ('201C241102',1,'S190220','D',15);
INSERT INTO ANSWER VALUES ('201C241102',2,'S190220',NULL,0);
INSERT INTO ANSWER VALUES ('201C241102',3,'S190220','no idea',0);
INSERT INTO ANSWER VALUES ('201C241102',4,'S190220','no idea',0);





--insert preset data for TAKE
INSERT INTO TAKE VALUES ('201C241101','S180101',71.43,'Good try!');
INSERT INTO TAKE VALUES ('201C241101','S180102',40,'Need more efforts on the subject!');
INSERT INTO TAKE VALUES ('201C241101','S180103',35.71,'Need more efforts on the subject! Maybe we will meet again in next semester.');

INSERT INTO TAKE VALUES ('201A123401','S180101',62.5,'Good try!');
INSERT INTO TAKE VALUES ('201A123401','S180102',56.25,'Good!');
INSERT INTO TAKE VALUES ('201A123401','S180103',50,'Well done!');

INSERT INTO TAKE VALUES ('201E201202','S190207',35,'More effort is needed in this subject.');
INSERT INTO TAKE VALUES ('201E201202','S190230',65,NULL);
INSERT INTO TAKE VALUES ('201E201202','S190221',25,'Please feel free to contact me for help.');
INSERT INTO TAKE VALUES ('201E201202','S190220',70,'Keep the good work!');

INSERT INTO TAKE VALUES ('201C241102','S190207',24,'More effort is needed in this subject.');
INSERT INTO TAKE VALUES ('201C241102','S190230',39,'Good!');
INSERT INTO TAKE VALUES ('201C241102','S190221',9,'Please feel free to contact me for help.');
INSERT INTO TAKE VALUES ('201C241102','S190220',15,'Please feel free to contact me for help.');
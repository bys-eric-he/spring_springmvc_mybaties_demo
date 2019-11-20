CREATE DATABASE IF NOT EXISTS spring_springmvc_mybatis
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

USE spring_springmvc_mybatis;


DROP TABLE IF EXISTS user_info;

CREATE TABLE user_info(
id  INTEGER PRIMARY KEY auto_increment,
uname VARCHAR(20) NOT NULL,
unumber INTEGER
);


INSERT INTO user_info(uname,unumber)
VALUES('heyong',1001),('eric.he',1002);

SELECT *FROM user_info;

DROP TABLE IF EXISTS course_info;

CREATE TABLE course_info(
id INTEGER PRIMARY KEY auto_increment,
cname VARCHAR(20) NOT NULL,
caddress VARCHAR(500)
);

INSERT INTO course_info(cname,caddress)
VALUES('Java','2F Class One'),('Redis','2F Class Two');

SELECT *FROM course_info;

DROP TABLE IF EXISTS course_user_info;

CREATE TABLE course_user_info(
id  INTEGER PRIMARY KEY auto_increment,
uid INTEGER,
cid INTEGER,
/*PRIMARY KEY(uid,cid), */
CONSTRAINT FK_COURSE_USER_INFO_COURSE_INFO FOREIGN KEY (cid) REFERENCES course_info(id),
CONSTRAINT FK_COURSE_USER_INFO_USER_INFO  FOREIGN KEY (uid) REFERENCES user_info(id)
);


INSERT INTO course_user_info(uid,cid)
VALUES(1,1),(1,2),(2,1),(2,2);


SELECT * FROM course_user_info;
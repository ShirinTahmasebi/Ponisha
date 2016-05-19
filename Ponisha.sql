DROP DATABASE IF EXISTS ponisha;
CREATE DATABASE ponisha CHARSET = utf8 COLLATE = utf8_general_ci;
USE ponisha;

drop table if exists user;
drop table if exists resume;


create table resume(
	resumeId INTEGER NOT NULL AUTO_INCREMENT,
    resumeDescription NVARCHAR(255),
    PRIMARY KEY (resumeId)
) charset = utf8; 

create table user(
	userId INTEGER NOT NULL AUTO_INCREMENT,
    username NVARCHAR(40) NOT NULL,
    userFirstLastName nvarchar(100),
    city nvarchar(30),
    birthDate nvarchar(30),
    gender INTEGER default 0, -- default is unknown
    password varchar(20) NOT NULL,
    email varchar(50) NOT NULL,
    resumeId INTEGER UNIQUE,
    PRIMARY KEY (userId),
    FOREIGN KEY (resumeId) REFERENCES resume(resumeId)
) charset = utf8;

create table project(
	projectId INTEGER NOT NULL AUTO_INCREMENT,
    projectName nvarchar(255) NOT NULL,
    budget nvarchar(20) NOT NULL,
    deadline nvarchar(50) not null,
    neededSkills nvarchar(255) not null,
    projectDescription nvarchar(255),
    userCreator INTEGER NOT NULL,
    constraint userCreatorFK foreign key (userCreator) references user (userId),
    primary key (projectId)
) charset = utf8;

-- CREATE TABLE createdProjects (
-- 	projectId INTEGER NOT NULL, 
--     userId INTEGER NOT NULL UNIQUE,
-- 	CONSTRAINT projectIdFK FOREIGN KEY (projectId) REFERENCES project (projectId),
-- 	CONSTRAINT userIdFK FOREIGN KEY (userId) REFERENCES user (userId), 
-- 	PRIMARY KEY (projectId, userId)
-- ) charset = utf8;

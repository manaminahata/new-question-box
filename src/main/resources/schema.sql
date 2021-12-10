use questionbox;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS administrators;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS answers;


create table users (
id int auto_increment,
name varchar(100) not null,
email varchar(100) not null unique,
password varchar(100) not null,
zipcode varchar(8) not null,
address varchar(200) not null,
telephone varchar(15) not null,
primary key(id)
);

create table administrators (
id int auto_increment,
corporate_name varchar(100) not null,
email varchar(100) not null unique,
password varchar(100) not null,
zipcode varchar(8) not null,
address varchar(200) not null,
telephone varchar(15) not null,
primary key(id)
);

create table questions (
id int auto_increment,
question varchar(3000) not null,
user_id int not null,
primary key(id)
);

create table answers (
id int auto_increment,
answer varchar(3000) not null,
user_id int,
administrator_id int,
question_id int not null,
primary key(id)
);

CREATE DATABASE IF NOT EXISTS hotel_db;

USE hotel_db;

CREATE TABLE room (
id int not null primary key auto_increment,
name varchar(55) not null 
);

CREATE TABLE client (
id int not null primary key auto_increment,
name varchar(255) not null,
surname varchar(255) not null,
room_id int not null,
constraint fk_client_room foreign key (room_id) references room(id)
);
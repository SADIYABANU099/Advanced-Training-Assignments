create database ebooks;

use ebooks;

create table books
(
   book_id bigint(5),
   book_name varchar(255),
   author varchar(255),
   price double(8,2),
   stocks int(5),
   constraint book_pk primary key(book_id)
);
create table users
(
	userid bigint(5) primary key auto_increment,
	first_name varchar(255),
    address varchar(255),
    email varchar(255),
    username varchar(255),
    password varchar(255),
    registration_date timestamp
);
create table order_details
(
   order_id bigint(5) auto_increment,
   book_id  bigint(5),
   cust_name varchar(20),
   phone_no varchar(10),
   address varchar(255),
   order_date timestamp,
   quantity int(5),
   constraint order_pk primary key(order_id),
   constraint order_fk foreign key(book_id) references books(book_id)
);
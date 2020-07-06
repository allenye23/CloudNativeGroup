create database cnative_logistics;

use cnative_logistics;
create table logistics(
id int auto_increment primary key,
order_id int not null,
address varchar(50) not null,
arrival_time timestamp,
create_time timestamp,
last_update_time timestamp
);

-- create database cnative_order;

use cnative_order;
drop table  orders;
create table n_orders(
id int auto_increment primary key,
good_name varchar(100) not null,
good_count int   not null,
price DECIMAL(10,2) not null,
address varchar(200) not null,
order_status varchar(10) not null,
create_time timestamp,
last_update_time timestamp
);

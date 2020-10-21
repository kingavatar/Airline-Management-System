drop database Airline_Database;
create database Airline_Database;
use Airline_Database;
create table PASSENGER(passenger_id smallint primary key auto_increment , passenger_name varchar(30), phone varchar(13), age smallint
, pincode int, gender char, address varchar(100), city varchar(30) ,state varchar(30) ,nationality varchar(30) ,departure_time varchar(10) ,destination varchar(30),
constraint pk_passenger unique(passenger_name,phone));
create table ADMIN(admin_id smallint primary key auto_increment, admin_name  varchar(30), system_phone varchar(13),
constraint pk_admin unique(admin_name,system_phone));
create table AIRLINE_RESERVATION(reservation_id smallint primary key auto_increment, reservation_Date varchar(10), seat_price int, passenger_id smallint null, admin_id smallint null, 
	constraint fk_passenger foreign key(passenger_id) references PASSENGER(passenger_id) on delete cascade on update cascade , constraint fk_admin foreign key(admin_id)
	references ADMIN(admin_id) on delete cascade on update cascade );
create table TICKET(ticket_id smallint primary key auto_increment, destination varchar(30),seat_number
varchar(5),departure_time varchar(10), ticket_class varchar(15),
	reservation_id smallint null, constraint fk_reservation foreign key(reservation_id) references AIRLINE_RESERVATION(reservation_id) on delete cascade on update cascade);
insert into ADMIN(admin_name,system_phone) values("admin1","phone");

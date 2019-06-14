create table category(
	id integer unsigned auto_increment primary key,
	name varchar(255),
	description varchar(255),
	ordering integer unsigned
);

create table blog(
	blog_id integer unsigned auto_increment,
	name varchar(255) not null,
	content text,
	created datetime not null,
	category_id integer unsigned,
	primary key(blog_id),
	key(name),
	key(created),
	foreign key (category_id) references category(id)	
);

create table users(
	username varchar(50) not null primary key,
	password varchar(120) not null,
	enabled boolean not null
);

create table authorities(
	id integer auto_increment primary key,
	username varchar(50) not null,
	authority varchar(50) not null,
	foreign key (username) references users(username) on update cascade
);
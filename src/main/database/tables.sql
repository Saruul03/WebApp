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

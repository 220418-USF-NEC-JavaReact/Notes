-- DDL to create a table
create table if not exists social (
	-- First thing I like to do is include the primary key
	id int primary key, -- int declares the datatype, primary key declares that it is the primary key
	fullname varchar(128) not null, -- varchar holds up to 128 characters, not null means we must have some data
	email varchar(164) unique,
	username varchar(128) unique,
	password varchar(256),
	joined date
);

alter table social add column followercount int;
alter table social drop column followercount;

truncate table social;

drop table social;

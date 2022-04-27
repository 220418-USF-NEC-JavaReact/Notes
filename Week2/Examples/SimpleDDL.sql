-- DDL to create a table
create table if not exists social (
	-- First thing I like to do is include the primary key
	id int primary key, -- int declares the datatype, primary key declares that it is the primary key
	fullname varchar(128) not null, -- varchar holds up to 128 characters, not null means we must have some data
	email varchar(164),
	username varchar(128),
	password varchar(256),
	joined date,
	postcontent varchar(256),
	followerid int
);

alter table social add column followercount int;
alter table social drop column followercount;

truncate table social;

drop table social;

-- Simple DML Queries

-- The first thing we probably want to do it insert some data to view
-- The way to insert data is with the INSERT keyword
insert into social (id, fullname, email, username, password, joined, postcontent, followerid) values 
	(1, 'Summer Smith', 'summer.smith@mail.com', 'ssmith', 'password', '2021-01-30', '', null);

-- If you are including all values of the table, you don't have to list tehm our in the first set of parenthesis
insert into social values 
	(2, 'Morty Smith', 'morty.smith@mail.com', 'msmith', 'password', '2022-04-20', '', null),
	(3, 'Summer Smith', 'summer.smith@mail.com', 'ssmith', 'password', '2021-01-30', 'This is a post', null),
	(4, 'Gear Head', 'gear.head@mail.com', 'ghead', 'password', '2020-12-25', 'Let me tell you gears wars', null),
	(5, 'Bird Person', 'bird.person@mail.com', 'bperson', 'password', '2021-09-05', 'I love Tammy', null);
	
-- the star says to select everything from the table
select * from social;

-- If we want to select specific columns, we can tell the select which ones we want
select postcontent from social;

select username from social;



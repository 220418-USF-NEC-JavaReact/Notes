/*
What do we need for our socialhub database:
- User
	- userid
	- first
	- last
	- email
	- password
	- List of Posts ->  We will have a relation with the posts table
		where one user can have many posts assocaited with their account
	- Followers/Following -> List of other Users -> Many users can also follow many users
		We would need a junction between follower and following
- Post
	- postid
	- dateposted
	- content
	- User -> userid
*/

create table users(
	user_id int primary key,
	first_name varchar(64),
	last_name varchar(64),
	email varchar(136) unique,
	password varchar(256)
);

create table post(
	post_id int primary key generated always as identity,
	posted_date date,
	content varchar(256),
	users_fk int references users(user_id) not null
);

create table following_juction_table(
	following_id int references users(user_id) not null,
	follower_id int references users(user_id) not null,
	primary key(following_id, follower_id)
);

insert into users (first_name, last_name, email, password) values
	('Summer', 'Smith', 'summer.smith@mail.com','password'),
	('Morty','Smith', 'morty.smith@mail.com','password'),
	('Gear', 'Head', 'gear.head@mail.com', 'password'),
	('Bird', 'Person', 'bird.person@mail.com', 'password');

select * from users;

-- Lets see what happens if we try to create a post without a user
-- insert into post (posted_date, content, users_fk) values ('2022-04-27', 'This is an invalid post', 6);

insert into post (posted_date, content, users_fk) values ('2022-04-27', 'This is an invalid post', 1);

select * from post;

-- Now at this point, because of reference integrity, if we want to delete a user, we must delete all of their posts
-- The way we can drop all the posts with the CASCADE keyword
drop table users;

drop table following_juction_table cascade;
drop table post cascade;
drop table users;

insert into following_juction_table (following_id, follower_id) values (1,2);

select * from following_juction_table;

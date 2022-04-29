-- We have already seen the simple DML selects, now we can look into more complex queries
select * from users;
select * from post;
select * from following_juction_table;


-- Lets see how to delete a specific record\
-- We can use the where clause to specify to delete the user with id 4
delete from users where user_id = 4;

-- We can also update a specified user with the where clause
update users set password = 'pAssw0rd' where email = 'summer.smith@mail.com';

insert into users (first_name, last_name, email, password) values
('Bird', 'Person', 'bird.person@mail.com', 'password');


insert into post (posted_date, content, users_fk) values
	('2022-04-27', 'Summer 2', 1),
	('2022-04-27', 'Summer 3', 1),
	('2022-04-27', 'Morty 1', 2),
	('2022-04-27', 'Morty 2', 2),
	('2022-04-27', 'Gear Head 1', 3),
	('2022-04-27', 'Gear Head 2', 3),
	('2022-04-27', 'Bird Person 1', 4),
	('2022-04-27', 'Bird Person 2', 4);

-- We can select across tables
select u.first_name as user, p.content as content from users u, post p where u.user_id = p.users_fk;

-- We can select entities that are like certain patterns
-- You can use the wild card % as a standin for 0 or more characters
-- You can use the wild card _ has a standin for exactly 1 character

insert into users (first_name, last_name, email, password) values
	('Valorie', 'Smithy', 'valorie.smithy@mail.com', 'password');

-- Using wildcards we were able to get  all the users with the last name containing smith in their email
select * from users where email like '%smith%';

insert into users (first_name, last_name, email, password) values
	('Mark', 'Madden', 'mark.madden@mail.com', 'password');

-- Use the _ wildcard to search for a user that has the 
select * from users where first_name like 'M_r%';

-- Sorting and ordering results with the order by
select * from users order by email ;

select * from users order by email desc;

-- IN keyword
select * from users where last_name in('Smith');

-- We can also search/specify multiple things
select * from users where last_name like '%mith%' and first_name = 'Morty';

select * from users where first_name like 'M_r%' or password != 'password';

select * from users where user_id > 3;

insert into following_juction_table (following_id, follower_id) values (2,1);

insert into following_juction_table (following_id, follower_id) values 
	(2,3),
	(2,4),
	(2,5);

-- Scalar Functions
-- Takes in a single object, and transforms it
select length('Hello world');
select lower('Hello World');
select upper('hello world');

-- Aggregate Functions
-- Will take in a group of objects, and return some data about them
select count(*) as num_of_posts from post;

select u.first_name, count(f.follower_id)
from users u, following_juction_table f
where u.user_id = f.following_id
group by u.first_name;

select u.first_name as User, count(p.post_id) as NumberOfPosts
from users u, post p
where u.user_id = p.users_fk
group by u.first_name
order by count(p.post_id) desc;
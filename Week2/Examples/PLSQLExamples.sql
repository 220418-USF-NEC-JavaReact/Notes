select * from post;

-- Stored Procedures
create or replace procedure create_post(d date, c varchar(256), u_id int)
as $$
	begin 
		--This is the actual logic that will run
		insert into post(posted_date, content, users_fk)
		values(d, c, u_id);
	end;
$$ language 'plpgsql';

-- To run the stored procedure you have to use the keyword call 
call create_post('2022-04-28', 'This is some content passed into a stored procedure', 1);

select * from post p inner join users u on p.users_fk = u.user_id where p.users_fk = 4;

-- If we want to return a set of data from a function we must return a cursor or a refcursor
-- A cursor is a pointer to a temporary workspace, they hold rows returned from a sql statement
-- AKA it can hold our result set
create or replace function get_posts_by_user(u_id int)
returns refcursor as $$
declare ref refcursor;
begin
	open ref for select * from post p inner join users u on p.users_fk = u.user_id where p.users_fk = u_id;
	return ref;
end;
$$ language 'plpgsql';

-- To call a function we use the select keyword, however, if we want to see the result of the ref, we must turn
-- off autocomit

select get_posts_by_user(5);

select * from following_juction_table;

select * from users u inner join following_juction_table fjt on u.user_id = fjt.following_id;

select u.user_id as following, f.follower_id, f.first_name, f.last_name, f.email, f.password from users u
inner join (select * from users u2 inner join following_juction_table fjt on u2.user_id = fjt.follower_id) as f
on u.user_id = f.following_id;

-- Lets say, we want to store the results of the query above in a virtualized table, so we can query that anytime we want
-- To populate the users following list
create view following_list as 
select u.user_id as following, f.follower_id, f.first_name, f.last_name, f.email, f.password from users u
inner join (select * from users u2 inner join following_juction_table fjt on u2.user_id = fjt.follower_id) as f
on u.user_id = f.following_id;

--After the view is created we can query like a normal table, and if we add entries to either the users or the junction
--the view will automatically updated

select * from following_list;

-- If we wanted to auto generated a id for example, but start at a specific value, we could use something called 
-- a sequence and triggers

-- We first need to create the sequence
create sequence uid start 999;

-- To get the next number in the sequence we call 
select nextval('uid');

-- Using a PLPGSQL object called a trigger, we can tell the database, that every time a new user is created
-- We want to set their id equal to the next value of the sequence 
create or replace function id_trigger()
returns trigger as $$
begin 
	new.user_id = nextval('uid');
	return new;
end;
$$ language 'plpgsql';

-- Now we need to tell postgres when to call this trigger
-- We are create a new trigger
	-- This trigger will execute the procedure id_trigger for each row inserted into the users table
create trigger create_id before insert on users for each row execute procedure id_trigger();

insert into users(first_name, last_name, email, password) values
	('Ethan', 'McGill', 'ethan.mcgill@revature.com', 'password');

select * from users;




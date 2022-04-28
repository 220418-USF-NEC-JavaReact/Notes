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
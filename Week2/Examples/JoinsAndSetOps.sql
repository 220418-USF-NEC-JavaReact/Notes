-- Use DDL to define some tables

create table stores(
	store_id int primary key,
	store_city varchar(20),
	store_state varchar(20)
);

create table suppliers(
	supplier_id int primary key,
	supplier_city varchar(20),
	supplier_state varchar(20),
	product_type varchar(20),
	store_id int references stores
);

-- Let's add some mocked data
insert into stores (store_id, store_city, store_state) values (1, 'Fresno', 'California');
insert into stores (store_id, store_city, store_state) values (2, 'Boca Raton', 'Florida');
insert into stores (store_id, store_city, store_state) values (3, 'New York City', 'New York');
insert into stores (store_id, store_city, store_state) values (4, 'New York City', 'New York');
insert into stores (store_id, store_city, store_state) values (5, 'Tallahassee', 'Florida');
insert into stores (store_id, store_city, store_state) values (6, 'Los Angeles', 'California');
insert into stores (store_id, store_city, store_state) values (7, 'El Paso', 'Texas');
insert into stores (store_id, store_city, store_state) values (8, 'Abilene', 'Texas');
insert into stores (store_id, store_city, store_state) values (9, 'Jamaica', 'New York');
insert into stores (store_id, store_city, store_state) values (10, 'San Antonio', 'Texas');
insert into stores (store_id, store_city, store_state) values (11, 'Redwood City', 'California');
insert into stores (store_id, store_city, store_state) values (12, 'Simi Valley', 'California');
insert into stores (store_id, store_city, store_state) values (13, 'Rochester', 'New York');
insert into stores (store_id, store_city, store_state) values (14, 'San Antonio', 'Texas');
insert into stores (store_id, store_city, store_state) values (15, 'Austin', 'Texas');
insert into stores (store_id, store_city, store_state) values (16, 'Buffalo', 'New York');
insert into stores (store_id, store_city, store_state) values (17, 'Sacramento', 'California');
insert into stores (store_id, store_city, store_state) values (18, 'Orlando', 'Florida');
insert into stores (store_id, store_city, store_state) values (19, 'Houston', 'Texas');
insert into stores (store_id, store_city, store_state) values (20, 'Miami', 'Florida');
insert into stores (store_id, store_city, store_state) values (21, 'San Diego', 'California');
insert into stores (store_id, store_city, store_state) values (22, 'Houston', 'Texas');
insert into stores (store_id, store_city, store_state) values (23, 'New Hyde Park', 'New York');
insert into stores (store_id, store_city, store_state) values (24, 'Lake Worth', 'Florida');
insert into stores (store_id, store_city, store_state) values (25, 'Brooklyn', 'New York');
insert into stores (store_id, store_city, store_state) values (26, 'Los Angeles', 'California');
insert into stores (store_id, store_city, store_state) values (27, 'El Paso', 'Texas');
insert into stores (store_id, store_city, store_state) values (28, 'Wichita Falls', 'Texas');
insert into stores (store_id, store_city, store_state) values (29, 'San Diego', 'California');
insert into stores (store_id, store_city, store_state) values (30, 'San Luis Obispo', 'California');
insert into stores (store_id, store_city, store_state) values (31, 'Miami', 'Florida');
insert into stores (store_id, store_city, store_state) values (32, 'Corpus Christi', 'Texas');
insert into stores (store_id, store_city, store_state) values (33, 'Los Angeles', 'California');
insert into stores (store_id, store_city, store_state) values (34, 'El Paso', 'Texas');
insert into stores (store_id, store_city, store_state) values (35, 'Daytona Beach', 'Florida');
insert into stores (store_id, store_city, store_state) values (36, 'New York City', 'New York');
insert into stores (store_id, store_city, store_state) values (37, 'Fort Worth', 'Texas');
insert into stores (store_id, store_city, store_state) values (38, 'El Paso', 'Texas');
insert into stores (store_id, store_city, store_state) values (39, 'New Hyde Park', 'New York');
insert into stores (store_id, store_city, store_state) values (40, 'Corona', 'California');
insert into stores (store_id, store_city, store_state) values (41, 'Plano', 'Texas');
insert into stores (store_id, store_city, store_state) values (42, 'Stockton', 'California');
insert into stores (store_id, store_city, store_state) values (43, 'Palm Bay', 'Florida');
insert into stores (store_id, store_city, store_state) values (44, 'Melbourne', 'Florida');
insert into stores (store_id, store_city, store_state) values (45, 'Orlando', 'Florida');
insert into stores (store_id, store_city, store_state) values (46, 'New York City', 'New York');
insert into stores (store_id, store_city, store_state) values (47, 'Corpus Christi', 'Texas');
insert into stores (store_id, store_city, store_state) values (48, 'Miami', 'Florida');
insert into stores (store_id, store_city, store_state) values (49, 'Fort Lauderdale', 'Florida');
insert into stores (store_id, store_city, store_state) values (50, 'San Angelo', 'Texas');
insert into stores (store_id, store_city, store_state) values (51, 'New York City', 'New York');
insert into stores (store_id, store_city, store_state) values (52, 'New York City', 'New York');
insert into stores (store_id, store_city, store_state) values (53, 'Jamaica', 'New York');
insert into stores (store_id, store_city, store_state) values (54, 'San Bernardino', 'California');
insert into stores (store_id, store_city, store_state) values (55, 'Bronx', 'New York');
insert into stores (store_id, store_city, store_state) values (56, 'Albany', 'New York');
insert into stores (store_id, store_city, store_state) values (57, 'Palo Alto', 'California');
insert into stores (store_id, store_city, store_state) values (58, 'New York City', 'New York');
insert into stores (store_id, store_city, store_state) values (59, 'Buffalo', 'New York');
insert into stores (store_id, store_city, store_state) values (60, 'Tampa', 'Florida');

insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (1, 'Macon', 'Georgia', 'Deli Products', 37);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (2, 'Brooklyn', 'New York', 'Produce', 36);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (3, 'Conroe', 'Texas', 'Chicken Products', 17);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (4, 'Houston', 'Texas', 'Dairy Products', 7);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (5, 'Dallas', 'Texas', 'Cookware', 16);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (6, 'Tacoma', 'Washington', 'Deli Products', 35);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (7, 'San Jose', 'California', 'Chicken Products', 45);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (8, 'West Palm Beach', 'Florida', 'Dairy Products', 35);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (9, 'Birmingham', 'Alabama', 'Dairy Products', 14);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (10, 'Houston', 'Texas', 'Chicken Products', 11);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (11, 'New York City', 'New York', 'Deli Products', 44);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (12, 'Port Saint Lucie', 'Florida', 'Cookware', 44);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (13, 'Carlsbad', 'California', 'Produce', 5);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (14, 'Miami', 'Florida', 'Dairy Products', 6);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (15, 'Orange', 'California', 'Dairy Products', 11);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (16, 'Spring Hill', 'Florida', 'Dairy Products', 24);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (17, 'Decatur', 'Georgia', 'Deli Products', 28);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (18, 'El Paso', 'Texas', 'Produce', null);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (19, 'Torrance', 'California', 'Chicken Products', 24);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (20, 'Riverside', 'California', 'Deli Products', 9);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (21, 'San Antonio', 'Texas', 'Deli Products', 36);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (22, 'Buffalo', 'New York', 'Deli Products', 3);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (23, 'Chula Vista', 'California', 'Deli Products', 37);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (24, 'Fullerton', 'California', 'Dairy Products', 18);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (25, 'Orlando', 'Florida', 'Produce', null);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (26, 'Los Angeles', 'California', 'Cookware', 14);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (27, 'Los Angeles', 'California', 'Cookware', 47);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (28, 'Largo', 'Florida', 'Cookware', 31);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (29, 'San Antonio', 'Texas', 'Chicken Products', 11);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (30, 'Pompano Beach', 'Florida', 'Deli Products', 22);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (31, 'Amarillo', 'Texas', 'Deli Products', 46);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (32, 'El Paso', 'Texas', 'Cookware', 17);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (33, 'Jamaica', 'New York', 'Deli Products', 31);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (34, 'Schenectady', 'New York', 'Cookware', 25);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (35, 'Bryan', 'Texas', 'Deli Products', 46);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (36, 'Tyler', 'Texas', 'Cookware', 27);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (37, 'Rochester', 'New York', 'Dairy Products', null);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (38, 'Gainesville', 'Florida', 'Produce', null);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (39, 'Amarillo', 'Texas', 'Dairy Products', 15);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (40, 'Oxnard', 'California', 'Deli Products', null);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (41, 'Carlsbad', 'California', 'Cookware', 12);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (42, 'Burbank', 'California', 'Dairy Products', 24);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (43, 'Syracuse', 'New York', 'Chicken Products', 38);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (44, 'West Palm Beach', 'Florida', 'Produce', 25);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (45, 'Spokane', 'Washington', 'Cookware', 28);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (46, 'El Paso', 'Texas', 'Chicken Products', 44);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (47, 'San Francisco', 'California', 'Chicken Products', 20);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (48, 'San Diego', 'California', 'Deli Products', 46);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (49, 'Brooklyn', 'New York', 'Produce', 18);
insert into suppliers (supplier_id, supplier_city, supplier_state, product_type, store_id) values (50, 'Rochester', 'New York', 'Produce', 31);


-- some analysis

-- joins

select s.store_id, supplier_id, product_type from stores s
join suppliers on s.store_id = suppliers.store_id
order by store_id;

select s.store_id, supplier_id, product_type from stores s
left join suppliers on s.store_id = suppliers.store_id 
order by store_id;

select s.store_id, supplier_id, product_type from stores s
right join suppliers on s.store_id = suppliers.store_id 
order by supplier_id;

select s.store_id, supplier_id, product_type from stores s
full join suppliers on s.store_id = suppliers.store_id 
order by store_id;

-- Natural joins 
select s.store_id, supplier_id, product_type from stores s
natural join suppliers
order by store_id;

select s.store_id, supplier_id, product_type from stores s
natural left join suppliers 
order by store_id;

-- Subqueries
-- Number of suppliers without a store
select count(*) from suppliers;
select (count(*)*100.0/ 50) from suppliers where store_id is null;

select (count(*)*100.0/ (select count(*) from suppliers)) as suppliers_missing from suppliers where store_id is null;

-- Select all suppliers that supply to store in the state of new york
select store_id from stores where store_state = 'New York';

select * from suppliers where store_id in (select store_id from stores where store_state = 'New York');

-- Subquery where it's in the from clause
-- count the number of stores and suppliers that are mapped together

select count(*) from (select s.store_id, supplier_id from stores s natural join suppliers) as some_alias;


-- Set operations

select store_city as city from stores
UNION
select supplier_city from suppliers
order by city;

select store_city as city_all from stores 
union all 
select supplier_city from suppliers
order by city_all;

select store_city as city from stores 
intersect
select supplier_city from suppliers

select supplier_city as city_except from suppliers 
except
select store_city from stores 
order by city_except;

-- One cool query

select city_all.city, count(city_all.city)
from (
	select store_city as city from stores 
	union all 
	select supplier_city from suppliers 
	order by city desc 
	) as city_all group by city_all.city;
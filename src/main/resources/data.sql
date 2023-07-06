insert into user_details(id,birth_date,name) values (10001,current_date(), 'Vineet');
insert into user_details(id,birth_date,name) values (10002,current_date(), 'Reetika');
insert into user_details(id,birth_date,name) values (10003,current_date(), 'Anshu');

insert into post(id, description, user_id) values (20001, 'I want to learn AWS', 10001);
insert into post(id, description, user_id) values (20002, 'Second', 10001);
insert into post(id, description, user_id) values (20003, 'First', 10002);
insert into post(id, description, user_id) values (20004, 'Second Post', 10002);
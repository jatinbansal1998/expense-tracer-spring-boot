insert into user_table (ID, user_name, user_email)
values (nextval('user_seq'), 'Jake', 'Codeengine11@gmail.com');
insert into user_table (ID, USER_NAME, USER_EMAIL)
values (nextval('user_seq'), 'John', 'John@john.com');
insert into user_table (ID, USER_NAME, USER_EMAIL)
values (nextval('user_seq'), 'Adam', 'adam@adam.com');


insert into category_table
values (nextval('category_seq'), 'Travel', 1);
insert into category_table
values (nextval('category_seq'), 'Auto Loan', 1);
insert into category_table
values (nextval('category_seq'), 'Travel', 1);

insert into category_table
values (nextval('category_seq'), 'Credit Card Bill', 2);
insert into category_table
values (nextval('category_seq'), 'Auto Loan', 2);

insert into category_table
values (nextval('category_seq'), 'Student Loan', 3);
insert into category_table
values (nextval('category_seq'), 'Travel Loan', 3);
insert into category_table
values (nextval('category_seq'), 'Ticket', 3);
insert into category_table
values (nextval('category_seq'), 'Food', 3);


insert into expense_table (ID, EXPENSE_DESC, EXPENSE_INSTANT, EXPENSE_LOCATION, CATEGORY_ID, USER_ID)
values (nextval('expense_seq').nextval, 'New York Business Trip', '2019-06-16T17:00:00.000Z', 'New York', 1, 1);
insert into expense_table (ID, EXPENSE_DESC, EXPENSE_INSTANT, EXPENSE_LOCATION, CATEGORY_ID, USER_ID)
values (nextval('expense_seq').nextval, 'Ford Mustang Payment', '2019-06-15T15:00:00.000Z', 'LA, CA', 2, 2);
insert into expense_table (ID, EXPENSE_DESC, EXPENSE_INSTANT, EXPENSE_LOCATION, CATEGORY_ID, USER_ID)
values (nextval('expense_seq').nextval, 'Grand Canyon Trip With Family', '2019-06-15T15:00:00.000Z', 'Grand Canyon', 3,
        1);

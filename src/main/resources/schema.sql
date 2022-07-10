insert into role_table(role_id, name)
values (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

insert into user_table(user_id, username, email, password)
values (0, 'admin', 'admin@mail.com', '$2a$12$ctdd0cUUyPUG7zqCKPfUXORbIRXdFZ0KLAH20yR1jf8bF6qb6Kzom');

insert into user_role(user_id, role_id)
values (0, 2);
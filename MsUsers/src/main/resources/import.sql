insert into users (name, last_name, username, password, email , enabled ) values ('jesus', 'londoño', 'jlondono', '$2a$10$iprSL.b0j.zORy9J0/VnAuj04uQ9ogvAKthnnwpixJ8d9A9zAL1ja', 'jesus.antonio.londono@gmail.com', 1);
insert into users (name, last_name, username, password, email , enabled ) values ('andrea', 'aldaz', 'aaldaz', '$2a$10$iprSL.b0j.zORy9J0/VnAuj04uQ9ogvAKthnnwpixJ8d9A9zAL1ja', 'andrea.aldaz@gmail.com', 1);

insert into roles (name) values ('ROLE_USER');
insert into roles (name) values ('ROLE_ADMIN');

insert into users_roles (user_id, roles_id) values (1, 1);
insert into users_roles (user_id, roles_id) values (1, 2);
insert into users_roles (user_id, roles_id) values (2, 1);
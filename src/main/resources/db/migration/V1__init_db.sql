create table products (
    id bigserial primary key,
    name varchar(255),
    cost double precision,
    created_time timestamp default current_timestamp,
    updated_time timestamp default current_timestamp
                      );
insert into products (name, cost) values
('A', 10),
('B', 20),
('C', 30),
('D', 40),
('E', 50),
('F', 60),
('G', 70),
('H', 80),
('I', 90),
('J', 100),
('K', 110),
('L', 120),
('M', 130);

create table order_items (
    id bigserial primary key,
    name varchar(255),
    quantity int,
    cost_per_item double precision,
    cost double precision
);

create table users(
    id bigserial primary key,
    username varchar(30) not null,
    password varchar(80) not null,
    email varchar(50) unique,
    score int
);

create table roles (
    id serial primary key,
    name varchar(50) not null
);

create table users_roles (
    user_id bigint not null,
    role_id int not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);

insert into roles(name)
values ('ROLE_USER'), ('ROLE_ADMIN');

insert into users(username, password, email, score)
values
('user1', '$2a$10$QbCChCuoJBmv4ABv7s/4seDUgAixQ6Pqbmw4Sw3T4BLIusx5KRakW', 'user1@mail.ru', 1),
('user2', '$2a$10$QbCChCuoJBmv4ABv7s/4seDUgAixQ6Pqbmw4Sw3T4BLIusx5KRakW', 'user2@mail.ru', 1),
('user3', '$2a$10$QbCChCuoJBmv4ABv7s/4seDUgAixQ6Pqbmw4Sw3T4BLIusx5KRakW', 'user3@mail.ru', 1),
('user4', '$2a$10$QbCChCuoJBmv4ABv7s/4seDUgAixQ6Pqbmw4Sw3T4BLIusx5KRakW', 'user4@mail.ru', 1);

insert into users_roles(user_id, role_id)
values
(1, 1),
(2, 1),
(3, 2),
(4, 2);




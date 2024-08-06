create table note_type (
    id serial primary key,
    "name" varchar(60) unique not null,
    active boolean not null
);

create table status (
    id serial primary key,
    "name" varchar(60) unique not null
);

create table "label" (
    id serial primary key,
    "name" varchar(60) unique not null,
    active boolean not null
);

create table country (
    id serial primary key, 
    "name" varchar(60) unique not null,
    flag text null,
    prefix integer not null
);

create table "user" (
    id serial primary key,
    username varchar(40) unique not null,
    "password" varchar(200) not null,
    last_login timestamp null,
    last_password timestamp null,
    active boolean not null
);

create table profile (
    id serial primary key, 
    user_id integer not null,
    mail varchar(200) not null,

    "name" varchar(200) null,
    alias varchar(200) null,
    country_id integer null,
    address varchar(400) null,
    phone_prefix_id integer null,
    phone integer null,
    photo text null,

    foreign key (user_id) references "user"(id),
    foreign key (country_id) references country(id),
    foreign key (phone_prefix_id) references country(id)
);


create table category (
    id serial primary key, 
    user_id integer not null,
    label_id integer not null,
    "name" varchar(200) null,
    active boolean not null,

    unique(user_id, "name"),
    foreign key (user_id) references "user"(id),
    foreign key (label_id) references "label"(id)
);

create table note (
    id serial primary key,
    category_id integer not null,
    note_type_id integer not null,
    label_id integer not null,
    status_id integer not null,
    code varchar(10) null,
    short_name varchar(100) not null,
    "name" text not null,
    deleted boolean not null,
    active boolean not null,

     foreign key (category_id) references category(id),
     foreign key (note_type_id) references note_type(id),
     foreign key (label_id) references "label"(id),
     foreign key (status_id) references status(id)
);
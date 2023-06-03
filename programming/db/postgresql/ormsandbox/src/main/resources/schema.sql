create table if not exists child_a (
    id integer primary key
);

create table if not exists child_b (
    id integer primary key
);

create table if not exists root (
    id integer primary key,
    child_a_id integer references child_a (id),
    child_b_id integer references child_b (id)
);

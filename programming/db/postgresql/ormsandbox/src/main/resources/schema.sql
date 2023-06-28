create table if not exists app_user (
    user_id uuid primary key not null,
    email varchar(360) not null unique,
    hashed_password varchar(255) not null
);

create table if not exists app_user_refresh_token (
    user_id uuid references app_user(user_id),
    refresh_token uuid not null unique,
    expire_date timestamp default now() + interval '24' hour
);
create table first (id bigserial primary key,
                    content text not null,
                    status varchar(20));
create table counter (id int primary key,
                      counter bigint not null);
insert into counter(id,counter) values (0,0);
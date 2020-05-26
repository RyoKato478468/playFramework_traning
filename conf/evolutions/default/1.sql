# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table t_user (
  id                            integer auto_increment not null,
  name                          varchar(255) not null,
  school_year                   integer not null,
  height                        integer not null,
  like_food                     varchar(255),
  birth_day                     timestamp,
  created_at                    timestamp not null,
  updated_at                    timestamp not null,
  constraint pk_t_user primary key (id)
);


# --- !Downs

drop table if exists t_user;


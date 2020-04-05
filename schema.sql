drop schema  if exists social;
create schema social;
use social;
drop table if exists user;
create table user (user_id int(11) auto_increment primary key,email varchar(255) unique,first_name varchar(60) not null, last_name varchar(60),password varchar(255) not null,gender varchar(10) not null,country varchar(40) not null,social_score int(2) not null default (5));
drop table if exists followers;
create table followers(followers_id int(11) auto_increment primary key,follower int,following int, foreign key (follower) references user(user_id),foreign key (following) references user(user_id));
drop table if exists posts;
create table posts(post_id int(11) auto_increment primary key,post text,posted_on DATETIME DEFAULT CURRENT_TIMESTAMP,is_abusive bit,is_deleted bit,posted_by int, foreign key(posted_by) references user(user_id));
create table ban_words(word_id int(11) auto_increment primary key,word varchar(255) not null)
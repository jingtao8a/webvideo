create schema webvideo;
use webvideo;
create table `users` (
    `id` int NOT NULL AUTO_INCREMENT primary key,
    `username` varchar(45) NOT NULL,
    `email` varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `img` varchar(255)
);

create table `posts` (
	`id` int NOT NULL AUTO_INCREMENT primary key,
    `title` varchar(255) NOT NULL,
    `desc` varchar(1000) NOT NULL,
    `img` varchar(255) NOT NULL,
    `date` datetime NOT NULL,
    `uid` int NOT NULL,
    foreign key(`uid`) references users(`id`)
);

select * from webvideo.users;
select * from webvideo.posts;
drop table webvideo.users;
drop table webvideo.posts;
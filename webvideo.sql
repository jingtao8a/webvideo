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
    `cat` varchar(255) NOT NULL,
    foreign key(`uid`) references users(`id`)
);

select * from webvideo.users;
select * from webvideo.posts;
drop table webvideo.users;
drop table webvideo.posts;
insert into webvideo.posts(`title`, `desc`, `img`, `date`, `uid`, `cat`) values 
("fsd", "fdsfd", "<p>fdsfds</p>", "0000-00-00", 2, 'art');
insert into webvideo.posts(`title`, `desc`, `img`, `date`, `uid`, `cat`) values 
("Lorem ipsum dolor sit amet consectetur adipisicing elit", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. A possimus excepturi aliquid nihil cumque ipsam facere aperiam at! Ea dolorem ratione sit debitis deserunt repellendus numquam ab vel perspiciatis corporis!", "https://images.pexels.com/photos/7008010/pexels-photo-7008010.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2", "0000-00-00 00-00-00", 1, "art"),
("Lorem ipsum dolor sit amet consectetur adipisicing elit", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. A possimus excepturi aliquid nihil cumque ipsam facere aperiam at! Ea dolorem ratione sit debitis deserunt repellendus numquam ab vel perspiciatis corporis!", "https://images.pexels.com/photos/6489663/pexels-photo-6489663.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2", "0000-00-00 00-00-00", 1, "science"),
("Lorem ipsum dolor sit amet consectetur adipisicing elit", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. A possimus excepturi aliquid nihil cumque ipsam facere aperiam at! Ea dolorem ratione sit debitis deserunt repellendus numquam ab vel perspiciatis corporis!", "https://images.pexels.com/photos/4230630/pexels-photo-4230630.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2", "0000-00-00 00-00-00", 1, "technology"),
("Lorem ipsum dolor sit amet consectetur adipisicing elit", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. A possimus excepturi aliquid nihil cumque ipsam facere aperiam at! Ea dolorem ratione sit debitis deserunt repellendus numquam ab vel perspiciatis corporis!", "https://images.pexels.com/photos/6157049/pexels-photo-6157049.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2", "0000-00-00 00-00-00", 1, "food");
create schema webvideo;
use webvideo;
create table `users` (
    `id` int NOT NULL AUTO_INCREMENT primary key,
    `username` varchar(20) NOT NULL,
    `password` varchar(20) NOT NULL
);

insert into webvideo.users (`username`, `password`) 
	values ("admin", "123"),
		("root", "root"),
        ("xiaoyu", "123");
        
select * from webvideo.users;
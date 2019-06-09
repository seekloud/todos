-- 保存sql语句
create table record_info
(
	id          int           auto_increment,
	author      varchar(63)   not null,
	content     varchar(1023) not null,
	time        long          not null,
	constraint record_info
		primary key (id)
);
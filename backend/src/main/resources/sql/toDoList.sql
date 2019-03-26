-- 保存sql语句
create table record_info
(
	id          int       auto_increment,
	author      text      not null,
	content     text      not null,
	time        long      not null,
	constraint record_info
		primary key (id)
);
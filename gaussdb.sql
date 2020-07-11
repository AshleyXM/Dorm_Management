CREATE TABLE IF NOT EXISTS student(
sid INTEGER PRIMARY KEY,
sname varchar2(30),
gender varchar2(4),
institute varchar2(30),
inschool_date varchar2(20),
dorm_id varchar2(5)
);

insert into student values(1,'章北海','男','云计算学院','2015-10-04','330');
insert into student values(2,'罗辑','女','云计算学院','2016-04-12','213');
insert into student values(3,'熊勉','女','计算机学院','2017-09-15','426');
insert into student values((select max(sid) from student)+1,'朱丽叶','女','计算机学院','2017-09-15','426');

create table if not exists dorm(
dorm_id varchar2(25) primary key,
dorm_capacity INTEGER
);

insert into dorm values('330',6);
insert into dorm values('213',8);
insert into dorm values('426',4);
insert into dorm values('108',4);

create table if not exists dorm_record(
sid INTEGER,
dorm_id varchar2(25),
in_date varchar2(20),
out_date varchar2(20)
);

insert into dorm_record values(1,'330','2015-10-04','至今');
insert into dorm_record values(2,'213','2016-04-12','至今');
insert into dorm_record values(3,'108','2017-09-15','2018-03-15');
insert into dorm_record values(3,'426','2018-03-15','至今');
insert into dorm_record values(4,'426','2017-09-15','至今');




select * from student;
truncate table student;

select * from dorm;
truncate table dorm;

select * from dorm_record;
truncate table dorm_record;

select * from dorm_record where sid=3 order by in_date asc;

select * from student where sname like '%章%'

update student set dorm_capacity=dorm_capacity+1 where sid=3;

select sid,sname,gender,institute,inschool_date,dorm_id,(select dorm_capacity from dorm where dorm_id=student.dorm_id) dorm_capacity from student;
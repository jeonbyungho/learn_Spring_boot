-- http://www.incodom.kr/DB_-_%EB%8D%B0%EC%9D%B4%ED%84%B0_%ED%83%80%EC%9E%85/MYSQL

-- 회원 테이블 생성
create table people (
		idx 			int(11)			primary key auto_increment
	,	id 				varchar(45)		not null unique
	,	password 		varchar(300)	not null
	,	name 			varchar(12)		not null
	,	birthday		date
	,	gender 			char(2)
	,	phone			char(20)
	,	email			varchar(60)
	,	postcode		char(10)
	,	address			varchar(300)
)
;

-- 조회
select * from people p
;

-- 생성
insert into people values(
	0, 'tester01', 't1234', '김실험', 
	'2023-09-21', 'o', '01023456789',
	'user@email.com', '01234', '서울 용산구 한강대로 405'
)
;

-- 로그인
select * from people p
where p.id = 'tester01' and p.password = 't1234'
;
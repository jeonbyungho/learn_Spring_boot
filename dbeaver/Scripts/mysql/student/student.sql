-- http://www.incodom.kr/DB_-_%EB%8D%B0%EC%9D%B4%ED%84%B0_%ED%83%80%EC%9E%85/MYSQL

-- 회원 테이블 생성
create table person (
		idx 			int(11)			not null auto_increment primary key
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

-- 테이블 삭제
DROP TABLE person
;

-- 조회
select * from person p
;

-- 생성
insert into person values(
	0, 'user01', 'u1234', '김철수', 
	'2023-09-21', 'o', '01023456789',
	'user@email.com', '01234', '서울 용산구 한강대로 405'
)
;

-- 로그인
select * from person p where p.id = 'tester01' and p.password = 't1234'
;

-- 이메일로 아이디 찾기
select p.id from person p where p.email = 'user@email.com'
;

-- id 조회
select * from person p where p.idx = 1
;
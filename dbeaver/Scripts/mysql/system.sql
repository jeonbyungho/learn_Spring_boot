-- student User 추가
create user student@localhost identified by '1234'
;

-- 모든 User 조회
select * from user
;

-- Databases 목록 조회
show databases
;

-- student Database 생성
create database student
;

-- student User에게 student Database의 모든 권한 부여
grant all privileges on student.* to student@localhost
;

-- 변경된 내용을 메모리에 반영(권한 적용)
flush privileges
;

-- learn_jpa Database 생성
create database learn_jpa
;

-- student User에게 learn_jpa Database의 모든 권한 부여
grant all privileges on learn_jpa.* to student@localhost
;

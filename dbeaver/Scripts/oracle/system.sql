-- 오라클 DB
-- 계정 생성
CREATE USER springweb IDENTIFIED BY springweb;
-- 리소스 접근 권한을 주기
GRANT CONNECT, resource, dba TO springweb;
-- 계정 삭제
DROP USER SPRINGWEB CASCADE;

-- jpa 연습용 계정 생성
CREATE USER studentuser IDENTIFIED BY 1234;
GRANT CONNECT, resource, dba TO studentuser;
DROP USER studentuser CASCADE;


-- 오라클 DB
-- 계정 생성
CREATE USER springproject IDENTIFIED BY 1234;
-- 리소스 접근 권한을 주기
GRANT CONNECT, resource, dba TO springproject;
-- 계정 삭제
DROP USER SPRINGWEB CASCADE;
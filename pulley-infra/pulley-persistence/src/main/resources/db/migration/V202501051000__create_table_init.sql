CREATE TABLE pulley_user
(
    user_id       VARCHAR(50) PRIMARY KEY,
    user_name     VARCHAR(100) NOT NULL,
    role          VARCHAR(20)  NOT NULL,
    reg_date_time datetime(6) null comment '등록일자',
    mod_date_time datetime(6) null comment '수정일자'
);

-- 초기 데이터 삽입 (선택 사항)
INSERT INTO pulley_user (user_id, username, role)
VALUES ('user-001', 'teacher1', 'TEACHER'),
       ('user-002', 'student1', 'STUDENT');

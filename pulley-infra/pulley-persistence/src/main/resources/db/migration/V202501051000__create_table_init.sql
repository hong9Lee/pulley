CREATE TABLE users
(
    user_id       VARCHAR(50) PRIMARY KEY,
    user_name     VARCHAR(100) NOT NULL,
    role          VARCHAR(20)  NOT NULL,
    reg_date_time datetime(6) null comment '등록일자',
    mod_date_time datetime(6) null comment '수정일자'
);

CREATE TABLE piece
(
    piece_id      VARCHAR(50) PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    teacher_id    VARCHAR(50)  NOT NULL,
    reg_date_time datetime(6) null comment '등록일자',
    mod_date_time datetime(6) null comment '수정일자'
);

-- 문제
CREATE TABLE problem
(
    problem_id    VARCHAR(50) PRIMARY KEY,
    unit_code     VARCHAR(50)  NOT NULL,
    level         INT          NOT NULL,
    problem_type  VARCHAR(20)  NOT NULL,
    answer        VARCHAR(200) NOT NULL,
    piece_id      VARCHAR(50)  NOT NULL,
    reg_date_time datetime(6) null comment '등록일자',
    mod_date_time datetime(6) null comment '수정일자'
);

-- 학습지 제출
CREATE TABLE piece_assignment
(
    assignment_id VARCHAR(50) PRIMARY KEY,
    piece_id      VARCHAR(50) NOT NULL,
    student_id    VARCHAR(50) NOT NULL,
    status        VARCHAR(20) NOT NULL,
    reg_date_time datetime(6) null comment '등록일자',
    mod_date_time datetime(6) null comment '수정일자'
);

-- 문제 풀이
CREATE TABLE problem_attempt
(
    attempt_id     VARCHAR(50) PRIMARY KEY,
    assignment_id  VARCHAR(50)  NOT NULL,
    problem_id     VARCHAR(50)  NOT NULL,
    student_answer VARCHAR(200) NOT NULL,
    reg_date_time  datetime(6) null comment '등록일자',
    mod_date_time  datetime(6) null comment '수정일자'
);

-- 문제 채점
CREATE TABLE problem_grading
(
    grading_id    VARCHAR(50) PRIMARY KEY,
    attempt_id    VARCHAR(50) NOT NULL,
    status        VARCHAR(20) NOT NULL,
    reg_date_time datetime(6) null comment '등록일자',
    mod_date_time datetime(6) null comment '수정일자'
);



INSERT INTO pulley_user (user_id, username, role)
VALUES ('user-001', 'teacher1', 'TEACHER'),
       ('user-002', 'student1', 'STUDENT');

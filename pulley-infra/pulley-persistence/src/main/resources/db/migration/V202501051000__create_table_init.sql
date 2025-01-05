CREATE TABLE users
(
    seq           bigint auto_increment comment '유저 시퀀스' primary key,
    user_id       VARCHAR(50)  NOT NULL,
    user_name     VARCHAR(100) NOT NULL,
    role          VARCHAR(20)  NOT NULL,
    reg_date_time datetime(6) null comment '등록일자',
    mod_date_time datetime(6) null comment '수정일자'
);

CREATE TABLE piece
(
    seq           bigint auto_increment comment '학습지 시퀀스' primary key,
    piece_id      VARCHAR(50)  NOT NULL,
    name          VARCHAR(100) NOT NULL,
    teacher_id    VARCHAR(50)  NOT NULL,
    reg_date_time datetime(6) null comment '등록일자',
    mod_date_time datetime(6) null comment '수정일자'
);

-- 문제
CREATE TABLE problem
(
    seq           bigint auto_increment comment '문제 시퀀스' primary key,
    problem_id    VARCHAR(50)  NOT NULL,
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
    seq           bigint auto_increment comment '학습지 제출 시퀀스' primary key,
    assignment_id VARCHAR(50) NOT NULL,
    piece_id      VARCHAR(50) NOT NULL,
    student_id    VARCHAR(50) NOT NULL,
    status        VARCHAR(20) NOT NULL,
    reg_date_time datetime(6) null comment '등록일자',
    mod_date_time datetime(6) null comment '수정일자'
);

-- 문제 풀이
CREATE TABLE problem_attempt
(
    seq            bigint auto_increment comment '문제 풀이 시퀀스' primary key,
    attempt_id     VARCHAR(50)  NOT NULL,
    assignment_id  VARCHAR(50)  NOT NULL,
    problem_id     VARCHAR(50)  NOT NULL,
    student_answer VARCHAR(200) NOT NULL,
    reg_date_time  datetime(6) null comment '등록일자',
    mod_date_time  datetime(6) null comment '수정일자'
);

-- 문제 채점
CREATE TABLE problem_grading
(
    seq           bigint auto_increment comment '문제 채점 시퀀스' primary key,
    grading_id    VARCHAR(50) NOT NULL,
    attempt_id    VARCHAR(50) NOT NULL,
    status        VARCHAR(20) NOT NULL,
    reg_date_time datetime(6) null comment '등록일자',
    mod_date_time datetime(6) null comment '수정일자'
);



INSERT INTO users (user_id, user_name, role)
VALUES ('user-001', 'teacher1', 'TEACHER'),
       ('user-002', 'student1', 'STUDENT');

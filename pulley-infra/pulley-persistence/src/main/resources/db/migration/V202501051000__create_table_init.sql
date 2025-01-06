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



INSERT INTO users (user_id, user_name, role, reg_date_time, mod_date_time)
VALUES
    ('user-001', 'teacher1', 'TEACHER', NOW(), NOW()),
    ('user-002', 'student1', 'STUDENT', NOW(), NOW()),
    ('user-003', 'student2', 'STUDENT', NOW(), NOW());

INSERT INTO piece (piece_id, name, teacher_id, reg_date_time, mod_date_time)
VALUES
    ('piece-001', 'Math Homework 1', 'user-001', NOW(), NOW()),
    ('piece-002', 'Science Homework 1', 'user-001', NOW(), NOW());

-- ✅ Level 1 (하)
INSERT INTO problem (problem_id, unit_code, level, problem_type, answer, piece_id, reg_date_time, mod_date_time)
VALUES
    ('prb1A2B3C', 'UC1573', 1, 'SUBJECTIVE', 'Answer1', 'pcs1X2Y3Z', NOW(), NOW()),
    ('prb4D5E6F', 'UC1572', 1, 'SELECTION', '1', 'pcs4X5Y6Z', NOW(), NOW()),
    ('prb7G8H9I', 'UC1573', 1, 'SUBJECTIVE', 'Answer3', 'pcs7X8Y9Z', NOW(), NOW()),
    ('prb0J1K2L', 'UC1572', 1, 'SELECTION', '2', 'pcs0X1Y2Z', NOW(), NOW());

-- ✅ Level 2, 3, 4 (중)
INSERT INTO problem (problem_id, unit_code, level, problem_type, answer, piece_id, reg_date_time, mod_date_time)
VALUES
    ('prb3M4N5O', 'UC1572', 2, 'SELECTION', '3', 'pcs3X4Y5Z', NOW(), NOW()),
    ('prb6P7Q8R', 'UC1573', 2, 'SUBJECTIVE', 'Answer6', 'pcs6X7Y8Z', NOW(), NOW()),
    ('prb9S0T1U', 'UC1572', 3, 'SELECTION', '4', 'pcs9X0Y1Z', NOW(), NOW()),
    ('prb2V3W4X', 'UC1573', 3, 'SUBJECTIVE', 'Answer8', 'pcs2X3Y4Z', NOW(), NOW()),
    ('prb5Y6Z7A', 'UC1573', 4, 'SELECTION', '5', 'pcs5X6Y7Z', NOW(), NOW()),
    ('prb8B9C0D', 'UC1572', 4, 'SUBJECTIVE', 'Answer10', 'pcs8X9Y0Z', NOW(), NOW());

-- ✅ Level 5 (상)
INSERT INTO problem (problem_id, unit_code, level, problem_type, answer, piece_id, reg_date_time, mod_date_time)
VALUES
    ('prb1E2F3G', 'UC1572', 5, 'SUBJECTIVE', 'Answer11', 'pcs1E2F3G', NOW(), NOW()),
    ('prb4H5I6J', 'UC1572', 5, 'SELECTION', '1', 'pcs4H5I6J', NOW(), NOW()),
    ('prb7K8L9M', 'UC1573', 5, 'SUBJECTIVE', 'Answer13', 'pcs7K8L9M', NOW(), NOW()),
    ('prb0N1O2P', 'UC1573', 5, 'SELECTION', '2', 'pcs0N1O2P', NOW(), NOW()),
    ('prb3Q4R5S', 'UC1573', 5, 'SUBJECTIVE', 'Answer15', 'pcs3Q4R5S', NOW(), NOW());

-- ✅ 혼합 데이터 추가
INSERT INTO problem (problem_id, unit_code, level, problem_type, answer, piece_id, reg_date_time, mod_date_time)
VALUES
    ('prb6T7U8V', 'UC1573', 1, 'SUBJECTIVE', 'Answer16', 'pcs6T7U8V', NOW(), NOW()),
    ('prb9W0X1Y', 'UC1572', 2, 'SELECTION', '3', 'pcs9W0X1Y', NOW(), NOW()),
    ('prb2Z3A4B', 'UC1572', 3, 'SUBJECTIVE', 'Answer18', 'pcs2Z3A4B', NOW(), NOW()),
    ('prb5C6D7E', 'UC1573', 4, 'SELECTION', '4', 'pcs5C6D7E', NOW(), NOW()),
    ('prb8F9G0H', 'UC1572', 5, 'SUBJECTIVE', 'Answer20', 'pcs8F9G0H', NOW(), NOW());

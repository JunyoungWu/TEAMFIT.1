
CREATE OR REPLACE PROCEDURE ADD_EXERCISE_APPLICATION(
    p_user_code IN NUMBER,
    p_e_class_code IN VARCHAR2
) IS
BEGIN
    INSERT INTO Exercise_Application (application_id, user_code, e_classcode)
    VALUES (Exercise_Application_seq.nextval, p_user_code, p_e_class_code);
END;
/
CREATE OR REPLACE PROCEDURE DELETE_EXERCISE_APPLICATION(
    p_user_code IN NUMBER,
    p_e_classcode IN VARCHAR2
) AS
BEGIN
    DELETE FROM Exercise_Application
    WHERE user_code = p_user_code AND e_classcode = p_e_classcode;
END;
/

CREATE OR REPLACE PROCEDURE ADD_USER_TEACHER (
    p_user_code IN NUMBER,
    p_e_teachername IN VARCHAR2
)IS
    BEGIN
    UPDATE T_USER SET T_TEACHERNAME= p_e_teachername WHERE T_USER_CODE=p_user_code;
END;
/
CALL ADD_USER_TEACHER (21,'우준영');

SELECT * FROM T_USER;

CREATE OR REPLACE PROCEDURE ADD_EXERCISE_APPLICATION(
    p_user_code IN NUMBER,
    p_e_class_code IN VARCHAR2
) IS
BEGIN
    INSERT INTO Exercise_Application (application_id, user_code, e_classcode)
    VALUES (Exercise_Application_seq.nextval, p_user_code, p_e_class_code);
END;
/
INSERT INTO EXERCISE (e_no, e_CLASSCODE, e_NAME, e_LOCATION, e_E)
VALUES ('02', '운동 이름', '운동 장소', '강사 이름', 10000);

call ADD_EXERCISE_APPLICATION(21, '08');
call ADD_EXERCISE_APPLICATION(21, '08');
CREATE SEQUENCE Exercise_Application_seq
START WITH 1
INCREMENT BY 1

SELECT constraint_name, table_name, column_name 
FROM user_cons_columns 
WHERE constraint_name = 'SYS_C008355';

SELECT a.constraint_name, a.table_name, a.column_name, c_pk.table_name AS referenced_table, c_pk.column_name AS referenced_column
FROM user_cons_columns a
JOIN user_constraints c ON a.constraint_name = c.constraint_name
JOIN user_cons_columns c_pk ON c.r_constraint_name = c_pk.constraint_name
WHERE c.constraint_type = 'R'
AND a.constraint_name = 'SYS_C008355';
COMMIT;

SELECT a.constraint_name, a.table_name, a.column_name, c_pk.table_name AS referenced_table, c_pk.column_name AS referenced_column
FROM user_cons_columns a
JOIN user_constraints c ON a.constraint_name = c.constraint_name
JOIN user_cons_columns c_pk ON c.r_constraint_name = c_pk.constraint_name
WHERE c.constraint_type = 'R';

SELECT * FROM EXERCISE WHERE e_classcode = '08';
SELECT * FROM T_USER WHERE T_USER_CODE = 21;

select * from T_USER;
select * from instructor;
SELECT * FROM EXERCISE_APPLICATION;
select * from EXERCISE;
CREATE OR REPLACE PROCEDURE PRINT_USER_EXERCISE_LIST(
    p_user_code IN NUMBER,
    p_cursor OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN p_cursor FOR
        SELECT 
            ea.e_classCode AS ea_e_classCode, 
            e.e_classCode AS e_e_classCode,
            e.e_no, 
            e.e_name, 
            e.e_location, 
            e.e_teacherName, 
            e.e_price
        FROM 
            Exercise_Application ea
        JOIN 
            EXERCISE e ON ea.e_classcode = e.e_classcode
        WHERE 
            ea.user_code = p_user_code;
END;
/

CREATE OR REPLACE PROCEDURE PRINT_EXERCISE_LIST(
    p_cursor OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN p_cursor FOR
        SELECT * FROM Exercise;
END;
/
select * from exercise_application;
CREATE OR REPLACE PROCEDURE DELETE_EXERCISE_BY_CLASSCODE(
    p_e_classcode IN VARCHAR2
) IS
BEGIN
    -- Exercise_Application 테이블에서 관련 데이터 삭제
    DELETE FROM Exercise_Application WHERE e_classcode = p_e_classcode;

    -- Exercise 테이블에서 운동 삭제
    DELETE FROM Exercise WHERE e_classcode = p_e_classcode;
END;
/


CREATE OR REPLACE PROCEDURE ADD_EXERCISE(
    p_e_classCode IN VARCHAR2,
    p_e_name IN VARCHAR2,
    p_e_location IN VARCHAR2,
    p_e_date IN DATE,
    p_e_memNum IN NUMBER,
    p_e_teacherName IN VARCHAR2,
    p_e_price IN NUMBER
) AS
BEGIN
    INSERT INTO exercise (e_no, e_classCode, e_name, e_location, e_date, e_memNum, e_teacherName, e_price)
    VALUES (exercise_seq.nextval, p_e_classCode, p_e_name, p_e_location, p_e_date, p_e_memNum, p_e_teacherName, p_e_price);
    
    COMMIT; -- 커밋 추가
END;
/

select * from exercise where e_no=23;


CREATE OR REPLACE PROCEDURE REGISTER_USER(
    p_name IN VARCHAR2,
    p_phoneNumber IN VARCHAR2,
    p_userID IN VARCHAR2,
    p_password IN VARCHAR2
) AS
BEGIN
    INSERT INTO T_USER (t_user_code, t_name, t_pnum, t_id, t_password)
    VALUES (user_code_seq.NEXTVAL, p_name, p_phoneNumber, p_userID, p_password);
    
    COMMIT; -- 커밋 추가
END;
/
CREATE OR REPLACE PROCEDURE UPDATE_USER_INFO(
    p_userCode IN NUMBER,
    p_newPhoneNumber IN VARCHAR2,
    p_newPassword IN VARCHAR2
) AS
BEGIN
    UPDATE T_USER
    SET t_pnum = p_newPhoneNumber, t_password = p_newPassword
    WHERE t_user_code = p_userCode;
    
    COMMIT; -- 커밋 추가
END;
/
select * from t_user;



declare 
    v_cnt number;
begin
    print_user_exercise_list(4,v_cnt);
    dbms_output.put_line(v_cnt);
end;
/
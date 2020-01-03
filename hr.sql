select department_id from departments where department_name='Executive';

select * from employees where department_id=(select department_id from departments where department_name='Executive');

select last_name,salary,salary+300
from employees;

select last_name Name ,salary*12 "Annual Salary"
from employees;

select last_name||', '||first_name from Employees;
select first_name||q'[, ]'|| last_name from employees;

desc employees;

select first_name, salary from employees where salary between 1500 and 2500;

select last_name from employees where last_name like 'K%';

select last_name from employees where last_name like '_o%';

select last_name from employees where manager_id is null;

select last_name,department_id,salary
from employees
order by department_id,salary desc;

select last_name,last_name,salary
from employees
where rownum=1
order by salary desc;

select min(salary)
from employees;

select employee_id,last_name,salary,department_id
from employees where employee_id=&employee_id;

select employee_id,last_name,salary*12,department_id
from employees
where job_id='&job title';

select employee_id,first_name,last_name,salary,department_id
from employees 
where job_id='&job_title';

select employee_id,first_name,last_name,job_id,&column_name
from employees 
where &condition
order by &order_column;

select employee_id,first_name,last_name,job_id,&&column_name
from employees
order by &column_name;

select first_name,
lpad (salary,(select length(max(salary)) from employees),'*')
from employees;

SELECT employee_id, CONCAT(first_name,last_name) NAME, job_id, LENGTH(last_name), INSTR(last_name,'a') "conatains 'a'?"
from employees
where SUBSTR(job_id, 4)='REP';

select round(45.923,2),round(45.923,0),round(45.923,-1)
from dual;

select last_name,hire_date
from employees
where hire_date between '01-JAN-1990' and '31-DEC-10'
order by hire_date;

select sysdate from dual;

select round(sysdate,'month') from dual;

select last_name,
to_char(hire_date, 'fmDD Month YYYY')
as hiredate
from employees;

select to_char(salary,'$99,999.00') salary from employees where last_name='Ernst';

select last_name,upper(concat(substr(last_name,1,8),'_US'))
from employees
where department_id=60;

select last_name,job_id,commission_pct 
from employees
where commission_pct is null;

select last_name,salary,job_id,nvl(commission_pct,0.1),(salary*12)+(salary*12*nvl(commission_pct,0.1)) AN_SAL from employees where job_id like 'ST_CLERK';

select last_name,job_id from employees where hire_date is null;

select last_name, salary, commission_pct,NVL2(commission_pct, 'SAL+COMM', 'SAL') income
from employees
where department_id in (50,80);

select first_name,length(first_name) "expr1",last_name,length(last_name) "expr2",
nullif(length(first_name),length(last_name)) RESULT
from employees;

select last_name, manager_id, commission_pct,
       coalesce(manager_id, commission_pct,-1) comm
from employees
order by commission_pct;

select last_name,job_id,salary,
CASE job_id when 'IT_PROG' THEN 1.10*salary
when 'ST_CLERK' THEN 1.15*salary
when 'SA_REP' THEN 1.20*salary
ELSE salary END "REVISED SALARY"
from employees;

select last_name,salary,department_id,
        DECODE(department_id,30,1.10*salary,
        40,1.15*salary,
        50,1.20*salary,
        salary)
        REVISED_SALARY
        from employees;
        
select last_name, salary,
decode(trunc(salary/2000,0), 0, 0.00,
                             1, 0.09,
                             2, 0.20,
                             3,0.3,
                             4,0.4,
                             5,0.42,
                             6,0.44,
              0.45) TAX_RATE
from employees
WHERE DEPARTMENT_ID=80;

select (max(salary)-min(salary)) Difference from employees;

select (max(salary)-avg(salary)) Difference from employees;

select (avg(salary)-min(salary)) Difference from employees;


//select count(employee_id) 
from employees
where (trunc(avg(salary)-salary)<=4000);

//SELECT COUNT(EMPLOYEE_ID) FROM EMPLOYEEES WHERE SALARY-&VAR<=4000;

select avg(nvl(commission_pct,0))
from employees;

select avg(commission_pct)
from employees;

SELECT DEPARTMENT_ID,COUNT(EMPLOYEE_ID)
FROM EMPLOYEES 
GROUP BY(DEPARTMENT_ID)
ORDER BY DEPARTMENT_ID;


select department_id,job_id,sum(salary)
from employees
group by (department_id,job_id);

select department_id,max(salary)
from employees
group by department_id
having max(salary)>10000;

SELECT COUNT(EMPLOYEE_ID) 
FROM EMPLOYEES
WHERE SALARY < (SELECT AVG(SALARY)
FROM EMPLOYEES);

select e.employee_id,e.last_name,
d.location_id,department_id
from employees e join departments d
using (department_id);

select e.employee_id,e.last_name,
d.location_id,d.department_id
from employees e join departments d
on (e.department_id=d.department_id);

select e.last_name EMP,m.last_name MGR
from employees e join employees m
on (e.MANAGER_ID=m.EMPLOYEE_ID)
where m.last_name='Kochhar';

select e.employee_id, e.first_name, l.city
from employees e, departments d, locations l
where ((e.department_id=d.department_id) and (d.location_id=l.location_id) and l.city='Seattle');


select e.employee_id,e.last_name,
d.location_id,d.department_id
from employees e join departments d
on (e.department_id=d.department_id) 
join locations l
on d.location_id=l.location_id;


select e.employee_id,e.last_name,
d.location_id,d.department_id
from employees e left outer join departments d
on (e.department_id=d.department_id);


select e.employee_id,e.last_name,
d.location_id,d.department_id
from employees e right outer join departments d
on (e.department_id=d.department_id);


select e.employee_id,e.last_name,
d.location_id,d.department_id
from employees e full outer join departments d
on (e.department_id=d.department_id);

select last_name,department_name
from employees
cross join departments;

select last_name
from employees
where salary > (select salary from employees where last_name='Abel');

select last_name,job_id,salary
from employees
where job_id=(select job_id from employees where employee_id=141)
and salary>(select salary from employees where employee_id=143);

select last_name ,job_id, salary 
from employees 
where salary=(select min(salary) from employees);

select employee_id, last_name,job_id,salary
from employees
where salary <all  (select salary from employees where job_id='IT_PROG')
and job_id<> 'IT_PROG';

select employee_id,last_name
from employees e
where employee_id not in(select distinct(manager_id) from employees where manager_id is not null);

select count(distinct(employee_id)) 
from employees;

select distinct(manager_id) from employees;

select last_name,department_id 
from employees
where department_id in(20,50)
order by last_name;

select last_name,hire_date from employees
where hire_date like '%04';

select last_name,hire_date
from employees
where hire_date between '01-JAN-04' and '31-DEC-04';

select last_name,salary,commission_pct
from employees
where commission_pct is not null
order by salary desc,commission_pct desc;

select last_name 
from employees
where last_name like '__a%';

select last_name 
from employees
where last_name like '%a%e%' or last_name like'%e%a%';

select last_name 
from employees
where last_name like '%a%' and last_name like '%e%';

select last_name,job_id,salary 
from employees
where (job_id='SA_REP' or job_id='ST_CLERK')
and salary not in(2500,3500,7000);

select initcap(last_name), length(last_name)
from employees
where last_name like 'J%' or last_name like 'A%' or last_name like 'M%'
order by last_name;

SELECT INITCAP(last_name),
decode(last_name, 'J%', length(last_name),
                  'A%', length(last_name),
                  'M%', length(last_name),
   0) length_name
from employees;

select last_name,round(sysdate-hire_date) as MONTHS_WORKED 
from employees
order by (round(sysdate-hire_date),last_name) ;

select last_name, round(months_between(sysdate,hire_date)) as months_worked
from employees 
order by round(months_between(sysdate,hire_date));

SELECT LAST_NAME, DEPARTMENT_ID
FROM EMPLOYEES 
WHERE DEPARTMENT_ID=(SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE LAST_NAME LIKE 'Abel');

select last_name, hire_date 
from employees
where hire_date > (select hire_date from employees where last_name like 'Davies');

select e.last_name, e.hire_date, m.last_name, m.hire_date
from employees e, employees m
where e.manager_id = m.employee_id and e.hire_date<m.hire_date;

select e.employee_id,e.last_name,d.department_id,l.city
from employees e,departments d,locations l
where e.department_id=d.department_id and d.location_id=l.location_id and l.city like 'T%';

select distinct(manager_id) from employees where manager_id is not null;


select last_name 
from employees
where NOT EXISTS (select distinct(manager_id) from employees where manager_id is not null);

select employee_id, last_name
from employees e
where not exists (select manager_id from employees d where e.employee_id=d.manager_id);

  SELECT  last_name 
  FROM employees o 
  WHERE EXISTS (SELECT 'X' FROM employees i 
  WHERE i.department_id = o.department_id
  AND i.hire_date > o.hire_date
  AND i.salary > o.salary);	
  
  select e.employee_id, e.last_name, d.department_name
  from employees e, departments d
  where e.department_id=d.department_id;
  
  
  //select e.employee_id,e.last_name,d.department_name
  from employees e,departments o
  where exists(SELECT 'X' FROM employees e WHERE e.department_id = d.department_id);
  
select employee_id,last_name, 
(select department_name from departments d where e.department_id=d.department_id) department 
from employees e ;

WITH summary AS ( SELECT d.department_name, SUM(e.salary) AS dept_total FROM employees e, departments d WHERE e.department_id = d.department_id GROUP BY d.department_name) 
SELECT department_name, dept_total 
FROM summary 
WHERE dept_total > ( SELECT SUM(dept_total) * 1/8 FROM summary ) 
ORDER BY dept_total DESC;

select employee_id,job_id
from employees
UNION
select employee_id,job_id
from job_history;

select employee_id,job_id,department_id
from employees
UNION ALL
select employee_id,job_id,department_id
from job_history
order by employee_id;

select employee_id,job_id,department_id
from employees
where employee_id=200
UNION ALL
select employee_id,job_id,department_id
from job_history
where employee_id=200
order by employee_id;

select employee_id,job_id
from employees
INTERSECT
select employee_id,job_id
from job_history;

//employees who have not changed job
select employee_id,job_id
from employees
MINUS
select employee_id,job_id
from job_history;

//display dep id,loc,hire date of all employees
select department_id,TO_NUMBER(null) location,hire_date
from employees
UNION
select department_id,location_id,TO_DATE(null)
from departments;

select employee_id,department_id,TO_NUMBER(null) location,hire_date
from employees
UNION
select TO_NUMBER(null),department_id,location_id,TO_DATE(null)
from departments;

select TO_NUMBER(null),location_id
from locations
UNION
select department_id,location_id
from departments;

select employee_id,job_id,salary
from employees
UNION
select employee_id,job_id,0
from job_history;

column a_dummy NOPRINT
select 'sing' AS "My dream",3 a_dummy
from dual
union
select 'I''d like to teach',1 a_dummy
from dual
union
select 'the world to', 2 a_dummy
from dual
order by a_dummy;

INSERT INTO departments(department_id,department_name, manager_id, location_id)
values(770,'Public Relations',100,1700);

//implicit
INSERT INTO departments(department_id,department_name)
VALUES (30,'Purchasing');

//explicit setting to null
INSERT INTO departments
values(100,'Finance',NULL,NULL);

insert into employees(employee_id, first_name, last_name,
email, phone_number, hire_date, job_id,
salary, commission_pct, manager_id, department_id)
VALUES (1130,'LOUIS','Popp','LPOPP1','515.124.4567',
SYSDATE,'AC_ACCOUNT',6900,NULL,205,770);

insert into employees
values (1131,'Dolly','Bagaria','dolly@gmail.com','515.124.4567'
,TO_DATE('FEB 3, 1999', 'MON DD, YYYY'),'AC_ACCOUNT',69000,NULL,205,770);

SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=1131;

insert into departments
(department_id,department_name,location_id)
values(&department_id,'&department_name',&location);

INSERT INTO sa_reps(id, name, salary, commission_pct)
select employee_id,last_name,salary,commission_pct
from employees
where job_id LIKE '%REP%';

update employees
set department_id=70
where employee_id=1131;

SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=1131;

update employees
set job_id=(select job_id from employees where employee_id=205),
salary=(select salary from employees where employee_id=205)
where employee_id=1131;

update employees
set department_id=71
where employee_id=1130;

select * from departments where department_name='test_dept';

insert into employees
values (1132,'Niharika','Bagaria','niharika@gmail.com',
'515.124.4567',TO_DATE('FEB 3, 1999', 'MON DD, YYYY'),
'AC_ACCOUNT',69000,NULL,205,71);

select * from employees where department_id=71;

delete from job_history
where employee_id=1130;

delete from employees
where department_id=(select department_id from departments where department_name='test_dept');

insert into locations 
values (3300, 'Financial district', 560037, 'Hyderabad', 'Telangana', 'IN');

insert into departments
(department_id,department_name,location_id)
values(73,'test_dept',3300);

insert into employees
values (1133,'Pragyat','Bagaria','niharika@gmail.com','515.124.4567'
,TO_DATE('FEB 3, 1999', 'MON DD, YYYY'),'AC_ACCOUNT',69000,NULL,205,73);

select * from employees where employee_id=1133;

update employees
set salary=(salary+(salary*1/100))
where employee_id=1133;

delete from employees
where department_id=(select department_id
from departments
where location_id=(select location_id from locations where city='Hyderabad'));

insert into
          (select employee_id, last_name,email, hire_date, job_id, salary, department_id
            FROM employees
            where department_id=50)
values (99999, 'taylor', 'dtay', TO_DATE('07-JUN-99', 'DD-MON-RR'), 'ST_CLERK', 5000, 50);

select * from employees where department_id=50;

update employees
set first_name='swift' where employee_id=99999;

savepoint update_done;

insert into employees
values (99998,'xyz','abc','pragyat@gmail.com','515.124.4567',
TO_DATE('FEB 3, 1999', 'MON DD, YYYY'),'AC_ACCOUNT',69000,NULL,205,73);

rollback to update_done;

select * from employees where employee_id=99999;

commit;

delete from employees where employee_id=99999;

insert into departments
(department_id,department_name,location_id)
values(74,'Corporate tax',3300);

commit;

create table dept
(deptno NUMBER(2),
dname VARCHAR(14),
loc VARCHAR(13),
create_date DATE DEFAULT SYSDATE);

create table dept80
as
select employee_id, last_name, salary*12 ANNSAL
from employees
where department_id=80;

select * from dept80;

desc dept80;

create table copy_emp
as
select * from employees;

delete from copy_emp;

rollback;

select * from copy_emp;

delete from copy_emp where employee_id=1131;

commit;

rollback;

select * from copy_emp;

create table role
(role_id number(3) constraint role_pkey primary key,role_name varchar2(20));

create table users
(id  NUMBER(3) CONSTRAINT user_id_pk PRIMARY KEY,
 name VARCHAR2(20),
 username VARCHAR2(20),
 password  VARCHAR2(20) check (LENGTH(password)>8),
 email VARCHAR2(20),
 role_id NUMBER(3) CONSTRAINT role_id_fk REFERENCES role(role_id));
 
 insert into role values
 (1,'admin');
 
  insert into role values(2,'manager');
  insert into role values(3,'user');
  select * from role;
  
  insert into users values ( &id, '&name','&username','&password','&email',&rollid);
  
  select * from users;
  
 update users
set mobile='9987536325'
where id=101;

update users
set mobile='9987536326'
where id=102;

update users
set mobile='914536325'
where id=103;

update users
set mobile='7787536325'
where id=104;

update users
set mobile='7987536300'
where id=105;

   select * from users;
   
insert into users
values
(106,'Reeta','reta1','pass6','reta@gmail.com',3,'9874561251');

delete from users where id=106;

insert into users
values
(106,'Geeta','geta1','pass6','geta@gmail.com',3,'9874561251');


create view empvu80
as select employee_id, last_name, salary
from employees
where department_id=80;

select * from empvu80;

create or replace view empvu80 (id_number,name,sal,department_id)
as select employee_id, first_name || ' ' || last_name, salary,department_id
from employees
where department_id=80;



create or replace view dept_sum_vu (name,minsal,maxsal,avgsal)
as select d.department_name,min(e.salary),max(e.salary),avg(e.salary)
FROM employees e JOIN departments d
ON (e.department_id=d.department_id)
GROUP BY d.department_name;

select * from dept_sum_vu;


create or replace view empvu20
as select *
from employees
where department_id=20
with check option constraint empvu20_ck;

select * from empvu20;

update empvu20
set department_id=10;

create or replace view empvu20
as select *
from employees
where department_id=20;

create or replace view empvu10(employee_numbe,employee_name,job_title)
as select employee_id,last_name,job_id
from employees
where department_id=10
with read only;

update empvu10
set job_title='20';

 drop view empvu10;
 
 create sequence users_id_sequence
 increment by 1
 start with 106
 maxvalue 9999
 nocache
 nocycle;
 
insert into users values ( users_id_sequence.nextval, 'solly','sollyb','solly1234','solly@g.com',3,'9856245899');

 select users_id_sequence.currval
 from dual;
 
 select * from users;
 
  create sequence roles_id_sequence
 increment by 1
 start with 1
 maxvalue 9999
 nocache
 nocycle;
 
 select roles_id_sequence.currval
 from dual;
 
 insert into role values(roles_id_sequence.nextval,'aaa',NULL);
 
 create index users_last_name_idx
 on users(name);
 
 create view managr_view as select id,name,email from users where role_id=2;
 
 create synonym mgrv
 for managr_view;

select * from mgrv;

describe dictionary;

select * from dictionary;


select * from dictionary where table_name='USER_OBJECTS';

select object_name,object_type,created,status
from user_objects
order by object_type;

desc user_tables;

select table_name
from user_tables;

select column_name, data_type, data_length, data_precision, data_scale, nullable
from user_tab_columns
where table_name='USERS';

desc user_constraints;

SELECT constraint_name, constraint_type, search_condition, r_constraint_name, delete_rule, status
from USER_CONSTRAINTS
where table_name='USERS';

desc user_cons_columns;

SELECT constraint_name,column_name
from user_cons_columns
where table_name='USERS';

desc user_views;

select distinct view_name from user_views;

select text from user_views
where view_name='EMPVU20';


select sequence_name, min_value,max_value, increment_by, last_number
from user_sequences;

DESC user_synonyms;

select * from user_synonyms;

comment on table users is 'Employee Information';

select * from user_tab_comments;


DECLARE
    a Number := 3;
BEGIN
    a := a+1;
END;
/

set serveroutput on;
DECLARE
    a Number := 3;
BEGIN
    a := a+1;
    DBMS_output.put_line(a);
END;
/

set serveroutput on;

declare 
a Number;
b Number;
begin 
select role_id,role_name into a,b from role where roll_id>1;
if b=1 then
insert into t1 values (b,a);
else
a := a+b;
end;
/

set serveroutput on;

declare
a number:=3;
begin
a:=a+1;
if mod(a,2) =0 then
DBMS_output.put_line(a);
else
DBMS_output.put_line(a+1);
end if;
end;
/


declare 
    i number:=1;
begin
    loop
        insert into T1 values(i,i);
        i:=i+1;
        exit when i>100;
    end loop;
end;
/

delete from T1;
select * from T1;


declare 
    i number:=1;
begin
while i<150 loop
    insert into T1 values(i,i);
        i:=i+1;
    end loop;
end;
/
     select * from T1;
     
     
declare 
    i number:=1;
begin
    for i in 1..150 loop
        insert into T1 values(i,i);
        
    end loop;
end;
/
    



SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
    n_pct employees.commission_pct%TYPE;
    v_eval varchar2(10);
    n_emp_id employees.employee_id%TYPE := 145;
BEGIN
    SELECT commission_pct
    INTO n_pct
    FROM employees
    WHERE employee_id=n_emp_id;
case n_pct
    when 0 then
        v_eval:='N/A';
    when 0.1 then
        v_eval:='Low';
    when 0.4 then
        v_eval:='High';
    else 
        v_eval:='Fair';
end case;
DBMS_output.put_line('Employee'||n_emp_id||' commission '||to_char(n_pct)||' which is '||v_eval);
end;
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
    n_name users.name%TYPE:='pragyat';
    v_role integer;
    role_str varchar2(20);
    
BEGIN
    SELECT role_id
    INTO v_role
    FROM users
    WHERE name=n_name;
case v_role
    when 1 then
        role_str:='Admin';
    when 2 then
        role_str:='Manager';
    when 3 then
        role_str:='User';
    else 
       role_str:='User not found';
end case;
DBMS_output.put_line('Employee '||n_name||' having role_id '||v_role||' is a '||role_str);
end;
/  


    select * from employee_salary;    
    drop table employee_salary;
    
INSERT INTO "HR"."EMPLOYEE_SALARY" (EMP_NO, NAME, BASIC, HRA, DA, TOTAL_DEDUCTION, NET_SALARY, GROSS_SALARY) VALUES ('1', 'pragyat', '31000', '8000', '1000', '5000', '35000', '40000');
INSERT INTO "HR"."EMPLOYEE_SALARY" (EMP_NO, NAME, BASIC, HRA, DA, TOTAL_DEDUCTION, NET_SALARY, GROSS_SALARY) VALUES ('2', 'dolly', '15000', '4000', '1000', '5000', '15000', '20000');
INSERT INTO "HR"."EMPLOYEE_SALARY" (EMP_NO, NAME, BASIC, HRA, DA, TOTAL_DEDUCTION, NET_SALARY, GROSS_SALARY) VALUES ('3', 'niharika', '14000', '4000', '1000', '5000', '15000', '19000');
INSERT INTO "HR"."EMPLOYEE_SALARY" (EMP_NO, NAME, BASIC, HRA, DA, TOTAL_DEDUCTION, NET_SALARY, GROSS_SALARY) VALUES ('4', 'ram', '14000', '4000', '1000', '5000', '15000', '19000');
INSERT INTO "HR"."EMPLOYEE_SALARY" (EMP_NO, NAME, BASIC, HRA, DA, TOTAL_DEDUCTION, NET_SALARY, GROSS_SALARY) VALUES ('5', 'shaam', '13000', '4000', '1000', '5000', '15000', '18000');
 
 select * from employee_salary;
    


SET SERVEROUTPUT ON SIZE 1000000;
<<parent>>
DECLARE
  n_emp_id employee_salary.emp_no%TYPE:= &emp_id;
  n_name employee_salary.name%TYPE := '&name';
  n_basic employee_salary.basic%TYPE :=&basic;
  n_hra employee_salary.hra%TYPE :=&hra;
  n_da employee_salary.da%TYPE :=&da;
  n_total_deduction employee_salary.total_deduction%TYPE :=&total_deduction;
  n_net_salary employee_salary.net_salary%TYPE :=&net_salary;
  n_gross_salary employee_salary.gross_salary%TYPE :=&gross_salary;

BEGIN
    insert into employee_salary values(n_emp_id,n_name,n_basic,n_hra,n_da,n_total_deduction,n_net_salary,n_gross_salary);

  <<child>>
        DECLARE
             n_name employee_salary.name%TYPE :=parent.n_name;
             n_salary employee_salary.net_salary%TYPE;
             n_tax integer;
        BEGIN
            SELECT net_salary
            INTO n_salary
            FROM employee_salary
            WHERE name=n_name;
         CASE 
                when n_salary<=20000 then
                    n_tax:=0.1*n_salary;
                when n_salary>20000 and n_salary<=30000 then
                    n_tax:=0.2*n_salary;
               when n_salary>30000 and n_salary<=40000 then
                    n_tax:=0.3*n_salary; 
                else
                    n_tax:=0.4*n_salary;
        end case;
        DBMS_output.put_line('Employee'||parent.n_name||' tax '||n_tax||' on Rs. '||n_salary);
        end;
    end;
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  -- declare a cursor
  CURSOR cur_chief IS
      SELECT u.username,
             r.role_name          
      FROM users u,role r
      where u.role_id=r.role_id;
 
  r_chief cur_chief%ROWTYPE;
BEGIN
  OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
 
    EXIT WHEN cur_chief%NOTFOUND;
 
    -- print department - chief
    DBMS_OUTPUT.PUT_LINE(r_chief.username || ' - ' ||
                         r_chief.role_name );
  END LOOP;
  -- close cursor cur_chief
  CLOSE cur_chief;
END;
/




declare 
    i number:=1;
begin
    for i in 1..150 loop
        insert into T1 values(i,i+1);
    end loop;
end;
/

delete from t1;

select * from t1;

declare 
    a T1.A%TYPE;
    b T1.B%TYPE;
    -- declare a cursor
    CURSOR cur_chief IS
      SELECT A,B FROM T1 where A<B
      for update;    
      r_chief cur_chief%ROWTYPE;
begin
 OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO a,b;
    EXIT WHEN cur_chief%NOTFOUND;
    delete from T1 where current of cur_chief;
    insert into T1 values(b,a); 
    -- print department - chief
    DBMS_OUTPUT.PUT_LINE('done' );
    END LOOP;
  -- close cursor cur_chief
   CLOSE cur_chief;
end;
/



declare 
    e T1.A%TYPE;
    f T1.B%TYPE;
    -- declare a cursor
    CURSOR cur_chief IS
      SELECT A,B FROM T1 where A<B 
      for update;    
      r_chief cur_chief%ROWTYPE;

begin
 OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
    EXIT WHEN cur_chief%NOTFOUND; 
        
    update T1 set A=r_chief.B ,B=r_chief.A where current of cur_chief;
        
    -- print department - chief  
  END LOOP;
  DBMS_OUTPUT.PUT_LINE('done' );
  -- close cursor cur_chief
  CLOSE cur_chief;
end;
/


select * from copy_emp;



declare 
    -- declare a cursor
    CURSOR cur_chief IS
      SELECT * FROM copy_emp WHERE hire_date > '31-DEC-05'
      for update;    
      r_chief cur_chief%ROWTYPE;

begin
 OPEN cur_chief;
 --LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
  --  EXIT WHEN cur_chief%NOTFOUND; 
        
    update copy_emp set salary=(salary +r_chief.salary*0.1);
        
    -- print department - chief  
 -- END LOOP;
  DBMS_OUTPUT.PUT_LINE('done' );
  -- close cursor cur_chief
  CLOSE cur_chief;
end;
/





declare 
    -- declare a cursor    
    CURSOR cur_chief IS
     SELECT last_name,first_name,hire_date
      FROM copy_emp
      WHERE hire_date= (select min(hire_date) from copy_emp);
      r_chief cur_chief%ROWTYPE;
begin
 OPEN cur_chief;
 LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
    EXIT WHEN cur_chief%NOTFOUND; 
        DBMS_OUTPUT.PUT_LINE(r_chief.last_name || '    '|| r_chief.first_name );       
    -- print department - chief  
END LOOP;
  -- close cursor cur_chief
  CLOSE cur_chief;
end;
/



declare  
   -- c integer:=0;
    CURSOR cur_chief IS
     SELECT last_name,first_name,hire_date
      FROM copy_emp; 
       r_chief cur_chief%ROWTYPE;
begin
 OPEN cur_chief;
 LOOP 
    
    FETCH cur_chief INTO r_chief;
   -- EXIT WHEN c=12;
   exit when cur_chief%rowcount=12;
        DBMS_OUTPUT.PUT_LINE(r_chief.last_name || '    '|| r_chief.first_name ); 
        --c:=c+1;
END LOOP;
  CLOSE cur_chief;
end;
/





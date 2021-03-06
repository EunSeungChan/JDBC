select * from EMPLOYEES;
--Employees 테이블에서 자신을 관리자 ID(manager_id)로 지정하고 
--있는 직원수(직속부하직원수)를 다음과 같이 출력하고자 한다.
--적절한 쿼리문을 작성하시오. 단 직속부하직원 수가 8이상인 
--경우만 출력하도록 하고, 직속부하직원수 순으로 오름차순 정렬한다.

select count(*) 직속부하직원수, e.employee_id 관리자사번, e.last_name 관리자이름 
from employees e join employees m
on e.employee_id = m.manager_id
group by e.employee_id,e.last_name
having count(*) > 7 -- >=8
order by 1; --count(*)



--입력받은 두개의 업무명(job_title)에 종사하는 사원들의 
--사번(employee_id), 이름(first_name), 연봉(salary)을 
--출력하는 프로그램을 작성합니다
select job_title from jobs;

select e.employee_id, e.first_name, e.salary
from employees e, jobs j
where e.job_id = j.job_id ;

select e.employee_id, e.first_name, e.salary
from employees e join jobs j
on e.job_id = j.job_id 
where j.job_title in('President','Programmer')  ;

select e.employee_id, e.first_name, e.salary
from employees e join jobs j
on e.job_id = j.job_id 
where j.job_title in(?,?)  ;
# Write your MySQL query statement below
select e.unique_id ,emp.name from Employees emp left join EmployeeUNI e on e.id=emp.id;
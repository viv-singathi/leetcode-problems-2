Select d.name as Department, e.name as Employee, e.salary as Salary
From Employee e Join Department d on e.departmentId = d.id
where e.salary = (
    select max(salary) from Employee r
    where r.departmentId = e.departmentId);
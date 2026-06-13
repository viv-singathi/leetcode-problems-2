Select E.name as Employee FROM Employee E
join Employee M on E.managerId = M.Id
Where E.managerId = M.id and E.salary > M.Salary;
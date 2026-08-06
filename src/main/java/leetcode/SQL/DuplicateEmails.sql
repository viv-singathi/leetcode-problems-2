--problem: find all duplicate emails in the person table
Select distinct A.email From Person A
Where A.email in (select B.Email From Person B group by B.email having count(*) >= 2);
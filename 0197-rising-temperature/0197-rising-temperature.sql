# Write your MySQL query statement below
Select W1.id 
from Weather W1 inner join Weather W2 
ON DATEDIFF(W1.recordDate,W2.recordDate)=1
and W1.temperature>W2.temperature;
# Write your MySQL query statement below
select St.student_id,St.student_name,S.subject_name,count(E.subject_name) as attended_exams from Students St cross join Subjects S  left join Examinations E on St.student_id=E.student_id
 and S.subject_name=E.subject_name
 group by St.student_id , St.student_name ,S.subject_name order by (St.student_id);


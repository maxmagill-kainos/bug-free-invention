START TRANSACTION;
UPDATE Job
	INNER JOIN TempSpecTable USING(Job_ID)
	SET Job_Spec = TempSpecTable.Spec_Link;
    
select * FROM Job;
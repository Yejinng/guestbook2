--CRUD

--insert
insert
	into guestbook
	values(guestbook_seq.nextval, '둘리','호이~','1234',sysdate);
	
insert
	into guestbook
	values(guestbook_seq.nextval, '또치','또또~','2345',sysdate);
	
-- select
select no, name, content, password, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss')
	from guestbook
	order by reg_date;
	
--delete
delete
	from guestbook
	where no =2
	and password ='1234';	
	
	commit;
-- sequence
drop sequence guestbook_seq;
commit;
create sequence guestbook_seq
start with 1
increment by 1
maxvalue 9999999999;
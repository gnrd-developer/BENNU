/*SELECT*/
select * from postgres.public.user;
select * from postgres.public.country;
select * from postgres.public.profile;
select * from postgres.public.category;
select * from postgres.public.note;
select * from postgres.public.label;
select * from note_type;
select * from status;

/*DELETE*/
delete from postgres.public.country where id = 12;
delete from postgres.public.user where id = 5;
delete from postgres.public.profile where id = 4;
delete from postgres.public.category where id = 2;
delete from postgres.public.note where id = 4;

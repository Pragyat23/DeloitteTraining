select * from author;

INSERT INTO "HR"."PUBLISHER" (PUBLISHER_ID, PUBLISHER_NAME, CITY) VALUES ('1', 'Penguin', 'Delhi');
INSERT INTO "HR"."PUBLISHER" (PUBLISHER_ID, PUBLISHER_NAME, CITY) VALUES ('2', 'HCP', 'Mumbai');

select * from publisher;

INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, TYPE, AUTHOR_ID, PUBLISHER_ID) VALUES ('1001', 'Alchemist', '300', '2005', 'novellas', '101', '1');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, TYPE, AUTHOR_ID, PUBLISHER_ID) VALUES ('1002', 'Norwegian Woods', '250', '2010', 'novels', '102', '2');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, TYPE, AUTHOR_ID, PUBLISHER_ID) VALUES ('1003', 'Sense of Ending', '350', '2001', 'poems', '103', '1');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, TYPE, AUTHOR_ID, PUBLISHER_ID) VALUES ('1004', 'Glass Palace', '400', '2015', 'short stories', '104', '2');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, TYPE, AUTHOR_ID, PUBLISHER_ID) VALUES ('1005', 'Recursion', '450', '2016', 'novels', '105', '1');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, TYPE, AUTHOR_ID, PUBLISHER_ID) VALUES ('1006', 'Metamorphosis', '250', '2000', 'novels', '101', '2');

select * from book;

select * from book b,publisher p, author a where b.publisher_id=p.publisher_id and b.author_id=a.author_id;


INSERT INTO "HR"."AUTHOR" (AUTHOR_ID, NAME, NATIONALITY) VALUES ('104', 'Baren', 'German');
INSERT INTO "HR"."AUTHOR" (AUTHOR_ID, NAME, NATIONALITY) VALUES ('105', 'Kafka', 'Indian');
INSERT INTO "HR"."AUTHOR" (AUTHOR_ID, NAME, NATIONALITY) VALUES ('101', 'Coleho', 'Brazil');
INSERT INTO "HR"."AUTHOR" (AUTHOR_ID, NAME, NATIONALITY) VALUES ('102', 'Murukami', 'Japan');
INSERT INTO "HR"."AUTHOR" (AUTHOR_ID, NAME, NATIONALITY) VALUES ('103', 'Barnes', 'England');
commit;

INSERT INTO "HR"."PUBLISHER" (PUBLISHER_ID, PUBLISHER_NAME, CITY) VALUES ('1', 'Penguin', 'Delhi');
INSERT INTO "HR"."PUBLISHER" (PUBLISHER_ID, PUBLISHER_NAME, CITY) VALUES ('2', 'HCP', 'Mumbai');


INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, TYPE, AUTHOR_ID, PUBLISHER_ID) VALUES ('1001', 'Alchemist', '300', '2005', 'novellas', '101', '1');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, TYPE, AUTHOR_ID, PUBLISHER_ID) VALUES ('1002', 'Norwegian Woods', '250', '2010', 'novels', '102', '2');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, TYPE, AUTHOR_ID, PUBLISHER_ID) VALUES ('1003', 'Sense of Ending', '350', '2001', 'poems', '103', '1');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, TYPE, AUTHOR_ID, PUBLISHER_ID) VALUES ('1004', 'Glass Palace', '400', '2015', 'short stories', '104', '2');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, TYPE, AUTHOR_ID, PUBLISHER_ID) VALUES ('1005', 'Recursion', '450', '2016', 'novels', '105', '1');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, TYPE, AUTHOR_ID, PUBLISHER_ID) VALUES ('1006', 'Metamorphosis', '250', '2000', 'novels', '101', '2');

select b.isbn,b.title,b.pages,a.name,p.publisher_name,p.city from book b,publisher p, author a where b.publisher_id=p.publisher_id and b.author_id=a.author_id;

delete from book;
delete from author;
delete from publisher;


select a.name,b.title from author a,book b where a.author_id=b.author_id order by a.name,b.title;

select title from book where pub_year>2005;


select b.title,p.city from book b,publisher p where b.publisher_id=p.publisher_id AND (b.type='poems' AND p.city='Delhi');

select count(*) from book b,author a where a.author_id=b.author_id and a.name='Coleho';


create or replace
procedure book_cnt(aname String, c out int) is
begin
    select count(*)
    into c
    from book b, author a
    where b.author_id=a.author_id and a.name=aname;
end;
/
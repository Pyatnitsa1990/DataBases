--//////////////////////////////////HOMEWORK TABLE///////////////////////////////////////////

create table homework (
                          id SERIAL primary key not null,
                          name varchar(20) not null,
                          description varchar(100) not null
);

INSERT INTO tmp.homework ("name", description)
values
    ('chemical', 'chemical subject'),
    ('math', 'math subject');

--//////////////////////////////////LESSONS TABLE///////////////////////////////////////////

create table lesson(
                       id SERIAL primary key not null,
                       name varchar(20) not null,
                       updateAt TIMESTAMP not null,
                       homework_id integer not null unique references Homework(id)
);

INSERT INTO lesson ("name", updateat, homework_id)
values
    ('ls1', now(), 1),
    ('ls2', now(), 2);

delete  from lesson

ALTER SEQUENCE tmp.lesson_id_seq
    RESTART 1;


--//////////////////////////////////SCHEDULE TABLE///////////////////////////////////////////

create table schedule(
                         id SERIAL primary key not null,
                         name varchar(20) not null,
                         updateAt TIMESTAMP default current_timestamp
);


INSERT INTO schedule ("name")
values
    ('sch1'),
    ('sch2');


delete  from schedule where 1 = 1

ALTER SEQUENCE schedule_id_seq
    RESTART 1;

--//////////////////////////////////LESSON SCHEDULE TABLE///////////////////////////////////////////

create table lesson_schedule(
                                id_lesson serial4 not null references lesson(id),

                                id_schedule serial4 not null,
                                foreign key (id_schedule) references schedule(id),

                                primary key (id_lesson, id_schedule)
);


INSERT INTO lesson_schedule (id_lesson, id_schedule)
values
    (1,1),
    (1,2);


select l."name" , s."name" , s.updateat
from lesson_schedule ls
         join lesson l 	on l.id  = ls.id_lesson
         join schedule s on s.id  = ls.id_schedule
where ls.id_schedule  = 1


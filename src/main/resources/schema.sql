
create table if not exists movies (id serial primary key,title varchar(30) unique,poster varchar(3000),rating float,releasedate date,votes int, 
duration int,censor varchar(10));
create table if not exists languages (id serial primary key, language varchar(30) unique );
create table if not exists types (id serial primary key, type varchar(30) unique);
create table if not exists genres (id serial primary key , genre varchar(30) unique);


create table if not exists movie_language (movieid int references movies(id) on delete cascade,languageid int references languages(id) on delete cascade,PRIMARY KEY (movieid, languageid));

create table if not exists movie_type (movieid int references movies(id) on delete cascade,typeid int references types(id) on delete cascade,PRIMARY KEY (movieid, typeid)); 

create table if not exists movie_genre(movieid int references movies(id) on delete cascade ,genreid int references genres(id) on delete cascade,PRIMARY KEY (movieid, genreid));



create table if not exists locations (id serial primary key,location varchar(40) unique); 
create table if not exists theatres (id serial primary key,columns int,name varchar(30) unique,rows int,totalseats int,location int references locations(id) on delete cascade);
create table if not exists seats(id serial primary key,seat_number int unique);
create table if not exists shows (id serial primary key,date date,name varchar(20),language varchar(20),time time , movie int references movies(id) on delete cascade, theatre int references theatres(id) on delete cascade,unique(date,time,theatre));
create table if not exists show_seats (show_id int references shows(id),seat_id int references seats(id));
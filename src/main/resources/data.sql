

INSERT INTO types (type) VALUES ('2D'), ('3D'), ('IMAX'), ('4DX'), ('Dolby Atmos'), ('VIP'), ('Drive-In'), ('ScreenX'), ('Standard'), ('Gold Class') ON CONFLICT (type) DO NOTHING;
INSERT INTO genres (genre) VALUES ('Action'), ('Adventure'), ('Comedy'), ('Drama'), ('Fantasy'), ('Horror'), ('Mystery'), ('Romance'), ('Science Fiction'), ('Thriller'), ('Animation'), ('Documentary'), ('Crime'), ('Historical'), ('Musical'), ('Superhero'), ('Biographical'), ('War'), ('Western'), ('Mythological') ON CONFLICT (genre) DO NOTHING;
INSERT INTO languages (language) VALUES ('Hindi'), ('English'), ('Telugu'), ('Tamil'), ('Malayalam'), ('Kannada'), ('Bengali'), ('Marathi'), ('Gujarati'), ('Punjabi'), ('Urdu'), ('Odia'), ('Assamese'), ('Sanskrit'), ('Bhojpuri'), ('Rajasthani'), ('Haryanvi'), ('Konkani'), ('Kashmiri'), ('Manipuri') ON CONFLICT (language) DO NOTHING;




insert into movies (title,poster,rating,releasedate,votes,duration,censor) values ('Pushpa','http',9.9,'2023-12-05',124,132,'B') on conflict (title) do nothing;
insert into movie_genre (movieid,genreid) values (1,2),(1,8),(1,10) on conflict (movieid,genreid) do nothing;
insert into movie_type (movieid,typeid) values (1,2),(1,8) on conflict (movieid,typeid) do nothing;
insert into movie_language (movieid,languageid) values (1,2),(1,8) on conflict (movieid,languageid) do nothing;

insert into locations (location) values ('Penumur'),('Chittoor'),('Tirupathi') on conflict (location) do nothing;
insert into theatres (columns,name,rows,totalseats,location) values(19,'Sv Talkies',19,10,1) on conflict (name) do nothing;
INSERT INTO shows (date, name, language, time, movie, theatre) VALUES ('2025-11-11', 'Noon', 'Telugu', '18:25:00', 1, 1) on conflict(date,time,theatre) do nothing;

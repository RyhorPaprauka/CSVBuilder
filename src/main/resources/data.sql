INSERT INTO genre (id, name)
VALUES (1, 'CLASSIC'),
       (2, 'COMEDY'),
       (3, 'FANTASY'),
       (4, 'THRILLER'),
       (5, 'RELIGIOUS');

INSERT INTO author(id, name, date_of_birth)
VALUES (1, 'Dostoevskiy', to_date('1821-11-11', 'yyyy-MM-dd')),
       (2, 'Gashek', to_date('1883-04-30', 'yyyy-MM-dd')),
       (3, 'Tolkien', to_date('1892-02-03', 'yyyy-MM-dd'));

INSERT INTO book (name, creation_year, genre_id, author_id)
VALUES ('Demons', to_date('1871', 'yyyy'), 1, 1),
       ('Crime and Punishment', to_date('1865', 'yyyy'), 1, 1),
       ('The Good Soldier Svejk', to_date('1921', 'yyyy'), 2, 2),
       ('The Lord of the Rings', to_date('1954', 'yyyy'), 3, 3),
       ('The Hobbit', to_date('1937', 'yyyy'), 3, 3),
       ('Bible', to_date('0300', 'yyyy'), 5, null);

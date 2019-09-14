DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book;

CREATE TABLE genre
(
  id   BIGSERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE author
(
  id            BIGSERIAL PRIMARY KEY,
  name          VARCHAR(50) NOT NULL UNIQUE,
  date_of_birth DATE NOT NULL
);

CREATE TABLE book
(
  id            BIGSERIAL PRIMARY KEY,
  name          VARCHAR(50) NOT NULL UNIQUE,
  creation_year DATE NOT NULL,
  genre_id      BIGINT REFERENCES genre (id),
  author_id     BIGINT REFERENCES author (id)
);
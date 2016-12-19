DROP TABLE movies IF EXISTS;
CREATE TABLE movies (
  id INTEGER IDENTITY PRIMARY KEY,
  title varchar(100) NOT NULL,
  category varchar(50) DEFAULT NULL,
  year char(4) DEFAULT NULL,
  "cast" varchar(100) DEFAULT NULL,
  director varchar(100) DEFAULT NULL,
  story varchar(100) DEFAULT NULL,
  price double DEFAULT NULL
);
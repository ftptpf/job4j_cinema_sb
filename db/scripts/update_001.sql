CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  username VARCHAR NOT NULL,
  email VARCHAR NOT NULL UNIQUE,
  phone VARCHAR NOT NULL UNIQUE,
  password VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS sessions (
  id SERIAL PRIMARY KEY,
  name text
);

CREATE TABLE IF NOT EXISTS ticket (
  id SERIAL PRIMARY KEY,
  session_id INT NOT NULL REFERENCES sessions(id),
  pos_row INT NOT NULL,
  cell INT NOT NULL,
  user_id INT NOT NULL REFERENCES users(id)
);

ALTER TABLE ticket ADD CONSTRAINT ticket_buy_error UNIQUE (session_id, pos_row, cell);

INSERT INTO sessions(name) VALUES('Фильм №1');
INSERT INTO sessions(name) VALUES('Фильм №2');
INSERT INTO sessions(name) VALUES('Фильм №3');

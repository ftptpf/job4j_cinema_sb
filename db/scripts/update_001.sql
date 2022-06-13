CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  username VARCHAR NOT NULL,
  email VARCHAR NOT NULL UNIQUE,
  phone VARCHAR NOT NULL UNIQUE
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

INSERT INTO sessions(name) VALUES('Старый хороший фильм');
INSERT INTO sessions(name) VALUES('Фильм начала этого года');
INSERT INTO sessions(name) VALUES('Новый фильм который только что вышел');

INSERT INTO users(username, email, phone) VALUES ('user', 'user@user', 0);

INSERT INTO ticket (session_id, pos_row, cell, user_id) VALUES (1, 1, 1, 0);
INSERT INTO ticket (session_id, pos_row, cell, user_id) VALUES (1, 1, 2, 0);
INSERT INTO ticket (session_id, pos_row, cell, user_id) VALUES (1, 1, 3, 0);
INSERT INTO ticket (session_id, pos_row, cell, user_id) VALUES (1, 2, 1, 0);
INSERT INTO ticket (session_id, pos_row, cell, user_id) VALUES (1, 2, 2, 0);
INSERT INTO ticket (session_id, pos_row, cell, user_id) VALUES (1, 2, 3, 0);
INSERT INTO ticket (session_id, pos_row, cell, user_id) VALUES (1, 3, 1, 0);
INSERT INTO ticket (session_id, pos_row, cell, user_id) VALUES (1, 3, 2, 0);
INSERT INTO ticket (session_id, pos_row, cell, user_id) VALUES (1, 3, 3, 0);
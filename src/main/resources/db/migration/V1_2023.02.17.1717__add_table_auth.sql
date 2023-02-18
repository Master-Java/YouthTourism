CREATE TABLE users
(
    id           serial      NOT NULL PRIMARY KEY,
    username     text        NOT NULL,
    password     text        NOT NULL,
    email        text UNIQUE NOT NULL,
    name         text,
    surname      text,
    patronymic   text,
    confirmation boolean DEFAULT false,
    enabled      boolean DEFAULT true
);

CREATE INDEX ix1_users_email
    ON users (email);

CREATE TABLE user_details
(
    id         bigint UNIQUE NOT NULL REFERENCES users ON DELETE CASCADE,
    phone      text,
    city       text,
    university text,
    interests  text
);

CREATE TABLE role
(
    id   bigint UNIQUE REFERENCES users,
    role text
);

INSERT INTO users (username, password, email)
VALUES ('admin', '$2a$15$bYV5/3zC/0iN9Rp4m3mFR.vn4KXHSNoFY8fFQqXR7/aWFnp9gL8Z2', 'admin@mail.ru');

INSERT INTO user_details (id, city)
VALUES (1, 'Saint-Petersburg');

INSERT INTO role (id, role)
VALUES (1, 'ROLE_ADMIN');
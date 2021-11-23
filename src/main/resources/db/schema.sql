CREATE TABLE if not exists authorities(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE if not exists users(
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN DEFAULT true,
    authority_id INT NOT NULL REFERENCES authorities(id)
);

CREATE TABLE if not exists posts(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    created TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    author_id INT REFERENCES users(id) NOT NULL
);

CREATE TABLE if not exists comments(
    id SERIAL PRIMARY KEY,
    text TEXT NOT NULL,
    created TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    post_id INT REFERENCES posts(id) NOT NULL,
    author_id INT REFERENCES users(id) NOT NULL
);


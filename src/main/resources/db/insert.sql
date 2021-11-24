INSERT INTO authorities (name) VALUES ('ROLE_USER');
INSERT INTO authorities (name) VALUES ('ROLE_ADMIN');

INSERT INTO users (username, password, enabled, authority_id)
VALUES ('him', '$2a$10$lQwmLwjkDLUrcnA3yYe1D.5maB7ycV0D7eEGwPT9xKiOydDFkA4dW', true,
        (SELECT id FROM authorities WHERE name = 'ROLE_ADMIN'));
INSERT INTO users (username, password, enabled, authority_id)
VALUES ('user', '$2a$10$Y8yfdaLsUw8xoHwMi6w4FuSQD/2TJJWY.PfkwEyrddzSztPjDSgxq', true,
        (SELECT id FROM authorities WHERE name = 'ROLE_USER'));
INSERT INTO users (username, password, enabled, authority_id)
VALUES ('himax', '$2a$10$o8O1e.saDbyWxGTRJMEICuN/fesWWCPQ.6wJrsrRm3MIY6F0DdjGC', true,
        (SELECT id FROM authorities WHERE name = 'ROLE_USER'));

INSERT INTO posts (name, description, author_id)
VALUES ('Продам дом', 'Дом хороший брусовой 6 соток', 2),
       ('Продам ладу гранту.', 'Один хозяин без ДТП пробег 100000', 3);

INSERT INTO comments(text, post_id, author_id)
VALUES ('Скидка есть?', 1, 1), ('На квартиру меняете?', 1, 3);
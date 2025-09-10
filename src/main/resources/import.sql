INSERT INTO role (name) VALUES ('USER');
INSERT INTO role (name) VALUES ('ADMIN');

insert into "user" values(1,'kaiki@kaiki.com','kaiki','$2a$10$zmzxbzXvp2JMhi39QYddwOYquMA9ZUU9cffKh85lY47zym/PWfC0i');

INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
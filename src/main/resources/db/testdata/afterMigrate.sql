
INSERT INTO "role" (name) SELECT 'USER' WHERE NOT EXISTS (SELECT 1 FROM "role" WHERE name = 'USER');
INSERT INTO "role" (name) SELECT 'ADMIN' WHERE NOT EXISTS (SELECT 1 FROM "role" WHERE name = 'ADMIN');
INSERT INTO "user" (email, name, password) VALUES ('kaiki@kaiki.com', 'Admin Anshin', '$2a$10$zmzxbzXvp2JMhi39QYddwOYquMA9ZUU9cffKh85lY47zym/PWfC0i') ON CONFLICT (email) DO NOTHING;
INSERT INTO user_role (user_id, role_id) VALUES (1, 2) ON CONFLICT (user_id, role_id) DO NOTHING;
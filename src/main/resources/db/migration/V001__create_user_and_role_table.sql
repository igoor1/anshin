
CREATE TABLE "user" (
  id        BIGSERIAL NOT NULL,
  email     VARCHAR(255) NOT NULL UNIQUE,
  name      VARCHAR(255) NOT NULL,
  password  VARCHAR(255) NOT NULL,
  CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TYPE role_enum AS ENUM ('USER', 'ADMIN');

CREATE TABLE "role" (
  id    BIGSERIAL NOT NULL ,
  name  role_enum NOT NULL,
  CONSTRAINT role_pk PRIMARY KEY (id)
);

CREATE TABLE user_role (
  role_id   BIGINT NOT NULL,
  user_id   BIGINT NOT NULL,
  CONSTRAINT user_role_pk PRIMARY KEY (role_id, user_id),
  CONSTRAINT fk_user_role_user FOREIGN KEY (user_id) REFERENCES "user" (id),
  CONSTRAINT fk_user_role_role FOREIGN KEY (role_id) REFERENCES "role" (id)
);
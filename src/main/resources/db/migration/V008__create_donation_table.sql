CREATE TABLE donation (
  id            BIGSERIAL    NOT NULL,
  description   VARCHAR(255) NOT NULL,
  date          DATE         NOT NULL,
  type          VARCHAR(255) NOT NULL,
  CONSTRAINT donation_pk PRIMARY KEY (id)
);
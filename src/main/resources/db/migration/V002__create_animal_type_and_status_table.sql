CREATE TABLE animal_type (
  id    BIGSERIAL NOT NULL,
  name  VARCHAR(30) NOT NULL,
  CONSTRAINT animal_type_pk PRIMARY KEY (id)
);


CREATE TABLE animal_status (
  id    BIGSERIAL NOT NULL,
  name  VARCHAR(30) NOT NULL,
  CONSTRAINT animal_status_pk PRIMARY KEY (id)
);
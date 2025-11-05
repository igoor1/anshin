CREATE TABLE vaccine (
  id            BIGSERIAL    NOT NULL,
  manufacturer  VARCHAR(255) NOT NULL,
  name          VARCHAR(255) NOT NULL,
  CONSTRAINT vaccine_pk PRIMARY KEY (id)
);

CREATE TABLE animal_vaccine (
  id                BIGSERIAL NOT NULL,
  application_date  DATE      NOT NULL,
  animal_id         BIGINT    NOT NULL,
  vaccine_id        BIGINT    NOT NULL,
  CONSTRAINT animal_vaccine_pk PRIMARY KEY (id),
  CONSTRAINT fk_animal_vaccine FOREIGN KEY (vaccine_id) REFERENCES vaccine (id),
  CONSTRAINT fk_animal_vac_animal FOREIGN KEY (animal_id) REFERENCES animal (id)
);
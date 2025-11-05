CREATE TABLE disease (
  id        BIGSERIAL    NOT NULL,
  name      VARCHAR(255) NOT NULL,
  severity  VARCHAR(255) NOT NULL,
  CONSTRAINT disease_pk PRIMARY KEY (id)
);

CREATE TABLE animal_disease (
  id                BIGSERIAL NOT NULL,
  diagnosis_date    DATE      NOT NULL,
  recovery_date     DATE      NULL,
  animal_id         BIGINT    NOT NULL,
  disease_id        BIGINT    NOT NULL,
  CONSTRAINT animal_disease_pk PRIMARY KEY (id),
  CONSTRAINT fk_animal_disease_disease FOREIGN KEY (disease_id) REFERENCES disease (id),
  CONSTRAINT fk_animal_disease_animal FOREIGN KEY (animal_id) REFERENCES animal (id)
);
CREATE TABLE medication (
  id            BIGSERIAL    NOT NULL,
  name          VARCHAR(255) NOT NULL,
  batch         VARCHAR(255) NULL,
  manufacturer  VARCHAR(255) NOT NULL,
  CONSTRAINT medication_pk PRIMARY KEY (id)
);

CREATE TABLE animal_medication (
  id                BIGSERIAL    NOT NULL,
  dosage            VARCHAR(255) NOT NULL,
  start_date        DATE         NOT NULL,
  end_date          DATE         NULL,
  animal_id         BIGINT       NOT NULL,
  medication_id     BIGINT       NOT NULL,
  CONSTRAINT animal_medication_pk PRIMARY KEY (id),
  CONSTRAINT fk_animal_medication_medication FOREIGN KEY (medication_id) REFERENCES medication (id),
  CONSTRAINT fk_animal_medication_animal FOREIGN KEY (animal_id) REFERENCES animal (id)
);
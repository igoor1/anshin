CREATE TABLE animal (
  id            BIGSERIAL    NOT NULL,
  birth_date    DATE         NULL,
  breed         VARCHAR(30)  NOT NULL,
  color         VARCHAR(15)  NOT NULL,
  description   VARCHAR(255) NOT NULL,
  gender        VARCHAR(10)  NOT NULL,
  name          VARCHAR(50)  NOT NULL,
  rescue_date   DATE         NOT NULL,
  status_id     BIGINT       NOT NULL,
  type_id       BIGINT       NOT NULL,
  image_id      BIGINT       NULL,
  CONSTRAINT animal_pk PRIMARY KEY (id),

  CONSTRAINT uk_animal_image_id UNIQUE (image_id),
  CONSTRAINT fk_animal_status FOREIGN KEY (status_id) REFERENCES animal_status (id),
  CONSTRAINT fk_animal_type FOREIGN KEY (type_id) REFERENCES animal_type (id),
  CONSTRAINT fk_animal_image FOREIGN KEY (image_id) REFERENCES image (id)
);
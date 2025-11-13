CREATE TABLE donation_item (
  id            BIGSERIAL NOT NULL,
  quantity      INTEGER   NOT NULL,
  donation_id   BIGINT    NOT NULL,
  CONSTRAINT donation_item_pk PRIMARY KEY (id),
  CONSTRAINT fk_donation_item_donation FOREIGN KEY (donation_id) REFERENCES donation (id)
);

CREATE TABLE public.monetary_donation (
  id            BIGSERIAL      NOT NULL,
  amount        DECIMAL(10, 2) NOT NULL,
  donation_id   BIGINT         NOT NULL,
  CONSTRAINT monetary_donation_pk PRIMARY KEY (id),
  CONSTRAINT fk_monetary_donation_donation FOREIGN KEY (donation_id) REFERENCES donation (id)
);
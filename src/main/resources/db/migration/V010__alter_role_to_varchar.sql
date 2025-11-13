ALTER TABLE "role" ALTER COLUMN name TYPE VARCHAR(25) USING (name::text);

DROP TYPE role_enum;
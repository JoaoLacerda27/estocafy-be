CREATE EXTENSION IF NOT EXISTS "pgcrypto";
-- Insert roles
INSERT INTO roles (id, name)
VALUES
    (gen_random_uuid(), 'ADMIN'),
    (gen_random_uuid(), 'USER');

-- Insert plans
INSERT INTO plans (id, type, ativo)
VALUES
    (gen_random_uuid(), 'FREE', TRUE),
    (gen_random_uuid(), 'PREMIUM', TRUE);

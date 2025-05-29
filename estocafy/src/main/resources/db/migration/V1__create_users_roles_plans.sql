-- Create roles table
CREATE TABLE roles (
                       id UUID PRIMARY KEY,
                       name VARCHAR(50) NOT NULL UNIQUE,
                       CONSTRAINT UC_ROLE__NAME UNIQUE (name)
);

-- Create plans table
CREATE TABLE plans (
                       id UUID PRIMARY KEY,
                       type VARCHAR(50) NOT NULL UNIQUE,
                       ativo BOOLEAN NOT NULL,
                       CONSTRAINT UC_PLAN__TYPE UNIQUE (type)
);

-- Create users table
CREATE TABLE users (
                       id UUID PRIMARY KEY,
                       created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                       name VARCHAR(120) NOT NULL,
                       email VARCHAR(120) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       phone VARCHAR(20),
                       plan_id UUID,
                       CONSTRAINT UC_USER__EMAIL UNIQUE (email),
                       CONSTRAINT FK_USER__PLAN_ID FOREIGN KEY (plan_id) REFERENCES plans(id)
);

-- Create user_roles join table
CREATE TABLE user_roles (
                            user_id UUID NOT NULL,
                            role_id UUID NOT NULL,
                            PRIMARY KEY (user_id, role_id),
                            CONSTRAINT FK_USER_ROLES__USER_ID FOREIGN KEY (user_id) REFERENCES users(id),
                            CONSTRAINT FK_USER_ROLES__ROLE_ID FOREIGN KEY (role_id) REFERENCES roles(id)
);

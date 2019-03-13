CREATE TABLE IF NOT EXISTS users (
    id                SERIAL          PRIMARY KEY,
    login              VARCHAR(100)    NOT NULL,
    first_name              VARCHAR(100)    NOT NULL,
    last_name              VARCHAR(100)    NOT NULL,
    password_hash      VARCHAR(255)    NOT NULL,
    role              VARCHAR(100)    NOT NULL,
    UNIQUE(login)
)


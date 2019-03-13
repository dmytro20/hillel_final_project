CREATE TABLE IF NOT EXISTS orders (
    id                SERIAL          PRIMARY KEY,
    status        VARCHAR(100)    NOT NULL,
    date         VARCHAR(100)    NOT NULL
);


ALTER TABLE orders ADD COLUMN id_tour  INTEGER          REFERENCES tours(id);
ALTER TABLE orders ADD COLUMN id_user   INTEGER          REFERENCES users(id);
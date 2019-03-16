CREATE TABLE IF NOT EXISTS tours (
  id                 SERIAL          PRIMARY KEY,
  name         VARCHAR(100)    NOT NULL,
  country          VARCHAR(100),
  status           VARCHAR(100),
  type         VARCHAR(100),
  rating         VARCHAR(100),
  comment            VARCHAR(1000)
);




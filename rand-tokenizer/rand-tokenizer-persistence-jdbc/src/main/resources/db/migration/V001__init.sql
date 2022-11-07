
CREATE TABLE token (
    token_id   BIGSERIAL PRIMARY key,
    token_name VARCHAR NOT NULL,
    ts_insert  TIMESTAMP WITHOUT TIME zone DEFAULT now()
);

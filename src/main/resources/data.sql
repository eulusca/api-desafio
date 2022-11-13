CREATE TABLE IF NOT EXISTS app_client
(
    id SERIAL,
    name TEXT NOT NULL,
    mail TEXT NOT NULL,
    phone TEXT NOT NULL,
    createat TEXT NULL,
    updateat TEXT NULL
);

INSERT INTO app_client(id, name, mail, phone, createat) VALUES
(1,'JHON','mail@mail.com','21977778888','10-01-2000'),
(2,'ANON','mail@mail.com','21977778888','10-01-2000'),
(3,'BRO','mail@mail.com','21977778888','10-01-2000'),
(4,'SAFE','mail@mail.com','21977778888','10-01-2000'),
(5,'URI','mail@mail.com','21977778888','10-01-2000'),
(6,'AGO','mail@mail.com','21977778888','10-01-2000'),
(7,'FRA','mail@mail.com','21977778888','10-01-2000'),
(8,'ZANON','mail@mail.com','21977778888','10-01-2000')
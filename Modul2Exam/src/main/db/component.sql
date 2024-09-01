DROP SCHEMA IF EXISTS components;
CREATE SCHEMA components DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE components;

CREATE TABLE producers (
    id INT AUTO_INCREMENT, 
    name VARCHAR(50) NOT NULL, 
    location VARCHAR(50) NOT NULL, 
    PRIMARY KEY(id)
);

CREATE TABLE components (
    id BIGINT AUTO_INCREMENT, 
    producerId INT NOT NULL, 
    model VARCHAR(50) NOT NULL, 
    availabilityDate DATE NOT NULL, 
    price DECIMAL(10, 2), 
    available BOOLEAN NOT NULL DEFAULT false, 
    image VARCHAR(60), 
    PRIMARY KEY(id), 
    FOREIGN KEY(producerId) REFERENCES producers(id)
    ON DELETE RESTRICT
);

INSERT INTO producers (name, location) VALUES 
    ('AMD', 'United States (US)'),
    ('Samsung', 'South Korea (KR)'),
    ('Gigabyte', 'Taiwan (TW)'),
    ('Kingston', 'United States (US)');

INSERT INTO components (producerId, model, availabilityDate, price, available, image) VALUES 
    (1, 'Ryzen 9 3950X', '2019-09-25', 130000, true, 'AMD Ryzen 9 3950X.jpg'),
    (3, 'B450 Aorus M', '2018-07-25', 13000, false, 'Gigabyte B450 Aorus M.jpg'),
    (2, 'SSD 970 EVO PLUS 500GB', '2019-02-01', 18000, true, 'Samsung 970 EVO Plus.png'),
    (3, 'GeForce RTX 2080 SUPER OC 8G', '2019-07-23', 115000, true, 'Gigabyte GeForce RTX 2080 Super OC.png'),
    (4, 'HyperX Predator 16GB Kit 3200MHz', '2018-08-20', 13000, true, 'Kingston DDR4 HyperX Predator.jpeg'),
    (2, 'C24FG73', '2017-04-27', 20000, false, 'Samsung C24FG73.jpg');

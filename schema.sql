-- =========================================
-- CREACIÓN DE ESQUEMA BASE DE DATOS
-- Proyecto: Unidos por los Animales
-- Base de datos: H2
-- =========================================

-- La base de datos es generada automáticamente
-- mediante H2 embebida y Spring Boot

-- =========================================
-- TABLA USERS
-- =========================================

CREATE TABLE users (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    username VARCHAR(100) NOT NULL UNIQUE,

    email VARCHAR(150) NOT NULL UNIQUE,

    password VARCHAR(255) NOT NULL
);


-- =========================================
-- TABLA PET
-- =========================================

CREATE TABLE pet (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(100) NOT NULL,

    type VARCHAR(50) NOT NULL,

    age INT NOT NULL,

    description VARCHAR(255),

    available BOOLEAN NOT NULL
);


-- =========================================
-- TABLA ADOPTION_REQUEST
-- =========================================

CREATE TABLE adoption_request (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    adopter_name VARCHAR(100) NOT NULL,

    adopter_email VARCHAR(150) NOT NULL,

    message VARCHAR(500),

    pet_id BIGINT NOT NULL,

    CONSTRAINT fk_pet
        FOREIGN KEY (pet_id)
        REFERENCES pet(id)
);


-- =========================================
-- DATOS INICIALES USERS
-- =========================================

INSERT INTO users (username, email, password)
VALUES
('admin', 'admin@duoc.cl', '1234');


-- =========================================
-- DATOS INICIALES PETS
-- =========================================

INSERT INTO pet (name, type, age, description, available)
VALUES
('Firulais', 'Perro', 3, 'Muy amigable', TRUE),

('Mishi', 'Gato', 2, 'Tranquilo y cariñoso', TRUE),

('Luna', 'Perro', 1, 'Juguetona y sociable', TRUE),

('Tom', 'Gato', 4, 'Le gusta dormir', TRUE),

('Rocky', 'Perro', 5, 'Protector y tranquilo', FALSE);
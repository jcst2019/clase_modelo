CREATE DATABASE bdEscuela;

USE bdEscuela;

drop table if exists alumnos;

CREATE TABLE alumnos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(15)
);

INSERT INTO alumnos (nombre, edad, direccion, telefono) VALUES
('Juan Solar', 20, 'Av. Los Jardines 123', '987654321'),
('Ana Torres', 22, 'Calle Las Flores 456', '987654322'),
('Luis Savedra', 19, 'Jr. Los Álamos 789', '987654323');

DELIMITER //

DROP PROCEDURE IF EXISTS sp_ObtenerAlumnos//

CREATE PROCEDURE sp_ObtenerAlumnos()
BEGIN
    SELECT * FROM alumnos;
END //

DROP PROCEDURE IF EXISTS sp_AgregarAlumno//

CREATE PROCEDURE sp_AgregarAlumno(
    IN p_nombre VARCHAR(100),
    IN p_edad INT,
    IN p_direccion VARCHAR(255),
    IN p_telefono VARCHAR(15)
)
BEGIN
    INSERT INTO alumnos (nombre, edad, direccion, telefono) VALUES (p_nombre, p_edad, p_direccion, p_telefono);
END //

CREATE PROCEDURE ActualizarEstudiante(
    IN id INT,
    IN nombre VARCHAR(100),
    IN edad INT,
    IN direccion VARCHAR(255),
    IN telefono VARCHAR(15)
)
BEGIN
    UPDATE alumnos SET nombre = nombre, edad = edad, direccion = direccion, telefono = telefono WHERE id = id;
END //

DROP PROCEDURE IF EXISTS sp_ActualizarAlumno//

CREATE  PROCEDURE sp_ActualizarAlumno(
    IN p_id INT,
    IN p_nombre VARCHAR(100),
    IN p_edad INT,
    IN p_direccion VARCHAR(255),
    IN p_telefono VARCHAR(15)
)
BEGIN
    UPDATE alumnos 
    SET 
        nombre = p_nombre, 
        edad = p_edad, 
        direccion = p_direccion, 
        telefono = p_telefono
    WHERE id = p_id;
END //


DROP PROCEDURE IF EXISTS sp_EliminarAlumno//

CREATE PROCEDURE sp_EliminarAlumno(IN p_id INT)
BEGIN
    DELETE FROM alumnos WHERE id = p_id;
END //

DELIMITER ;

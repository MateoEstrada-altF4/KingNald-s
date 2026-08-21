-- =========================================
-- CREAR BASE DE DATOS
-- =========================================

CREATE DATABASE IF NOT EXISTS kingnalds;
USE kingnalds;


-- =========================================
-- TABLA: ROL
-- =========================================

CREATE TABLE Rol (
    idrol INT AUTO_INCREMENT PRIMARY KEY,
    nombreRol VARCHAR(50) NOT NULL UNIQUE
);


-- =========================================
-- INSERTAR ROLES
-- =========================================

INSERT INTO Rol (nombreRol) VALUES
('Administrador'),
('Usuario');


-- =========================================
-- TABLA: USUARIO
-- =========================================

CREATE TABLE Usuario (
    idusuario INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(200),
    fecha DATE,
    idrol INT NOT NULL,

    CONSTRAINT fk_usuario_rol
        FOREIGN KEY (idrol)
        REFERENCES Rol(idrol)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);


-- =========================================
-- USUARIOS DE EJEMPLO
-- =========================================

INSERT INTO Usuario
(usuario, contrasena, nombre, telefono, direccion, fecha, idrol)
VALUES
('admin', 'admin123', 'Administrador', '5555555555', 'Oficina principal', CURDATE(), 1),
('usuario1', 'usuario123', 'Usuario Normal', '5555555556', 'Direccion 1', CURDATE(), 2);


-- =========================================
-- TABLA: CATEGORIA
-- =========================================

CREATE TABLE Categoria (
    idcategoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255)
);


-- =========================================
-- TABLA: PRODUCTO
-- =========================================

CREATE TABLE Producto (
    idproducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    idcategoria INT NOT NULL,

    CONSTRAINT fk_producto_categoria
        FOREIGN KEY (idcategoria)
        REFERENCES Categoria(idcategoria)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);


-- =========================================
-- TABLA: VENTA
-- =========================================

CREATE TABLE Venta (
    idventa INT AUTO_INCREMENT PRIMARY KEY,
    fecha_venta DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    metodo_pago VARCHAR(50) NOT NULL,
    estado VARCHAR(30) NOT NULL,
    idusuario INT NOT NULL,

    CONSTRAINT fk_venta_usuario
        FOREIGN KEY (idusuario)
        REFERENCES Usuario(idusuario)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);


-- =========================================
-- TABLA: DETALLE_VENTA
-- =========================================

CREATE TABLE Detalle_Venta (
    iddetalle INT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    idventa INT NOT NULL,
    idproducto INT NOT NULL,

    CONSTRAINT fk_detalle_venta
        FOREIGN KEY (idventa)
        REFERENCES Venta(idventa)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    CONSTRAINT fk_detalle_producto
        FOREIGN KEY (idproducto)
        REFERENCES Producto(idproducto)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

SELECT * FROM Usuario;
DESCRIBE Usuario;
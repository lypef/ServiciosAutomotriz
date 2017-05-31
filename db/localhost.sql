-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 31-05-2017 a las 07:56:12
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `autoserv`
--
CREATE DATABASE IF NOT EXISTS `autoserv` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `autoserv`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clients`
--

CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `nombre` varchar(254) NOT NULL,
  `direccion` varchar(254) NOT NULL,
  `telefono` varchar(254) NOT NULL,
  `rfc` varchar(254) NOT NULL,
  `mail` varchar(254) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clients`
--

INSERT INTO `clients` (`id`, `nombre`, `direccion`, `telefono`, `rfc`, `mail`) VALUES
(4, 'ALFREDO', '20 DE NOVIEMBRE 306', '9231200505', 'AEDF9201245G3', 'CONTACTO@CYBERCHOAPAS.COM'),
(7, 'DOÑA CLEOTILDE', 'DIRECCION', '018001232222', 'RFC', 'EMAIL'),
(16, 'RAMON VALDEZ', 'AAAA', 'AAA', 'AAAAAAAAAAA', 'AA'),
(17, 'CLIENTE SIN NOMBRE', 'AAAAAA', 'AAAAAAAAAA', 'AAAAAAAA', 'AAAAAAA'),
(18, 'ALBERTO GOMES BOLAÑOS', 'AAAAAAAAA', 'AAAA', 'AAAAAAAAAA', 'AAAAAAAAAA'),
(19, 'FLORINDA MESA', 'DIRECCION', 'H', 'RFC', 'HJ'),
(20, 'NARCIZO RAYO', ' NUEVA DIRECCION ', 'TELEFONO', 'RFC NUEV', 'CORREO ELECTRONICO'),
(21, 'FRANCISCO EDUARDO ASCENCIO GARCIA', 'DIRECCION', 'TELEFONOS', 'AEGF17105G4', 'CORRE@AA.COM'),
(22, 'SORIBEL ASCENCIO GARCIA', 'NO SABEMOS ', '222', 'SORIANACUESTAMENOS', 'OJOIJ@HOTMAI.COM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos`
--

CREATE TABLE `datos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(254) NOT NULL,
  `direccion` varchar(254) NOT NULL,
  `rfc` varchar(254) NOT NULL,
  `telefono` varchar(254) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `datos`
--

INSERT INTO `datos` (`id`, `nombre`, `direccion`, `rfc`, `telefono`) VALUES
(1, 'nombre fisico', 'direccion fisica', 'rfc fisico', 'telefono fisico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisos`
--

CREATE TABLE `permisos` (
  `id_user` int(12) NOT NULL,
  `clientes` tinyint(1) NOT NULL,
  `clientes_agregar` tinyint(1) NOT NULL,
  `clientes_editar` tinyint(1) NOT NULL,
  `clientes_eliminar` tinyint(1) NOT NULL,
  `vehiculos` tinyint(1) NOT NULL,
  `vehiculos_agregar` tinyint(1) NOT NULL,
  `vehiculos_editar` tinyint(1) NOT NULL,
  `vehiculos_eliminar` tinyint(1) NOT NULL,
  `provedores` tinyint(1) NOT NULL,
  `provedores_agregar` tinyint(1) NOT NULL,
  `provedores_editar` tinyint(1) NOT NULL,
  `provedores_eliminar` tinyint(1) NOT NULL,
  `stock` tinyint(1) NOT NULL,
  `stock_agregar` tinyint(1) NOT NULL,
  `stock_editar` tinyint(1) NOT NULL,
  `stock_eliminar` tinyint(1) NOT NULL,
  `inventario` tinyint(1) NOT NULL,
  `users` tinyint(1) NOT NULL,
  `user_add` tinyint(1) NOT NULL,
  `user_update` tinyint(1) NOT NULL,
  `user_delete` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `permisos`
--

INSERT INTO `permisos` (`id_user`, `clientes`, `clientes_agregar`, `clientes_editar`, `clientes_eliminar`, `vehiculos`, `vehiculos_agregar`, `vehiculos_editar`, `vehiculos_eliminar`, `provedores`, `provedores_agregar`, `provedores_editar`, `provedores_eliminar`, `stock`, `stock_agregar`, `stock_editar`, `stock_eliminar`, `inventario`, `users`, `user_add`, `user_update`, `user_delete`) VALUES
(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `codebar` varchar(254) NOT NULL,
  `nombre` varchar(254) NOT NULL,
  `descripcion` varchar(254) NOT NULL,
  `precio` double NOT NULL,
  `existencia` int(11) NOT NULL,
  `vendidos` int(11) NOT NULL,
  `id_provedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`codebar`, `nombre`, `descripcion`, `precio`, `existencia`, `vendidos`, `id_provedor`) VALUES
('AAAA', 'AAAA', 'AAA', 14144, 4, 0, 1),
('AAAS', 'AA', 'AAA', 1, 1, 0, 3),
('AEDF', 'CCCC', 'DDDD', 10, 100, 0, 3),
('DDD', 'DD', 'DDD', 1, 1, 0, 3),
('DDDD', 'DDDD', 'DDD', 1111, 5, 0, 2),
('DQWWWD', 'WDWDWD', 'DWW', 5555, 5555, 0, 2),
('DWDW', '5', '55', 5, 5, 4, 1),
('DWWDW', 'DWDWDW', 'DW', 2, 2, 0, 2),
('SQSQQ', 'QSQSQ', 'SQSQ', 10, 10, 0, 2),
('WDWDWDW', '56565', '6565656', 565656, 65656, 0, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provedores`
--

CREATE TABLE `provedores` (
  `id` int(11) NOT NULL,
  `empresa` varchar(254) NOT NULL,
  `direccion` varchar(254) NOT NULL,
  `telefono_empresa` varchar(254) NOT NULL,
  `responsable` varchar(254) NOT NULL,
  `mail` varchar(254) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `provedores`
--

INSERT INTO `provedores` (`id`, `empresa`, `direccion`, `telefono_empresa`, `responsable`, `mail`) VALUES
(1, 'FORD', 'DIRECCION FICTICIA', '018001232222', 'JAIMITO', '92355545'),
(5, 'SSSS', 'GHJGHJGHJG', 'HJGHJGHJGHJGHJGHJ', 'GJGJHGHJGHJGJ', 'MAIL NUEVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(254) NOT NULL,
  `password` varchar(254) NOT NULL,
  `nombre` varchar(254) NOT NULL,
  `direccion` varchar(254) NOT NULL,
  `telefono` varchar(254) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `nombre`, `direccion`, `telefono`) VALUES
(1, 'ROOT', 'root', 'lypef', 'DIRECCION', '9231200505'),
(3, 'ADMIN', 'admin', 'ADMINISTRADOR', 'DIRECCION', '00000'),
(4, 'USERNAME', 'username', 'MI NOMBRE ES MIO', 'DIRECCION FICTICIA', '9231200505');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `placas` varchar(254) NOT NULL,
  `color` varchar(254) NOT NULL,
  `departamento` varchar(254) NOT NULL,
  `mtp` varchar(254) NOT NULL,
  `kilometros` double NOT NULL,
  `id_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vehiculos`
--

INSERT INTO `vehiculos` (`placas`, `color`, `departamento`, `mtp`, `kilometros`, `id_client`) VALUES
('AAAAA', 'AAAAA', 'NO SE ', 'FORD F150', 150000, 22),
('AEDF', 'AAAAA', 'AAA', 'AAAA', 123, 17),
('AXEDF-A55', 'VERDE', 'SONIDO', 'MICOOPER, EPORTIVO MODELO 99', 158999, 20),
('Y99T-65', 'ROJO VINO', 'AFINACION', 'CAMIONETA NISSAN NP300, MOD-2014', 189000, 21);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `datos`
--
ALTER TABLE `datos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD PRIMARY KEY (`id_user`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`codebar`);

--
-- Indices de la tabla `provedores`
--
ALTER TABLE `provedores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`placas`),
  ADD KEY `client` (`id_client`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT de la tabla `datos`
--
ALTER TABLE `datos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `provedores`
--
ALTER TABLE `provedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD CONSTRAINT `user_permiso` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD CONSTRAINT `client` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

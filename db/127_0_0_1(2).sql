-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-11-2019 a las 23:44:52
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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
(1, 'NUEVO CLIENTE NUMERO 1', '', '', '', ''),
(2, 'AURELIO', '', '', '', ''),
(3, 'LAUREANO', '', '', '', '');

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
(1, 'FLETES LEMARGO', 'AV. DIAZ MIRON', 'AGRS945128F53', '018001232222');

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
  `user_delete` tinyint(1) NOT NULL,
  `update_dates` tinyint(1) NOT NULL,
  `service_edit` tinyint(1) NOT NULL,
  `servcice_delete` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `permisos`
--

INSERT INTO `permisos` (`id_user`, `clientes`, `clientes_agregar`, `clientes_editar`, `clientes_eliminar`, `vehiculos`, `vehiculos_agregar`, `vehiculos_editar`, `vehiculos_eliminar`, `provedores`, `provedores_agregar`, `provedores_editar`, `provedores_eliminar`, `stock`, `stock_agregar`, `stock_editar`, `stock_eliminar`, `inventario`, `users`, `user_add`, `user_update`, `user_delete`, `update_dates`, `service_edit`, `servcice_delete`) VALUES
(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

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
('CC', 'REMPLAZO DE CLUTH', 'SERVICIO DE REEMPLAZO DE CLUTH', 500, 999980, 20, 1),
('RVM', 'REACTIVADO DE VOLANTE MATRIZ', 'SE REACTIVA VOLANTE MATRIZ', 900, 999976, 24, 1);

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
-- Estructura de tabla para la tabla `services`
--

CREATE TABLE `services` (
  `id` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_vehiculo` varchar(254) NOT NULL,
  `s_solicitado` varchar(254) NOT NULL,
  `s_realizado` varchar(254) NOT NULL,
  `productos` varchar(254) NOT NULL,
  `total` double NOT NULL,
  `p_urgente` tinyint(1) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `services`
--

INSERT INTO `services` (`id`, `id_cliente`, `id_vehiculo`, `s_solicitado`, `s_realizado`, `productos`, `total`, `p_urgente`, `fecha`) VALUES
(1, 1, 'KLNLKJNJHJKNKJNJ', 'GBFDGBRFDBFDRBDRFBR', 'GBFDGBRFDBFDRBDRFBR', 'RVM,CC,', 1400, 0, '2019-11-26 15:15:33'),
(2, 2, 'AAAA', '', '', 'RVM,', 900, 0, '2019-11-26 15:20:29'),
(3, 3, 'EWQFDEWD', '', '', 'RVM,', 1800, 1, '2019-11-26 15:20:39'),
(4, 1, 'KLNLKJNJHJKNKJNJ', '', '', 'RVM,', 2700, 1, '2019-11-26 15:20:46');

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
(1, 'ROOT', 'root', 'ROOT', 'DIRECCION', '9231200505');

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
('AAAA', 'ROJHO', 'AAA', 'AAA', 222, 2),
('EWQFDEWD', '3WQDQDQWWQ', 'QWDQWD', 'DWQDWQD', 2222, 3),
('KLNLKJNJHJKNKJNJ', 'JKNBJKNJKNJKNJK', 'NJKNJKNJKNKJN', 'JKNJKNJKNJKNJKN', 15151, 1);

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
  ADD PRIMARY KEY (`codebar`),
  ADD KEY `provedor` (`id_provedor`);

--
-- Indices de la tabla `provedores`
--
ALTER TABLE `provedores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente` (`id_cliente`),
  ADD KEY `vehiculos` (`id_vehiculo`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
-- AUTO_INCREMENT de la tabla `services`
--
ALTER TABLE `services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `permisos`
--
ALTER TABLE `permisos`
  ADD CONSTRAINT `user_permiso` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `provedor` FOREIGN KEY (`id_provedor`) REFERENCES `provedores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `services`
--
ALTER TABLE `services`
  ADD CONSTRAINT `cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clients` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vehiculos` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculos` (`placas`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD CONSTRAINT `client` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

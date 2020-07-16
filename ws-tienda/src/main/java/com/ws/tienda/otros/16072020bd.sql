-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.27-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para bp_prueba_tecnica
CREATE DATABASE IF NOT EXISTS `bp_prueba_tecnica` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bp_prueba_tecnica`;

-- Volcando estructura para tabla bp_prueba_tecnica.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(150) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bp_prueba_tecnica.cliente: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`id_cliente`, `nombres`, `apellidos`) VALUES
	(1, 'MARIA JOSE', 'PEREZ MENENDEZ'),
	(2, 'MIRNA MAGDALENA', 'SANCHEZ VASQUEZ'),
	(3, 'CARLOS ALBERTO', 'CASTILLO'),
	(5, 'MARIO ANTONIO', 'ROSALEZ');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla bp_prueba_tecnica.orden
CREATE TABLE IF NOT EXISTS `orden` (
  `id_orden` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `cantidad` decimal(10,2) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id_orden`),
  KEY `FK_orden_producto` (`id_producto`),
  KEY `FK_orden_cliente` (`id_cliente`),
  CONSTRAINT `FK_orden_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `FK_orden_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bp_prueba_tecnica.orden: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `orden` DISABLE KEYS */;
INSERT INTO `orden` (`id_orden`, `id_producto`, `id_cliente`, `cantidad`, `fecha`) VALUES
	(1, 1, 3, 4.00, '2020-07-16 01:18:21');
/*!40000 ALTER TABLE `orden` ENABLE KEYS */;

-- Volcando estructura para tabla bp_prueba_tecnica.producto
CREATE TABLE IF NOT EXISTS `producto` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bp_prueba_tecnica.producto: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`id_producto`, `nombre`, `descripcion`, `precio`) VALUES
	(1, 'HIERRO NEGRO', 'LIBRA DE HIERRO NEGO', 0.50),
	(2, 'ALUMINIO', 'ALUMINIO ORIGINAL', 1.00);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

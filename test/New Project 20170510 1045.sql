-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.11


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema secure
--

CREATE DATABASE IF NOT EXISTS secure;
USE secure;

--
-- Definition of table `actual`
--

DROP TABLE IF EXISTS `actual`;
CREATE TABLE `actual` (
  `node` decimal(10,0) NOT NULL,
  `xpos` decimal(10,0) NOT NULL,
  `yos` decimal(10,0) NOT NULL,
  `dx` decimal(10,0) NOT NULL,
  `dy` decimal(10,0) NOT NULL,
  `distance` decimal(10,0) NOT NULL,
  `route` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `actual`
--

/*!40000 ALTER TABLE `actual` DISABLE KEYS */;
/*!40000 ALTER TABLE `actual` ENABLE KEYS */;


--
-- Definition of table `basestation`
--

DROP TABLE IF EXISTS `basestation`;
CREATE TABLE `basestation` (
  `name` text NOT NULL,
  `accesskey` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `basestation`
--

/*!40000 ALTER TABLE `basestation` DISABLE KEYS */;
/*!40000 ALTER TABLE `basestation` ENABLE KEYS */;


--
-- Definition of table `calculate`
--

DROP TABLE IF EXISTS `calculate`;
CREATE TABLE `calculate` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dx` decimal(10,0) NOT NULL,
  `dy` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `calculate`
--

/*!40000 ALTER TABLE `calculate` DISABLE KEYS */;
/*!40000 ALTER TABLE `calculate` ENABLE KEYS */;


--
-- Definition of table `graph`
--

DROP TABLE IF EXISTS `graph`;
CREATE TABLE `graph` (
  `sequenceid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` text NOT NULL,
  `work` decimal(10,0) NOT NULL,
  `protection` text NOT NULL,
  PRIMARY KEY (`sequenceid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `graph`
--

/*!40000 ALTER TABLE `graph` DISABLE KEYS */;
/*!40000 ALTER TABLE `graph` ENABLE KEYS */;


--
-- Definition of table `history`
--

DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `transaction` int(10) unsigned NOT NULL,
  `network` text NOT NULL,
  `algorithm` text NOT NULL,
  `work` text NOT NULL,
  `protection` text NOT NULL,
  `singleline` decimal(10,0) NOT NULL,
  `multipleline` decimal(10,0) NOT NULL,
  `duration` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `history`
--

/*!40000 ALTER TABLE `history` DISABLE KEYS */;
/*!40000 ALTER TABLE `history` ENABLE KEYS */;


--
-- Definition of table `net1`
--

DROP TABLE IF EXISTS `net1`;
CREATE TABLE `net1` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `node` decimal(10,0) NOT NULL,
  `xpos` decimal(10,0) NOT NULL,
  `ypos` decimal(10,0) NOT NULL,
  `capacity` decimal(10,0) NOT NULL,
  `accesskey` decimal(10,0) NOT NULL,
  `status` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `net1`
--

/*!40000 ALTER TABLE `net1` DISABLE KEYS */;
/*!40000 ALTER TABLE `net1` ENABLE KEYS */;


--
-- Definition of table `net2`
--

DROP TABLE IF EXISTS `net2`;
CREATE TABLE `net2` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `node` decimal(10,0) NOT NULL,
  `xpos` decimal(10,0) NOT NULL,
  `ypos` decimal(10,0) NOT NULL,
  `capacity` decimal(10,0) NOT NULL,
  `accesskey` decimal(10,0) NOT NULL,
  `status` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `net2`
--

/*!40000 ALTER TABLE `net2` DISABLE KEYS */;
/*!40000 ALTER TABLE `net2` ENABLE KEYS */;


--
-- Definition of table `net3`
--

DROP TABLE IF EXISTS `net3`;
CREATE TABLE `net3` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `node` decimal(10,0) NOT NULL,
  `xpos` decimal(10,0) NOT NULL,
  `ypos` decimal(10,0) NOT NULL,
  `capacity` decimal(10,0) NOT NULL,
  `accesskey` decimal(10,0) NOT NULL,
  `status` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `net3`
--

/*!40000 ALTER TABLE `net3` DISABLE KEYS */;
/*!40000 ALTER TABLE `net3` ENABLE KEYS */;


--
-- Definition of table `net4`
--

DROP TABLE IF EXISTS `net4`;
CREATE TABLE `net4` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `node` decimal(10,0) NOT NULL,
  `xpos` decimal(10,0) NOT NULL,
  `ypos` decimal(10,0) NOT NULL,
  `capacity` decimal(10,0) NOT NULL,
  `accesskey` decimal(10,0) NOT NULL,
  `status` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `net4`
--

/*!40000 ALTER TABLE `net4` DISABLE KEYS */;
/*!40000 ALTER TABLE `net4` ENABLE KEYS */;


--
-- Definition of table `nodelog`
--

DROP TABLE IF EXISTS `nodelog`;
CREATE TABLE `nodelog` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nodename` text NOT NULL,
  `xpos` decimal(10,0) NOT NULL,
  `ypos` decimal(10,0) NOT NULL,
  `power` decimal(10,0) NOT NULL,
  `node` decimal(10,0) NOT NULL,
  `cluster` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nodelog`
--

/*!40000 ALTER TABLE `nodelog` DISABLE KEYS */;
INSERT INTO `nodelog` (`id`,`nodename`,`xpos`,`ypos`,`power`,`node`,`cluster`) VALUES 
 (1,'1','457','343','8','1','Cluster0'),
 (2,'2','533','248','27','2','Cluster0'),
 (3,'3','724','245','65','3','Cluster1'),
 (4,'4','884','361','55','4','Cluster1'),
 (5,'5','948','544','34','5','Cluster2');
/*!40000 ALTER TABLE `nodelog` ENABLE KEYS */;


--
-- Definition of table `process`
--

DROP TABLE IF EXISTS `process`;
CREATE TABLE `process` (
  `cluster` text NOT NULL,
  `process` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `process`
--

/*!40000 ALTER TABLE `process` DISABLE KEYS */;
INSERT INTO `process` (`cluster`,`process`) VALUES 
 ('','2 is sending Message to 4'),
 ('Cluster0',' Message send successfully from 2 to 4 between different cluster'),
 ('Cluster1','4 Received Message Successfully from 2');
/*!40000 ALTER TABLE `process` ENABLE KEYS */;


--
-- Definition of table `route`
--

DROP TABLE IF EXISTS `route`;
CREATE TABLE `route` (
  `route` decimal(10,0) NOT NULL,
  `energy` decimal(10,0) NOT NULL,
  `status` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `route`
--

/*!40000 ALTER TABLE `route` DISABLE KEYS */;
/*!40000 ALTER TABLE `route` ENABLE KEYS */;


--
-- Definition of table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `test` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

/*!40000 ALTER TABLE `test` DISABLE KEYS */;
/*!40000 ALTER TABLE `test` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

-- phpMyAdmin SQL Dump
-- version 3.1.3.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 25, 2015 at 11:45 PM
-- Server version: 5.1.33
-- PHP Version: 5.2.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `perpustakaan`
--
CREATE DATABASE `perpustakaan` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `perpustakaan`;

-- --------------------------------------------------------

--
-- Table structure for table `mst_anggota`
--

CREATE TABLE IF NOT EXISTS `mst_anggota` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `pekerjaan` varchar(50) NOT NULL,
  `umur` int(11) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mst_anggota`
--

INSERT INTO `mst_anggota` (`id`, `nama`, `alamat`, `pekerjaan`, `umur`, `password`) VALUES
(1, 'Anur Prayitno', 'Bububuu', 'Mimimimi', 12, '1234'),
(2, 'Irfan Rofie', 'Tasikmalaya', 'Manager Bank', 45, '00000');

-- --------------------------------------------------------

--
-- Table structure for table `mst_buku`
--

CREATE TABLE IF NOT EXISTS `mst_buku` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `judul` varchar(50) NOT NULL,
  `penulis` varchar(50) NOT NULL,
  `jumlah` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `mst_buku`
--

INSERT INTO `mst_buku` (`id`, `judul`, `penulis`, `jumlah`) VALUES
(1, 'Membelah Langit', 'Chairil Yasin', 3),
(3, 'Laskar Pelangi', 'Andrea Hirata', 1),
(2, 'Sang Pemimpi', 'Andrea Hinata', 2);

-- --------------------------------------------------------

--
-- Table structure for table `mst_user`
--

CREATE TABLE IF NOT EXISTS `mst_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(30) NOT NULL,
  `pass` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Dumping data for table `mst_user`
--

INSERT INTO `mst_user` (`id`, `nama`, `pass`) VALUES
(1, 'admin', 'admin'),
(27, 'irfan', 'rofie'),
(3, 'user', 'user'),
(28, 'iii', 'iii'),
(26, 'kebo', 'unto'),
(24, 'jojo', 'jojo');

-- --------------------------------------------------------

--
-- Table structure for table `trx_pinjam`
--

CREATE TABLE IF NOT EXISTS `trx_pinjam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_anggota` int(11) NOT NULL,
  `id_buku` int(11) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_kembali` date DEFAULT NULL,
  `denda` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `trx_pinjam`
--

INSERT INTO `trx_pinjam` (`id`, `id_anggota`, `id_buku`, `tgl_pinjam`, `tgl_kembali`, `denda`) VALUES
(1, 1, 1, '2013-07-15', '2013-07-24', 1000),
(2, 2, 1, '2013-08-05', '2013-08-08', 0),
(3, 2, 1, '2013-08-03', '2013-08-04', 0),
(4, 1, 3, '2013-08-18', NULL, NULL),
(5, 1, 3, '2013-08-04', NULL, NULL),
(11, 1, 3, '2015-04-07', '2015-04-07', 0);

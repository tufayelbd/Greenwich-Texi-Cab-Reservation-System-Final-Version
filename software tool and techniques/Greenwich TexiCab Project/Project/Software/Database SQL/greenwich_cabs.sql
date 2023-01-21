-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2021 at 12:25 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `greenwich_cabs`
--

-- --------------------------------------------------------

--
-- Table structure for table `dispatchers`
--

CREATE TABLE `dispatchers` (
  `user_id` int(10) NOT NULL,
  `password` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `account` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dispatchers`
--

INSERT INTO `dispatchers` (`user_id`, `password`, `name`, `account`) VALUES
(1, 'Admin', 'Admin', 'Greenwich'),
(2, '1234', 'Tufayel', 'Greenwich'),
(3, '1234', 'Mike', 'Greenwich'),
(4, '1234', 'Chowdhury', 'Default');

-- --------------------------------------------------------

--
-- Table structure for table `earning_details`
--

CREATE TABLE `earning_details` (
  `id` int(10) NOT NULL,
  `driver_id` varchar(50) NOT NULL,
  `journey_date` varchar(50) NOT NULL,
  `fare_cost` varchar(50) NOT NULL,
  `additional_tips` varchar(50) NOT NULL,
  `job` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `earning_details`
--

INSERT INTO `earning_details` (`id`, `driver_id`, `journey_date`, `fare_cost`, `additional_tips`, `job`) VALUES
(13, '3', '2021-11-08', '80.0', '5.0', '2'),
(14, '7', '2021-11-08', '0.0', '0.0', '0.0'),
(15, '5', '2021-11-08', '120', '10', '1'),
(16, '4', '2021-11-10', '80', '5', '1'),
(17, '2', '2021-11-10', '0.0', '0.0', '0.0'),
(18, '1', '2021-11-14', '10', '10', '1'),
(19, '5', '2021-11-14', '12.0', '0.0', '0.0'),
(20, '2', '2021-11-14', '90', '0', '1'),
(21, '3', '2021-11-21', '60', '5', '1'),
(22, '1', '2021-11-21', '10', '0', '1'),
(23, '6', '2021-11-21', '10', '2', '1'),
(24, '1', '2021-11-24', '285.0', '12.0', '3'),
(25, '5', '2021-11-24', '275.0', '25.0', '3'),
(26, '10', '2021-11-24', '340.0', '30.0', '2'),
(27, '3', '2021-11-24', '256.0', '7.0', '4'),
(28, '6', '2021-11-24', '165.0', '4.0', '2'),
(29, '7', '2021-11-24', '150', '0', '1'),
(30, '9', '2021-11-24', '85', '0', '1'),
(31, '2', '2021-11-24', '120', '0', '1'),
(32, '4', '2021-11-24', '65', '10', '1'),
(33, '8', '2021-11-24', '160.0', '0.0', '2'),
(34, '3', '2021-12-16', '80', '5', '1');

-- --------------------------------------------------------

--
-- Table structure for table `temp_data`
--

CREATE TABLE `temp_data` (
  `id` int(10) NOT NULL,
  `driver_id` varchar(50) NOT NULL,
  `journey_date` varchar(30) NOT NULL,
  `pickup_point` varchar(100) NOT NULL,
  `destination_point` varchar(100) NOT NULL,
  `passenger_name` varchar(100) NOT NULL,
  `passenger_phone` varchar(100) NOT NULL,
  `fare_cost` varchar(10) NOT NULL,
  `additional_tips` varchar(10) NOT NULL,
  `account_name` varchar(100) NOT NULL,
  `journey_time` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `temp_data`
--

INSERT INTO `temp_data` (`id`, `driver_id`, `journey_date`, `pickup_point`, `destination_point`, `passenger_name`, `passenger_phone`, `fare_cost`, `additional_tips`, `account_name`, `journey_time`) VALUES
(35, '3', '2021-11-08', 'HA37', 'HA12', 'Prince', '08570474', '45', '0', 'Greenwich', '10:21:09 AM'),
(36, '3', '2021-11-08', 'AB45', 'AC23', 'Mr Tufayel', '097387387', '35', '5', 'Greenwich', '12:30'),
(38, '5', '2021-11-08', 'HA76', 'AB67', 'MR Prince', '098746588', '120', '10', 'Shirley', '01:52:25 PM'),
(39, '4', '2021-11-10', 'AB12', 'Bcs3', 'Tufayel', '0789064', '80', '5', 'Shirley', '4:00'),
(41, '1', '2021-11-14', 'Abc12D', 'abc12H', 'Rocky', '094658', '10', '10', 'Shirley', '12:49:27 PM'),
(43, '2', '2021-11-14', 'Ab2', 'BA2', 'prince', '0975757', '90', '0', 'Greenwich', '12:54:37 PM'),
(44, '3', '2021-11-21', 'Greenwich', 'Stanford ', 'Mr Chowdhury Tufayel', '09747584', '60', '5', 'Greenwich', '11:40:25 AM'),
(45, '1', '2021-11-21', 'greenwich', 'easthum', 'Mr Prince', '07489595', '10', '0', 'Greenwich', '3:03'),
(46, '6', '2021-11-21', 'Currty Shark', 'Stanmore', 'Mr Zaman', '0947574809', '10', '2', 'Greenwich', '12:00:46 PM'),
(47, '1', '2021-11-24', 'Ab13', 'BD34', 'Mr Prince', '0956478397', '90', '10', 'Shirley', '01:05:23 PM'),
(48, '1', '2021-11-24', 'Greenwich', 'Startford', 'Mr Zaman', '0674893', '100', '0', 'Greenwich', '01:06:30 PM'),
(49, '5', '2021-11-24', 'Startford', 'greenwich', 'Mike', '09735289', '120', '10', 'Default(NO Account )', '01:07:48 PM'),
(50, '10', '2021-11-24', 'Greenwich', 'London', 'Josh', '09863242', '90', '10', 'Greenwich', '01:09:00 PM'),
(51, '3', '2021-11-24', 'Ha34', 'Ha9', 'Hussy', '09523427', '30', '0', 'Beany', '01:09:47 PM'),
(52, '6', '2021-11-24', 'Whitechapel', 'Eastham', 'Rocky', '06374892', '100', '0', 'Shirley', '01:11:11 PM'),
(53, '3', '2021-11-24', 'Greenwich Campus ', 'Medway campus', 'Jonny', '09635287', '90', '5', 'Default(NO Account )', '3:20'),
(54, '5', '2021-11-24', 'Haq2', 'Ha90', 'Mr David ', '09753428', '65', '5', 'Default(NO Account )', '01:14:38 PM'),
(55, '3', '2021-11-24', 'Ab34', 'hq12', 'David', '0937836', '100', '0', 'Default(NO Account )', '01:16:30 PM'),
(56, '6', '2021-11-24', 'Abc', 'Abd3', 'Mr David', '09863245', '65', '4', 'Default(NO Account )', '01:18:13 PM'),
(57, '5', '2021-11-24', 'Abd3', 'Abd4', 'bdg', '9876', '90', '10', 'Default(NO Account )', '01:19:15 PM'),
(58, '3', '2021-11-24', 'ach3', 'at5', 'prince', '095637829', '36', '2', 'Default(NO Account )', '01:20:14 PM'),
(59, '1', '2021-11-24', 'Abcd', 'Efgh', 'Chowdhury Tufayel', '09673849', '95', '2', 'Default(NO Account )', '01:22:23 PM'),
(60, '7', '2021-11-24', 'Hw23', 'Ha12Ab', 'Mr Josh', '098635', '150', '0', 'Default(NO Account )', '01:25:32 PM'),
(61, '9', '2021-11-24', 'JA12', 'Greenwich Ha264', 'Abds', '0738945632', '85', '0', 'Beany', '01:26:35 PM'),
(62, '10', '2021-11-24', 'Greenwich university', 'London South bank University', 'Dr David', '09853672', '250', '20', 'Default(NO Account )', '01:27:51 PM'),
(63, '2', '2021-11-24', 'B29Ab', 'C29Ya', 'Prince', '0953629', '120', '0', 'Beany', '01:29:35 PM'),
(64, '4', '2021-11-24', 'Cd6RB', 'CE49E', 'Proby', '062739849', '65', '10', 'Default(NO Account )', '01:30:33 PM'),
(65, '8', '2021-11-24', 'PA4Wc', 'PD34E', 'Jack', '052367394', '75', '0', 'Default(NO Account )', '01:31:27 PM'),
(66, '8', '2021-11-24', 'AS28OP', 'AV4C2', 'Mr Rock', '9862436', '85', '0', 'Default(NO Account )', '01:32:37 PM'),
(67, '3', '2021-12-16', 'Greenwich', 'Tower Bridge', 'Mr Jack', '093735376', '80', '5', 'Greenwich', '10:42:06 AM');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dispatchers`
--
ALTER TABLE `dispatchers`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `earning_details`
--
ALTER TABLE `earning_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `temp_data`
--
ALTER TABLE `temp_data`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dispatchers`
--
ALTER TABLE `dispatchers`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `earning_details`
--
ALTER TABLE `earning_details`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `temp_data`
--
ALTER TABLE `temp_data`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

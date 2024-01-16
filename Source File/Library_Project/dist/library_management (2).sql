-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2023 at 09:43 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `ID` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ID`, `username`, `password`) VALUES
(1, 'Admin', 'admin@123');

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` int(12) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `book_name` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  `no_of_pages` varchar(255) NOT NULL,
  `edition` varchar(255) NOT NULL,
  `book_quantity` varchar(255) NOT NULL,
  `price` varchar(250) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `Id` int(11) NOT NULL,
  `Category` varchar(255) NOT NULL,
  `Status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `issue_book`
--

CREATE TABLE `issue_book` (
  `id` int(11) NOT NULL,
  `member_id` int(10) NOT NULL,
  `member_name` varchar(200) NOT NULL,
  `book_category` varchar(200) NOT NULL,
  `author_name` varchar(200) NOT NULL,
  `publisher_name` varchar(200) NOT NULL,
  `book_name` varchar(200) NOT NULL,
  `avaliable_quantity` int(10) NOT NULL,
  `Issue_date` date NOT NULL,
  `issue_quantity` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE `librarian` (
  `id` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Contact` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Date_of_Birth` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Experience` varchar(255) NOT NULL,
  `Document_type` varchar(255) NOT NULL,
  `Document_no` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `librarian`
--

INSERT INTO `librarian` (`id`, `Name`, `Username`, `Password`, `Contact`, `Email`, `Date_of_Birth`, `Address`, `Experience`, `Document_type`, `Document_no`) VALUES
(1, 'Raja', 'raja', 'raja@123', '7549361612', 'rajkumar896946@gmail.com', '10/10/2001', 'Araria', '1 Year', 'Addhar', '362279941395'),
(2, 'Shyam', 'shyam@123', 'shyan@12345', '75454564565', 'shyam123@gmail.com', '10/10/1995', 'araria	', '1 Year', 'Pan', 'JDKAPK6878p');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `ID` int(11) NOT NULL,
  `member_name` varchar(255) NOT NULL,
  `registration` varchar(255) NOT NULL,
  `session` varchar(255) NOT NULL,
  `course` varchar(255) NOT NULL,
  `contact` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `membership`
--

CREATE TABLE `membership` (
  `membership_id` int(11) NOT NULL,
  `member_id` int(10) NOT NULL,
  `member_name` varchar(255) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `plan` varchar(255) NOT NULL,
  `price` int(15) NOT NULL,
  `membership_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `expiry_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE `publisher` (
  `Id` int(11) NOT NULL,
  `publisher_name` varchar(255) NOT NULL,
  `p_address` varchar(255) NOT NULL,
  `p_phone` varchar(255) NOT NULL,
  `p_email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `return_book`
--

CREATE TABLE `return_book` (
  `Return_ID` int(11) NOT NULL,
  `Member_Id` int(10) NOT NULL,
  `member_name` int(11) NOT NULL,
  `Book_Category` varchar(255) NOT NULL,
  `Author_Name` varchar(255) NOT NULL,
  `Publisher_Name` varchar(255) NOT NULL,
  `Book_Name` varchar(255) NOT NULL,
  `Edition` varchar(255) NOT NULL,
  `quantity` int(10) NOT NULL,
  `Return_Date` date NOT NULL,
  `Issue_Date` date NOT NULL,
  `Total_Days` int(10) NOT NULL,
  `Fine` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `view_quantity`
--

CREATE TABLE `view_quantity` (
  `id` int(11) NOT NULL,
  `issuue_qty` int(11) DEFAULT 0,
  `book_name` varchar(255) NOT NULL,
  `book_category` varchar(255) NOT NULL,
  `author_name` varchar(255) NOT NULL,
  `publisher` varchar(255) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp(),
  `Available_qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `issue_book`
--
ALTER TABLE `issue_book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `membership`
--
ALTER TABLE `membership`
  ADD PRIMARY KEY (`membership_id`),
  ADD UNIQUE KEY `member_id` (`member_id`);

--
-- Indexes for table `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `return_book`
--
ALTER TABLE `return_book`
  ADD PRIMARY KEY (`Return_ID`),
  ADD UNIQUE KEY `Member_Id` (`Member_Id`);

--
-- Indexes for table `view_quantity`
--
ALTER TABLE `view_quantity`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `issue_book`
--
ALTER TABLE `issue_book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `librarian`
--
ALTER TABLE `librarian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `membership`
--
ALTER TABLE `membership`
  MODIFY `membership_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `publisher`
--
ALTER TABLE `publisher`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `return_book`
--
ALTER TABLE `return_book`
  MODIFY `Return_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `view_quantity`
--
ALTER TABLE `view_quantity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

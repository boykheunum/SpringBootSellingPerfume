-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 13, 2022 lúc 10:21 AM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `test`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `department`
--

CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `department_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `department`
--

INSERT INTO `department` (`id`, `department_name`) VALUES
(1, 'Deputy'),
(2, 'Manager'),
(3, 'Accountant'),
(4, 'Staff');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employees`
--

CREATE TABLE `employees` (
  `id` int(11) NOT NULL,
  `adress` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `employee_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `phone_number` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `salary` int(10) DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `employees`
--

INSERT INTO `employees` (`id`, `adress`, `birthday`, `employee_name`, `password`, `phone_number`, `salary`, `username`, `department_id`) VALUES
(1, '45 Hàng Mã', '2022-03-26 05:38:04', 'Nguyễn Văn Tèo', '123456789', '123456789', 100000000, 'ad001', 2),
(2, '230 Hoàng Quốc Việt', '1995-04-08 11:42:52', 'Nguyễn Văn Nam', '123456789', '0865228068', 30000000, 'ad002', 1),
(3, '230 Mã Mây', '2000-06-16 11:42:52', 'Lê Thị Tuyết', '987654321', '0865228066', 10000000, 'ad003', 3),
(4, '237 Hoàng Hoa Thám', '2002-07-11 11:45:29', 'Võ Hải An', '123', '0865228064', 10000000, 'epl001', 4),
(5, '23 Lương Văn Can', '2002-03-01 11:45:29', 'Lê Thị Hải Vân', '456789', '0865228061', 10000000, 'epl002', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `adress` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `avatar` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `sex` tinyint(1) DEFAULT 1,
  `status_user` tinyint(1) DEFAULT 1,
  `username` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `role` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'USER'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `adress`, `avatar`, `birthday`, `email`, `name`, `password`, `phone`, `sex`, `status_user`, `username`, `role`) VALUES
(5, '95 Hàng Mã', 'testvares6.js', '2022-04-05', 'tiendat28121999@gmail.com', 'Đạt Nguyễn', '$2a$12$QGL0NFQzW6/MO83Mh2Ehc.z9CuXWhocS3Js8kcwNI1vVrbPEC9rLG', '0865228067', 0, 0, 'boykheunum', 'USER'),
(8, '95 Hàng Mã', 'testvares6.js', '2022-04-05', 'tiendat28121999@gmail.com', 'Đạt Nguyễn', '123', '0865228067', 0, 0, 'us1', 'USER');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8if1byloc650qvkaxabyjveap` (`department_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `department`
--
ALTER TABLE `department`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

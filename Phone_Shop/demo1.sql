
DROP DATABASE IF EXISTS Mock_Project;
CREATE DATABASE Mock_Project;
USE Mock_Project;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
---------------------------------------------------

DROP TABLE IF EXISTS `registration_account_tokens`;
CREATE TABLE IF NOT EXISTS `registration_account_tokens` (
    id 				BIGINT(20) NOT NULL,
    `token` 		CHAR(40) NOT NULL UNIQUE,
    `account_id` 	BIGINT(20) DEFAULT NULL,
    `expiryDate` 	DATETIME NOT NULL
);

DROP TABLE IF EXISTS `rates`;
CREATE TABLE `rates` (
    `id` 			BIGINT(20) NOT NULL,
    `star` 			DOUBLE DEFAULT NULL,
    `comment` 		VARCHAR(255) DEFAULT NULL,
    `product_id` 	BIGINT(20) DEFAULT NULL,
    `account_id` 	BIGINT(20) DEFAULT NULL,
    `rate_date` 	DATETIME DEFAULT NULL
)  ENGINE=INNODB 	DEFAULT CHARSET=UTF8MB4;

INSERT INTO `rates` (`id`, `star`, `comment`, `product_id`, `account_id`, `rate_date`) VALUES
(1, 5, 'sản phẩm này dùng tạm được.', 15, 1, '2021-07-24 13:30:57'),
(3, 5, 'giao hàng nhanh', 14, 1, '2021-07-16 13:31:11'),
(4, 1, 'Shipper thái độ, 1 sao', 16, 1, '2021-07-13 13:31:19'),
(5, 3, 'cũng bình thường', 16, 1, '2021-07-17 13:31:26'),
(6, 5, 'Sản phẩm này dùng rất đau mắt mọi người không nên mua nhé !', 16, 1, '2021-07-24 13:36:23'),
(8, 3, 'giao nham tv r ', 6, 1, '2021-07-24 18:21:58'),
(9, 3, 'ga', 3, 1, '2021-07-24 23:22:10'),
(10, 4, 'tam', 3, 1, '2021-07-24 23:22:17'),
(11, 5, NULL, 13, 1, '2021-07-24 23:32:25'),
(12, 4, NULL, 14, 1, '2021-07-24 23:32:33'),
(13, 3, 'điện thoại nhìn cùi vậy thôi chứ nó cùi thật.', 21, 1, '2021-07-25 21:32:39'),
(14, 4, 'San pham nay dep lam', 10, 1, '2021-07-25 21:46:42'),
(15, 2, 'cung tam', 10, 1, '2021-07-25 21:47:00'),
(16, 3, 'qua dat', 10, 1, '2021-07-25 21:47:06'),
(17, 5, 'điện thoại nay dep qua', 10, 1, '2021-07-25 21:47:15'),
(18, 3, 'điện thoại nay nhin dau mat qua', 3, 1, '2021-08-01 10:27:06'),
(19, 5, 'điện thoại nay dep', 5, 1, '2021-08-01 10:27:15'),
(20, 5, 'điện thoại nay rat dep', 3, 1, '2021-08-01 10:38:03'),
(21, 2, 'điện thoại nay ko duoc dep', 4, 1, '2021-08-01 10:38:13'),
(22, 3, 'tam duoc', 6, 20, '2021-08-01 10:41:35'),
(23, 4, 'ship lau nhung duoc cai man rat ngon', 5, 20, '2021-08-01 10:41:45'),
(24, 1, 'điện thoại mau trang xau qua troi', 3, 21, '2021-08-01 10:48:36'),
(25, 5, 'điện thoại nay dep', 4, 21, '2021-08-01 10:48:43'),
(26, 5, 'điện thoại dep lam <3', 3, 22, '2021-08-01 11:00:48'),
(27, 3, 'tam duoc', 15, 22, '2021-08-01 11:00:55'),
(28, 5, 'san pham nay cung tam duoc', 6, 22, '2021-08-01 12:38:14');


DROP TABLE IF EXISTS `carts`;
CREATE TABLE IF NOT EXISTS `carts` (
  `id` 			BIGINT(20) NOT NULL,
  `address` 	VARCHAR(255) DEFAULT NULL,
  `amount` 		DOUBLE DEFAULT NULL,
  `phone` 		VARCHAR(255) DEFAULT NULL,
  `status` 		TINYINT DEFAULT 1,
  `account_id` 	BIGINT(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `carts`
--

INSERT INTO `carts` (`id`, `address`, `amount`, `phone`, `status`, `account_id`) VALUES
(5, 'Hà Nội', 0, '0916546820', b'1', 1),
(6, 'Đà Nẵng', 0, '0872312313', b'1', 14),
(7, 'Thừa Thiên Huế', 0, '0916546821', b'1', 15),
(8, NULL, 0, NULL, b'1', 2),
(9, NULL, 0, NULL, b'1', 3),
(10, NULL, 0, NULL, b'1', 4),
(11, 'quang tri', 0, '0916546820', b'1', 5),
(12, 'Thừa Thiên Huế', 0, '0865299519', b'1', 8),
(14, 'Thừa Thiên Huế', 0, '0987654321', b'1', 17),
(15, 'số 8 Hà Văn Tính, Đà Nẵng', 0, '0987654321', b'1', 18),
(16, '8 Hà Văn Tính, Liên Chiểu, Đà Nẵng', 0, '0987654321', b'1', 19),
(17, '8 Hà Văn Tính, Liên Chiểu, Đà Nẵng', 0, '0987654321', b'1', 20),
(18, 'Thua Thien Hue, Nam Dong, Thi Tran Khe tre', 0, '0987654321', b'1', 21),
(19, '8 Hà Văn Tính, Liên Chiểu, Đà Nẵng', 0, '0987654321', b'1', 22);

-- --------------------------------------------------------

--
-- Table structure for table `cart_details`
--
DROP TABLE IF EXISTS `cart_details`;
CREATE TABLE IF NOT EXISTS `cart_details` (
  `id` 			BIGINT(20) NOT NULL,
  `price` 		DOUBLE NOT NULL,
  `quantity` 	INT(11) NOT NULL,
  `cart_id` 	BIGINT(20) DEFAULT NULL,
  `product_id` 	BIGINT(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cart_details`
--

INSERT INTO `cart_details` VALUES 
(129,96000000,3,5,4),
(130,60000000,3,5,5),
(144,2900000,1,5,14),
(145,28000000,1,5,3),
(146,54000000,1,5,10),
(149,18000000,1,5,6);

-- --------------------------------------------------------

--
-- Table structure for table `brands`
--
DROP TABLE IF EXISTS `brands`;
CREATE TABLE IF NOT EXISTS`brands` (
  `brand_id` 	BIGINT(20) NOT NULL,
  `brand_name` 	VARCHAR(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `brands`
--

INSERT INTO `brands` VALUES 
(1,'iphone'),
(2,'samsung'),
(3,'oppo'),
(4,'nokia'),
(5,'Vsmart'),
(13,'Vivo'),
(15,'xiaomi'),
(16,'philips'),
(17,'realme'),
(18,'huawei'),
(19,'Itel'),
(25,'blackberry'),
(26,'energiner');

-- --------------------------------------------------------
DROP TABLE IF EXISTS `rams`;
CREATE TABLE `rams`(
	ram_id			BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    ram_name		VARCHAR(100) NOT NULL UNIQUE KEY
);

INSERT INTO `rams` (`ram_name`) VALUES 								
('2gb'),   
('4gb'),
('6gb'),
('8gb'),
('12gb');
-- create table : ProductMemory
DROP TABLE IF EXISTS `memories`;
CREATE TABLE `memories`(
	memory_id			BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    memory_name			VARCHAR(100) NOT NULL UNIQUE KEY
);

INSERT INTO `memories` (`memory_name`) VALUES 										
('16gb'),	
('32gb'),
('64gb'),
('128gb'),
('256gb'),
('512gb');
                                            
--
-- Table structure for table `orders`
--
DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id` 			BIGINT(20) NOT NULL,
  `address` 	VARCHAR(255) DEFAULT NULL,
  `amount` 		DOUBLE DEFAULT NULL,
  `order_date` 	DATETIME DEFAULT NULL,
  `phone` 		VARCHAR(255) DEFAULT NULL,
  `status` 		TINYINT DEFAULT 3,
  `account_id` 	BIGINT(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` VALUES 
(1,'số 8 Hà Văn Tính, Đà Nẵng',73270000,'2021-04-14 22:12:37','0866499519',3,1),
(2,'Thừa Thiên Huế',101310000,'2019-05-23 22:13:12','0866499519',3,1),
(3,'Thừa Thiên Huế',110000000,'2021-07-22 22:22:53','0866499519',0,1),
(4,'Thừa Thiên Huế',27590000,'2021-07-23 11:49:00','0866499519',0,1),
(5,'Thị Trấn Khe Tre',27590000,'2021-03-10 16:22:18','0916546820',3,1),
(6,'Huyện Nam Đông, Tỉnh Thừa Thiên Huế',22223000,'2021-06-09 20:43:15','0866499519',3,1),
(7,'Hà Nội',2910000,'2021-07-24 13:25:57','0916546820',3,1),
(8,'số 8 Hà Văn Tính, Đà Nẵng',84000000,'2021-05-12 13:56:13','0916546820',3,1),
(9,'Thua Thien Hue, Nam Dong, Thi Tran Khe tre',36000000,'2021-02-16 18:21:10','0916546820',3,1),
(10,'Hà Nội',75000000,'2020-10-07 23:32:05','0916546820',3,1),
(11,'Hà Nội',2168100,'2020-02-19 21:32:00','0916546820',3,1),
(12,'Hà Nội',54000000,'2021-01-20 21:46:05','0916546820',3,1),
(13,'Hà Nội',2168100,'2019-06-20 21:32:00','0916546820',3,1),
(14,'Hà Nội',20000000,'2021-07-28 17:48:04','0916546820',3,1),
(15,'Hà Nội',24690000,'2020-04-15 17:48:10','0916546820',3,1),
(16,'Hà Nội',19000000,'2017-07-20 17:48:19','0916546820',3,1),
(17,'Hà Nội',66000000,'2015-12-30 17:51:16','0916546820',3,1),
(18,'Hà Nội',98000000,'2021-07-29 12:00:48','0916546820',3,1),
(19,'Hà Nội',28000000,'2021-07-29 12:01:53','0916546820',3,1),
(20,'Đà Nẵng',38000000,'2021-07-30 18:42:55','0872312313',1,14),
(21,'quang tri',60000000,'2021-07-30 18:56:31','0916546820',1,5),
(22,'8 Hà Văn Tính, Liên Chiểu, Đà Nẵng',159000000,'2021-07-31 21:10:49','0987654321',0,8),
(23,'Thừa Thiên Huế',148000000,'2021-07-31 21:31:41','0865299519',1,8),
(24,'Thừa Thiên Huế',30000000,'2021-07-31 21:34:08','0865299519',0,8),
(25,'Thừa Thiên Huế',203000000,'2021-07-31 21:34:39','0865299519',3,8),
(26,'Thừa Thiên Huế',70000000,'2021-07-31 21:40:09','0865299519',0,8),
(27,'Thừa Thiên Huế',88000000,'2021-07-31 21:42:23','0865299519',3,8),
(28,'Thừa Thiên Huế',63168100,'2021-07-31 22:04:06','0865299519',0,8),
(29,'Thừa Thiên Huế',38000000,'2021-07-31 22:04:16','0865299519',3,8),
(30,'Thừa Thiên Huế',23900000,'2021-07-31 22:05:30','0865299519',1,8),
(31,'Thừa Thiên Huế',80000000,'2021-07-31 22:10:40','0865299519',1,8),
(32,'Thừa Thiên Huế',60000000,'2021-07-31 22:13:24','0865299519',1,8),
(33,'Thừa Thiên Huế',27590000,'2021-07-31 22:13:55','0865299519',3,8),
(34,'Thừa Thiên Huế',98000000,'2021-07-31 22:15:57','0865299519',1,8),
(35,'Thừa Thiên Huế',80000000,'2021-07-31 22:19:32','0865299519',1,8),
(36,'Thừa Thiên Huế',137000000,'2021-07-31 22:21:09','0865299519',1,8),
(37,'Thừa Thiên Huế',123000000,'2021-07-31 22:30:45','0865299519',1,8),
(38,'Thừa Thiên Huế',78000000,'2021-07-31 22:43:24','0865299519',1,8),
(39,'Thừa Thiên Huế',60000000,'2021-08-01 08:15:58','0987654321',1,17),
(40,'Huyện Nam Đông, Tỉnh Thừa Thiên Huế',38000000,'2021-08-01 10:13:34','0865299519',0,18),
(41,'số 8 Hà Văn Tính, Đà Nẵng',114000000,'2021-08-01 10:14:04','0987654321',1,18),
(42,'8 Hà Văn Tính, Liên Chiểu, Đà Nẵng',81168100,'2021-08-01 10:23:37','0987654321',0,19),
(43,'8 Hà Văn Tính, Liên Chiểu, Đà Nẵng',100000000,'2021-08-01 10:24:00','0987654321',3,19),
(44,'8 Hà Văn Tính, Liên Chiểu, Đà Nẵng',86000000,'2021-08-01 10:36:31','0866499562',0,20),
(45,'8 Hà Văn Tính, Liên Chiểu, Đà Nẵng',80000000,'2021-08-01 10:37:20','0987654321',3,20),
(46,'8 Hà Văn Tính, Liên Chiểu, Đà Nẵng',70000000,'2021-08-01 10:41:15','0987654321',3,20),
(47,'Thua Thien Hue, Nam Dong, Thi Tran Khe tre',92000000,'2021-08-01 10:47:09','0987654321',0,21),
(48,'Thua Thien Hue, Nam Dong, Thi Tran Khe tre',114000000,'2021-08-01 10:47:39','0987654321',3,21),
(49,'8 Hà Văn Tính, Liên Chiểu, Đà Nẵng',68000000,'2021-08-01 10:59:33','0987654321',0,22),
(50,'8 Hà Văn Tính, Liên Chiểu, Đà Nẵng',84680000,'2021-08-01 10:59:55','0987654321',3,22),
(51,'8 Hà Văn Tính, Liên Chiểu, Đà Nẵng',18000000,'2021-08-01 12:36:48','0987654321',3,22);

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--
DROP TABLE IF EXISTS `order_details`;
CREATE TABLE IF NOT EXISTS`order_details` (
  `id` 			BIGINT(20) NOT NULL,
  `price` 		DOUBLE NOT NULL,
  `quantity` 	INT(11) NOT NULL,
  `order_id` 	BIGINT(20) DEFAULT NULL,
  `product_id` 	BIGINT(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` VALUES 
(1,5800000,2,1,14),
(2,43560000,2,1,15),
(3,2910000,1,1,16),
(4,21000000,1,1,13),
(5,2910000,1,2,16),
(6,5500000,1,2,17),
(7,2900000,1,2,14),
(8,63000000,3,2,13),
(9,27000000,1,2,8),
(10,60000000,3,3,5),
(11,32000000,1,3,4),
(12,18000000,1,3,6),
(13,21780000,1,4,15),
(14,2910000,1,4,16),
(15,2900000,1,4,14),
(16,2900000,1,5,14),
(17,21780000,1,5,15),
(18,2910000,1,5,16),
(19,117000000,3,6,7),
(20,32000000,1,6,4),
(21,18000000,1,6,6),
(22,2910000,1,7,16),
(23,84000000,3,8,3),
(24,36000000,2,9,6),
(25,36000000,2,10,6),
(26,39000000,1,10,7),
(27,2168100,1,11,21),
(28,54000000,1,12,10),
(29,20000000,1,14,5),
(30,2910000,1,15,16),
(31,21780000,1,15,15),
(32,19000000,1,16,12),
(33,54000000,1,17,10),
(34,12000000,1,17,11),
(35,18000000,1,18,6),
(36,20000000,1,18,5),
(37,32000000,1,18,4),
(38,28000000,1,18,3),
(39,28000000,1,19,3),
(40,20000000,1,20,5),
(41,18000000,1,20,6),
(42,32000000,1,21,4),
(43,28000000,1,21,3),
(44,28000000,1,22,3),
(45,20000000,1,22,5),
(46,72000000,4,22,6),
(47,39000000,1,22,7),
(48,20000000,1,23,5),
(49,18000000,1,23,6),
(50,32000000,1,23,4),
(51,78000000,2,23,7),
(52,18000000,1,24,6),
(53,12000000,2,24,11),
(54,108000000,2,25,10),
(55,12000000,1,25,11),
(56,19000000,1,25,12),
(57,64000000,2,25,9),
(58,18000000,1,26,6),
(59,20000000,1,26,5),
(60,32000000,1,26,4),
(61,20000000,1,27,5),
(62,32000000,1,27,4),
(63,36000000,2,27,6),
(64,12000000,1,28,11),
(65,20000000,1,28,5),
(66,21000000,1,28,13),
(67,28000000,1,28,3),
(68,2168100,1,28,21),
(69,20000000,1,29,5),
(70,18000000,1,29,6),
(71,2900000,1,30,14),
(72,21000000,1,30,13),
(73,20000000,1,31,5),
(74,32000000,2,31,4),
(75,28000000,1,31,3),
(76,28000000,1,32,3),
(77,32000000,1,32,4),
(78,2900000,1,33,14),
(79,21780000,1,33,15),
(80,2910000,1,33,16),
(81,28000000,1,34,3),
(82,32000000,1,34,4),
(83,18000000,1,34,6),
(84,20000000,1,34,5),
(85,20000000,1,35,5),
(86,32000000,1,35,4),
(87,28000000,1,35,3),
(88,32000000,1,36,4),
(89,28000000,1,36,3),
(90,18000000,1,36,6),
(91,20000000,1,36,5),
(92,39000000,1,36,7),
(93,39000000,1,37,7),
(94,18000000,1,37,6),
(95,12000000,1,37,11),
(96,54000000,1,37,10),
(97,28000000,1,38,3),
(98,32000000,1,38,4),
(99,18000000,1,38,6),
(100,28000000,1,39,3),
(101,32000000,1,39,4),
(102,20000000,1,40,5),
(103,18000000,1,40,6),
(104,28000000,1,41,3),
(105,32000000,1,41,9),
(106,54000000,2,41,8),
(107,40000000,2,42,5),
(108,39000000,1,42,7),
(109,2168100,1,42,21),
(110,28000000,1,43,3),
(111,40000000,2,43,5),
(112,32000000,1,43,4),
(113,56000000,2,44,3),
(114,18000000,1,44,6),
(115,12000000,1,44,11),
(116,28000000,1,45,3),
(117,32000000,1,45,4),
(118,20000000,1,45,5),
(119,18000000,1,46,6),
(120,20000000,1,46,5),
(121,32000000,1,46,4),
(122,28000000,1,47,3),
(123,64000000,2,47,4),
(124,28000000,1,48,3),
(125,32000000,1,48,4),
(126,54000000,1,48,10),
(127,28000000,1,49,3),
(128,40000000,2,49,5),
(129,28000000,1,50,3),
(130,21780000,1,50,15),
(131,2900000,1,50,14),
(132,32000000,1,50,4),
(133,18000000,1,51,6);
-- --------------------------------------------------------

--
-- Table structure for table `products`
--
DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS`products` (
	`product_id` 			BIGINT(20) NOT NULL,
	`description` 			VARCHAR(4000) DEFAULT NULL,
	`discount` 				DOUBLE DEFAULT NULL,
	`entered_date` 			DATETIME DEFAULT NULL,
	`image` 				LONGTEXT NOT NULL,
	`name` 					VARCHAR(255) NOT NULL,
	`price` 				DOUBLE DEFAULT NULL,
	`quantity` 				INT(11) NOT NULL,
	`brand_id` 				BIGINT(20) NOT NULL,
	`ram_id`				BIGINT(20) NOT NULL,
	`memory_id` 			BIGINT(20) NOT NULL,
    `category`				ENUM('PHONE' , 'ACCESSORY') DEFAULT 'PHONE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`

INSERT INTO `products` VALUES 
(3,'iPhone 12 Pro Max chính thức trở thành chiếc iPhone có màn hình lớn nhất tính tới thời điểm hiện tại. Bạn sẽ được trải nghiệm hình ảnh đã mắt trên màn hình 6,7 inch Super Retina XDR này.',10,NULL,'https://hoanghamobile.com/i/preview/Uploads/2020/11/06/iphone-12-pro-max.png','iPhone 12 Pro Max - 128GB',28000000,99,1,1,1, 'PHONE'),
(4,'iPhone 12 Series của năm nay cũng không phải là một ngoại lệ. Mẫu iPhone 12 64GB sở hữu một thiết kế đã được “lột xác” hoàn toàn so với các thế hệ tiền nhiệm trước đây với cạnh được vát phẳng, vuông thành sắc cạnh, mang tới một cảm giác cực kì bền bỉ và chắc chắn.',10,'2021-07-16 19:57:17','https://hoanghamobile.com/i/preview/Uploads/2020/11/06/apple-iphone-12-mini-5.png','iPhone 12 - 64G',32000000,99,1,2,2, 'PHONE'),
(5,'Giống như những người anh em của mình như iPhone X, iPhone Xs/Xs Max thì iPhone Xr cũng có thiết kế nguyên khối, viền tràn cạnh ở tứ phía cho người dùng thêm nhiều không gian để hiển thị hơn',10,'2021-07-16 19:58:00','https://hoanghamobile.com/i/preview/Uploads/2020/11/27/red.png','iPhone XR - 128GB',20000000,99,1,3,3, 'PHONE'),
(6,' Chiếc iPhone X đánh dấu 10 năm của dòng điện thoại được ưa thích nhất trên toàn cầu cũng không thoát ly khỏi phong cách già dặn có phần hơi trầm tính của Apple. ',3,'2021-07-16 20:01:36','https://hoanghamobile.com/i/preview/Uploads/2020/11/27/w.png','iPhone XR  64GB',18000000,99,1,4,4, 'PHONE'),
(7,'Samsung là một trong những nhà sản xuất dẫn đầu trên thị trường điện thoại thông minh nhiều năm qua. Sau thành công của dòng Galaxy S20 series, Samsung đã trở lại và tiếp tục khẳng định vị thế cho dòng flagship cao cấp của mình',1,'2021-07-16 22:08:03','https://hoanghamobile.com/i/preview/Uploads/2021/01/15/5g1.png','Samsung Galaxy s21',39000000,99,2,5,5, 'PHONE'),
(8,'Với những thành công mà Samsung đã gặt hái được từ các thế hệ Galaxy Note đi trước, ông lớn tới từ Hàn Quốc lại tiếp tục làm cho người hâm mộ một lần nữa phải phát cuồng vì thế hệ Galaxy Note 20 cao cấp của năm 2020',1,'2021-07-16 22:21:35','https://hoanghamobile.com/i/preview/Uploads/2020/10/27/image-removebg-preview%20(4).png','Samsung Galaxy Note 20 Ultra',27000000,99,2,1,1, 'PHONE'),
(9,'Hầu hết các mẫu điện thoại của Samsung từ phân khúc giá rẻ đến cao cấp đều sở hữu thiết kế bên ngoài khá nổi bật. Và chiếc Galaxy A72 chính hãng này cũng không ngoại lệ. ',10,'2021-07-16 22:28:39','https://hoanghamobile.com/i/preview/Uploads/2021/03/10/a72.png','Samsung Galaxy A72',32000000,99,2,2,2, 'PHONE'),
(10,'Samsung là thương hiệu điện thoại thông minh không còn xa lạ trên thị trường. Trong những năm qua, bên cạnh việc nghiên cứu phát triển hai dòng flagship Galaxy S và Galaxy Note, Samsung cũng bắt đầu mở rộng hệ sinh thái các sản phẩm của họ.',1,'2021-07-16 22:28:39','https://hoanghamobile.com/i/preview/Uploads/2020/10/27/Z%20Fold%202%20-%20Cooper%20(3).png','Samsung Galaxy Z Fold2 5G',54000000,99,2,3,3, 'PHONE'),
(11,'Vì là mẫu điện thoại thuộc phân khúc giá rẻ bình dân nên Galaxy A02s sở hữu một ngôn ngữ thiết kế với vẻ ngoài đơn giản, thế nhưng không vì thế mà sản phẩm mất đi nét hiện đại của một mẫu smartphone được ra mắt trong năm 2021.',1,'2021-07-16 22:28:39','https://hoanghamobile.com/i/preview/Uploads/2021/02/19/a20s-3.png','Samsung Galaxy A02s',12000000,99,2,4,4, 'PHONE'),
(12,'OPPO cho ra mắt những dòng sản phẩm hướng đến đối tượng người dùng trẻ. OPPO Reno5 chính hãng có thiết kế trẻ trung, thời thượng với các biến thể màu độc đáo.',10,'2021-07-16 22:28:39','https://hoanghamobile.com/i/preview/Uploads/2021/05/10/image-removebg-preview-4.png','oppo reno5',19000000,99,3,5,5, 'PHONE'),
(13,'Nối tiếp sự thành công của dòng Reno5, OPPO mới đây đã trình làng bộ đôi siêu phẩm thuộc dòng OPPO Reno6 series có cấu hình mạnh mẽ, thiết kế ấn tượng. ',9,'2021-07-16 22:31:05','https://hoanghamobile.com/i/preview/Uploads/2021/07/23/image-removebg-preview-2.png','oppo reno6 5G',21000000,99,3,1,1, 'PHONE'),
(14,'OPPO A94 là mẫu smartphone tầm trung kế thừa những ưu điểm của thế hệ trước. Mặc dù vậy, máy vẫn được cải tiến thêm về thiết kế, pin cũng như camera nhằm đáp ứng tốt hơn nhu cầu của người dùng. ',0,'2021-07-17 10:07:35','https://hoanghamobile.com/i/preview/Uploads/2021/03/20/thumb-a94.png','oppo A94',2900000,99,3,2,2, 'PHONE'),
(15,'Cách đây không lâu, HMD Global đã cho ra mắt Nokia X10. Đây là chiếc điện thoại cấu hình ổn, giá hấp dẫn mà bạn không nên bỏ qua. Và Hoàng Hà Mobile rất tự hào khi trở thành đại lý bán lẻ độc quyền Nokia X10 chính hãng giá cực tốt.',1,'2021-07-17 10:36:47','https://hoanghamobile.com/i/preview/Uploads/2021/06/24/xx100.png','Nokia X10 5G',22000000,99,4,3,3, 'PHONE'),
(16,'Nokia 3.4 là một đại diện năm 2020 của Nokia trong phân khúc điện thoại giá rẻ. Với một cấu hình ổn định, camera nhiều tính năng chụp ảnh độc đáo và thiết kế trẻ trung, đây hứa hẹn là chiếc smartphone đáng giá, đáp ứng được nhu cầu đa dạng của người dùng.',3,'2021-07-17 10:45:58','https://hoanghamobile.com/i/preview/Uploads/2020/11/26/image-removebg-preview_637419802000906090.png','Nokia 3.4',3000000,99,4,4,4, 'PHONE'),
(17,'Nội dung đang cập nhật ',0,'2021-07-17 20:59:51','https://hoanghamobile.com/i/preview/Uploads/2021/06/07/y53s-2.png','Vivo Y53s',5500000,99,13,5,5, 'PHONE'),
(18,'Xã hội đang ngày càng phát triển, và điện thoại 5G đã trở thành xu hướng tất yếu của thế kỷ 21. Tiếp nối sự thành công của người tiền nhiệm V20, sản phẩm V21 5G sẽ là smartphone mới nhất thuộc V-series mang đến cho bạn cảm giác đây không chỉ đơn thuần là 1 chiếc điện thoại thông thường mà còn cực kỳ thời trang, hữu dụng.',1,'2021-07-17 21:00:31','https://hoanghamobile.com/i/preview/Uploads/2021/05/07/untitled-2.jpg','Vivo V21 5G',3000000,99,13,1,1, 'PHONE'),
(19,'Cũng như những chiếc smartphone khác nhà Vivo, chiếc Vivo V20 SE sở hữu ngôn ngữ thiết kế hiện đại và các chi tiết được hoàn thiện rất tốt. ',1,'2021-07-17 21:06:31','https://hoanghamobile.com/i/preview/Uploads/2020/12/28/blcak.png','Vivo V20 SE',3000000,99,13,2,2, 'PHONE'),
(20,'Vivo là thương hiệu sản xuất điện thoại thông minh đến từ Trung Quốc. Những năm qua, Vivo đã tìm được chỗ đứng của mình tại thị trường Việt Nam. Các sản phẩm mang thương hiệu Vivo luôn nổi bật bởi thiết kế khác biệt trong phân khúc giá. ',1,'2021-07-17 21:19:59','https://hoanghamobile.com/i/preview/Uploads/2020/10/28/re.png','Vivo S1 Pro - 8Gb',11000000,99,13,3,3, 'PHONE'),
(21,'Galaxy A là dòng điện thoại tầm trung dẫn đầu về doanh thu tại thị trường Việt Nam. Ngày 12/12/2019, Công ty Điện tử Samsung Vina đã cho ra mắt Samsung Galaxy A51, chiếc smartphone sở hữu Camera Macro ấn tượng.',1,'2021-07-25 21:30:54','https://hoanghamobile.com/i/preview/Uploads/2020/10/09/a51%20-%20blue%20(2).png','Samsung Galaxy A51',2190000,99,2,4,4, 'PHONE'),
(25,'Vsmart là điện thoại thông minh thuộc phân khúc giá rẻ được sản xuất bởi tập đoàn Vingroup. Mới đây, Vsmart Active 3 đã ra mắt với nhiều tính năng hiện đại, cấu hình cao hơn thế hệ trước.',12,'2021-08-01 11:02:30','https://hoanghamobile.com/i/preview/Uploads/2020/10/28/%C4%91en.png','Vsmart Active 3',1000000,99,5,5,5, 'PHONE');
-- --------------------------------------------------------

--
-- Table structure for table `rates`
--
DROP TABLE IF EXISTS product_images;
CREATE TABLE product_images(
	image_id		BIGINT(20) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    path_image		VARCHAR(255),
	product_id		BIGINT(20) NOT NULL
);

--
-- Dumping data for table `rates`
--

DROP TABLE IF EXISTS `accounts`;
CREATE TABLE  IF NOT EXISTS `accounts` (
  `account_id` 		BIGINT(20) NOT NULL,
  `email` 			VARCHAR(255) UNIQUE KEY NOT NULL,
  `username` 		VARCHAR(255) UNIQUE KEY NOT NULL ,
  `fullname` 		VARCHAR(255) NOT NULL,
  `password` 		VARCHAR(255) NOT NULL,
  `register_date` 	DATETIME DEFAULT NOW(),
  `status` 			TINYINT DEFAULT 1,
  `gender` 			ENUM('MALE', 'FEMALE', 'UNKNOWN') DEFAULT 'UNKNOWN',
  `image` 			LONGTEXT DEFAULT NULL,
  `city` 			VARCHAR(255) NOT NULL,
  `address` 		VARCHAR(255) NOT NULL,
  `phone` 			VARCHAR(255) DEFAULT NULL,
  `role` 			ENUM('ADMIN' , 'USER') DEFAULT 'USER'
) ENGINE=InnoDB 	DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (account_id, email, username, fullname, `password`, `role`) VALUES  
(1,'haidang29productions@gmail.com','dangblack','Dang Nguyen Hai','$2a$10$BeqYk3.ZXyYSQAMG0GJ7EuYAsD8niqj/2/bO3.Iy1lYX1s1DLG3kO','ADMIN'),
(2,'account1@gmail.com','quanganh','Anh Tong Quang','$2a$10$BeqYk3.ZXyYSQAMG0GJ7EuYAsD8niqj/2/bO3.Iy1lYX1s1DLG3kO','USER'),
(3,'account2@gmail.com','vanchien','Chien Nguyen Van','$2a$12$h1AwkaX8J40cVdkacCgop.bBPr249GnlDrlh49PDF.15qCGJR2ajy','USER'),
(4,'account3@gmail.com','cocoduongqua','Do Duong','$2a$12$h1AwkaX8J40cVdkacCgop.bBPr249GnlDrlh49PDF.15qCGJR2ajy','USER'),
(5,'account4@gmail.com','doccocaubai','Thang Nguyen Chien','$2a$12$h1AwkaX8J40cVdkacCgop.bBPr249GnlDrlh49PDF.15qCGJR2ajy','USER'),
(8,'account7@gmail.com','tungnui','Tung Nui','$2a$12$h1AwkaX8J40cVdkacCgop.bBPr249GnlDrlh49PDF.15qCGJR2ajy','USER'),
(14,'account5@gmail.com','khabanh','Kha Ngo Ba','$2a$12$h1AwkaX8J40cVdkacCgop.bBPr249GnlDrlh49PDF.15qCGJR2ajy','USER'),
(15,'account6@gmail.com','huanhoahong','Huan Hoa Hong','$2a$12$h1AwkaX8J40cVdkacCgop.bBPr249GnlDrlh49PDF.15qCGJR2ajy','USER'),
(17,'account8@gmail.com','duongghuu','Duong Huu','$2a$12$h1AwkaX8J40cVdkacCgop.bBPr249GnlDrlh49PDF.15qCGJR2ajy','USER'),
(18,'account9@gmail.com','USER9','Huu Duong Van','$2a$12$h1AwkaX8J40cVdkacCgop.bBPr249GnlDrlh49PDF.15qCGJR2ajy','USER'),
(19,'account10@gmail.com','account10','Tung Nguyen Thanh','$2a$12$h1AwkaX8J40cVdkacCgop.bBPr249GnlDrlh49PDF.15qCGJR2ajy','USER'),
(20,'account11@gmail.com','username11','Tung Nguyen','$2a$12$h1AwkaX8J40cVdkacCgop.bBPr249GnlDrlh49PDF.15qCGJR2ajy','USER'),
(21,'account12@gmail.com','account12','Huu Duong','$2a$12$h1AwkaX8J40cVdkacCgop.bBPr249GnlDrlh49PDF.15qCGJR2ajy','USER'),
(22,'account13@gmail.com','username13','Duong Do','$2a$12$h1AwkaX8J40cVdkacCgop.bBPr249GnlDrlh49PDF.15qCGJR2ajy','USER');

-- --------------------------------------------------------
--
-- Indexes for table `carts`
--
ALTER TABLE `carts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb5o626f86h46m4s7ms6ginnop` (`account_id`);

--
-- Indexes for table `cart_details`
--
ALTER TABLE `cart_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkcochhsa891wv0s9wrtf36wgt` (`cart_id`),
  ADD KEY `FK9rlic3aynl3g75jvedkx84lhv` (`product_id`);

--
-- Indexes for table `brands`
--
ALTER TABLE `brands`
  ADD PRIMARY KEY (`brand_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK32ql8ubntj5uh44ph9659tiih` (`account_id`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjyu2qbqt8gnvno9oe9j2s2ldk` (`order_id`),
  ADD KEY `FK4q98utpd73imf4yhttm3w0eax` (`product_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`brand_id`);

--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`account_id`);


ALTER TABLE `carts`
  MODIFY `id` BIGINT(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `cart_details`
--
ALTER TABLE `cart_details`
  MODIFY `id` BIGINT(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=238;

--
-- AUTO_INCREMENT for table `brands`
--
ALTER TABLE `brands`
  MODIFY `brand_id` BIGINT(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` BIGINT(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `id` BIGINT(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=134;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` BIGINT(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `rates`
--


--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `account_id` BIGINT(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `account_roles`
--

--
-- Constraints for dumped tables
--

--
-- Constraints for table `carts`
--
ALTER TABLE `carts`
  ADD CONSTRAINT `FKb5o626f86h46m4s7ms6ginnop` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`account_id`) ON DELETE CASCADE ON UPDATE CASCADE;
    
--
-- Constraints for table `cart_details`
--
ALTER TABLE `cart_details`
  ADD CONSTRAINT `FK9rlic3aynl3g75jvedkx84lhv` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  ADD CONSTRAINT `FKkcochhsa891wv0s9wrtf36wgt` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`account_id`);

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `FK4q98utpd73imf4yhttm3w0eax` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  ADD CONSTRAINT `FKjyu2qbqt8gnvno9oe9j2s2ldk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
ADD CONSTRAINT `FKb5o626f86h46m4s7ms6ginnoa`FOREIGN KEY(ram_id)  	REFERENCES rams(ram_id),
	  ADD CONSTRAINT `FKb5o626f86h46m4s7ms6ginnob`FOREIGN KEY(memory_id)  REFERENCES `memories`(memory_id),
      ADD CONSTRAINT `FKb5o626f86h46m4s7ms6ginnoc`FOREIGN KEY(brand_id)  	REFERENCES brands(brand_id),
  ADD CONSTRAINT `FKog2rp4qthbtt2lfyhfo32lsw9` FOREIGN KEY (`brand_id`) REFERENCES `brands` (`brand_id`);


ALTER TABLE `product_images`
ADD CONSTRAINT `FKb5o626f86h46m4s7ms6ginnod` FOREIGN KEY(product_id)  REFERENCES `products`(product_id);

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

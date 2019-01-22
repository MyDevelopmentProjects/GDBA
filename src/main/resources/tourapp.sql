-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 01, 2017 at 04:37 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tourapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `about`
--

CREATE TABLE `about` (
  `id` bigint(20) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_deleted` date DEFAULT NULL,
  `date_updated` date DEFAULT NULL,
  `description_en` longtext,
  `description_ru` longtext,
  `title_en` varchar(255) DEFAULT NULL,
  `title_ru` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `title_en` varchar(255) DEFAULT NULL,
  `title_ru` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` bigint(20) NOT NULL,
  `title_en` varchar(255) DEFAULT NULL,
  `title_ru` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `title_en`, `title_ru`) VALUES
(1, 'Tbilisi', 'Тбилиси'),
(2, 'Abasha', 'Абаша'),
(3, 'Ambrolauri', 'Амбролаури'),
(4, 'Akhalkalaki', 'Ахалкалаки'),
(5, 'Akhaltsikhe', 'Ахалцихе'),
(6, 'Akhmeta', 'Ахмета'),
(7, 'Batumi', 'Батуми'),
(8, 'Baghdati', 'Багдати'),
(9, 'Bolnisi', 'Болниси'),
(10, 'Borjomi', 'Боржоми'),
(11, 'Gardabani', 'Гардабани'),
(12, 'Gori', 'Гори'),
(13, 'Gurjaani', 'Гурджаани'),
(14, 'Dedoplistskaro', 'Дедоплисцкаро'),
(15, 'Dmanisi', 'Дманиси'),
(16, 'Dusheti', 'Душети'),
(17, 'Vale', 'Вале'),
(18, 'Vani', 'Вани'),
(19, 'Zestaponi', 'Зестафони'),
(20, 'Zugdidi', 'Зугдиди'),
(21, 'Tetritskaro', 'Тетрицкаро'),
(22, 'Telavi', 'Телави'),
(23, 'Terjola', 'Терджола'),
(24, 'Kaspi', 'Каспи'),
(25, 'Lagodekhi', 'Лагодехи'),
(26, 'Lanchkhuti', 'Ланчхути'),
(27, 'Marneuli', 'Марнеули'),
(28, 'Martvili', 'Мартвили'),
(29, 'Mtskheta', 'Мцхета'),
(30, 'Ninotsminda', 'Ниноцминда'),
(31, 'Ozurgeti', 'Озургети'),
(32, 'Oni', 'Они'),
(33, 'Rustavi', 'Рустави'),
(34, 'Sagarejo', 'Сагареджо'),
(35, 'Samtredia', 'Самтредия'),
(36, 'Sachkhere', 'Сачхере'),
(37, 'Senaki', 'Сенаки'),
(38, 'Sighnaghi', 'Сигнахи'),
(39, 'Tkibuli', 'Ткибули'),
(40, 'Poti', 'Поти'),
(41, 'Kareli', 'Карели'),
(42, 'Kobuleti', 'Кобулети'),
(43, 'Kutaisi', 'Кутаиси'),
(44, 'Kvareli', 'Кварели'),
(45, 'Tsageri', 'Цагери'),
(46, 'Tsalenjikha', 'Цаленджиха'),
(47, 'Tsalka', 'Цалка'),
(48, 'Tsnori', 'Цнори'),
(49, 'Tskaltubo', 'Цхалтубо'),
(50, 'Chiatura', 'Чиатура'),
(51, 'Khashuri', 'Хашури'),
(52, 'Khobi', 'Хоби'),
(53, 'Khoni', 'Хони'),
(54, 'Jvari', 'Джвари');

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `id` bigint(20) NOT NULL,
  `data` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`id`, `data`, `description`, `path`) VALUES
(1, '593-47-40-04', NULL, 'MobileNumber'),
(2, 'https://www.facebook.com/misho.janiashvili', NULL, 'Facebook'),
(3, 'mishojaniashvili', NULL, 'Skype'),
(4, 'info@tourapp.ge', NULL, 'Email'),
(5, '{"lat":"41.7232166","lng":"44.7504341"}', NULL, 'Gmap'),
(6, 'Ateni Str. 6/8 Apt.25', NULL, 'Address');

-- --------------------------------------------------------

--
-- Table structure for table `hotel`
--

CREATE TABLE `hotel` (
  `id` bigint(20) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_deleted` date DEFAULT NULL,
  `date_updated` date DEFAULT NULL,
  `is_cheating` bit(1) DEFAULT NULL,
  `description_en` longtext,
  `description_ru` longtext,
  `title_en` varchar(255) DEFAULT NULL,
  `title_ru` varchar(255) DEFAULT NULL,
  `is_ethernet` bit(1) DEFAULT NULL,
  `latitude` decimal(9,6) DEFAULT NULL,
  `longitude` decimal(9,6) DEFAULT NULL,
  `is_parking` bit(1) DEFAULT NULL,
  `is_pool` bit(1) DEFAULT NULL,
  `room_count` int(11) DEFAULT NULL,
  `stage_count` int(11) DEFAULT NULL,
  `star_count` int(11) DEFAULT NULL,
  `is_televison` bit(1) DEFAULT NULL,
  `wet_corners` int(11) DEFAULT NULL,
  `city_id` bigint(20) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hotel`
--

INSERT INTO `hotel` (`id`, `date_created`, `date_deleted`, `date_updated`, `is_cheating`, `description_en`, `description_ru`, `title_en`, `title_ru`, `is_ethernet`, `latitude`, `longitude`, `is_parking`, `is_pool`, `room_count`, `stage_count`, `star_count`, `is_televison`, `wet_corners`, `city_id`, `image_url`) VALUES
(1, '2017-04-01 13:57:02', NULL, NULL, b'1', 'Found in the heart of Georgia’s capital city, Tbilisi, this hotel is nestled between the beautiful Mtkvari River and nearby mountain ranges. Step outside to find dining, shopping and nightlife on Rustaveli Avenue. You can visit nearby attractions like Old Town and the Narikala Fortress. Our 249 rooms and suites provide Free high-speed, wireless Internet and scenic views of Mtatsminda, the city’s historic hill, or of the river landscape.\r\n\r\nSavor Italian dishes at Filini Restaurant, Asian fusion fare at Umami or pastries and coffee at Iveria Café. You can dine outdoors at Iveria Terrace during summer. After dinner, have a drink in the Surface Bar or in the 18th-floor Oxygen Bar. You can shop at our Iveria Gallery and then try your luck in our Casino Iveria. The world-class spa will pamper you with premium treatments from Anne Semonin. For business ', 'Found in the heart of Georgia’s capital city, Tbilisi, this hotel is nestled between the beautiful Mtkvari River and nearby mountain ranges. Step outside to find dining, shopping and nightlife on Rustaveli Avenue. You can visit nearby attractions like Old Town and the Narikala Fortress. Our 249 rooms and suites provide Free high-speed, wireless Internet and scenic views of Mtatsminda, the city’s historic hill, or of the river landscape.\r\n\r\nSavor Italian dishes at Filini Restaurant, Asian fusion fare at Umami or pastries and coffee at Iveria Café. You can dine outdoors at Iveria Terrace during summer. After dinner, have a drink in the Surface Bar or in the 18th-floor Oxygen Bar. You can shop at our Iveria Gallery and then try your luck in our Casino Iveria. The world-class spa will pamper you with premium treatments from Anne Semonin. For business ', 'Radisson Blu Iveria Hotel', 'ОСТИНИЦА РАДИСОН СИН ИВЕРИЯ', b'1', NULL, NULL, b'1', b'1', 1, 1, 5, b'1', 3, 14, 'http://www.hotels.ltd.ge/wp-content/uploads/2010/02/radisson-iveria.jpg'),
(2, '2017-04-01 13:57:02', NULL, NULL, b'1', 'Found in the heart of Georgia’s capital city, Tbilisi, this hotel is nestled between the beautiful Mtkvari River and nearby mountain ranges. Step outside to find dining, shopping and nightlife on Rustaveli Avenue. You can visit nearby attractions like Old Town and the Narikala Fortress. Our 249 rooms and suites provide Free high-speed, wireless Internet and scenic views of Mtatsminda, the city’s historic hill, or of the river landscape.\r\n\r\nSavor Italian dishes at Filini Restaurant, Asian fusion fare at Umami or pastries and coffee at Iveria Café. You can dine outdoors at Iveria Terrace during summer. After dinner, have a drink in the Surface Bar or in the 18th-floor Oxygen Bar. You can shop at our Iveria Gallery and then try your luck in our Casino Iveria. The world-class spa will pamper you with premium treatments from Anne Semonin. For business ', 'Found in the heart of Georgia’s capital city, Tbilisi, this hotel is nestled between the beautiful Mtkvari River and nearby mountain ranges. Step outside to find dining, shopping and nightlife on Rustaveli Avenue. You can visit nearby attractions like Old Town and the Narikala Fortress. Our 249 rooms and suites provide Free high-speed, wireless Internet and scenic views of Mtatsminda, the city’s historic hill, or of the river landscape.\r\n\r\nSavor Italian dishes at Filini Restaurant, Asian fusion fare at Umami or pastries and coffee at Iveria Café. You can dine outdoors at Iveria Terrace during summer. After dinner, have a drink in the Surface Bar or in the 18th-floor Oxygen Bar. You can shop at our Iveria Gallery and then try your luck in our Casino Iveria. The world-class spa will pamper you with premium treatments from Anne Semonin. For business ', 'Radisson Blu Iveria Hotel', 'ОСТИНИЦА РАДИСОН СИН ИВЕРИЯ', b'1', NULL, NULL, b'1', b'1', 1, 1, 5, b'1', 3, 14, 'http://www.hotels.ltd.ge/wp-content/uploads/2010/02/radisson-iveria.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `our_team`
--

CREATE TABLE `our_team` (
  `id` bigint(20) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `description_en` longtext,
  `description_ru` longtext,
  `title_en` varchar(255) DEFAULT NULL,
  `title_ru` varchar(255) DEFAULT NULL,
  `position_en` varchar(255) DEFAULT NULL,
  `position_ru` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `our_team`
--

INSERT INTO `our_team` (`id`, `image_url`, `description_en`, `description_ru`, `title_en`, `title_ru`, `position_en`, `position_ru`) VALUES
(1, 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Bill_Gates_June_2015.jpg/330px-Bill_Gates_June_2015.jpg', 'William Henry "Bill" Gates III (born October 28, 1955) is an American business magnate, investor, author, and philanthropist.[1][2] In 1975, Gates and Paul Allen co-founded Microsoft, which became the world\'s largest PC software company. During his career at Microsoft, Gates held the positions of chairman, CEO and chief software architect, and was the largest individual shareholder until May 2014.[3][a] Gates has authored and co-authored several books.', 'William Henry "Bill" Gates III (born October 28, 1955) is an American business magnate, investor, author, and philanthropist.[1][2] In 1975, Gates and Paul Allen co-founded Microsoft, which became the world\'s largest PC software company. During his career at Microsoft, Gates held the positions of chairman, CEO and chief software architect, and was the largest individual shareholder until May 2014.[3][a] Gates has authored and co-authored several books.', 'Bill Gates', 'Bill Gates', 'TerraPower', 'TerraPower'),
(2, 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Mark_Zuckerberg_em_setembro_de_2014.jpg/430px-Mark_Zuckerberg_em_setembro_de_2014.jpg', 'Zuckerberg launched Facebook from his Harvard University dormitory room on February 4, 2004. He was assisted by his college roommates and fellow Harvard students Eduardo Saverin, Andrew McCollum, Dustin Moskovitz, and Chris Hughes.[8] The group then introduced Facebook to other college campuses. Facebook expanded rapidly, reaching one billion users by 2012. Meanwhile, Zuckerberg was involved in various legal disputes brought by others in the group, who claimed a share of the company based upon their involvement during the development phase of Facebook.', 'Zuckerberg launched Facebook from his Harvard University dormitory room on February 4, 2004. He was assisted by his college roommates and fellow Harvard students Eduardo Saverin, Andrew McCollum, Dustin Moskovitz, and Chris Hughes.[8] The group then introduced Facebook to other college campuses. Facebook expanded rapidly, reaching one billion users by 2012. Meanwhile, Zuckerberg was involved in various legal disputes brought by others in the group, who claimed a share of the company based upon their involvement during the development phase of Facebook.', 'Mark Zuckerberg', 'Mark Zuckerberg', 'Co-founder of Facebook', 'Co-founder of Facebook'),
(3, 'https://upload.wikimedia.org/wikipedia/commons/8/82/David_Heinemeier_Hansson.jpg', 'Steven Paul "Steve" Jobs (/ˈdʒɒbz/; February 24, 1955 – October 5, 2011) was an American entrepreneur, businessman, inventor, and industrial designer. He was the co-founder, chairman, and chief executive officer (CEO) of Apple Inc.; CEO and majority shareholder of Pixar;[2] a member of The Walt Disney Company\'s board of directors following its acquisition of Pixar; and founder, chairman, and CEO of NeXT. Jobs and Apple co-founder Steve Wozniak are widely recognized as pioneers of the microcomputer revolution of the 1970s and 1980s.', 'Steven Paul "Steve" Jobs (/ˈdʒɒbz/; February 24, 1955 – October 5, 2011) was an American entrepreneur, businessman, inventor, and industrial designer. He was the co-founder, chairman, and chief executive officer (CEO) of Apple Inc.; CEO and majority shareholder of Pixar;[2] a member of The Walt Disney Company\'s board of directors following its acquisition of Pixar; and founder, chairman, and CEO of NeXT. Jobs and Apple co-founder Steve Wozniak are widely recognized as pioneers of the microcomputer revolution of the 1970s and 1980s.', 'David Heinemeier Hansson', 'David Heinemeier Hansson', 'Founder and CEO of NeXT', 'Founder and CEO of NeXT');

-- --------------------------------------------------------

--
-- Table structure for table `our_travel_agency`
--

CREATE TABLE `our_travel_agency` (
  `id` bigint(20) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_deleted` date DEFAULT NULL,
  `date_updated` date DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `description_en` longtext,
  `description_ru` longtext,
  `title_en` varchar(255) DEFAULT NULL,
  `title_ru` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `our_travel_agency`
--

INSERT INTO `our_travel_agency` (`id`, `date_created`, `date_deleted`, `date_updated`, `icon`, `description_en`, `description_ru`, `title_en`, `title_ru`) VALUES
(1, '2017-04-01 08:13:57', NULL, NULL, '/img/adv-01.png', 'We respect our clients as we want to get all together and give favorite trip.', 'We respect our clients as we want to get all together and give favorite trip.', 'we love our clients', 'we love our clients'),
(2, '2017-04-01 08:14:12', NULL, NULL, '/img/adv-02.png', 'We respect our clients as we want to get all together and give favorite trip.', 'We respect our clients as we want to get all together and give favorite trip.', 'brilliant prices', 'brilliant prices'),
(3, '2017-04-01 08:14:37', NULL, NULL, '/img/adv-03.png', 'We respect our clients as we want to get all together and give favorite trip.', 'We respect our clients as we want to get all together and give favorite trip.', 'many different tours', 'many different tours');

-- --------------------------------------------------------

--
-- Table structure for table `permissions`
--

CREATE TABLE `permissions` (
  `id` bigint(20) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_deleted` date DEFAULT NULL,
  `date_updated` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_deleted` date DEFAULT NULL,
  `date_updated` date DEFAULT NULL,
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role_permissions`
--

CREATE TABLE `role_permissions` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `slider`
--

CREATE TABLE `slider` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `caption_one_en` varchar(255) DEFAULT NULL,
  `caption_one_ru` varchar(255) DEFAULT NULL,
  `caption_two_en` varchar(255) DEFAULT NULL,
  `caption_two_ru` varchar(255) DEFAULT NULL,
  `href` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `slider`
--

INSERT INTO `slider` (`id`, `active`, `caption_one_en`, `caption_one_ru`, `caption_two_en`, `caption_two_ru`, `href`, `image`) VALUES
(1, b'1', 'This is the worlds beautiful place', 'This is the worlds beautiful place', 'You should visit this place', 'You should visit this place', 'https://www.oars.com/wp-content/uploads/2015/12/gc-dory-lees-phantom-hero.jpg', 'https://www.oars.com/wp-content/uploads/2015/12/gc-dory-lees-phantom-hero.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tour`
--

CREATE TABLE `tour` (
  `id` bigint(20) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_deleted` date DEFAULT NULL,
  `date_updated` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `tour_price` int(11) DEFAULT NULL,
  `stars` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `description_en` longtext,
  `description_ru` longtext,
  `title_en` varchar(255) DEFAULT NULL,
  `title_ru` varchar(255) DEFAULT NULL,
  `city_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tour`
--

INSERT INTO `tour` (`id`, `date_created`, `date_deleted`, `date_updated`, `end_date`, `image_url`, `tour_price`, `stars`, `start_date`, `description_en`, `description_ru`, `title_en`, `title_ru`, `city_id`) VALUES
(1, '2017-04-01 08:35:03', NULL, NULL, '2017-04-30', 'http://uskrd.ru/assets/cache/images/tours/2016/626x464-sevkav.e47.jpg', 123, 5, '2017-04-19', NULL, NULL, 'Gudauri', 'Гудаури', 5),
(2, '2017-04-01 08:35:03', NULL, NULL, '2017-04-30', 'http://uskrd.ru/assets/cache/images/tours/2016/626x464-sevkav.e47.jpg', 300, 1, '2017-04-19', NULL, NULL, 'Gudauri', 'Гудаури', 5),
(3, '2017-04-01 08:35:03', NULL, NULL, '2017-04-30', 'http://uskrd.ru/assets/cache/images/tours/2016/626x464-sevkav.e47.jpg', 123, 3, '2017-04-19', NULL, NULL, 'Gudauri', 'Гудаури', 5),
(4, '2017-04-01 08:35:03', NULL, NULL, '2017-04-30', 'http://uskrd.ru/assets/cache/images/tours/2016/626x464-sevkav.e47.jpg', 123, 3, '2017-04-19', NULL, NULL, 'Gudauri', 'Гудаури', 5),
(5, '2017-04-01 08:35:03', NULL, NULL, '2017-04-30', 'http://uskrd.ru/assets/cache/images/tours/2016/626x464-sevkav.e47.jpg', 123, 3, '2017-04-19', NULL, NULL, 'Gudauri', 'Гудаури', 5),
(6, '2017-04-01 08:35:03', NULL, NULL, '2017-04-30', 'http://uskrd.ru/assets/cache/images/tours/2016/626x464-sevkav.e47.jpg', 123, 3, '2017-04-19', NULL, NULL, 'Gudauri', 'Гудаури', 5);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_deleted` date DEFAULT NULL,
  `date_updated` date DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `why_choose_us`
--

CREATE TABLE `why_choose_us` (
  `id` bigint(20) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_deleted` date DEFAULT NULL,
  `date_updated` date DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `description_en` longtext,
  `description_ru` longtext,
  `title_en` varchar(255) DEFAULT NULL,
  `title_ru` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `why_choose_us`
--

INSERT INTO `why_choose_us` (`id`, `date_created`, `date_deleted`, `date_updated`, `icon`, `description_en`, `description_ru`, `title_en`, `title_ru`) VALUES
(1, '2017-04-01 15:44:10', NULL, NULL, '/img/why-we-01.png', 'Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui. voluptatem sequi nesciunt.', 'Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui. voluptatem sequi nesciunt.', 'EXCELLENT TRIP PLANNING', 'EXCELLENT TRIP PLANNING'),
(2, '2017-04-01 15:44:10', NULL, NULL, '/img/why-we-02.png', 'Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui. voluptatem sequi nesciunt.', 'Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui. voluptatem sequi nesciunt.', 'BEST TOUR PRICING', 'BEST TOUR PRICING'),
(3, '2017-04-01 15:45:01', NULL, NULL, '/img/why-we-03.png', 'Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui. voluptatem sequi nesciunt.', 'Voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui. voluptatem sequi nesciunt.', 'WE LOVE OUR CLIENTS', 'WE LOVE OUR CLIENTS');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `about`
--
ALTER TABLE `about`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKf1iabdv6bi2yohh9h48wce42x` (`city_id`);

--
-- Indexes for table `our_team`
--
ALTER TABLE `our_team`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `our_travel_agency`
--
ALTER TABLE `our_travel_agency`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `permissions`
--
ALTER TABLE `permissions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_pnvtwliis6p05pn6i3ndjrqt2` (`name`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role_permissions`
--
ALTER TABLE `role_permissions`
  ADD KEY `FKegdk29eiy7mdtefy5c7eirr6e` (`permission_id`),
  ADD KEY `FKlodb7xh4a2xjv39gc3lsop95n` (`role_id`);

--
-- Indexes for table `slider`
--
ALTER TABLE `slider`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tour`
--
ALTER TABLE `tour`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpy38sq4e84fouj3ixh3t6pkhs` (`city_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`),
  ADD KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`);

--
-- Indexes for table `why_choose_us`
--
ALTER TABLE `why_choose_us`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `about`
--
ALTER TABLE `about`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `hotel`
--
ALTER TABLE `hotel`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `our_team`
--
ALTER TABLE `our_team`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `our_travel_agency`
--
ALTER TABLE `our_travel_agency`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `permissions`
--
ALTER TABLE `permissions`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `slider`
--
ALTER TABLE `slider`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `tour`
--
ALTER TABLE `tour`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `why_choose_us`
--
ALTER TABLE `why_choose_us`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `FKf1iabdv6bi2yohh9h48wce42x` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`);

--
-- Constraints for table `role_permissions`
--
ALTER TABLE `role_permissions`
  ADD CONSTRAINT `FKegdk29eiy7mdtefy5c7eirr6e` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`),
  ADD CONSTRAINT `FKlodb7xh4a2xjv39gc3lsop95n` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- Constraints for table `tour`
--
ALTER TABLE `tour`
  ADD CONSTRAINT `FKpy38sq4e84fouj3ixh3t6pkhs` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

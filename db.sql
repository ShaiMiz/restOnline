-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 30, 2019 at 07:48 PM
-- Server version: 5.7.21
-- PHP Version: 7.1.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restonline`
--

-- --------------------------------------------------------

--
-- Table structure for table `appetizers`
--

DROP TABLE IF EXISTS `appetizers`;
CREATE TABLE IF NOT EXISTS `appetizers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_2` (`id`),
  KEY `id` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `appetizers`
--

INSERT INTO `appetizers` (`id`, `name`, `description`, `price`) VALUES
(1, 'חומוס', 'חומוס תוצרת בית: כולל צנוברים ושמן זית', 30),
(2, 'טחינה', 'עם שמן זית טרי ולחם כפרי', 30),
(3, 'חומס עם גרגירים', 'החומוס המעולה שלנו בתוספת גרגירי חומס מדהימים', 35),
(4, 'חומוס עם בשר', 'כמו החומוס הרגיל רק יותר טוב', 42),
(5, 'פטריות על האש', 'פטריות שמפיניון צלויות על האש ברוטב פיקנטי', 37),
(6, 'ציפס קטן', 'ציפס מוכן רגיל בכמות סבירה', 15),
(7, 'ציפס גדול', 'כמו הקטן רק גדול יותר', 27),
(8, 'כדורי פלאפל', 'מוכן במקום טרי טרי', 23);

-- --------------------------------------------------------

--
-- Table structure for table `breakfast`
--

DROP TABLE IF EXISTS `breakfast`;
CREATE TABLE IF NOT EXISTS `breakfast` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET hebrew NOT NULL,
  `description` varchar(255) CHARACTER SET hebrew COLLATE hebrew_bin NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_2` (`id`),
  KEY `id` (`id`),
  KEY `id_3` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `breakfast`
--

INSERT INTO `breakfast` (`id`, `name`, `description`, `price`) VALUES
(1, 'בוקר זוגי', 'כולל 5 סוגי סלט', 120),
(2, 'בוקר ישראלי', 'כולל 4 סוגי גבינות, 2 לחמים, 5 מתבלים', 60),
(3, 'השקשוקה שלנו', 'מוגש בתוספת סלט בוקר, זיתים, טחינה ולחמניית חלה', 42),
(4, 'המוזלי שלנו', 'יוגורט, גרנולה, פירות העונה ודבש', 37),
(5, 'בוקר בקטנה', 'חצי כריך חביתה עם טונה בתוספת סלט קטן וקפה', 29),
(6, 'בוקר גלילי', 'ביצת עין, סלט קצוץ, מוגשים על פוקא\'צה עם טחינה.', 52);

-- --------------------------------------------------------

--
-- Table structure for table `cold_drinks`
--

DROP TABLE IF EXISTS `cold_drinks`;
CREATE TABLE IF NOT EXISTS `cold_drinks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_3` (`id`),
  KEY `id` (`id`),
  KEY `id_2` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `cold_drinks`
--

INSERT INTO `cold_drinks` (`id`, `name`, `description`, `price`) VALUES
(1, 'סודה', 'סודה בטעם לימון', 11),
(2, 'מים מינרליים', 'סן בנדטו', 10),
(3, 'קוקה קולה', 'בקבוק 0.5 ליטר', 12),
(4, 'פאנטה', 'בטעם תפוז מוגז', 12),
(5, 'תפוזים פריגת', 'סחוט טרי טרי', 14),
(6, 'ענבים פריגת', 'סחוט טרי טרי', 14),
(7, 'אשכוליות פרימור', 'משקה דיאט', 11),
(8, 'בירה שחורה', 'נשר מאלט', 12);

-- --------------------------------------------------------

--
-- Table structure for table `desserts`
--

DROP TABLE IF EXISTS `desserts`;
CREATE TABLE IF NOT EXISTS `desserts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_2` (`id`),
  KEY `id` (`id`),
  KEY `id_3` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `desserts`
--

INSERT INTO `desserts` (`id`, `name`, `description`, `price`) VALUES
(1, 'כנאפה', 'מוכן במקום עם רוטב סודי', 26),
(2, 'מגדל שחיתות', 'וופל בריסל בלגי עם רוטב טופי, שוקולד חלב, ממרח שוקולד', 52),
(3, 'בקלוואה', '8 יחידות מוגשים עם סירופ סוכר', 17),
(4, 'חגיגה לבנה של פעם', 'עוגת גבינה אפויה עם פירות יער, קצפת ושטרוייזל', 28);

-- --------------------------------------------------------

--
-- Table structure for table `main_dish`
--

DROP TABLE IF EXISTS `main_dish`;
CREATE TABLE IF NOT EXISTS `main_dish` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_3` (`id`),
  KEY `id` (`id`),
  KEY `id_2` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `main_dish`
--

INSERT INTO `main_dish` (`id`, `name`, `description`, `price`) VALUES
(1, 'אנטריקוט עם עצם', 'אנטריקוט ישראלי משובח ומעושן. המחיר הוא ל- 100 גרם', 35),
(2, 'סטייק פרגית בטריאקי', 'סטייק פרגית ברוטב טריאקי מוגש עם תוספת לבחירה', 76),
(3, 'מעורב ירושלמי', 'מיקס בשרים איכותיים', 77),
(4, 'שווארמה פרגית ופפריקה', 'חיטה ירוקה, ירקות שורש, כמון ועשבי תיבול', 56),
(5, 'מיני המבורגר', 'שלושה מיני המבורגר בקר, חסה, עגבניה, בצד ומלפפון.', 56),
(6, 'נקניקיות טלה חריפות', 'צלויות על האש לטעם מהחיים', 54),
(7, 'שניצל הבית', 'חזה עוף בציפוי פריך מוגש עם תוספת לבחירה', 35);

-- --------------------------------------------------------

--
-- Table structure for table `salads`
--

DROP TABLE IF EXISTS `salads`;
CREATE TABLE IF NOT EXISTS `salads` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_2` (`id`),
  KEY `id` (`id`),
  KEY `id_3` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=hebrew;

--
-- Dumping data for table `salads`
--

INSERT INTO `salads` (`id`, `name`, `description`, `price`) VALUES
(1, 'סלט בריאות', 'חסה, קינואה, כרוב אדום, עגבניות שרי..', 44),
(2, 'סלט ניסואז לימוני', 'חסה, עגבניה, עגבניות שרי, רוקט, ותערובת פטרוזיליה', 45),
(3, 'איכרים איטלקי', 'עגבניות, פלפל קלוי, עגבניות שרי, בצל סגול, חסה ורוקט', 56),
(4, 'סלט ים תיכוני', 'עגבניות שרי, עגבניה, מלפפונים, פלפלים צבעוניים וחסה', 47),
(5, 'סלט עוף', 'בורגול, קינואה ותערובת פטרוזיליה, גרגרי חומוס ואבוקדו.', 66);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(255) NOT NULL,
  `l_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_2` (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `id_3` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `f_name`, `l_name`, `email`, `password`) VALUES
(1, 'test', '11', '123', 'aksdlj21'),
(2, 'asdsa', '12', '1233', '111'),
(3, 'shai', 'miz', 'shai@gmail.com', '123132'),
(4, 'tom', 'sony', 'tom@gmail.com', '123tom'),
(5, '12', '331', '11', '123'),
(6, '3', '22', '111', '1321');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

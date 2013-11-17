/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2013-11-03 10:56:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_number` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '图书号',
  `book_name` varchar(20) DEFAULT NULL COMMENT '书名',
  `author` varchar(200) DEFAULT NULL COMMENT '作者',
  `publisher` varchar(20) DEFAULT NULL COMMENT '出版社',
  `publish_date` datetime DEFAULT NULL COMMENT '出版日期',
  `price` decimal(10,0) DEFAULT NULL COMMENT '单价',
  `book_type` varchar(30) DEFAULT NULL,
  `store_location` varchar(30) DEFAULT NULL COMMENT '存放位置',
  `store_date` datetime DEFAULT NULL COMMENT '入库日期',
  `borrowed_number` int(11) DEFAULT NULL COMMENT '借出数量',
  `number` int(11) DEFAULT NULL COMMENT '图书数量',
  PRIMARY KEY (`book_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1088045', 'Windows核心编程', 'Jeffrey Richter', '机械工业出版社', '2000-06-26 14:03:26', '86', '经济学', 'A30', '2013-10-26 14:03:26', '1', '1');
INSERT INTO `book` VALUES ('1139336', 'C程序设计语言', '（美）Brian W. Kernighan （美）Dennis M. Ritchie', '机械工业出版社', '2004-03-27 00:22:54', '30', '编程', 'A90', '2013-10-27 14:22:47', null, '4');
INSERT INTO `book` VALUES ('1148282', '计算机程序的构造和解释', 'Harold Abelson Gerald Jay Sussman Julie Sussman', '机械工业出版社', '2004-03-27 00:21:24', '45', '经济学', 'B10', '2013-10-27 00:21:24', '0', '2');
INSERT INTO `book` VALUES ('1477390', '代码大全（第2版）', '[美] 史蒂夫·迈克康奈尔', '电子工业出版社', '2006-04-27 00:22:06', '128', '编程', 'B10', '2013-10-27 00:22:06', '0', '3');
INSERT INTO `book` VALUES ('1885170', '算法导论', '[美] Thomas H.Cormen Charles E.Leiserson Ronald L.Rivest Clifford Stein', '机械工业出版社', '2006-10-23 23:28:48', '85', '编程', '111', '2013-10-23 23:28:48', '5', '10');
INSERT INTO `book` VALUES ('3004255', '编程之美', '《编程之美》小组 编', '电子工业出版社', '2008-04-26 14:03:55', '40', '经济学', 'A31', '2013-10-26 14:03:55', '0', '1');
INSERT INTO `book` VALUES ('3112503', 'Python核心编程（第二版）', '[美]Wesley J. Chun（陳仲才）', '人民邮电出版社', '2008-07-26 14:02:19', '89', '编程', 'A20', '2013-10-26 14:02:19', '0', '2');
INSERT INTO `book` VALUES ('3561811', '大学物理学', '张三慧', '清华大学出版社', '2009-03-24 13:38:41', '38', '编程', 'A-1-002', '2013-10-24 13:38:41', '0', '1');
INSERT INTO `book` VALUES ('4200822', 'Android应用开发揭秘', '杨丰盛', '机械工业出版社', '2010-02-24 13:30:25', '69', '编程', 'A-1-01', '2013-10-24 13:30:25', '0', '10');
INSERT INTO `book` VALUES ('5338024', '与孩子一起学编程', '[美] 桑德Warren Sande Carter Sande', '人民邮电出版社', '2010-12-26 14:02:58', '65', '编程', 'A20', '2013-10-26 14:02:58', '0', '3');
INSERT INTO `book` VALUES ('5399293', 'JavaEE程序设计与应用开发', '郭克华 编', '清华大学', '2011-02-28 21:29:01', '32', '编程', 'A20', '2013-10-28 21:29:01', '0', '10');

-- ----------------------------
-- Table structure for `booktype`
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype` (
  `type` varchar(255) NOT NULL COMMENT '图书类别',
  `borrow_day` int(11) NOT NULL COMMENT '可借天数',
  `day_fine` decimal(10,0) DEFAULT NULL COMMENT '图书超期每天罚款金额',
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES ('经济学', '30', '1');
INSERT INTO `booktype` VALUES ('编程', '30', '1');

-- ----------------------------
-- Table structure for `borrow`
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `borrower_number` decimal(10,0) NOT NULL COMMENT '借阅卡号',
  `book_number` decimal(10,0) NOT NULL COMMENT '图书号',
  `borrower_name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `book_name` varchar(20) DEFAULT NULL COMMENT '书名',
  `return_date` datetime DEFAULT NULL COMMENT '实际归还日期',
  `borrowed_date` datetime DEFAULT NULL COMMENT '借出日期',
  `fine` decimal(10,0) DEFAULT NULL COMMENT '罚款'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('2', '4200822', '陈洪晶', 'Android应用开发揭秘', '2013-10-26 01:59:43', '2013-10-25 13:57:57', '0');
INSERT INTO `borrow` VALUES ('100', '101', '陈洪晶', '设计模式', null, '2013-11-19 00:00:00', null);
INSERT INTO `borrow` VALUES ('101', '101', '谭苑霞', '设计模式', '2013-10-21 00:34:42', '2013-09-19 00:00:00', '2');
INSERT INTO `borrow` VALUES ('2', '1088045', '陈洪晶', 'Windows核心编程', null, '2013-10-28 21:31:56', null);

-- ----------------------------
-- Table structure for `borrower`
-- ----------------------------
DROP TABLE IF EXISTS `borrower`;
CREATE TABLE `borrower` (
  `card_number` decimal(10,0) NOT NULL COMMENT '借阅卡号',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` varchar(5) NOT NULL COMMENT '性别',
  `id_card_number` varchar(30) NOT NULL COMMENT '身份证号码',
  `work_place` varchar(30) DEFAULT NULL COMMENT '单位',
  `address` varchar(30) DEFAULT NULL COMMENT '家庭住址',
  `phone` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `type` varchar(30) NOT NULL COMMENT '借阅者类别',
  `create_time` datetime NOT NULL COMMENT '办证日期',
  `borrowed` int(11) DEFAULT '0' COMMENT '已借书数目',
  `is_lost` int(11) DEFAULT '0' COMMENT '是否挂失\r\n1、挂失\r\n0、未挂失',
  PRIMARY KEY (`card_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrower
-- ----------------------------
INSERT INTO `borrower` VALUES ('2', '陈洪晶', '男', '440782199109133911', '五邑大学', '五邑大学', '13750376797', '超级会员', '2013-10-20 00:00:00', '6', '0');
INSERT INTO `borrower` VALUES ('3', '谭苑霞', '女', '1', '五邑大学', '五邑大学', '121212', '普通会员', '2013-10-24 00:32:50', '0', '0');
INSERT INTO `borrower` VALUES ('4', '小苑', '女', '440782199105270458', '五邑大学', '女生宿舍27幢', '13750371111', '普通会员', '2013-10-24 13:11:08', '0', '0');
INSERT INTO `borrower` VALUES ('5', 'ddd', '男', '11111', 'ddd', 'wyu', '12', '普通会员', '2013-10-28 21:26:49', '0', '0');

-- ----------------------------
-- Table structure for `borrowertype`
-- ----------------------------
DROP TABLE IF EXISTS `borrowertype`;
CREATE TABLE `borrowertype` (
  `type` varchar(20) NOT NULL COMMENT '借阅者类型',
  `borrow_number` int(11) NOT NULL COMMENT '能借出书的数量',
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowertype
-- ----------------------------
INSERT INTO `borrowertype` VALUES ('普通会员', '5');
INSERT INTO `borrowertype` VALUES ('超级会员', '10');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `is_admin` int(11) DEFAULT NULL COMMENT '是否是管理员',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('eleven', '123', '1');
INSERT INTO `user` VALUES ('hello', '123', '1');
INSERT INTO `user` VALUES ('nono', '123', '1');
INSERT INTO `user` VALUES ('NovemberEleven', '123', '1');
INSERT INTO `user` VALUES ('skyhacker', '123', '1');
INSERT INTO `user` VALUES ('xiaoyuan', '123', '1');

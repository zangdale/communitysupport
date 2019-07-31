/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : didi

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2019-07-31 20:27:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_text` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `a_questionid` int(11) NOT NULL,
  `a_userid` int(11) NOT NULL,
  `a_date` datetime NOT NULL,
  PRIMARY KEY (`a_id`),
  KEY `a_userid` (`a_userid`),
  KEY `a_questionid` (`a_questionid`),
  CONSTRAINT `a_questionid` FOREIGN KEY (`a_questionid`) REFERENCES `question` (`q_id`),
  CONSTRAINT `a_userid` FOREIGN KEY (`a_userid`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of answer
-- ----------------------------
INSERT INTO `answer` VALUES ('1', '水电费水电费水电费', '1', '4', '2019-07-16 15:22:24');
INSERT INTO `answer` VALUES ('2', '发生的股份', '2', '5', '2019-07-24 15:22:38');
INSERT INTO `answer` VALUES ('3', '好久好久军或或或或', '1', '3', '2019-07-29 15:22:54');
INSERT INTO `answer` VALUES ('4', '奥斯卡就都不卡手机绑定卡萨九点半', '2', '3', '2019-07-30 08:33:52');

-- ----------------------------
-- Table structure for blood
-- ----------------------------
DROP TABLE IF EXISTS `blood`;
CREATE TABLE `blood` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT,
  `b_userid` int(11) NOT NULL,
  `b_number` int(10) unsigned zerofill NOT NULL,
  `b_date` datetime NOT NULL,
  PRIMARY KEY (`b_id`),
  KEY `b_userid` (`b_userid`),
  CONSTRAINT `b_userid` FOREIGN KEY (`b_userid`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of blood
-- ----------------------------
INSERT INTO `blood` VALUES ('1', '1', '0000000070', '2019-07-27 15:23:14');
INSERT INTO `blood` VALUES ('2', '1', '0000000075', '2019-07-28 15:23:22');
INSERT INTO `blood` VALUES ('3', '1', '0000000080', '2019-07-29 15:23:37');
INSERT INTO `blood` VALUES ('4', '1', '0000000079', '2019-07-30 16:12:39');
INSERT INTO `blood` VALUES ('5', '1', '0000000078', '2019-07-31 16:12:56');

-- ----------------------------
-- Table structure for ill
-- ----------------------------
DROP TABLE IF EXISTS `ill`;
CREATE TABLE `ill` (
  `i_id` int(11) NOT NULL AUTO_INCREMENT,
  `i_userid` int(11) NOT NULL,
  `i_title` varchar(255) COLLATE utf8_bin NOT NULL,
  `i_date` datetime NOT NULL,
  PRIMARY KEY (`i_id`),
  KEY `i_userid` (`i_userid`),
  CONSTRAINT `i_userid` FOREIGN KEY (`i_userid`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ill
-- ----------------------------
INSERT INTO `ill` VALUES ('1', '1', '232323', '2019-07-22 15:24:28');
INSERT INTO `ill` VALUES ('2', '2', '34让我发斯蒂芬', '2019-07-25 15:24:38');
INSERT INTO `ill` VALUES ('3', '1', '第三方第三方', '2019-07-24 15:24:47');
INSERT INTO `ill` VALUES ('4', '3', '的范德萨发', '2019-07-24 15:24:57');

-- ----------------------------
-- Table structure for jump
-- ----------------------------
DROP TABLE IF EXISTS `jump`;
CREATE TABLE `jump` (
  `j_id` int(11) NOT NULL AUTO_INCREMENT,
  `j_userid` int(11) NOT NULL,
  `j_number` int(10) unsigned zerofill NOT NULL,
  `j_date` datetime NOT NULL,
  PRIMARY KEY (`j_id`),
  KEY `j_userid` (`j_userid`),
  CONSTRAINT `j_userid` FOREIGN KEY (`j_userid`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of jump
-- ----------------------------
INSERT INTO `jump` VALUES ('1', '1', '0000000120', '2019-07-27 15:25:11');
INSERT INTO `jump` VALUES ('2', '1', '0000000125', '2019-07-28 15:25:19');
INSERT INTO `jump` VALUES ('3', '1', '0000000130', '2019-07-29 15:25:27');
INSERT INTO `jump` VALUES ('4', '1', '0000000126', '2019-07-30 15:25:35');
INSERT INTO `jump` VALUES ('5', '1', '0000000128', '2019-07-31 16:14:40');

-- ----------------------------
-- Table structure for keepage
-- ----------------------------
DROP TABLE IF EXISTS `keepage`;
CREATE TABLE `keepage` (
  `k_id` int(11) NOT NULL AUTO_INCREMENT,
  `k_userid` int(11) NOT NULL,
  `k_number` int(10) unsigned zerofill NOT NULL,
  `k_date` datetime NOT NULL,
  PRIMARY KEY (`k_id`),
  KEY `k_userid` (`k_userid`),
  CONSTRAINT `k_userid` FOREIGN KEY (`k_userid`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of keepage
-- ----------------------------
INSERT INTO `keepage` VALUES ('1', '1', '0000000100', '2019-07-27 15:25:52');
INSERT INTO `keepage` VALUES ('2', '1', '0000000095', '2019-07-28 15:26:01');
INSERT INTO `keepage` VALUES ('3', '1', '0000000098', '2019-07-29 15:26:14');
INSERT INTO `keepage` VALUES ('4', '1', '0000000095', '2019-07-30 16:14:03');
INSERT INTO `keepage` VALUES ('5', '1', '0000000094', '2019-07-31 16:14:18');

-- ----------------------------
-- Table structure for onebank
-- ----------------------------
DROP TABLE IF EXISTS `onebank`;
CREATE TABLE `onebank` (
  `o_id` int(11) NOT NULL AUTO_INCREMENT,
  `o_title` varchar(255) COLLATE utf8_bin NOT NULL,
  `o_answer1` varchar(255) COLLATE utf8_bin NOT NULL,
  `o_answer2` varchar(255) COLLATE utf8_bin NOT NULL,
  `o_answer3` varchar(255) COLLATE utf8_bin NOT NULL,
  `o_right` int(11) NOT NULL,
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of onebank
-- ----------------------------
INSERT INTO `onebank` VALUES ('1', '所具备的可我就不付款', '凄凄切切', '快快快', '快快快', '1');
INSERT INTO `onebank` VALUES ('2', '第三方看美女', '离开了', '2222', '22', '2');
INSERT INTO `onebank` VALUES ('3', '经理看好你看见你', '来看你了看见你', '加快了节能', '离开那里可能', '2');
INSERT INTO `onebank` VALUES ('4', '空间和个别地方警察吧', '金花南路看见你', '了看见那看来今年', '看见那里看见', '3');
INSERT INTO `onebank` VALUES ('5', '尽可能看见你', '看见那看来今年', '看见你了;疬o', '没了', '2');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `q_id` int(11) NOT NULL AUTO_INCREMENT,
  `q_title` varchar(255) COLLATE utf8_bin NOT NULL,
  `q_text` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `q_userid` int(11) NOT NULL,
  `q_date` datetime NOT NULL,
  PRIMARY KEY (`q_id`),
  KEY `q_userid` (`q_userid`),
  CONSTRAINT `q_userid` FOREIGN KEY (`q_userid`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '哈哈哈哈', '安可设计都不卡级别', '1', '2019-07-30 15:20:24');
INSERT INTO `question` VALUES ('2', '杀得快你妈来说可能的', '了看见那对方开出今年', '2', '2019-07-30 15:20:35');
INSERT INTO `question` VALUES ('3', '地方都是可麻烦了', '吗', '1', '2019-07-30 15:20:49');
INSERT INTO `question` VALUES ('4', '撒大声地', 'dddd', '1', '2019-07-30 15:21:00');
INSERT INTO `question` VALUES ('5', '地方的工业化', ' 的范德萨发', '3', '2019-07-15 15:21:15');
INSERT INTO `question` VALUES ('6', '撒打发点', '啥都不干很过分', '4', '2019-07-25 15:21:26');
INSERT INTO `question` VALUES ('7', '撒地方师傅的说法', '对方受到广泛', '5', '2019-07-25 15:21:42');
INSERT INTO `question` VALUES ('8', '面授阶段你快来', '暗示领导讲话哪款手机绑定卡经常放苦啊', '1', '2019-07-30 07:41:00');
INSERT INTO `question` VALUES ('9', '哈哈哈', 'hhhh', '1', '2019-07-30 07:44:36');
INSERT INTO `question` VALUES ('10', '花开时接电话', 'hhhh', '1', '2019-07-30 07:48:42');
INSERT INTO `question` VALUES ('11', '测试发帖', '测试kdjla阿斯顿撒多', '6', '2019-07-30 12:38:40');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_account` varchar(255) COLLATE utf8_bin NOT NULL,
  `u_passwd` varchar(255) COLLATE utf8_bin NOT NULL,
  `u_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `u_age` int(10) unsigned zerofill NOT NULL,
  `u_tel` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `u_oldtype` varchar(255) COLLATE utf8_bin NOT NULL,
  `u_type` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', 'hello1', '0000000001', '1', '1', '1');
INSERT INTO `user` VALUES ('2', '2', '2', 'hello2', '0000000002', '2', '2', '2');
INSERT INTO `user` VALUES ('3', '3', '3', 'hello3', '0000000003', '3', '33', '3');
INSERT INTO `user` VALUES ('4', '4', '4', '4', '0000000001', '1', '1', '1');
INSERT INTO `user` VALUES ('5', '0', '0', '5', '0000000000', '0', '0', '0');
INSERT INTO `user` VALUES ('6', '121', '121', '6', '0000000001', '121', '家庭', '患者');

-- ----------------------------
-- Table structure for video
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `v_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `v_type` varchar(255) COLLATE utf8_bin NOT NULL,
  `v_imageurl` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `v_url` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '美英驻伊拉克大使馆遭火箭弹袭击 火箭弹发射器被找到', '少儿', 'http://i1.hdslb.com/bfs/archive/2b29c44caf614c2ba7e58f90f3c7b230aa2eb971.jpg', 'https://www.bilibili.com/video/av53136345');
INSERT INTO `video` VALUES ('2', '美英驻伊拉克大使馆遭火箭弹袭击 火箭弹发射器被找到', '成年', 'http://i1.hdslb.com/bfs/archive/16f0d23ff9f9333a28dba9460280d81525128972.jpg', 'https://www.bilibili.com/video/av53230877');
INSERT INTO `video` VALUES ('3', '《面对面》独家专访任正非：胜利一定属于华为', '老人', 'http://i2.hdslb.com/bfs/archive/405d564434cd86a13643a02ec633f222e03850e4.jpg', 'https://www.bilibili.com/video/av53742823');

-- ----------------------------
-- Table structure for weight
-- ----------------------------
DROP TABLE IF EXISTS `weight`;
CREATE TABLE `weight` (
  `w_id` int(11) NOT NULL AUTO_INCREMENT,
  `w_userid` int(11) NOT NULL,
  `w_number` int(10) unsigned zerofill NOT NULL,
  `w_date` datetime NOT NULL,
  PRIMARY KEY (`w_id`),
  KEY `w_userid` (`w_userid`),
  CONSTRAINT `w_userid` FOREIGN KEY (`w_userid`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of weight
-- ----------------------------
INSERT INTO `weight` VALUES ('1', '1', '0000000065', '2019-07-27 16:15:17');
INSERT INTO `weight` VALUES ('2', '1', '0000000066', '2019-07-28 16:15:02');
INSERT INTO `weight` VALUES ('3', '1', '0000000065', '2019-07-29 15:29:02');
INSERT INTO `weight` VALUES ('4', '1', '0000000065', '2019-07-30 15:29:12');
INSERT INTO `weight` VALUES ('5', '1', '0000000064', '2019-07-31 15:29:20');

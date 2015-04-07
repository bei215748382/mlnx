/*
Navicat MySQL Data Transfer

Source Server         : mlnx
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : mlnx

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2015-03-26 13:32:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `banner`
-- ----------------------------
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `bId` int(11) NOT NULL auto_increment,
  `banImg` varchar(50) default NULL,
  `banSize` varchar(50) default NULL,
  `banStatus` int(11) default NULL,
  PRIMARY KEY  (`bId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banner
-- ----------------------------

-- ----------------------------
-- Table structure for `contact`
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` (
  `ctId` int(11) NOT NULL auto_increment,
  `ctPhone` varchar(50) default NULL,
  `ctAdress` varchar(50) default NULL,
  `ctEmail` varchar(50) default NULL,
  `ctFax` int(11) default NULL,
  PRIMARY KEY  (`ctId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contact
-- ----------------------------

-- ----------------------------
-- Table structure for `content`
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `cId` int(11) NOT NULL auto_increment,
  `conTitle` varchar(50) default NULL,
  `conImg` varchar(50) default NULL,
  `conText` varchar(200) default NULL,
  PRIMARY KEY  (`cId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of content
-- ----------------------------

-- ----------------------------
-- Table structure for `copyright`
-- ----------------------------
DROP TABLE IF EXISTS `copyright`;
CREATE TABLE `copyright` (
  `cpId` int(11) NOT NULL auto_increment,
  `cpDetail` varchar(2000) default NULL,
  `cpStatus` int(11) default NULL,
  PRIMARY KEY  (`cpId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of copyright
-- ----------------------------
INSERT INTO `copyright` VALUES ('2', '<p class=\"c999 lh24 txtcenter\" style=\"margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-align: center; line-height: 24px; font-family: tahoma, 微软雅黑; font-size: 12px; background-color: rgb(249, 250, 250);\">CopyRight© 2002-2014 Inc.All Rights Reserved 猫扑网 版权所有</p><p class=\"c999 lh24 txtcenter\" style=\"margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-align: center; line-height: 24px; font-family: tahoma, 微软雅黑; font-size: 12px; background-color: rgb(249, 250, 250);\"><a class=\"c999\" href=\"http://i4.mopimg.cn/img/dzh/wenwangwen.jpg\" target=\"_blank\" style=\"margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-decoration: none;\">桂网文[2013]第0738-002号</a>　桂B2-20130006</p><p class=\"c999 lh24 txtcenter\" style=\"margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-align: center; line-height: 24px; font-family: tahoma, 微软雅黑; font-size: 12px; background-color: rgb(249, 250, 250);\">文化部监督电子邮箱:wlwh@vip.sina.com　违法和不良信息举报电话：0771－5086886转</p>', '0');
INSERT INTO `copyright` VALUES ('3', '<p class=\"c999 lh24 txtcenter\" style=\"text-align: right; margin: 0px; padding: 0px; color: rgb(153, 153, 153); line-height: 24px; font-family: tahoma, 微软雅黑; font-size: 12px; background-color: rgb(249, 250, 250);\">CopyRight© 2002-2014 Inc.All Rights Reserved 猫扑网 版权所有</p><p class=\"c999 lh24 txtcenter\" style=\"text-align: right; margin: 0px; padding: 0px; color: rgb(153, 153, 153); line-height: 24px; font-family: tahoma, 微软雅黑; font-size: 12px; background-color: rgb(249, 250, 250);\"><a class=\"c999\" href=\"http://i4.mopimg.cn/img/dzh/wenwangwen.jpg\" target=\"_blank\" style=\"margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-decoration: none;\">桂网文[2013]第0738-002号</a>　桂B2-20130006</p><p class=\"c999 lh24 txtcenter\" style=\"text-align: right; margin: 0px; padding: 0px; color: rgb(153, 153, 153); line-height: 24px; font-family: tahoma, 微软雅黑; font-size: 12px; background-color: rgb(249, 250, 250);\">文化部监督电子邮箱:wlwh@vip.sina.com　违法和不良信息举报电话：0771－5086886转5326（周一至周五：9：00－18：00）</p>', '1');
INSERT INTO `copyright` VALUES ('4', '<p class=\"c999 lh24 txtcenter\" style=\"margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-align: center; line-height: 24px; font-family: tahoma, 微软雅黑; font-size: 12px; background-color: rgb(249, 250, 250);\">CopyRight© 2002-2014 Inc.All Rights Reserved 猫扑网 版权所有</p><p class=\"c999 lh24 txtcenter\" style=\"margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-align: center; line-height: 24px; font-family: tahoma, 微软雅黑; font-size: 12px; background-color: rgb(249, 250, 250);\"><a class=\"c999\" href=\"http://i4.mopimg.cn/img/dzh/wenwangwen.jpg\" target=\"_blank\" style=\"margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-decoration: none;\">桂网文[2013]第0738-002号</a>　桂B2-20130006</p><p class=\"c999 lh24 txtcenter\" style=\"margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-align: center; line-height: 24px; font-family: tahoma, 微软雅黑; font-size: 12px; background-color: rgb(249, 250, 250);\">文化部监督电子邮箱:wlwh@vip.sina.com　违法和不良信息举报电话：0771－5086886转5326（周一至周五：9：00－18：00）</p><p class=\"c999 lh24 txtcenter\" style=\"margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-align: center; line-height: 24px; font-family: tahoma, 微软雅黑; font-size: 12px; background-color: rgb(249, 250, 250);\">举报邮箱:jubao@opi-corp.com</p>', '0');
INSERT INTO `copyright` VALUES ('5', '<p class=\"c999 lh24 txtcenter\" style=\"font-family: tahoma, 微软雅黑; font-weight: normal; font-style: normal; margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-align: center; line-height: 24px; font-size: 12px; background-color: rgb(249, 250, 250);\"><u>CopyRight© 2</u>002-2014 Inc.All Rights Reserved 猫扑网 版权所有</p><p class=\"c999 lh24 txtcenter\" style=\"font-family: tahoma, 微软雅黑; font-style: normal; margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-align: center; line-height: 24px; font-size: 12px; background-color: rgb(249, 250, 250);\"><a class=\"c999\" href=\"http://i4.mopimg.cn/img/dzh/wenwangwen.jpg\" target=\"_blank\" style=\"font-weight: normal; margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-decoration: none;\">桂网文[2013]第0738-002号</a>　<b>桂B2</b>-20130006</p><p class=\"c999 lh24 txtcenter\" style=\"font-family: tahoma, 微软雅黑; font-weight: normal; margin: 0px; padding: 0px; text-align: center; line-height: 24px; font-size: 12px;\"><span style=\"background-color: rgb(249, 250, 250);\"><font color=\"#999999\"><i>文化部监督</i>电子邮箱:wlwh@vip.sina.com　</font><font color=\"#ff0000\" style=\"font-style: normal;\">违法</font><font color=\"#999999\" style=\"font-style: normal;\">和不良信息举报电话：0771－5086886转5326（周一至周五：9：00－18</font></span><span style=\"font-style: normal; color: rgb(153, 153, 153); background-color: rgb(255, 153, 102);\">：00）</span></p><p class=\"c999 lh24 txtcenter\" style=\"font-weight: normal; font-style: normal; margin: 0px; padding: 0px; color: rgb(153, 153, 153); text-align: center; line-height: 24px; font-size: 12px; background-color: rgb(249, 250, 250);\"><strike><font face=\"Sans Serif\">举报邮箱</font></strike><font face=\"tahoma, 微软雅黑\">:jubao@opi-corp.com</font></p>', '0');

-- ----------------------------
-- Table structure for `header`
-- ----------------------------
DROP TABLE IF EXISTS `header`;
CREATE TABLE `header` (
  `hId` int(11) NOT NULL auto_increment,
  `logoImg` varchar(50) default NULL,
  `comName` varchar(50) default NULL,
  `logoSize` varchar(50) default NULL,
  `headerStatus` int(11) default NULL,
  PRIMARY KEY  (`hId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of header
-- ----------------------------
INSERT INTO `header` VALUES ('1', '1427347818637.png', '宁波美灵思医疗科技有限公司', '245px*89px', '0');

-- ----------------------------
-- Table structure for `link`
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `lId` int(11) NOT NULL auto_increment,
  `linkName` varchar(50) default NULL,
  `linkUrl` varchar(50) default NULL,
  `linkStatus` int(11) default NULL,
  PRIMARY KEY  (`lId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of link
-- ----------------------------
INSERT INTO `link` VALUES ('1', '猫扑论坛', 'http://www.mop.com/', '1');
INSERT INTO `link` VALUES ('2', '魅族社区', 'http://bbs.meizu.cn/', '0');
INSERT INTO `link` VALUES ('3', '魔时网论坛', 'http://www.mosh.cn/', '0');
INSERT INTO `link` VALUES ('4', '分享工具代码', 'http://www.jiathis.com/getcode', '1');
INSERT INTO `link` VALUES ('6', 'bootstrap3.0学习', 'http://www.cnblogs.com/aehyok/p/3381651.html', '0');

-- ----------------------------
-- Table structure for `navigation`
-- ----------------------------
DROP TABLE IF EXISTS `navigation`;
CREATE TABLE `navigation` (
  `nId` int(11) NOT NULL auto_increment,
  `navName` varchar(50) default NULL,
  `navStatus` int(11) default NULL,
  PRIMARY KEY  (`nId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of navigation
-- ----------------------------
INSERT INTO `navigation` VALUES ('1', '公司简介', '1');
INSERT INTO `navigation` VALUES ('2', '产品介绍', '0');
INSERT INTO `navigation` VALUES ('3', '人才招聘', '0');
INSERT INTO `navigation` VALUES ('4', '联系我们', '1');
INSERT INTO `navigation` VALUES ('6', '论坛交流', '0');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pId` int(11) NOT NULL auto_increment,
  `pduName` varchar(50) default NULL,
  `pduImg` varchar(50) default NULL,
  `pduDetail` varchar(200) default NULL,
  `pduStatus` int(11) default NULL,
  PRIMARY KEY  (`pId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for `qrcode`
-- ----------------------------
DROP TABLE IF EXISTS `qrcode`;
CREATE TABLE `qrcode` (
  `qId` int(11) NOT NULL auto_increment,
  `qrName` varchar(50) default NULL,
  `qrImg` varchar(50) default NULL,
  `qrSize` varchar(50) default NULL,
  `qrStatus` int(11) default NULL,
  PRIMARY KEY  (`qId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrcode
-- ----------------------------

-- ----------------------------
-- Table structure for `recruitment`
-- ----------------------------
DROP TABLE IF EXISTS `recruitment`;
CREATE TABLE `recruitment` (
  `rId` int(11) NOT NULL auto_increment,
  `recruitPost` varchar(50) default NULL,
  `recruitDuty` varchar(500) default NULL,
  `recruitClaim` varchar(200) default NULL,
  PRIMARY KEY  (`rId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recruitment
-- ----------------------------

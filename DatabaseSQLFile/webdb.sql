/*
Navicat MySQL Data Transfer

Source Server         : 106.12.40.123
Source Server Version : 80012
Source Host           : 106.12.40.123:3306
Source Database       : webdb

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2018-10-26 09:53:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `mailbox` varchar(255) DEFAULT NULL,
  `country` varchar(128) DEFAULT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '1',
  `givename` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'root', 'root', 'root@spdata.com', 'china', '1', '超级管理员', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3403293427,1009198645&fm=27&gp=0.jpg');
INSERT INTO `account` VALUES ('37', 'admin', 'admin', 'admin', 'china', '1', 'admin', null);
INSERT INTO `account` VALUES ('38', 'testaccount', 'testaccount', 'testaccount', 'china', '1', '测试账户', null);

-- ----------------------------
-- Table structure for `account_role`
-- ----------------------------
DROP TABLE IF EXISTS `account_role`;
CREATE TABLE `account_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='账户角色中间表';

-- ----------------------------
-- Records of account_role
-- ----------------------------
INSERT INTO `account_role` VALUES ('1', '1', '1');
INSERT INTO `account_role` VALUES ('2', '1', '2');
INSERT INTO `account_role` VALUES ('6', '37', '2');
INSERT INTO `account_role` VALUES ('7', '38', '2');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `icon` varchar(128) DEFAULT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '1',
  `sort` int(11) NOT NULL COMMENT '排序',
  `superior` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统管理', '/systemMG', '<i class=\"el-icon-share\"></i>', '1', '30', null);
INSERT INTO `menu` VALUES ('2', '用户管理', '/system/account', 'el-icon-star-on', '1', '10', '1');
INSERT INTO `menu` VALUES ('3', '角色管理', '/system/role', 'el-icon-star-on', '1', '20', '1');
INSERT INTO `menu` VALUES ('4', '权限管理', '/system/Permission', 'form', '1', '30', '1');
INSERT INTO `menu` VALUES ('5', '菜单管理', '/system/menu', null, '1', '40', '1');
INSERT INTO `menu` VALUES ('6', '测试菜单', '/test1', null, '0', '20', null);
INSERT INTO `menu` VALUES ('7', 'test', 'test', 'test', '0', '10', '1');
INSERT INTO `menu` VALUES ('8', 'test', 'test', 'test', '0', '111', '1');
INSERT INTO `menu` VALUES ('9', 'test', '/test', 'iio', '0', '10', null);
INSERT INTO `menu` VALUES ('10', 'aaa', 'aaa', 'aaa', '0', '1', '2');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '导出数据', 'OUTPUTDATA', '1');
INSERT INTO `permission` VALUES ('2', '超级管理员', 'ROOT', '1');
INSERT INTO `permission` VALUES ('3', '管理员', 'ADMIN', '1');
INSERT INTO `permission` VALUES ('4', '普通用户', 'USER', '1');
INSERT INTO `permission` VALUES ('5', 'VIP用户', 'VIP', '1');
INSERT INTO `permission` VALUES ('6', '导入数据', 'INTPUTDATA', '1');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '2018-09-03 08:37:12', '1');
INSERT INTO `role` VALUES ('2', '管理员', '2018-09-05 10:39:40', '1');
INSERT INTO `role` VALUES ('3', '测试1', '2018-10-16 00:12:04', '1');
INSERT INTO `role` VALUES ('4', '测试2', '2018-10-16 00:12:32', '1');

-- ----------------------------
-- Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='角色菜单中间表';

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('1', '4', '1');
INSERT INTO `role_menu` VALUES ('2', '2', '1');
INSERT INTO `role_menu` VALUES ('3', '3', '1');
INSERT INTO `role_menu` VALUES ('4', '5', '1');
INSERT INTO `role_menu` VALUES ('5', '1', '1');

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='角色权限中间表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('15', '2', '1');
INSERT INTO `role_permission` VALUES ('16', '4', '1');

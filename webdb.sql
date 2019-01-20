/*
Navicat MySQL Data Transfer

Source Server         : 106.12.40.123
Source Server Version : 80012
Source Host           : 106.12.40.123:3306
Source Database       : webdb

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2018-12-11 15:00:30
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
  `is_del` tinyint(4) NOT NULL DEFAULT '0',
  `givename` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'root', 'root', 'root@spdata.com', 'china', '0', '超级管理员', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3403293427,1009198645&fm=27&gp=0.jpg');
INSERT INTO `account` VALUES ('37', 'admin', 'admin', 'admin', 'china', '0', 'admin', null);
INSERT INTO `account` VALUES ('38', 'testaccount', 'testaccount', 'testaccount', 'china', '0', '测试账户', null);
INSERT INTO `account` VALUES ('39', 'test', 'test', 'test', 'china', '0', 'test', null);
INSERT INTO `account` VALUES ('40', 'aaa', 'aaa', 'aaa', 'china', '0', 'aaa', null);

-- ----------------------------
-- Table structure for `account_role`
-- ----------------------------
DROP TABLE IF EXISTS `account_role`;
CREATE TABLE `account_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='账户角色中间表';

-- ----------------------------
-- Records of account_role
-- ----------------------------
INSERT INTO `account_role` VALUES ('1', '1', '1');
INSERT INTO `account_role` VALUES ('2', '1', '2');
INSERT INTO `account_role` VALUES ('6', '37', '2');
INSERT INTO `account_role` VALUES ('7', '38', '2');
INSERT INTO `account_role` VALUES ('8', '39', '2');
INSERT INTO `account_role` VALUES ('9', '40', '2');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `icon` varchar(128) DEFAULT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '0',
  `sort` int(11) NOT NULL COMMENT '排序',
  `superior` int(11) DEFAULT NULL,
  `component` varchar(255) NOT NULL COMMENT '前端组件',
  `render` varchar(255) DEFAULT NULL COMMENT '渲染目标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '系统管理', '/systemMG', 'form', '0', '30', '0', 'layout/Layout', null);
INSERT INTO `menu` VALUES ('2', '用户管理', '/system/account', 'user', '0', '10', '1', 'account/index', null);
INSERT INTO `menu` VALUES ('3', '角色管理', '/system/role', 'form', '0', '20', '1', 'role/index', null);
INSERT INTO `menu` VALUES ('4', '权限管理', '/system/Permission', 'form', '0', '30', '1', 'Permission/index', null);
INSERT INTO `menu` VALUES ('5', '菜单管理', '/system/menu', 'tree', '0', '40', '1', 'menu/index', null);
INSERT INTO `menu` VALUES ('15', '系统工具', '/systool', 'sys', '0', '20', '0', '/log', null);
INSERT INTO `menu` VALUES ('16', '测试菜单-修改', '/test', 'test', '0', '10', '15', 'test', null);
INSERT INTO `menu` VALUES ('17', '测试菜单1-1', 'asdas', 'dwqdwq', '0', '10', '16', 'wqeqw', null);
INSERT INTO `menu` VALUES ('18', '测试菜单1-1-1', 'asdsa', 'sadas', '0', '1', '17', 'sadas', null);
INSERT INTO `menu` VALUES ('19', '测试菜单1-1-1-1', 'sad', 'sadas', '0', '1', '18', 'sadasd', null);

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '导出数据', 'OUTPUTDATA', '0');
INSERT INTO `permission` VALUES ('2', '超级管理员', 'ROOT', '0');
INSERT INTO `permission` VALUES ('3', '管理员', 'ADMIN', '0');
INSERT INTO `permission` VALUES ('4', '普通用户', 'USER', '0');
INSERT INTO `permission` VALUES ('5', 'VIP用户', 'VIP', '0');
INSERT INTO `permission` VALUES ('6', '导入数据', 'INTPUTDATA', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '2018-09-03 08:37:12', '0');
INSERT INTO `role` VALUES ('2', '管理员', '2018-09-05 10:39:40', '0');
INSERT INTO `role` VALUES ('3', '测试1', '2018-10-16 00:12:04', '0');
INSERT INTO `role` VALUES ('4', '测试2', '2018-10-16 00:12:32', '0');

-- ----------------------------
-- Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COMMENT='角色菜单中间表';

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES ('27', '1', '1');
INSERT INTO `role_menu` VALUES ('28', '2', '1');
INSERT INTO `role_menu` VALUES ('29', '3', '1');
INSERT INTO `role_menu` VALUES ('30', '4', '1');
INSERT INTO `role_menu` VALUES ('31', '5', '1');
INSERT INTO `role_menu` VALUES ('32', '16', '1');
INSERT INTO `role_menu` VALUES ('33', '17', '1');
INSERT INTO `role_menu` VALUES ('34', '15', '1');
INSERT INTO `role_menu` VALUES ('54', '1', '2');
INSERT INTO `role_menu` VALUES ('55', '2', '2');
INSERT INTO `role_menu` VALUES ('56', '4', '2');
INSERT INTO `role_menu` VALUES ('57', '15', '2');
INSERT INTO `role_menu` VALUES ('58', '16', '2');
INSERT INTO `role_menu` VALUES ('59', '17', '2');

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='角色权限中间表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('15', '2', '1');
INSERT INTO `role_permission` VALUES ('16', '4', '1');
INSERT INTO `role_permission` VALUES ('17', '3', '1');
INSERT INTO `role_permission` VALUES ('18', '5', '1');
INSERT INTO `role_permission` VALUES ('19', '6', '1');
INSERT INTO `role_permission` VALUES ('33', '1', '2');
INSERT INTO `role_permission` VALUES ('34', '3', '2');
INSERT INTO `role_permission` VALUES ('35', '5', '2');
INSERT INTO `role_permission` VALUES ('36', '6', '2');
INSERT INTO `role_permission` VALUES ('37', '4', '2');
DROP TRIGGER IF EXISTS `insertMenuTrigger`;
DELIMITER ;;
CREATE TRIGGER `insertMenuTrigger` AFTER INSERT ON `menu` FOR EACH ROW BEGIN
    insert into role_menu (role_id, menu_id) value (1, NEW.id);
  end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `deleteMenuTrigger`;
DELIMITER ;;
CREATE TRIGGER `deleteMenuTrigger` AFTER UPDATE ON `menu` FOR EACH ROW begin
    IF ((select menu.is_del from menu where id = OLD.id) = 1)
    then
      delete from role_menu where role_menu.menu_id = OLD.id;
    end if;
  end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `insertPermission`;
DELIMITER ;;
CREATE TRIGGER `insertPermission` AFTER INSERT ON `permission` FOR EACH ROW begin
    insert into role_permission(role_id,permission_id) value (1,NEW.id);
  end
;;
DELIMITER ;

/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : webdb

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 09/03/2019 17:11:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dept_id` int(11) NOT NULL COMMENT '部门ID',
  `mailbox` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `country` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT 0,
  `givename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` int(11) NULL DEFAULT NULL COMMENT '手机号码',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `account_username_uindex`(`username`) USING BTREE,
  UNIQUE INDEX `account_phone_uindex`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'root', 'root', 0, 'root@spdata.com', 'china', 0, '超级管理员', 'https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3403293427,1009198645&fm=27&gp=0.jpg', NULL);
INSERT INTO `account` VALUES (44, 'testuser', 'testuser', 10, 'testuser', 'testuser', 0, 'testuser', NULL, NULL);
INSERT INTO `account` VALUES (45, 'spdata-admin', 'spdata-admin', 5, '1114923161@16', 'china1', 0, 'SpdataAdmin', NULL, NULL);
INSERT INTO `account` VALUES (46, 'Eca71knEe', 'Eca71knEe', 2, 'Eca71knEe', 'Eca71knEe', 0, '彭于晏', NULL, NULL);
INSERT INTO `account` VALUES (47, 'LboKZ9uMW', 'LboKZ9uMW', 3, 'LboKZ9uMW', 'LboKZ9uMW', 0, '苍井空', NULL, NULL);
INSERT INTO `account` VALUES (48, 'CgugK8KUv', 'CgugK8KUv', 10, 'CgugK8KUv', 'CgugK8KUv', 0, '波多野菊衣', NULL, NULL);
INSERT INTO `account` VALUES (49, 'tiBh1VfRC', 'tiBh1VfRC', 4, 'tiBh1VfRC', 'tiBh1VfRC', 0, '大桥未久', NULL, NULL);
INSERT INTO `account` VALUES (50, 'LboKZ9uMW1', 'LboKZ9uMW1', 5, 'LboKZ9uMW1', 'LboKZ9uMW1', 0, 'LboKZ9uMW1', NULL, NULL);

-- ----------------------------
-- Table structure for account_role
-- ----------------------------
DROP TABLE IF EXISTS `account_role`;
CREATE TABLE `account_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '账户角色中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account_role
-- ----------------------------
INSERT INTO `account_role` VALUES (1, 1, 1);
INSERT INTO `account_role` VALUES (2, 1, 2);
INSERT INTO `account_role` VALUES (10, 1, 16);
INSERT INTO `account_role` VALUES (22, 45, 2);
INSERT INTO `account_role` VALUES (23, 46, 15);
INSERT INTO `account_role` VALUES (24, 47, 15);
INSERT INTO `account_role` VALUES (26, 49, 15);
INSERT INTO `account_role` VALUES (28, 50, 16);
INSERT INTO `account_role` VALUES (29, 50, 15);
INSERT INTO `account_role` VALUES (30, 48, 15);
INSERT INTO `account_role` VALUES (31, 48, 16);
INSERT INTO `account_role` VALUES (37, 44, 16);
INSERT INTO `account_role` VALUES (38, 1, 17);

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `parent` int(11) NOT NULL DEFAULT 0 COMMENT '父节点ID 为0时为顶层',
  `is_del` int(11) NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '长沙总部', 0, 0, '2019-01-21 12:45:33', '2019-01-21 12:45:36');
INSERT INTO `dept` VALUES (2, '技术部', 1, 0, '2019-01-21 20:50:24', '2019-01-21 20:50:24');
INSERT INTO `dept` VALUES (3, '开发组', 2, 0, '2019-01-21 20:53:58', '2019-01-21 20:53:58');
INSERT INTO `dept` VALUES (4, 'Java组', 2, 0, '2019-01-21 21:57:42', '2019-01-21 21:57:42');
INSERT INTO `dept` VALUES (5, '前端组', 2, 0, '2019-01-21 21:58:53', '2019-01-21 21:58:53');
INSERT INTO `dept` VALUES (10, '广州分公司', 0, 0, '2019-01-22 14:30:06', '2019-01-22 14:30:06');
INSERT INTO `dept` VALUES (19, '行政部', 1, 0, '2019-02-25 19:53:17', '2019-02-25 19:53:17');
INSERT INTO `dept` VALUES (21, 'HR组', 19, 0, '2019-02-25 20:46:44', '2019-02-25 20:46:44');
INSERT INTO `dept` VALUES (22, '销售部', 10, 0, '2019-02-25 20:47:56', '2019-02-25 20:47:56');
INSERT INTO `dept` VALUES (23, '后勤部门', 1, 0, '2019-02-25 20:48:27', '2019-02-25 20:48:27');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `superior` int(11) NULL DEFAULT NULL COMMENT '上级菜单ID',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'URL',
  `redirect` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渲染目标',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前端组件',
  `hidden` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否隐藏 默认显示菜单',
  `sort` int(11) NOT NULL COMMENT '排序',
  `is_del` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, '系统管理', 'xitongshezhi', '/systemMG', '/system/account', 'layout/Layout', 0, 30, 0);
INSERT INTO `menu` VALUES (2, 1, '后台账户管理', 'user', '/system/account', NULL, 'Account/index', 0, 10, 0);
INSERT INTO `menu` VALUES (3, 1, '角色管理', 'ic-pin', '/system/role', NULL, 'Role/index', 0, 20, 0);
INSERT INTO `menu` VALUES (4, 1, '权限管理', 'ic-filter', '/system/Permission', NULL, 'Permission/index', 0, 30, 0);
INSERT INTO `menu` VALUES (5, 1, '菜单管理', 'jiedianguanli', '/system/menu', '', 'Menu/index', 0, 40, 0);
INSERT INTO `menu` VALUES (20, 0, '项目地址', 'aaa', 'https://github.com/yangqifang/SB-spring-cloud', NULL, NULL, 0, 20, 1);
INSERT INTO `menu` VALUES (21, 0, '系统工具', 'system-statu', 'tool', NULL, 'layout/Layout', 0, 20, 0);
INSERT INTO `menu` VALUES (22, 21, 'github项目地址', 'wendang', 'https://github.com/yangqifang/SB-spring-cloud', NULL, 'layout/components/AppMain', 0, 10, 0);
INSERT INTO `menu` VALUES (23, 21, 'swagger文档', 'wendang', 'http://127.0.0.1/admin/swagger-ui.html', NULL, NULL, 0, 21, 0);
INSERT INTO `menu` VALUES (24, 1, '部门管理', 'zuhuguanli', '/system/dept', NULL, 'Dept/index', 0, 30, 0);
INSERT INTO `menu` VALUES (25, 1, '数据字典', 'zidianguanli', '/sys/dict', NULL, 'Dict/index', 0, 16, 0);
INSERT INTO `menu` VALUES (26, 1, '图表生成', 'ic-data', '/chartconfig', '', 'layout/components/AppMain', 0, 70, 0);
INSERT INTO `menu` VALUES (27, 26, '折线图', 'zhexiantu', '/chartconfig/lin', NULL, 'config/chart/Line/index', 0, 20, 0);
INSERT INTO `menu` VALUES (28, 26, '柱状图', 'zhuzhuangtu', '/chartconfig/histogram', NULL, 'config/chart/histogram/index', 0, 30, 0);
INSERT INTO `menu` VALUES (29, 1, '服务配置', 'peizhi', '/server/config', NULL, 'serverconfig/index', 0, 28, 0);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `permission_value_uindex`(`value`) USING BTREE,
  UNIQUE INDEX `permission_name_uindex`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '导出数据', 'OUTPUTDATA', 0);
INSERT INTO `permission` VALUES (2, '超级管理员', 'ROOT', 0);
INSERT INTO `permission` VALUES (3, '管理员', 'ROLE_ADMIN', 0);
INSERT INTO `permission` VALUES (4, '普通用户', 'USER', 0);
INSERT INTO `permission` VALUES (5, 'VIP用户', 'VIP', 0);
INSERT INTO `permission` VALUES (6, '导入数据', 'INTPUTDATA', 0);

-- ----------------------------
-- Table structure for properties
-- ----------------------------
DROP TABLE IF EXISTS `properties`;
CREATE TABLE `properties`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '键',
  `value` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '值',
  `application` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用程序名称',
  `profile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置环境',
  `label` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of properties
-- ----------------------------
INSERT INTO `properties` VALUES (7, 'eureka.client.serviceUrl.defaultZone', 'http://spdata:spdata@localhost:8761/eureka/', 'server-oauth2', 'dev', 'master');
INSERT INTO `properties` VALUES (8, 'eureka.client.serviceUrl.defaultZone', 'http://spdata:spdata@localhost:8761/eureka/', 'server-crm', 'dev', 'master');
INSERT INTO `properties` VALUES (9, 'security.oauth2.client.id', 'spdata', 'server-crm', 'dev', 'master');
INSERT INTO `properties` VALUES (10, 'security.oauth2.client.client-secret', 'secret', 'server-crm', 'dev', 'master');
INSERT INTO `properties` VALUES (11, 'security.oauth2.client.user-authorization-uri', 'http://localhost:8762/auth/oauth/authorize', 'server-crm', 'dev', 'master');
INSERT INTO `properties` VALUES (12, 'security.oauth2.client.grant-type', 'password', 'server-crm', 'dev', 'master');
INSERT INTO `properties` VALUES (13, 'security.oauth2.client.scope', 'all', 'server-crm', 'dev', 'master');
INSERT INTO `properties` VALUES (14, 'security.oauth2.client.access-token-uri', 'http://localhost:8762/auth/oauth/token', 'server-crm', 'dev', 'master');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `is_del` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `role_name_uindex`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '2018-09-03 08:37:12', 0);
INSERT INTO `role` VALUES (2, '管理员', '2018-09-05 10:39:40', 0);
INSERT INTO `role` VALUES (15, '系统测试用户', '2019-01-29 14:23:00', 0);
INSERT INTO `role` VALUES (16, '普通用户', '2019-01-29 14:23:01', 0);
INSERT INTO `role` VALUES (17, 'test', '2019-03-06 16:52:28', 1);

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 150 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (28, 2, 1);
INSERT INTO `role_menu` VALUES (29, 3, 1);
INSERT INTO `role_menu` VALUES (30, 4, 1);
INSERT INTO `role_menu` VALUES (31, 5, 1);
INSERT INTO `role_menu` VALUES (77, 1, 1);
INSERT INTO `role_menu` VALUES (79, 21, 1);
INSERT INTO `role_menu` VALUES (80, 22, 1);
INSERT INTO `role_menu` VALUES (81, 23, 1);
INSERT INTO `role_menu` VALUES (82, 24, 1);
INSERT INTO `role_menu` VALUES (120, 2, 16);
INSERT INTO `role_menu` VALUES (121, 21, 16);
INSERT INTO `role_menu` VALUES (122, 22, 16);
INSERT INTO `role_menu` VALUES (123, 23, 16);
INSERT INTO `role_menu` VALUES (124, 25, 1);
INSERT INTO `role_menu` VALUES (125, 26, 1);
INSERT INTO `role_menu` VALUES (126, 27, 1);
INSERT INTO `role_menu` VALUES (127, 28, 1);
INSERT INTO `role_menu` VALUES (128, 2, 15);
INSERT INTO `role_menu` VALUES (129, 3, 15);
INSERT INTO `role_menu` VALUES (130, 4, 15);
INSERT INTO `role_menu` VALUES (131, 5, 15);
INSERT INTO `role_menu` VALUES (132, 24, 15);
INSERT INTO `role_menu` VALUES (133, 25, 15);
INSERT INTO `role_menu` VALUES (134, 21, 15);
INSERT INTO `role_menu` VALUES (135, 22, 15);
INSERT INTO `role_menu` VALUES (136, 23, 15);
INSERT INTO `role_menu` VALUES (137, 2, 2);
INSERT INTO `role_menu` VALUES (138, 3, 2);
INSERT INTO `role_menu` VALUES (139, 4, 2);
INSERT INTO `role_menu` VALUES (140, 5, 2);
INSERT INTO `role_menu` VALUES (141, 24, 2);
INSERT INTO `role_menu` VALUES (142, 25, 2);
INSERT INTO `role_menu` VALUES (143, 21, 2);
INSERT INTO `role_menu` VALUES (144, 22, 2);
INSERT INTO `role_menu` VALUES (145, 23, 2);
INSERT INTO `role_menu` VALUES (146, 26, 17);
INSERT INTO `role_menu` VALUES (147, 27, 17);
INSERT INTO `role_menu` VALUES (148, 28, 17);
INSERT INTO `role_menu` VALUES (149, 29, 1);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1, 1);
INSERT INTO `role_permission` VALUES (16, 4, 1);
INSERT INTO `role_permission` VALUES (18, 5, 1);
INSERT INTO `role_permission` VALUES (19, 6, 1);
INSERT INTO `role_permission` VALUES (33, 1, 2);
INSERT INTO `role_permission` VALUES (34, 3, 2);
INSERT INTO `role_permission` VALUES (35, 5, 2);
INSERT INTO `role_permission` VALUES (36, 6, 2);
INSERT INTO `role_permission` VALUES (37, 4, 2);
INSERT INTO `role_permission` VALUES (41, 3, 1);
INSERT INTO `role_permission` VALUES (42, 2, 1);
INSERT INTO `role_permission` VALUES (77, 4, 15);
INSERT INTO `role_permission` VALUES (78, 1, 15);
INSERT INTO `role_permission` VALUES (79, 6, 15);
INSERT INTO `role_permission` VALUES (80, 5, 15);
INSERT INTO `role_permission` VALUES (81, 3, 15);
INSERT INTO `role_permission` VALUES (91, 1, 16);
INSERT INTO `role_permission` VALUES (92, 4, 16);
INSERT INTO `role_permission` VALUES (93, 6, 16);

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `group` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_del` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (2, 'data-server-1', '测试group', '9', 1);
INSERT INTO `sys_dict` VALUES (14, '测试', '	 测试group', 'value', 1);
INSERT INTO `sys_dict` VALUES (15, '测试', '测试group', 'value', 1);
INSERT INTO `sys_dict` VALUES (16, '支付宝KEY', 'play', '9b72f495-32c6-44d6-b893-1dc97699a7f4', 0);
INSERT INTO `sys_dict` VALUES (17, '微信支付KEY', 'play', 'b88a404b-2951-46a9-b2db-a517a0f45471', 0);
INSERT INTO `sys_dict` VALUES (18, '贝宝支付', 'play', '57a5e79e-02a4-4053-a0e4-3ec67ea0801f', 0);
INSERT INTO `sys_dict` VALUES (19, 'a', 'a', 'a', 1);
INSERT INTO `sys_dict` VALUES (20, 'a', 'a', 'a', 1);
INSERT INTO `sys_dict` VALUES (21, 'host', 'mail', 'smtp.qq.com', 0);
INSERT INTO `sys_dict` VALUES (22, 'password', 'mail', 'password', 0);
INSERT INTO `sys_dict` VALUES (23, 'username', 'mail', 'username', 0);
INSERT INTO `sys_dict` VALUES (24, 'a', 'a', 'a', 1);

-- ----------------------------
-- Function structure for getDeptChild
-- ----------------------------
DROP FUNCTION IF EXISTS `getDeptChild`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `getDeptChild`(rootid int) RETURNS varchar(1024) CHARSET utf8
begin
  declare sdept varchar(1024);
  declare sdeptchd varchar(1024);
  set sdept = '$';
  set sdeptchd = cast(rootid as char);
  while sdeptchd is not null do
  set sdept = concat(sdept, ',', sdeptchd);
  select group_concat(id) into sdeptchd from dept where FIND_IN_SET(parent, sdeptchd) > 0 and is_del=0;
  end while;
  return sdept;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;

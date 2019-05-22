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

 Date: 24/04/2019 21:48:19
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
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'root', 'root', 0, 'root@spdata.com', 'china', 0, '超级管理员', 'http://pic1.win4000.com/tj/2018-12-29/5c273cb53a893.png', NULL);
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
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '账户角色中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account_role
-- ----------------------------
INSERT INTO `account_role` VALUES (1, 1, 1);
INSERT INTO `account_role` VALUES (2, 1, 2);
INSERT INTO `account_role` VALUES (10, 1, 16);
INSERT INTO `account_role` VALUES (22, 45, 2);
INSERT INTO `account_role` VALUES (23, 46, 15);
INSERT INTO `account_role` VALUES (26, 49, 15);
INSERT INTO `account_role` VALUES (28, 50, 16);
INSERT INTO `account_role` VALUES (29, 50, 15);
INSERT INTO `account_role` VALUES (30, 48, 15);
INSERT INTO `account_role` VALUES (31, 48, 16);
INSERT INTO `account_role` VALUES (37, 44, 16);
INSERT INTO `account_role` VALUES (38, 1, 17);
INSERT INTO `account_role` VALUES (39, 47, 15);
INSERT INTO `account_role` VALUES (40, 47, 16);

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
INSERT INTO `dept` VALUES (10, 'dept-update', 1, 0, '2019-01-22 14:30:06', '2019-01-22 14:30:06');
INSERT INTO `dept` VALUES (19, '行政部', 1, 0, '2019-02-25 19:53:17', '2019-02-25 19:53:17');
INSERT INTO `dept` VALUES (21, 'HR组', 19, 0, '2019-02-25 20:46:44', '2019-02-25 20:46:44');
INSERT INTO `dept` VALUES (22, '销售部', 10, 0, '2019-02-25 20:47:56', '2019-02-25 20:47:56');
INSERT INTO `dept` VALUES (23, '后勤部门', 10, 0, '2019-02-25 20:48:27', '2019-02-25 20:48:27');
INSERT INTO `dept` VALUES (24, '测试顶级部门', 0, 0, '2019-03-27 17:16:27', '2019-03-27 17:16:27');

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
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, '系统管理', 'xitongshezhi', '/systemMG', '/system/account', 'layout/Layout', 0, 30, 0);
INSERT INTO `menu` VALUES (2, 1, '账户管理', 'user', '/system/account', NULL, 'Account/index', 0, 10, 0);
INSERT INTO `menu` VALUES (3, 1, '角色管理', 'ic-pin', '/system/role', NULL, 'Role/index', 0, 20, 0);
INSERT INTO `menu` VALUES (4, 1, '权限管理', 'ic-filter', '/system/Permission', NULL, 'Permission/index', 0, 30, 0);
INSERT INTO `menu` VALUES (5, 1, '菜单管理', 'jiedianguanli', '/system/menu', '', 'Menu/index', 0, 40, 0);
INSERT INTO `menu` VALUES (20, 0, '项目地址', 'aaa', 'https://github.com/yangqifang/SB-spring-cloud', NULL, NULL, 0, 20, 1);
INSERT INTO `menu` VALUES (21, 0, '系统工具', 'system-statu', 'tool', NULL, 'layout/Layout', 0, 20, 0);
INSERT INTO `menu` VALUES (22, 21, 'github项目地址', 'wendang', 'https://github.com/yangqifang/SB-spring-cloud', NULL, 'layout/components/AppMain', 0, 10, 0);
INSERT INTO `menu` VALUES (23, 21, 'swagger文档', 'wendang', 'http://127.0.0.1/admin/doc.html', NULL, NULL, 0, 21, 0);
INSERT INTO `menu` VALUES (24, 1, '部门管理', 'zuhuguanli', '/system/dept', NULL, 'Dept/index', 0, 30, 0);
INSERT INTO `menu` VALUES (25, 1, '数据字典', 'zidianguanli', '/sys/dict', NULL, 'Dict/index', 0, 16, 0);
INSERT INTO `menu` VALUES (26, 1, '图表生成', 'ic-data', '/chartconfig', '', 'layout/components/AppMain', 0, 70, 0);
INSERT INTO `menu` VALUES (27, 26, '折线图', 'zhexiantu', '/chartconfig/lin', NULL, 'config/chart/Line/index', 0, 20, 0);
INSERT INTO `menu` VALUES (28, 26, '柱状图', 'zhuzhuangtu', '/chartconfig/histogram', NULL, 'config/chart/histogram/index', 0, 30, 0);
INSERT INTO `menu` VALUES (29, 1, '服务配置', 'peizhi', '/server/config', NULL, 'serverconfig/index', 0, 28, 0);

-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token`  (
  `token_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` blob NULL,
  `authentication_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authentication` blob NULL,
  `refresh_token` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_access_token
-- ----------------------------
INSERT INTO `oauth_access_token` VALUES ('6e81db4b34cc4bb60189c1024d7a9495', 0xACED0005737200436F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E636F6D6D6F6E2E44656661756C744F4175746832416363657373546F6B656E0CB29E361B24FACE0200064C00156164646974696F6E616C496E666F726D6174696F6E74000F4C6A6176612F7574696C2F4D61703B4C000A65787069726174696F6E7400104C6A6176612F7574696C2F446174653B4C000C72656672657368546F6B656E74003F4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F636F6D6D6F6E2F4F417574683252656672657368546F6B656E3B4C000573636F706574000F4C6A6176612F7574696C2F5365743B4C0009746F6B656E547970657400124C6A6176612F6C616E672F537472696E673B4C000576616C756571007E00057870737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F72646572787200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000177080000000200000001740004636F6465737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B0200007870000007D078007372000E6A6176612E7574696C2E44617465686A81014B597419030000787077080000016A510FD9DF7870737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C0001637400164C6A6176612F7574696C2F436F6C6C656374696F6E3B7870737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000002740003616C6C740004726561647874000662656172657274002437353638626130322D363630352D343937612D383966612D393136316439643138616566, '4d85b66e6f8a80a139fc7660b9fbc949', 'root', 'spdata', 0xACED0005737200416F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F417574683241757468656E7469636174696F6EBD400B02166252130200024C000D73746F7265645265717565737474003C4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F4F4175746832526571756573743B4C00127573657241757468656E7469636174696F6E7400324C6F72672F737072696E676672616D65776F726B2F73656375726974792F636F72652F41757468656E7469636174696F6E3B787200476F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E416273747261637441757468656E7469636174696F6E546F6B656ED3AA287E6E47640E0200035A000D61757468656E746963617465644C000B617574686F7269746965737400164C6A6176612F7574696C2F436F6C6C656374696F6E3B4C000764657461696C737400124C6A6176612F6C616E672F4F626A6563743B787000737200266A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654C697374FC0F2531B5EC8E100200014C00046C6973747400104C6A6176612F7574696C2F4C6973743B7872002C6A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65436F6C6C656374696F6E19420080CB5EF71E0200014C00016371007E00047870737200136A6176612E7574696C2E41727261794C6973747881D21D99C7619D03000149000473697A65787000000006770400000006737200426F72672E737072696E676672616D65776F726B2E73656375726974792E636F72652E617574686F726974792E53696D706C654772616E746564417574686F7269747900000000000001F40200014C0004726F6C657400124C6A6176612F6C616E672F537472696E673B787074000A494E54505554444154417371007E000D740004524F4F547371007E000D74000A4F5554505554444154417371007E000D74000A524F4C455F41444D494E7371007E000D740004555345527371007E000D7400035649507871007E000C707372003A6F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E4F41757468325265717565737400000000000000010200075A0008617070726F7665644C000B617574686F72697469657371007E00044C000A657874656E73696F6E7374000F4C6A6176612F7574696C2F4D61703B4C000B726564697265637455726971007E000E4C00077265667265736874003B4C6F72672F737072696E676672616D65776F726B2F73656375726974792F6F61757468322F70726F76696465722F546F6B656E526571756573743B4C000B7265736F7572636549647374000F4C6A6176612F7574696C2F5365743B4C000D726573706F6E7365547970657371007E001E787200386F72672E737072696E676672616D65776F726B2E73656375726974792E6F61757468322E70726F76696465722E426173655265717565737436287A3EA37169BD0200034C0008636C69656E74496471007E000E4C001172657175657374506172616D657465727371007E001C4C000573636F706571007E001E7870740006737064617461737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C654D6170F1A5A8FE74F507420200014C00016D71007E001C7870737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F400000000000037708000000040000000274000A6772616E745F7479706574000870617373776F7264740008757365726E616D65740004726F6F7478737200256A6176612E7574696C2E436F6C6C656374696F6E7324556E6D6F6469666961626C65536574801D92D18F9B80550200007871007E0009737200176A6176612E7574696C2E4C696E6B656448617368536574D86CD75A95DD2A1E020000787200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F40000000000002740003616C6C7400047265616478017371007E002D770C000000103F40000000000000787371007E00243F40000000000000770800000010000000007870707371007E002D770C000000103F40000000000001740006737064617461787371007E002D770C000000103F40000000000000787372004F6F72672E737072696E676672616D65776F726B2E73656375726974792E61757468656E7469636174696F6E2E557365726E616D6550617373776F726441757468656E7469636174696F6E546F6B656E00000000000001F40200024C000B63726564656E7469616C7371007E00054C00097072696E636970616C71007E00057871007E0003017371007E00077371007E000B0000000677040000000671007E000F71007E001171007E001371007E001571007E001771007E00197871007E0039737200176A6176612E7574696C2E4C696E6B6564486173684D617034C04E5C106CC0FB0200015A000B6163636573734F726465727871007E00243F400000000000067708000000080000000271007E002671007E002771007E002871007E002978007071007E0029, NULL);

-- ----------------------------
-- Table structure for oauth_approvals
-- ----------------------------
DROP TABLE IF EXISTS `oauth_approvals`;
CREATE TABLE `oauth_approvals`  (
  `userId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clientId` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scope` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expiresAt` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `lastModifiedAt` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_secret` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'read',
  `authorized_grant_types` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authorities` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additional_information` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `autoapprove` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false',
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('spdata', 'spdata', 'secret', 'all,read', 'password,authorization_code', 'http://127.0.0.1:9000,http://localhost:9000', '', NULL, NULL, NULL, 'false');

-- ----------------------------
-- Table structure for oauth_client_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token`  (
  `token_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` blob NULL,
  `authentication_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`authentication_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_code
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code`  (
  `code` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authentication` blob NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token`  (
  `token_id` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `token` blob NULL,
  `authentication` blob NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `properties` VALUES (7, 'eureka.client.serviceUrl.defaultZone', 'http://spdata:spdata@eureka-host:8761/eureka/', 'server-oauth2', 'dev', 'master');
INSERT INTO `properties` VALUES (8, 'eureka.client.serviceUrl.defaultZone', 'http://spdata:spdata@eureka-host:8761/eureka/', 'server-crm', 'dev', 'master');
INSERT INTO `properties` VALUES (9, 'security.oauth2.client.id', 'spdata', 'server-crm', 'dev', 'master');
INSERT INTO `properties` VALUES (10, 'security.oauth2.client.client-secret', 'secret', 'server-crm', 'dev', 'master');
INSERT INTO `properties` VALUES (11, 'security.oauth2.client.user-authorization-uri', 'http://oauth2-host:8762/auth/oauth/authorize', 'server-crm', 'dev', 'master');
INSERT INTO `properties` VALUES (12, 'security.oauth2.client.grant-type', 'password', 'server-crm', 'dev', 'master');
INSERT INTO `properties` VALUES (13, 'security.oauth2.client.scope', 'all', 'server-crm', 'dev', 'master');
INSERT INTO `properties` VALUES (14, 'security.oauth2.client.access-token-uri', 'http://oauth2-host:8762/auth/oauth/token', 'server-crm', 'dev', 'master');
INSERT INTO `properties` VALUES (15, 'server.port', '8084', 'test-server4', 'test', 'master');

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
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 169 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单中间表' ROW_FORMAT = Dynamic;

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
INSERT INTO `role_menu` VALUES (160, 2, 16);
INSERT INTO `role_menu` VALUES (161, 5, 16);
INSERT INTO `role_menu` VALUES (162, 24, 16);
INSERT INTO `role_menu` VALUES (163, 25, 16);
INSERT INTO `role_menu` VALUES (164, 26, 16);
INSERT INTO `role_menu` VALUES (165, 27, 16);
INSERT INTO `role_menu` VALUES (166, 28, 16);
INSERT INTO `role_menu` VALUES (167, 21, 16);
INSERT INTO `role_menu` VALUES (168, 22, 16);
INSERT INTO `role_menu` VALUES (169, 23, 16);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限中间表' ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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

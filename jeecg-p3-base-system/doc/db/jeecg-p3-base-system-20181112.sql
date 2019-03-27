/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50037
Source Host           : 127.0.0.1:3306
Source Database       : jeecg-p3

Target Server Type    : MYSQL
Target Server Version : 50037
File Encoding         : 65001

Date: 2018-11-12 11:19:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jp_system_auth
-- ----------------------------
DROP TABLE IF EXISTS `jp_system_auth`;
CREATE TABLE `jp_system_auth` (
  `id` varchar(32) collate utf8_bin NOT NULL COMMENT '序号',
  `auth_name` varchar(100) collate utf8_bin default NULL COMMENT '权限名称',
  `auth_type` varchar(2) collate utf8_bin default NULL COMMENT '权限类型 0:菜单;1:功能',
  `auth_desc` varchar(120) collate utf8_bin default NULL COMMENT '权限说明',
  `auth_url` varchar(256) collate utf8_bin default NULL COMMENT '权限控制请求',
  `parent_id` varchar(32) collate utf8_bin default NULL COMMENT '上一级权限编码',
  `deep` varchar(10) collate utf8_bin default NULL COMMENT '菜单深度',
  `sort_no` int(11) default NULL COMMENT '排序',
  `del_flag` char(2) collate utf8_bin NOT NULL default '0' COMMENT '删除标志 0未删除 1已删除',
  `icon_type` varchar(50) collate utf8_bin default NULL COMMENT '图标类型',
  `create_by` varchar(50) collate utf8_bin default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_by` varchar(50) collate utf8_bin default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统权限菜单表';

-- ----------------------------
-- Records of jp_system_auth
-- ----------------------------
INSERT INTO `jp_system_auth` VALUES ('41CE12EFA6B04579BC0869B5B269874C', '系统管理', '0', '系统管理-', '', '0', '5', '5', '0', 'fa-cog', null, '2017-08-08 12:02:53', null, null);
INSERT INTO `jp_system_auth` VALUES ('42D440160BF24960AA4E5EA52E4E3CAF', '角色管理', '0', '角色管理', 'system/jpSystemRole.do?list', '41CE12EFA6B04579BC0869B5B269874C', '51', '1', '0', '', null, '2017-08-08 12:03:41', null, null);
INSERT INTO `jp_system_auth` VALUES ('860B92AD57C24D969B9841C6314C1B29', '菜单管理', '0', '菜单管理', 'system/jpSystemAuth.do?list', '41CE12EFA6B04579BC0869B5B269874C', '53', '3', '0', '', null, '2017-08-08 12:08:05', null, null);
INSERT INTO `jp_system_auth` VALUES ('87CD38DC1AC44DD3BB8840232E348246', '用户管理', '0', '用户管理', 'system/jpSystemUser.do?list', '41CE12EFA6B04579BC0869B5B269874C', '52', '2', '0', '', null, '2017-08-08 12:07:14', null, null);

-- ----------------------------
-- Table structure for jp_system_role
-- ----------------------------
DROP TABLE IF EXISTS `jp_system_role`;
CREATE TABLE `jp_system_role` (
  `id` varchar(32) collate utf8_bin NOT NULL COMMENT '序号',
  `role_id` varchar(32) collate utf8_bin NOT NULL default '' COMMENT '角色编码',
  `role_name` varchar(100) collate utf8_bin default NULL COMMENT '角色名称',
  `del_flag` char(2) collate utf8_bin default '0' COMMENT '删除标志',
  `create_by` varchar(50) collate utf8_bin default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_by` varchar(50) collate utf8_bin default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uniq_roleid` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统角色表';

-- ----------------------------
-- Records of jp_system_role
-- ----------------------------
INSERT INTO `jp_system_role` VALUES ('000111js', '001', '管理员', '0', '', '2017-08-07 15:30:02', '', null);

-- ----------------------------
-- Table structure for jp_system_role_auth_rel
-- ----------------------------
DROP TABLE IF EXISTS `jp_system_role_auth_rel`;
CREATE TABLE `jp_system_role_auth_rel` (
  `role_id` varchar(32) collate utf8_bin NOT NULL default '' COMMENT '角色编码',
  `auth_id` varchar(32) collate utf8_bin NOT NULL default '' COMMENT '权限编码',
  PRIMARY KEY  (`auth_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统角色权限关联表';

-- ----------------------------
-- Records of jp_system_role_auth_rel
-- ----------------------------
INSERT INTO `jp_system_role_auth_rel` VALUES ('000111js', '41CE12EFA6B04579BC0869B5B269874C');
INSERT INTO `jp_system_role_auth_rel` VALUES ('000111js', '42D440160BF24960AA4E5EA52E4E3CAF');
INSERT INTO `jp_system_role_auth_rel` VALUES ('000111js', '860B92AD57C24D969B9841C6314C1B29');
INSERT INTO `jp_system_role_auth_rel` VALUES ('000111js', '87CD38DC1AC44DD3BB8840232E348246');

-- ----------------------------
-- Table structure for jp_system_user
-- ----------------------------
DROP TABLE IF EXISTS `jp_system_user`;
CREATE TABLE `jp_system_user` (
  `id` varchar(32) collate utf8_bin NOT NULL default '0' COMMENT '序号',
  `user_code` varchar(32) collate utf8_bin default '' COMMENT '用户编码',
  `user_name` varchar(32) collate utf8_bin default NULL COMMENT '用户名称',
  `password` varchar(64) collate utf8_bin default NULL COMMENT '密码',
  `user_type` char(2) collate utf8_bin default NULL COMMENT '用户种类',
  `user_status` varchar(20) collate utf8_bin default NULL COMMENT '用户状态 NORMAL:正常；INVALID：无效',
  `last_logn_time` datetime default NULL COMMENT '上次登录日期',
  `last_logn_ip` char(15) collate utf8_bin default NULL COMMENT '上次登录IP',
  `del_flag` char(2) collate utf8_bin default '0' COMMENT '删除标志',
  `create_by` varchar(50) collate utf8_bin default NULL COMMENT '创建人登录名称',
  `create_date` datetime default NULL COMMENT '创建日期',
  `update_by` varchar(50) collate utf8_bin default NULL COMMENT '更新人登录名称',
  `update_date` datetime default NULL COMMENT '更新日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统用户表';

-- ----------------------------
-- Records of jp_system_user
-- ----------------------------
INSERT INTO `jp_system_user` VALUES ('4A4A85432C124CE29EACA2A0E09F9194', 'admin', 'admin', '8ca1e641c2bc5040', null, 'NORMAL', null, null, '0', null, '2017-08-11 14:57:56', null, '2017-08-11 15:27:18');

-- ----------------------------
-- Table structure for jp_system_user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `jp_system_user_role_rel`;
CREATE TABLE `jp_system_user_role_rel` (
  `user_id` varchar(32) collate utf8_bin NOT NULL default '' COMMENT '用户id',
  `role_id` varchar(32) collate utf8_bin NOT NULL default '' COMMENT '角色id',
  PRIMARY KEY  (`role_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统用户角色关联表';

-- ----------------------------
-- Records of jp_system_user_role_rel
-- ----------------------------
INSERT INTO `jp_system_user_role_rel` VALUES ('4A4A85432C124CE29EACA2A0E09F9194', '000111js');

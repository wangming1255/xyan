/*
Navicat MySQL Data Transfer

Source Server         : xyan
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : xyan

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-03-08 17:37:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for xy_code
-- ----------------------------
DROP TABLE IF EXISTS `xy_code`;
CREATE TABLE `xy_code` (
  `MODEL_NAME` varchar(20) NOT NULL COMMENT '实体类名称',
  `VALUE` varchar(20) DEFAULT NULL COMMENT '主键值',
  PRIMARY KEY (`MODEL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主键生成表';

-- ----------------------------
-- Table structure for xy_resource
-- ----------------------------
DROP TABLE IF EXISTS `xy_resource`;
CREATE TABLE `xy_resource` (
  `ID` bigint(20) NOT NULL,
  `PID` bigint(20) NOT NULL COMMENT '父级ID',
  `RESOURCE_NAME` varchar(50) NOT NULL COMMENT '资源名称',
  `ICON` varchar(50) DEFAULT NULL,
  `URL` varchar(50) DEFAULT NULL,
  `AVAILABLE` varchar(1) DEFAULT '1' COMMENT '是否可用，1 可用 0 不可用',
  `PERMISSION` varchar(30) DEFAULT NULL COMMENT '权限字符串',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统资源表';

-- ----------------------------
-- Table structure for xy_role
-- ----------------------------
DROP TABLE IF EXISTS `xy_role`;
CREATE TABLE `xy_role` (
  `ID` bigint(20) NOT NULL,
  `ROLE_NAME` varchar(50) NOT NULL COMMENT '角色名称',
  `PID` bigint(20) NOT NULL COMMENT '父级ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Table structure for xy_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `xy_role_resource`;
CREATE TABLE `xy_role_resource` (
  `ID` bigint(20) NOT NULL,
  `RESOURCE_ID` bigint(20) NOT NULL,
  `ROLE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源中间表';

-- ----------------------------
-- Table structure for xy_test
-- ----------------------------
DROP TABLE IF EXISTS `xy_test`;
CREATE TABLE `xy_test` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试表';

-- ----------------------------
-- Table structure for xy_user
-- ----------------------------
DROP TABLE IF EXISTS `xy_user`;
CREATE TABLE `xy_user` (
  `ID` bigint(255) NOT NULL COMMENT '主键',
  `USER_NAME` varchar(30) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(40) NOT NULL COMMENT '密码',
  `SALT` varchar(10) NOT NULL COMMENT '盐值',
  `EMAIL` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `MOBILE` varchar(15) DEFAULT NULL COMMENT '手机号',
  `LOGIN_NAME` varchar(30) NOT NULL COMMENT '登陆名',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for xy_user_role
-- ----------------------------
DROP TABLE IF EXISTS `xy_user_role`;
CREATE TABLE `xy_user_role` (
  `ID` bigint(20) NOT NULL,
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色中间表';

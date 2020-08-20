SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cf_address
-- ----------------------------
DROP TABLE IF EXISTS `cf_address`;
CREATE TABLE `cf_address`  (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `detailedarea` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `postalcode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `consignee` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `consigneephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cf_address
-- ----------------------------
INSERT INTO `cf_address` VALUES (1, 2, '中国辽宁省朝阳市朝阳县', '巨魔巢穴', '666666', '冬泳怪鸽', '18888888888');
INSERT INTO `cf_address` VALUES (2, 2, '中国辽宁省朝阳市朝阳县', '巨魔巢穴', '666666', '萌萌的喵酱', '18888888881');
INSERT INTO `cf_address` VALUES (3, 2, '中国辽宁省朝阳市朝阳县', '巨魔巢穴', '666666', '未见青山老', '18366598753');
INSERT INTO `cf_address` VALUES (4, 2, '中国辽宁省朝阳市朝阳县', '巨魔巢穴', '666666', '蓝丝戴尔', '18888888883');
INSERT INTO `cf_address` VALUES (5, 2, '中国辽宁省朝阳市朝阳县', '巨魔巢穴', '123456', '明明的苗酱', '18888888884');
INSERT INTO `cf_address` VALUES (6, 2, '中国辽宁省朝阳市朝阳县', '巨魔巢穴', '666666', '黑夜的精灵', '18888888885');
INSERT INTO `cf_address` VALUES (7, 2, '中国辽宁省朝阳市朝阳县', '巨魔巢穴', '666666', '我朋友', '18888888886');
INSERT INTO `cf_address` VALUES (8, 2, '中国辽宁省朝阳市朝阳县', '巨魔巢穴', '666666', '老鸨子', '18888888887');
INSERT INTO `cf_address` VALUES (9, 2, '中国辽宁省朝阳市朝阳县', '巨魔巢穴', '666666', '老豹子', '18888888889');
INSERT INTO `cf_address` VALUES (10, 2, '中国辽宁省朝阳市朝阳县', '巨魔巢穴', '666666', '烫烫烫烫烫', '18888888878');
INSERT INTO `cf_address` VALUES (12, 2, '中国辽宁省朝阳市朝阳县', '巨魔巢穴', '666666', '正义哥斯拉', '18888888876');
INSERT INTO `cf_address` VALUES (13, 2, '中国辽宁省朝阳市朝阳县', '巨魔巢穴', '666666', '德莉莎·观星', '18888888875');
INSERT INTO `cf_address` VALUES (16, 2, '中国河北省秦皇岛市北戴河区', '巨魔巢穴', '450000', '胡德', '18888888159'); 

-- ----------------------------
-- Table structure for cf_car
-- ----------------------------
DROP TABLE IF EXISTS `cf_car`;
CREATE TABLE `cf_car`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `yid` int(11) NOT NULL,
  `cnum` int(11) NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cf_car
-- ----------------------------
INSERT INTO `cf_car` VALUES (1, 1, 1, 4);
INSERT INTO `cf_car` VALUES (27, 2, 26, 1);
INSERT INTO `cf_car` VALUES (28, 2, 27, 1);
INSERT INTO `cf_car` VALUES (29, 2, 28, 1);
INSERT INTO `cf_car` VALUES (30, 2, 29, 1);
INSERT INTO `cf_car` VALUES (31, 2, 30, 1);
INSERT INTO `cf_car` VALUES (32, 2, 31, 1);
INSERT INTO `cf_car` VALUES (33, 2, 32, 1);
INSERT INTO `cf_car` VALUES (34, 2, 33, 1);
INSERT INTO `cf_car` VALUES (37, 2, 4, 1);
INSERT INTO `cf_car` VALUES (38, 1, 2, 1);
INSERT INTO `cf_car` VALUES (39, 1, 3, 1);

-- ----------------------------
-- Table structure for cf_commodity
-- ----------------------------
DROP TABLE IF EXISTS `cf_commodity`;
CREATE TABLE `cf_commodity`  (
  `yid` int(11) NOT NULL AUTO_INCREMENT,
  `yname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `yprice` int(11) NOT NULL,
  `ygrounding` int(11) NOT NULL,
  `ynum` int(11) NOT NULL,
  `ytid` int(11) NOT NULL,
  `yimage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`yid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cf_commodity
-- ----------------------------
INSERT INTO `cf_commodity` VALUES (1, '阿馥奇朵', 15, 1, 100, 1, 'images/afqd.jpg');
INSERT INTO `cf_commodity` VALUES (2, '红茶拿铁', 10, 1, 100, 1, 'images/hcnt.jpg');
INSERT INTO `cf_commodity` VALUES (3, '冰摇红莓黑加仑茶', 20, 1, 100, 1, 'images/byhmhjlc.jpg');
INSERT INTO `cf_commodity` VALUES (4, '美式咖啡', 15, 1, 100, 1, 'images/meiskf.jpg');
INSERT INTO `cf_commodity` VALUES (5, '拿铁', 10, 1, 100, 1, 'images/nt.jpg');
INSERT INTO `cf_commodity` VALUES (6, '摩卡', 15, 1, 100, 1, 'images/mk.jpg');
INSERT INTO `cf_commodity` VALUES (7, '卡布奇诺', 15, 1, 100, 1, 'images/kbqn.jpg');
INSERT INTO `cf_commodity` VALUES (8, '焦糖浓缩咖啡', 20, 1, 100, 1, 'images/jtnskf.jpg');
INSERT INTO `cf_commodity` VALUES (9, '焦糖玛奇朵', 18, 1, 100, 1, 'images/jtmqd.jpg');
INSERT INTO `cf_commodity` VALUES (10, '冷萃浮乐朵', 16, 1, 100, 1, 'images/lcfld.jpg');
INSERT INTO `cf_commodity` VALUES (11, '冷萃冰咖啡', 16, 1, 100, 1, 'images/lcbkf.jpg');
INSERT INTO `cf_commodity` VALUES (12, '冰摇芒果花草茶', 14, 1, 100, 1, 'images/bymghcc.jpg');
INSERT INTO `cf_commodity` VALUES (13, '牛油果鸡肉焙果', 15, 1, 100, 2, 'images/nygjrpg.jpg');
INSERT INTO `cf_commodity` VALUES (14, '培根蛋可颂堡', 15, 1, 100, 2, 'images/pgdksb.jpg');
INSERT INTO `cf_commodity` VALUES (15, '蜜汁培根蛋卷', 15, 1, 100, 2, 'images/mzpgdj.jpg');
INSERT INTO `cf_commodity` VALUES (16, '层层牛肉法棍 ', 15, 1, 100, 2, 'images/ccnrfg.jpg');
INSERT INTO `cf_commodity` VALUES (17, '牛肉芝士可颂', 15, 1, 100, 2, 'images/nrzsks.jpg');
INSERT INTO `cf_commodity` VALUES (18, '蓝莓曲奇风轻乳酪蛋糕', 15, 1, 100, 2, 'images/lmqqfqrldg.jpg');
INSERT INTO `cf_commodity` VALUES (19, '蓝莓麦芬', 15, 1, 100, 2, 'images/lmmf.jpg');
INSERT INTO `cf_commodity` VALUES (20, '凯撒鸡肉卷', 15, 1, 100, 2, 'images/ksjrj.jpg');
INSERT INTO `cf_commodity` VALUES (21, '腰果', 15, 1, 100, 2, 'images/yg.jpg');
INSERT INTO `cf_commodity` VALUES (22, '鸡肉芝香帕尼尼', 15, 1, 100, 2, 'images/jrzxpnn.jpg');
INSERT INTO `cf_commodity` VALUES (23, '香浓巧克力麦芬', 15, 1, 100, 2, 'images/xnqklmf.jpg');
INSERT INTO `cf_commodity` VALUES (24, '旋风玉桂酥', 15, 1, 100, 2, 'images/xfygs.jpg');
INSERT INTO `cf_commodity` VALUES (25, '纯黑/古铜亮面品牌桌面杯', 15, 1, 100, 3, 'images/chgtlmppzmb.jpg');
INSERT INTO `cf_commodity` VALUES (26, '烫金品牌黑色马克杯', 15, 1, 100, 3, 'images/tjpphsmkb.jpg');
INSERT INTO `cf_commodity` VALUES (27, '银色/白色亮面品牌桌面杯', 15, 1, 100, 3, 'images/ysbslmppzmb.jpg');
INSERT INTO `cf_commodity` VALUES (28, '彰显本色黑色/深灰不锈钢桌面杯', 15, 1, 100, 3, 'images/zxbshsshbxgzmb.jpg');
INSERT INTO `cf_commodity` VALUES (29, '纯白磨砂玻璃杯', 15, 1, 100, 3, 'images/cbmsblb.jpg');
INSERT INTO `cf_commodity` VALUES (30, '烫金品牌白色马克杯', 15, 1, 100, 3, 'images/tjppbsmkb.jpg');
INSERT INTO `cf_commodity` VALUES (31, '原木黑色拎绳不锈钢保温杯', 15, 1, 100, 3, 'images/ymhslsbxgbwb.jpg');
INSERT INTO `cf_commodity` VALUES (32, '香槟金品牌不锈钢桌面杯', 15, 1, 100, 3, 'images/xbjppbxgzmb.jpg');
INSERT INTO `cf_commodity` VALUES (33, '彰显本色黑色/深灰不锈钢随行杯', 15, 1, 100, 3, 'images/zxbshsshbxgsxb.jpg');
INSERT INTO `cf_commodity` VALUES (34, '金色Logo水瓶', 15, 1, 100, 3, 'images/jslogosp.jpg');
INSERT INTO `cf_commodity` VALUES (35, '臻选玻璃杯', 15, 1, 100, 3, 'images/zxblb.jpg');

-- ----------------------------
-- Table structure for cf_commoditytype
-- ----------------------------
DROP TABLE IF EXISTS `cf_commoditytype`;
CREATE TABLE `cf_commoditytype`  (
  `ytid` int(11) NOT NULL AUTO_INCREMENT,
  `ytype` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ytid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cf_commoditytype
-- ----------------------------
INSERT INTO `cf_commoditytype` VALUES (1, '饮料');
INSERT INTO `cf_commoditytype` VALUES (2, '美食');
INSERT INTO `cf_commoditytype` VALUES (3, '商品');

-- ----------------------------
-- Table structure for cf_contact
-- ----------------------------
DROP TABLE IF EXISTS `cf_contact`;
CREATE TABLE `cf_contact`  (
  `conid` int(11) NOT NULL AUTO_INCREMENT,
  `conname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `conemail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `conphone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `conmessage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`conid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cf_contact
-- ----------------------------
INSERT INTO `cf_contact` VALUES (5, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (6, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (7, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (8, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (9, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (10, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (11, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (12, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (13, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (14, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (15, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (16, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (17, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (18, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (19, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (20, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (21, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (22, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (23, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (24, 'test', 'test', 'test', 'test');
INSERT INTO `cf_contact` VALUES (25, 'test', 'test', 'test', 'test');

-- ----------------------------
-- Table structure for cf_order
-- ----------------------------
DROP TABLE IF EXISTS `cf_order`;
CREATE TABLE `cf_order`  (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `onumber` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ocratetime` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ogold` int(11) NOT NULL,
  `otransaction` int(11) NOT NULL,
  `aid` int(11) NOT NULL,
  `oname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `oprice` int(10) NOT NULL,
  `onum` int(11) NOT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cf_order
-- ----------------------------
INSERT INTO `cf_order` VALUES (20, 2, '20200207013930', '2020-02-07 01:39:30', 100, 1, 5, '红茶拿铁', 10, 10);
INSERT INTO `cf_order` VALUES (21, 2, '20200207013930', '2020-02-07 01:39:30', 300, 1, 5, '美式咖啡', 15, 20);
INSERT INTO `cf_order` VALUES (22, 2, '20200207013930', '2020-02-07 01:39:30', 225, 1, 5, '卡布奇诺', 15, 15);
INSERT INTO `cf_order` VALUES (23, 2, '20200207013946', '2020-02-07 01:39:46', 340, 1, 4, '焦糖浓缩咖啡', 20, 17);
INSERT INTO `cf_order` VALUES (25, 2, '20200207013946', '2020-02-07 01:39:46', 16, 1, 4, '冷萃冰咖啡', 16, 1);
INSERT INTO `cf_order` VALUES (26, 2, '20200207013946', '2020-02-07 01:39:46', 14, 1, 4, '冰摇芒果花草茶', 14, 1);
INSERT INTO `cf_order` VALUES (27, 2, '20200207013946', '2020-02-07 01:39:46', 15, 1, 4, '牛肉芝士可颂', 15, 1);
INSERT INTO `cf_order` VALUES (28, 2, '20200207013946', '2020-02-07 01:39:46', 15, 1, 4, '蓝莓曲奇风轻乳酪蛋糕', 15, 1);
INSERT INTO `cf_order` VALUES (29, 2, '20200207013946', '2020-02-07 01:39:46', 15, 1, 4, '蓝莓麦芬', 15, 1);
INSERT INTO `cf_order` VALUES (31, 2, '20200207013946', '2020-02-07 01:39:46', 15, 1, 4, '牛油果鸡肉焙果', 15, 1);
INSERT INTO `cf_order` VALUES (32, 2, '20200207013946', '2020-02-07 01:39:46', 15, 1, 4, '培根蛋可颂堡', 15, 1);
INSERT INTO `cf_order` VALUES (33, 2, '20200207014332', '2020-02-07 01:43:32', 15, 1, 3, '腰果', 15, 1);
INSERT INTO `cf_order` VALUES (34, 2, '20200207022004', '2020-02-07 02:20:04', 15, 1, 6, '层层牛肉法棍 ', 15, 1);
INSERT INTO `cf_order` VALUES (35, 2, '20200207131053', '2020-02-07 13:10:53', 15, 1, 13, '鸡肉芝香帕尼尼', 15, 1);
INSERT INTO `cf_order` VALUES (36, 2, '20200207131053', '2020-02-07 13:10:53', 30, 1, 13, '香浓巧克力麦芬', 15, 2);
INSERT INTO `cf_order` VALUES (37, 2, '20200207133005', '2020-02-07 13:30:05', 15, 1, 16, '旋风玉桂酥', 15, 1);

-- ----------------------------
-- Table structure for cf_user
-- ----------------------------
DROP TABLE IF EXISTS `cf_user`;
CREATE TABLE `cf_user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `upwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uemail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `uphone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `ustate` int(11) NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cf_user
-- ----------------------------
INSERT INTO `cf_user` VALUES (1, 'zhangsan', 'zhangsan1234', 'zhangsan@qq.com', '18888888888', 1);
INSERT INTO `cf_user` VALUES (2, 'zhangsan1', 'zhangsan123', 'zhangsan1@qq.com', '18888888881', 1);
INSERT INTO `cf_user` VALUES (3, 'zhangsan2', 'zhangsan123', 'zhangsan2@qq.com', NULL, 1);
INSERT INTO `cf_user` VALUES (4, 'zhangsan3', 'zhangsan123', 'zhangsan3@qq.com', NULL, 1);
INSERT INTO `cf_user` VALUES (5, 'zhangsan4', 'zhangsan123', 'zhangsan4@qq.com', NULL, 1);
INSERT INTO `cf_user` VALUES (6, 'zhangsan5', 'zhangsan123', 'zhangsan5@qq.com', NULL, 1);
INSERT INTO `cf_user` VALUES (7, 'zhangsan6', 'zhangsan123', 'zhangsan6@qq.com', NULL, 1);

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1, NULL, 'ROLE_系统权限菜单', 'glyphicon glyphicon-th-list', NULL);
INSERT INTO `t_permission` VALUES (3, 1, 'ROLE_权限管理', 'glyphicon glyphicon glyphicon-tasks', NULL);
INSERT INTO `t_permission` VALUES (4, 3, 'ROLE_员工维护', 'glyphicon glyphicon-user', '/user');
INSERT INTO `t_permission` VALUES (5, 3, 'ROLE_角色维护', 'glyphicon glyphicon-king', '/role');
INSERT INTO `t_permission` VALUES (7, 1, 'ROLE_用户监控', 'glyphicon glyphicon-ok', NULL);
INSERT INTO `t_permission` VALUES (8, 7, 'ROLE_订单监控', 'glyphicon glyphicon-check', '/order_monitoring');
INSERT INTO `t_permission` VALUES (9, 7, 'ROLE_用户状态监控', 'glyphicon glyphicon-check', '/condition_monitoring');
INSERT INTO `t_permission` VALUES (10, 7, 'ROLE_用户反馈', 'glyphicon glyphicon-check', '/feedback_monitoring');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'PM - 项目经理');
INSERT INTO `t_role` VALUES (2, 'SE - 软件工程师');
INSERT INTO `t_role` VALUES (3, 'PG - 程序员');
INSERT INTO `t_role` VALUES (4, 'TL - 组长');
INSERT INTO `t_role` VALUES (5, 'GL - 组长');
INSERT INTO `t_role` VALUES (6, 'QA - 品质保证');
INSERT INTO `t_role` VALUES (7, 'QC - 品质控制');
INSERT INTO `t_role` VALUES (8, 'SA - 软件架构师');
INSERT INTO `t_role` VALUES (9, 'CMO / CMS - 配置管理员');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) NULL DEFAULT NULL,
  `permissionid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_3`(`roleid`) USING BTREE,
  INDEX `FK_Reference_4`(`permissionid`) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`roleid`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`permissionid`) REFERENCES `t_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (47, 1, 1);
INSERT INTO `t_role_permission` VALUES (49, 1, 3);
INSERT INTO `t_role_permission` VALUES (50, 1, 4);
INSERT INTO `t_role_permission` VALUES (51, 1, 5);
INSERT INTO `t_role_permission` VALUES (53, 1, 7);
INSERT INTO `t_role_permission` VALUES (54, 1, 8);
INSERT INTO `t_role_permission` VALUES (55, 1, 9);
INSERT INTO `t_role_permission` VALUES (56, 1, 10);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginacct` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `userpassword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `createtime` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'test', '$2a$10$kNyVZ3P.AYCTuVMeJR/dRO6883KT2s51c4xGAHqPWOMPif97DJTl.', 'zhangsan', 'zhangsan@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (2, 'test1', '$2a$10$kNyVZ3P.AYCTuVMeJR/dRO6883KT2s51c4xGAHqPWOMPif97DJTl.', 'lisi', 'lisi@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (3, 'test2', '$2a$10$kNyVZ3P.AYCTuVMeJR/dRO6883KT2s51c4xGAHqPWOMPif97DJTl.', 'wangwu', 'wangwu@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (4, 'test3', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'zhaoliu', 'zhaoliu@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (5, 'test4', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'tianqi', 'tianqi@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (6, 'test5', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'bagua', 'bagua@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (7, 'test6', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'jiutian', 'jiutian@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (8, 'test7', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'shifang', 'shifang@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (9, 'test8', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'wanggoudan', 'wanggoudan@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (10, 'test9', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'zhaotiezhu', 'zhaotiezhu@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (11, 'test10', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'sunwukong', 'suwukong@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (12, 'test11', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'zhubajie', 'zhubajie@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (13, 'test12', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'wangsitu', 'wangsitu@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (14, 'test13', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'qingdao', 'qingdao@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (15, 'test14', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'shanghai', 'shanghai@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (16, 'test15', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'yangzhou', 'yangzhou@qq.com', '2019-10-29');
INSERT INTO `t_user` VALUES (17, 'test16', '$2a$10$FlnlNZSqdKSWtVtBYLfJjOpm4UN09QMyjLvBMADfZtFZ.9f4dp/aW', 'yanhua', 'yanhua@qq.com', '2019-10-29');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NULL DEFAULT NULL,
  `roleid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_1`(`userid`) USING BTREE,
  INDEX `FK_Reference_2`(`roleid`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`roleid`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (40, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;

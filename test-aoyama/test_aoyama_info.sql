/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : test_aoyama

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 19/05/2023 21:03:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for test_aoyama_info
-- ----------------------------
DROP TABLE IF EXISTS `test_aoyama_info`;
CREATE TABLE `test_aoyama_info`  (
  `id` int(0) NOT NULL COMMENT 'ID',
  `announcement_title` varchar(125) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告标题',
  `announcement_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公告时间',
  `auction_name` varchar(125) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '拍卖名称/拍卖标的',
  `auction_type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '拍卖类型型(动产0,不动产1)',
  `auction_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '拍卖时间',
  `auction_frequency` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '拍卖次数(是一拍0，二拍1，还是变卖2) ',
  `starting_amount` varchar(125) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '起拍金额:如(\"835460.28元\")',
  `price_increase_margin` varchar(125) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '加价幅度/增价幅度:如(\"1000元\")',
  `security_deposit` varchar(125) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '保证金:如(\"80000元\")',
  `signing_time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '落款时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_aoyama_info
-- ----------------------------
INSERT INTO `test_aoyama_info` VALUES (1, '包头市青山区人民法院关于内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商', NULL, '内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商', '不动产', '2023年6月11日10时至2023年6月12日10时', '一拍', '835460.28元', '1000元', '80000元', NULL);
INSERT INTO `test_aoyama_info` VALUES (2, '包头市青山区人民法院关于内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商', NULL, '内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商', '不动产', '2023年6月11日10时至2023年6月12日10时', '二拍', '650000.28元', '1000元', '80000元', NULL);
INSERT INTO `test_aoyama_info` VALUES (3, '包头市青山区人民法院关于内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商', NULL, '内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商', '不动产', '2023年6月11日10时至2023年6月12日10时', '变卖', '640000.28元', '1000元', '80000元', NULL);
INSERT INTO `test_aoyama_info` VALUES (4, '包头市青山区人民法院关于内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商', NULL, '内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商1', '不动产', '2023年6月11日10时至2023年6月12日10时', '变卖', '835460.28元', '1000元', '80000元', NULL);
INSERT INTO `test_aoyama_info` VALUES (5, '包头市青山区人民法院关于内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商', NULL, '内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商1', '不动产', '2023年6月11日10时至2023年6月12日10时', '变卖', '835460.28元', '1000元', '80000元', NULL);
INSERT INTO `test_aoyama_info` VALUES (6, '包头市青山区人民法院关于内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商', NULL, '内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商1', '不动产', '2023年6月11日10时至2023年6月12日10时', '二拍', '835460.28元', '1000元', '80000元', NULL);
INSERT INTO `test_aoyama_info` VALUES (7, '包头市青山区人民法院关于内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商', NULL, '内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商1', '不动产', '2023年6月11日10时至2023年6月12日10时', '二拍', '835460.28元', '1000元', '80000元', NULL);
INSERT INTO `test_aoyama_info` VALUES (8, '包头市青山区人民法院关于内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商', NULL, '内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商1', '动产', '2023年6月11日10时至2023年6月12日10时', '一拍', '835460.28元', '1000元', '80000元', NULL);
INSERT INTO `test_aoyama_info` VALUES (9, '包头市青山区人民法院关于内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商', NULL, '内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商1', '动产', '2023年6月11日10时至2023年6月12日10时', '一拍', '835460.28元', '1000元', '80000元', NULL);
INSERT INTO `test_aoyama_info` VALUES (10, '包头市青山区人民法院关于内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商', NULL, '内蒙古自治区鄂尔多斯市达拉特旗树镇亿利大道北，杨场湾停车服务中心B-6#楼7号底商1', '动产', '2023年6月11日10时至2023年6月12日10时', '一拍', '835460.28元', '1000元', '80000元', NULL);

SET FOREIGN_KEY_CHECKS = 1;

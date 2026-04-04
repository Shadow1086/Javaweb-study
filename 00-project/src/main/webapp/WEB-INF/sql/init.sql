CREATE DATABASE schedule_system;

USE  schedule_system;


CREATE TABLE `sys_schedule`
(
    sid       INT                                                          NOT NULL AUTO_INCREMENT COMMENT '日程主键ID',
    uid       INT                                                          NULL DEFAULT NULL COMMENT '所属用户ID',
    title     VARCHAR(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '日程标题',
    completed TINYINT(1)                                                   NULL DEFAULT NULL COMMENT '完成状态：0未完成，1已完成',
    PRIMARY KEY (sid) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC
    COMMENT = '日程表';

CREATE TABLE `sys_user`
(
    uid      INT                                                           NOT NULL AUTO_INCREMENT COMMENT '用户主键ID',
    username VARCHAR(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL COMMENT '用户名',
    user_pwd VARCHAR(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
    PRIMARY KEY (uid) USING BTREE,
    UNIQUE INDEX `username` (`username`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = DYNAMIC
    COMMENT = '用户表';

INSERT INTO `sys_user`
VALUES (1, 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `sys_user`
VALUES (2, 'lisi', 'e10adc3949ba59abbe56e057f20f883e');

SET FOREIGN_KEY_CHECKS = 1;

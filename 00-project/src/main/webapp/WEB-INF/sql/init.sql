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


INSERT INTO sys_schedule (uid, title, completed) VALUES
                                                     (3, '完成登录页面', 0),
                                                     (3, '完善注册校验', 1),
                                                     (3, '学习Vue路由', 0),
                                                     (3, '整理Axios用法', 0),
                                                     (3, '编写日程查询', 1),
                                                     (5, '完成日程新增', 0),
                                                     (5, '完成日程修改', 0),
                                                     (5, '完成日程删除', 1),
                                                     (5, '优化页面布局', 0),
                                                     (5, '整理学习笔记', 1);
drop table if exists user;
create table user
(
    id          bigint auto_increment primary key comment '主键',
    user_name   varchar(10)                        null comment '用户名',
    real_name   varchar(10)                        null comment '真实姓名',
    phone       varchar(13)                        null comment '电话',
    age         int(3)                             null comment '年龄',
    is_delete   int(1)   default 0                 not null comment '是否删除',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
) comment '用户表' auto_increment = 1;


DROP TABLE IF EXISTS `hy_area`;
CREATE TABLE `hy_area`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `pid`         int(11)      DEFAULT NULL COMMENT '父id',
    `short_name`  varchar(100) DEFAULT NULL COMMENT '简称',
    `name`        varchar(100) DEFAULT NULL COMMENT '名称',
    `merger_name` varchar(255) DEFAULT NULL COMMENT '全称',
    `level`       tinyint(4)   DEFAULT NULL COMMENT '层级 0 1 2 省市区县',
    `pin_yin`     varchar(100) DEFAULT NULL COMMENT '拼音',
    `code`        varchar(100) DEFAULT NULL COMMENT '长途区号',
    `zip_code`    varchar(100) DEFAULT NULL COMMENT '邮编',
    `first`       varchar(50)  DEFAULT NULL COMMENT '首字母',
    `lng`         varchar(100) DEFAULT NULL COMMENT '经度',
    `lat`         varchar(100) DEFAULT NULL COMMENT '纬度',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3750
  DEFAULT CHARSET = utf8;
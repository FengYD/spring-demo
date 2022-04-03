create database demo;
use demo;
drop table if exists user;
create table user
(
    id          bigint auto_increment primary key comment '主键',
    user_name   varchar(10) not null default '0' comment '用户名',
    real_name   varchar(10) not null default '0' comment '真实姓名',
    phone       varchar(11) not null default '0' comment '电话',
    age         int(3)      not null default '0' comment '年龄',
    is_delete   int(1)      not null default 0 comment '是否删除',
    create_time datetime    not null default CURRENT_TIMESTAMP comment '创建时间',
    update_time datetime    not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  auto_increment = 1 comment '用户表';



DROP TABLE IF EXISTS area;
CREATE TABLE area
(
    id          bigint       NOT NULL AUTO_INCREMENT COMMENT 'ID',
    pid         bigint       NOT NULL DEFAULT '0' COMMENT '父id',
    short_name  varchar(100) NOT NULL DEFAULT '0' COMMENT '简称',
    name        varchar(100) NOT NULL DEFAULT '0' COMMENT '名称',
    merger_name varchar(255) NOT NULL DEFAULT '0' COMMENT '全称',
    level       tinyint(4)   NOT NULL DEFAULT '0' COMMENT '层级 0 1 2 省市区县',
    pin_yin     varchar(100) NOT NULL DEFAULT '0' COMMENT '拼音',
    code        varchar(20)  NOT NULL DEFAULT '0' COMMENT '长途区号',
    zip_code    varchar(20)  NOT NULL DEFAULT '0' COMMENT '邮编',
    first       varchar(10)  NOT NULL DEFAULT '0' COMMENT '首字母',
    lng         varchar(50)  NOT NULL DEFAULT '0' COMMENT '经度',
    lat         varchar(50)  NOT NULL DEFAULT '0' COMMENT '纬度',
    is_delete   int(1)       not null default 0 comment '是否删除',
    create_time datetime     not null default CURRENT_TIMESTAMP comment '创建时间',
    update_time datetime     not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 3750
  DEFAULT CHARSET = utf8mb4 comment '区域表';

drop table if exists access_file;
CREATE TABLE access_file
(
    id               bigint       NOT NULL AUTO_INCREMENT COMMENT 'ID',
    origin_name      varchar(100) NOT NULL DEFAULT '0' COMMENT '原始文件名',
    path             varchar(100) NOT NULL DEFAULT '0' COMMENT '存储路径',
    bucket           varchar(100) NOT NULL DEFAULT '0' COMMENT '文件桶',
    upload_time      datetime     NOT NULL default CURRENT_TIMESTAMP comment '上传时间',
    last_assess_time datetime     NOT NULL default CURRENT_TIMESTAMP comment '最后访问时间',
    is_delete        int(1)       not null default 0 comment '是否删除',
    create_time      datetime     NOT NULL default CURRENT_TIMESTAMP comment '创建时间',
    update_time      datetime     NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间',
    PRIMARY KEY (id),
    KEY idx_path (path)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4 comment '文件表';
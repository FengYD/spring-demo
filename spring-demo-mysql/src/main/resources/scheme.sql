drop table if exists user;
create table user (
      id bigint not null auto_increment primary key comment '主键',
      user_name varchar(10) null comment '用户名',
      real_name varchar(10) null comment '真实姓名',
      phone varchar(13) null comment '电话',
      age int(3) null comment '年龄',
      is_delete int(1) not null default 0 comment '是否删除',
      create_time datetime not null default current_timestamp comment '创建时间',
      update_time datetime not null default current_timestamp on update current_timestamp comment '更新时间'
) engine=innodb charset = utf8mb4 comment = '用户表';
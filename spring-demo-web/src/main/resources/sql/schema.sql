drop table if exists user;
create table user
(
    id          bigint auto_increment primary key  comment '主键',
    user_name   varchar(10)                        null comment '用户名',
    real_name   varchar(10)                        null comment '真实姓名',
    phone       varchar(13)                        null comment '电话',
    age         int(3)                             null comment '年龄',
    is_delete   int(1)   default 0                 not null comment '是否删除',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间'
) comment '用户表' auto_increment = 1;

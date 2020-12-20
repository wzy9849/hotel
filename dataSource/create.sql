/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2009-6-15 12:40:41                           */
/*==============================================================*/

create database hotel charset=utf8;

use hotel

drop table if exists category;

drop table if exists manager;

drop table if exists member;

drop table if exists reside;

drop table if exists room;

drop table if exists subscription;

drop table if exists subscription_dtl;

/*==============================================================*/
/* Table: category,房间类型
/*==============================================================*/
create table category
(
   id                   int not null auto_increment,
   name                 varchar(30) not null, 	-- 类型名
   code                 varchar(10) not null,
   description          text,			-- 房间描述
   bedprice             float not null,		-- 床位价格
   roomprice            float not null,		-- 整间价格
   primary key (id)
);

/*==============================================================*/
/* Table: manager   管理员                                            */
/*==============================================================*/
create table manager
(
   id                   int not null auto_increment,
   username             varchar(20) not null,
   pwd                  varchar(15) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: member          会员                                      */
/*==============================================================*/
create table member
(
   id                   int not null auto_increment,
   username             varchar(20) not null,
   pwd                  varchar(15) not null,
   name                 varchar(30),
   email                varchar(50),
   phone                varchar(18),
   regtime              datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: reside          居住情况                                      */
/*==============================================================*/
create table reside
(
   id                   int not null auto_increment,
   dtlid                int not null,   #--详细订单号
   residedate           date not null,  #--入住时间
   roomername           varchar(30),	#--住客姓名
   idcard               varchar(18),	#--身份证号
   primary key (id)
);

/*==============================================================*/
/* Table: room      房间                                            */
/*==============================================================*/
create table room
(
   id                   int not null auto_increment,
   cid                  int not null,   #--房间类型
   no                   char(3),	#--房间号码
   status               char(1),	#--状态，表示房间是否可用，状态为o(open)和c(close)
   primary key (id)
);

/*==============================================================*/
/* Table: subscription     订单                                     */
/*==============================================================*/
create table subscription
(
   id                   int not null auto_increment,
   mid                  int not null,                   #--订单预订者
   no                   varchar(20) not null,		#--订单号
   linkman              varchar(30) not null,		#--联系人
   email                varchar(50) not null,		#--email
   phone                varchar(18) not null,		#--电话
   status               char(1) not null,		#--订单状态，取消、确定、未生效
   cretime              datetime not null,		#--创建时间
   remark               varchar(100),			#--备注
   primary key (id)
);

/*==============================================================*/
/* Table: subscription_dtl     订单明细                                 */
/*==============================================================*/
create table subscription_dtl
(
   id                   int not null auto_increment,
   rid                  int,			#--房间号码
   sid                  int,			#--订单号
   sdate                date not null,		#--开始时间
   edate                date not null,		#--结束时间
   residetype           int not null,	        #--预定方式
   price                float not null,		#--价格
   primary key (id)
);

alter table reside add constraint FK_Reference_6 foreign key (dtlid)
      references subscription_dtl (id);

alter table room add constraint fk_room_cat foreign key (cid)
      references category (id);

alter table subscription add constraint fk_sub_member foreign key (mid)
      references member (id);

alter table subscription_dtl add constraint fk_dtl_room foreign key (rid)
      references room (id);

alter table subscription_dtl add constraint fk_dtl_sub foreign key (sid)
      references subscription (id);


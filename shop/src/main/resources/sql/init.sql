DROP DATABASE IF EXISTS shdev_shop;
CREATE database shdev_shop;
use shdev_shop;
CREATE TABLE t_user(
  id int(10) primary key auto_increment,
  username VARCHAR(100),
  password VARCHAR(100),
  nickname VARCHAR(100)
);

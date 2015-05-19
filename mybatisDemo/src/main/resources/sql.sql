drop database if exists store_oukongli;
CREATE database store_oukongli;
use store_oukongli;
CREATE TABLE t_user(
  id int(11) PRIMARY KEY auto_increment,
  username VARCHAR(100),
  password VARCHAR(100),
  nickname varchar(100),
  type int(5)
);
CREATE table t_address(
    id int(11) PRIMARY KEY auto_increment,
  name varchar(255),
  phone VARCHAR(100),
  postcode varchar(100),
  user_id int(100),
  constraint FOREIGN KEY (user_id) REFERENCES t_user(id)
);
CREATE table t_order(
    id int(11) PRIMARY KEY auto_increment,
  buy_date datetime,
  status int(5),
  postcode varchar(100),
  user_id int(11),
  address_id int(11),
  CONSTRAINT FOREIGN KEY (user_id) REFERENCES t_user(id),
  CONSTRAINT FOREIGN KEY (address_id) REFERENCES t_address(id)
);
create TABLE t_category(
  id INT(11) PRIMARY key auto_increment,
  name VARCHAR(100)
);
CREATE table t_goods(
    id int(11) PRIMARY KEY auto_increment,
  name VARCHAR(100),
  price double,
  intro text,
  img varchar(100),
  stock int(10),
  c_id int(10),
  CONSTRAINT FOREIGN KEY (c_id) REFERENCES t_category(id)
);
CREATE table t_goods_orders(
  id int(11) PRIMARY KEY auto_increment,
  goods_id int(10),
  orders_id int(10),
  CONSTRAINT FOREIGN KEY (goods_id) REFERENCES t_goods(id),
  CONSTRAINT FOREIGN KEY (orders_id) REFERENCES t_order(id)
);
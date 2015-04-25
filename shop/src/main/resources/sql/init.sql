DROP DATABASE IF EXISTS shdev_shop;
CREATE database shdev_shop;
use shdev_shop;
CREATE TABLE t_user(
  id int(10) primary key auto_increment,
  username VARCHAR(100),
  password VARCHAR(100),
  nickname VARCHAR(100),
  type int(3)
);

CREATE TABLE t_msg (
  id INT(11) NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  content TEXT DEFAULT NULL,
  post_date DATETIME NOT NULL,
  user_id INT(11) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (user_id) REFERENCES shdev_shop.t_user(id)
);

CREATE TABLE shdev_shop.t_comment (
  id INT(11) NOT NULL AUTO_INCREMENT,
  content TEXT DEFAULT NULL,
  post_date DATETIME DEFAULT NULL,
  user_id INT(11) DEFAULT NULL,
  msg_id INT(11) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_t_comment_t_msg_id FOREIGN KEY (msg_id)
  REFERENCES shdev_shop.t_msg(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT FK_t_comment_t_user_id FOREIGN KEY (user_id)
  REFERENCES shdev_shop.t_user(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)
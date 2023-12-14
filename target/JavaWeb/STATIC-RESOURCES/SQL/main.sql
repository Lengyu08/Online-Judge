-- Author: ZWH
ALTER USER 'root'@'localhost' IDENTIFIED with mysql_native_password BY '123456';
FLUSH PRIVILEGES;

-- 删除原有的数据库，创建新的数据库
DROP DATABASE IF EXISTS zwh;
CREATE DATABASE zwh;
USE zwh;

-- 创建用户表
DROP TABLE IF EXISTS user;
CREATE TABLE user (
    user_id      SERIAL PRIMARY KEY AUTO_INCREMENT,
    username     VARCHAR(255) NOT NULL,
    password     VARCHAR(255) NOT NULL, -- 存储加密后的密码
    email        VARCHAR(255),
    phone_number VARCHAR(255),
    interests    VARCHAR(255),
    gender       VARCHAR(10),
    login_time   VARCHAR(255),
    right_level  VARCHAR(10)
);

-- 创建用户
INSERT INTO user (username, password, email, phone_number, interests, gender, login_time, right_level)
VALUES  ('root', 'root', 'onnes1108@gmail.com', '15045348574', 'c++', 'male', 'all', '0'),
        ('admin', 'admin', NULL, NULL, NULL, NULL, NULL, '1'),
        ('user', 'user', NULL, NULL, NULL, NULL, NULL, '2');
        ('test', 'test', NULL, NULL, NULL, NULL, NULL, '2');


-- 创建功能表格
DROP TABLE IF EXISTS function_user;
CREATE TABLE function_user (
    function_id   SERIAL PRIMARY KEY,
    function_name VARCHAR(255) NOT NULL,
    count         BIGINT UNSIGNED NOT NULL
);

-- 创建功能
INSERT INTO function_user (function_name, count)
VALUES ('morning', 0), ('afternoon', 0), ('evening', 0);

-- 创建管理员邮件箱，用于接收用户反馈
DROP TABLE IF EXISTS admin_mailbox;
CREATE TABLE admin_mailbox (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    email TEXT NOT NULL,
    time DATE
);

-- 创建触发器，插入时自动添加时间
DROP TRIGGER IF EXISTS admin_mailbox_insert;
DELIMITER //

CREATE TRIGGER admin_mailbox_insert
    BEFORE INSERT ON admin_mailbox
    FOR EACH ROW
BEGIN
    SET NEW.time = NOW();
END //

DELIMITER ;

INSERT INTO admin_mailbox (username, type, email) VALUES
('user', 'problemset', '请加入js语言的支持'),
('user', 'item', '第一个项目我为什么进不去啊'),
('user', 'other', '我想要一个新功能，就是可以在这里发表自己的想法'),
('test', 'other', '你好啊管理员');

-- 用户信箱
DROP TABLE IF EXISTS user_mailbox;
CREATE TABLE user_mailbox (
    id SERIAL PRIMARY KEY,
    username   VARCHAR(255) NOT NULL,
    admin_name VARCHAR(255) NOT NULL,
    content    TEXT NOT NULL,
    time       DATE
);

-- 创建触发器，插入时自动添加时间
DROP TRIGGER IF EXISTS user_mailbox_insert;
DELIMITER //

CREATE TRIGGER user_mailbox_insert
    BEFORE INSERT ON user_mailbox
    FOR EACH ROW
BEGIN
    SET NEW.time = NOW();
END //

DELIMITER ;

INSERT INTO user_mailbox (username, admin_name, content) VALUES ('user', 'admin', '关于这个问题我们会尽快解决请放心');
INSERT INTO user_mailbox (username, admin_name, content) VALUES ('张维桓', 'admin', '关于这个这个功能的开发我们已经提上了日程');

CREATE TABLE IF NOT EXISTS `t_user`(
    `id` INT AUTO_INCREMENT,
    `title` VARCHAR(50) NOT NULL,
    `content` VARCHAR(100) NOT NULL,
    PRIMARY KEY ( `id` )
);
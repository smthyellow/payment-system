CREATE TABLE AuthUserEntity
(
    authUserId bigint PRIMARY KEY AUTO_INCREMENT,
    login varchar(255),
    password varchar(255),
    userId bigint
);
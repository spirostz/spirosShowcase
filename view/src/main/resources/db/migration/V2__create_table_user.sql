CREATE TABLE user
(
    id              bigint       NOT NULL AUTO_INCREMENT,
    first_name      varchar(100) DEFAULT NULL,
    last_name       varchar(100) DEFAULT NULL,
    username        varchar(100) NOT NULL,
    city_id         bigint       DEFAULT NULL,
    create_datetime datetime(6)  DEFAULT NULL,
    update_datetime datetime(6)  DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY UK_username (username),
    KEY             KEY_city_id (city_id),
    CONSTRAINT FK_address_id FOREIGN KEY (city_id) REFERENCES city (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

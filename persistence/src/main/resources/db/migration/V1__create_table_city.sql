CREATE TABLE city
(
    id              bigint       NOT NULL AUTO_INCREMENT,
    name            varchar(100) NOT NULL,
    create_datetime datetime(6) DEFAULT NULL,
    update_datetime datetime(6) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY `UK_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
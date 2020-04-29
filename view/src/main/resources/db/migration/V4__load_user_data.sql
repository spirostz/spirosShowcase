INSERT INTO user (first_name, last_name, username, city_id, create_datetime, update_datetime)
VALUES ('Spiros', 'Tzoras', 'spiros', (select id from city where name = 'Athens'), NOW(), NOW());
INSERT INTO user (first_name, last_name, username, city_id, create_datetime, update_datetime)
VALUES ('Blue', 'Dog', 'blue', (select id from city where name = 'London'), NOW(), NOW());
INSERT INTO user (first_name, last_name, username, city_id, create_datetime, update_datetime)
VALUES ('Red', 'Staff', 'red', (select id from city where name = 'London'), NOW(), NOW());
INSERT INTO user (first_name, last_name, username, city_id, create_datetime, update_datetime)
VALUES ('White', 'Board', 'white', (select id from city where name = 'Berlin'), NOW(), NOW());
INSERT INTO user (first_name, last_name, username, city_id, create_datetime, update_datetime)
VALUES ('Purple', 'Night', 'purple', (select id from city where name = 'Rome'), NOW(), NOW());
INSERT INTO user (first_name, last_name, username, city_id, create_datetime, update_datetime)
VALUES ('Green', 'Forest', 'green', (select id from city where name = 'Athens'), NOW(), NOW());
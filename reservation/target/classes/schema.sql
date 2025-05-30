DROP TABLE if EXISTS ApiUser;
DROP TABLE if EXiSTS user_role;
CREATE TABLE Api_User (
                         id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         first_name VARCHAR(255) NOT NULL,
                         last_name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL UNIQUE,
                         password VARCHAR(255) NOT NULL
);

CREATE TABLE user_role (
                           id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL
);

CREATE TABLE user_roles (
                            id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                            user_id BIGINT NOT NULL,
                            role_id BIGINT NOT NULL,
                            FOREIGN KEY (user_id) REFERENCES Api_User(id) ON DELETE CASCADE,
                            FOREIGN KEY (role_id) REFERENCES user_role(id) ON DELETE CASCADE
);
CREATE TABLE Reservation (
                             id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             title VARCHAR(255),
                             start_time TIMESTAMP,
                             end_time TIMESTAMP,
                                room_id BIGINT
);
CREATE TABLE room (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      number INT NOT NULL,
                      capacity INT NOT NULL
);

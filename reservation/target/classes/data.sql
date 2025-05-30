INSERT INTO Api_User (first_name, last_name, email, password) VALUES
('Jane', 'Doe', 'kowal@g.com', '{MD5}207023ccb44feb4d7dadca005ce29a64'),
('John', 'Smith', 'john@g.com', '{MD5}207023ccb44feb4d7dadca005ce29a64'),
('Jane', 'Smith', 'jane@g.com', '{MD5}207023ccb44feb4d7dadca005ce29a64');

INSERT INTO user_role (name) VALUES
('USER'),
('ADMIN');

INSERT INTO user_roles(user_id, role_id) VALUES
(1, 1),
(2, 2),
(3, 1);
INSERT INTO room (number, capacity) VALUES
(101, 10),
 (102, 8),
(103, 6),
(104, 12),
 (105, 4);


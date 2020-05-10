USE bugtracker;
CREATE TABLE item
(
    item_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(60) NOT NULL,
    description VARCHAR(250),
    status_id INT UNSIGNED,
    FOREIGN KEY(status_id) REFERENCES status(status_id),
    typeId INT UNSIGNED,
    FOREIGN KEY(typeId) REFERENCES type(type_id)
);
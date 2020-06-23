USE bugtracker;
CREATE TABLE item
(
    item_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(60) NOT NULL,
    description VARCHAR(250),
    status_id INT,
    FOREIGN KEY(status_id) REFERENCES status(status_id),
    type_id INT,
    member_id INT,
    FOREIGN KEY(type_id) REFERENCES type(type_id),
    FOREIGN KEY (member_id) REFERENCES team_members(member_id)
);
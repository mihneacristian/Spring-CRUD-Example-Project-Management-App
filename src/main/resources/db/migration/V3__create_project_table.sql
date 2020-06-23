USE bugtracker;
CREATE TABLE project
(
    project_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    description VARCHAR(250),
    status_id INT DEFAULT 1,
    member_id INT,
    FOREIGN KEY(status_id) REFERENCES status(status_id),
    FOREIGN KEY (member_id) REFERENCES team_members(member_id)
);
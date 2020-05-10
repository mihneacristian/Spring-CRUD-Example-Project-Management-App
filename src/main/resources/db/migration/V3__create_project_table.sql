USE bugtracker;
CREATE TABLE project
(
    project_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    short_name VARCHAR(12) NOT NULL,
    description VARCHAR(250),
    status_id INT UNSIGNED,
    FOREIGN KEY(status_id) REFERENCES status(status_id)
);
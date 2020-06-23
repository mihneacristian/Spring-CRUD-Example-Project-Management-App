USE bugtracker;
CREATE TABLE team_members
(
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(60) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    email_address VARCHAR(250) NOT NULL
);
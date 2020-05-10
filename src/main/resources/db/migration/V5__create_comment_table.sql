USE bugtracker;
CREATE TABLE comment
(
    comment_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(3000),
    item_id INT UNSIGNED,
    FOREIGN KEY(item_id) REFERENCES item(item_id)
);
USE bugtracker;
CREATE TABLE comment
(
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(3000),
    item_id INT,
    FOREIGN KEY(item_id) REFERENCES item(item_id)
);